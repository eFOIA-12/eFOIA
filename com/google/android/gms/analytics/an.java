package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.q;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class an {
   private static final char[] CC = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

   static String E(boolean var0) {
      return var0?"1":"0";
   }

   public static double a(String var0, double var1) {
      if(var0 == null) {
         return var1;
      } else {
         try {
            double var3 = Double.parseDouble(var0);
            return var3;
         } catch (NumberFormatException var5) {
            return var1;
         }
      }
   }

   public static String a(Locale var0) {
      if(var0 != null && !TextUtils.isEmpty(var0.getLanguage())) {
         StringBuilder var1 = new StringBuilder();
         var1.append(var0.getLanguage().toLowerCase());
         if(!TextUtils.isEmpty(var0.getCountry())) {
            var1.append("-").append(var0.getCountry().toLowerCase());
         }

         return var1.toString();
      } else {
         return null;
      }
   }

   public static void a(Map var0, String var1, q var2) {
      if(!var0.containsKey(var1)) {
         var0.put(var1, var2.getValue(var1));
      }

   }

   public static void a(Map var0, String var1, String var2) {
      if(!var0.containsKey(var1)) {
         var0.put(var1, var2);
      }

   }

   public static Map an(String var0) {
      HashMap var3 = new HashMap();
      String[] var5 = var0.split("&");
      int var2 = var5.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         String[] var4 = var5[var1].split("=");
         if(var4.length > 1) {
            var3.put(var4[0], var4[1]);
         } else if(var4.length == 1 && var4[0].length() != 0) {
            var3.put(var4[0], (Object)null);
         }
      }

      return var3;
   }

   public static String ao(String var0) {
      if(TextUtils.isEmpty(var0)) {
         return null;
      } else {
         String var2 = var0;
         if(var0.contains("?")) {
            String[] var3 = var0.split("[\\?]");
            var2 = var0;
            if(var3.length > 1) {
               var2 = var3[1];
            }
         }

         if(var2.contains("%3D")) {
            try {
               var0 = URLDecoder.decode(var2, "UTF-8");
            } catch (UnsupportedEncodingException var4) {
               return null;
            }
         } else {
            var0 = var2;
            if(!var2.contains("=")) {
               return null;
            }
         }

         Map var5 = an(var0);
         String[] var6 = new String[]{"dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t"};
         StringBuilder var7 = new StringBuilder();

         for(int var1 = 0; var1 < var6.length; ++var1) {
            if(!TextUtils.isEmpty((CharSequence)var5.get(var6[var1]))) {
               if(var7.length() > 0) {
                  var7.append("&");
               }

               var7.append(var6[var1]).append("=").append((String)var5.get(var6[var1]));
            }
         }

         return var7.toString();
      }
   }

   public static MessageDigest ap(String var0) {
      for(int var1 = 0; var1 < 2; ++var1) {
         MessageDigest var2;
         try {
            var2 = MessageDigest.getInstance(var0);
         } catch (NoSuchAlgorithmException var3) {
            continue;
         }

         if(var2 != null) {
            return var2;
         }
      }

      return null;
   }

   public static boolean f(String var0, boolean var1) {
      boolean var2 = var1;
      if(var0 != null) {
         if(!var0.equalsIgnoreCase("true") && !var0.equalsIgnoreCase("yes") && !var0.equalsIgnoreCase("1")) {
            if(!var0.equalsIgnoreCase("false") && !var0.equalsIgnoreCase("no")) {
               var2 = var1;
               if(!var0.equalsIgnoreCase("0")) {
                  return var2;
               }
            }

            return false;
         } else {
            var2 = true;
         }
      }

      return var2;
   }
}
