package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mz;
import com.google.android.gms.internal.nc;
import com.google.android.gms.internal.nh;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.nj;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class nk extends nc {
   private final nj agX;
   private final mz agY;
   private final ie agZ;

   public nk(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6) {
      this(var1, var2, var3, var4, var5, var6, (String)null);
   }

   public nk(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String var7) {
      this(var1, var2, var3, var4, var5, var6, var7, (String)null);
   }

   public nk(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String var7, String var8) {
      super(var1, var2, var4, var5, var6);
      this.agX = new nj(var1, this.Ee);
      this.agY = mz.a(var1, var7, var8, this.Ee);
      this.agZ = ie.a(var1, this.Ee);
   }

   public void S(boolean var1) throws RemoteException {
      this.agX.S(var1);
   }

   public void a(long var1, PendingIntent var3) throws RemoteException {
      this.dS();
      jx.i(var3);
      boolean var4;
      if(var1 >= 0L) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.b(var4, "detectionIntervalMillis must be >= 0");
      ((ni)this.hw()).a(var1, true, var3);
   }

   public void a(PendingIntent var1) throws RemoteException {
      this.dS();
      jx.i(var1);
      ((ni)this.hw()).a(var1);
   }

   public void a(PendingIntent var1, com.google.android.gms.location.c var2) throws RemoteException {
      this.dS();
      jx.b((Object)var1, "PendingIntent must be specified.");
      jx.b((Object)var2, "OnRemoveGeofencesResultListener not provided.");
      nk.b var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new nk.b(var2, this);
      }

      ((ni)this.hw()).a((PendingIntent)var1, (nh)var3, (String)this.getContext().getPackageName());
   }

   public void a(GeofencingRequest var1, PendingIntent var2, com.google.android.gms.location.c var3) throws RemoteException {
      this.dS();
      jx.b((Object)var1, "geofencingRequest can\'t be null.");
      jx.b((Object)var2, "PendingIntent must be specified.");
      jx.b((Object)var3, "OnAddGeofencesResultListener not provided.");
      nk.b var4;
      if(var3 == null) {
         var4 = null;
      } else {
         var4 = new nk.b(var3, this);
      }

      ((ni)this.hw()).a((GeofencingRequest)var1, (PendingIntent)var2, (nh)var4);
   }

   public void a(LocationListener var1) throws RemoteException {
      this.agX.a(var1);
   }

   public void a(LocationRequest param1, LocationListener param2, Looper param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void a(List var1, com.google.android.gms.location.c var2) throws RemoteException {
      this.dS();
      boolean var3;
      if(var1 != null && var1.size() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      jx.b(var3, "geofenceRequestIds can\'t be null nor empty.");
      jx.b((Object)var2, "OnRemoveGeofencesResultListener not provided.");
      String[] var4 = (String[])var1.toArray(new String[0]);
      nk.b var5;
      if(var2 == null) {
         var5 = null;
      } else {
         var5 = new nk.b(var2, this);
      }

      ((ni)this.hw()).a((String[])var4, (nh)var5, (String)this.getContext().getPackageName());
   }

   public void b(Location var1) throws RemoteException {
      this.agX.b(var1);
   }

   public void b(LocationRequest var1, PendingIntent var2) throws RemoteException {
      this.agX.b(var1, var2);
   }

   public void c(PendingIntent var1) throws RemoteException {
      this.agX.c(var1);
   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   public Location nl() {
      return this.agX.nl();
   }

   private final class a extends jl.b {
      private final int Iv;
      private final String[] aha;

      public a(com.google.android.gms.location.c var2, int var3, String[] var4) {
         super();
         this.Iv = LocationStatusCodes.eC(var3);
         this.aha = var4;
      }

      protected void a(com.google.android.gms.location.c var1) {
         if(var1 != null) {
            var1.a(this.Iv, this.aha);
         }

      }

      // $FF: synthetic method
      protected void g(Object var1) {
         this.a((com.google.android.gms.location.c)var1);
      }

      protected void hx() {
      }
   }

   private static final class b extends nh.a {
      private com.google.android.gms.location.c ahc;
      private com.google.android.gms.location.c ahd;
      private nk ahe;

      public b(com.google.android.gms.location.c var1, nk var2) {
         this.ahc = var1;
         this.ahd = null;
         this.ahe = var2;
      }

      public b(com.google.android.gms.location.c var1, nk var2) {
         this.ahd = var1;
         this.ahc = null;
         this.ahe = var2;
      }

      public void a(int var1, PendingIntent var2) {
         if(this.ahe == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
         } else {
            nk var3 = this.ahe;
            nk var4 = this.ahe;
            var3.a((jl.b)(var4.new c(1, this.ahd, var1, var2)));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
         }
      }

      public void a(int var1, String[] var2) throws RemoteException {
         if(this.ahe == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
         } else {
            nk var3 = this.ahe;
            nk var4 = this.ahe;
            var3.a((jl.b)(var4.new a(this.ahc, var1, var2)));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
         }
      }

      public void b(int var1, String[] var2) {
         if(this.ahe == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
         } else {
            nk var3 = this.ahe;
            nk var4 = this.ahe;
            var3.a((jl.b)(var4.new c(2, this.ahd, var1, var2)));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
         }
      }
   }

   private final class c extends jl.b {
      private final int Iv;
      private final String[] aha;
      private final int ahf;
      private final PendingIntent mPendingIntent;

      public c(int var2, com.google.android.gms.location.c var3, int var4, PendingIntent var5) {
         boolean var6 = true;
         super();
         if(var2 != 1) {
            var6 = false;
         }

         je.K(var6);
         this.ahf = var2;
         this.Iv = LocationStatusCodes.eC(var4);
         this.mPendingIntent = var5;
         this.aha = null;
      }

      public c(int var2, com.google.android.gms.location.c var3, int var4, String[] var5) {
         super();
         boolean var6;
         if(var2 == 2) {
            var6 = true;
         } else {
            var6 = false;
         }

         je.K(var6);
         this.ahf = var2;
         this.Iv = LocationStatusCodes.eC(var4);
         this.aha = var5;
         this.mPendingIntent = null;
      }

      protected void a(com.google.android.gms.location.c var1) {
         if(var1 != null) {
            switch(this.ahf) {
            case 1:
               var1.a(this.Iv, this.mPendingIntent);
               return;
            case 2:
               var1.b(this.Iv, this.aha);
               return;
            default:
               Log.wtf("LocationClientImpl", "Unsupported action: " + this.ahf);
            }
         }

      }

      // $FF: synthetic method
      protected void g(Object var1) {
         this.a((com.google.android.gms.location.c)var1);
      }

      protected void hx() {
      }
   }
}
