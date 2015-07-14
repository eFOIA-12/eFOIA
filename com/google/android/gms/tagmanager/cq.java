package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.pu;
import com.google.android.gms.internal.qw;
import com.google.android.gms.tagmanager.ba;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.ce;
import com.google.android.gms.tagmanager.cr;
import com.google.android.gms.tagmanager.o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cq implements o.f {
   private final String aqm;
   private bg asC;
   private final ExecutorService asJ;
   private final Context mContext;

   cq(Context var1, String var2) {
      this.mContext = var1;
      this.aqm = var2;
      this.asJ = Executors.newSingleThreadExecutor();
   }

   private cr.c a(ByteArrayOutputStream var1) {
      try {
         cr.c var4 = ba.cI(var1.toString("UTF-8"));
         return var4;
      } catch (UnsupportedEncodingException var2) {
         bh.S("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
         return null;
      } catch (JSONException var3) {
         bh.W("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn\'t contain a JSON container");
         return null;
      }
   }

   private void d(pu.a var1) throws IllegalArgumentException {
      if(var1.gs == null && var1.auC == null) {
         throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
      }
   }

   private cr.c k(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(bg var1) {
      this.asC = var1;
   }

   public void b(final pu.a var1) {
      this.asJ.execute(new Runnable() {
         public void run() {
            cq.this.c(var1);
         }
      });
   }

   boolean c(pu.a var1) {
      File var3 = this.qj();

      FileOutputStream var2;
      try {
         var2 = new FileOutputStream(var3);
      } catch (FileNotFoundException var11) {
         bh.T("Error opening resource file for writing");
         return false;
      }

      try {
         var2.write(qw.f(var1));
         return true;
      } catch (IOException var12) {
         bh.W("Error writing resource to disk. Removing resource from disk.");
         var3.delete();
      } finally {
         try {
            var2.close();
         } catch (IOException var10) {
            bh.W("error closing stream for writing resource to disk");
         }

      }

      return false;
   }

   public cr.c fH(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void pt() {
      this.asJ.execute(new Runnable() {
         public void run() {
            cq.this.qi();
         }
      });
   }

   void qi() {
      if(this.asC == null) {
         throw new IllegalStateException("Callback must be set before execute");
      } else {
         this.asC.ps();
         bh.V("Attempting to load resource from disk");
         if((ce.qa().qb() == ce.a.asr || ce.qa().qb() == ce.a.ass) && this.aqm.equals(ce.qa().getContainerId())) {
            this.asC.a(bg.a.arV);
         } else {
            FileInputStream var1;
            try {
               var1 = new FileInputStream(this.qj());
            } catch (FileNotFoundException var15) {
               bh.S("Failed to find the resource in the disk");
               this.asC.a(bg.a.arV);
               return;
            }

            try {
               ByteArrayOutputStream var2 = new ByteArrayOutputStream();
               cr.b(var1, var2);
               pu.a var16 = pu.a.l(var2.toByteArray());
               this.d(var16);
               this.asC.l(var16);
            } catch (IOException var12) {
               this.asC.a(bg.a.arW);
               bh.W("Failed to read the resource from disk");
            } catch (IllegalArgumentException var13) {
               this.asC.a(bg.a.arW);
               bh.W("Failed to read the resource from disk. The resource is inconsistent");
            } finally {
               try {
                  var1.close();
               } catch (IOException var11) {
                  bh.W("Error closing stream for reading resource from disk");
               }

            }

            bh.V("The Disk resource was successfully read.");
         }
      }
   }

   File qj() {
      String var1 = "resource_" + this.aqm;
      return new File(this.mContext.getDir("google_tagmanager", 0), var1);
   }

   public void release() {
      synchronized(this){}

      try {
         this.asJ.shutdown();
      } finally {
         ;
      }

   }
}
