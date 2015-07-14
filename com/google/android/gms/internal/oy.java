package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jx;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;

public final class oy implements Account {
   private static com.google.android.gms.plus.internal.e a(GoogleApiClient var0, Api.c var1) {
      boolean var3 = true;
      boolean var2;
      if(var0 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.b(var2, "GoogleApiClient parameter is required.");
      jx.a(var0.isConnected(), "GoogleApiClient must be connected.");
      com.google.android.gms.plus.internal.e var4 = (com.google.android.gms.plus.internal.e)var0.a(var1);
      if(var4 != null) {
         var2 = var3;
      } else {
         var2 = false;
      }

      jx.a(var2, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return var4;
   }

   public void clearDefaultAccount(GoogleApiClient var1) {
      a(var1, Plus.DQ).clearDefaultAccount();
   }

   public String getAccountName(GoogleApiClient var1) {
      return a(var1, Plus.DQ).getAccountName();
   }

   public PendingResult revokeAccessAndDisconnect(final GoogleApiClient var1) {
      return var1.b(new oy.a(var1, null) {
         protected void a(com.google.android.gms.plus.internal.e var1) {
            var1.l((BaseImplementation.b)this);
         }
      });
   }

   private abstract static class a extends Plus.a {
      private a(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      a(GoogleApiClient var1, Object var2) {
         this(var1);
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
