package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gz;

@ey
public class fb implements Runnable {
   private final int li;
   private final int lj;
   protected final gu mo;
   private final Handler tr;
   private final long ts;
   private long tt;
   private gv.a tu;
   protected boolean tv;
   protected boolean tw;

   public fb(gv.a var1, gu var2, int var3, int var4) {
      this(var1, var2, var3, var4, 200L, 50L);
   }

   public fb(gv.a var1, gu var2, int var3, int var4, long var5, long var7) {
      this.ts = var5;
      this.tt = var7;
      this.tr = new Handler(Looper.getMainLooper());
      this.mo = var2;
      this.tu = var1;
      this.tv = false;
      this.tw = false;
      this.lj = var4;
      this.li = var3;
   }

   // $FF: synthetic method
   static long c(fb var0) {
      long var1 = var0.tt - 1L;
      var0.tt = var1;
      return var1;
   }

   public void a(fj var1, gz var2) {
      this.mo.setWebViewClient(var2);
      gu var3 = this.mo;
      String var4;
      if(TextUtils.isEmpty(var1.sg)) {
         var4 = null;
      } else {
         var4 = gi.L(var1.sg);
      }

      var3.loadDataWithBaseURL(var4, var1.tU, "text/html", "UTF-8", (String)null);
   }

   public void b(fj var1) {
      this.a(var1, new gz(this, this.mo, var1.ud));
   }

   public void cF() {
      this.tr.postDelayed(this, this.ts);
   }

   public void cG() {
      synchronized(this){}

      try {
         this.tv = true;
      } finally {
         ;
      }

   }

   public boolean cH() {
      synchronized(this){}

      boolean var1;
      try {
         var1 = this.tv;
      } finally {
         ;
      }

      return var1;
   }

   public boolean cI() {
      return this.tw;
   }

   public void run() {
      if(this.mo != null && !this.cH()) {
         (new fb.a(this.mo)).execute(new Void[0]);
      } else {
         this.tu.a(this.mo);
      }
   }

   protected final class a extends AsyncTask {
      private final WebView tx;
      private Bitmap ty;

      public a(WebView var2) {
         this.tx = var2;
      }

      protected void a(Boolean var1) {
         fb.c(fb.this);
         if(!var1.booleanValue() && !fb.this.cH() && fb.this.tt > 0L) {
            if(fb.this.tt > 0L) {
               if(gr.v(2)) {
                  gr.S("Ad not detected, scheduling another run.");
               }

               fb.this.tr.postDelayed(fb.this, fb.this.ts);
               return;
            }
         } else {
            fb.this.tw = var1.booleanValue();
            fb.this.tu.a(fb.this.mo);
         }

      }

      protected Boolean b(Void... param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: synthetic method
      protected Object doInBackground(Object[] var1) {
         return this.b((Void[])var1);
      }

      // $FF: synthetic method
      protected void onPostExecute(Object var1) {
         this.a((Boolean)var1);
      }

      protected void onPreExecute() {
         synchronized(this){}

         try {
            this.ty = Bitmap.createBitmap(fb.this.li, fb.this.lj, Config.ARGB_8888);
            this.tx.setVisibility(0);
            this.tx.measure(MeasureSpec.makeMeasureSpec(fb.this.li, 0), MeasureSpec.makeMeasureSpec(fb.this.lj, 0));
            this.tx.layout(0, 0, fb.this.li, fb.this.lj);
            Canvas var1 = new Canvas(this.ty);
            this.tx.draw(var1);
            this.tx.invalidate();
         } finally {
            ;
         }

      }
   }
}
