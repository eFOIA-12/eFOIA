package io.fabric.sdk.android;

import io.fabric.sdk.android.Logger;

public class SilentLogger implements Logger {
   private int logLevel = 7;

   public void d(String var1, String var2) {
   }

   public void d(String var1, String var2, Throwable var3) {
   }

   public void e(String var1, String var2) {
   }

   public void e(String var1, String var2, Throwable var3) {
   }

   public int getLogLevel() {
      return this.logLevel;
   }

   public void i(String var1, String var2) {
   }

   public void i(String var1, String var2, Throwable var3) {
   }

   public boolean isLoggable(String var1, int var2) {
      return false;
   }

   public void log(int var1, String var2, String var3) {
   }

   public void log(int var1, String var2, String var3, boolean var4) {
   }

   public void setLogLevel(int var1) {
   }

   public void v(String var1, String var2) {
   }

   public void v(String var1, String var2, Throwable var3) {
   }

   public void w(String var1, String var2) {
   }

   public void w(String var1, String var2, Throwable var3) {
   }
}
