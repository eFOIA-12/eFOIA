package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import com.google.android.gms.tagmanager.j;
import java.util.Map;

class ac extends aj {
   private static final String ID;
   private static final String arp;
   private static final String arq;
   private static final String arr;
   private static final String ars;

   static {
      ID = com.google.android.gms.internal.a.aa.toString();
      arp = com.google.android.gms.internal.b.bw.toString();
      arq = com.google.android.gms.internal.b.dH.toString();
      arr = com.google.android.gms.internal.b.de.toString();
      ars = com.google.android.gms.internal.b.dP.toString();
   }

   public ac() {
      super(ID, new String[]{arp});
   }

   public com.google.android.gms.internal.d B(Map var1) {
      com.google.android.gms.internal.d var3 = (com.google.android.gms.internal.d)var1.get(arp);
      if(var3 != null && var3 != di.rb()) {
         String var5 = di.j(var3);
         var3 = (com.google.android.gms.internal.d)var1.get(arr);
         String var4;
         if(var3 == null) {
            var4 = "text";
         } else {
            var4 = di.j(var3);
         }

         var3 = (com.google.android.gms.internal.d)var1.get(ars);
         String var10;
         if(var3 == null) {
            var10 = "base16";
         } else {
            var10 = di.j(var3);
         }

         com.google.android.gms.internal.d var7 = (com.google.android.gms.internal.d)var1.get(arq);
         byte var2;
         if(var7 != null && di.n(var7).booleanValue()) {
            var2 = 3;
         } else {
            var2 = 2;
         }

         byte[] var8;
         try {
            if("text".equals(var4)) {
               var8 = var5.getBytes();
            } else if("base16".equals(var4)) {
               var8 = j.co(var5);
            } else if("base64".equals(var4)) {
               var8 = Base64.decode(var5, var2);
            } else {
               if(!"base64url".equals(var4)) {
                  bh.T("Encode: unknown input format: " + var4);
                  var7 = di.rb();
                  return var7;
               }

               var8 = Base64.decode(var5, var2 | 8);
            }
         } catch (IllegalArgumentException var6) {
            bh.T("Encode: invalid input:");
            return di.rb();
         }

         String var9;
         if("base16".equals(var10)) {
            var9 = j.d(var8);
         } else if("base64".equals(var10)) {
            var9 = Base64.encodeToString(var8, var2);
         } else {
            if(!"base64url".equals(var10)) {
               bh.T("Encode: unknown output format: " + var10);
               return di.rb();
            }

            var9 = Base64.encodeToString(var8, var2 | 8);
         }

         return di.u(var9);
      } else {
         return di.rb();
      }
   }

   public boolean pe() {
      return true;
   }
}
