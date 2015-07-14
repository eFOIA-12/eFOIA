package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.da;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public final class dc extends cz.a {
   private final MediationAdapter qV;

   public dc(MediationAdapter var1) {
      this.qV = var1;
   }

   private Bundle a(String param1, int param2, String param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void a(com.google.android.gms.dynamic.d var1, av var2, String var3, da var4) throws RemoteException {
      this.a(var1, (av)var2, (String)var3, (String)null, var4);
   }

   public void a(com.google.android.gms.dynamic.d param1, av param2, String param3, String param4, da param5) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void a(com.google.android.gms.dynamic.d var1, ay var2, av var3, String var4, da var5) throws RemoteException {
      this.a(var1, var2, var3, var4, (String)null, var5);
   }

   public void a(com.google.android.gms.dynamic.d param1, ay param2, av param3, String param4, String param5, da param6) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void destroy() throws RemoteException {
      try {
         this.qV.onDestroy();
      } catch (Throwable var2) {
         gr.d("Could not destroy adapter.", var2);
         throw new RemoteException();
      }
   }

   public com.google.android.gms.dynamic.d getView() throws RemoteException {
      if(!(this.qV instanceof MediationBannerAdapter)) {
         gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qV.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         try {
            com.google.android.gms.dynamic.d var1 = com.google.android.gms.dynamic.e.k(((MediationBannerAdapter)this.qV).getBannerView());
            return var1;
         } catch (Throwable var2) {
            gr.d("Could not get banner view from adapter.", var2);
            throw new RemoteException();
         }
      }
   }

   public void pause() throws RemoteException {
      try {
         this.qV.onPause();
      } catch (Throwable var2) {
         gr.d("Could not pause adapter.", var2);
         throw new RemoteException();
      }
   }

   public void resume() throws RemoteException {
      try {
         this.qV.onResume();
      } catch (Throwable var2) {
         gr.d("Could not resume adapter.", var2);
         throw new RemoteException();
      }
   }

   public void showInterstitial() throws RemoteException {
      if(!(this.qV instanceof MediationInterstitialAdapter)) {
         gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qV.getClass().getCanonicalName());
         throw new RemoteException();
      } else {
         gr.S("Showing interstitial from adapter.");

         try {
            ((MediationInterstitialAdapter)this.qV).showInterstitial();
         } catch (Throwable var2) {
            gr.d("Could not show interstitial from adapter.", var2);
            throw new RemoteException();
         }
      }
   }
}
