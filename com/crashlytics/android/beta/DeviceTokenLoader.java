package com.crashlytics.android.beta;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.services.cache.ValueLoader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeviceTokenLoader implements ValueLoader {
   private static final String DIRFACTOR_DEVICE_TOKEN_PREFIX = "assets/com.crashlytics.android.beta/dirfactor-device-token=";

   String determineDeviceToken(ZipInputStream var1) throws IOException {
      while(true) {
         ZipEntry var2 = var1.getNextEntry();
         if(var2 != null) {
            String var3 = var2.getName();
            if(!var3.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=")) {
               continue;
            }

            return var3.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), var3.length() - 1);
         }

         return "";
      }
   }

   ZipInputStream getZipInputStreamOfAppApkFrom(Context var1) throws NameNotFoundException, FileNotFoundException {
      return new ZipInputStream(new FileInputStream(var1.getPackageManager().getApplicationInfo(var1.getPackageName(), 0).sourceDir));
   }

   public String load(Context param1) throws Exception {
      // $FF: Couldn't be decompiled
   }
}
