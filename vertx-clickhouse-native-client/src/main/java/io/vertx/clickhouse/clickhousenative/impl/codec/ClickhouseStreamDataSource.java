package io.vertx.clickhouse.clickhousenative.impl.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public interface ClickhouseStreamDataSource {
  Logger LOG = LoggerFactory.getLogger(ClickhouseStreamDataSource.class);

  void moreData(ByteBuf buf, ByteBufAllocator ctx);
  int readableBytes();
  void skipBytes(int length);
  String readPascalString();
  Integer readULeb128();
  boolean readBoolean();
  int readIntLE();
  long readLongLE();
  short readShortLE();
  float readFloatLE();
  double readDoubleLE();
  ByteBuf readSlice(int nBytes);
  void readBytes(byte[] dst);
  byte readByte();
  String hexdump();
  void finish();
}
