package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.ce;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.t;
import com.google.android.gms.internal.v;
import org.json.JSONObject;

@ey
public class aj implements ah {
   private final gu mo;

   public aj(Context var1, gs var2) {
      this.mo = gu.a(var1, new ay(), false, false, (k)null, var2);
   }

   private void runOnUiThread(Runnable var1) {
      if(gq.dB()) {
         var1.run();
      } else {
         gq.wR.post(var1);
      }
   }

   public void a(final ah.a var1) {
      this.mo.dD().a(new gv.a() {
         public void a(gu var1x) {
            var1.aR();
         }
      });
   }

   public void a(t var1, ds var2, cb var3, dv var4, boolean var5, ce var6) {
      this.mo.dD().a(var1, var2, var3, var4, var5, var6, new v(false));
   }

   public void a(String var1, cd var2) {
      this.mo.dD().a(var1, var2);
   }

   public void a(final String var1, final JSONObject var2) {
      this.runOnUiThread(new Runnable() {
         public void run() {
            aj.this.mo.a(var1, var2);
         }
      });
   }

   public void destroy() {
      this.mo.destroy();
   }

   public void f(final String var1) {
      this.runOnUiThread(new Runnable() {
         public void run() {
            aj.this.mo.loadUrl(var1);
         }
      });
   }

   public void g(String var1) {
      this.mo.dD().a(var1, (cd)null);
   }

   public void pause() {
      gi.a((WebView)this.mo);
   }

   public void resume() {
      gi.b(this.mo);
   }
}
