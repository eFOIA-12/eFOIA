package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class a {
   public static String[] A(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         String[] var3 = var0.createStringArray();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static ArrayList B(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         ArrayList var5 = new ArrayList();
         int var4 = var0.readInt();

         for(var1 = 0; var1 < var4; ++var1) {
            var5.add(Integer.valueOf(var0.readInt()));
         }

         var0.setDataPosition(var3 + var2);
         return var5;
      }
   }

   public static ArrayList C(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         ArrayList var3 = var0.createStringArrayList();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static Parcel D(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         Parcel var3 = Parcel.obtain();
         var3.appendFrom(var0, var2, var1);
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static Parcel[] E(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int var4 = var0.readInt();
         Parcel[] var7 = new Parcel[var4];

         for(var1 = 0; var1 < var4; ++var1) {
            int var5 = var0.readInt();
            if(var5 != 0) {
               int var6 = var0.dataPosition();
               Parcel var8 = Parcel.obtain();
               var8.appendFrom(var0, var6, var5);
               var7[var1] = var8;
               var0.setDataPosition(var5 + var6);
            } else {
               var7[var1] = null;
            }
         }

         var0.setDataPosition(var3 + var2);
         return var7;
      }
   }

   public static int F(Parcel var0) {
      return var0.readInt();
   }

   public static int G(Parcel var0) {
      int var2 = F(var0);
      int var3 = a(var0, var2);
      int var1 = var0.dataPosition();
      if(aH(var2) != 20293) {
         throw new a.a("Expected object header. Got 0x" + Integer.toHexString(var2), var0);
      } else {
         var2 = var1 + var3;
         if(var2 >= var1 && var2 <= var0.dataSize()) {
            return var2;
         } else {
            throw new a.a("Size read is invalid start=" + var1 + " end=" + var2, var0);
         }
      }
   }

   public static int a(Parcel var0, int var1) {
      return (var1 & -65536) != -65536?var1 >> 16 & '\uffff':var0.readInt();
   }

   public static Parcelable a(Parcel var0, int var1, Creator var2) {
      var1 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         Parcelable var4 = (Parcelable)var2.createFromParcel(var0);
         var0.setDataPosition(var1 + var3);
         return var4;
      }
   }

   private static void a(Parcel var0, int var1, int var2) {
      var1 = a(var0, var1);
      if(var1 != var2) {
         throw new a.a("Expected size " + var2 + " got " + var1 + " (0x" + Integer.toHexString(var1) + ")", var0);
      }
   }

   private static void a(Parcel var0, int var1, int var2, int var3) {
      if(var2 != var3) {
         throw new a.a("Expected size " + var3 + " got " + var2 + " (0x" + Integer.toHexString(var2) + ")", var0);
      }
   }

   public static void a(Parcel var0, int var1, List var2, ClassLoader var3) {
      var1 = a(var0, var1);
      int var4 = var0.dataPosition();
      if(var1 != 0) {
         var0.readList(var2, var3);
         var0.setDataPosition(var1 + var4);
      }
   }

   public static int aH(int var0) {
      return '\uffff' & var0;
   }

   public static void b(Parcel var0, int var1) {
      var0.setDataPosition(a(var0, var1) + var0.dataPosition());
   }

   public static Object[] b(Parcel var0, int var1, Creator var2) {
      var1 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         Object[] var4 = var0.createTypedArray(var2);
         var0.setDataPosition(var1 + var3);
         return var4;
      }
   }

   public static ArrayList c(Parcel var0, int var1, Creator var2) {
      var1 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         ArrayList var4 = var0.createTypedArrayList(var2);
         var0.setDataPosition(var1 + var3);
         return var4;
      }
   }

   public static boolean c(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readInt() != 0;
   }

   public static Boolean d(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         a(var0, var1, var2, 4);
         boolean var3;
         if(var0.readInt() != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return Boolean.valueOf(var3);
      }
   }

   public static byte e(Parcel var0, int var1) {
      a(var0, var1, 4);
      return (byte)var0.readInt();
   }

   public static short f(Parcel var0, int var1) {
      a(var0, var1, 4);
      return (short)var0.readInt();
   }

   public static int g(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readInt();
   }

   public static Integer h(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         a(var0, var1, var2, 4);
         return Integer.valueOf(var0.readInt());
      }
   }

   public static long i(Parcel var0, int var1) {
      a(var0, var1, 8);
      return var0.readLong();
   }

   public static Long j(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         a(var0, var1, var2, 8);
         return Long.valueOf(var0.readLong());
      }
   }

   public static BigInteger k(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         byte[] var3 = var0.createByteArray();
         var0.setDataPosition(var1 + var2);
         return new BigInteger(var3);
      }
   }

   public static float l(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readFloat();
   }

   public static double m(Parcel var0, int var1) {
      a(var0, var1, 8);
      return var0.readDouble();
   }

   public static BigDecimal n(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         byte[] var4 = var0.createByteArray();
         int var3 = var0.readInt();
         var0.setDataPosition(var1 + var2);
         return new BigDecimal(new BigInteger(var4), var3);
      }
   }

   public static String o(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         String var3 = var0.readString();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static IBinder p(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         IBinder var3 = var0.readStrongBinder();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static Bundle q(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         Bundle var3 = var0.readBundle();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static byte[] r(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         byte[] var3 = var0.createByteArray();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static byte[][] s(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return (byte[][])null;
      } else {
         int var4 = var0.readInt();
         byte[][] var5 = new byte[var4][];

         for(var1 = 0; var1 < var4; ++var1) {
            var5[var1] = var0.createByteArray();
         }

         var0.setDataPosition(var3 + var2);
         return var5;
      }
   }

   public static boolean[] t(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         boolean[] var3 = var0.createBooleanArray();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static int[] u(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         int[] var3 = var0.createIntArray();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static long[] v(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         long[] var3 = var0.createLongArray();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static BigInteger[] w(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int var4 = var0.readInt();
         BigInteger[] var5 = new BigInteger[var4];

         for(var1 = 0; var1 < var4; ++var1) {
            var5[var1] = new BigInteger(var0.createByteArray());
         }

         var0.setDataPosition(var3 + var2);
         return var5;
      }
   }

   public static float[] x(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         float[] var3 = var0.createFloatArray();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static double[] y(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      if(var1 == 0) {
         return null;
      } else {
         double[] var3 = var0.createDoubleArray();
         var0.setDataPosition(var1 + var2);
         return var3;
      }
   }

   public static BigDecimal[] z(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int var4 = var0.readInt();
         BigDecimal[] var6 = new BigDecimal[var4];

         for(var1 = 0; var1 < var4; ++var1) {
            byte[] var7 = var0.createByteArray();
            int var5 = var0.readInt();
            var6[var1] = new BigDecimal(new BigInteger(var7), var5);
         }

         var0.setDataPosition(var3 + var2);
         return var6;
      }
   }

   public static class a extends RuntimeException {
      public a(String var1, Parcel var2) {
         super(var1 + " Parcel: pos=" + var2.dataPosition() + " size=" + var2.dataSize());
      }
   }
}
