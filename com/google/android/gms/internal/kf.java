package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.kc;

abstract class kf extends BaseImplementation.a {
   public kf(GoogleApiClient var1) {
      super(kc.DQ, var1);
   }

   abstract static class a extends kf {
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
