package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import com.google.android.gms.tagmanager.dm;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class az extends aj {
   private static final String ID;
   private static final String arJ;
   private static final String arK;
   private static final String arL;
   private static final String arp;

   static {
      ID = com.google.android.gms.internal.a.ae.toString();
      arp = com.google.android.gms.internal.b.bw.toString();
      arJ = com.google.android.gms.internal.b.di.toString();
      arK = com.google.android.gms.internal.b.dm.toString();
      arL = com.google.android.gms.internal.b.cH.toString();
   }

   public az() {
      super(ID, new String[]{arp});
   }

   private String a(String var1, az.a var2, Set var3) {
      switch(null.arM[var2.ordinal()]) {
      case 1:
         try {
            String var6 = dm.dg(var1);
            return var6;
         } catch (UnsupportedEncodingException var4) {
            bh.b("Joiner: unsupported encoding", var4);
            return var1;
         }
      case 2:
         var1 = var1.replace("\\", "\\\\");

         String var7;
         for(Iterator var5 = var3.iterator(); var5.hasNext(); var1 = var1.replace(var7, "\\" + var7)) {
            var7 = ((Character)var5.next()).toString();
         }

         return var1;
      default:
         return var1;
      }
   }

   private void a(StringBuilder var1, String var2, az.a var3, Set var4) {
      var1.append(this.a(var2, var3, var4));
   }

   private void a(Set var1, String var2) {
      for(int var3 = 0; var3 < var2.length(); ++var3) {
         var1.add(Character.valueOf(var2.charAt(var3)));
      }

   }

   public com.google.android.gms.internal.d B(Map var1) {
      com.google.android.gms.internal.d var8 = (com.google.android.gms.internal.d)var1.get(arp);
      if(var8 == null) {
         return di.rb();
      } else {
         com.google.android.gms.internal.d var5 = (com.google.android.gms.internal.d)var1.get(arJ);
         String var6;
         if(var5 != null) {
            var6 = di.j(var5);
         } else {
            var6 = "";
         }

         var5 = (com.google.android.gms.internal.d)var1.get(arK);
         String var7;
         if(var5 != null) {
            var7 = di.j(var5);
         } else {
            var7 = "=";
         }

         az.a var15 = az.a.arN;
         com.google.android.gms.internal.d var12 = (com.google.android.gms.internal.d)var1.get(arL);
         HashSet var14;
         if(var12 != null) {
            String var13 = di.j(var12);
            if("url".equals(var13)) {
               var15 = az.a.arO;
               var14 = null;
            } else {
               if(!"backslash".equals(var13)) {
                  bh.T("Joiner: unsupported escape type: " + var13);
                  return di.rb();
               }

               var15 = az.a.arP;
               var14 = new HashSet();
               this.a(var14, var6);
               this.a(var14, var7);
               var14.remove(Character.valueOf('\\'));
            }
         } else {
            var14 = null;
         }

         StringBuilder var9 = new StringBuilder();
         int var2;
         switch(var8.type) {
         case 2:
            boolean var3 = true;
            com.google.android.gms.internal.d[] var16 = var8.gw;
            int var4 = var16.length;

            for(var2 = 0; var2 < var4; var3 = false) {
               var8 = var16[var2];
               if(!var3) {
                  var9.append(var6);
               }

               this.a(var9, di.j(var8), var15, var14);
               ++var2;
            }

            return di.u(var9.toString());
         case 3:
            for(var2 = 0; var2 < var8.gx.length; ++var2) {
               if(var2 > 0) {
                  var9.append(var6);
               }

               String var10 = di.j(var8.gx[var2]);
               String var11 = di.j(var8.gy[var2]);
               this.a(var9, var10, var15, var14);
               var9.append(var7);
               this.a(var9, var11, var15, var14);
            }

            return di.u(var9.toString());
         default:
            this.a(var9, di.j(var8), var15, var14);
            return di.u(var9.toString());
         }
      }
   }

   public boolean pe() {
      return true;
   }

   private static enum a {
      arN,
      arO,
      arP;
   }
}
