package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.ax;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.ba;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.br;
import com.google.android.gms.internal.bs;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.es;
import com.google.android.gms.internal.ew;
import com.google.android.gms.internal.gr;

public class bi {
   private final Context mContext;
   private final cx oH;
   private final ax oI;
   private bd oJ;
   private String oK;
   private InAppPurchaseListener oM;
   private PlayStorePurchaseListener oN;
   private com.google.android.gms.ads.doubleclick.b oO;
   private PublisherInterstitialAd oP;
   private AdListener ob;
   private AppEventListener os;
   private String ou;

   public bi(Context var1) {
      this(var1, ax.bg(), (PublisherInterstitialAd)null);
   }

   public bi(Context var1, PublisherInterstitialAd var2) {
      this(var1, ax.bg(), var2);
   }

   public bi(Context var1, ax var2, PublisherInterstitialAd var3) {
      this.oH = new cx();
      this.mContext = var1;
      this.oI = var2;
      this.oP = var3;
   }

   private void v(String var1) throws RemoteException {
      if(this.ou == null) {
         this.w(var1);
      }

      this.oJ = au.a(this.mContext, new ay(), this.ou, this.oH);
      if(this.ob != null) {
         this.oJ.a((bc)(new at(this.ob)));
      }

      if(this.os != null) {
         this.oJ.a((bf)(new ba(this.os)));
      }

      if(this.oM != null) {
         this.oJ.a((en)(new es(this.oM)));
      }

      if(this.oN != null) {
         this.oJ.a(new ew(this.oN), this.oK);
      }

      if(this.oO != null) {
         this.oJ.a((br)(new bs(this.oO)));
      }

   }

   private void w(String var1) {
      if(this.oJ == null) {
         throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + var1 + " is called.");
      }
   }

   public void a(bg var1) {
      try {
         if(this.oJ == null) {
            this.v("loadAd");
         }

         if(this.oJ.a(this.oI.a(this.mContext, var1))) {
            this.oH.d(var1.bj());
         }

      } catch (RemoteException var2) {
         gr.d("Failed to load ad.", var2);
      }
   }

   public AdListener getAdListener() {
      return this.ob;
   }

   public String getAdUnitId() {
      return this.ou;
   }

   public AppEventListener getAppEventListener() {
      return this.os;
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.oM;
   }

   public String getMediationAdapterClassName() {
      try {
         if(this.oJ != null) {
            String var1 = this.oJ.getMediationAdapterClassName();
            return var1;
         }
      } catch (RemoteException var2) {
         gr.d("Failed to get the mediation adapter class name.", var2);
      }

      return null;
   }

   public boolean isLoaded() {
      try {
         if(this.oJ == null) {
            return false;
         } else {
            boolean var1 = this.oJ.isReady();
            return var1;
         }
      } catch (RemoteException var3) {
         gr.d("Failed to check if ad is ready.", var3);
         return false;
      }
   }

   public void setAdListener(AdListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAdUnitId(String var1) {
      if(this.ou != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
      } else {
         this.ou = var1;
      }
   }

   public void setAppEventListener(AppEventListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setInAppPurchaseListener(InAppPurchaseListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setPlayStorePurchaseParams(PlayStorePurchaseListener param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void show() {
      try {
         this.w("show");
         this.oJ.showInterstitial();
      } catch (RemoteException var2) {
         gr.d("Failed to show interstitial.", var2);
      }
   }
}
