package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nf;
import com.google.android.gms.internal.ng;
import com.google.android.gms.internal.nk;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.GeofencingApi;

public class LocationServices {
   public static final Api API;
   private static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      // $FF: synthetic method
      public Api.a a(Context var1, Looper var2, jg var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.e(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public nk e(Context var1, Looper var2, jg var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new nk(var1, var2, var1.getPackageName(), var5, var6, "locationServices", var3.getAccountName());
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static FusedLocationProviderApi FusedLocationApi;
   public static GeofencingApi GeofencingApi;

   static {
      API = new Api(DR, DQ, new Scope[0]);
      FusedLocationApi = new nf();
      GeofencingApi = new ng();
   }

   public static nk f(GoogleApiClient var0) {
      boolean var2 = true;
      boolean var1;
      if(var0 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      jx.b(var1, "GoogleApiClient parameter is required.");
      nk var3 = (nk)var0.a(DQ);
      if(var3 != null) {
         var1 = var2;
      } else {
         var1 = false;
      }

      jx.a(var1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }

   public abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(LocationServices.DQ, var1);
      }
   }
}
