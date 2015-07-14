package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.dy;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public final class dw extends com.google.android.gms.dynamic.g {
   private static final dw sy = new dw();

   private dw() {
      super("com.google.android.gms.ads.AdOverlayCreatorImpl");
   }

   public static dx b(Activity var0) {
      try {
         if(c(var0)) {
            gr.S("Using AdOverlay from the client jar.");
            return new dp(var0);
         } else {
            dx var2 = sy.d(var0);
            return var2;
         }
      } catch (dw.a var1) {
         gr.W(var1.getMessage());
         return null;
      }
   }

   private static boolean c(Activity var0) throws dw.a {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
         throw new dw.a("Ad overlay requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
      }
   }

   private dx d(Activity var1) {
      try {
         com.google.android.gms.dynamic.d var2 = com.google.android.gms.dynamic.e.k(var1);
         dx var5 = dx.a.r(((dy)this.L(var1)).b(var2));
         return var5;
      } catch (RemoteException var3) {
         gr.d("Could not create remote AdOverlay.", var3);
         return null;
      } catch (com.google.android.gms.dynamic.g var4) {
         gr.d("Could not create remote AdOverlay.", var4);
         return null;
      }
   }

   // $FF: synthetic method
   protected Object d(IBinder var1) {
      return this.q(var1);
   }

   protected dy q(IBinder var1) {
      return dy.a.s(var1);
   }

   private static final class a extends Exception {
      public a(String var1) {
         super(var1);
      }
   }
}
