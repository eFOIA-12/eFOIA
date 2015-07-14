package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventServerParameters;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.gr;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
   private View n;
   private CustomEventBanner o;
   private CustomEventInterstitial p;

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

   public void destroy() {
      if(this.o != null) {
         this.o.destroy();
      }

      if(this.p != null) {
         this.p.destroy();
      }

   }

   public Class getAdditionalParametersType() {
      return CustomEventExtras.class;
   }

   public View getBannerView() {
      return this.n;
   }

   public Class getServerParametersType() {
      return CustomEventServerParameters.class;
   }

   public void requestBannerAd(MediationBannerListener var1, Activity var2, CustomEventServerParameters var3, AdSize var4, MediationAdRequest var5, CustomEventExtras var6) {
      this.o = (CustomEventBanner)a(var3.className);
      if(this.o == null) {
         var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      } else {
         Object var7;
         if(var6 == null) {
            var7 = null;
         } else {
            var7 = var6.getExtra(var3.label);
         }

         this.o.requestBannerAd(new CustomEventAdapter.a(this, var1), var2, var3.label, var3.parameter, var4, var5, var7);
      }
   }

   public void requestInterstitialAd(MediationInterstitialListener var1, Activity var2, CustomEventServerParameters var3, MediationAdRequest var4, CustomEventExtras var5) {
      this.p = (CustomEventInterstitial)a(var3.className);
      if(this.p == null) {
         var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      } else {
         Object var6;
         if(var5 == null) {
            var6 = null;
         } else {
            var6 = var5.getExtra(var3.label);
         }

         this.p.requestInterstitialAd(new CustomEventAdapter.b(this, var1), var2, var3.label, var3.parameter, var4, var6);
      }
   }

   public void showInterstitial() {
      this.p.showInterstitial();
   }

   private static final class a implements CustomEventBannerListener {
      private final CustomEventAdapter q;
      private final MediationBannerListener r;

      public a(CustomEventAdapter var1, MediationBannerListener var2) {
         this.q = var1;
         this.r = var2;
      }

      public void onClick() {
         gr.S("Custom event adapter called onFailedToReceiveAd.");
         this.r.onClick(this.q);
      }

      public void onDismissScreen() {
         gr.S("Custom event adapter called onFailedToReceiveAd.");
         this.r.onDismissScreen(this.q);
      }

      public void onFailedToReceiveAd() {
         gr.S("Custom event adapter called onFailedToReceiveAd.");
         this.r.onFailedToReceiveAd(this.q, AdRequest.ErrorCode.NO_FILL);
      }

      public void onLeaveApplication() {
         gr.S("Custom event adapter called onFailedToReceiveAd.");
         this.r.onLeaveApplication(this.q);
      }

      public void onPresentScreen() {
         gr.S("Custom event adapter called onFailedToReceiveAd.");
         this.r.onPresentScreen(this.q);
      }

      public void onReceivedAd(View var1) {
         gr.S("Custom event adapter called onReceivedAd.");
         this.q.a(var1);
         this.r.onReceivedAd(this.q);
      }
   }

   private class b implements CustomEventInterstitialListener {
      private final CustomEventAdapter q;
      private final MediationInterstitialListener s;

      public b(CustomEventAdapter var2, MediationInterstitialListener var3) {
         this.q = var2;
         this.s = var3;
      }

      public void onDismissScreen() {
         gr.S("Custom event adapter called onDismissScreen.");
         this.s.onDismissScreen(this.q);
      }

      public void onFailedToReceiveAd() {
         gr.S("Custom event adapter called onFailedToReceiveAd.");
         this.s.onFailedToReceiveAd(this.q, AdRequest.ErrorCode.NO_FILL);
      }

      public void onLeaveApplication() {
         gr.S("Custom event adapter called onLeaveApplication.");
         this.s.onLeaveApplication(this.q);
      }

      public void onPresentScreen() {
         gr.S("Custom event adapter called onPresentScreen.");
         this.s.onPresentScreen(this.q);
      }

      public void onReceivedAd() {
         gr.S("Custom event adapter called onReceivedAd.");
         this.s.onReceivedAd(CustomEventAdapter.this);
      }
   }
}
