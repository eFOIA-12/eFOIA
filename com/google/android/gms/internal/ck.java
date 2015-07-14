package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public final class ck {
   public static void a(Context var0, ck.b var1) {
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) != 0) {
         var1.a(bn.by());
      } else {
         new ck.a(var0, var1);
      }
   }

   public static final class a implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
      private final Object mH;
      private final ck.b qe;
      private final cl qf;

      public a(Context var1, ck.b var2) {
         this(var1, var2, false);
      }

      a(Context var1, ck.b var2, boolean var3) {
         this.mH = new Object();
         this.qe = var2;
         this.qf = new cl(var1, this, this, 6587000);
         if(!var3) {
            this.qf.connect();
         }

      }

      public void onConnected(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.qe.a(bn.by());
      }

      public void onConnectionSuspended(int var1) {
         gr.S("Disconnected from remote ad request service.");
      }
   }

   public interface b {
      void a(Bundle var1);
   }
}
