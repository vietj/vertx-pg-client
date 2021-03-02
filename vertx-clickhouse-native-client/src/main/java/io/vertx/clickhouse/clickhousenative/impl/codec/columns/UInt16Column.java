package io.vertx.clickhouse.clickhousenative.impl.codec.columns;

import io.netty.buffer.ByteBuf;
import io.vertx.clickhouse.clickhousenative.impl.codec.ClickhouseNativeColumnDescriptor;

public class UInt16Column extends ClickhouseColumn {
  public static final int ELEMENT_SIZE = 2;

  public UInt16Column(int nRows, ClickhouseNativeColumnDescriptor columnDescriptor) {
    super(nRows, columnDescriptor);
  }

  @Override
  protected Object readItems(ByteBuf in) {
    if (in.readableBytes() >= ELEMENT_SIZE * nRows) {
      short[] data = new short[nRows];
      for (int i = 0; i < nRows; ++i) {
        data[i] = in.readShortLE();
      }
      return data;
    }
    return null;
  }

  @Override
  protected Object getElementInternal(int rowIdx) {
    short element = ((short[])this.itemsArray)[rowIdx];
    if (columnDescriptor.isUnsigned()) {
      return Short.toUnsignedInt(element);
    }
    return element;
  }
}