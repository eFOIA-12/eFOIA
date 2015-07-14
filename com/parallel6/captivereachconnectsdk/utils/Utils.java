package com.parallel6.captivereachconnectsdk.utils;

import android.annotation.TargetApi;
import android.os.StrictMode;
import android.os.Build.VERSION;
import android.os.StrictMode.ThreadPolicy.Builder;

public class Utils {
   @TargetApi(11)
   public static void enableStrictMode() {
      if(hasGingerbread()) {
         Builder var0 = (new Builder()).detectAll().penaltyLog();
         android.os.StrictMode.VmPolicy.Builder var1 = (new android.os.StrictMode.VmPolicy.Builder()).detectAll().penaltyLog();
         if(hasHoneycomb()) {
            var0.penaltyFlashScreen();
         }

         StrictMode.setThreadPolicy(var0.build());
         StrictMode.setVmPolicy(var1.build());
      }

   }

   public static boolean hasFroyo() {
      return VERSION.SDK_INT >= 8;
   }

   public static boolean hasGingerbread() {
      return VERSION.SDK_INT >= 9;
   }

   public static boolean hasHoneycomb() {
      return VERSION.SDK_INT >= 11;
   }

   public static boolean hasHoneycombMR1() {
      return VERSION.SDK_INT >= 12;
   }

   public static boolean hasJellyBean() {
      return VERSION.SDK_INT >= 16;
   }
}
