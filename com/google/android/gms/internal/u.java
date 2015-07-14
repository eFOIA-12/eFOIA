package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.aa;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.af;
import com.google.android.gms.internal.ak;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.bo;
import com.google.android.gms.internal.br;
import com.google.android.gms.internal.bt;
import com.google.android.gms.internal.bu;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.by;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.ce;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.cy;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gc;
import com.google.android.gms.internal.gd;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.t;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.w;
import com.google.android.gms.internal.x;
import com.google.android.gms.internal.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ey
public class u extends bd.a implements cb, ce, cg, cs, ds, dv, ej, ez.a, fc.a, gc, t, w {
   private final cy lA;
   private final u.b lB;
   private final ab lC;
   private final ae lD;
   private boolean lE;
   private final ComponentCallbacks lF;
   private av lz;

   public u(Context var1, ay var2, String var3, cy var4, gs var5) {
      this(new u.b(var1, var2, var3, var5), var4, (ab)null);
   }

   u(u.b var1, cy var2, ab var3) {
      this.lF = new ComponentCallbacks() {
         public void onConfigurationChanged(Configuration var1) {
            if(u.this.lB != null && u.this.lB.lT != null && u.this.lB.lT.se != null) {
               u.this.lB.lT.se.cb();
            }

         }

         public void onLowMemory() {
         }
      };
      this.lB = var1;
      this.lA = var2;
      if(var3 == null) {
         var3 = new ab(this);
      }

      this.lC = var3;
      this.lD = new ae();
      gi.q(this.lB.lM);
      ga.a(this.lB.lM, this.lB.lO);
      this.ad();
   }

   private fh.a a(av var1, Bundle var2) {
      ApplicationInfo var12 = this.lB.lM.getApplicationInfo();

      PackageInfo var9;
      try {
         var9 = this.lB.lM.getPackageManager().getPackageInfo(var12.packageName, 0);
      } catch (NameNotFoundException var14) {
         var9 = null;
      }

      String var11 = null;
      Bundle var10 = var11;
      if(!this.lB.lS.oq) {
         var10 = var11;
         if(this.lB.lK.getParent() != null) {
            int[] var15 = new int[2];
            this.lB.lK.getLocationOnScreen(var15);
            int var5 = var15[0];
            int var6 = var15[1];
            DisplayMetrics var16 = this.lB.lM.getResources().getDisplayMetrics();
            int var7 = this.lB.lK.getWidth();
            int var8 = this.lB.lK.getHeight();
            byte var4 = 0;
            byte var3 = var4;
            if(this.lB.lK.isShown()) {
               var3 = var4;
               if(var5 + var7 > 0) {
                  var3 = var4;
                  if(var6 + var8 > 0) {
                     var3 = var4;
                     if(var5 <= var16.widthPixels) {
                        var3 = var4;
                        if(var6 <= var16.heightPixels) {
                           var3 = 1;
                        }
                     }
                  }
               }
            }

            var10 = new Bundle(5);
            var10.putInt("x", var5);
            var10.putInt("y", var6);
            var10.putInt("width", var7);
            var10.putInt("height", var8);
            var10.putInt("visible", var3);
         }
      }

      var11 = ga.df();
      this.lB.lV = new fz(var11, this.lB.lL);
      this.lB.lV.e(var1);
      Bundle var13 = ga.a(this.lB.lM, this, var11);
      return new fh.a(var10, var1, this.lB.lS, this.lB.lL, var12, var9, var11, ga.vY, this.lB.lO, var13, this.lB.mc, var2, ga.dl());
   }

   private gu a(v var1) {
      gu var4;
      if(this.lB.lS.oq) {
         var4 = gu.a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
         var4.dD().a(this, (ds)null, this, this, true, this, this, var1);
         return var4;
      } else {
         View var2 = this.lB.lK.getNextView();
         if(var2 instanceof gu) {
            var4 = (gu)var2;
            var4.a(this.lB.lM, this.lB.lS);
         } else {
            if(var2 != null) {
               this.lB.lK.removeView(var2);
            }

            gu var3 = gu.a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
            var4 = var3;
            if(this.lB.lS.or == null) {
               this.c(var3);
               var4 = var3;
            }
         }

         var4.dD().a(this, this, this, this, false, this, var1);
         return var4;
      }
   }

