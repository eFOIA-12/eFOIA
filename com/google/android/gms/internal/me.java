package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class me implements PendingResult {
   private final Result UU;

   me(Result var1) {
      this.UU = var1;
   }

   public void a(PendingResult.a var1) {
      var1.m(this.UU.getStatus());
   }

   public Result await() {
      return this.UU;
   }

   public Result await(long var1, TimeUnit var3) {
      return this.UU;
   }

   public void cancel() {
   }

   public boolean isCanceled() {
      return false;
   }

   public void setResultCallback(ResultCallback var1) {
      var1.onResult(this.UU);
   }

   public void setResultCallback(ResultCallback var1, long var2, TimeUnit var4) {
      var1.onResult(this.UU);
   }
}
