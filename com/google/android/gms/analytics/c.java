package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.b;
import com.google.android.gms.internal.hb;
import java.util.List;
import java.util.Map;

class c implements b {
   private Context mContext;
   private ServiceConnection xV;
   private c.b xW;
   private c.c xX;
   private hb xY;

   public c(Context var1, c.b var2, c.c var3) {
      this.mContext = var1;
      if(var2 == null) {
         throw new IllegalArgumentException("onConnectedListener cannot be null");
      } else {
         this.xW = var2;
         if(var3 == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
         } else {
            this.xX = var3;
         }
      }
   }

   private hb dR() {
      this.dS();
      return this.xY;
   }

   private void dT() {
      this.dU();
   }

   private void dU() {
      this.xW.onConnected();
   }

   public void a(Map var1, long var2, String var4, List var5) {
      try {
         this.dR().a(var1, var2, var4, var5);
      } catch (RemoteException var6) {
         ae.T("sendHit failed: " + var6);
      }
   }

   public void connect() {
      Intent var2 = new Intent("com.google.android.gms.analytics.service.START");
      var2.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
      var2.putExtra("app_package_name", this.mContext.getPackageName());
      if(this.xV != null) {
         ae.T("Calling connect() while still connected, missing disconnect().");
      } else {
         this.xV = new c.a();
         boolean var1 = this.mContext.bindService(var2, this.xV, 129);
         ae.V("connect: bindService returned " + var1 + " for " + var2);
         if(!var1) {
            this.xV = null;
            this.xX.a(1, (Intent)null);
            return;
         }
      }

   }

   public void dQ() {
      try {
         this.dR().dQ();
      } catch (RemoteException var2) {
         ae.T("clear hits failed: " + var2);
      }
   }

   protected void dS() {
      if(!this.isConnected()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public void disconnect() {
      this.xY = null;
      if(this.xV != null) {
         try {
            this.mContext.unbindService(this.xV);
         } catch (IllegalStateException var2) {
            ;
         } catch (IllegalArgumentException var3) {
            ;
         }

         this.xV = null;
         this.xW.onDisconnected();
      }

   }

   public boolean isConnected() {
      return this.xY != null;
   }

   final class a implements ServiceConnection {
      public void onServiceConnected(ComponentName var1, IBinder var2) {
         ae.V("service connected, binder: " + var2);

         try {
            if("com.google.android.gms.analytics.internal.IAnalyticsService".equals(var2.getInterfaceDescriptor())) {
               ae.V("bound to service");
               c.this.xY = hb.a.D(var2);
               c.this.dT();
               return;
            }
         } catch (RemoteException var4) {
            ;
         }

         try {
            c.this.mContext.unbindService(this);
         } catch (IllegalArgumentException var3) {
            ;
         }

         c.this.xV = null;
         c.this.xX.a(2, (Intent)null);
      }

      public void onServiceDisconnected(ComponentName var1) {
         ae.V("service disconnected: " + var1);
         c.this.xV = null;
         c.this.xW.onDisconnected();
      }
   }

   public interface b {
      void onConnected();

      void onDisconnected();
   }

   public interface c {
      void a(int var1, Intent var2);
   }
}
