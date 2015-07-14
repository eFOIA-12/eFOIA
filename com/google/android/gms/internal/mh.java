package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.mp;

public class mh implements BleApi {
   public PendingResult claimBleDevice(final GoogleApiClient var1, final BleDevice var2) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.b)(new com.google.android.gms.fitness.request.b(var2)), (md)var2x, var3);
         }
      });
   }

   public PendingResult claimBleDevice(final GoogleApiClient var1, final String var2) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.b)(new com.google.android.gms.fitness.request.b(var2)), (md)var2x, var3);
         }
      });
   }

   public PendingResult listClaimedBleDevices(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new lu.a(var1) {
         protected void a(lu var1) throws RemoteException {
            mh.a var2 = new mh.a(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((mp)var2, var3);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.v(var1);
         }

         protected BleDevicesResult v(Status var1) {
            return BleDevicesResult.C(var1);
         }
      }));
   }

   public PendingResult startBleScan(final GoogleApiClient var1, final StartBleScanRequest var2) {
      return var1.a((BaseImplementation.a)(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((StartBleScanRequest)var2, (md)var2x, var3);
         }
      }));
   }

   public PendingResult stopBleScan(final GoogleApiClient var1, final BleScanCallback var2) {
      return var1.a((BaseImplementation.a)(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            com.google.android.gms.fitness.request.ad var4 = new com.google.android.gms.fitness.request.ad(var2);
            var1.jM().a((com.google.android.gms.fitness.request.ad)var4, (md)var2x, var3);
         }
      }));
   }

   public PendingResult unclaimBleDevice(GoogleApiClient var1, BleDevice var2) {
      return this.unclaimBleDevice(var1, var2.getAddress());
   }

   public PendingResult unclaimBleDevice(final GoogleApiClient var1, final String var2) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.ah)(new com.google.android.gms.fitness.request.ah(var2)), (md)var2x, var3);
         }
      });
   }

   private static class a extends mp.a {
      private final BaseImplementation.b Ea;

      private a(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      // $FF: synthetic method
      a(BaseImplementation.b var1, Object var2) {
         this(var1);
      }

      public void a(BleDevicesResult var1) {
         this.Ea.b(var1);
      }
   }
}