   private void a(int var1) {
      gr.W("Failed to load ad: " + var1);
      if(this.lB.lP != null) {
         try {
            this.lB.lP.onAdFailedToLoad(var1);
         } catch (RemoteException var3) {
            gr.d("Could not call AdListener.onAdFailedToLoad().", var3);
            return;
         }
      }

   }

   private void ad() {
      if(VERSION.SDK_INT >= 14 && this.lB != null && this.lB.lM != null) {
         this.lB.lM.registerComponentCallbacks(this.lF);
      }

   }

   private void ae() {
      if(VERSION.SDK_INT >= 14 && this.lB != null && this.lB.lM != null) {
         this.lB.lM.unregisterComponentCallbacks(this.lF);
      }

   }

   private void ao() {
      gr.U("Ad closing.");
      if(this.lB.lP != null) {
         try {
            this.lB.lP.onAdClosed();
         } catch (RemoteException var2) {
            gr.d("Could not call AdListener.onAdClosed().", var2);
            return;
         }
      }

   }

   private void ap() {
      gr.U("Ad leaving application.");
      if(this.lB.lP != null) {
         try {
            this.lB.lP.onAdLeftApplication();
         } catch (RemoteException var2) {
            gr.d("Could not call AdListener.onAdLeftApplication().", var2);
            return;
         }
      }

   }

   private void aq() {
      gr.U("Ad opening.");
      if(this.lB.lP != null) {
         try {
            this.lB.lP.onAdOpened();
         } catch (RemoteException var2) {
            gr.d("Could not call AdListener.onAdOpened().", var2);
            return;
         }
      }

   }

   private void ar() {
      gr.U("Ad finished loading.");
      if(this.lB.lP != null) {
         try {
            this.lB.lP.onAdLoaded();
         } catch (RemoteException var2) {
            gr.d("Could not call AdListener.onAdLoaded().", var2);
            return;
         }
      }

   }

   private void as() {
      try {
         if(this.lB.lT.vI instanceof bt && this.lB.lZ != null) {
            this.lB.lZ.a((bt)this.lB.lT.vI);
         }

      } catch (RemoteException var2) {
         gr.d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", var2);
      }
   }

   private void at() {
      try {
         if(this.lB.lT.vI instanceof bu && this.lB.ma != null) {
            this.lB.ma.a((bu)this.lB.lT.vI);
         }

      } catch (RemoteException var2) {
         gr.d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", var2);
      }
   }

   private void ax() {
      if(this.lB.lT != null) {
         if(this.lB.mg == 0) {
            this.lB.lT.se.destroy();
         }

         this.lB.lT = null;
         this.lB.mi = false;
      }

   }

   private boolean b(fy var1) {
      View var6;
      if(var1.tW) {
         try {
            var6 = (View)com.google.android.gms.dynamic.e.f(var1.qQ.getView());
         } catch (RemoteException var5) {
            gr.d("Could not get View from mediation adapter.", var5);
            return false;
         }

         View var2 = this.lB.lK.getNextView();
         if(var2 != null) {
            this.lB.lK.removeView(var2);
         }

         try {
            this.c(var6);
         } catch (Throwable var4) {
            gr.d("Could not add mediation view to view hierarchy.", var4);
            return false;
         }
      } else if(var1.vF != null) {
         var1.se.a(var1.vF);
         this.lB.lK.removeAllViews();
         this.lB.lK.setMinimumWidth(var1.vF.widthPixels);
         this.lB.lK.setMinimumHeight(var1.vF.heightPixels);
         this.c(var1.se);
      }

      if(this.lB.lK.getChildCount() > 1) {
         this.lB.lK.showNext();
      }

      if(this.lB.lT != null) {
         var6 = this.lB.lK.getNextView();
         if(var6 instanceof gu) {
            ((gu)var6).a(this.lB.lM, this.lB.lS);
         } else if(var6 != null) {
            this.lB.lK.removeView(var6);
         }

         if(this.lB.lT.qQ != null) {
            try {
               this.lB.lT.qQ.destroy();
            } catch (RemoteException var3) {
               gr.W("Could not destroy previous mediation adapter.");
            }
         }
      }

      this.lB.lK.setVisibility(0);
      return true;
   }

