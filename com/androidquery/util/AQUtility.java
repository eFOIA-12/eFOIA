package com.androidquery.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.androidquery.AQuery;
import com.androidquery.util.Common;
import com.androidquery.util.Progress;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AQUtility {
   private static final int IO_BUFFER_SIZE = 4096;
   public static boolean TEST_IO_EXCEPTION = false;
   private static File cacheDir;
   private static Context context;
   private static boolean debug = false;
   private static UncaughtExceptionHandler eh;
   private static Handler handler;
   private static final char[] map1 = new char[64];
   private static final byte[] map2;
   private static File pcacheDir;
   private static ScheduledExecutorService storeExe;
   private static Map times = new HashMap();
   private static Object wait;

   static {
      char var0 = 65;

      int var1;
      for(var1 = 0; var0 <= 90; ++var1) {
         map1[var1] = var0++;
      }

      for(var0 = 97; var0 <= 122; ++var1) {
         map1[var1] = var0++;
      }

      for(var0 = 48; var0 <= 57; ++var1) {
         map1[var1] = var0++;
      }

      char[] var3 = map1;
      int var2 = var1 + 1;
      var3[var1] = 43;
      map1[var2] = 47;
      map2 = new byte[128];

      for(var1 = 0; var1 < map2.length; ++var1) {
         map2[var1] = -1;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         map2[map1[var1]] = (byte)var1;
      }

   }

   public static void apply(Editor var0) {
      if(AQuery.SDK_INT >= 9) {
         invokeHandler(var0, "apply", false, true, (Class[])null, (Object[])null);
      } else {
         var0.commit();
      }
   }

   public static void cleanCache(File param0, long param1, long param3) {
      // $FF: Couldn't be decompiled
   }

   private static void cleanCache(File[] var0, long var1) {
      long var6 = 0L;
      int var4 = 0;

      long var8;
      for(int var3 = 0; var3 < var0.length; var6 = var8) {
         File var10 = var0[var3];
         int var5 = var4;
         var8 = var6;
         if(var10.isFile()) {
            var8 = var6 + var10.length();
            if(var8 < var1) {
               var5 = var4;
            } else {
               var10.delete();
               var5 = var4 + 1;
            }
         }

         ++var3;
         var4 = var5;
      }

      debug("deleted", Integer.valueOf(var4));
   }

   public static void cleanCacheAsync(Context var0) {
      cleanCacheAsync(var0, 3000000L, 2000000L);
   }

   public static void cleanCacheAsync(Context var0, long var1, long var3) {
      try {
         File var6 = getCacheDir(var0);
         Common var7 = (new Common()).method(2, new Object[]{var6, Long.valueOf(var1), Long.valueOf(var3)});
         getFileStoreExecutor().schedule(var7, 0L, TimeUnit.MILLISECONDS);
      } catch (Exception var5) {
         report(var5);
      }
   }

   public static void close(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (Exception var1) {
            return;
         }
      }

   }

   public static void copy(InputStream var0, OutputStream var1) throws IOException {
      copy(var0, var1, 0, (Progress)null);
   }

   public static void copy(InputStream var0, OutputStream var1, int var2, Progress var3) throws IOException {
      if(var3 != null) {
         var3.reset();
         var3.setBytes(var2);
      }

      byte[] var6 = new byte[4096];
      var2 = 0;

      while(true) {
         int var5 = var0.read(var6);
         if(var5 == -1) {
            if(var3 != null) {
               var3.done();
            }

            return;
         }

         var1.write(var6, 0, var5);
         int var4 = var2 + 1;
         if(TEST_IO_EXCEPTION && var4 > 2) {
            debug((Object)"simulating internet error");
            throw new IOException();
         }

         var2 = var4;
         if(var3 != null) {
            var3.increment(var5);
            var2 = var4;
         }
      }
   }

   public static void debug(Object var0) {
      if(debug) {
         Log.w("AQuery", var0 + "");
      }

   }

   public static void debug(Object var0, Object var1) {
      if(debug) {
         Log.w("AQuery", var0 + ":" + var1);
      }

   }

   public static void debug(Throwable var0) {
      if(debug) {
         Log.w("AQuery", Log.getStackTraceString(var0));
      }

   }

   public static void debugNotify() {
      // $FF: Couldn't be decompiled
   }

   public static void debugWait(long param0) {
      // $FF: Couldn't be decompiled
   }

   public static int dip2pixel(Context var0, float var1) {
      return (int)TypedValue.applyDimension(1, var1, var0.getResources().getDisplayMetrics());
   }

   public static char[] encode64(byte[] var0, int var1, int var2) {
      int var7 = (var2 * 4 + 2) / 3;
      char[] var10 = new char[(var2 + 2) / 3 * 4];
      int var8 = var1 + var2;

      for(var2 = 0; var1 < var8; ++var2) {
         int var4 = var1 + 1;
         int var9 = var0[var1] & 255;
         if(var4 < var8) {
            var1 = var4 + 1;
            var4 = var0[var4] & 255;
         } else {
            byte var5 = 0;
            var1 = var4;
            var4 = var5;
         }

         int var6;
         int var11;
         if(var1 < var8) {
            var11 = var1 + 1;
            var6 = var0[var1] & 255;
            var1 = var11;
            var11 = var6;
         } else {
            var11 = 0;
         }

         var6 = var2 + 1;
         var10[var2] = map1[var9 >>> 2];
         var2 = var6 + 1;
         var10[var6] = map1[(var9 & 3) << 4 | var4 >>> 4];
         char var3;
         if(var2 < var7) {
            var3 = map1[(var4 & 15) << 2 | var11 >>> 6];
         } else {
            var3 = 61;
         }

         var10[var2] = var3;
         ++var2;
         if(var2 < var7) {
            var3 = map1[var11 & 63];
         } else {
            var3 = 61;
         }

         var10[var2] = var3;
      }

      return var10;
   }

   public static void ensureUIThread() {
      if(!isUIThread()) {
         report(new IllegalStateException("Not UI Thread"));
      }

   }

   public static File getCacheDir(Context var0) {
      if(cacheDir == null) {
         cacheDir = new File(var0.getCacheDir(), "aquery");
         cacheDir.mkdirs();
      }

      return cacheDir;
   }

   public static File getCacheDir(Context var0, int var1) {
      if(var1 == 1) {
         if(pcacheDir != null) {
            return pcacheDir;
         } else {
            pcacheDir = new File(getCacheDir(var0), "persistent");
            pcacheDir.mkdirs();
            return pcacheDir;
         }
      } else {
         return getCacheDir(var0);
      }
   }

   public static File getCacheFile(File var0, String var1) {
      return var1 == null?null:(var1.startsWith(File.separator)?new File(var1):makeCacheFile(var0, getCacheFileName(var1)));
   }

   private static String getCacheFileName(String var0) {
      return getMD5Hex(var0);
   }

   public static Context getContext() {
      if(context == null) {
         warn("warn", "getContext with null");
         debug((Throwable)(new IllegalStateException()));
      }

      return context;
   }

   public static File getExistedCacheByUrl(File var0, String var1) {
      File var2 = getCacheFile(var0, var1);
      if(var2 != null && var2.exists()) {
         var0 = var2;
         if(var2.length() != 0L) {
            return var0;
         }
      }

      var0 = null;
      return var0;
   }

   public static File getExistedCacheByUrlSetAccess(File var0, String var1) {
      var0 = getExistedCacheByUrl(var0, var1);
      if(var0 != null) {
         lastAccess(var0);
      }

      return var0;
   }

   private static ScheduledExecutorService getFileStoreExecutor() {
      if(storeExe == null) {
         storeExe = Executors.newSingleThreadScheduledExecutor();
      }

      return storeExe;
   }

   public static Handler getHandler() {
      if(handler == null) {
         handler = new Handler(Looper.getMainLooper());
      }

      return handler;
   }

   private static byte[] getMD5(byte[] var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance("MD5");
         var1.update(var0);
         var0 = var1.digest();
         return var0;
      } catch (NoSuchAlgorithmException var2) {
         report(var2);
         return null;
      }
   }

   private static String getMD5Hex(String var0) {
      return (new BigInteger(getMD5(var0.getBytes()))).abs().toString(36);
   }

   public static File getTempDir() {
      File var1 = new File(Environment.getExternalStorageDirectory(), "aquery/temp");
      var1.mkdirs();
      File var0;
      if(var1.exists()) {
         var0 = var1;
         if(var1.canWrite()) {
            return var0;
         }
      }

      var0 = null;
      return var0;
   }

   public static Object invokeHandler(Object var0, String var1, boolean var2, boolean var3, Class[] var4, Class[] var5, Object... var6) {
      try {
         var0 = invokeMethod(var0, var1, var2, var4, var5, var6);
         return var0;
      } catch (Exception var7) {
         if(var3) {
            report(var7);
         } else {
            debug((Throwable)var7);
         }

         return null;
      }
   }

   public static Object invokeHandler(Object var0, String var1, boolean var2, boolean var3, Class[] var4, Object... var5) {
      return invokeHandler(var0, var1, var2, var3, var4, (Class[])null, var5);
   }

   private static Object invokeMethod(Object param0, String param1, boolean param2, Class[] param3, Class[] param4, Object... param5) throws Exception {
      // $FF: Couldn't be decompiled
   }

   public static boolean isDebug() {
      return debug;
   }

   public static boolean isUIThread() {
      return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
   }

   private static void lastAccess(File var0) {
      var0.setLastModified(System.currentTimeMillis());
   }

   private static File makeCacheFile(File var0, String var1) {
      return new File(var0, var1);
   }

   public static float pixel2dip(Context var0, float var1) {
      return var1 / ((float)var0.getResources().getDisplayMetrics().densityDpi / 160.0F);
   }

   public static void post(Object var0, String var1) {
      post(var0, var1, new Class[0], new Object[0]);
   }

   public static void post(final Object var0, final String var1, final Class[] var2, final Object... var3) {
      post(new Runnable() {
         public void run() {
            AQUtility.invokeHandler(var0, var1, false, true, var2, var3);
         }
      });
   }

   public static void post(Runnable var0) {
      getHandler().post(var0);
   }

   public static void postAsync(Object var0, String var1) {
      postAsync(var0, var1, new Class[0], new Object[0]);
   }

   public static void postAsync(final Object var0, final String var1, final Class[] var2, final Object... var3) {
      postAsync(new Runnable() {
         public void run() {
            AQUtility.invokeHandler(var0, var1, false, true, var2, var3);
         }
      });
   }

   public static void postAsync(final Runnable var0) {
      (new AsyncTask() {
         protected String doInBackground(Void... var1) {
            try {
               var0.run();
            } catch (Exception var2) {
               AQUtility.report(var2);
            }

            return null;
         }
      }).execute(new Void[0]);
   }

   public static void postDelayed(Runnable var0, long var1) {
      getHandler().postDelayed(var0, var1);
   }

   public static void removePost(Runnable var0) {
      getHandler().removeCallbacks(var0);
   }

   public static void report(Throwable var0) {
      if(var0 != null) {
         try {
            warn("reporting", Log.getStackTraceString(var0));
            if(eh != null) {
               eh.uncaughtException(Thread.currentThread(), var0);
               return;
            }
         } catch (Exception var1) {
            var1.printStackTrace();
            return;
         }
      }

   }

   private static void setAlpha(View var0, float var1) {
      if(var1 == 1.0F) {
         var0.clearAnimation();
      } else {
         AlphaAnimation var2 = new AlphaAnimation(var1, var1);
         var2.setDuration(0L);
         var2.setFillAfter(true);
         var0.startAnimation(var2);
      }
   }

   public static void setCacheDir(File var0) {
      cacheDir = var0;
      if(cacheDir != null) {
         cacheDir.mkdirs();
      }

   }

   public static void setContext(Application var0) {
      context = var0.getApplicationContext();
   }

   public static void setDebug(boolean var0) {
      debug = var0;
   }

   public static void setExceptionHandler(UncaughtExceptionHandler var0) {
      eh = var0;
   }

   public static void store(File var0, byte[] var1) {
      if(var0 != null) {
         try {
            write(var0, var1);
         } catch (Exception var2) {
            report(var2);
            return;
         }
      }

   }

   public static void storeAsync(File var0, byte[] var1, long var2) {
      getFileStoreExecutor().schedule((new Common()).method(1, new Object[]{var0, var1}), var2, TimeUnit.MILLISECONDS);
   }

   private static boolean testCleanNeeded(File[] var0, long var1) {
      long var5 = 0L;
      int var4 = var0.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         var5 += var0[var3].length();
         if(var5 > var1) {
            return true;
         }
      }

      return false;
   }

   public static void time(String var0) {
      times.put(var0, Long.valueOf(System.currentTimeMillis()));
   }

   public static long timeEnd(String var0, long var1) {
      Long var7 = (Long)times.get(var0);
      long var3;
      if(var7 == null) {
         var3 = 0L;
         return var3;
      } else {
         long var5 = System.currentTimeMillis() - var7.longValue();
         if(var1 != 0L) {
            var3 = var5;
            if(var5 <= var1) {
               return var3;
            }
         }

         debug(var0, Long.valueOf(var5));
         return var5;
      }
   }

   public static byte[] toBytes(InputStream var0) {
      byte[] var1 = null;
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();

      label13: {
         byte[] var4;
         try {
            copy(var0, var2);
            var4 = var2.toByteArray();
         } catch (IOException var3) {
            report(var3);
            break label13;
         }

         var1 = var4;
      }

      close(var0);
      return var1;
   }

   public static void transparent(View var0, boolean var1) {
      float var2 = 1.0F;
      if(var1) {
         var2 = 0.5F;
      }

      setAlpha(var0, var2);
   }

   public static void warn(Object var0, Object var1) {
      Log.w("AQuery", var0 + ":" + var1);
   }

   public static void write(File param0, byte[] param1) {
      // $FF: Couldn't be decompiled
   }
}
