package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.da;
import com.google.android.gms.internal.df;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public final class de extends cz.a {
   private final MediationAdapter qX;
   private final NetworkExtras qY;

   public de(MediationAdapter var1, NetworkExtras var2) {
      this.qX = var1;
      this.qY = var2;
   }

   private MediationServerParameters b(String param1, int param2, String param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void a(com.google.android.gms.dynamic.d var1, av var2, String var3, da var4) throws RemoteException {
      this.a(var1, (av)var2, (String)var3, (String)null, var4);
   }

   public void a(com.google.android.gms.dynamic.d var1, av var2, String var3, String var4, da var5) throws RemoteException {
      if(!(this.qX instanceof MediationInterstitialAdapter)) {
         gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         gr.S("Requesting interstitial ad from adapter.");

         try {
            ((MediationInterstitialAdapter)this.qX).requestInterstitialAd(new df(var5), (Activity)com.google.android.gms.dynamic.e.f(var1), this.b(var3, var2.oh, var4), dg.d(var2), this.qY);
         } catch (Throwable var6) {
            gr.d("Could not request interstitial ad from adapter.", var6);
            throw new RemoteException();
         }
      }
   }

   public void a(com.google.android.gms.dynamic.d var1, ay var2, av var3, String var4, da var5) throws RemoteException {
      this.a(var1, var2, var3, var4, (String)null, var5);
   }

   public void a(com.google.android.gms.dynamic.d var1, ay var2, av var3, String var4, String var5, da var6) throws RemoteException {
      if(!(this.qX instanceof MediationBannerAdapter)) {
         gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         gr.S("Requesting banner ad from adapter.");

         try {
            ((MediationBannerAdapter)this.qX).requestBannerAd(new df(var6), (Activity)com.google.android.gms.dynamic.e.f(var1), this.b(var4, var3.oh, var5), dg.b(var2), dg.d(var3), this.qY);
         } catch (Throwable var7) {
            gr.d("Could not request banner ad from adapter.", var7);
            throw new RemoteException();
         }
      }
   }

   public void destroy() throws RemoteException {
      try {
         this.qX.destroy();
      } catch (Throwable var2) {
         gr.d("Could not destroy adapter.", var2);
         throw new RemoteException();
      }
   }

   public com.google.android.gms.dynamic.d getView() throws RemoteException {
      if(!(this.qX instanceof MediationBannerAdapter)) {
         gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         try {
            com.google.android.gms.dynamic.d var1 = com.google.android.gms.dynamic.e.k(((MediationBannerAdapter)this.qX).getBannerView());
            return var1;
         } catch (Throwable var2) {
            gr.d("Could not get banner view from adapter.", var2);
            throw new RemoteException();
         }
      }
   }

   public void pause() throws RemoteException {
      throw new RemoteException();
   }

   public void resume() throws RemoteException {
      throw new RemoteException();
   }

   public void showInterstitial() throws RemoteException {
      if(!(this.qX instanceof MediationInterstitialAdapter)) {
         gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         gr.S("Showing interstitial from adapter.");

         try {
            ((MediationInterstitialAdapter)this.qX).showInterstitial();
         } catch (Throwable var2) {
            gr.d("Could not show interstitial from adapter.", var2);
            throw new RemoteException();
         }
      }
   }
}
