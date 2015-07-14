package org.apache.http.util;

import java.util.ArrayList;
import java.util.Map;
import org.apache.http.util.Args;

public class VersionInfo {
   public static final String PROPERTY_MODULE = "info.module";
   public static final String PROPERTY_RELEASE = "info.release";
   public static final String PROPERTY_TIMESTAMP = "info.timestamp";
   public static final String UNAVAILABLE = "UNAVAILABLE";
   public static final String VERSION_PROPERTY_FILE = "version.properties";
   private final String infoClassloader;
   private final String infoModule;
   private final String infoPackage;
   private final String infoRelease;
   private final String infoTimestamp;

   protected VersionInfo(String var1, String var2, String var3, String var4, String var5) {
      Args.notNull(var1, "Package identifier");
      this.infoPackage = var1;
      if(var2 == null) {
         var2 = "UNAVAILABLE";
      }

      this.infoModule = var2;
      if(var3 == null) {
         var3 = "UNAVAILABLE";
      }

      this.infoRelease = var3;
      if(var4 == null) {
         var4 = "UNAVAILABLE";
      }

      this.infoTimestamp = var4;
      if(var5 == null) {
         var5 = "UNAVAILABLE";
      }

      this.infoClassloader = var5;
   }

   protected static VersionInfo fromMap(String var0, Map var1, ClassLoader var2) {
      Args.notNull(var0, "Package identifier");
      String var6 = null;
      String var7 = null;
      String var4 = null;
      String var8;
      if(var1 != null) {
         var4 = (String)var1.get("info.module");
         String var3 = var4;
         if(var4 != null) {
            var3 = var4;
            if(var4.length() < 1) {
               var3 = null;
            }
         }

         var4 = (String)var1.get("info.release");
         String var5 = var4;
         if(var4 != null) {
            label31: {
               if(var4.length() >= 1) {
                  var5 = var4;
                  if(!var4.equals("${pom.version}")) {
                     break label31;
                  }
               }

               var5 = null;
            }
         }

         var8 = (String)var1.get("info.timestamp");
         var6 = var3;
         var7 = var5;
         var4 = var8;
         if(var8 != null) {
            label26: {
               if(var8.length() >= 1) {
                  var6 = var3;
                  var7 = var5;
                  var4 = var8;
                  if(!var8.equals("${mvn.timestamp}")) {
                     break label26;
                  }
               }

               var4 = null;
               var7 = var5;
               var6 = var3;
            }
         }
      }

      var8 = null;
      if(var2 != null) {
         var8 = var2.toString();
      }

      return new VersionInfo(var0, var6, var7, var4, var8);
   }

   public static String getUserAgent(String var0, String var1, Class var2) {
      VersionInfo var3 = loadVersionInfo(var1, var2.getClassLoader());
      if(var3 != null) {
         var1 = var3.getRelease();
      } else {
         var1 = "UNAVAILABLE";
      }

      String var4 = System.getProperty("java.version");
      return var0 + "/" + var1 + " (Java 1.5 minimum; Java/" + var4 + ")";
   }

   public static VersionInfo loadVersionInfo(String param0, ClassLoader param1) {
      // $FF: Couldn't be decompiled
   }

   public static VersionInfo[] loadVersionInfo(String[] var0, ClassLoader var1) {
      Args.notNull(var0, "Package identifier array");
      ArrayList var4 = new ArrayList(var0.length);
      int var3 = var0.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         VersionInfo var5 = loadVersionInfo(var0[var2], var1);
         if(var5 != null) {
            var4.add(var5);
         }
      }

      return (VersionInfo[])var4.toArray(new VersionInfo[var4.size()]);
   }

   public final String getClassloader() {
      return this.infoClassloader;
   }

   public final String getModule() {
      return this.infoModule;
   }

   public final String getPackage() {
      return this.infoPackage;
   }

   public final String getRelease() {
      return this.infoRelease;
   }

   public final String getTimestamp() {
      return this.infoTimestamp;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
      var1.append("VersionInfo(").append(this.infoPackage).append(':').append(this.infoModule);
      if(!"UNAVAILABLE".equals(this.infoRelease)) {
         var1.append(':').append(this.infoRelease);
      }

      if(!"UNAVAILABLE".equals(this.infoTimestamp)) {
         var1.append(':').append(this.infoTimestamp);
      }

      var1.append(')');
      if(!"UNAVAILABLE".equals(this.infoClassloader)) {
         var1.append('@').append(this.infoClassloader);
      }

      return var1.toString();
   }
}
