package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

public abstract class iy {
   private static iy.a KO = null;
   private static final Object mH = new Object();
   protected final String KP;
   protected final Object KQ;
   private Object KR = null;

   protected iy(String var1, Object var2) {
      this.KP = var1;
      this.KQ = var2;
   }

   public static void H(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static iy a(final String var0, final Integer var1) {
      return new iy(var0, var1) {
      };
   }

   public static iy h(final String var0, boolean var1) {
      return new iy(var0, Boolean.valueOf(var1)) {
      };
   }

   public static iy l(final String var0, final String var1) {
      return new iy(var0, var1) {
      };
   }

   public String getKey() {
      return this.KP;
   }

   private interface a {
   }

   private static class b implements iy.a {
      private final ContentResolver mContentResolver;

      public b(ContentResolver var1) {
         this.mContentResolver = var1;
      }
   }
}
