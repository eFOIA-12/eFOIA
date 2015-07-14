package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class is {
   private static boolean HN = false;
   private boolean HO;
   private boolean HP;
   private String HQ;
   protected final String mTag;

   public is(String var1) {
      this(var1, go());
   }

   public is(String var1, boolean var2) {
      this.mTag = var1;
      this.HO = var2;
      this.HP = false;
   }

   public static boolean go() {
      return HN;
   }

   public void a(String var1, Object... var2) {
      if(this.gn()) {
         Log.v(this.mTag, this.e(var1, var2));
      }

   }

   public void a(Throwable var1, String var2, Object... var3) {
      if(this.gm() || HN) {
         Log.d(this.mTag, this.e(var2, var3), var1);
      }

   }

   public void aK(String var1) {
      if(TextUtils.isEmpty(var1)) {
         var1 = null;
      } else {
         var1 = String.format("[%s] ", new Object[]{var1});
      }

      this.HQ = var1;
   }

   public void b(String var1, Object... var2) {
      if(this.gm() || HN) {
         Log.d(this.mTag, this.e(var1, var2));
      }

   }

   public void c(String var1, Object... var2) {
      Log.i(this.mTag, this.e(var1, var2));
   }

   public void d(String var1, Object... var2) {
      Log.w(this.mTag, this.e(var1, var2));
   }

   protected String e(String var1, Object... var2) {
      if(var2.length != 0) {
         var1 = String.format(var1, var2);
      }

      String var3 = var1;
      if(!TextUtils.isEmpty(this.HQ)) {
         var3 = this.HQ + var1;
      }

      return var3;
   }

   public boolean gm() {
      return this.HO;
   }

   public boolean gn() {
      return this.HP;
   }
}
