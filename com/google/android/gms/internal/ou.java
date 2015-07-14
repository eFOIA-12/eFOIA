package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.ox;

public class ou implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
   private ox amU;
   private final op.a ane;
   private boolean anf;

   public ou(op.a var1) {
      this.ane = var1;
      this.amU = null;
      this.anf = true;
   }

   public void T(boolean var1) {
      this.anf = var1;
   }

   public void a(ox var1) {
      this.amU = var1;
   }

   public void onConnected(Bundle var1) {
      this.amU.U(false);
      if(this.anf && this.ane != null) {
         this.ane.on();
      }

      this.anf = false;
   }

   public void onConnectionFailed(ConnectionResult var1) {
      this.amU.U(true);
      if(this.anf && this.ane != null) {
         if(var1.hasResolution()) {
            this.ane.d(var1.getResolution());
         } else {
            this.ane.oo();
         }
      }

      this.anf = false;
   }

   public void onDisconnected() {
      this.amU.U(true);
   }
}
