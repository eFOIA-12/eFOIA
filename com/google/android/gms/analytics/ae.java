package com.google.android.gms.analytics;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;

public class ae {
   private static GoogleAnalytics BL;
   private static volatile boolean BM = false;
   private static Logger BN;

   public static void T(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.error(var0);
      }

   }

   public static void U(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.info(var0);
      }

   }

   public static void V(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.verbose(var0);
      }

   }

   public static void W(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.warn(var0);
      }

   }

   public static boolean ff() {
      boolean var1 = false;
      boolean var0 = var1;
      if(getLogger() != null) {
         var0 = var1;
         if(getLogger().getLogLevel() == 0) {
            var0 = true;
         }
      }

      return var0;
   }

   static Logger getLogger() {
      // $FF: Couldn't be decompiled
   }
}
