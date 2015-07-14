package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.ll;
import com.google.android.gms.internal.t;

@ey
public class dp extends dx.a {
   private static final int rL = Color.argb(0, 0, 0, 0);
   private gu mo;
   private final Activity nB;
   private dr rM;
   private dt rN;
   private dp.c rO;
   private du rP;
   private boolean rQ;
   private boolean rR = false;
   private FrameLayout rS;
   private CustomViewCallback rT;
   private boolean rU = false;
   private boolean rV = false;
   private boolean rW = false;
   private RelativeLayout rX;

   public dp(Activity var1) {
      this.nB = var1;
   }

   private static LayoutParams a(int var0, int var1, int var2, int var3) {
      LayoutParams var4 = new LayoutParams(var2, var3);
      var4.setMargins(var0, var1, 0, 0);
      var4.addRule(10);
      var4.addRule(9);
      return var4;
   }

   public static void a(Context var0, dr var1) {
      Intent var2 = new Intent();
      var2.setClassName(var0, "com.google.android.gms.ads.AdActivity");
      var2.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", var1.lO.wV);
      dr.a(var2, var1);
      if(!ll.in()) {
         var2.addFlags(524288);
      }

      if(!(var0 instanceof Activity)) {
         var2.addFlags(268435456);
      }

      var0.startActivity(var2);
   }

   public void X() {
      this.rQ = true;
   }

   public void a(View var1, CustomViewCallback var2) {
      this.rS = new FrameLayout(this.nB);
      this.rS.setBackgroundColor(-16777216);
      this.rS.addView(var1, -1, -1);
      this.nB.setContentView(this.rS);
      this.X();
      this.rT = var2;
      this.rR = true;
   }

   public void b(int var1, int var2, int var3, int var4) {
      if(this.rN != null) {
         this.rN.setLayoutParams(a(var1, var2, var3, var4));
      }

   }

   public void c(int var1, int var2, int var3, int var4) {
      if(this.rN == null) {
         this.rN = new dt(this.nB, this.mo);
         this.rX.addView(this.rN, 0, a(var1, var2, var3, var4));
         this.mo.dD().A(false);
      }

   }

   public dt ce() {
      return this.rN;
   }

   public void cf() {
      if(this.rM != null && this.rR) {
         this.setRequestedOrientation(this.rM.orientation);
      }

      if(this.rS != null) {
         this.nB.setContentView(this.rX);
         this.X();
         this.rS.removeAllViews();
         this.rS = null;
      }

      if(this.rT != null) {
         this.rT.onCustomViewHidden();
         this.rT = null;
      }

      this.rR = false;
   }

   public void cg() {
      this.rX.removeView(this.rP);
      this.p(true);
   }

   void ch() {
      if(this.nB.isFinishing() && !this.rV) {
         this.rV = true;
         if(this.nB.isFinishing()) {
            if(this.mo != null) {
               this.cj();
               this.rX.removeView(this.mo);
               if(this.rO != null) {
                  this.mo.z(false);
                  this.rO.sa.addView(this.mo, this.rO.index, this.rO.rZ);
               }
            }

            if(this.rM != null && this.rM.sd != null) {
               this.rM.sd.ag();
               return;
            }
         }
      }

   }

   void ci() {
      this.mo.ci();
   }

   void cj() {
      this.mo.cj();
   }

