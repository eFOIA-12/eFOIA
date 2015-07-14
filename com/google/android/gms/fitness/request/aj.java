package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.ak;
import com.google.android.gms.internal.jv;

public class aj implements SafeParcelable {
   public static final Creator CREATOR = new ak();
   private final int CK;
   private final DataType TM;
   private final DataSource TN;

   aj(int var1, DataType var2, DataSource var3) {
      this.CK = var1;
      this.TM = var2;
      this.TN = var3;
   }

   private aj(aj.a var1) {
      this.CK = 1;
      this.TM = var1.TM;
      this.TN = var1.TN;
   }

   // $FF: synthetic method
   aj(aj.a var1, Object var2) {
      this(var1);
   }

   private boolean a(aj var1) {
      return jv.equal(this.TN, var1.TN) && jv.equal(this.TM, var1.TM);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof aj && this.a((aj)var1);
   }

   public DataSource getDataSource() {
      return this.TN;
   }

   public DataType getDataType() {
      return this.TM;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TN, this.TM});
   }

   public void writeToParcel(Parcel var1, int var2) {
      ak.a(this, var1, var2);
   }

   public static class a {
      private DataType TM;
      private DataSource TN;

      public aj.a d(DataSource var1) {
         this.TN = var1;
         return this;
      }

      public aj.a d(DataType var1) {
         this.TM = var1;
         return this;
      }

      public aj kq() {
         if(this.TM != null && this.TN != null) {
            throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
         } else {
            return new aj(this, null);
         }
      }
   }
}
