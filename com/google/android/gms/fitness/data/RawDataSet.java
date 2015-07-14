package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.o;
import com.google.android.gms.fitness.data.t;
import com.google.android.gms.internal.jv;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
   public static final Creator CREATOR = new o();
   final int CK;
   final int UJ;
   final int UL;
   final List UM;
   final boolean Uc;

   RawDataSet(int var1, int var2, int var3, List var4, boolean var5) {
      this.CK = var1;
      this.UJ = var2;
      this.UL = var3;
      this.UM = var4;
      this.Uc = var5;
   }

   public RawDataSet(DataSet var1, List var2, List var3) {
      this.CK = 2;
      this.UM = var1.f(var2);
      this.Uc = var1.jn();
      this.UJ = t.a(var1.getDataSource(), var2);
      this.UL = t.a(var1.getDataType(), var3);
   }

   private boolean a(RawDataSet var1) {
      return this.UJ == var1.UJ && this.UL == var1.UL && this.Uc == var1.Uc && jv.equal(this.UM, var1.UM);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawDataSet && this.a((RawDataSet)var1);
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.UJ), Integer.valueOf(this.UL)});
   }

   public String toString() {
      return String.format("RawDataSet{%s@[%s, %s]}", new Object[]{Integer.valueOf(this.UJ), Integer.valueOf(this.UL), this.UM});
   }

   public void writeToParcel(Parcel var1, int var2) {
      o.a(this, var1, var2);
   }
}
