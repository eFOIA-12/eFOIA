package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.ht;
import com.google.android.gms.internal.hx;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.jg;

public final class hc {
   public static final Api.c CG = new Api.c();
   private static final Api.b CH = new Api.b() {
      public hx a(Context var1, Looper var2, jg var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new hx(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final Api CI;
   public static final ht CJ;

   static {
      CI = new Api(CH, CG, new Scope[0]);
      CJ = new hz();
   }
}
