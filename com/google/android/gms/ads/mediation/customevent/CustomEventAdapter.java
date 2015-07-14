package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.android.gms.internal.gr;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
   private View n;
   private CustomEventBanner xu;
   private CustomEventInterstitial xv;

   private static Object a(String var0) {
      try {
         Object var1 = Class.forName(var0).newInstance();
         return var1;
      } catch (Throwable var2) {
         gr.W("Could not instantiate custom event adapter: " + var0 + ". " + var2.getMessage());
         return null;
      }
   }

   private void a(View var1) {
      this.n = var1;
   }

   public View getBannerView() {
      return this.n;
   }

   public void onDestroy() {
      if(this.xu != null) {
         this.xu.onDestroy();
      }

      if(this.xv != null) {
         this.xv.onDestroy();
      }

   }

   public void onPause() {
      if(this.xu != null) {
         this.xu.onPause();
      }

      if(this.xv != null) {
         this.xv.onPause();
      }

   }

   public void onResume() {
      if(this.xu != null) {
         this.xu.onResume();
      }

      if(this.xv != null) {
         this.xv.onResume();
      }

   }

   public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6) {
      this.xu = (CustomEventBanner)a(var3.getString("class_name"));
      if(this.xu == null) {
         var2.onAdFailedToLoad(this, 0);
      } else {
         if(var6 == null) {
            var6 = null;
         } else {
            var6 = var6.getBundle(var3.getString("class_name"));
         }

         this.xu.requestBannerAd(var1, new CustomEventAdapter.a(this, var2), var3.getString("parameter"), var4, var5, var6);
      }
   }

   public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5) {
      this.xv = (CustomEventInterstitial)a(var3.getString("class_name"));
      if(this.xv == null) {
         var2.onAdFailedToLoad(this, 0);
      } else {
         if(var5 == null) {
            var5 = null;
         } else {
            var5 = var5.getBundle(var3.getString("class_name"));
         }

         this.xv.requestInterstitialAd(var1, new CustomEventAdapter.b(this, var2), var3.getString("parameter"), var4, var5);
      }
   }

   public void showInterstitial() {
      this.xv.showInterstitial();
   }

   private static final class a implements CustomEventBannerListener {
      private final MediationBannerListener l;
      private final CustomEventAdapter xw;

      public a(CustomEventAdapter var1, MediationBannerListener var2) {
         this.xw = var1;
         this.l = var2;
      }

      public void onAdClicked() {
         gr.S("Custom event adapter called onAdClicked.");
         this.l.onAdClicked(this.xw);
      }

      public void onAdClosed() {
         gr.S("Custom event adapter called onAdClosed.");
         this.l.onAdClosed(this.xw);
      }

      public void onAdFailedToLoad(int var1) {
         gr.S("Custom event adapter called onAdFailedToLoad.");
         this.l.onAdFailedToLoad(this.xw, var1);
      }

      public void onAdLeftApplication() {
         gr.S("Custom event adapter called onAdLeftApplication.");
         this.l.onAdLeftApplication(this.xw);
      }

      public void onAdLoaded(View var1) {
         gr.S("Custom event adapter called onAdLoaded.");
         this.xw.a(var1);
         this.l.onAdLoaded(this.xw);
      }

      public void onAdOpened() {
         gr.S("Custom event adapter called onAdOpened.");
         this.l.onAdOpened(this.xw);
      }
   }

   private class b implements CustomEventInterstitialListener {
      private final MediationInterstitialListener m;
      private final CustomEventAdapter xw;

      public b(CustomEventAdapter var2, MediationInterstitialListener var3) {
         this.xw = var2;
         this.m = var3;
      }

      public void onAdClicked() {
         gr.S("Custom event adapter called onAdClicked.");
         this.m.onAdClicked(this.xw);
      }

      public void onAdClosed() {
         gr.S("Custom event adapter called onAdClosed.");
         this.m.onAdClosed(this.xw);
      }

      public void onAdFailedToLoad(int var1) {
         gr.S("Custom event adapter called onFailedToReceiveAd.");
         this.m.onAdFailedToLoad(this.xw, var1);
      }

      public void onAdLeftApplication() {
         gr.S("Custom event adapter called onAdLeftApplication.");
         this.m.onAdLeftApplication(this.xw);
      }

      public void onAdLoaded() {
         gr.S("Custom event adapter called onReceivedAd.");
         this.m.onAdLoaded(CustomEventAdapter.this);
      }

      public void onAdOpened() {
         gr.S("Custom event adapter called onAdOpened.");
         this.m.onAdOpened(this.xw);
      }
   }
}
