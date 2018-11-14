/*
 * Copyright (C) 2017 Julien Viet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.reactiverse.pgclient.impl;

import io.reactiverse.pgclient.PgConnection;
import io.reactiverse.pgclient.PgNotification;
import io.reactiverse.pgclient.PgPreparedQuery;
import io.reactiverse.pgclient.PgTransaction;
import io.reactiverse.pgclient.copy.CopyFromOptions;
import io.reactiverse.pgclient.copy.CopyTuple;
import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.streams.Pump;
import io.vertx.core.streams.ReadStream;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class PgConnectionImpl extends PgConnectionBase<PgConnectionImpl> implements PgConnection, Connection.Holder {

  private volatile Handler<Throwable> exceptionHandler;
  private volatile Handler<Void> closeHandler;
  private Transaction tx;
  private volatile Handler<PgNotification> notificationHandler;

  public PgConnectionImpl(Context context, Connection conn) {
    super(context, conn);
  }

  @Override
  public Connection connection() {
    return conn;
  }

  @Override
  public void handleClosed() {
    Handler<Void> handler = closeHandler;
    if (handler != null) {
      context.runOnContext(handler);
    }
  }

  @Override
  public <R> void schedule(CommandBase<R> cmd, Handler<? super CommandResponse<R>> handler) {
    cmd.handler = cr -> {
      // Tx might be gone ???
      cr.scheduler = this;
      handler.handle(cr);
    };
    schedule(cmd);
  }

  protected void schedule(CommandBase<?> cmd) {
    if (context == Vertx.currentContext()) {
      if (tx != null) {
        tx.schedule(cmd);
      } else {
        conn.schedule(cmd);
      }
    } else {
      context.runOnContext(v -> {
        schedule(cmd);
      });
    }
  }

  @Override
  public void handleException(Throwable err) {
    Handler<Throwable> handler = exceptionHandler;
    if (handler != null) {
      context.runOnContext(v -> {
        handler.handle(err);
      });
    } else {
      err.printStackTrace();
    }
  }

  @Override
  public boolean isSSL() {
    return conn.isSsl();
  }

  @Override
  public PgConnection closeHandler(Handler<Void> handler) {
    closeHandler = handler;
    return this;
  }

  @Override
  public PgConnection notificationHandler(Handler<PgNotification> handler) {
    notificationHandler = handler;
    return this;
  }

  @Override
  public PgConnection exceptionHandler(Handler<Throwable> handler) {
    exceptionHandler = handler;
    return this;
  }

  @Override
  public PgTransaction begin() {
    return begin(false);
  }

  PgTransaction begin(boolean closeOnEnd) {
    if (tx != null) {
      throw new IllegalStateException();
    }
    tx = new Transaction(context, conn, v -> {
      tx = null;
      if (closeOnEnd) {
        close();
      }
    });
    return tx;
  }

  public void handleNotification(int processId, String channel, String payload) {
    Handler<PgNotification> handler = notificationHandler;
    if (handler != null) {
      handler.handle(new PgNotification().setProcessId(processId).setChannel(channel).setPayload(payload));
    }
  }

  @Override
  public void close() {
    if (context == Vertx.currentContext()) {
      if (tx != null) {
        tx.rollback(ar -> conn.close(this));
        tx = null;
      } else {
        conn.close(this);
      }
    } else {
      context.runOnContext(v -> close());
    }
  }

  @Override
  public PgConnection copyFrom(String table, ReadStream<CopyTuple> data,
    Handler<AsyncResult<Integer>> handler) {
    return copyFrom(table, Collections.emptyList(), data, handler);
  }

  @Override
  public PgConnection copyFrom(String table, List<String> columns,
    ReadStream<CopyTuple> data, Handler<AsyncResult<Integer>> handler) {
    return pumpCopyData(table, columns, data, new PgBinaryWriteStream(conn), CopyFromOptions.binary(), handler);
  }

  @Override
  public PgConnection copyFrom(String table, ReadStream<Buffer> data, CopyFromOptions options,
    Handler<AsyncResult<Integer>> handler) {
    return copyFrom(table, Collections.emptyList(), data, options, handler);
  }

  @Override
  public PgConnection copyFrom(String table, List<String> columns, ReadStream<Buffer> data,
    CopyFromOptions options, Handler<AsyncResult<Integer>> handler) {
    return pumpCopyData(table, columns, data, new PgTextWriteStream(conn), options, handler);
  }

  private <T> PgConnection pumpCopyData(String table, List<String> columns, ReadStream<T> readStream,
    PgCopyWriteStreamBase<T> writeStream, CopyFromOptions options, Handler<AsyncResult<Integer>> handler) {

    schedule(new CopyInCommand(table, columns, options),
      res -> {
        if (res.failed()) {
          handler.handle(Future.failedFuture(res.cause()));
        } else {
          writeStream.exceptionHandler(exp -> handler.handle(Future.failedFuture(exp)));
          writeStream.endHandler(c -> handler.handle(Future.succeededFuture(c)));
          writeStream.writeHeader();
          Pump pump = Pump.pump(readStream, writeStream);
          readStream.endHandler(end -> {
            writeStream.end();
            pump.stop();
          });
          pump.start();
        }
      });
    return this;
  }
}
