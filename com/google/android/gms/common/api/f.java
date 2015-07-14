package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class f extends BaseImplementation.AbstractPendingResult {
   public f(Looper var1) {
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
