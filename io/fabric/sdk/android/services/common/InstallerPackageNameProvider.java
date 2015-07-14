package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

public class InstallerPackageNameProvider {
   private static final String NO_INSTALLER_PACKAGE_NAME = "";
   private final MemoryValueCache installerPackageNameCache = new MemoryValueCache();
   private final ValueLoader installerPackageNameLoader = new ValueLoader() {
      public String load(Context var1) throws Exception {
         String var2 = var1.getPackageManager().getInstallerPackageName(var1.getPackageName());
         String var3 = var2;
         if(var2 == null) {
            var3 = "";
         }

         return var3;
      }
   };

   public String getInstallerPackageName(Context var1) {
      boolean var2;
      String var4;
      try {
         var4 = (String)this.installerPackageNameCache.get(var1, this.installerPackageNameLoader);
         var2 = "".equals(var4);
      } catch (Exception var3) {
         Fabric.getLogger().e("Fabric", "Failed to determine installer package name", var3);
         return null;
      }

      if(var2) {
         var4 = null;
      }

      return var4;
   }
}
