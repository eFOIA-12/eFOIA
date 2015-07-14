package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.ey;

@ey
public final class at extends bc.a {
   private final AdListener ob;

   public at(AdListener var1) {
      this.ob = var1;
   }

   public void onAdClosed() {
      this.ob.onAdClosed();
   }

   public void onAdFailedToLoad(int var1) {
      this.ob.onAdFailedToLoad(var1);
   }

   public void onAdLeftApplication() {
      this.ob.onAdLeftApplication();
   }

   public void onAdLoaded() {
      this.ob.onAdLoaded();
   }

   public void onAdOpened() {
      this.ob.onAdOpened();
   }
}
