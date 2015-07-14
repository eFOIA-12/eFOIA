package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.nk;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class nf implements FusedLocationProviderApi {
   public Location getLastLocation(GoogleApiClient var1) {
      nk var3 = LocationServices.f(var1);

      try {
         Location var4 = var3.nl();
         return var4;
      } catch (Exception var2) {
         return null;
      }
   }

   public PendingResult removeLocationUpdates(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.b(new nf.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.c(var2);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult removeLocationUpdates(final GoogleApiClient var1, final LocationListener var2) {
      return var1.b(new nf.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.a(var2);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult requestLocationUpdates(final GoogleApiClient var1, final LocationRequest var2, final PendingIntent var3) {
      return var1.b(new nf.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.b(var2, var3);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult requestLocationUpdates(final GoogleApiClient var1, final LocationRequest var2, final LocationListener var3) {
      return var1.b(new nf.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.a((LocationRequest)var2, (LocationListener)var3, (Looper)null);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult requestLocationUpdates(final GoogleApiClient var1, final LocationRequest var2, final LocationListener var3, final Looper var4) {
      return var1.b(new nf.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.a(var2, var3, var4);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult setMockLocation(final GoogleApiClient var1, final Location var2) {
      return var1.b(new nf.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.b(var2);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult setMockMode(final GoogleApiClient var1, final boolean var2) {
      return var1.b(new nf.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.S(var2);
            this.b(Status.Kw);
         }
      });
   }

   private abstract static class a extends LocationServices.a {
      public a(GoogleApiClient var1) {
         super(var1);
      }

      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }
}
