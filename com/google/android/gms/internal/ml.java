package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.md;

public class ml implements RecordingApi {
   private PendingResult a(final GoogleApiClient var1, final com.google.android.gms.fitness.request.m var2) {
      return var1.a((BaseImplementation.a)(new lu.a(var1) {
         protected void a(lu var1) throws RemoteException {
            ml.a var2x = new ml.a(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.m)var2, (ma)var2x, var3);
         }

         // $FF: synthetic method
         protected Result c(Status var1) {
            return this.y(var1);
         }

         protected ListSubscriptionsResult y(Status var1) {
            return ListSubscriptionsResult.F(var1);
         }
      }));
   }

   public PendingResult a(final GoogleApiClient var1, final com.google.android.gms.fitness.request.af var2) {
      return var1.a((BaseImplementation.a)(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.af)var2, (md)var2x, var3);
         }
      }));
   }

   public PendingResult a(final GoogleApiClient var1, final com.google.android.gms.fitness.request.aj var2) {
      return var1.b(new lu.c(var1) {
         protected void a(lu var1) throws RemoteException {
            lu.b var2x = new lu.b(this);
            String var3 = var1.getContext().getPackageName();
            var1.jM().a((com.google.android.gms.fitness.request.aj)var2, (md)var2x, var3);
         }
      });
   }

   public PendingResult listSubscriptions(GoogleApiClient var1) {
      return this.a(var1, (new com.google.android.gms.fitness.request.m()).ka());
   }

   public PendingResult listSubscriptions(GoogleApiClient var1, DataType var2) {
      return this.a(var1, (new com.google.android.gms.fitness.request.m()).c(var2).ka());
   }

   public PendingResult subscribe(GoogleApiClient var1, DataSource var2) {
      return this.a(var1, (new com.google.android.gms.fitness.request.af()).b((new Subscription.a()).b(var2).jK()).kp());
   }

   public PendingResult subscribe(GoogleApiClient var1, DataType var2) {
      return this.a(var1, (new com.google.android.gms.fitness.request.af()).b((new Subscription.a()).b(var2).jK()).kp());
   }

   public PendingResult unsubscribe(GoogleApiClient var1, DataSource var2) {
      return this.a(var1, (new com.google.android.gms.fitness.request.aj()).d(var2).kq());
   }

   public PendingResult unsubscribe(GoogleApiClient var1, DataType var2) {
      return this.a(var1, (new com.google.android.gms.fitness.request.aj()).d(var2).kq());
   }

   public PendingResult unsubscribe(GoogleApiClient var1, Subscription var2) {
      return var2.getDataType() == null?this.unsubscribe(var1, var2.getDataSource()):this.unsubscribe(var1, var2.getDataType());
   }

   private static class a extends ma.a {
      private final BaseImplementation.b Ea;

      private a(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      // $FF: synthetic method
      a(BaseImplementation.b var1, Object var2) {
         this(var1);
      }

      public void a(ListSubscriptionsResult var1) {
         this.Ea.b(var1);
      }
   }
}
