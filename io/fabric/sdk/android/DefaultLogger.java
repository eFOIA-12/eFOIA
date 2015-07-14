package io.fabric.sdk.android;

import android.util.Log;
import io.fabric.sdk.android.Logger;

public class DefaultLogger implements Logger {
   private int logLevel;

   public DefaultLogger() {
      this.logLevel = 4;
   }

   public DefaultLogger(int var1) {
      this.logLevel = var1;
   }

   public void d(String var1, String var2) {
      this.d(var1, var2, (Throwable)null);
   }

   public void d(String var1, String var2, Throwable var3) {
      if(this.isLoggable(var1, 3)) {
         Log.d(var1, var2, var3);
      }

   }

   public void e(String var1, String var2) {
      this.e(var1, var2, (Throwable)null);
   }

   public void e(String var1, String var2, Throwable var3) {
      if(this.isLoggable(var1, 6)) {
         Log.e(var1, var2, var3);
      }

   }

   public int getLogLevel() {
      return this.logLevel;
   }

   public void i(String var1, String var2) {
      this.i(var1, var2, (Throwable)null);
   }

   public void i(String var1, String var2, Throwable var3) {
      if(this.isLoggable(var1, 4)) {
         Log.i(var1, var2, var3);
      }

   }

   public boolean isLoggable(String var1, int var2) {
      return this.logLevel <= var2;
   }

   public void log(int var1, String var2, String var3) {
      this.log(var1, var2, var3, false);
   }

   public void log(int var1, String var2, String var3, boolean var4) {
      if(var4 || this.isLoggable(var2, var1)) {
         Log.println(var1, var2, var3);
      }

   }

   public void setLogLevel(int var1) {
      this.logLevel = var1;
   }

   public void v(String var1, String var2) {
      this.v(var1, var2, (Throwable)null);
   }

   public void v(String var1, String var2, Throwable var3) {
      if(this.isLoggable(var1, 2)) {
         Log.v(var1, var2, var3);
      }

   }

   public void w(String var1, String var2) {
      this.w(var1, var2, (Throwable)null);
   }

   public void w(String var1, String var2, Throwable var3) {
      if(this.isLoggable(var1, 5)) {
         Log.w(var1, var2, var3);
      }

   }
}
