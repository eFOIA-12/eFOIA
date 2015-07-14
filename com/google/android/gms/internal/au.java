package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.be;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.u;

@ey
public final class au extends com.google.android.gms.dynamic.g {
   private static final au oc = new au();

   private au() {
      super("com.google.android.gms.ads.AdManagerCreatorImpl");
   }

   public static bd a(Context var0, ay var1, String var2, cx var3) {
      Object var4;
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) == 0) {
         bd var5 = oc.b(var0, var1, var2, var3);
         var4 = var5;
         if(var5 != null) {
            return (bd)var4;
         }
      }

      gr.S("Using AdManager from the client jar.");
      var4 = new u(var0, var1, var2, var3, new gs(6587000, 6587000, true));
      return (bd)var4;
   }

   private bd b(Context var1, ay var2, String var3, cx var4) {
      try {
         com.google.android.gms.dynamic.d var5 = com.google.android.gms.dynamic.e.k(var1);
         bd var8 = bd.a.f(((be)this.L(var1)).a(var5, var2, var3, var4, 6587000));
         return var8;
      } catch (RemoteException var6) {
         gr.d("Could not create remote AdManager.", var6);
         return null;
      } catch (com.google.android.gms.dynamic.g var7) {
         gr.d("Could not create remote AdManager.", var7);
         return null;
      }
   }

   protected be c(IBinder var1) {
      return be.a.g(var1);
   }

   // $FF: synthetic method
   protected Object d(IBinder var1) {
      return this.c(var1);
   }
}
