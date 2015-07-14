package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.bi;

public final class InterstitialAd {
   private final bi lm;

   public InterstitialAd(Context var1) {
      this.lm = new bi(var1);
   }

   public AdListener getAdListener() {
      return this.lm.getAdListener();
   }

   public String getAdUnitId() {
      return this.lm.getAdUnitId();
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.lm.getInAppPurchaseListener();
   }

   public String getMediationAdapterClassName() {
      return this.lm.getMediationAdapterClassName();
   }

   public boolean isLoaded() {
      return this.lm.isLoaded();
   }

   public void loadAd(AdRequest var1) {
      this.lm.a(var1.Y());
   }

   public void setAdListener(AdListener var1) {
      this.lm.setAdListener(var1);
   }

   public void setAdUnitId(String var1) {
      this.lm.setAdUnitId(var1);
   }

   public void setInAppPurchaseListener(InAppPurchaseListener var1) {
      this.lm.setInAppPurchaseListener(var1);
   }

   public void setPlayStorePurchaseParams(PlayStorePurchaseListener var1, String var2) {
      this.lm.setPlayStorePurchaseParams(var1, var2);
   }

   public void show() {
      this.lm.show();
   }
}
