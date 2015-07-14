package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

public final class lc {
   private static Pattern Oe = null;

   public static boolean K(Context var0) {
      return var0.getPackageManager().hasSystemFeature("android.hardware.type.watch");
   }

   public static int aS(int var0) {
      return var0 / 1000;
   }

   public static int aT(int var0) {
      return var0 % 1000 / 100;
   }

   public static boolean aU(int var0) {
      return aT(var0) == 3;
   }
}
