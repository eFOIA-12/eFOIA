package com.google.android.gms.internal;

import com.google.android.gms.internal.qm;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ql {
   private static int a(String var0, qm.a[] var1) {
      int var5 = var1.length;
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 14; var2 < var5; var3 = var4) {
         qm.a var6 = var1[var2];
         if(var3 == 14) {
            if(var6.type != 9 && var6.type != 2 && var6.type != 6) {
               var4 = var3;
               if(var6.type != 14) {
                  throw new IllegalArgumentException("Unexpected TypedValue type: " + var6.type + " for key " + var0);
               }
            } else {
               var4 = var6.type;
            }
         } else {
            var4 = var3;
            if(var6.type != var3) {
               throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + var0 + " contains items of type " + var3 + " and " + var6.type);
            }
         }

         ++var2;
      }

      return var3;
   }

   static int a(List var0, Asset var1) {
      var0.add(var1);
      return var0.size() - 1;
   }

   public static ql.a a(DataMap var0) {
      qm var1 = new qm();
      ArrayList var2 = new ArrayList();
      var1.ayq = a((DataMap)var0, (List)var2);
      return new ql.a(var1, var2);
   }

   private static qm.a a(List var0, Object var1) {
      qm.a var6 = new qm.a();
      if(var1 == null) {
         var6.type = 14;
         return var6;
      } else {
         var6.ayu = new qm.a();
         if(var1 instanceof String) {
            var6.type = 2;
            var6.ayu.ayw = (String)var1;
         } else if(var1 instanceof Integer) {
            var6.type = 6;
            var6.ayu.ayA = ((Integer)var1).intValue();
         } else if(var1 instanceof Long) {
            var6.type = 5;
            var6.ayu.ayz = ((Long)var1).longValue();
         } else if(var1 instanceof Double) {
            var6.type = 3;
            var6.ayu.ayx = ((Double)var1).doubleValue();
         } else if(var1 instanceof Float) {
            var6.type = 4;
            var6.ayu.ayy = ((Float)var1).floatValue();
         } else if(var1 instanceof Boolean) {
            var6.type = 8;
            var6.ayu.ayC = ((Boolean)var1).booleanValue();
         } else if(var1 instanceof Byte) {
            var6.type = 7;
            var6.ayu.ayB = ((Byte)var1).byteValue();
         } else if(var1 instanceof byte[]) {
            var6.type = 1;
            var6.ayu.ayv = (byte[])((byte[])var1);
         } else if(var1 instanceof String[]) {
            var6.type = 11;
            var6.ayu.ayF = (String[])((String[])var1);
         } else if(var1 instanceof long[]) {
            var6.type = 12;
            var6.ayu.ayG = (long[])((long[])var1);
         } else if(var1 instanceof float[]) {
            var6.type = 15;
            var6.ayu.ayH = (float[])((float[])var1);
         } else if(var1 instanceof Asset) {
            var6.type = 13;
            var6.ayu.ayI = (long)a(var0, (Asset)var1);
         } else {
            int var2;
            if(var1 instanceof DataMap) {
               var6.type = 9;
               DataMap var10 = (DataMap)var1;
               Set var7 = var10.keySet();
               qm.a[] var5 = new qm.a[var7.size()];
               Iterator var12 = var7.iterator();

               for(var2 = 0; var12.hasNext(); ++var2) {
                  String var8 = (String)var12.next();
                  var5[var2] = new qm.a();
                  var5[var2].name = var8;
                  var5[var2].ays = a(var0, var10.get(var8));
               }

               var6.ayu.ayD = var5;
            } else {
               if(!(var1 instanceof ArrayList)) {
                  throw new RuntimeException("newFieldValueFromValue: unexpected value " + var1.getClass().getSimpleName());
               }

               var6.type = 10;
               ArrayList var13 = (ArrayList)var1;
               qm.a[] var14 = new qm.a[var13.size()];
               var1 = null;
               int var4 = var13.size();
               int var3 = 0;

               for(var2 = 14; var3 < var4; ++var3) {
                  Object var11 = var13.get(var3);
                  qm.a var9 = a(var0, var11);
                  if(var9.type != 14 && var9.type != 2 && var9.type != 6 && var9.type != 9) {
                     throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + var11.getClass());
                  }

                  if(var2 == 14 && var9.type != 14) {
                     var2 = var9.type;
                     var1 = var11;
                  } else if(var9.type != var2) {
                     throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + var1.getClass() + " and a " + var11.getClass());
                  }

                  var14[var3] = var9;
               }

               var6.ayu.ayE = var14;
            }
         }

         return var6;
      }
   }

   public static DataMap a(ql.a var0) {
      DataMap var3 = new DataMap();
      qm.a[] var4 = var0.ayo.ayq;
      int var2 = var4.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         qm.a var5 = var4[var1];
         a(var0.ayp, var3, var5.name, var5.ays);
      }

      return var3;
   }

   private static ArrayList a(List var0, qm.a var1, int var2) {
      ArrayList var7 = new ArrayList(var1.ayE.length);
      qm.a[] var11 = var1.ayE;
      int var5 = var11.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         qm.a var9 = var11[var3];
         if(var9.type == 14) {
            var7.add((Object)null);
         } else if(var2 == 9) {
            DataMap var8 = new DataMap();
            qm.a[] var12 = var9.ayu.ayD;
            int var6 = var12.length;

            for(int var4 = 0; var4 < var6; ++var4) {
               qm.a var10 = var12[var4];
               a(var0, var8, var10.name, var10.ays);
            }

            var7.add(var8);
         } else if(var2 == 2) {
            var7.add(var9.ayu.ayw);
         } else {
            if(var2 != 6) {
               throw new IllegalArgumentException("Unexpected typeOfArrayList: " + var2);
            }

            var7.add(Integer.valueOf(var9.ayu.ayA));
         }
      }

      return var7;
   }

   private static void a(List var0, DataMap var1, String var2, qm.a var3) {
      int var4 = var3.type;
      if(var4 == 14) {
         var1.putString(var2, (String)null);
      } else {
         qm.a var6 = var3.ayu;
         if(var4 == 1) {
            var1.putByteArray(var2, var6.ayv);
         } else if(var4 == 11) {
            var1.putStringArray(var2, var6.ayF);
         } else if(var4 == 12) {
            var1.putLongArray(var2, var6.ayG);
         } else if(var4 == 15) {
            var1.putFloatArray(var2, var6.ayH);
         } else if(var4 == 2) {
            var1.putString(var2, var6.ayw);
         } else if(var4 == 3) {
            var1.putDouble(var2, var6.ayx);
         } else if(var4 == 4) {
            var1.putFloat(var2, var6.ayy);
         } else if(var4 == 5) {
            var1.putLong(var2, var6.ayz);
         } else if(var4 == 6) {
            var1.putInt(var2, var6.ayA);
         } else if(var4 == 7) {
            var1.putByte(var2, (byte)var6.ayB);
         } else if(var4 == 8) {
            var1.putBoolean(var2, var6.ayC);
         } else if(var4 == 13) {
            if(var0 == null) {
               throw new RuntimeException("populateBundle: unexpected type for: " + var2);
            } else {
               var1.putAsset(var2, (Asset)var0.get((int)var6.ayI));
            }
         } else if(var4 != 9) {
            if(var4 == 10) {
               var4 = a(var2, var6.ayE);
               ArrayList var8 = a(var0, var6, var4);
               if(var4 == 14) {
                  var1.putStringArrayList(var2, var8);
               } else if(var4 == 9) {
                  var1.putDataMapArrayList(var2, var8);
               } else if(var4 == 2) {
                  var1.putStringArrayList(var2, var8);
               } else if(var4 == 6) {
                  var1.putIntegerArrayList(var2, var8);
               } else {
                  throw new IllegalStateException("Unexpected typeOfArrayList: " + var4);
               }
            } else {
               throw new RuntimeException("populateBundle: unexpected type " + var4);
            }
         } else {
            DataMap var9 = new DataMap();
            qm.a[] var10 = var6.ayD;
            int var5 = var10.length;

            for(var4 = 0; var4 < var5; ++var4) {
               qm.a var7 = var10[var4];
               a(var0, var9, var7.name, var7.ays);
            }

            var1.putDataMap(var2, var9);
         }
      }
   }

   private static qm.a[] a(DataMap var0, List var1) {
      Set var4 = var0.keySet();
      qm.a[] var3 = new qm.a[var4.size()];
      Iterator var7 = var4.iterator();

      for(int var2 = 0; var7.hasNext(); ++var2) {
         String var5 = (String)var7.next();
         Object var6 = var0.get(var5);
         var3[var2] = new qm.a();
         var3[var2].name = var5;
         var3[var2].ays = a(var1, var6);
      }

      return var3;
   }

   public static class a {
      public final qm ayo;
      public final List ayp;

      public a(qm var1, List var2) {
         this.ayo = var1;
         this.ayp = var2;
      }
   }
}
