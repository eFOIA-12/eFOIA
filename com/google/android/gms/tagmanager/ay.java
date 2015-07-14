package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.tagmanager.cz;
import java.util.HashMap;
import java.util.Map;

class ay {
   private static String arH;
   static Map arI = new HashMap();

   static void cH(String param0) {
      // $FF: Couldn't be decompiled
   }

   static void d(Context var0, String var1) {
      cz.a(var0, "gtm_install_referrer", "referrer", var1);
      f(var0, var1);
   }

   static String e(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   static String f(Context var0, String var1, String var2) {
      String var4 = (String)arI.get(var1);
      String var3 = var4;
      if(var4 == null) {
         SharedPreferences var5 = var0.getSharedPreferences("gtm_click_referrers", 0);
         String var6;
         if(var5 != null) {
            var6 = var5.getString(var1, "");
         } else {
            var6 = "";
         }

         arI.put(var1, var6);
         var3 = var6;
      }

      return w(var3, var2);
   }

   static void f(Context var0, String var1) {
      String var2 = w(var1, "conv");
      if(var2 != null && var2.length() > 0) {
         arI.put(var2, var1);
         cz.a(var0, "gtm_click_referrers", var2, var1);
      }

   }

   static String w(String var0, String var1) {
      return var1 == null?(var0.length() > 0?var0:null):Uri.parse("http://hostname/?" + var0).getQueryParameter(var1);
   }
}
