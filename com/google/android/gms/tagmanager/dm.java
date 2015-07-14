package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.bz;
import com.google.android.gms.tagmanager.di;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dm {
   private static bz a(bz var0) {
      try {
         bz var1 = new bz(di.u(dg(di.j((com.google.android.gms.internal.d)var0.getObject()))), var0.pX());
         return var1;
      } catch (UnsupportedEncodingException var2) {
         bh.b("Escape URI: unsupported encoding", var2);
         return var0;
      }
   }

   private static bz a(bz var0, int var1) {
      if(!q((com.google.android.gms.internal.d)var0.getObject())) {
         bh.T("Escaping can only be applied to strings.");
         return var0;
      } else {
         switch(var1) {
         case 12:
            return a(var0);
         default:
            bh.T("Unsupported Value Escaping: " + var1);
            return var0;
         }
      }
   }

   static bz a(bz var0, int... var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0 = a(var0, var1[var2]);
      }

      return var0;
   }

   static String dg(String var0) throws UnsupportedEncodingException {
      return URLEncoder.encode(var0, "UTF-8").replaceAll("\\+", "%20");
   }

   private static boolean q(com.google.android.gms.internal.d var0) {
      return di.o(var0) instanceof String;
   }
}
