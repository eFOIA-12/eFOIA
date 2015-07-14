package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dz;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.em;
import com.google.android.gms.internal.ey;

@ey
public final class ea implements SafeParcelable {
   public static final dz CREATOR = new dz();
   public final ek md;
   public final Context sA;
   public final ej sB;
   public final em sz;
   public final int versionCode;

   ea(int var1, IBinder var2, IBinder var3, IBinder var4, IBinder var5) {
      this.versionCode = var1;
      this.md = (ek)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var2));
      this.sz = (em)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var3));
      this.sA = (Context)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var4));
      this.sB = (ej)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var5));
   }

   public ea(Context var1, ek var2, em var3, ej var4) {
      this.versionCode = 2;
      this.sA = var1;
      this.md = var2;
      this.sz = var3;
      this.sB = var4;
   }

   public static void a(Intent var0, ea var1) {
      Bundle var2 = new Bundle(1);
      var2.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var1);
      var0.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", var2);
   }

   public static ea c(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         var2.setClassLoader(ea.class.getClassLoader());
         ea var3 = (ea)var2.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         return var3;
      } catch (Exception var1) {
         return null;
      }
   }

   IBinder ct() {
      return com.google.android.gms.dynamic.e.k(this.sB).asBinder();
   }

   IBinder cu() {
      return com.google.android.gms.dynamic.e.k(this.md).asBinder();
   }

   IBinder cv() {
      return com.google.android.gms.dynamic.e.k(this.sz).asBinder();
   }

   IBinder cw() {
      return com.google.android.gms.dynamic.e.k(this.sA).asBinder();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      dz.a(this, var1, var2);
   }
}
