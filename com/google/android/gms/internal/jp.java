package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.oo;

public final class jp {
   private final String Nq;

   public jp(String var1) {
      this.Nq = (String)jx.i(var1);
   }

   public void a(Context var1, String var2, String var3, Throwable var4) {
      StackTraceElement[] var7 = var4.getStackTrace();
      StringBuilder var6 = new StringBuilder();

      for(int var5 = 0; var5 < var7.length && var5 < 2; ++var5) {
         var6.append(var7[var5].toString());
         var6.append("\n");
      }

      oo var8 = new oo(var1, 10);
      var8.a("GMS_WTF", (byte[])null, new String[]{"GMS_WTF", var6.toString()});
      var8.send();
      if(this.aF(7)) {
         Log.e(var2, var3, var4);
         Log.wtf(var2, var3, var4);
      }

   }

   public void a(String var1, String var2, Throwable var3) {
      if(this.aF(4)) {
         Log.i(var1, var2, var3);
      }

   }

   public boolean aF(int var1) {
      return Log.isLoggable(this.Nq, var1);
   }

   public void b(String var1, String var2, Throwable var3) {
      if(this.aF(5)) {
         Log.w(var1, var2, var3);
      }

   }

   public void c(String var1, String var2, Throwable var3) {
      if(this.aF(6)) {
         Log.e(var1, var2, var3);
      }

   }

   public void m(String var1, String var2) {
      if(this.aF(3)) {
         Log.d(var1, var2);
      }

   }

   public void n(String var1, String var2) {
      if(this.aF(2)) {
         Log.v(var1, var2);
      }

   }

   public void o(String var1, String var2) {
      if(this.aF(5)) {
         Log.w(var1, var2);
      }

   }

   public void p(String var1, String var2) {
      if(this.aF(6)) {
         Log.e(var1, var2);
      }

   }
}
