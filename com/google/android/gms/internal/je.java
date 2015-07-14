package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

public final class je {
   public static void K(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   public static void a(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void aU(String var0) {
      if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
         Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   public static void aV(String var0) {
      if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
         Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   public static void f(Object var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("null reference");
      }
   }
}
