package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lz;
import com.google.android.gms.internal.md;

public interface lu extends Api.a {
   Context getContext();

   lz jM() throws DeadObjectException;

   public abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(Fitness.DQ, var1);
      }
   }

   public static class b extends md.a {
      private final BaseImplementation.b Ea;

      public b(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void j(Status var1) {
         this.Ea.b(var1);
      }
   }

   public abstract static class c extends lu.a {
      c(GoogleApiClient var1) {
         super(var1);
      }

      protected Status b(Status var1) {
         boolean var2;
         if(!var1.isSuccess()) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.L(var2);
         return var1;
      }

      // $FF: synthetic method
      protected Result c(Status var1) {
         return this.b(var1);
      }
   }
}
