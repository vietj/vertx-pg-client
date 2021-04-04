package io.vertx.clickhouse.clickhousenative.impl.codec.columns;

import io.vertx.clickhouse.clickhousenative.impl.codec.ClickhouseNativeColumnDescriptor;

import java.util.Map;

public class Enum16ColumnReader extends UInt16ColumnReader {
  public static final int ELEMENT_SIZE = 2;
  private final Map<Short, String> enumVals;

  public Enum16ColumnReader(int nRows, ClickhouseNativeColumnDescriptor descr, Map<? extends Number, String> enumVals) {
    super(nRows, descr);
    this.enumVals = (Map<Short, String>) enumVals;
  }

  @Override
  protected Object getElementInternal(int rowIdx, Class<?> desired) {
    Short key = (Short) super.getElementInternal(rowIdx, desired);
    return enumVals.get(key);
  }
}