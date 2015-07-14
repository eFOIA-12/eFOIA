package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.da;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;

@ey
public final class df implements MediationBannerListener, MediationInterstitialListener {
   private final da qW;

   public df(da var1) {
      this.qW = var1;
   }

   public void onClick(MediationBannerAdapter var1) {
      gr.S("Adapter called onClick.");
      if(!gq.dB()) {
         gr.W("onClick must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdClicked();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdClicked.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdClicked();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdClicked.", var2);
         }
      }
   }

   public void onDismissScreen(MediationBannerAdapter var1) {
      gr.S("Adapter called onDismissScreen.");
      if(!gq.dB()) {
         gr.W("onDismissScreen must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdClosed();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdClosed.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdClosed();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdClosed.", var2);
         }
      }
   }

   public void onDismissScreen(MediationInterstitialAdapter var1) {
      gr.S("Adapter called onDismissScreen.");
      if(!gq.dB()) {
         gr.W("onDismissScreen must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdClosed();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdClosed.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdClosed();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdClosed.", var2);
         }
      }
   }

   public void onFailedToReceiveAd(MediationBannerAdapter var1, final AdRequest.ErrorCode var2) {
      gr.S("Adapter called onFailedToReceiveAd with error. " + var2);
      if(!gq.dB()) {
         gr.W("onFailedToReceiveAd must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdFailedToLoad(dg.a(var2));
               } catch (RemoteException var2x) {
                  gr.d("Could not call onAdFailedToLoad.", var2x);
               }
            }
         });
      } else {
         try {
            this.qW.onAdFailedToLoad(dg.a(var2));
         } catch (RemoteException var3) {
            gr.d("Could not call onAdFailedToLoad.", var3);
         }
      }
   }

   public void onFailedToReceiveAd(MediationInterstitialAdapter var1, final AdRequest.ErrorCode var2) {
      gr.S("Adapter called onFailedToReceiveAd with error " + var2 + ".");
      if(!gq.dB()) {
         gr.W("onFailedToReceiveAd must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdFailedToLoad(dg.a(var2));
               } catch (RemoteException var2x) {
                  gr.d("Could not call onAdFailedToLoad.", var2x);
               }
            }
         });
      } else {
         try {
            this.qW.onAdFailedToLoad(dg.a(var2));
         } catch (RemoteException var3) {
            gr.d("Could not call onAdFailedToLoad.", var3);
         }
      }
   }

   public void onLeaveApplication(MediationBannerAdapter var1) {
      gr.S("Adapter called onLeaveApplication.");
      if(!gq.dB()) {
         gr.W("onLeaveApplication must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdLeftApplication();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdLeftApplication.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdLeftApplication();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdLeftApplication.", var2);
         }
      }
   }

   public void onLeaveApplication(MediationInterstitialAdapter var1) {
      gr.S("Adapter called onLeaveApplication.");
      if(!gq.dB()) {
         gr.W("onLeaveApplication must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdLeftApplication();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdLeftApplication.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdLeftApplication();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdLeftApplication.", var2);
         }
      }
   }

   public void onPresentScreen(MediationBannerAdapter var1) {
      gr.S("Adapter called onPresentScreen.");
      if(!gq.dB()) {
         gr.W("onPresentScreen must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdOpened();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdOpened.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdOpened();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdOpened.", var2);
         }
      }
   }

   public void onPresentScreen(MediationInterstitialAdapter var1) {
      gr.S("Adapter called onPresentScreen.");
      if(!gq.dB()) {
         gr.W("onPresentScreen must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdOpened();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdOpened.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdOpened();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdOpened.", var2);
         }
      }
   }

   public void onReceivedAd(MediationBannerAdapter var1) {
      gr.S("Adapter called onReceivedAd.");
      if(!gq.dB()) {
         gr.W("onReceivedAd must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdLoaded();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdLoaded.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdLoaded();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdLoaded.", var2);
         }
      }
   }

   public void onReceivedAd(MediationInterstitialAdapter var1) {
      gr.S("Adapter called onReceivedAd.");
      if(!gq.dB()) {
         gr.W("onReceivedAd must be called on the main UI thread.");
         gq.wR.post(new Runnable() {
            public void run() {
               try {
                  df.this.qW.onAdLoaded();
               } catch (RemoteException var2) {
                  gr.d("Could not call onAdLoaded.", var2);
               }
            }
         });
      } else {
         try {
            this.qW.onAdLoaded();
         } catch (RemoteException var2) {
            gr.d("Could not call onAdLoaded.", var2);
         }
      }
   }
}
