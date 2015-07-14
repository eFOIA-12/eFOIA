package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.ce;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.t;
import com.google.android.gms.internal.y;

@ey
public final class dr implements SafeParcelable {
   public static final dq CREATOR = new dq();
   public final gs lO;
   public final int orientation;
   public final String rH;
   public final do sb;
   public final t sc;
   public final ds sd;
   public final gu se;
   public final cb sf;
   public final String sg;
   public final boolean sh;
   public final String si;
   public final dv sj;
   public final int sk;
   public final ce sl;
   public final String sm;
   public final y sn;
   public final int versionCode;

   dr(int var1, do var2, IBinder var3, IBinder var4, IBinder var5, IBinder var6, String var7, boolean var8, String var9, IBinder var10, int var11, int var12, String var13, gs var14, IBinder var15, String var16, y var17) {
      this.versionCode = var1;
      this.sb = var2;
      this.sc = (t)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var3));
      this.sd = (ds)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var4));
      this.se = (gu)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var5));
      this.sf = (cb)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var6));
      this.sg = var7;
      this.sh = var8;
      this.si = var9;
      this.sj = (dv)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var10));
      this.orientation = var11;
      this.sk = var12;
      this.rH = var13;
      this.lO = var14;
      this.sl = (ce)com.google.android.gms.dynamic.e.f(com.google.android.gms.dynamic.d.ap(var15));
      this.sm = var16;
      this.sn = var17;
   }

   public dr(do var1, t var2, ds var3, dv var4, gs var5) {
      this.versionCode = 4;
      this.sb = var1;
      this.sc = var2;
      this.sd = var3;
      this.se = null;
      this.sf = null;
      this.sg = null;
      this.sh = false;
      this.si = null;
      this.sj = var4;
      this.orientation = -1;
      this.sk = 4;
      this.rH = null;
      this.lO = var5;
      this.sl = null;
      this.sm = null;
      this.sn = null;
   }

   public dr(t var1, ds var2, cb var3, dv var4, gu var5, boolean var6, int var7, String var8, gs var9, ce var10) {
      this.versionCode = 4;
      this.sb = null;
      this.sc = var1;
      this.sd = var2;
      this.se = var5;
      this.sf = var3;
      this.sg = null;
      this.sh = var6;
      this.si = null;
      this.sj = var4;
      this.orientation = var7;
      this.sk = 3;
      this.rH = var8;
      this.lO = var9;
      this.sl = var10;
      this.sm = null;
      this.sn = null;
   }

   public dr(t var1, ds var2, cb var3, dv var4, gu var5, boolean var6, int var7, String var8, String var9, gs var10, ce var11) {
      this.versionCode = 4;
      this.sb = null;
      this.sc = var1;
      this.sd = var2;
      this.se = var5;
      this.sf = var3;
      this.sg = var9;
      this.sh = var6;
      this.si = var8;
      this.sj = var4;
      this.orientation = var7;
      this.sk = 3;
      this.rH = null;
      this.lO = var10;
      this.sl = var11;
      this.sm = null;
      this.sn = null;
   }

   public dr(t var1, ds var2, dv var3, gu var4, int var5, gs var6, String var7, y var8) {
      this.versionCode = 4;
      this.sb = null;
      this.sc = var1;
      this.sd = var2;
      this.se = var4;
      this.sf = null;
      this.sg = null;
      this.sh = false;
      this.si = null;
      this.sj = var3;
      this.orientation = var5;
      this.sk = 1;
      this.rH = null;
      this.lO = var6;
      this.sl = null;
      this.sm = var7;
      this.sn = var8;
   }

   public dr(t var1, ds var2, dv var3, gu var4, boolean var5, int var6, gs var7) {
      this.versionCode = 4;
      this.sb = null;
      this.sc = var1;
      this.sd = var2;
      this.se = var4;
      this.sf = null;
      this.sg = null;
      this.sh = var5;
      this.si = null;
      this.sj = var3;
      this.orientation = var6;
      this.sk = 2;
      this.rH = null;
      this.lO = var7;
      this.sl = null;
      this.sm = null;
      this.sn = null;
   }

   public static void a(Intent var0, dr var1) {
      Bundle var2 = new Bundle(1);
      var2.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var1);
      var0.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var2);
   }

   public static dr b(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         var2.setClassLoader(dr.class.getClassLoader());
         dr var3 = (dr)var2.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         return var3;
      } catch (Exception var1) {
         return null;
      }
   }

   IBinder ck() {
      return com.google.android.gms.dynamic.e.k(this.sc).asBinder();
   }

   IBinder cl() {
      return com.google.android.gms.dynamic.e.k(this.sd).asBinder();
   }

   IBinder cm() {
      return com.google.android.gms.dynamic.e.k(this.se).asBinder();
   }

   IBinder cn() {
      return com.google.android.gms.dynamic.e.k(this.sf).asBinder();
   }

   IBinder co() {
      return com.google.android.gms.dynamic.e.k(this.sl).asBinder();
   }

   IBinder cp() {
      return com.google.android.gms.dynamic.e.k(this.sj).asBinder();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      dq.a(this, var1, var2);
   }
}
