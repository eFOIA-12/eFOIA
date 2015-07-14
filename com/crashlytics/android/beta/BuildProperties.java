package com.crashlytics.android.beta;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class BuildProperties {
   private static final String BUILD_ID = "build_id";
   private static final String PACKAGE_NAME = "package_name";
   private static final String VERSION_CODE = "version_code";
   private static final String VERSION_NAME = "version_name";
   public final String buildId;
   public final String packageName;
   public final String versionCode;
   public final String versionName;

   BuildProperties(String var1, String var2, String var3, String var4) {
      this.versionCode = var1;
      this.versionName = var2;
      this.buildId = var3;
      this.packageName = var4;
   }

   public static BuildProperties fromProperties(Properties var0) {
      return new BuildProperties(var0.getProperty("version_code"), var0.getProperty("version_name"), var0.getProperty("build_id"), var0.getProperty("package_name"));
   }

   public static BuildProperties fromPropertiesStream(InputStream var0) throws IOException {
      Properties var1 = new Properties();
      var1.load(var0);
      return fromProperties(var1);
   }
}
