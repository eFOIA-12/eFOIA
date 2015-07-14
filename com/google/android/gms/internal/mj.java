package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.md;

public class mj implements HistoryApi {
   public PendingResult deleteData(final GoogleApiClient var1, final DataDeleteRequest var2) {
      return var1.a((BaseImplementation.a)(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((DataDeleteRequest)var2, (md)var2x, var3);
         }
      }));
   }

   public PendingResult insertData(final GoogleApiClient var1, final DataSet var2) {
      return var1.a((BaseImplementation.a)(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.e)(new com.google.android.gms.fitness.request.e()).b(var2).jU(), (md)var2x, var3);
         }
      }));
   }

   public PendingResult readData(final GoogleApiClient var1, final DataReadRequest var2) {
      return var1.a((BaseImplementation.a)(new lu.a(var1) {
         protected void a(lu var1) throws RemoteException {
            mj.a var2x = new mj.a(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((DataReadRequest)var2, (lw)var2x, var3);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.x(var1);
         }

         protected DataReadResult x(Status var1) {
            return DataReadResult.a(var1, var2);
         }
      }));
   }

   private static class a extends lw.a {
      private final BaseImplementation.b Ea;
      private int Vi;
      private DataReadResult Vj;

      private a(BaseImplementation.b var1) {
         this.Vi = 0;
         this.Vj = null;
         this.Ea = var1;
      }

      // $FF: synthetic method
      a(BaseImplementation.b var1, Object var2) {
         this(var1);
      }

      public void a(DataReadResult param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
