package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class gu extends WebView implements DownloadListener {
   private final Object mH = new Object();
   private final WindowManager mR;
   private ay qI;
   private final gs qJ;
   private final k tl;
   private final gv wW;
   private final gu.a wX;
   private dp wY;
   private boolean wZ;
   private boolean xa;
   private boolean xb;
   private boolean xc;

   protected gu(gu.a var1, ay var2, boolean var3, boolean var4, k var5, gs var6) {
      super(var1);
      this.wX = var1;
      this.qI = var2;
      this.wZ = var3;
      this.tl = var5;
      this.qJ = var6;
      this.mR = (WindowManager)this.getContext().getSystemService("window");
      this.setBackgroundColor(0);
      WebSettings var7 = this.getSettings();
      var7.setJavaScriptEnabled(true);
      var7.setSavePassword(false);
      var7.setSupportMultipleWindows(true);
      var7.setJavaScriptCanOpenWindowsAutomatically(true);
      gi.a((Context)var1, (String)var6.wS, (WebSettings)var7);
      if(VERSION.SDK_INT >= 17) {
         go.a(this.getContext(), var7);
      } else if(VERSION.SDK_INT >= 11) {
         gm.a(this.getContext(), var7);
      }

      this.setDownloadListener(this);
      if(VERSION.SDK_INT >= 11) {
         this.wW = new gx(this, var4);
      } else {
         this.wW = new gv(this, var4);
      }

      this.setWebViewClient(this.wW);
      if(VERSION.SDK_INT >= 14) {
         this.setWebChromeClient(new gy(this));
      } else if(VERSION.SDK_INT >= 11) {
         this.setWebChromeClient(new gw(this));
      }

      this.dJ();
   }

   public static gu a(Context var0, ay var1, boolean var2, boolean var3, k var4, gs var5) {
      return new gu(new gu.a(var0), var1, var2, var3, var4, var5);
   }

   private void dJ() {
      // $FF: Couldn't be decompiled
   }

   private void dK() {
      // $FF: Couldn't be decompiled
   }

   private void dL() {
      // $FF: Couldn't be decompiled
   }

   protected void X(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(Context param1, ay param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(ay param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(dp param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(String var1, Map var2) {
      JSONObject var4;
      try {
         var4 = gi.t(var2);
      } catch (JSONException var3) {
         gr.W("Could not convert parameters to JSON.");
         return;
      }

      this.b(var1, var4);
   }

   public void a(String var1, JSONObject var2) {
      JSONObject var3 = var2;
      if(var2 == null) {
         var3 = new JSONObject();
      }

      String var4 = var3.toString();
      StringBuilder var5 = new StringBuilder();
      var5.append("javascript:" + var1 + "(");
      var5.append(var4);
      var5.append(");");
      this.X(var5.toString());
   }

   public ay ac() {
      // $FF: Couldn't be decompiled
   }

   public void b(String var1, JSONObject var2) {
      JSONObject var3 = var2;
      if(var2 == null) {
         var3 = new JSONObject();
      }

      String var4 = var3.toString();
      StringBuilder var5 = new StringBuilder();
      var5.append("javascript:AFMA_ReceiveMessage(\'");
      var5.append(var1);
      var5.append("\'");
      var5.append(",");
      var5.append(var4);
      var5.append(");");
      gr.V("Dispatching AFMA event: " + var5);
      this.X(var5.toString());
   }

   public void cb() {
      if(this.dD().dN()) {
         DisplayMetrics var4 = new DisplayMetrics();
         Display var5 = this.mR.getDefaultDisplay();
         var5.getMetrics(var4);
         int var3 = gi.s(this.getContext());
         float var1 = 160.0F / (float)var4.densityDpi;
         int var2 = Math.round((float)var4.widthPixels * var1);
         var3 = Math.round((float)(var4.heightPixels - var3) * var1);

         try {
            this.b("onScreenInfoChanged", (new JSONObject()).put("width", var2).put("height", var3).put("density", (double)var4.density).put("rotation", var5.getRotation()));
         } catch (JSONException var6) {
            gr.b("Error occured while obtaining screen information.", var6);
         }
      }
   }

   public void ci() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.qJ.wS);
      this.a((String)"onshow", (Map)var1);
   }

   public void cj() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.qJ.wS);
      this.a((String)"onhide", (Map)var1);
   }

   public dp dC() {
      // $FF: Couldn't be decompiled
   }

   public gv dD() {
      return this.wW;
   }

   public boolean dE() {
      return this.xc;
   }

   public k dF() {
      return this.tl;
   }

   public gs dG() {
      return this.qJ;
   }

   public boolean dH() {
      // $FF: Couldn't be decompiled
   }

   public Context dI() {
      return this.wX.dI();
   }

   public void destroy() {
      // $FF: Couldn't be decompiled
   }

   public void evaluateJavascript(String param1, ValueCallback param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean isDestroyed() {
      // $FF: Couldn't be decompiled
   }

   public void onDownloadStart(String var1, String var2, String var3, String var4, long var5) {
      try {
         Intent var8 = new Intent("android.intent.action.VIEW");
         var8.setDataAndType(Uri.parse(var1), var4);
         this.getContext().startActivity(var8);
      } catch (ActivityNotFoundException var7) {
         gr.S("Couldn\'t find an Activity to view url/mimetype: " + var1 + " / " + var4);
      }
   }

   protected void onMeasure(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(this.tl != null) {
         this.tl.a(var1);
      }

      return super.onTouchEvent(var1);
   }

   public void q(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void setContext(Context var1) {
      this.wX.setBaseContext(var1);
   }

   public void z(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   @ey
   protected static class a extends MutableContextWrapper {
      private Context mO;
      private Activity xd;

      public a(Context var1) {
         super(var1);
         this.setBaseContext(var1);
      }

      public Context dI() {
         return this.xd;
      }

      public void setBaseContext(Context var1) {
         this.mO = var1.getApplicationContext();
         Activity var2;
         if(var1 instanceof Activity) {
            var2 = (Activity)var1;
         } else {
            var2 = null;
         }

         this.xd = var2;
         super.setBaseContext(this.mO);
      }

      public void startActivity(Intent var1) {
         if(this.xd != null) {
            this.xd.startActivity(var1);
         } else {
            var1.setFlags(268435456);
            this.mO.startActivity(var1);
         }
      }
   }
}
