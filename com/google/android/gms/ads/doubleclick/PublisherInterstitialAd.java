package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.internal.bi;

public final class PublisherInterstitialAd {
   private final bi lm;

   public PublisherInterstitialAd(Context var1) {
      this.lm = new bi(var1, this);
   }

   public AdListener getAdListener() {
      return this.lm.getAdListener();
   }

   public String getAdUnitId() {
      return this.lm.getAdUnitId();
   }

   public AppEventListener getAppEventListener() {
      return this.lm.getAppEventListener();
   }

   public String getMediationAdapterClassName() {
      return this.lm.getMediationAdapterClassName();
   }

   public boolean isLoaded() {
      return this.lm.isLoaded();
   }

   public void loadAd(PublisherAdRequest var1) {
      this.lm.a(var1.Y());
   }

   public void setAdListener(AdListener var1) {
      this.lm.setAdListener(var1);
   }

   public void setAdUnitId(String var1) {
      this.lm.setAdUnitId(var1);
   }

   public void setAppEventListener(AppEventListener var1) {
      this.lm.setAppEventListener(var1);
   }

   public void show() {
      this.lm.show();
   }
}
