package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.aw;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.ey;
import java.util.List;

@ey
public final class av implements SafeParcelable {
   public static final aw CREATOR = new aw();
   public final Bundle extras;
   public final long od;
   public final int oe;
   public final List of;
   public final boolean og;
   public final int oh;
   public final boolean oi;
   public final String oj;
   public final bj ok;
   public final Location ol;
   public final String om;
   public final Bundle on;
   public final int versionCode;

   public av(int var1, long var2, Bundle var4, int var5, List var6, boolean var7, int var8, boolean var9, String var10, bj var11, Location var12, String var13, Bundle var14) {
      this.versionCode = var1;
      this.od = var2;
      this.extras = var4;
      this.oe = var5;
      this.of = var6;
      this.og = var7;
      this.oh = var8;
      this.oi = var9;
      this.oj = var10;
      this.ok = var11;
      this.ol = var12;
      this.om = var13;
      this.on = var14;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      aw.a(this, var1, var2);
   }
}
