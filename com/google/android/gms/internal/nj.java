package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.np;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class nj {
   private final np Ee;
   private ContentProviderClient agS = null;
   private boolean agT = false;
   private HashMap agU = new HashMap();
   private final Context mContext;

   public nj(Context var1, np var2) {
      this.mContext = var1;
      this.Ee = var2;
   }

   private nj.b a(LocationListener param1, Looper param2) {
      // $FF: Couldn't be decompiled
   }

   public void S(boolean var1) throws RemoteException {
      this.Ee.dS();
      ((ni)this.Ee.hw()).S(var1);
      this.agT = var1;
   }

   public void a(LocationListener param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void a(LocationRequest var1, LocationListener var2, Looper var3) throws RemoteException {
      this.Ee.dS();
      nj.b var4 = this.a(var2, var3);
      ((ni)this.Ee.hw()).a((LocationRequest)var1, (com.google.android.gms.location.b)var4);
   }

   public void b(Location var1) throws RemoteException {
      this.Ee.dS();
      ((ni)this.Ee.hw()).b(var1);
   }

   public void b(LocationRequest var1, PendingIntent var2) throws RemoteException {
      this.Ee.dS();
      ((ni)this.Ee.hw()).a(var1, var2);
   }

   public void c(PendingIntent var1) throws RemoteException {
      this.Ee.dS();
      ((ni)this.Ee.hw()).b(var1);
   }

   public Location nl() {
      this.Ee.dS();

      try {
         Location var1 = ((ni)this.Ee.hw()).bZ(this.mContext.getPackageName());
         return var1;
      } catch (RemoteException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public void nm() {
      if(this.agT) {
         try {
            this.S(false);
         } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
         }
      }

   }

   public void removeAllListeners() {
      // $FF: Couldn't be decompiled
   }

   private static class a extends Handler {
      private final LocationListener agV;

      public a(LocationListener var1) {
         this.agV = var1;
      }

      public a(LocationListener var1, Looper var2) {
         super(var2);
         this.agV = var1;
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Location var2 = new Location((Location)var1.obj);
            this.agV.onLocationChanged(var2);
            return;
         default:
            Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
         }
      }
   }

   private static class b extends com.google.android.gms.location.b {
      private Handler agW;

      b(LocationListener var1, Looper var2) {
         nj.a var3;
         if(var2 == null) {
            var3 = new nj.a(var1);
         } else {
            var3 = new nj.a(var1, var2);
         }

         this.agW = var3;
      }

      public void onLocationChanged(Location var1) {
         if(this.agW == null) {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
         } else {
            Message var2 = Message.obtain();
            var2.what = 1;
            var2.obj = var1;
            this.agW.sendMessage(var2);
         }
      }

      public void release() {
         this.agW = null;
      }
   }
}
