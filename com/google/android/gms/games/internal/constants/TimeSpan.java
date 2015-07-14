package com.google.android.gms.games.internal.constants;

public final class TimeSpan {
   private TimeSpan() {
      throw new AssertionError("Uninstantiable");
   }

   public static String dZ(int var0) {
      switch(var0) {
      case 0:
         return "DAILY";
      case 1:
         return "WEEKLY";
      case 2:
         return "ALL_TIME";
      default:
         throw new IllegalArgumentException("Unknown time span " + var0);
      }
   }
}
