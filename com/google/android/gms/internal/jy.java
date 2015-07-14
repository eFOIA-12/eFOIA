package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.internal.ju;

public final class jy extends com.google.android.gms.dynamic.g {
   private static final jy Nt = new jy();

   private jy() {
      super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
   }

   public static View b(Context var0, int var1, int var2) throws com.google.android.gms.dynamic.g {
      return Nt.c(var0, var1, var2);
   }

   private View c(Context var1, int var2, int var3) throws com.google.android.gms.dynamic.g {
      try {
         com.google.android.gms.dynamic.d var4 = com.google.android.gms.dynamic.e.k(var1);
         View var6 = (View)com.google.android.gms.dynamic.e.f(((ju)this.L(var1)).a(var4, var2, var3));
         return var6;
      } catch (Exception var5) {
         throw new com.google.android.gms.dynamic.g("Could not get button with size " + var2 + " and color " + var3, var5);
      }
   }

   public ju S(IBinder var1) {
      return ju.a.R(var1);
   }

   // $FF: synthetic method
   public Object d(IBinder var1) {
      return this.S(var1);
   }
}
