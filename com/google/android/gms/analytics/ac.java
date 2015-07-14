package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ac {
   public static String a(ab var0, long var1) {
      StringBuilder var3 = new StringBuilder();
      var3.append(var0.fa());
      if(var0.fc() > 0L) {
         var1 -= var0.fc();
         if(var1 >= 0L) {
            var3.append("&qt").append("=").append(var1);
         }
      }

      var3.append("&z").append("=").append(var0.fb());
      return var3.toString();
   }

   public static String encode(String var0) {
      try {
         String var1 = URLEncoder.encode(var0, "UTF-8");
         return var1;
      } catch (UnsupportedEncodingException var2) {
         throw new AssertionError("URL encoding failed for: " + var0);
      }
   }

   static Map z(Map var0) {
      HashMap var1 = new HashMap();
      Iterator var4 = var0.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var2 = (Entry)var4.next();
         if(((String)var2.getKey()).startsWith("&") && var2.getValue() != null) {
            String var3 = ((String)var2.getKey()).substring(1);
            if(!TextUtils.isEmpty(var3)) {
               var1.put(var3, var2.getValue());
            }
         }
      }

      return var1;
   }
}