   public void close() {
      this.nB.finish();
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void onDestroy() {
      if(this.rN != null) {
         this.rN.destroy();
      }

      if(this.mo != null) {
         this.rX.removeView(this.mo);
      }

      this.ch();
   }

   public void onPause() {
      if(this.rN != null) {
         this.rN.pause();
      }

      this.cf();
      if(this.mo != null && (!this.nB.isFinishing() || this.rO == null)) {
         gi.a((WebView)this.mo);
      }

      this.ch();
   }

   public void onRestart() {
   }

   public void onResume() {
      if(this.rM != null && this.rM.sk == 4) {
         if(this.rU) {
            this.nB.finish();
         } else {
            this.rU = true;
         }
      }

      if(this.mo != null) {
         gi.b(this.mo);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      var1.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.rU);
   }

   public void onStart() {
   }

   public void onStop() {
      this.ch();
   }

   public void p(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 50;
      } else {
         var2 = 32;
      }

      this.rP = new du(this.nB, var2);
      LayoutParams var3 = new LayoutParams(-2, -2);
      var3.addRule(10);
      if(var1) {
         var2 = 11;
      } else {
         var2 = 9;
      }

      var3.addRule(var2);
      this.rP.q(this.rM.sh);
      this.rX.addView(this.rP, var3);
   }

   public void q(boolean var1) {
      if(this.rP != null) {
         this.rP.q(var1);
      }

   }

   void r(boolean var1) throws dp.a {
      if(!this.rQ) {
         this.nB.requestWindowFeature(1);
      }

      Window var3 = this.nB.getWindow();
      if(!this.rW || this.rM.sn.ms) {
         var3.setFlags(1024, 1024);
      }

      this.setRequestedOrientation(this.rM.orientation);
      if(VERSION.SDK_INT >= 11) {
         gr.S("Enabling hardware acceleration on the AdActivity window.");
         gm.a(var3);
      }

      this.rX = new dp.b(this.nB, this.rM.sm);
      if(!this.rW) {
         this.rX.setBackgroundColor(-16777216);
      } else {
         this.rX.setBackgroundColor(rL);
      }

      this.nB.setContentView(this.rX);
      this.X();
      boolean var2 = this.rM.se.dD().dN();
      if(var1) {
         this.mo = gu.a(this.nB, this.rM.se.ac(), true, var2, (k)null, this.rM.lO);
         this.mo.dD().a((t)null, (ds)null, this.rM.sf, this.rM.sj, true, this.rM.sl, this.rM.se.dD().dM());
         this.mo.dD().a(new gv.a() {
            public void a(gu var1) {
               var1.ci();
            }
         });
         if(this.rM.rH != null) {
            this.mo.loadUrl(this.rM.rH);
         } else {
            if(this.rM.si == null) {
               throw new dp.a("No URL or HTML to display in ad overlay.");
            }

            this.mo.loadDataWithBaseURL(this.rM.sg, this.rM.si, "text/html", "UTF-8", (String)null);
         }
      } else {
         this.mo = this.rM.se;
         this.mo.setContext(this.nB);
      }

      this.mo.a(this);
      ViewParent var4 = this.mo.getParent();
      if(var4 != null && var4 instanceof ViewGroup) {
         ((ViewGroup)var4).removeView(this.mo);
      }

      if(this.rW) {
         this.mo.setBackgroundColor(rL);
      }

      this.rX.addView(this.mo, -1, -1);
      if(!var1) {
         this.ci();
      }

      this.p(var2);
      if(this.mo.dE()) {
         this.q(true);
      }

   }

   public void setRequestedOrientation(int var1) {
      this.nB.setRequestedOrientation(var1);
   }

   @ey
   private static final class a extends Exception {
      public a(String var1) {
         super(var1);
      }
   }

   @ey
   private static final class b extends RelativeLayout {
      private final gl lJ;

      public b(Context var1, String var2) {
         super(var1);
         this.lJ = new gl(var1, var2);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         this.lJ.c(var1);
         return false;
      }
   }

   @ey
   private static final class c {
      public final int index;
      public final android.view.ViewGroup.LayoutParams rZ;
      public final ViewGroup sa;

      public c(gu var1) throws dp.a {
         this.rZ = var1.getLayoutParams();
         ViewParent var2 = var1.getParent();
         if(var2 instanceof ViewGroup) {
            this.sa = (ViewGroup)var2;
            this.index = this.sa.indexOfChild(var1);
            this.sa.removeView(var1);
            var1.z(true);
         } else {
            throw new dp.a("Could not get the parent of the WebView for an overlay.");
         }
      }
   }
}
