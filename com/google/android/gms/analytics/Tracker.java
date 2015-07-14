package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.TrackerHandler;
import com.google.android.gms.analytics.ad;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.ah;
import com.google.android.gms.analytics.ai;
import com.google.android.gms.analytics.am;
import com.google.android.gms.analytics.an;
import com.google.android.gms.analytics.g;
import com.google.android.gms.analytics.k;
import com.google.android.gms.analytics.y;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
   private final TrackerHandler Ce;
   private final Map Cf;
   private ah Cg;
   private final k Ch;
   private final ai Ci;
   private final g Cj;
   private boolean Ck;
   private Tracker.a Cl;
   private am Cm;
   private ExceptionReporter Cn;
   private Context mContext;
   private final Map rd;

   Tracker(String var1, TrackerHandler var2, Context var3) {
      this(var1, var2, k.el(), ai.fl(), g.dZ(), new ad("tracking"), var3);
   }

   Tracker(String var1, TrackerHandler var2, k var3, ai var4, g var5, ah var6, Context var7) {
      this.rd = new HashMap();
      this.Cf = new HashMap();
      this.Ce = var2;
      if(var7 != null) {
         this.mContext = var7.getApplicationContext();
      }

      if(var1 != null) {
         this.rd.put("&tid", var1);
      }

      this.rd.put("useSecure", "1");
      this.Ch = var3;
      this.Ci = var4;
      this.Cj = var5;
      this.rd.put("&a", Integer.toString((new Random()).nextInt(Integer.MAX_VALUE) + 1));
      this.Cg = var6;
      this.Cl = new Tracker.a();
      this.enableAdvertisingIdCollection(false);
   }

   void a(am var1) {
      ae.V("Loading Tracker config values.");
      this.Cm = var1;
      String var2;
      if(this.Cm.ft()) {
         var2 = this.Cm.fu();
         this.set("&tid", var2);
         ae.V("[Tracker] trackingId loaded: " + var2);
      }

      if(this.Cm.fv()) {
         var2 = Double.toString(this.Cm.fw());
         this.set("&sf", var2);
         ae.V("[Tracker] sample frequency loaded: " + var2);
      }

      if(this.Cm.fx()) {
         this.setSessionTimeout((long)this.Cm.getSessionTimeout());
         ae.V("[Tracker] session timeout loaded: " + this.fn());
      }

      if(this.Cm.fy()) {
         this.enableAutoActivityTracking(this.Cm.fz());
         ae.V("[Tracker] auto activity tracking loaded: " + this.fo());
      }

      if(this.Cm.fA()) {
         if(this.Cm.fB()) {
            this.set("&aip", "1");
            ae.V("[Tracker] anonymize ip loaded: true");
         }

         ae.V("[Tracker] anonymize ip loaded: false");
      }

      this.enableExceptionReporting(this.Cm.fC());
   }

   public void enableAdvertisingIdCollection(boolean var1) {
      if(!var1) {
         this.rd.put("&ate", (Object)null);
         this.rd.put("&adid", (Object)null);
      } else {
         if(this.rd.containsKey("&ate")) {
            this.rd.remove("&ate");
         }

         if(this.rd.containsKey("&adid")) {
            this.rd.remove("&adid");
            return;
         }
      }

   }

   public void enableAutoActivityTracking(boolean var1) {
      this.Cl.enableAutoActivityTracking(var1);
   }

   public void enableExceptionReporting(boolean var1) {
      if(this.Ck != var1) {
         this.Ck = var1;
         if(var1) {
            this.Cn = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
            Thread.setDefaultUncaughtExceptionHandler(this.Cn);
            ae.V("Uncaught exceptions will be reported to Google Analytics.");
         } else {
            if(this.Cn != null) {
               Thread.setDefaultUncaughtExceptionHandler(this.Cn.et());
            } else {
               Thread.setDefaultUncaughtExceptionHandler((UncaughtExceptionHandler)null);
            }

            ae.V("Uncaught exceptions will not be reported to Google Analytics.");
         }
      }
   }

   long fn() {
      return this.Cl.fn();
   }

   boolean fo() {
      return this.Cl.fo();
   }

   public String get(String var1) {
      y.eK().a(y.a.Af);
      if(!TextUtils.isEmpty(var1)) {
         if(this.rd.containsKey(var1)) {
            return (String)this.rd.get(var1);
         }

         if(var1.equals("&ul")) {
            return an.a(Locale.getDefault());
         }

         if(this.Ch != null && this.Ch.ac(var1)) {
            return this.Ch.getValue(var1);
         }

         if(this.Ci != null && this.Ci.ac(var1)) {
            return this.Ci.getValue(var1);
         }

         if(this.Cj != null && this.Cj.ac(var1)) {
            return this.Cj.getValue(var1);
         }
      }

      return null;
   }

   public void send(Map var1) {
      y.eK().a(y.a.Ah);
      HashMap var5 = new HashMap();
      var5.putAll(this.rd);
      if(var1 != null) {
         var5.putAll(var1);
      }

      Iterator var6 = this.Cf.keySet().iterator();

      String var4;
      while(var6.hasNext()) {
         var4 = (String)var6.next();
         if(!var5.containsKey(var4)) {
            var5.put(var4, this.Cf.get(var4));
         }
      }

      this.Cf.clear();
      if(TextUtils.isEmpty((CharSequence)var5.get("&tid"))) {
         ae.W(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
      }

      var4 = (String)var5.get("&t");
      String var7 = var4;
      if(TextUtils.isEmpty(var4)) {
         ae.W(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
         var7 = "";
      }

      if(this.Cl.fp()) {
         var5.put("&sc", "start");
      }

      var7 = var7.toLowerCase();
      if("screenview".equals(var7) || "pageview".equals(var7) || "appview".equals(var7) || TextUtils.isEmpty(var7)) {
         int var3 = Integer.parseInt((String)this.rd.get("&a")) + 1;
         int var2 = var3;
         if(var3 >= Integer.MAX_VALUE) {
            var2 = 1;
         }

         this.rd.put("&a", Integer.toString(var2));
      }

      if(!var7.equals("transaction") && !var7.equals("item") && !this.Cg.fe()) {
         ae.W("Too many hits sent too quickly, rate limiting invoked.");
      } else {
         this.Ce.u(var5);
      }
   }

   public void set(String var1, String var2) {
      jx.b((Object)var1, "Key should be non-null");
      y.eK().a(y.a.Ag);
      this.rd.put(var1, var2);
   }

   public void setAnonymizeIp(boolean var1) {
      this.set("&aip", an.E(var1));
   }

   public void setAppId(String var1) {
      this.set("&aid", var1);
   }

   public void setAppInstallerId(String var1) {
      this.set("&aiid", var1);
   }

   public void setAppName(String var1) {
      this.set("&an", var1);
   }

   public void setAppVersion(String var1) {
      this.set("&av", var1);
   }

   public void setCampaignParamsOnNextHit(Uri var1) {
      if(var1 != null) {
         String var3 = var1.getQueryParameter("referrer");
         if(!TextUtils.isEmpty(var3)) {
            var1 = Uri.parse("http://hostname/?" + var3);
            String var2 = var1.getQueryParameter("utm_id");
            if(var2 != null) {
               this.Cf.put("&ci", var2);
            }

            var2 = var1.getQueryParameter("utm_campaign");
            if(var2 != null) {
               this.Cf.put("&cn", var2);
            }

            var2 = var1.getQueryParameter("utm_content");
            if(var2 != null) {
               this.Cf.put("&cc", var2);
            }

            var2 = var1.getQueryParameter("utm_medium");
            if(var2 != null) {
               this.Cf.put("&cm", var2);
            }

            var2 = var1.getQueryParameter("utm_source");
            if(var2 != null) {
               this.Cf.put("&cs", var2);
            }

            var2 = var1.getQueryParameter("utm_term");
            if(var2 != null) {
               this.Cf.put("&ck", var2);
            }

            var2 = var1.getQueryParameter("dclid");
            if(var2 != null) {
               this.Cf.put("&dclid", var2);
            }

            var3 = var1.getQueryParameter("gclid");
            if(var3 != null) {
               this.Cf.put("&gclid", var3);
               return;
            }
         }
      }

   }

   public void setClientId(String var1) {
      this.set("&cid", var1);
   }

   public void setEncoding(String var1) {
      this.set("&de", var1);
   }

   public void setHostname(String var1) {
      this.set("&dh", var1);
   }

   public void setLanguage(String var1) {
      this.set("&ul", var1);
   }

   public void setLocation(String var1) {
      this.set("&dl", var1);
   }

   public void setPage(String var1) {
      this.set("&dp", var1);
   }

   public void setReferrer(String var1) {
      this.set("&dr", var1);
   }

   public void setSampleRate(double var1) {
      this.set("&sf", Double.toHexString(var1));
   }

   public void setScreenColors(String var1) {
      this.set("&sd", var1);
   }

   public void setScreenName(String var1) {
      this.set("&cd", var1);
   }

   public void setScreenResolution(int var1, int var2) {
      if(var1 < 0 && var2 < 0) {
         ae.W("Invalid width or height. The values should be non-negative.");
      } else {
         this.set("&sr", var1 + "x" + var2);
      }
   }

   public void setSessionTimeout(long var1) {
      this.Cl.setSessionTimeout(1000L * var1);
   }

   public void setTitle(String var1) {
      this.set("&dt", var1);
   }

   public void setUseSecure(boolean var1) {
      this.set("useSecure", an.E(var1));
   }

   public void setViewportSize(String var1) {
      this.set("&vp", var1);
   }

   private class a implements GoogleAnalytics.a {
      private boolean Co = false;
      private int Cp = 0;
      private long Cq = -1L;
      private boolean Cr = false;
      private long Cs;
      private ld wb = lf.if();

      private void fq() {
         GoogleAnalytics var1 = GoogleAnalytics.eY();
         if(var1 == null) {
            ae.T("GoogleAnalytics isn\'t initialized for the Tracker!");
         } else if(this.Cq < 0L && !this.Co) {
            var1.b(Tracker.this.Cl);
         } else {
            var1.a((GoogleAnalytics.a)Tracker.this.Cl);
         }
      }

      public void enableAutoActivityTracking(boolean var1) {
         this.Co = var1;
         this.fq();
      }

      public long fn() {
         return this.Cq;
      }

      public boolean fo() {
         return this.Co;
      }

      public boolean fp() {
         boolean var1 = this.Cr;
         this.Cr = false;
         return var1;
      }

      boolean fr() {
         return this.wb.elapsedRealtime() >= this.Cs + Math.max(1000L, this.Cq);
      }

      public void i(Activity var1) {
         y.eK().a(y.a.Be);
         if(this.Cp == 0 && this.fr()) {
            this.Cr = true;
         }

         ++this.Cp;
         if(this.Co) {
            Intent var2 = var1.getIntent();
            if(var2 != null) {
               Tracker.this.setCampaignParamsOnNextHit(var2.getData());
            }

            HashMap var5 = new HashMap();
            var5.put("&t", "screenview");
            y.eK().D(true);
            Tracker var3 = Tracker.this;
            String var4;
            if(Tracker.this.Cm != null) {
               var4 = Tracker.this.Cm.k(var1);
            } else {
               var4 = var1.getClass().getCanonicalName();
            }

            var3.set("&cd", var4);
            Tracker.this.send(var5);
            y.eK().D(false);
         }

      }

      public void j(Activity var1) {
         y.eK().a(y.a.Bf);
         --this.Cp;
         this.Cp = Math.max(0, this.Cp);
         if(this.Cp == 0) {
            this.Cs = this.wb.elapsedRealtime();
         }

      }

      public void setSessionTimeout(long var1) {
         this.Cq = var1;
         this.fq();
      }
   }
}
