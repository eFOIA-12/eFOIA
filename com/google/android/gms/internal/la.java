package com.google.android.gms.internal;

import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class la {
   public static int a(Object[] var0, Object var1) {
      int var3 = 0;
      int var2;
      if(var0 != null) {
         var2 = var0.length;
      } else {
         var2 = 0;
      }

      while(var3 < var2) {
         if(jv.equal(var0[var3], var1)) {
            return var3;
         }

         ++var3;
      }

      return -1;
   }

   public static void a(StringBuilder var0, double[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var2 != 0) {
            var0.append(",");
         }

         var0.append(Double.toString(var1[var2]));
      }

   }

   public static void a(StringBuilder var0, float[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var2 != 0) {
            var0.append(",");
         }

         var0.append(Float.toString(var1[var2]));
      }

   }

   public static void a(StringBuilder var0, int[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var2 != 0) {
            var0.append(",");
         }

         var0.append(Integer.toString(var1[var2]));
      }

   }

   public static void a(StringBuilder var0, long[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var2 != 0) {
            var0.append(",");
         }

         var0.append(Long.toString(var1[var2]));
      }

   }

   public static void a(StringBuilder var0, Object[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var2 != 0) {
            var0.append(",");
         }

         var0.append(var1[var2].toString());
      }

   }

   public static void a(StringBuilder var0, String[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var2 != 0) {
            var0.append(",");
         }

         var0.append("\"").append(var1[var2]).append("\"");
      }

   }

   public static void a(StringBuilder var0, boolean[] var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         if(var2 != 0) {
            var0.append(",");
         }

         var0.append(Boolean.toString(var1[var2]));
      }

   }

   public static Integer[] a(int[] var0) {
      Integer[] var3;
      if(var0 == null) {
         var3 = null;
      } else {
         int var2 = var0.length;
         Integer[] var4 = new Integer[var2];
         int var1 = 0;

         while(true) {
            var3 = var4;
            if(var1 >= var2) {
               break;
            }

            var4[var1] = Integer.valueOf(var0[var1]);
            ++var1;
         }
      }

      return var3;
   }

   public static ArrayList b(Object[] var0) {
      int var2 = var0.length;
      ArrayList var3 = new ArrayList(var2);

      for(int var1 = 0; var1 < var2; ++var1) {
         var3.add(var0[var1]);
      }

      return var3;
   }

   public static boolean b(Object[] var0, Object var1) {
      return a(var0, var1) >= 0;
   }

   public static ArrayList ie() {
      return new ArrayList();
   }
}
