package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.om;
import com.google.android.gms.panorama.PanoramaApi;

public final class Panorama {
   public static final Api API;
   public static final Api.c DQ = new Api.c();
   static final Api.b DR = new Api.b() {
      // $FF: synthetic method
      public Api.a a(Context var1, Looper var2, jg var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.f(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public om f(Context var1, Looper var2, jg var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new om(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final PanoramaApi PanoramaApi;

   static {
      API = new Api(DR, DQ, new Scope[0]);
      PanoramaApi = new ol();
   }
}
