package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public interface PendingResult {
   void a(PendingResult.a var1);

   Result await();

   Result await(long var1, TimeUnit var3);

   void cancel();

   boolean isCanceled();

   void setResultCallback(ResultCallback var1);

   void setResultCallback(ResultCallback var1, long var2, TimeUnit var4);

   public interface a {
      void m(Status var1);
   }
}
