package com.google.android.gms.analytics;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class p implements Logger {
   private int yM = 2;

   private String af(String var1) {
      return Thread.currentThread().toString() + ": " + var1;
   }

   public void error(Exception var1) {
      if(this.yM <= 3) {
         Log.e("GAV4", (String)null, var1);
      }

   }

   public void error(String var1) {
      if(this.yM <= 3) {
         Log.e("GAV4", this.af(var1));
      }

   }

   public int getLogLevel() {
      return this.yM;
   }

   public void info(String var1) {
      if(this.yM <= 1) {
         Log.i("GAV4", this.af(var1));
      }

   }

   public void setLogLevel(int var1) {
      this.yM = var1;
   }

   public void verbose(String var1) {
      if(this.yM <= 0) {
         Log.v("GAV4", this.af(var1));
      }

   }

   public void warn(String var1) {
      if(this.yM <= 2) {
         Log.w("GAV4", this.af(var1));
      }

   }
}
