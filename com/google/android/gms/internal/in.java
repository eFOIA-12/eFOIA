package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;

public final class in {
   public static boolean a(Object var0, Object var1) {
      return var0 == null && var1 == null || var0 != null && var1 != null && var0.equals(var1);
   }

   public static void aF(String var0) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("Namespace cannot be null or empty");
      } else if(var0.length() > 128) {
         throw new IllegalArgumentException("Invalid namespace length");
      } else if(!var0.startsWith("urn:x-cast:")) {
         throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
      } else if(var0.length() == "urn:x-cast:".length()) {
         throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
      }
   }

   public static String aG(String var0) {
      return "urn:x-cast:" + var0;
   }

   public static long b(double var0) {
      return (long)(1000.0D * var0);
   }

   public static String b(Locale var0) {
      StringBuilder var1 = new StringBuilder(20);
      var1.append(var0.getLanguage());
      String var2 = var0.getCountry();
      if(!TextUtils.isEmpty(var2)) {
         var1.append('-').append(var2);
      }

      String var3 = var0.getVariant();
      if(!TextUtils.isEmpty(var3)) {
         var1.append('-').append(var3);
      }

      return var1.toString();
   }

   public static double o(long var0) {
      return (double)var0 / 1000.0D;
   }
}
