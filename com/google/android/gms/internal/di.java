package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class di {
   static final Set rk = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
   private int li = -1;
   private int lj = -1;
   private final Context mContext;
   private final gu mo;
   private final Map rd;
   private int rl = 0;
   private int rm = 0;
   private boolean rn = true;
   private String ro = "top-right";

   public di(gu var1, Map var2) {
      this.mo = var1;
      this.rd = var2;
      this.mContext = var1.dI();
   }

   private void bQ() {
      int[] var2 = gi.t(this.mContext);
      int var1;
      if(!TextUtils.isEmpty((CharSequence)this.rd.get("width"))) {
         var1 = gi.M((String)this.rd.get("width"));
         if(this.b(var1, var2[0])) {
            this.li = var1;
         }
      }

      if(!TextUtils.isEmpty((CharSequence)this.rd.get("height"))) {
         var1 = gi.M((String)this.rd.get("height"));
         if(this.c(var1, var2[1])) {
            this.lj = var1;
         }
      }

      if(!TextUtils.isEmpty((CharSequence)this.rd.get("offsetX"))) {
         this.rl = gi.M((String)this.rd.get("offsetX"));
      }

      if(!TextUtils.isEmpty((CharSequence)this.rd.get("offsetY"))) {
         this.rm = gi.M((String)this.rd.get("offsetY"));
      }

      if(!TextUtils.isEmpty((CharSequence)this.rd.get("allowOffscreen"))) {
         this.rn = Boolean.parseBoolean((String)this.rd.get("allowOffscreen"));
      }

      String var3 = (String)this.rd.get("customClosePosition");
      if(!TextUtils.isEmpty(var3) && rk.contains(var3)) {
         this.ro = var3;
      }

   }

   boolean b(int var1, int var2) {
      return var1 >= 50 && var1 < var2;
   }

   boolean bR() {
      return this.li > -1 && this.lj > -1;
   }

   void bS() {
      try {
         JSONObject var1 = (new JSONObject()).put("x", this.rl).put("y", this.rm).put("width", this.li).put("height", this.lj);
         this.mo.b("onSizeChanged", var1);
      } catch (JSONException var2) {
         gr.b("Error occured while dispatching size change.", var2);
      }
   }

   void bT() {
      try {
         JSONObject var1 = (new JSONObject()).put("state", "resized");
         this.mo.b("onStateChanged", var1);
      } catch (JSONException var2) {
         gr.b("Error occured while dispatching state change.", var2);
      }
   }

   boolean c(int var1, int var2) {
      return var1 >= 50 && var1 < var2;
   }

   public void execute() {
      gr.U("PLEASE IMPLEMENT mraid.resize()");
      if(this.mContext == null) {
         gr.W("Not an activity context. Cannot resize.");
      } else if(this.mo.ac().oq) {
         gr.W("Is interstitial. Cannot resize an interstitial.");
      } else if(this.mo.dH()) {
         gr.W("Is expanded. Cannot resize an expanded banner.");
      } else {
         this.bQ();
         if(!this.bR()) {
            gr.W("Invalid width and height options. Cannot resize.");
         } else {
            WindowManager var4 = (WindowManager)this.mContext.getSystemService("window");
            DisplayMetrics var5 = new DisplayMetrics();
            var4.getDefaultDisplay().getMetrics(var5);
            int var1 = gq.a(var5, this.li);
            int var2 = gq.a(var5, this.lj);
            ViewParent var6 = this.mo.getParent();
            if(var6 != null && var6 instanceof ViewGroup) {
               ((ViewGroup)var6).removeView(this.mo);
            }

            LinearLayout var7 = new LinearLayout(this.mContext);
            var7.setBackgroundColor(0);
            PopupWindow var8 = new PopupWindow(this.mContext);
            var8.setHeight(var2 + 16);
            var8.setWidth(var1 + 16);
            boolean var3;
            if(!this.rn) {
               var3 = true;
            } else {
               var3 = false;
            }

            var8.setClippingEnabled(var3);
            var8.setContentView(var7);
            var7.addView(this.mo, -1, -1);
            var8.showAtLocation(((Activity)this.mContext).getWindow().getDecorView(), 0, this.rl, this.rm);
            this.mo.a(new ay(this.mContext, new AdSize(this.li, this.lj)));
            this.bS();
            this.bT();
         }
      }
   }
}
