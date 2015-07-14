package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BaseImplementation.AbstractPendingResult {
   private boolean JA;
   private boolean JB;
   private final PendingResult[] JC;
   private int Jz;
   private final Object mH;

   private Batch(List var1, Looper var2) {
      super(new BaseImplementation.CallbackHandler(var2));
      this.mH = new Object();
      this.Jz = var1.size();
      this.JC = new PendingResult[this.Jz];

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         PendingResult var4 = (PendingResult)var1.get(var3);
         this.JC[var3] = var4;
         var4.a(new PendingResult.a() {
            public void m(Status param1) {
               // $FF: Couldn't be decompiled
            }
         });
      }

   }

   // $FF: synthetic method
   Batch(List var1, Looper var2, Object var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static Object a(Batch var0) {
      return var0.mH;
   }

   // $FF: synthetic method
   static boolean a(Batch var0, boolean var1) {
      var0.JB = var1;
      return var1;
   }

   // $FF: synthetic method
   static int b(Batch var0) {
      int var1 = var0.Jz;
      var0.Jz = var1 - 1;
      return var1;
   }

   // $FF: synthetic method
   static boolean b(Batch var0, boolean var1) {
      var0.JA = var1;
      return var1;
   }

   // $FF: synthetic method
   static int c(Batch var0) {
      return var0.Jz;
   }

   // $FF: synthetic method
   static boolean d(Batch var0) {
      return var0.JB;
   }

   // $FF: synthetic method
   static void e(Batch var0) {
      var0.cancel();
   }

   // $FF: synthetic method
   static boolean f(Batch var0) {
      return var0.JA;
   }

   // $FF: synthetic method
   static PendingResult[] g(Batch var0) {
      return var0.JC;
   }

   // $FF: synthetic method
   public Result c(Status var1) {
      return this.createFailedResult(var1);
   }

   public void cancel() {
      super.cancel();
      PendingResult[] var3 = this.JC;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         var3[var1].cancel();
      }

   }

   public BatchResult createFailedResult(Status var1) {
      return new BatchResult(var1, this.JC);
   }

   public static final class Builder {
      private List JE = new ArrayList();
      private Looper JF;

      public Builder(GoogleApiClient var1) {
         this.JF = var1.getLooper();
      }

      public BatchResultToken add(PendingResult var1) {
         BatchResultToken var2 = new BatchResultToken(this.JE.size());
         this.JE.add(var1);
         return var2;
      }

      public Batch build() {
         return new Batch(this.JE, this.JF, null);
      }
   }
}
