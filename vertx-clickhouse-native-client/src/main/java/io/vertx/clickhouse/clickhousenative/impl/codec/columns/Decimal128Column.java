package io.vertx.clickhouse.clickhousenative.impl.codec.columns;

import io.vertx.clickhouse.clickhousenative.impl.codec.ClickhouseNativeColumnDescriptor;
import io.vertx.clickhouse.clickhousenative.impl.codec.ClickhouseStreamDataSource;
import io.vertx.clickhouse.clickhousenative.impl.codec.Utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

//TODO smagellan: maybe introduce separate universal reader/column for Decimal128 and Decimal256
public class Decimal128Column extends ClickhouseColumn {
  public static final int ELEMENT_SIZE = 16;
  public static final int MAX_PRECISION = 38;
  public static final MathContext MATH_CONTEXT = new MathContext(MAX_PRECISION, RoundingMode.HALF_EVEN);

  protected Decimal128Column(int nRows, ClickhouseNativeColumnDescriptor columnDescriptor) {
    super(nRows, columnDescriptor);
  }

  @Override
  protected Object readItems(ClickhouseStreamDataSource in) {
    if (in.readableBytes() >= ELEMENT_SIZE * nRows) {
      BigDecimal[] data = new BigDecimal[nRows];
      int scale = columnDescriptor.getScale();
      byte[] readBuffer = new byte[ELEMENT_SIZE];
      for (int i = 0; i < nRows; ++i) {
        in.readBytes(readBuffer);
        BigInteger bi = new BigInteger(Utils.reverse(readBuffer));
        data[i] = new BigDecimal(bi, scale, MATH_CONTEXT);
      }
      return data;
    }
    return null;
  }
}