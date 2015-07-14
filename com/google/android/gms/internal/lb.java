package com.google.android.gms.internal;

import android.util.Base64;

public final class lb {
   public static String d(byte[] var0) {
      return var0 == null?null:Base64.encodeToString(var0, 0);
   }

   public static String e(byte[] var0) {
      return var0 == null?null:Base64.encodeToString(var0, 10);
   }
}
