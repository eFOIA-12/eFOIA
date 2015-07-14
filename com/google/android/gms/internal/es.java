package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.em;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.ev;
import com.google.android.gms.internal.ey;

@ey
public final class es extends en.a {
   private final InAppPurchaseListener oM;

   public es(InAppPurchaseListener var1) {
      this.oM = var1;
   }

   public void a(em var1) {
      this.oM.onInAppPurchaseRequested(new ev(var1));
   }
}
