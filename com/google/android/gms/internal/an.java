package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.internal.ak;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.ex;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.ll;

@ey
public class an extends Thread {
   private final Object mH;
   private boolean mStarted = false;
   private boolean nC = false;
   private boolean nD = false;
   private final am nE;
   private final al nF;
   private final ex nG;
   private final int nH;
   private final int nI;
   private final int nJ;
   private final int np;
   private final int nr;

   public an(am var1, al var2, Bundle var3, ex var4) {
      this.nE = var1;
      this.nF = var2;
      this.nG = var4;
      this.mH = new Object();
      this.np = var3.getInt(bn.pq.getKey());
      this.nI = var3.getInt(bn.pr.getKey());
      this.nr = var3.getInt(bn.ps.getKey());
      this.nJ = var3.getInt(bn.pt.getKey());
      this.nH = var3.getInt(bn.pu.getKey(), 10);
      this.setName("ContentFetchTask");
   }

   private void a(Activity var1) {
      if(var1 != null) {
         Object var3 = null;
         View var2 = (View)var3;
         if(var1.getWindow() != null) {
            var2 = (View)var3;
            if(var1.getWindow().getDecorView() != null) {
               var2 = var1.getWindow().getDecorView().findViewById(16908290);
            }
         }

         if(var2 != null) {
            this.g(var2);
            return;
         }
      }

   }

   private boolean a(final WebView var1, final ak var2) {
      if(!ll.im()) {
         return false;
      } else {
         var2.aW();
         var1.post(new Runnable() {
            ValueCallback nM = new ValueCallback() {
               public void k(String var1x) {
                  an.this.a(var2, var1, var1x);
               }

               // $FF: synthetic method
               public void onReceiveValue(Object var1x) {
                  this.k((String)var1x);
               }
            };

            public void run() {
               if(var1.getSettings().getJavaScriptEnabled()) {
                  var1.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.nM);
               }

            }
         });
         return true;
      }
   }

   private boolean bb() {
      // $FF: Couldn't be decompiled
   }

   an.a a(View var1, ak var2) {
      int var3 = 0;
      if(var1 == null) {
         return new an.a(0, 0);
      } else if(var1 instanceof TextView && !(var1 instanceof EditText)) {
         var2.i(((TextView)var1).getText().toString());
         return new an.a(1, 0);
      } else if(var1 instanceof WebView && !(var1 instanceof gu)) {
         var2.aW();
         return this.a((WebView)var1, var2)?new an.a(0, 1):new an.a(0, 0);
      } else if(!(var1 instanceof ViewGroup)) {
         return new an.a(0, 0);
      } else {
         ViewGroup var7 = (ViewGroup)var1;
         int var4 = 0;

         int var5;
         for(var5 = 0; var3 < var7.getChildCount(); ++var3) {
            an.a var6 = this.a(var7.getChildAt(var3), var2);
            var5 += var6.nQ;
            var4 += var6.nR;
         }

         return new an.a(var5, var4);
      }
   }

   void a(ak param1, WebView param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public void ba() {
      // $FF: Couldn't be decompiled
   }

   public ak bc() {
      return this.nF.aZ();
   }

   public void bd() {
      // $FF: Couldn't be decompiled
   }

   public boolean be() {
      return this.nC;
   }

   boolean g(final View var1) {
      if(var1 == null) {
         return false;
      } else {
         var1.post(new Runnable() {
            public void run() {
               an.this.h(var1);
            }
         });
         return true;
      }
   }

   void h(View var1) {
      try {
         ak var2 = new ak(this.np, this.nI, this.nr, this.nJ);
         an.a var4 = this.a(var1, var2);
         var2.aX();
         if(var4.nQ == 0 && var4.nR == 0) {
            return;
         }

         if((var4.nR != 0 || var2.aY() != 0) && (var4.nR != 0 || !this.nF.a(var2))) {
            this.nF.c(var2);
            return;
         }
      } catch (Exception var3) {
         gr.b("Exception in fetchContentOnUIThread", var3);
         this.nG.b(var3);
      }

   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   public void wakeup() {
      // $FF: Couldn't be decompiled
   }

   @ey
   class a {
      final int nQ;
      final int nR;

      a(int var2, int var3) {
         this.nQ = var2;
         this.nR = var3;
      }
   }
}
