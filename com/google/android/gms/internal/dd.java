package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.da;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.jx;

@ey
public final class dd implements MediationBannerListener, MediationInterstitialListener {
   private final da qW;

   public dd(da var1) {
      this.qW = var1;
   }

   public void onAdClicked(MediationBannerAdapter var1) {
      jx.aU("onAdClicked must be called on the main UI thread.");
      gr.S("Adapter called onAdClicked.");

      try {
         this.qW.onAdClicked();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdClicked.", var2);
      }
   }

   public void onAdClicked(MediationInterstitialAdapter var1) {
      jx.aU("onAdClicked must be called on the main UI thread.");
      gr.S("Adapter called onAdClicked.");

      try {
         this.qW.onAdClicked();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdClicked.", var2);
      }
   }

   public void onAdClosed(MediationBannerAdapter var1) {
      jx.aU("onAdClosed must be called on the main UI thread.");
      gr.S("Adapter called onAdClosed.");

      try {
         this.qW.onAdClosed();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdClosed.", var2);
      }
   }

   public void onAdClosed(MediationInterstitialAdapter var1) {
      jx.aU("onAdClosed must be called on the main UI thread.");
      gr.S("Adapter called onAdClosed.");

      try {
         this.qW.onAdClosed();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdClosed.", var2);
      }
   }

   public void onAdFailedToLoad(MediationBannerAdapter var1, int var2) {
      jx.aU("onAdFailedToLoad must be called on the main UI thread.");
      gr.S("Adapter called onAdFailedToLoad with error. " + var2);

      try {
         this.qW.onAdFailedToLoad(var2);
      } catch (RemoteException var3) {
         gr.d("Could not call onAdFailedToLoad.", var3);
      }
   }

   public void onAdFailedToLoad(MediationInterstitialAdapter var1, int var2) {
      jx.aU("onAdFailedToLoad must be called on the main UI thread.");
      gr.S("Adapter called onAdFailedToLoad with error " + var2 + ".");

      try {
         this.qW.onAdFailedToLoad(var2);
      } catch (RemoteException var3) {
         gr.d("Could not call onAdFailedToLoad.", var3);
      }
   }

   public void onAdLeftApplication(MediationBannerAdapter var1) {
      jx.aU("onAdLeftApplication must be called on the main UI thread.");
      gr.S("Adapter called onAdLeftApplication.");

      try {
         this.qW.onAdLeftApplication();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdLeftApplication.", var2);
      }
   }

   public void onAdLeftApplication(MediationInterstitialAdapter var1) {
      jx.aU("onAdLeftApplication must be called on the main UI thread.");
      gr.S("Adapter called onAdLeftApplication.");

      try {
         this.qW.onAdLeftApplication();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdLeftApplication.", var2);
      }
   }

   public void onAdLoaded(MediationBannerAdapter var1) {
      jx.aU("onAdLoaded must be called on the main UI thread.");
      gr.S("Adapter called onAdLoaded.");

      try {
         this.qW.onAdLoaded();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdLoaded.", var2);
      }
   }

   public void onAdLoaded(MediationInterstitialAdapter var1) {
      jx.aU("onAdLoaded must be called on the main UI thread.");
      gr.S("Adapter called onAdLoaded.");

      try {
         this.qW.onAdLoaded();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdLoaded.", var2);
      }
   }

   public void onAdOpened(MediationBannerAdapter var1) {
      jx.aU("onAdOpened must be called on the main UI thread.");
      gr.S("Adapter called onAdOpened.");

      try {
         this.qW.onAdOpened();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdOpened.", var2);
      }
   }

   public void onAdOpened(MediationInterstitialAdapter var1) {
      jx.aU("onAdOpened must be called on the main UI thread.");
      gr.S("Adapter called onAdOpened.");

      try {
         this.qW.onAdOpened();
      } catch (RemoteException var2) {
         gr.d("Could not call onAdOpened.", var2);
      }
   }
}
