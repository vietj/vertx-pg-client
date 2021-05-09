/*
 *
 *  Copyright (c) 2021 Vladimir Vishnevskii
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 *  which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *
 */

package io.vertx.clickhousenativeclient.alltypes;

import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.Tuple;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(VertxUnitRunner.class)
public class UInt8Test extends AllTypesBase<Short> {
  public UInt8Test() {
    super("uint8", new MyColumnChecker<>(Short.class, Tuple::getShort, Row::getShort, Tuple::getArrayOfShorts, Row::getArrayOfShorts));
  }

  @Override
  public List<Tuple> createBatch() {
    Short v1 = 10;
    Short v2 = 20;
    Short v3 = 30;
    Short v4 = 40;
    Short v5 = 60;
    Short v6 = 70;
    Short nv = 0;
    Short mn = 0;
    Short mx = 255;

    return Arrays.asList(
      //            id    simple_t    nullable_t   array_t                                           array3_t                                                                                                                nullable_array_t                                        nullable_array3_t                                                                                        simple_lc_t  nullable_lc_t   array_lc_t                                        array3_lc_t                                                                                                      nullable_array_lc_t                                      nullable_array3_lc_t
      Tuple.of((byte)1,        mn,      mn,        new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mn, mn},                                   new Short[][][]{{{mn, null, mn}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},           mn,        mn,      new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mn, mn},                                    new Short[][][]{{{mn, null, mn}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}            ),
      Tuple.of((byte)2,        mn,      mn,        new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mn, mn},                                   new Short[][][]{{{mn, null, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},     mn,        mn,      new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mn, mn},                                    new Short[][][]{{{mn, null, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}      ),
      Tuple.of((byte)3,        mn,      mn,        new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mn, null, mn},                             new Short[][][]{{{mn, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},           mn,        mn,      new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mn, null, mn},                              new Short[][][]{{{mn, mn, null}, {mn, mn, null}, {null}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}            ),
      Tuple.of((byte)4,        mn,      mn,        new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mn, null, mn},                             new Short[][][]{{{mn, null, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},                     mn,        mn,      new Short[]{mn, mn},                             new Short[][][]{{{mn, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mn, null, mn},                              new Short[][][]{{{mn, null, mn}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}                      ),
      Tuple.of((byte)5,        mx,      mx,        new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mx, mx},                                   new Short[][][]{{{mx, null, mx}, {mx, mx, null}, {}}, {{mn, mn}, {mn, null, mn}, {}}, {{}, {null}, {}}},         mx,        mx,      new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mx, null, mx},                              new Short[][][]{{{mx, null, mx}, {mx, mx, null}, {}}, {{mn, mn}, {mn, null, mn}, {}}, {{}, {null}, {}}}          ),
      Tuple.of((byte)6,        mn,      mn,        new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mx, mx},                                   new Short[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{null}, {}, {}}},                     mn,        mn,      new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mx, null, mx},                              new Short[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{null}, {}, {}}}                      ),
      Tuple.of((byte)7,        mx,      mx,        new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mx, null, mx},                             new Short[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         mx,        mx,      new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mx, null, mx},                              new Short[][][]{{{mx, mx}, {mx, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                          ),
      Tuple.of((byte)8,        mn,      mn,        new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mx, null, mx},                             new Short[][][]{{{mx, mx}, {mx, null, mx, null}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}},               mn,        mn,      new Short[]{mx, mx},                             new Short[][][]{{{mx, mx}, {mx, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mx, null, mx},                              new Short[][][]{{{mx, mx}, {mx, null, mx, null}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {null}, {}}}                ),
      Tuple.of((byte)9,        mx,      mx,        new Short[]{mn, mx},                             new Short[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mn, null, mx},                             new Short[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                   mx,        mx,      new Short[]{mn, mx},                             new Short[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mn, null, mx},                              new Short[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                    ),
      Tuple.of((byte)10,       mn,      mn,        new Short[]{mn, mx},                             new Short[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{mn, null, mx},                             new Short[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                   mn,        mn,      new Short[]{mn, mx},                             new Short[][][]{{{mn, mx}, {mn, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{mn, null, mx},                              new Short[][][]{{{mn, mx, null}, {mn, null, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                    ),
      Tuple.of((byte)11,       v2,      v3,        new Short[]{},                                   new Short[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                                 new Short[]{},                                         new Short[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}},                                                       v2,        v3,      new Short[]{},                                   new Short[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                          new Short[]{},                                          new Short[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}}                                                        ),
      Tuple.of((byte)12,       v2,      v3,        new Short[]{},                                   new Short[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                                 new Short[]{},                                         new Short[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}},                                                       v2,        v3,      new Short[]{},                                   new Short[][][]{{{}, {}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                          new Short[]{},                                          new Short[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}}                                                        ),
      Tuple.of((byte)13,       v2,      v3,        new Short[]{},                                   new Short[][][]{{{}}},                                                                                                 new Short[]{},                                         new Short[][][]{{{}}},                                                                                           v2,        v3,      new Short[]{},                                   new Short[][][]{{{}}},                                                                                          new Short[]{},                                          new Short[][][]{{{}}}                                                                                            ),
      Tuple.of((byte)14,       v2,      v3,        new Short[]{},                                   new Short[][][]{{{}}},                                                                                                 new Short[]{},                                         new Short[][][]{{{}}},                                                                                           v2,        v3,      new Short[]{},                                   new Short[][][]{{{}}},                                                                                          new Short[]{},                                          new Short[][][]{{{}}}                                                                                            ),
      Tuple.of((byte)15,       v2,      v3,        new Short[]{},                                   new Short[][][]{{{}}},                                                                                                 new Short[]{null},                                     new Short[][][]{{{null}}},                                                                                       v2,        v3,      new Short[]{},                                   new Short[][][]{{{}}},                                                                                          new Short[]{null},                                      new Short[][][]{{{null}}}                                                                                        ),
      Tuple.of((byte)16,       v2,      v3,        new Short[]{},                                   new Short[][][]{{{}}},                                                                                                 new Short[]{null},                                     new Short[][][]{{{null}}},                                                                                       v2,        v3,      new Short[]{},                                   new Short[][][]{{{}}},                                                                                          new Short[]{null},                                      new Short[][][]{{{null}}}                                                                                        ),
      Tuple.of((byte)17,       v2,      v3,        new Short[]{nv},                                 new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{nv},                                       new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                               v2,        v3,      new Short[]{nv},                                 new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{nv},                                        new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                                ),
      Tuple.of((byte)18,       v2,      v3,        new Short[]{nv},                                 new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                                     new Short[]{nv},                                       new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                               v2,        v3,      new Short[]{nv},                                 new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                              new Short[]{nv},                                        new Short[][][]{{{nv, nv}, {nv, nv}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}                                ),
      Tuple.of((byte)19,       v2,      v3,        new Short[]{nv, mn, mx},                         new Short[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         new Short[]{nv, mn, null, mx},                         new Short[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}},       v2,        v3,      new Short[]{nv, mn, mx},                         new Short[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                  new Short[]{nv},                                        new Short[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}}        ),
      Tuple.of((byte)20,       v2,      v3,        new Short[]{nv, mn, mx},                         new Short[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                         new Short[]{nv, mn, null, mx},                         new Short[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}},       v2,        v3,      new Short[]{nv, mn, mx},                         new Short[][][]{{{v2, nv, mn}, {v3, mn, nv, mx}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},                  new Short[]{nv},                                        new Short[][][]{{{v2, nv, mn, null}, {v3, mn, nv, mx}, {}}, {{mn, mn, null}, {mn, mn}, {}}, {{}, {}, {}}}        ),
      Tuple.of((byte)21,       v2,      v3,        new Short[]{nv, mn, mx},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{nv, mn, null, mx},                         new Short[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v2,        v3,      new Short[]{nv, mn, mx},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{nv, mn, null, mx},                          new Short[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)22,       v2,      v3,        new Short[]{nv, mn, mx},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{nv, mn, null, mx},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, null, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v2,        v3,      new Short[]{nv, mn, mx},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{nv, mn, null, mx},                          new Short[][][]{{{nv, mn, mx, v1, v2, v3, null, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)23, nv,    null,        new Short[]{v3, v1, nv, mx, v4},                 new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{v3, v1, null, nv, mx, v3},                 new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5, null}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,      null,      new Short[]{v3, v1, nv, mx, v4},                 new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{nv, v2, null, v3, v2},                       new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5, null}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}} ),
      Tuple.of((byte)24, nv,    null,        new Short[]{v3, v1, nv, mx, v4},                 new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{v3, v1, null, nv, mx, v3},                 new Short[][][]{{{nv, mn, mx, null, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,      null,      new Short[]{v3, v1, nv, mx, v4},                 new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{nv, v2, null, v3, v2},                       new Short[][][]{{{nv, mn, mx, null, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}} ),
      Tuple.of((byte)25,       v1,      v1,        new Short[]{v1, nv, nv},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{v3, nv, null},                             new Short[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v1,        v1,      new Short[]{v1, nv, nv},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{v2, nv, null},                              new Short[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)26,       nv,      nv,        new Short[]{nv, nv, nv},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{nv, null, v4},                             new Short[][][]{{{nv, null, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, nv,        nv,      new Short[]{nv, nv, nv},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{nv, null, nv},                              new Short[][][]{{{nv, null, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)27,       v6,      v5,        new Short[]{v4, nv, nv},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{v3, nv, null},                             new Short[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new Short[]{v4, nv, nv},                         new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{v2, nv, null},                              new Short[][][]{{{nv, mn, null, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)28,       v6,      v5,        new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null}, new Short[][][]{{{nv, mn, mx, v1, null, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null},  new Short[][][]{{{nv, mn, mx, v1, null, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  ),
      Tuple.of((byte)29,       v6,      v5,        new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},             new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null}, new Short[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}, v6,        v5,      new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6}, new Short[][][]{{{nv, mn, mx, v1, v2, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}},      new Short[]{v1, nv, mn, mx, v2, v3, v4, v5, v6, null},  new Short[][][]{{{nv, mn, mx, v1, v2, null, v3, v4, v5}, {mn, mn}, {}}, {{mn, mn}, {mn, mn}, {}}, {{}, {}, {}}}  )
    );
  }
}