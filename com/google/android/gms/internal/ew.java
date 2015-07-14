package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.eq;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.eu;
import com.google.android.gms.internal.ey;

@ey
public final class ew extends er.a {
   private final PlayStorePurchaseListener oN;

   public ew(PlayStorePurchaseListener var1) {
      this.oN = var1;
   }

   public void a(eq var1) {
      this.oN.onInAppPurchaseFinished(new eu(var1));
   }

   public boolean isValidPurchase(String var1) {
      return this.oN.isValidPurchase(var1);
   }
}