   private void c(View var1) {
      LayoutParams var2 = new LayoutParams(-2, -2);
      this.lB.lK.addView(var1, var2);
   }

   private void e(boolean var1) {
      if(this.lB.lT == null) {
         gr.W("Ad state was null when trying to ping impression URLs.");
      } else {
         gr.S("Pinging Impression URLs.");
         this.lB.lV.cW();
         if(this.lB.lT.qx != null) {
            gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qx);
         }

         if(this.lB.lT.vE != null && this.lB.lT.vE.qx != null) {
            cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, var1, this.lB.lT.vE.qx);
         }

         if(this.lB.lT.qP != null && this.lB.lT.qP.qs != null) {
            cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, var1, this.lB.lT.qP.qs);
            return;
         }
      }

   }

   Bundle a(an var1) {
      if(var1 != null) {
         if(var1.be()) {
            var1.wakeup();
         }

         ak var2 = var1.bc();
         String var3;
         if(var2 != null) {
            var3 = var2.aT();
            gr.S("In AdManger: loadAd, " + var2.toString());
         } else {
            var3 = null;
         }

         if(var3 != null) {
            Bundle var4 = new Bundle(1);
            var4.putString("fingerprint", var3);
            var4.putInt("v", 1);
            return var4;
         }
      }

      return null;
   }

   public void a(ay var1) {
      jx.aU("setAdSize must be called on the main UI thread.");
      this.lB.lS = var1;
      if(this.lB.lT != null && this.lB.mg == 0) {
         this.lB.lT.se.a(var1);
      }

      if(this.lB.lK.getChildCount() > 1) {
         this.lB.lK.removeView(this.lB.lK.getNextView());
      }

      this.lB.lK.setMinimumWidth(var1.widthPixels);
      this.lB.lK.setMinimumHeight(var1.heightPixels);
      this.lB.lK.requestLayout();
   }

   public void a(bc var1) {
      jx.aU("setAdListener must be called on the main UI thread.");
      this.lB.lP = var1;
   }

   public void a(bf var1) {
      jx.aU("setAppEventListener must be called on the main UI thread.");
      this.lB.lW = var1;
   }

   public void a(br var1) {
      jx.aU("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
      this.lB.mb = var1;
   }

   public void a(en var1) {
      jx.aU("setInAppPurchaseListener must be called on the main UI thread.");
      this.lB.lY = var1;
   }

   public void a(er var1, String var2) {
      jx.aU("setPlayStorePurchaseParams must be called on the main UI thread.");
      this.lB.md = new ek(var2);
      this.lB.lX = var1;
      if(!ga.dj() && var1 != null) {
         (new ec(this.lB.lM, this.lB.lX, this.lB.md)).start();
      }

   }

   public void a(fy.a var1) {
      String var3 = null;
      this.lB.lQ = null;
      this.lB.lU = var1;
      this.a((List)null);
      gu var2;
      if(!var1.vK.ug) {
         final v var4 = new v();
         var2 = this.a(var4);
         var4.a(new v.b(var1, var2));
         var2.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View var1, MotionEvent var2) {
               var4.av();
               return false;
            }
         });
         var2.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               var4.av();
            }
         });
      } else {
         var2 = null;
      }

      if(var1.lS != null) {
         this.lB.lS = var1.lS;
      }

      if(var1.errorCode != -2) {
         this.a(new fy(var1, var2, (cq)null, (cz)null, (String)null, (ct)null, (bv.a)null));
      } else {
         if(!var1.vK.tW && var1.vK.uf) {
            if(var1.vK.sg != null) {
               var3 = Uri.parse(var1.vK.sg).buildUpon().query((String)null).build().toString();
            }

            bo var6 = new bo(this, var3, var1.vK.tU);

            try {
               if(this.lB.mb != null) {
                  this.lB.mg = 1;
                  this.lB.mb.a(var6);
                  return;
               }
            } catch (RemoteException var5) {
               gr.d("Could not call the onCustomRenderedAdLoadedListener.", var5);
            }
         }

         this.lB.mg = 0;
         this.lB.lR = fc.a(this.lB.lM, this, var1, var2, this.lA, this);
      }
   }

   public void a(fy var1) {
      this.lB.lR = null;
      boolean var4;
      if(var1.vI != null) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(var1.errorCode != -2 && var1.errorCode != 3) {
         ga.b(this.lB.ay());
      }

      if(var1.errorCode != -1) {
         if(this.a(var1, var4)) {
            gr.S("Ad refresh scheduled.");
         }

         if(var1.errorCode == 3 && var1.vE != null && var1.vE.qy != null) {
            gr.S("Pinging no fill URLs.");
            cw.a(this.lB.lM, this.lB.lO.wS, var1, this.lB.lL, false, var1.vE.qy);
         }

         if(var1.errorCode != -2) {
            this.a(var1.errorCode);
            return;
         }

         if(!this.lB.lS.oq && !var4 && this.lB.mg == 0) {
            if(!this.b(var1)) {
               this.a(0);
               return;
            }

            if(this.lB.lK != null) {
               this.lB.lK.lJ.Q(var1.ub);
            }
         }

         if(this.lB.lT != null && this.lB.lT.qS != null) {
            this.lB.lT.qS.a((cs)null);
         }

         if(var1.qS != null) {
            var1.qS.a((cs)this);
         }

         this.lD.d(this.lB.lT);
         this.lB.lT = var1;
         this.lB.lV.j(var1.vG);
         this.lB.lV.k(var1.vH);
         this.lB.lV.v(this.lB.lS.oq);
         this.lB.lV.w(var1.tW);
         if(!this.lB.lS.oq && !var4 && this.lB.mg == 0) {
            this.e(false);
         }

         if(this.lB.me == null) {
            this.lB.me = new gd(this.lB.lL);
         }

         int var2;
         int var3;
         if(var1.vE != null) {
            var3 = var1.vE.qB;
            var2 = var1.vE.qC;
         } else {
            var2 = 0;
            var3 = 0;
         }

         this.lB.me.d(var3, var2);
         if(this.lB.mg == 0) {
            if(!this.lB.lS.oq && var1.se != null && (var1.se.dD().dN() || var1.vD != null)) {
               af var5 = this.lD.a(this.lB.lS, this.lB.lT);
               if(var1.se.dD().dN() && var5 != null) {
                  var5.a((ac)(new aa(var1.se)));
               }
            }

            if(this.lB.lT.se != null) {
               this.lB.lT.se.cb();
               this.lB.lT.se.dD().dO();
            }

            if(var4) {
               bv.a var6 = var1.vI;
               if(var6 instanceof bu && this.lB.ma != null) {
                  this.at();
               } else {
                  if(!(var6 instanceof bt) || this.lB.lZ == null) {
                     gr.W("No matching listener for retrieved native ad template.");
                     this.a(0);
                     return;
                  }

                  this.as();
               }
            }

            this.ar();
            return;
         }

         if(this.lB.mf != null && var1.vD != null) {
            this.lD.a(this.lB.lM, this.lB.lS, this.lB.lT, this.lB.mf, this.lB.lO);
            return;
         }
      }

   }

   public void a(String var1, ArrayList var2) {
      ed var5 = new ed(var1, var2, this.lB.lM, this.lB.lO.wS);
      if(this.lB.lY == null) {
         gr.W("InAppPurchaseListener is not set. Try to launch default purchase flow.");
         if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.lB.lM) != 0) {
            gr.W("Google Play Service unavailable, cannot launch default purchase flow.");
         } else if(this.lB.lX == null) {
            gr.W("PlayStorePurchaseListener is not set.");
         } else if(this.lB.md == null) {
            gr.W("PlayStorePurchaseVerifier is not initialized.");
         } else if(this.lB.mh) {
            gr.W("An in-app purchase request is already in progress, abort");
         } else {
            this.lB.mh = true;

            try {
               if(!this.lB.lX.isValidPurchase(var1)) {
                  this.lB.mh = false;
                  return;
               }
            } catch (RemoteException var4) {
               gr.W("Could not start In-App purchase.");
               this.lB.mh = false;
               return;
            }

            ee.a(this.lB.lM, this.lB.lO.wV, new ea(this.lB.lM, this.lB.md, var5, this));
         }
      } else {
         try {
            this.lB.lY.a(var5);
         } catch (RemoteException var3) {
            gr.W("Could not start In-App purchase.");
         }
      }
   }

   public void a(String var1, boolean var2, int var3, final Intent var4, ef var5) {
      try {
         if(this.lB.lX != null) {
            this.lB.lX.a(new eg(this.lB.lM, var1, var2, var3, var4, var5));
         }
      } catch (RemoteException var6) {
         gr.W("Fail to invoke PlayStorePurchaseListener.");
      }

      gq.wR.postDelayed(new Runnable() {
         public void run() {
            if(ei.d(var4) == 0 && u.this.lB.lT != null && u.this.lB.lT.se != null && u.this.lB.lT.se.dC() != null) {
               u.this.lB.lT.se.dC().close();
            }

            u.this.lB.mh = false;
         }
      }, 500L);
   }

   public void a(HashSet var1) {
      this.lB.a(var1);
   }

   public void a(List var1) {
      jx.aU("setNativeTemplates must be called on the main UI thread.");
      this.lB.mc = var1;
   }

   public boolean a(av var1) {
      jx.aU("loadAd must be called on the main UI thread.");
      if(this.lB.lQ == null && this.lB.lR == null) {
         if(this.lB.lS.oq && this.lB.lT != null) {
            gr.W("An interstitial is already loading. Aborting.");
            return false;
         }

         if(this.au()) {
            gr.U("Starting ad request.");
            if(!var1.og) {
               gr.U("Use AdRequest.Builder.addTestDevice(\"" + gq.v(this.lB.lM) + "\") to get test ads on this device.");
            }

            Bundle var2 = this.a(ga.dc().l(this.lB.lM));
            this.lC.cancel();
            this.lB.mg = 0;
            fh.a var3 = this.a(var1, var2);
            this.lB.lQ = ez.a(this.lB.lM, var3, this.lB.lN, this);
            return true;
         }
      } else {
         if(this.lz != null) {
            gr.W("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
         }

         this.lz = var1;
      }

      return false;
   }

   boolean a(fy var1, boolean var2) {
      boolean var3 = false;
      av var4;
      if(this.lz != null) {
         var4 = this.lz;
         this.lz = null;
      } else {
         av var5 = var1.tL;
         var4 = var5;
         if(var5.extras != null) {
            var3 = var5.extras.getBoolean("_noRefresh", false);
            var4 = var5;
         }
      }

      if(this.lB.lS.oq) {
         if(this.lB.mg == 0) {
            gi.a((WebView)var1.se);
         }
      } else if(!(var3 | var2) && this.lB.mg == 0) {
         if(var1.qA > 0L) {
            this.lC.a(var4, var1.qA);
         } else if(var1.vE != null && var1.vE.qA > 0L) {
            this.lC.a(var4, var1.vE.qA);
         } else if(!var1.tW && var1.errorCode == 2) {
            this.lC.c(var4);
         }
      }

      return this.lC.aD();
   }

   public com.google.android.gms.dynamic.d ab() {
      jx.aU("getAdFrame must be called on the main UI thread.");
      return com.google.android.gms.dynamic.e.k(this.lB.lK);
   }

   public ay ac() {
      jx.aU("getAdSize must be called on the main UI thread.");
      return this.lB.lS;
   }

   public void af() {
      this.ap();
   }

   public void ag() {
      this.lD.d(this.lB.lT);
      if(this.lB.lS.oq) {
         this.ax();
      }

      this.lE = false;
      this.ao();
      this.lB.lV.cY();
   }

   public void ah() {
      if(this.lB.lS.oq) {
         this.e(false);
      }

      this.lE = true;
      this.aq();
   }

   public void ai() {
      this.onAdClicked();
   }

   public void aj() {
      this.ag();
   }

   public void ak() {
      this.af();
   }

   public void al() {
      this.ah();
   }

   public void am() {
      if(this.lB.lT != null) {
         gr.W("Mediation adapter " + this.lB.lT.qR + " refreshed, but mediation adapters should never refresh.");
      }

      this.e(true);
      this.ar();
   }

   public void an() {
      jx.aU("recordManualImpression must be called on the main UI thread.");
      if(this.lB.lT == null) {
         gr.W("Ad state was null when trying to ping manual tracking URLs.");
      } else {
         gr.S("Pinging manual tracking URLs.");
         if(this.lB.lT.tY != null) {
            gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.tY);
            return;
         }
      }

   }

   public boolean au() {
      boolean var1 = true;
      if(!gi.a(this.lB.lM.getPackageManager(), this.lB.lM.getPackageName(), "android.permission.INTERNET")) {
         if(!this.lB.lS.oq) {
            gq.a(this.lB.lK, this.lB.lS, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
         }

         var1 = false;
      }

      if(!gi.p(this.lB.lM)) {
         if(!this.lB.lS.oq) {
            gq.a(this.lB.lK, this.lB.lS, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
         }

         var1 = false;
      }

      if(!var1 && !this.lB.lS.oq) {
         this.lB.lK.setVisibility(0);
      }

      return var1;
   }

   public void av() {
      if(this.lB.lT == null) {
         gr.W("Ad state was null when trying to ping click URLs.");
      } else {
         gr.S("Pinging click URLs.");
         this.lB.lV.cX();
         if(this.lB.lT.qw != null) {
            gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qw);
         }

         if(this.lB.lT.vE != null && this.lB.lT.vE.qw != null) {
            cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, false, this.lB.lT.vE.qw);
            return;
         }
      }

   }

   public void aw() {
      this.e(false);
   }

   public void b(View var1) {
      this.lB.mf = var1;
      this.a(new fy(this.lB.lU, (gu)null, (cq)null, (cz)null, (String)null, (ct)null, (bv.a)null));
   }

   public void b(av var1) {
      ViewParent var2 = this.lB.lK.getParent();
      if(var2 instanceof View && ((View)var2).isShown() && gi.dt() && !this.lE) {
         this.a(var1);
      } else {
         gr.U("Ad is not visible. Not refreshing ad.");
         this.lC.c(var1);
      }
   }

   public void d(boolean var1) {
      this.lB.mi = var1;
   }

   public void destroy() {
      jx.aU("destroy must be called on the main UI thread.");
      this.ae();
      this.lB.lP = null;
      this.lB.lW = null;
      this.lB.lX = null;
      this.lB.lY = null;
      this.lB.mb = null;
      this.lC.cancel();
      this.lD.stop();
      this.stopLoading();
      if(this.lB.lK != null) {
         this.lB.lK.removeAllViews();
      }

      if(this.lB.lT != null && this.lB.lT.se != null) {
         this.lB.lT.se.destroy();
      }

      if(this.lB.lT != null && this.lB.lT.qQ != null) {
         try {
            this.lB.lT.qQ.destroy();
         } catch (RemoteException var2) {
            gr.W("Could not destroy mediation adapter.");
            return;
         }
      }

   }

   public String getMediationAdapterClassName() {
      return this.lB.lT != null?this.lB.lT.qR:null;
   }

   public boolean isReady() {
      jx.aU("isLoaded must be called on the main UI thread.");
      return this.lB.lQ == null && this.lB.lR == null && this.lB.lT != null;
   }

   public void onAdClicked() {
      this.av();
   }

   public void onAppEvent(String var1, String var2) {
      if(this.lB.lW != null) {
         try {
            this.lB.lW.onAppEvent(var1, var2);
         } catch (RemoteException var3) {
            gr.d("Could not call the AppEventListener.", var3);
            return;
         }
      }

   }

   public void pause() {
      jx.aU("pause must be called on the main UI thread.");
      if(this.lB.lT != null && this.lB.mg == 0) {
         gi.a((WebView)this.lB.lT.se);
      }

      if(this.lB.lT != null && this.lB.lT.qQ != null) {
         try {
            this.lB.lT.qQ.pause();
         } catch (RemoteException var2) {
            gr.W("Could not pause mediation adapter.");
         }
      }

      this.lD.pause();
      this.lC.pause();
   }

   public void resume() {
      jx.aU("resume must be called on the main UI thread.");
      if(this.lB.lT != null && this.lB.mg == 0) {
         gi.b(this.lB.lT.se);
      }

      if(this.lB.lT != null && this.lB.lT.qQ != null) {
         try {
            this.lB.lT.qQ.resume();
         } catch (RemoteException var2) {
            gr.W("Could not resume mediation adapter.");
         }
      }

      this.lC.resume();
      this.lD.resume();
   }

   public void showInterstitial() {
      jx.aU("showInterstitial must be called on the main UI thread.");
      if(!this.lB.lS.oq) {
         gr.W("Cannot call showInterstitial on a banner ad.");
      } else {
         if(this.lB.lT == null) {
            gr.W("The interstitial has not loaded.");
            return;
         }

         if(this.lB.mg != 1) {
            if(this.lB.lT.se.dH()) {
               gr.W("The interstitial is already showing.");
               return;
            }

            this.lB.lT.se.z(true);
            if(this.lB.lT.se.dD().dN() || this.lB.lT.vD != null) {
               af var3 = this.lD.a(this.lB.lS, this.lB.lT);
               if(this.lB.lT.se.dD().dN() && var3 != null) {
                  var3.a((ac)(new aa(this.lB.lT.se)));
               }
            }

            if(this.lB.lT.tW) {
               try {
                  this.lB.lT.qQ.showInterstitial();
                  return;
               } catch (RemoteException var7) {
                  gr.d("Could not show interstitial.", var7);
                  this.ax();
                  return;
               }
            }

            y var4 = new y(this.lB.mi, false);
            y var8 = var4;
            if(this.lB.lM instanceof Activity) {
               Window var9 = ((Activity)this.lB.lM).getWindow();
               Rect var5 = new Rect();
               Rect var6 = new Rect();
               var9.getDecorView().getGlobalVisibleRect(var5);
               var9.getDecorView().getWindowVisibleDisplayFrame(var6);
               var8 = var4;
               if(var5.bottom != 0) {
                  var8 = var4;
                  if(var6.bottom != 0) {
                     boolean var2 = this.lB.mi;
                     boolean var1;
                     if(var5.top == var6.top) {
                        var1 = true;
                     } else {
                        var1 = false;
                     }

                     var8 = new y(var2, var1);
                  }
               }
            }

            dr var10 = new dr(this, this, this, this.lB.lT.se, this.lB.lT.orientation, this.lB.lO, this.lB.lT.ub, var8);
            dp.a(this.lB.lM, var10);
            return;
         }
      }

   }

   public void stopLoading() {
      jx.aU("stopLoading must be called on the main UI thread.");
      if(this.lB.lT != null && this.lB.mg == 0) {
         this.lB.lT.se.stopLoading();
         this.lB.lT = null;
      }

      if(this.lB.lQ != null) {
         this.lB.lQ.cancel();
      }

      if(this.lB.lR != null) {
         this.lB.lR.cancel();
      }

   }

   @ey
   private static final class a extends ViewSwitcher {
      private final gl lJ;

      public a(Context var1) {
         super(var1);
         this.lJ = new gl(var1);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         this.lJ.c(var1);
         return false;
      }
   }

   @ey
   static class b {
      public final u.a lK;
      public final String lL;
      public final Context lM;
      public final k lN;
      public final gs lO;
      public bc lP;
      public gf lQ;
      public gf lR;
      public ay lS;
      public fy lT;
      public fy.a lU;
      public fz lV;
      public bf lW;
      public er lX;
      public en lY;
      public by lZ;
      public bz ma;
      public br mb;
      public List mc;
      public ek md;
      public gd me = null;
      public View mf = null;
      public int mg = 0;
      public boolean mh = false;
      public boolean mi = false;
      private HashSet mj = null;

      public b(Context var1, ay var2, String var3, gs var4) {
         if(var2.oq) {
            this.lK = null;
         } else {
            this.lK = new u.a(var1);
            this.lK.setMinimumWidth(var2.widthPixels);
            this.lK.setMinimumHeight(var2.heightPixels);
            this.lK.setVisibility(4);
         }

         this.lS = var2;
         this.lL = var3;
         this.lM = var1;
         this.lO = var4;
         this.lN = new k(new x(this));
      }

      public void a(HashSet var1) {
         this.mj = var1;
      }

      public HashSet ay() {
         return this.mj;
      }
   }
}
