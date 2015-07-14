package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import com.google.android.gms.tagmanager.j;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
   private static final String ID;
   private static final String arp;
   private static final String arr;
   private static final String arv;

   static {
      ID = com.google.android.gms.internal.a.ac.toString();
      arp = com.google.android.gms.internal.b.bw.toString();
      arv = com.google.android.gms.internal.b.bn.toString();
      arr = com.google.android.gms.internal.b.de.toString();
   }

   public ao() {
      super(ID, new String[]{arp});
   }

   private byte[] d(String var1, byte[] var2) throws NoSuchAlgorithmException {
      MessageDigest var3 = MessageDigest.getInstance(var1);
      var3.update(var2);
      return var3.digest();
   }

   public com.google.android.gms.internal.d B(Map var1) {
      com.google.android.gms.internal.d var2 = (com.google.android.gms.internal.d)var1.get(arp);
      if(var2 != null && var2 != di.rb()) {
         String var3 = di.j(var2);
         var2 = (com.google.android.gms.internal.d)var1.get(arv);
         String var7;
         if(var2 == null) {
            var7 = "MD5";
         } else {
            var7 = di.j(var2);
         }

         com.google.android.gms.internal.d var5 = (com.google.android.gms.internal.d)var1.get(arr);
         String var6;
         if(var5 == null) {
            var6 = "text";
         } else {
            var6 = di.j(var5);
         }

         byte[] var8;
         if("text".equals(var6)) {
            var8 = var3.getBytes();
         } else {
            if(!"base16".equals(var6)) {
               bh.T("Hash: unknown input format: " + var6);
               return di.rb();
            }

            var8 = j.co(var3);
         }

         try {
            var5 = di.u(j.d(this.d(var7, var8)));
            return var5;
         } catch (NoSuchAlgorithmException var4) {
            bh.T("Hash: unknown algorithm: " + var7);
            return di.rb();
         }
      } else {
         return di.rb();
      }
   }

   public boolean pe() {
      return true;
   }
}
