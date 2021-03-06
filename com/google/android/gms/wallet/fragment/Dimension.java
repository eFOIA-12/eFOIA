package com.google.android.gms.wallet.fragment;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Dimension {
   public static final int MATCH_PARENT = -1;
   public static final int UNIT_DIP = 1;
   public static final int UNIT_IN = 4;
   public static final int UNIT_MM = 5;
   public static final int UNIT_PT = 3;
   public static final int UNIT_PX = 0;
   public static final int UNIT_SP = 2;
   public static final int WRAP_CONTENT = -2;

   public static int a(long var0, DisplayMetrics var2) {
      int var3 = (int)(var0 >>> 32);
      int var4 = (int)var0;
      byte var5;
      switch(var3) {
      case 0:
         var5 = 0;
         break;
      case 1:
         var5 = 1;
         break;
      case 2:
         var5 = 2;
         break;
      case 3:
         var5 = 3;
         break;
      case 4:
         var5 = 4;
         break;
      case 5:
         var5 = 5;
         break;
      case 128:
         return TypedValue.complexToDimensionPixelSize(var4, var2);
      case 129:
         return var4;
      default:
         throw new IllegalStateException("Unexpected unit or type: " + var3);
      }

      return Math.round(TypedValue.applyDimension(var5, Float.intBitsToFloat(var4), var2));
   }

   public static long a(int var0, float var1) {
      switch(var0) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
         return p(var0, Float.floatToIntBits(var1));
      default:
         throw new IllegalArgumentException("Unrecognized unit: " + var0);
      }
   }

   public static long a(TypedValue var0) {
      switch(var0.type) {
      case 5:
         return p(128, var0.data);
      case 16:
         return gg(var0.data);
      default:
         throw new IllegalArgumentException("Unexpected dimension type: " + var0.type);
      }
   }

   public static long gg(int var0) {
      if(var0 < 0) {
         if(var0 != -1 && var0 != -2) {
            throw new IllegalArgumentException("Unexpected dimension value: " + var0);
         } else {
            return p(129, var0);
         }
      } else {
         return a(0, (float)var0);
      }
   }

   private static long p(int var0, int var1) {
      return (long)var0 << 32 | (long)var1 & 4294967295L;
   }
}
