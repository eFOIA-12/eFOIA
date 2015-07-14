package io.fabric.sdk.android.services.network;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.TreeMap;

public final class UrlUtils {
   public static final String UTF8 = "UTF8";

   public static TreeMap getQueryParams(String var0, boolean var1) {
      TreeMap var4 = new TreeMap();
      if(var0 != null) {
         String[] var6 = var0.split("&");
         int var3 = var6.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            String[] var5 = var6[var2].split("=");
            if(var5.length == 2) {
               if(var1) {
                  var4.put(urlDecode(var5[0]), urlDecode(var5[1]));
               } else {
                  var4.put(var5[0], var5[1]);
               }
            } else if(!TextUtils.isEmpty(var5[0])) {
               if(var1) {
                  var4.put(urlDecode(var5[0]), "");
               } else {
                  var4.put(var5[0], "");
               }
            }
         }
      }

      return var4;
   }

   public static TreeMap getQueryParams(URI var0, boolean var1) {
      return getQueryParams(var0.getRawQuery(), var1);
   }

   public static String percentEncode(String var0) {
      if(var0 == null) {
         return "";
      } else {
         StringBuilder var4 = new StringBuilder();
         var0 = urlEncode(var0);
         int var3 = var0.length();

         for(int var2 = 0; var2 < var3; ++var2) {
            char var1 = var0.charAt(var2);
            if(var1 == 42) {
               var4.append("%2A");
            } else if(var1 == 43) {
               var4.append("%20");
            } else if(var1 == 37 && var2 + 2 < var3 && var0.charAt(var2 + 1) == 55 && var0.charAt(var2 + 2) == 69) {
               var4.append('~');
               var2 += 2;
            } else {
               var4.append(var1);
            }
         }

         return var4.toString();
      }
   }

   public static String urlDecode(String var0) {
      if(var0 == null) {
         return "";
      } else {
         try {
            var0 = URLDecoder.decode(var0, "UTF8");
            return var0;
         } catch (UnsupportedEncodingException var1) {
            throw new RuntimeException(var1.getMessage(), var1);
         }
      }
   }

   public static String urlEncode(String var0) {
      if(var0 == null) {
         return "";
      } else {
         try {
            var0 = URLEncoder.encode(var0, "UTF8");
            return var0;
         } catch (UnsupportedEncodingException var1) {
            throw new RuntimeException(var1.getMessage(), var1);
         }
      }
   }
}
