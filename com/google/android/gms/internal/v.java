package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;

@ey
public class v {
   private v.a mk;
   private boolean ml;
   private boolean mm;

   public v() {
      boolean var2 = false;
      super();
      Bundle var3 = ga.bN();
      boolean var1 = var2;
      if(var3 != null) {
         var1 = var2;
         if(var3.getBoolean("gads:block_autoclicks", false)) {
            var1 = true;
         }
      }

      this.mm = var1;
   }

   public v(boolean var1) {
      this.mm = var1;
   }

   public void a(v.a var1) {
      this.mk = var1;
   }

   public void av() {
      this.ml = true;
   }

   public boolean az() {
      return !this.mm || this.ml;
   }

   public void d(String var1) {
      gr.S("Action was blocked because no click was detected.");
      if(this.mk != null) {
         this.mk.e(var1);
      }

   }

   public interface a {
      void e(String var1);
   }

   @ey
   public static class b implements v.a {
      private final fy.a mn;
      private final gu mo;

      public b(fy.a var1, gu var2) {
         this.mn = var1;
         this.mo = var2;
      }

      public void e(String var1) {
         gr.S("An auto-clicking creative is blocked");
         Builder var2 = new Builder();
         var2.scheme("https");
         var2.path("//pagead2.googlesyndication.com/pagead/gen_204");
         var2.appendQueryParameter("id", "gmob-apps-blocked-navigation");
         if(!TextUtils.isEmpty(var1)) {
            var2.appendQueryParameter("navigationURL", var1);
         }

         if(this.mn != null && this.mn.vK != null && !TextUtils.isEmpty(this.mn.vK.ub)) {
            var2.appendQueryParameter("debugDialog", this.mn.vK.ub);
         }

         gi.c(this.mo.getContext(), this.mo.dG().wS, var2.toString());
      }
   }
}
