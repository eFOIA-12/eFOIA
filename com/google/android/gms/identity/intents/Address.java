package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mw;

public final class Address {
   public static final Api API;
   static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      public mw a(Context var1, Looper var2, jg var3, Address.AddressOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         jx.b(var1 instanceof Activity, "An Activity must be used for Address APIs");
         Address.AddressOptions var7 = var4;
         if(var4 == null) {
            var7 = new Address.AddressOptions();
         }

         return new mw((Activity)var1, var2, var5, var6, var3.getAccountName(), var7.theme);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(DR, DQ, new Scope[0]);
   }

   public static void requestUserAddress(final GoogleApiClient var0, final UserAddressRequest var1, final int var2) {
      var0.a((BaseImplementation.a)(new Address.a(var0) {
         protected void a(mw var1x) throws RemoteException {
            var1x.a(var1, var2);
            this.b(Status.Kw);
         }
      }));
   }

   public static final class AddressOptions implements Api.HasOptions {
      public final int theme;

      public AddressOptions() {
         this.theme = 0;
      }

      public AddressOptions(int var1) {
         this.theme = var1;
      }
   }

   private abstract static class a extends BaseImplementation.a {
      public a(GoogleApiClient var1) {
         super(Address.DQ, var1);
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
