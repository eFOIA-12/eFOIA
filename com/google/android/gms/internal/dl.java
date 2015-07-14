package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.bl;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class dl {
   private final Context mContext;
   private final WindowManager mR;
   private final gu mo;
   int rA = -1;
   int rB = -1;
   private int rC;
   private int rD = -1;
   private int rE = -1;
   private int[] rF = new int[2];
   private final bl rx;
   DisplayMetrics ry;
   private float rz;

   public dl(gu var1, Context var2, bl var3) {
      this.mo = var1;
      this.mContext = var2;
      this.rx = var3;
      this.mR = (WindowManager)var2.getSystemService("window");
      this.bV();
      this.bW();
      this.bX();
   }

   private void bV() {
      this.ry = new DisplayMetrics();
      Display var1 = this.mR.getDefaultDisplay();
      var1.getMetrics(this.ry);
      this.rz = this.ry.density;
      this.rC = var1.getRotation();
   }

   private void bX() {
      this.mo.getLocationOnScreen(this.rF);
      this.mo.measure(0, 0);
      float var1 = 160.0F / (float)this.ry.densityDpi;
      this.rD = Math.round((float)this.mo.getMeasuredWidth() * var1);
      this.rE = Math.round(var1 * (float)this.mo.getMeasuredHeight());
   }

   private dk cd() {
      return (new dk.a()).l(this.rx.bo()).k(this.rx.bp()).m(this.rx.bt()).n(this.rx.bq()).o(this.rx.br()).bU();
   }

   void bW() {
      int var2 = gi.s(this.mContext);
      float var1 = 160.0F / (float)this.ry.densityDpi;
      this.rA = Math.round((float)this.ry.widthPixels * var1);
      this.rB = Math.round((float)(this.ry.heightPixels - var2) * var1);
   }

   public void bY() {
      this.cb();
      this.cc();
      this.ca();
      this.bZ();
   }

   public void bZ() {
      if(gr.v(2)) {
         gr.U("Dispatching Ready Event.");
      }

      this.mo.b("onReadyEventReceived", new JSONObject());
   }

   public void ca() {
      try {
         JSONObject var1 = (new JSONObject()).put("x", this.rF[0]).put("y", this.rF[1]).put("width", this.rD).put("height", this.rE);
         this.mo.b("onDefaultPositionReceived", var1);
      } catch (JSONException var2) {
         gr.b("Error occured while dispatching default position.", var2);
      }
   }

   public void cb() {
      try {
         JSONObject var1 = (new JSONObject()).put("width", this.rA).put("height", this.rB).put("density", (double)this.rz).put("rotation", this.rC);
         this.mo.b("onScreenInfoChanged", var1);
      } catch (JSONException var2) {
         gr.b("Error occured while obtaining screen information.", var2);
      }
   }

   public void cc() {
      dk var1 = this.cd();
      this.mo.b("onDeviceFeaturesReceived", var1.toJson());
   }
}
