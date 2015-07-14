package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.me;

public class mm implements SensorsApi {
   private PendingResult a(final GoogleApiClient var1, final com.google.android.gms.fitness.request.o var2) {
      return var1.a((BaseImplementation.a)(new mm.a(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.o)var2, (md)var2x, var3);
         }

         protected Status b(Status var1) {
            return var1;
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.b(var1);
         }
      }));
   }

   private PendingResult a(final GoogleApiClient var1, final com.google.android.gms.fitness.request.q var2, final mm.b var3) {
      return var1.b(new mm.a(var1) {
         protected void a(lu var1) throws RemoteException {
            mm.d var2x = new mm.d(this, var3, null);
            String var3x = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.q)var2, (md)var2x, var3x);
         }

         protected Status b(Status var1) {
            return var1;
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.b(var1);
         }
      });
   }

   public PendingResult add(GoogleApiClient var1, SensorRequest var2, PendingIntent var3) {
      return this.a(var1, new com.google.android.gms.fitness.request.o(var2, (com.google.android.gms.fitness.data.k)null, var3));
   }

   public PendingResult add(GoogleApiClient var1, SensorRequest var2, OnDataPointListener var3) {
      return this.a(var1, new com.google.android.gms.fitness.request.o(var2, com.google.android.gms.fitness.data.l.jG().a(var3), (PendingIntent)null));
   }

   public PendingResult findDataSources(final GoogleApiClient var1, final DataSourcesRequest var2) {
      return var1.a((BaseImplementation.a)(new mm.a(var1) {
         protected void a(lu var1) throws RemoteException {
            mm.c var2x = new mm.c(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((DataSourcesRequest)var2, (lx)var2x, var3);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.z(var1);
         }

         protected DataSourcesResult z(Status var1) {
            return DataSourcesResult.D(var1);
         }
      }));
   }

   public PendingResult remove(GoogleApiClient var1, PendingIntent var2) {
      return this.a(var1, new com.google.android.gms.fitness.request.q((com.google.android.gms.fitness.data.k)null, var2), (mm.b)null);
   }

   public PendingResult remove(GoogleApiClient var1, final OnDataPointListener var2) {
      com.google.android.gms.fitness.data.l var3 = com.google.android.gms.fitness.data.l.jG().b(var2);
      return (PendingResult)(var3 == null?new me(Status.Kw):this.a(var1, new com.google.android.gms.fitness.request.q(var3, (PendingIntent)null), new mm.b() {
         public void jO() {
            com.google.android.gms.fitness.data.l.jG().c(var2);
         }
      }));
   }

   private abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(Fitness.DQ, var1);
      }
   }

   private interface b {
      void jO();
   }

   private static class c extends lx.a {
      private final BaseImplementation.b Ea;

      private c(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      // $FF: synthetic method
      c(BaseImplementation.b var1, Object var2) {
         this(var1);
      }

      public void a(DataSourcesResult var1) {
         this.Ea.b(var1);
      }
   }

   private static class d extends md.a {
      private final BaseImplementation.b Ea;
      private final mm.b Vu;

      private d(BaseImplementation.b var1, mm.b var2) {
         this.Ea = var1;
         this.Vu = var2;
      }

      // $FF: synthetic method
      d(BaseImplementation.b var1, mm.b var2, Object var3) {
         this(var1, var2);
      }

      public void j(Status var1) {
         if(this.Vu != null && var1.isSuccess()) {
            this.Vu.jO();
         }

         this.Ea.b(var1);
      }
   }
}
