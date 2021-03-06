package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tagmanager.bh;

class df {
   private Context mContext;
   private Tracker yO;
   private GoogleAnalytics yQ;

   df(Context var1) {
      this.mContext = var1;
   }

   private void cX(String var1) {
      synchronized(this){}

      try {
         if(this.yQ == null) {
            this.yQ = GoogleAnalytics.getInstance(this.mContext);
            this.yQ.setLogger(new df.a());
            this.yO = this.yQ.newTracker(var1);
         }
      } finally {
         ;
      }

   }

   public Tracker cW(String var1) {
      this.cX(var1);
      return this.yO;
   }

   static class a implements Logger {
      private static int fP(int var0) {
         switch(var0) {
         case 2:
            return 0;
         case 3:
         case 4:
            return 1;
         case 5:
            return 2;
         case 6:
         default:
            return 3;
         }
      }

      public void error(Exception var1) {
         bh.b("", var1);
      }

      public void error(String var1) {
         bh.T(var1);
      }

      public int getLogLevel() {
         return fP(bh.getLogLevel());
      }

      public void info(String var1) {
         bh.U(var1);
      }

      public void setLogLevel(int var1) {
         bh.W("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
      }

      public void verbose(String var1) {
         bh.V(var1);
      }

      public void warn(String var1) {
         bh.W(var1);
      }
   }
}
