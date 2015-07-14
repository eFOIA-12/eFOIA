package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.ly;
import com.google.android.gms.internal.md;

public class mi implements ConfigApi {
   public PendingResult createCustomDataType(final GoogleApiClient var1, final DataTypeCreateRequest var2) {
      return var1.b(new lu.a(var1) {
         protected void a(lu var1) throws RemoteException {
            mi.a var2x = new mi.a(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((DataTypeCreateRequest)var2, (ly)var2x, var3);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.w(var1);
         }

         protected DataTypeResult w(Status var1) {
            return DataTypeResult.E(var1);
         }
      });
   }

   public PendingResult disableFit(final GoogleApiClient var1) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2 = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((md)var2, var3);
         }
      });
   }

   public PendingResult readDataType(final GoogleApiClient var1, String var2) {
      return var1.a((BaseImplementation.a)(new lu.a(var1) {
         // $FF: synthetic field
         final com.google.android.gms.fitness.request.j Vd;

         {
            this.Vd = var3;
         }

         protected void a(lu var1) throws RemoteException {
            mi.a var2 = new mi.a(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.j)this.Vd, (ly)var2, var3);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.w(var1);
         }

         protected DataTypeResult w(Status var1) {
            return DataTypeResult.E(var1);
         }
      }));
   }

   private static class a extends ly.a {
      private final BaseImplementation.b Ea;

      private a(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      // $FF: synthetic method
      a(BaseImplementation.b var1, Object var2) {
         this(var1);
      }

      public void a(DataTypeResult var1) {
         this.Ea.b(var1);
      }
   }
}
