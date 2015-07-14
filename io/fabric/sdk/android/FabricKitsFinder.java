package io.fabric.sdk.android;

import android.os.SystemClock;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.KitInfo;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class FabricKitsFinder implements Callable {
   private static final String FABRIC_BUILD_TYPE_KEY = "fabric-build-type";
   static final String FABRIC_DIR = ".fabric/";
   private static final String FABRIC_IDENTIFIER_KEY = "fabric-identifier";
   private static final String FABRIC_VERSION_KEY = "fabric-version";
   final String apkFileName;

   FabricKitsFinder(String var1) {
      this.apkFileName = var1;
   }

   private KitInfo loadKitInfo(ZipEntry param1, ZipFile param2) {
      // $FF: Couldn't be decompiled
   }

   public Map call() throws Exception {
      HashMap var5 = new HashMap();
      long var3 = SystemClock.elapsedRealtime();
      int var1 = 0;
      ZipFile var6 = this.loadApkFile();
      Enumeration var7 = var6.entries();

      while(var7.hasMoreElements()) {
         int var2 = var1 + 1;
         ZipEntry var8 = (ZipEntry)var7.nextElement();
         var1 = var2;
         if(var8.getName().startsWith(".fabric/")) {
            KitInfo var10 = this.loadKitInfo(var8, var6);
            var1 = var2;
            if(var10 != null) {
               var5.put(var10.getIdentifier(), var10);
               Fabric.getLogger().v("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{var10.getIdentifier(), var10.getVersion()}));
               var1 = var2;
            }
         }
      }

      if(var6 != null) {
         try {
            var6.close();
         } catch (IOException var9) {
            ;
         }
      }

      Fabric.getLogger().v("Fabric", "finish scanning in " + (System.currentTimeMillis() - var3) + " reading:" + var1);
      return var5;
   }

   protected ZipFile loadApkFile() throws IOException {
      return new ZipFile(this.apkFileName);
   }
}
