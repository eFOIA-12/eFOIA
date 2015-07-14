package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import io.fabric.sdk.android.Fabric;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CommonUtils {
   static final int BYTES_IN_A_GIGABYTE = 1073741824;
   static final int BYTES_IN_A_KILOBYTE = 1024;
   static final int BYTES_IN_A_MEGABYTE = 1048576;
   private static final String CLS_SHARED_PREFERENCES_NAME = "com.crashlytics.prefs";
   static final boolean CLS_TRACE_DEFAULT = false;
   static final String CLS_TRACE_PREFERENCE_NAME = "com.crashlytics.Trace";
   static final String CRASHLYTICS_BUILD_ID = "com.crashlytics.android.build_id";
   public static final int DEVICE_STATE_BETAOS = 8;
   public static final int DEVICE_STATE_COMPROMISEDLIBRARIES = 32;
   public static final int DEVICE_STATE_DEBUGGERATTACHED = 4;
   public static final int DEVICE_STATE_ISSIMULATOR = 1;
   public static final int DEVICE_STATE_JAILBROKEN = 2;
   public static final int DEVICE_STATE_VENDORINTERNAL = 16;
   static final String ENCRYPTION_AES = "AES/ECB/PKCS7Padding";
   static final String FABRIC_BUILD_ID = "io.fabric.android.build_id";
   public static final Comparator FILE_MODIFIED_COMPARATOR = new Comparator() {
      public int compare(File var1, File var2) {
         return (int)(var1.lastModified() - var2.lastModified());
      }
   };
   public static final String GOOGLE_SDK = "google_sdk";
   private static final char[] HEX_VALUES = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   private static final boolean LOGGING_DISABLED_DEFAULT = false;
   private static final String LOGGING_DISABLED_KEY = "com.crashlytics.SilenceCrashlyticsLogCat";
   private static final String LOG_PRIORITY_NAME_ASSERT = "A";
   private static final String LOG_PRIORITY_NAME_DEBUG = "D";
   private static final String LOG_PRIORITY_NAME_ERROR = "E";
   private static final String LOG_PRIORITY_NAME_INFO = "I";
   private static final String LOG_PRIORITY_NAME_UNKNOWN = "?";
   private static final String LOG_PRIORITY_NAME_VERBOSE = "V";
   private static final String LOG_PRIORITY_NAME_WARN = "W";
   public static final String MD5_INSTANCE = "MD5";
   public static final String SDK = "sdk";
   public static final String SHA1_INSTANCE = "SHA-1";
   private static final long UNCALCULATED_TOTAL_RAM = -1L;
   private static Boolean clsTrace = null;
   private static Boolean loggingEnabled = null;
   private static long totalRamInBytes = -1L;

   public static long calculateFreeRamInBytes(Context var0) {
      MemoryInfo var1 = new MemoryInfo();
      ((ActivityManager)var0.getSystemService("activity")).getMemoryInfo(var1);
      return var1.availMem;
   }

   public static long calculateUsedDiskSpaceInBytes(String var0) {
      StatFs var3 = new StatFs(var0);
      long var1 = (long)var3.getBlockSize();
      return var1 * (long)var3.getBlockCount() - var1 * (long)var3.getAvailableBlocks();
   }

   public static boolean canTryConnection(Context var0) {
      if(checkPermission(var0, "android.permission.ACCESS_NETWORK_STATE")) {
         NetworkInfo var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
         if(var1 == null || !var1.isConnectedOrConnecting()) {
            return false;
         }
      }

      return true;
   }

   public static boolean checkPermission(Context var0, String var1) {
      return var0.checkCallingOrSelfPermission(var1) == 0;
   }

   public static void closeOrLog(Closeable var0, String var1) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            Fabric.getLogger().e("Fabric", var1, var2);
            return;
         }
      }

   }

   public static void closeQuietly(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (RuntimeException var1) {
            throw var1;
         } catch (Exception var2) {
            return;
         }
      }

   }

   static long convertMemInfoToBytes(String var0, String var1, int var2) {
      return Long.parseLong(var0.split(var1)[0].trim()) * (long)var2;
   }

   public static void copyStream(InputStream var0, OutputStream var1, byte[] var2) throws IOException {
      while(true) {
         int var3 = var0.read(var2);
         if(var3 == -1) {
            return;
         }

         var1.write(var2, 0, var3);
      }
   }

   @SuppressLint({"GetInstance"})
   public static Cipher createCipher(int var0, String var1) throws InvalidKeyException {
      if(var1.length() < 32) {
         throw new InvalidKeyException("Key must be at least 32 bytes.");
      } else {
         SecretKeySpec var4 = new SecretKeySpec(var1.getBytes(), 0, 32, "AES/ECB/PKCS7Padding");

         Cipher var2;
         try {
            var2 = Cipher.getInstance("AES/ECB/PKCS7Padding");
         } catch (GeneralSecurityException var3) {
            Fabric.getLogger().e("Fabric", "Could not create Cipher for AES/ECB/PKCS7Padding - should never happen.", var3);
            throw new RuntimeException(var3);
         }

         var2.init(var0, var4);
         return var2;
      }
   }

   public static String createInstanceIdFrom(String... var0) {
      if(var0 != null && var0.length != 0) {
         ArrayList var3 = new ArrayList();
         int var2 = var0.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            String var4 = var0[var1];
            if(var4 != null) {
               var3.add(var4.replace("-", "").toLowerCase(Locale.US));
            }
         }

         Collections.sort(var3);
         StringBuilder var5 = new StringBuilder();
         Iterator var7 = var3.iterator();

         while(var7.hasNext()) {
            var5.append((String)var7.next());
         }

         String var6 = var5.toString();
         if(var6.length() > 0) {
            return sha1(var6);
         }
      }

      return null;
   }

   public static byte[] dehexify(String var0) {
      int var2 = var0.length();
      byte[] var3 = new byte[var2 / 2];

      for(int var1 = 0; var1 < var2; var1 += 2) {
         var3[var1 / 2] = (byte)((Character.digit(var0.charAt(var1), 16) << 4) + Character.digit(var0.charAt(var1 + 1), 16));
      }

      return var3;
   }

   public static String extractFieldFromSystemFile(File param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   @TargetApi(16)
   public static void finishAffinity(Activity var0, int var1) {
      if(var0 != null) {
         if(VERSION.SDK_INT >= 16) {
            var0.finishAffinity();
         } else {
            var0.setResult(var1);
            var0.finish();
         }
      }
   }

   @TargetApi(16)
   public static void finishAffinity(Context var0, int var1) {
      if(var0 instanceof Activity) {
         finishAffinity((Activity)var0, var1);
      }

   }

   public static void flushOrLog(Flushable var0, String var1) {
      if(var0 != null) {
         try {
            var0.flush();
         } catch (IOException var2) {
            Fabric.getLogger().e("Fabric", var1, var2);
            return;
         }
      }

   }

   public static String getAppIconHashOrNull(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static int getAppIconResourceId(Context var0) {
      return var0.getApplicationContext().getApplicationInfo().icon;
   }

   public static RunningAppProcessInfo getAppProcessInfo(String var0, Context var1) {
      List var3 = ((ActivityManager)var1.getSystemService("activity")).getRunningAppProcesses();
      Object var2 = null;
      RunningAppProcessInfo var4 = (RunningAppProcessInfo)var2;
      if(var3 != null) {
         Iterator var5 = var3.iterator();

         do {
            var4 = (RunningAppProcessInfo)var2;
            if(!var5.hasNext()) {
               break;
            }

            var4 = (RunningAppProcessInfo)var5.next();
         } while(!var4.processName.equals(var0));
      }

      return var4;
   }

   public static float getBatteryLevel(Context var0) {
      Intent var3 = var0.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      int var1 = var3.getIntExtra("level", -1);
      int var2 = var3.getIntExtra("scale", -1);
      return (float)var1 / (float)var2;
   }

   public static int getBatteryVelocity(Context var0, boolean var1) {
      float var2 = getBatteryLevel(var0);
      return !var1?1:(var1 && (double)var2 >= 99.0D?3:(var1 && (double)var2 < 99.0D?2:0));
   }

   public static byte[] getBitmapBytes(Bitmap var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      var0.compress(CompressFormat.PNG, 100, var1);
      return var1.toByteArray();
   }

   public static boolean getBooleanResourceValue(Context var0, String var1, boolean var2) {
      boolean var4 = var2;
      if(var0 != null) {
         Resources var5 = var0.getResources();
         var4 = var2;
         if(var5 != null) {
            int var3 = getResourcesIdentifier(var0, var1, "bool");
            if(var3 > 0) {
               var4 = var5.getBoolean(var3);
            } else {
               var3 = getResourcesIdentifier(var0, var1, "string");
               var4 = var2;
               if(var3 > 0) {
                  return Boolean.parseBoolean(var0.getString(var3));
               }
            }
         }
      }

      return var4;
   }

   public static int getCpuArchitectureInt() {
      return CommonUtils.Architecture.getValue().ordinal();
   }

   public static int getDeviceState(Context var0) {
      int var2 = 0;
      if(isEmulator(var0)) {
         var2 = 0 | 1;
      }

      int var1 = var2;
      if(isRooted(var0)) {
         var1 = var2 | 2;
      }

      var2 = var1;
      if(isDebuggerAttached()) {
         var2 = var1 | 4;
      }

      return var2;
   }

   public static boolean getProximitySensorEnabled(Context var0) {
      return !isEmulator(var0) && ((SensorManager)var0.getSystemService("sensor")).getDefaultSensor(8) != null;
   }

   public static String getResourcePackageName(Context var0) {
      int var1 = var0.getApplicationContext().getApplicationInfo().icon;
      return var1 > 0?var0.getResources().getResourcePackageName(var1):var0.getPackageName();
   }

   public static int getResourcesIdentifier(Context var0, String var1, String var2) {
      return var0.getResources().getIdentifier(var1, var2, getResourcePackageName(var0));
   }

   public static SharedPreferences getSharedPrefs(Context var0) {
      return var0.getSharedPreferences("com.crashlytics.prefs", 0);
   }

   public static String getStringsFileValue(Context var0, String var1) {
      int var2 = getResourcesIdentifier(var0, var1, "string");
      return var2 > 0?var0.getString(var2):"";
   }

   public static long getTotalRamInBytes() {
      // $FF: Couldn't be decompiled
   }

   private static String hash(InputStream param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   private static String hash(String var0, String var1) {
      return hash(var0.getBytes(), var1);
   }

   private static String hash(byte[] var0, String var1) {
      MessageDigest var2;
      try {
         var2 = MessageDigest.getInstance(var1);
      } catch (NoSuchAlgorithmException var3) {
         Fabric.getLogger().e("Fabric", "Could not create hashing algorithm: " + var1 + ", returning empty string.", var3);
         return "";
      }

      var2.update(var0);
      return hexify(var2.digest());
   }

   public static String hexify(byte[] var0) {
      char[] var3 = new char[var0.length * 2];

      for(int var1 = 0; var1 < var0.length; ++var1) {
         int var2 = var0[var1] & 255;
         var3[var1 * 2] = HEX_VALUES[var2 >>> 4];
         var3[var1 * 2 + 1] = HEX_VALUES[var2 & 15];
      }

      return new String(var3);
   }

   public static void hideKeyboard(Context var0, View var1) {
      InputMethodManager var2 = (InputMethodManager)var0.getSystemService("input_method");
      if(var2 != null) {
         var2.hideSoftInputFromWindow(var1.getWindowToken(), 0);
      }

   }

   public static boolean isAppDebuggable(Context var0) {
      return (var0.getApplicationInfo().flags & 2) != 0;
   }

   public static boolean isClsTrace(Context var0) {
      if(clsTrace == null) {
         clsTrace = Boolean.valueOf(getBooleanResourceValue(var0, "com.crashlytics.Trace", false));
      }

      return clsTrace.booleanValue();
   }

   public static boolean isDebuggerAttached() {
      return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
   }

   public static boolean isEmulator(Context var0) {
      String var1 = Secure.getString(var0.getContentResolver(), "android_id");
      return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || var1 == null;
   }

   public static boolean isLoggingEnabled(Context var0) {
      boolean var1 = false;
      if(loggingEnabled == null) {
         if(!getBooleanResourceValue(var0, "com.crashlytics.SilenceCrashlyticsLogCat", false)) {
            var1 = true;
         }

         loggingEnabled = Boolean.valueOf(var1);
      }

      return loggingEnabled.booleanValue();
   }

   public static boolean isNullOrEmpty(String var0) {
      return var0 == null || var0.length() == 0;
   }

   public static boolean isRooted(Context var0) {
      boolean var1 = isEmulator(var0);
      String var2 = Build.TAGS;
      if((var1 || var2 == null || !var2.contains("test-keys")) && !(new File("/system/app/Superuser.apk")).exists()) {
         File var3 = new File("/system/xbin/su");
         if(var1 || !var3.exists()) {
            return false;
         }
      }

      return true;
   }

   public static void logControlled(Context var0, int var1, String var2, String var3) {
      if(isClsTrace(var0)) {
         Fabric.getLogger().log(var1, "Fabric", var3);
      }

   }

   public static void logControlled(Context var0, String var1) {
      if(isClsTrace(var0)) {
         Fabric.getLogger().d("Fabric", var1);
      }

   }

   public static void logControlledError(Context var0, String var1, Throwable var2) {
      if(isClsTrace(var0)) {
         Fabric.getLogger().e("Fabric", var1);
      }

   }

   public static void logOrThrowIllegalArgumentException(String var0, String var1) {
      if(Fabric.isDebuggable()) {
         throw new IllegalArgumentException(var1);
      } else {
         Fabric.getLogger().w(var0, var1);
      }
   }

   public static void logOrThrowIllegalStateException(String var0, String var1) {
      if(Fabric.isDebuggable()) {
         throw new IllegalStateException(var1);
      } else {
         Fabric.getLogger().w(var0, var1);
      }
   }

   public static String logPriorityToString(int var0) {
      switch(var0) {
      case 2:
         return "V";
      case 3:
         return "D";
      case 4:
         return "I";
      case 5:
         return "W";
      case 6:
         return "E";
      case 7:
         return "A";
      default:
         return "?";
      }
   }

   public static String md5(String var0) {
      return hash(var0, "MD5");
   }

   public static String md5(byte[] var0) {
      return hash(var0, "MD5");
   }

   public static void openKeyboard(Context var0, View var1) {
      InputMethodManager var2 = (InputMethodManager)var0.getSystemService("input_method");
      if(var2 != null) {
         var2.showSoftInputFromInputMethod(var1.getWindowToken(), 0);
      }

   }

   public static String padWithZerosToMaxIntWidth(int var0) {
      if(var0 < 0) {
         throw new IllegalArgumentException("value must be zero or greater");
      } else {
         return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(var0)}).replace(' ', '0');
      }
   }

   public static String resolveBuildId(Context var0) {
      String var3 = null;
      int var2 = getResourcesIdentifier(var0, "io.fabric.android.build_id", "string");
      int var1 = var2;
      if(var2 == 0) {
         var1 = getResourcesIdentifier(var0, "com.crashlytics.android.build_id", "string");
      }

      if(var1 != 0) {
         var3 = var0.getResources().getString(var1);
         Fabric.getLogger().d("Fabric", "Build ID is: " + var3);
      }

      return var3;
   }

   public static String sha1(InputStream var0) {
      return hash(var0, "SHA-1");
   }

   public static String sha1(String var0) {
      return hash(var0, "SHA-1");
   }

   public static String sha1(byte[] var0) {
      return hash(var0, "SHA-1");
   }

   public static String streamToString(InputStream var0) throws IOException {
      Scanner var1 = (new Scanner(var0)).useDelimiter("\\A");
      return var1.hasNext()?var1.next():"";
   }

   public static boolean stringsEqualIncludingNull(String var0, String var1) {
      return var0 == var1?true:(var0 != null?var0.equals(var1):false);
   }

   static enum Architecture {
      ARM64,
      ARMV6,
      ARMV7,
      ARMV7S,
      ARM_UNKNOWN,
      PPC,
      PPC64,
      UNKNOWN,
      X86_32,
      X86_64;

      private static final Map matcher;

      static {
         matcher = new HashMap(4);
         matcher.put("armeabi-v7a", ARMV7);
         matcher.put("armeabi", ARMV6);
         matcher.put("x86", X86_32);
      }

      static CommonUtils.Architecture getValue() {
         String var0 = Build.CPU_ABI;
         CommonUtils.Architecture var2;
         if(TextUtils.isEmpty(var0)) {
            Fabric.getLogger().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
            var2 = UNKNOWN;
         } else {
            var0 = var0.toLowerCase(Locale.US);
            CommonUtils.Architecture var1 = (CommonUtils.Architecture)matcher.get(var0);
            var2 = var1;
            if(var1 == null) {
               return UNKNOWN;
            }
         }

         return var2;
      }
   }
}
