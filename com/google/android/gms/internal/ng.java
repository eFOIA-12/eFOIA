package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.nk;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class ng implements GeofencingApi {
   public PendingResult addGeofences(final GoogleApiClient var1, final GeofencingRequest var2, final PendingIntent var3) {
      return var1.b(new ng.a(var1) {
         protected void a(nk var1) throws RemoteException {
            com.google.android.gms.location.c var2x = new com.google.android.gms.location.c() {
               public void a(int var1, String[] var2x) {
                  b(LocationStatusCodes.eD(var1));
               }
            };
            var1.a(var2, var3, var2x);
         }
      });
   }

   @Deprecated
   public PendingResult addGeofences(GoogleApiClient var1, List var2, PendingIntent var3) {
      GeofencingRequest.Builder var4 = new GeofencingRequest.Builder();
      var4.addGeofences(var2);
      var4.setInitialTrigger(5);
      return this.addGeofences(var1, var4.build(), var3);
   }

   public PendingResult removeGeofences(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.b(new ng.a(var1) {
         protected void a(nk var1) throws RemoteException {
            com.google.android.gms.location.c var2x = new com.google.android.gms.location.c() {
               public void a(int var1, PendingIntent var2x) {
                  b(LocationStatusCodes.eD(var1));
               }

               public void b(int var1, String[] var2x) {
                  Log.wtf("GeofencingImpl", "Request ID callback shouldn\'t have been called");
               }
            };
            var1.a(var2, var2x);
         }
      });
   }

   public PendingResult removeGeofences(final GoogleApiClient var1, final List var2) {
      return var1.b(new ng.a(var1) {
         protected void a(nk var1) throws RemoteException {
            com.google.android.gms.location.c var2x = new com.google.android.gms.location.c() {
               public void a(int var1, PendingIntent var2x) {
                  Log.wtf("GeofencingImpl", "PendingIntent callback shouldn\'t have been called");
               }

               public void b(int var1, String[] var2x) {
                  b(LocationStatusCodes.eD(var1));
               }
            };
            var1.a(var2, var2x);
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
