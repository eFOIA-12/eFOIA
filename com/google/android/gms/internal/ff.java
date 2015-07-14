package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.fg;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.fx;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gr;

@ey
public abstract class ff extends gf {
   private final fh qh;
   private final fe.a tI;

   public ff(fh var1, fe.a var2) {
      this.qh = var1;
      this.tI = var2;
   }

   private static fj a(fl var0, fh var1) {
      try {
         fj var6 = var0.b(var1);
         return var6;
      } catch (RemoteException var2) {
         gr.d("Could not fetch ad response from ad request service.", var2);
         return null;
      } catch (NullPointerException var3) {
         gr.d("Could not fetch ad response from ad request service due to an Exception.", var3);
         return null;
      } catch (SecurityException var4) {
         gr.d("Could not fetch ad response from ad request service due to an Exception.", var4);
         return null;
      } catch (Throwable var5) {
         ga.e(var5);
         return null;
      }
   }

   public abstract void cJ();

   public abstract fl cK();

   public final void cx() {
      // $FF: Couldn't be decompiled
   }

   public final void onStop() {
      this.cJ();
   }

   @ey
   public static final class a extends ff {
      private final Context mContext;

      public a(Context var1, fh var2, fe.a var3) {
         super(var2, var3);
         this.mContext = var1;
      }

      public void cJ() {
      }

      public fl cK() {
         Bundle var1 = ga.bN();
         bm var2 = new bm(var1.getString("gads:sdk_core_location"), var1.getString("gads:sdk_core_experiment_id"), var1.getString("gads:block_autoclicks_experiment_id"), var1.getString("gads:spam_app_context:experiment_id"));
         return fq.a(this.mContext, var2, new co(), new fx());
      }
   }

   @ey
   public static final class b extends ff implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
      private final Object mH = new Object();
      private final fe.a tI;
      private final fg tJ;

      public b(Context var1, fh var2, fe.a var3) {
         super(var2, var3);
         this.tI = var3;
         this.tJ = new fg(var1, this, this, var2.lO.wU);
         this.tJ.connect();
      }

      public void cJ() {
         // $FF: Couldn't be decompiled
      }

      public fl cK() {
         // $FF: Couldn't be decompiled
      }

      public void onConnected(Bundle var1) {
         this.start();
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.tI.a(new fj(0));
      }

      public void onConnectionSuspended(int var1) {
         gr.S("Disconnected from remote ad request service.");
      }
   }
}
