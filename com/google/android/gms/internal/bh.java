package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.ax;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.ba;
import com.google.android.gms.internal.bb;
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
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;

public final class bh {
   private final cx oH;
   private final ax oI;
   private bd oJ;
   private String oK;
   private ViewGroup oL;
   private InAppPurchaseListener oM;
   private PlayStorePurchaseListener oN;
   private com.google.android.gms.ads.doubleclick.b oO;
   private AdListener ob;
   private AppEventListener os;
   private AdSize[] ot;
   private String ou;

   public bh(ViewGroup var1) {
      this(var1, (AttributeSet)null, false, ax.bg());
   }

   public bh(ViewGroup var1, AttributeSet var2, boolean var3) {
      this(var1, var2, var3, ax.bg());
   }

   bh(ViewGroup var1, AttributeSet var2, boolean var3, ax var4) {
      this(var1, var2, var3, var4, (bd)null);
   }

   bh(ViewGroup var1, AttributeSet var2, boolean var3, ax var4, bd var5) {
      this.oH = new cx();
      this.oL = var1;
      this.oI = var4;
      if(var2 != null) {
         Context var8 = var1.getContext();

         try {
            bb var7 = new bb(var8, var2);
            this.ot = var7.h(var3);
            this.ou = var7.getAdUnitId();
         } catch (IllegalArgumentException var6) {
            gq.a(var1, new ay(var8, AdSize.BANNER), var6.getMessage(), var6.getMessage());
            return;
         }

         if(var1.isInEditMode()) {
            gq.a(var1, new ay(var8, this.ot[0]), "Ads by Google");
            return;
         }
      }

      this.oJ = var5;
   }

   private void bm() {
      // $FF: Couldn't be decompiled
   }

   private void bn() throws RemoteException {
      if((this.ot == null || this.ou == null) && this.oJ == null) {
         throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
      } else {
         Context var1 = this.oL.getContext();
         this.oJ = au.a(var1, new ay(var1, this.ot), this.ou, this.oH);
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

         this.bm();
      }
   }

   public void a(bg var1) {
      try {
         if(this.oJ == null) {
            this.bn();
         }

         if(this.oJ.a(this.oI.a(this.oL.getContext(), var1))) {
            this.oH.d(var1.bj());
         }

      } catch (RemoteException var2) {
         gr.d("Failed to load ad.", var2);
      }
   }

   public void a(AdSize... var1) {
      this.ot = var1;

      try {
         if(this.oJ != null) {
            this.oJ.a(new ay(this.oL.getContext(), this.ot));
         }
      } catch (RemoteException var2) {
         gr.d("Failed to set the ad size.", var2);
      }

      this.oL.requestLayout();
   }

   public void destroy() {
      try {
         if(this.oJ != null) {
            this.oJ.destroy();
         }

      } catch (RemoteException var2) {
         gr.d("Failed to destroy AdView.", var2);
      }
   }

   public AdListener getAdListener() {
      return this.ob;
   }

   public AdSize getAdSize() {
      try {
         if(this.oJ != null) {
            AdSize var1 = this.oJ.ac().bh();
            return var1;
         }
      } catch (RemoteException var2) {
         gr.d("Failed to get the current AdSize.", var2);
      }

      return this.ot != null?this.ot[0]:null;
   }

   public AdSize[] getAdSizes() {
      return this.ot;
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

   public void pause() {
      try {
         if(this.oJ != null) {
            this.oJ.pause();
         }

      } catch (RemoteException var2) {
         gr.d("Failed to call pause.", var2);
      }
   }

   public void recordManualImpression() {
      try {
         if(this.oJ != null) {
            this.oJ.an();
         }

      } catch (RemoteException var2) {
         gr.d("Failed to record impression.", var2);
      }
   }

   public void resume() {
      try {
         if(this.oJ != null) {
            this.oJ.resume();
         }

      } catch (RemoteException var2) {
         gr.d("Failed to call resume.", var2);
      }
   }

   public void setAdListener(AdListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAdSizes(AdSize... var1) {
      if(this.ot != null) {
         throw new IllegalStateException("The ad size can only be set once on AdView.");
      } else {
         this.a(var1);
      }
   }

   public void setAdUnitId(String var1) {
      if(this.ou != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
}
