package com.google.android.gms.analytics;

import com.google.android.gms.analytics.ae;

public final class s {
   public static String A(int var0) {
      return d("&pr", var0);
   }

   public static String B(int var0) {
      return d("&promo", var0);
   }

   public static String C(int var0) {
      return d("pi", var0);
   }

   public static String D(int var0) {
      return d("&il", var0);
   }

   public static String E(int var0) {
      return d("cd", var0);
   }

   public static String F(int var0) {
      return d("cm", var0);
   }

   private static String d(String var0, int var1) {
      if(var1 < 1) {
         ae.T("index out of range for " + var0 + " (" + var1 + ")");
         return "";
      } else {
         return var0 + var1;
      }
   }

   static String y(int var0) {
      return d("&cd", var0);
   }

   static String z(int var0) {
      return d("&cm", var0);
   }
}
