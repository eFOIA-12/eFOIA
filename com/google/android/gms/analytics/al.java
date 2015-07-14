package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.am;
import com.google.android.gms.analytics.m;
import com.google.android.gms.analytics.n;

class al extends n {
   public al(Context var1) {
      super(var1, new al.a());
   }

   private static class a implements n.a {
      private final am Cu = new am();

      public void c(String var1, int var2) {
         if("ga_sessionTimeout".equals(var1)) {
            this.Cu.Cx = var2;
         } else {
            ae.W("int configuration name not recognized:  " + var1);
         }
      }

      public void e(String var1, String var2) {
         this.Cu.CB.put(var1, var2);
      }

      public void e(String var1, boolean var2) {
         byte var4 = 1;
         byte var5 = 1;
         byte var3 = 1;
         am var6;
         if("ga_autoActivityTracking".equals(var1)) {
            var6 = this.Cu;
            if(!var2) {
               var3 = 0;
            }

            var6.Cy = var3;
         } else if("ga_anonymizeIp".equals(var1)) {
            var6 = this.Cu;
            if(var2) {
               var3 = var4;
            } else {
               var3 = 0;
            }

            var6.Cz = var3;
         } else if("ga_reportUncaughtExceptions".equals(var1)) {
            var6 = this.Cu;
            if(var2) {
               var3 = var5;
            } else {
               var3 = 0;
            }

            var6.CA = var3;
         } else {
            ae.W("bool configuration name not recognized:  " + var1);
         }
      }

      // $FF: synthetic method
      public m er() {
         return this.fs();
      }

      public void f(String var1, String var2) {
         if("ga_trackingId".equals(var1)) {
            this.Cu.Cv = var2;
         } else if("ga_sampleFrequency".equals(var1)) {
            try {
               this.Cu.Cw = Double.parseDouble(var2);
            } catch (NumberFormatException var3) {
               ae.T("Error parsing ga_sampleFrequency value: " + var2);
            }
         } else {
            ae.W("string configuration name not recognized:  " + var1);
         }
      }

      public am fs() {
         return this.Cu;
      }
   }
}
