/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */

package io.vertx.pgclient;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import org.junit.Test;

public class PreparedStatementNameTest extends PgTestBase {
  @Test
  public void testNameOverflow(TestContext ctx) {
    PgConnection.connect(Vertx.vertx(), rule.options(), ctx.asyncAssertSuccess(conn -> {
      conn.prepare("SELECT 1", ctx.asyncAssertSuccess(ps1 -> {
        for (int i=1; i<=0x10000; i++) {
          conn.prepare("SELECT 2", ctx.asyncAssertSuccess(ps2 -> {
            ps2.query().execute(ctx.asyncAssertSuccess(done -> ps2.close()));
          }));
        }
      }));
    }));
  }
}
