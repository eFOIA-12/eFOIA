package com.parallel6.captivereachconnectsdk.utils;

public class UrlUtils {
   public static String appendHttp(String var0) {
      String var1;
      if(var0 == null) {
         var1 = "";
      } else {
         var1 = var0;
         if(!var0.startsWith("http://")) {
            return "http://" + var0;
         }
      }

      return var1;
   }

   public static String appendSlash(String var0) {
      String var1;
      if(var0 == null) {
         var1 = "";
      } else {
         var1 = var0;
         if(!var0.endsWith("/")) {
            return var0 + "/";
         }
      }

      return var1;
   }
}
