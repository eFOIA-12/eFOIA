package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
   com.google.android.gms.common.a ln;
   s lo;
   boolean lp;
   Object lq;
   AdvertisingIdClient.a lr;
   final long ls;
   private final Context mContext;

   public AdvertisingIdClient(Context var1) {
      this(var1, 30000L);
   }

   public AdvertisingIdClient(Context var1, long var2) {
      this.lq = new Object();
      jx.i(var1);
      this.mContext = var1;
      this.lp = false;
      this.ls = var2;
   }

   private void Z() {
      // $FF: Couldn't be decompiled
   }

   static s a(Context var0, com.google.android.gms.common.a var1) throws IOException {
      try {
         s var3 = s.a.b(var1.gs());
         return var3;
      } catch (InterruptedException var2) {
         throw new IOException("Interrupted exception");
      }
   }

   public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context var0) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      AdvertisingIdClient var4 = new AdvertisingIdClient(var0, -1L);

      AdvertisingIdClient.Info var1;
      try {
         var4.b(false);
         var1 = var4.getInfo();
      } finally {
         var4.finish();
      }

      return var1;
   }

   static com.google.android.gms.common.a h(Context var0) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      try {
         var0.getPackageManager().getPackageInfo("com.android.vending", 0);
      } catch (NameNotFoundException var4) {
         throw new GooglePlayServicesNotAvailableException(9);
      }

      try {
         GooglePlayServicesUtil.C(var0);
      } catch (GooglePlayServicesNotAvailableException var3) {
         throw new IOException(var3);
      }

      com.google.android.gms.common.a var1 = new com.google.android.gms.common.a();
      Intent var2 = new Intent("com.google.android.gms.ads.identifier.service.START");
      var2.setPackage("com.google.android.gms");
      if(var0.bindService(var2, var1, 1)) {
         return var1;
      } else {
         throw new IOException("Connection failure");
      }
   }

   protected void b(boolean param1) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      // $FF: Couldn't be decompiled
   }

   protected void finalize() throws Throwable {
      this.finish();
      super.finalize();
   }

   public void finish() {
      // $FF: Couldn't be decompiled
   }

   public AdvertisingIdClient.Info getInfo() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      this.b(true);
   }

   public static final class Info {
      private final String lx;
      private final boolean ly;

      public Info(String var1, boolean var2) {
         this.lx = var1;
         this.ly = var2;
      }

      public String getId() {
         return this.lx;
      }

      public boolean isLimitAdTrackingEnabled() {
         return this.ly;
      }

      public String toString() {
         return "{" + this.lx + "}" + this.ly;
      }
   }

   static class a extends Thread {
      private WeakReference lt;
      private long lu;
      CountDownLatch lv;
      boolean lw;

      public a(AdvertisingIdClient var1, long var2) {
         this.lt = new WeakReference(var1);
         this.lu = var2;
         this.lv = new CountDownLatch(1);
         this.lw = false;
         this.start();
      }

      private void disconnect() {
         AdvertisingIdClient var1 = (AdvertisingIdClient)this.lt.get();
         if(var1 != null) {
            var1.finish();
            this.lw = true;
         }

      }

      public boolean aa() {
         return this.lw;
      }

      public void cancel() {
         this.lv.countDown();
      }

      public void run() {
         try {
            if(!this.lv.await(this.lu, TimeUnit.MILLISECONDS)) {
               this.disconnect();
            }

         } catch (InterruptedException var2) {
            this.disconnect();
         }
      }
   }
}
