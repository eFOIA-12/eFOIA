package com.google.android.gms.maps.internal;

public final class a {
   public static Boolean a(byte var0) {
      switch(var0) {
      case 0:
         return Boolean.FALSE;
      case 1:
         return Boolean.TRUE;
      default:
         return null;
      }
   }

   public static byte c(Boolean var0) {
      return (byte)(var0 != null?(var0.booleanValue()?1:0):-1);
   }
}
