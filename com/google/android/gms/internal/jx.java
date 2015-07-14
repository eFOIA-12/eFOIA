package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class jx {
   public static void K(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   public static void L(boolean var0) {
      if(!var0) {
         throw new IllegalArgumentException();
      }
   }

   public static void a(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void a(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalStateException(String.format(var1, var2));
      }
   }

   public static void aU(String var0) {
      if(Looper.myLooper() != Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   public static void aV(String var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   public static Object b(Object var0, Object var1) {
      if(var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static String b(String var0, Object var1) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static void b(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   public static void b(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalArgumentException(String.format(var1, var2));
      }
   }

   public static String bb(String var0) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("Given String is empty or null");
      } else {
         return var0;
      }
   }

   public static Object i(Object var0) {
      if(var0 == null) {
         throw new NullPointerException("null reference");
      } else {
         return var0;
      }
   }
}
