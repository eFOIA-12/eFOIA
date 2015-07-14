package com.google.ads.mediation;

import android.app.Activity;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public interface MediationInterstitialAdapter extends MediationAdapter {
   void requestInterstitialAd(MediationInterstitialListener var1, Activity var2, MediationServerParameters var3, MediationAdRequest var4, NetworkExtras var5);

   void showInterstitial();
}
