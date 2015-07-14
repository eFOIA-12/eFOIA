package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.internal.ey;

@ey
public final class gr {
   public static void S(String var0) {
      if(v(3)) {
         Log.d("Ads", var0);
      }

   }

   public static void T(String var0) {
      if(v(6)) {
         Log.e("Ads", var0);
      }

   }

   public static void U(String var0) {
      if(v(4)) {
         Log.i("Ads", var0);
      }

   }

   public static void V(String var0) {
      if(v(2)) {
         Log.v("Ads", var0);
      }

   }

   public static void W(String var0) {
      if(v(5)) {
         Log.w("Ads", var0);
      }

   }

   public static void a(String var0, Throwable var1) {
      if(v(3)) {
         Log.d("Ads", var0, var1);
      }

   }

   public static void b(String var0, Throwable var1) {
      if(v(6)) {
         Log.e("Ads", var0, var1);
      }

   }

   public static void c(String var0, Throwable var1) {
      if(v(4)) {
         Log.i("Ads", var0, var1);
      }

   }

   public static void d(String var0, Throwable var1) {
      if(v(5)) {
         Log.w("Ads", var0, var1);
      }

   }

   public static boolean v(int var0) {
      return (var0 >= 5 || Log.isLoggable("Ads", var0)) && var0 != 2;
   }
}
