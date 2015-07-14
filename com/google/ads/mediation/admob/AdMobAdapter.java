package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gq;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
   private AdView i;
   private InterstitialAd j;

   static AdRequest a(Context var0, MediationAdRequest var1, Bundle var2, Bundle var3) {
      AdRequest.Builder var6 = new AdRequest.Builder();
      Date var7 = var1.getBirthday();
      if(var7 != null) {
         var6.setBirthday(var7);
      }

      int var4 = var1.getGender();
      if(var4 != 0) {
         var6.setGender(var4);
      }

      Set var8 = var1.getKeywords();
      if(var8 != null) {
         Iterator var9 = var8.iterator();

         while(var9.hasNext()) {
            var6.addKeyword((String)var9.next());
         }
      }

      Location var10 = var1.getLocation();
      if(var10 != null) {
         var6.setLocation(var10);
      }

      if(var1.isTesting()) {
         var6.addTestDevice(gq.v(var0));
      }

      if(var3.getInt("tagForChildDirectedTreatment") != -1) {
         boolean var5;
         if(var3.getInt("tagForChildDirectedTreatment") == 1) {
            var5 = true;
         } else {
            var5 = false;
         }

         var6.tagForChildDirectedTreatment(var5);
      }

      if(var2 == null) {
         var2 = new Bundle();
      }

      var2.putInt("gw", 1);
      var2.putString("mad_hac", var3.getString("mad_hac"));
      if(!TextUtils.isEmpty(var3.getString("adJson"))) {
         var2.putString("_ad", var3.getString("adJson"));
      }

      var2.putBoolean("_noRefresh", true);
      var6.addNetworkExtrasBundle(AdMobAdapter.class, var2);
      return var6.build();
   }

   public View getBannerView() {
      return this.i;
   }

   public void onDestroy() {
      if(this.i != null) {
         this.i.destroy();
         this.i = null;
      }

      if(this.j != null) {
         this.j = null;
      }

   }

   public void onPause() {
      if(this.i != null) {
         this.i.pause();
      }

   }

   public void onResume() {
      if(this.i != null) {
         this.i.resume();
      }

   }

   public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6) {
      this.i = new AdView(var1);
      this.i.setAdSize(new AdSize(var4.getWidth(), var4.getHeight()));
      this.i.setAdUnitId(var3.getString("pubid"));
      this.i.setAdListener(new AdMobAdapter.a(this, var2));
      this.i.loadAd(a(var1, var5, var6, var3));
   }

   public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5) {
      this.j = new InterstitialAd(var1);
      this.j.setAdUnitId(var3.getString("pubid"));
      this.j.setAdListener(new AdMobAdapter.b(this, var2));
      this.j.loadAd(a(var1, var4, var5, var3));
   }

   public void showInterstitial() {
      this.j.show();
   }

   private static final class a extends AdListener {
      private final AdMobAdapter k;
      private final MediationBannerListener l;

      public a(AdMobAdapter var1, MediationBannerListener var2) {
         this.k = var1;
         this.l = var2;
      }

      public void onAdClosed() {
         this.l.onAdClosed(this.k);
      }

      public void onAdFailedToLoad(int var1) {
         this.l.onAdFailedToLoad(this.k, var1);
      }

      public void onAdLeftApplication() {
         this.l.onAdLeftApplication(this.k);
      }

      public void onAdLoaded() {
         this.l.onAdLoaded(this.k);
      }

      public void onAdOpened() {
         this.l.onAdClicked(this.k);
         this.l.onAdOpened(this.k);
      }
   }

   private static final class b extends AdListener {
      private final AdMobAdapter k;
      private final MediationInterstitialListener m;

      public b(AdMobAdapter var1, MediationInterstitialListener var2) {
         this.k = var1;
         this.m = var2;
      }

      public void onAdClosed() {
         this.m.onAdClosed(this.k);
      }

      public void onAdFailedToLoad(int var1) {
         this.m.onAdFailedToLoad(this.k, var1);
      }

      public void onAdLeftApplication() {
         this.m.onAdLeftApplication(this.k);
      }

      public void onAdLoaded() {
         this.m.onAdLoaded(this.k);
      }

      public void onAdOpened() {
         this.m.onAdOpened(this.k);
      }
   }
}
