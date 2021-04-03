package io.vertx.clickhousenativeclient.alltypes;

import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.Tuple;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(VertxUnitRunner.class)
public class Float64Test extends AllTypesBase<Double> {
  public Float64Test() {
    super("float64", new MyColumnChecker<>(Double.class, Tuple::getDouble, Row::getDouble, Tuple::getArrayOfDoubles, Row::getArrayOfDoubles));
  }

  @Override
  public List<Tuple> createBatch() {
    Double v1 = Double.MAX_VALUE / 2;
    Double v2 = Double.MIN_VALUE / 2;
    Double v3 = 30.0;
    Double v4 = -40.0;
    Double v5 = 60.0;
    Double v6 = -70.0;
    Double nv = 0.0;
    Double mn = Double.MIN_VALUE;
    Double mx = Double.MAX_VALUE;

    return Arrays.asList(
      //            id    simple_t    nullable_t   array_t                                           array3_t                                                                                                                nullable_array_t                                        nullable_array3_t                                                                                        simple_lc_t  nullable_lc_t   array_lc_t                                        array3_lc_t                                                                                                      nullable_array_lc_t                                      nullable_array3_lc_t
      Tuple.of((byte)1,        mn,      mn,        new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mn, mn},                                   new Double[][][]{{{mn, null, mn}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},           mn,        mn,      new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mn, mn},                                    new Double[][][]{{{mn, null, mn}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}            ),
      Tuple.of((byte)2,        mn,      mn,        new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mn, mn},                                   new Double[][][]{{{mn, null, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},     mn,        mn,      new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mn, mn},                                    new Double[][][]{{{mn, null, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}      ),
      Tuple.of((byte)3,        mn,      mn,        new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mn, null, mn},                             new Double[][][]{{{mn, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},           mn,        mn,      new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mn, null, mn},                              new Double[][][]{{{mn, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}            ),
      Tuple.of((byte)4,        mn,      mn,        new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mn, null, mn},                             new Double[][][]{{{mn, null, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},                     mn,        mn,      new Double[]{mn, mn},                             new Double[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mn, null, mn},                              new Double[][][]{{{mn, null, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}                      ),
      Tuple.of((byte)5,        mx,      mx,        new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mx, mx},                                   new Double[][][]{{{mx, null, mx}, {mx, mx, null}, {}}, {{mn, mn}, {mn, null, mn}, {}}, {{}, {null}, {}}},         mx,        mx,      new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mx, null, mx},                              new Double[][][]{{{mx, null, mx}, {mx, mx, null}, {}}, {{mn, mn}, {mn, null, mn}, {}}, {{}, {null}, {}}}          ),
      Tuple.of((byte)6,        mn,      mn,        new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mx, mx},                                   new Double[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{null}, {}, {}}},                     mn,        mn,      new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mx, null, mx},                              new Double[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{null}, {}, {}}}                      ),
      Tuple.of((byte)7,        mx,      mx,        new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mx, null, mx},                             new Double[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         mx,        mx,      new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mx, null, mx},                              new Double[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                          ),
      Tuple.of((byte)8,        mn,      mn,        new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mx, null, mx},                             new Double[][][]{{{mx, mx}, {mx, null, mx, null}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},               mn,        mn,      new Double[]{mx, mx},                             new Double[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mx, null, mx},                              new Double[][][]{{{mx, mx}, {mx, null, mx, null}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}                ),
      Tuple.of((byte)9,        mx,      mx,        new Double[]{mn, mx},                             new Double[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mn, null, mx},                             new Double[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                   mx,        mx,      new Double[]{mn, mx},                             new Double[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mn, null, mx},                              new Double[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                    ),
      Tuple.of((byte)10,       mn,      mn,        new Double[]{mn, mx},                             new Double[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{mn, null, mx},                             new Double[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                   mn,        mn,      new Double[]{mn, mx},                             new Double[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{mn, null, mx},                              new Double[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                    ),
      Tuple.of((byte)11,       v2,      v3,        new Double[]{},                                   new Double[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                                 new Double[]{},                                         new Double[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}},                                                       v2,        v3,      new Double[]{},                                   new Double[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                          new Double[]{},                                          new Double[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}}                                                        ),
      Tuple.of((byte)12,       v2,      v3,        new Double[]{},                                   new Double[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                                 new Double[]{},                                         new Double[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}},                                                       v2,        v3,      new Double[]{},                                   new Double[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                          new Double[]{},                                          new Double[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}}                                                        ),
      Tuple.of((byte)13,       v2,      v3,        new Double[]{},                                   new Double[][][]{{{}}},                                                                                                 new Double[]{},                                         new Double[][][]{{{}}},                                                                                           v2,        v3,      new Double[]{},                                   new Double[][][]{{{}}},                                                                                          new Double[]{},                                          new Double[][][]{{{}}}                                                                                            ),
      Tuple.of((byte)14,       v2,      v3,        new Double[]{},                                   new Double[][][]{{{}}},                                                                                                 new Double[]{},                                         new Double[][][]{{{}}},                                                                                           v2,        v3,      new Double[]{},                                   new Double[][][]{{{}}},                                                                                          new Double[]{},                                          new Double[][][]{{{}}}                                                                                            ),
      Tuple.of((byte)15,       v2,      v3,        new Double[]{},                                   new Double[][][]{{{}}},                                                                                                 new Double[]{null},                                     new Double[][][]{{{null}}},                                                                                       v2,        v3,      new Double[]{},                                   new Double[][][]{{{}}},                                                                                          new Double[]{null},                                      new Double[][][]{{{null}}}                                                                                            ),
      Tuple.of((byte)16,       v2,      v3,        new Double[]{},                                   new Double[][][]{{{}}},                                                                                                 new Double[]{null},                                     new Double[][][]{{{null}}},                                                                                       v2,        v3,      new Double[]{},                                   new Double[][][]{{{}}},                                                                                          new Double[]{null},                                      new Double[][][]{{{null}}}                                                                                            ),
      Tuple.of((byte)17,       v2,      v3,        new Double[]{nv},                                 new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{nv},                                       new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                               v2,        v3,      new Double[]{nv},                                 new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{nv},                                        new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                                ),
      Tuple.of((byte)18,       v2,      v3,        new Double[]{nv},                                 new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Double[]{nv},                                       new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                               v2,        v3,      new Double[]{nv},                                 new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Double[]{nv},                                        new Double[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                                ),
      Tuple.of((byte)19,       v2,      v3,        new Double[]{nv, mn, mx},                         new Double[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         new Double[]{nv, mn, null, mx},                         new Double[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}},       v2,        v3,      new Double[]{nv, mn, mx},                         new Double[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                  new Double[]{nv},                                        new Double[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}}        ),
      Tuple.of((byte)20,       v2,      v3,        new Double[]{nv, mn, mx},                         new Double[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         new Double[]{nv, mn, null, mx},                         new Double[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}},       v2,        v3,      new Double[]{nv, mn, mx},                         new Double[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                  new Double[]{nv},                                        new Double[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}}        ),
      Tuple.of((byte)21,       v2,      v3,        new Double[]{nv, mn, mx},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{nv, mn, null, mx},                         new Double[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v2,        v3,      new Double[]{nv, mn, mx},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{nv, mn, null, mx},                          new Double[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)22,       v2,      v3,        new Double[]{nv, mn, mx},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{nv, mn, null, mx},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, null, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v2,        v3,      new Double[]{nv, mn, mx},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{nv, mn, null, mx},                          new Double[][][]{{{nv, mn, mx, v1, v2, v3, null, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)23, nv,    null,        new Double[]{v3, v1, nv, mx, v4},                 new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{v3, v1, null, nv, mx, v3},                 new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5, null}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,      null,      new Double[]{v3, v1, nv, mx, v4},                 new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{nv, v2, null, v3, v2},                       new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5, null}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}} ),
      Tuple.of((byte)24, nv,    null,        new Double[]{v3, v1, nv, mx, v4},                 new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{v3, v1, null, nv, mx, v3},                 new Double[][][]{{{nv, mn, mx, null, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,      null,      new Double[]{v3, v1, nv, mx, v4},                 new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{nv, v2, null, v3, v2},                       new Double[][][]{{{nv, mn, mx, null, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}} ),
      Tuple.of((byte)25,       v1,      v1,        new Double[]{v1, nv, nv},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{v3, nv, null},                             new Double[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v1,        v1,      new Double[]{v1, nv, nv},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{v2, nv, null},                              new Double[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)26,       nv,      nv,        new Double[]{nv, nv, nv},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{nv, null, v4},                             new Double[][][]{{{nv, null, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,        nv,      new Double[]{nv, nv, nv},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{nv, null, nv},                              new Double[][][]{{{nv, null, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)27,       v6,      v5,        new Double[]{v4, nv, nv},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{v3, nv, null},                             new Double[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new Double[]{v4, nv, nv},                         new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{v2, nv, null},                              new Double[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)28,       v6,      v5,        new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null}, new Double[][][]{{{nv, mn, mx, v1, null, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null},  new Double[][][]{{{nv, mn, mx, v1, null, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)29,       v6,      v5,        new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null}, new Double[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Double[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Double[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null},  new Double[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  )
    );
  }
}
