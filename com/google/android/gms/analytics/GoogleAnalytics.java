package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.TrackerHandler;
import com.google.android.gms.analytics.aa;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.ai;
import com.google.android.gms.analytics.aj;
import com.google.android.gms.analytics.f;
import com.google.android.gms.analytics.g;
import com.google.android.gms.analytics.k;
import com.google.android.gms.analytics.p;
import com.google.android.gms.analytics.v;
import com.google.android.gms.analytics.x;
import com.google.android.gms.analytics.y;
import com.google.android.gms.analytics.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
   private static boolean Bm;
   private static GoogleAnalytics Bs;
   private aj Bn;
   private volatile Boolean Bo;
   private Logger Bp;
   private Set Bq;
   private boolean Br;
   private Context mContext;
   private f yV;
   private String ya;
   private String yb;
   private boolean yt;

   protected GoogleAnalytics(Context var1) {
      this(var1, x.A(var1), v.eu());
   }

   private GoogleAnalytics(Context var1, f var2, aj var3) {
      this.Bo = Boolean.valueOf(false);
      this.Br = false;
      if(var1 == null) {
         throw new IllegalArgumentException("context cannot be null");
      } else {
         this.mContext = var1.getApplicationContext();
         this.yV = var2;
         this.Bn = var3;
         g.y(this.mContext);
         ai.y(this.mContext);
         k.y(this.mContext);
         this.Bp = new p();
         this.Bq = new HashSet();
         this.eZ();
      }
   }

   private Tracker a(Tracker var1) {
      if(this.ya != null) {
         var1.set("&an", this.ya);
      }

      if(this.yb != null) {
         var1.set("&av", this.yb);
      }

      return var1;
   }

   private int ai(String var1) {
      var1 = var1.toLowerCase();
      return "verbose".equals(var1)?0:("info".equals(var1)?1:("warning".equals(var1)?2:("error".equals(var1)?3:-1)));
   }

   static GoogleAnalytics eY() {
      // $FF: Couldn't be decompiled
   }

   private void eZ() {
      if(!Bm) {
         ApplicationInfo var2;
         try {
            var2 = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
         } catch (NameNotFoundException var3) {
            ae.V("PackageManager doesn\'t know about package: " + var3);
            var2 = null;
         }

         if(var2 == null) {
            ae.W("Couldn\'t get ApplicationInfo to load gloabl config.");
            return;
         }

         Bundle var4 = var2.metaData;
         if(var4 != null) {
            int var1 = var4.getInt("com.google.android.gms.analytics.globalConfigResource");
            if(var1 > 0) {
               aa var5 = (aa)(new z(this.mContext)).x(var1);
               if(var5 != null) {
                  this.a(var5);
                  return;
               }
            }
         }
      }

   }

   public static GoogleAnalytics getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   void a(GoogleAnalytics.a var1) {
      this.Bq.add(var1);
      if(this.mContext instanceof Application) {
         this.enableAutoActivityReports((Application)this.mContext);
      }

   }

   void a(aa var1) {
      ae.V("Loading global config values.");
      if(var1.eO()) {
         this.ya = var1.eP();
         ae.V("app name loaded: " + this.ya);
      }

      if(var1.eQ()) {
         this.yb = var1.eR();
         ae.V("app version loaded: " + this.yb);
      }

      if(var1.eS()) {
         int var2 = this.ai(var1.eT());
         if(var2 >= 0) {
            ae.V("log level loaded: " + var2);
            this.getLogger().setLogLevel(var2);
         }
      }

      if(var1.eU()) {
         this.Bn.setLocalDispatchPeriod(var1.eV());
      }

      if(var1.eW()) {
         this.setDryRun(var1.eX());
      }

   }

   void b(GoogleAnalytics.a var1) {
      this.Bq.remove(var1);
   }

   void dY() {
      this.yV.dY();
   }

   @Deprecated
   public void dispatchLocalHits() {
      this.Bn.dispatchLocalHits();
   }

   public void enableAutoActivityReports(Application var1) {
      if(VERSION.SDK_INT >= 14 && !this.Br) {
         var1.registerActivityLifecycleCallbacks(new GoogleAnalytics.b());
         this.Br = true;
      }

   }

   void g(Activity var1) {
      Iterator var2 = this.Bq.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.a)var2.next()).i(var1);
      }

   }

   public boolean getAppOptOut() {
      y.eK().a(y.a.AN);
      return this.Bo.booleanValue();
   }

   public Logger getLogger() {
      return this.Bp;
   }

   void h(Activity var1) {
      Iterator var2 = this.Bq.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.a)var2.next()).j(var1);
      }

   }

   public boolean isDryRunEnabled() {
      y.eK().a(y.a.AZ);
      return this.yt;
   }

   public Tracker newTracker(int param1) {
      // $FF: Couldn't be decompiled
   }

   public Tracker newTracker(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void reportActivityStart(Activity var1) {
      if(!this.Br) {
         this.g(var1);
      }

   }

   public void reportActivityStop(Activity var1) {
      if(!this.Br) {
         this.h(var1);
      }

   }

   public void setAppOptOut(boolean var1) {
      y.eK().a(y.a.AM);
      this.Bo = Boolean.valueOf(var1);
      if(this.Bo.booleanValue()) {
         this.yV.dQ();
      }

   }

   public void setDryRun(boolean var1) {
      y.eK().a(y.a.AY);
      this.yt = var1;
   }

   @Deprecated
   public void setLocalDispatchPeriod(int var1) {
      this.Bn.setLocalDispatchPeriod(var1);
   }

   public void setLogger(Logger var1) {
      y.eK().a(y.a.Ba);
      this.Bp = var1;
   }

   void u(Map param1) {
      // $FF: Couldn't be decompiled
   }

   interface a {
      void i(Activity var1);

      void j(Activity var1);
   }

   class b implements ActivityLifecycleCallbacks {
      public void onActivityCreated(Activity var1, Bundle var2) {
      }

      public void onActivityDestroyed(Activity var1) {
      }

      public void onActivityPaused(Activity var1) {
      }

      public void onActivityResumed(Activity var1) {
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      }

      public void onActivityStarted(Activity var1) {
         GoogleAnalytics.this.g(var1);
      }

      public void onActivityStopped(Activity var1) {
         GoogleAnalytics.this.h(var1);
      }
   }
}
