package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.bm;
import com.google.android.gms.tagmanager.bn;
import com.google.android.gms.tagmanager.ce;
import com.google.android.gms.tagmanager.cr;
import com.google.android.gms.tagmanager.r;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class co implements Runnable {
   private volatile String aqI;
   private final String aqm;
   private final bn asA;
   private final String asB;
   private bg asC;
   private volatile r asD;
   private volatile String asE;
   private final Context mContext;

   co(Context var1, String var2, bn var3, r var4) {
      this.mContext = var1;
      this.asA = var3;
      this.aqm = var2;
      this.asD = var4;
      this.asB = "/r?id=" + var2;
      this.aqI = this.asB;
      this.asE = null;
   }

   public co(Context var1, String var2, r var3) {
      this(var1, var2, new bn(), var3);
   }

   private boolean qd() {
      NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         bh.V("...no network connectivity");
         return false;
      }
   }

   private void qe() {
      if(!this.qd()) {
         this.asC.a(bg.a.arV);
      } else {
         bh.V("Start loading resource from network ...");
         String var2 = this.qf();
         bm var1 = this.asA.pO();

         try {
            InputStream var3;
            try {
               var3 = var1.cF(var2);
            } catch (FileNotFoundException var10) {
               bh.W("No data is retrieved from the given url: " + var2 + ". Make sure container_id: " + this.aqm + " is correct.");
               this.asC.a(bg.a.arX);
               return;
            } catch (IOException var11) {
               bh.d("Error when loading resources from url: " + var2 + " " + var11.getMessage(), var11);
               this.asC.a(bg.a.arW);
               return;
            }

            try {
               ByteArrayOutputStream var4 = new ByteArrayOutputStream();
               cr.b(var3, var4);
               com.google.android.gms.internal.c var13 = com.google.android.gms.internal.c.b(var4.toByteArray());
               bh.V("Successfully loaded supplemented resource: " + var13);
               if(var13.gs == null && var13.gr.length == 0) {
                  bh.V("No change for container: " + this.aqm);
               }

               this.asC.l(var13);
            } catch (IOException var9) {
               bh.d("Error when parsing downloaded resources from url: " + var2 + " " + var9.getMessage(), var9);
               this.asC.a(bg.a.arX);
               return;
            }
         } finally {
            var1.close();
         }

         bh.V("Load resource from network finished.");
      }
   }

   void a(bg var1) {
      this.asC = var1;
   }

   void cL(String var1) {
      bh.S("Setting previous container version: " + var1);
      this.asE = var1;
   }

   void cw(String var1) {
      if(var1 == null) {
         this.aqI = this.asB;
      } else {
         bh.S("Setting CTFE URL path: " + var1);
         this.aqI = var1;
      }
   }

   String qf() {
      String var2 = this.asD.pu() + this.aqI + "&v=a65833898";
      String var1 = var2;
      if(this.asE != null) {
         var1 = var2;
         if(!this.asE.trim().equals("")) {
            var1 = var2 + "&pv=" + this.asE;
         }
      }

      var2 = var1;
      if(ce.qa().qb().equals(ce.a.ass)) {
         var2 = var1 + "&gtm_debug=x";
      }

      return var2;
   }

   public void run() {
      if(this.asC == null) {
         throw new IllegalStateException("callback must be set before execute");
      } else {
         this.asC.ps();
         this.qe();
      }
   }
}
