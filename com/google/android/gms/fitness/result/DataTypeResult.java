package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.d;
import com.google.android.gms.internal.jv;

public class DataTypeResult implements Result, SafeParcelable {
   public static final Creator CREATOR = new d();
   private final int CK;
   private final Status Eb;
   private final DataType TM;

   DataTypeResult(int var1, Status var2, DataType var3) {
      this.CK = var1;
      this.Eb = var2;
      this.TM = var3;
   }

   public DataTypeResult(Status var1, DataType var2) {
      this.CK = 2;
      this.Eb = var1;
      this.TM = var2;
   }

   public static DataTypeResult E(Status var0) {
      return new DataTypeResult(var0, (DataType)null);
   }

   private boolean b(DataTypeResult var1) {
      return this.Eb.equals(var1.Eb) && jv.equal(this.TM, var1.TM);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataTypeResult && this.b((DataTypeResult)var1);
   }

   public DataType getDataType() {
      return this.TM;
   }

   public Status getStatus() {
      return this.Eb;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Eb, this.TM});
   }

   public String toString() {
      return jv.h(this).a("status", this.Eb).a("dataType", this.TM).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
