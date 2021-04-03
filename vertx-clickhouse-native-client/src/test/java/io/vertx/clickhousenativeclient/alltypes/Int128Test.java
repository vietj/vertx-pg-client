package io.vertx.clickhousenativeclient.alltypes;

import io.vertx.clickhouse.clickhousenative.impl.codec.columns.Int128Column;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.sqlclient.Tuple;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


@RunWith(VertxUnitRunner.class)
public class Int128Test extends AllTypesBase<BigInteger> {
  public Int128Test() {
    super("int128", new MyColumnChecker<>(BigInteger.class, null, null, null, null));
  }

  @Ignore
  @Test
  public void testEmptyData(TestContext ctx) {
    //experimental support at the moment
  }

  @Ignore
  @Test
  public void testData(TestContext ctx) {
    //experimental support at the moment
  }

  @Override
  public List<Tuple> createBatch() {
    BigInteger v1 = BigInteger.valueOf(Long.MAX_VALUE);
    BigInteger v2 = BigInteger.valueOf(Long.MIN_VALUE);
    BigInteger v3 = BigInteger.valueOf(Integer.MAX_VALUE);
    BigInteger v4 = BigInteger.valueOf(Integer.MIN_VALUE);
    BigInteger v5 = BigInteger.valueOf(Long.MAX_VALUE / 2);
    BigInteger v6 = BigInteger.valueOf(Long.MIN_VALUE / 2);
    BigInteger nv = Int128Column.ZERO_VALUE;
    BigInteger mn = Int128Column.INT128_MIN_VALUE;
    BigInteger mx = Int128Column.INT128_MAX_VALUE;

    return Arrays.asList(
      //            id    simple_t    nullable_t   array_t                                           array3_t                                                                                                                nullable_array_t                                        nullable_array3_t                                                                                        simple_lc_t  nullable_lc_t   array_lc_t                                        array3_lc_t                                                                                                      nullable_array_lc_t                                      nullable_array3_lc_t
      Tuple.of((byte)1,        mn,      mn,        new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mn, mn},                                   new BigInteger[][][]{{{mn, null, mn}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},           mn,        mn,      new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mn, mn},                                    new BigInteger[][][]{{{mn, null, mn}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}            ),
      Tuple.of((byte)2,        mn,      mn,        new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mn, mn},                                   new BigInteger[][][]{{{mn, null, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},     mn,        mn,      new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mn, mn},                                    new BigInteger[][][]{{{mn, null, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}      ),
      Tuple.of((byte)3,        mn,      mn,        new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mn, null, mn},                             new BigInteger[][][]{{{mn, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},           mn,        mn,      new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mn, null, mn},                              new BigInteger[][][]{{{mn, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}            ),
      Tuple.of((byte)4,        mn,      mn,        new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mn, null, mn},                             new BigInteger[][][]{{{mn, null, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},                     mn,        mn,      new BigInteger[]{mn, mn},                             new BigInteger[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mn, null, mn},                              new BigInteger[][][]{{{mn, null, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}                      ),
      Tuple.of((byte)5,        mx,      mx,        new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mx, mx},                                   new BigInteger[][][]{{{mx, null, mx}, {mx, mx, null}, {}}, {{mn, mn}, {mn, null, mn}, {}}, {{}, {null}, {}}},         mx,        mx,      new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mx, null, mx},                              new BigInteger[][][]{{{mx, null, mx}, {mx, mx, null}, {}}, {{mn, mn}, {mn, null, mn}, {}}, {{}, {null}, {}}}          ),
      Tuple.of((byte)6,        mn,      mn,        new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mx, mx},                                   new BigInteger[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{null}, {}, {}}},                     mn,        mn,      new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mx, null, mx},                              new BigInteger[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{null}, {}, {}}}                      ),
      Tuple.of((byte)7,        mx,      mx,        new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mx, null, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         mx,        mx,      new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mx, null, mx},                              new BigInteger[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                          ),
      Tuple.of((byte)8,        mn,      mn,        new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mx, null, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, null, mx, null}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},               mn,        mn,      new BigInteger[]{mx, mx},                             new BigInteger[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mx, null, mx},                              new BigInteger[][][]{{{mx, mx}, {mx, null, mx, null}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}                ),
      Tuple.of((byte)9,        mx,      mx,        new BigInteger[]{mn, mx},                             new BigInteger[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mn, null, mx},                             new BigInteger[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                   mx,        mx,      new BigInteger[]{mn, mx},                             new BigInteger[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mn, null, mx},                              new BigInteger[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                    ),
      Tuple.of((byte)10,       mn,      mn,        new BigInteger[]{mn, mx},                             new BigInteger[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{mn, null, mx},                             new BigInteger[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                   mn,        mn,      new BigInteger[]{mn, mx},                             new BigInteger[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{mn, null, mx},                              new BigInteger[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                    ),
      Tuple.of((byte)11,       v2,      v3,        new BigInteger[]{},                                   new BigInteger[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                                 new BigInteger[]{},                                         new BigInteger[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}},                                                       v2,        v3,      new BigInteger[]{},                                   new BigInteger[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                          new BigInteger[]{},                                          new BigInteger[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}}                                                        ),
      Tuple.of((byte)12,       v2,      v3,        new BigInteger[]{},                                   new BigInteger[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                                 new BigInteger[]{},                                         new BigInteger[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}},                                                       v2,        v3,      new BigInteger[]{},                                   new BigInteger[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                          new BigInteger[]{},                                          new BigInteger[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}}                                                        ),
      Tuple.of((byte)13,       v2,      v3,        new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                                 new BigInteger[]{},                                         new BigInteger[][][]{{{}}},                                                                                           v2,        v3,      new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                          new BigInteger[]{},                                          new BigInteger[][][]{{{}}}                                                                                            ),
      Tuple.of((byte)14,       v2,      v3,        new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                                 new BigInteger[]{},                                         new BigInteger[][][]{{{}}},                                                                                           v2,        v3,      new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                          new BigInteger[]{},                                          new BigInteger[][][]{{{}}}                                                                                            ),
      Tuple.of((byte)15,       v2,      v3,        new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                                 new BigInteger[]{null},                                     new BigInteger[][][]{{{null}}},                                                                                       v2,        v3,      new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                          new BigInteger[]{null},                                      new BigInteger[][][]{{{null}}}                                                                                            ),
      Tuple.of((byte)16,       v2,      v3,        new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                                 new BigInteger[]{null},                                     new BigInteger[][][]{{{null}}},                                                                                       v2,        v3,      new BigInteger[]{},                                   new BigInteger[][][]{{{}}},                                                                                          new BigInteger[]{null},                                      new BigInteger[][][]{{{null}}}                                                                                            ),
      Tuple.of((byte)17,       v2,      v3,        new BigInteger[]{nv},                                 new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{nv},                                       new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                               v2,        v3,      new BigInteger[]{nv},                                 new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{nv},                                        new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                                ),
      Tuple.of((byte)18,       v2,      v3,        new BigInteger[]{nv},                                 new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new BigInteger[]{nv},                                       new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                               v2,        v3,      new BigInteger[]{nv},                                 new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new BigInteger[]{nv},                                        new BigInteger[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                                ),
      Tuple.of((byte)19,       v2,      v3,        new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         new BigInteger[]{nv, mn, null, mx},                         new BigInteger[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}},       v2,        v3,      new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                  new BigInteger[]{nv},                                        new BigInteger[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}}        ),
      Tuple.of((byte)20,       v2,      v3,        new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         new BigInteger[]{nv, mn, null, mx},                         new BigInteger[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}},       v2,        v3,      new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                  new BigInteger[]{nv},                                        new BigInteger[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}}        ),
      Tuple.of((byte)21,       v2,      v3,        new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{nv, mn, null, mx},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v2,        v3,      new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{nv, mn, null, mx},                          new BigInteger[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)22,       v2,      v3,        new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{nv, mn, null, mx},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, null, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v2,        v3,      new BigInteger[]{nv, mn, mx},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{nv, mn, null, mx},                          new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, null, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)23, nv,    null,        new BigInteger[]{v3, v1, nv, mx, v4},                 new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{v3, v1, null, nv, mx, v3},                 new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5, null}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,      null,      new BigInteger[]{v3, v1, nv, mx, v4},                 new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{nv, v2, null, v3, v2},                       new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5, null}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}} ),
      Tuple.of((byte)24, nv,    null,        new BigInteger[]{v3, v1, nv, mx, v4},                 new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{v3, v1, null, nv, mx, v3},                 new BigInteger[][][]{{{nv, mn, mx, null, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,      null,      new BigInteger[]{v3, v1, nv, mx, v4},                 new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{nv, v2, null, v3, v2},                       new BigInteger[][][]{{{nv, mn, mx, null, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}} ),
      Tuple.of((byte)25,       v1,      v1,        new BigInteger[]{v1, nv, nv},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{v3, nv, null},                             new BigInteger[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v1,        v1,      new BigInteger[]{v1, nv, nv},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{v2, nv, null},                              new BigInteger[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)26,       nv,      nv,        new BigInteger[]{nv, nv, nv},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{nv, null, v4},                             new BigInteger[][][]{{{nv, null, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,        nv,      new BigInteger[]{nv, nv, nv},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{nv, null, nv},                              new BigInteger[][][]{{{nv, null, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)27,       v6,      v5,        new BigInteger[]{v4, nv, nv},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{v3, nv, null},                             new BigInteger[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new BigInteger[]{v4, nv, nv},                         new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{v2, nv, null},                              new BigInteger[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)28,       v6,      v5,        new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null}, new BigInteger[][][]{{{nv, mn, mx, v1, null, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null},  new BigInteger[][][]{{{nv, mn, mx, v1, null, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)29,       v6,      v5,        new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null}, new BigInteger[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new BigInteger[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new BigInteger[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null},  new BigInteger[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  )
    );
  }
}
