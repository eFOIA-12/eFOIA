package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

abstract class q extends BaseImplementation.a {
   public q(GoogleApiClient var1) {
      super(Drive.DQ, var1);
   }

   abstract static class a extends q {
      a(GoogleApiClient var1) {
         super(var1);
      }

      protected Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      protected Result c(Status var1) {
         return this.b(var1);
      }
   }
}
