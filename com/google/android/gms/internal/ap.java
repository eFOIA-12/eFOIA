package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.ao;
import com.google.android.gms.internal.aq;
import com.google.android.gms.internal.ar;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.gr;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class ap {
   private final int nT;
   private final int nU;
   private final ao nV = new ar();
   private Base64OutputStream nW;
   private ByteArrayOutputStream nX;

   public ap(int var1) {
      this.nU = var1;
      this.nT = 6;
   }

   private String m(String var1) {
      String[] var6 = var1.split("\n");
      if(var6 != null && var6.length != 0) {
         this.nX = new ByteArrayOutputStream();
         this.nW = new Base64OutputStream(this.nX, 10);
         Arrays.sort(var6, new Comparator() {
            public int compare(String var1, String var2) {
               return var2.length() - var1.length();
            }
         });

         for(int var2 = 0; var2 < var6.length && var2 < this.nU; ++var2) {
            if(var6[var2].trim().length() != 0) {
               try {
                  this.nW.write(this.nV.l(var6[var2]));
               } catch (IOException var5) {
                  gr.b("Error while writing hash to byteStream", var5);
               }
            }
         }

         try {
            this.nW.flush();
            this.nW.close();
            var1 = this.nX.toString();
            return var1;
         } catch (IOException var4) {
            gr.b("HashManager: Unable to convert to base 64", var4);
            return "";
         }
      } else {
         return "";
      }
   }

   public String a(ArrayList var1) {
      StringBuffer var2 = new StringBuffer();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.append(((String)var3.next()).toLowerCase(Locale.US));
         var2.append('\n');
      }

      switch(0) {
      case 0:
         return this.n(var2.toString());
      case 1:
         return this.m(var2.toString());
      default:
         return "";
      }
   }

   String n(String var1) {
      String[] var7 = var1.split("\n");
      if(var7 != null && var7.length != 0) {
         this.nX = new ByteArrayOutputStream();
         this.nW = new Base64OutputStream(this.nX, 10);
         PriorityQueue var3 = new PriorityQueue(this.nU, new Comparator() {
            public int a(as.a var1, as.a var2) {
               return (int)(var1.value - var2.value);
            }

            // $FF: synthetic method
            public int compare(Object var1, Object var2) {
               return this.a((as.a)var1, (as.a)var2);
            }
         });

         for(int var2 = 0; var2 < var7.length; ++var2) {
            String[] var4 = aq.p(var7[var2]);
            if(var4.length >= this.nT) {
               as.a(var4, this.nU, this.nT, var3);
            }
         }

         Iterator var8 = var3.iterator();

         while(var8.hasNext()) {
            as.a var9 = (as.a)var8.next();

            try {
               this.nW.write(this.nV.l(var9.oa));
            } catch (IOException var6) {
               gr.b("Error while writing hash to byteStream", var6);
            }
         }

         try {
            this.nW.flush();
            this.nW.close();
            var1 = this.nX.toString();
            return var1;
         } catch (IOException var5) {
            gr.b("HashManager: unable to convert to base 64", var5);
            return "";
         }
      } else {
         return "";
      }
   }
}
