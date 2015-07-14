package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.n;
import com.google.android.gms.fitness.data.t;
import com.google.android.gms.internal.jv;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
   public static final Creator CREATOR = new n();
   final int CK;
   final int UJ;
   final int UK;
   final long Ud;
   final long Ue;
   final Value[] Uf;
   final long Uh;
   final long Ui;

   RawDataPoint(int var1, long var2, long var4, Value[] var6, int var7, int var8, long var9, long var11) {
      this.CK = var1;
      this.Ud = var2;
      this.Ue = var4;
      this.UJ = var7;
      this.UK = var8;
      this.Uh = var9;
      this.Ui = var11;
      this.Uf = var6;
   }

   RawDataPoint(DataPoint var1, List var2) {
      this.CK = 4;
      this.Ud = var1.getTimestamp(TimeUnit.NANOSECONDS);
      this.Ue = var1.getStartTime(TimeUnit.NANOSECONDS);
      this.Uf = var1.jr();
      this.UJ = t.a(var1.getDataSource(), var2);
      this.UK = t.a(var1.getOriginalDataSource(), var2);
      this.Uh = var1.js();
      this.Ui = var1.jt();
   }

   private boolean a(RawDataPoint var1) {
      return this.Ud == var1.Ud && this.Ue == var1.Ue && Arrays.equals(this.Uf, var1.Uf) && this.UJ == var1.UJ && this.UK == var1.UK && this.Uh == var1.Uh;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawDataPoint && this.a((RawDataPoint)var1);
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Long.valueOf(this.Ud), Long.valueOf(this.Ue)});
   }

   public String toString() {
      return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.Uf), Long.valueOf(this.Ue), Long.valueOf(this.Ud), Integer.valueOf(this.UJ), Integer.valueOf(this.UK)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      n.a(this, var1, var2);
   }
}
