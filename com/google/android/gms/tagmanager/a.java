package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.tagmanager.bh;
import java.io.IOException;

class a {
   private static a aqa;
   private static Object xO = new Object();
   private volatile long apW;
   private volatile long apX;
   private volatile long apY;
   private a.a apZ;
   private volatile boolean mClosed;
   private final Context mContext;
   private final ld wb;
   private final Thread wu;
   private volatile AdvertisingIdClient.Info xQ;

   private a(Context var1) {
      this(var1, (a.a)null, lf.if());
   }

   a(Context var1, a.a var2, ld var3) {
      this.apW = 900000L;
      this.apX = 30000L;
      this.mClosed = false;
      this.apZ = new a.a() {
         public AdvertisingIdClient.Info pd() {
            try {
               AdvertisingIdClient.Info var1 = AdvertisingIdClient.getAdvertisingIdInfo(a.this.mContext);
               return var1;
            } catch (IllegalStateException var2) {
               bh.W("IllegalStateException getting Advertising Id Info");
               return null;
            } catch (GooglePlayServicesRepairableException var3) {
               bh.W("GooglePlayServicesRepairableException getting Advertising Id Info");
               return null;
            } catch (IOException var4) {
               bh.W("IOException getting Ad Id Info");
               return null;
            } catch (GooglePlayServicesNotAvailableException var5) {
               bh.W("GooglePlayServicesNotAvailableException getting Advertising Id Info");
               return null;
            } catch (Exception var6) {
               bh.W("Unknown exception. Could not get the Advertising Id Info.");
               return null;
            }
         }
      };
      this.wb = var3;
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      if(var2 != null) {
         this.apZ = var2;
      }

      this.wu = new Thread(new Runnable() {
         public void run() {
            a.this.pb();
         }
      });
   }

   static a W(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private void pb() {
      Process.setThreadPriority(10);

      while(!this.mClosed) {
         try {
            this.xQ = this.apZ.pd();
            Thread.sleep(this.apW);
         } catch (InterruptedException var2) {
            bh.U("sleep interrupted in AdvertiserDataPoller thread; continuing");
         }
      }

   }

   private void pc() {
      if(this.wb.currentTimeMillis() - this.apY >= this.apX) {
         this.interrupt();
         this.apY = this.wb.currentTimeMillis();
      }
   }

   void interrupt() {
      this.wu.interrupt();
   }

   public boolean isLimitAdTrackingEnabled() {
      this.pc();
      return this.xQ == null?true:this.xQ.isLimitAdTrackingEnabled();
   }

   public String pa() {
      this.pc();
      return this.xQ == null?null:this.xQ.getId();
   }

   void start() {
      this.wu.start();
   }

   public interface a {
      AdvertisingIdClient.Info pd();
   }
}
