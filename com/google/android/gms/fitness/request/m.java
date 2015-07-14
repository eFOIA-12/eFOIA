package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.n;

public class m implements SafeParcelable {
   public static final Creator CREATOR = new n();
   private final int CK;
   private final DataType TM;

   m(int var1, DataType var2) {
      this.CK = var1;
      this.TM = var2;
   }

   private m(m.a var1) {
      this.CK = 1;
      this.TM = var1.TM;
   }

   // $FF: synthetic method
   m(m.a var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public DataType getDataType() {
      return this.TM;
   }

   int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      n.a(this, var1, var2);
   }

   public static class a {
      private DataType TM;

      public m.a c(DataType var1) {
         this.TM = var1;
         return this;
      }

      public m ka() {
         return new m(this, null);
      }
   }
}
