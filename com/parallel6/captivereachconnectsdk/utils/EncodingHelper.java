package com.parallel6.captivereachconnectsdk.utils;

import java.nio.charset.Charset;

public class EncodingHelper {
   public static final String ISO_8859_1_ENCODING = "ISO-8859-1";
   public static final String UTF_8_ENCODING = "UTF-8";
   public static final String WINDOWS_1251_ENCODING = "Windows-1251";

   public static String encodeFromTo(String var0, String var1, String var2) {
      try {
         var0 = new String(var0.getBytes(var1), Charset.forName(var2));
         return var0;
      } catch (Exception var3) {
         var3.printStackTrace();
         return "";
      }
   }
}
