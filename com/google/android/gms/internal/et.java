package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public final class et extends com.google.android.gms.dynamic.g {
   private static final et td = new et();

   private et() {
      super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
   }

   private static boolean c(Activity var0) throws et.a {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
         throw new et.a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
      }
   }

   public static eo e(Activity var0) {
      try {
         if(c(var0)) {
            gr.S("Using AdOverlay from the client jar.");
            return new ee(var0);
         } else {
            eo var2 = td.f(var0);
            return var2;
         }
      } catch (et.a var1) {
         gr.W(var1.getMessage());
         return null;
      }
   }

   private eo f(Activity var1) {
      try {
         com.google.android.gms.dynamic.d var2 = com.google.android.gms.dynamic.e.k(var1);
         eo var5 = eo.a.w(((ep)this.L(var1)).c(var2));
         return var5;
      } catch (RemoteException var3) {
         gr.d("Could not create remote InAppPurchaseManager.", var3);
         return null;
      } catch (com.google.android.gms.dynamic.g var4) {
         gr.d("Could not create remote InAppPurchaseManager.", var4);
         return null;
      }
   }

   protected ep A(IBinder var1) {
      return ep.a.x(var1);
   }

   // $FF: synthetic method
   protected Object d(IBinder var1) {
      return this.A(var1);
   }

   private static final class a extends Exception {
      public a(String var1) {
         super(var1);
      }
   }
}
