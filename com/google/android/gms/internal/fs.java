package com.google.android.gms.internal;

import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.jx;
import java.util.Map;
import java.util.concurrent.Future;

@ey
public final class fs {
   private final Object mH = new Object();
   gu mo;
   private String uE;
   private gj uF = new gj();
   public final cd uG = new cd() {
      public void a(gu param1, Map param2) {
         // $FF: Couldn't be decompiled
      }
   };
   public final cd uH = new cd() {
      public void a(gu param1, Map param2) {
         // $FF: Couldn't be decompiled
      }
   };

   public fs(String var1) {
      this.uE = var1;
   }

   // $FF: synthetic method
   static Object a(fs var0) {
      return var0.mH;
   }

   // $FF: synthetic method
   static gj b(fs var0) {
      return var0.uF;
   }

   // $FF: synthetic method
   static String c(fs var0) {
      return var0.uE;
   }

   public void b(gu var1) {
      jx.aU("setAdWebView must be called on the main thread.");
      this.mo = var1;
   }

   public Future cR() {
      return this.uF;
   }

   public void cS() {
      jx.aU("destroyAdWebView must be called on the main thread.");
      if(this.mo != null) {
         this.mo.destroy();
         this.mo = null;
      }

   }
}
