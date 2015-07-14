package io.fabric.sdk.android;

public interface Logger {
   void d(String var1, String var2);

   void d(String var1, String var2, Throwable var3);

   void e(String var1, String var2);

   void e(String var1, String var2, Throwable var3);

   int getLogLevel();

   void i(String var1, String var2);

   void i(String var1, String var2, Throwable var3);

   boolean isLoggable(String var1, int var2);

   void log(int var1, String var2, String var3);

   void log(int var1, String var2, String var3, boolean var4);

   void setLogLevel(int var1);

   void v(String var1, String var2);

   void v(String var1, String var2, Throwable var3);

   void w(String var1, String var2);

   void w(String var1, String var2, Throwable var3);
}
