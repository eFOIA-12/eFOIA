package com.google.android.gms.games.internal.constants;

public final class PlatformType {
   public static String dZ(int var0) {
      switch(var0) {
      case 0:
         return "ANDROID";
      case 1:
         return "IOS";
      case 2:
         return "WEB_APP";
      default:
         throw new IllegalArgumentException("Unknown platform type: " + var0);
      }
   }
}
