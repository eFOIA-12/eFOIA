package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public interface MediationBannerAdapter extends MediationAdapter {
   View getBannerView();

   void requestBannerAd(MediationBannerListener var1, Activity var2, MediationServerParameters var3, AdSize var4, MediationAdRequest var5, NetworkExtras var6);
}
