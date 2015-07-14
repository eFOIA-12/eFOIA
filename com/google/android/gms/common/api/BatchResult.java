package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
   private final Status Eb;
   private final PendingResult[] JC;

   BatchResult(Status var1, PendingResult[] var2) {
      this.Eb = var1;
      this.JC = var2;
   }

   public Status getStatus() {
      return this.Eb;
   }

   public Result take(BatchResultToken var1) {
      boolean var2;
      if(var1.mId < this.JC.length) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.b(var2, "The result token does not belong to this batch");
      return this.JC[var1.mId].await(0L, TimeUnit.MILLISECONDS);
   }
}
