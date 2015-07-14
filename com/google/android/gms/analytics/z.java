package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.aa;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.m;
import com.google.android.gms.analytics.n;

class z extends n {
   public z(Context var1) {
      super(var1, new z.a());
   }

   private static class a implements n.a {
      private final aa Bi = new aa();

      public void c(String var1, int var2) {
         if("ga_dispatchPeriod".equals(var1)) {
            this.Bi.Bk = var2;
         } else {
            ae.W("int configuration name not recognized:  " + var1);
         }
      }

      public void e(String var1, String var2) {
      }

      public void e(String var1, boolean var2) {
         if("ga_dryRun".equals(var1)) {
            aa var4 = this.Bi;
            byte var3;
            if(var2) {
               var3 = 1;
            } else {
               var3 = 0;
            }

            var4.Bl = var3;
         } else {
            ae.W("bool configuration name not recognized:  " + var1);
         }
      }

      public aa eN() {
         return this.Bi;
      }

      // $FF: synthetic method
      public m er() {
         return this.eN();
      }

      public void f(String var1, String var2) {
         if("ga_appName".equals(var1)) {
            this.Bi.ya = var2;
         } else if("ga_appVersion".equals(var1)) {
            this.Bi.yb = var2;
         } else if("ga_logLevel".equals(var1)) {
            this.Bi.Bj = var2;
         } else {
            ae.W("string configuration name not recognized:  " + var1);
         }
      }
   }
}
