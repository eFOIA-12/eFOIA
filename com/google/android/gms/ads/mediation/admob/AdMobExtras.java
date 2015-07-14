package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras implements NetworkExtras {
   private final Bundle mExtras;

   public AdMobExtras(Bundle var1) {
      if(var1 != null) {
         var1 = new Bundle(var1);
      } else {
         var1 = null;
      }

      this.mExtras = var1;
   }

   public Bundle getExtras() {
      return this.mExtras;
   }
}
