package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.f;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class e implements SafeParcelable {
   public static final Creator CREATOR = new f();
   private final int CK;
   private final DataSet UP;

   e(int var1, DataSet var2) {
      this.CK = var1;
      this.UP = var2;
   }

   private e(e.a var1) {
      this.CK = 1;
      this.UP = var1.UP;
   }

   // $FF: synthetic method
   e(e.a var1, Object var2) {
      this(var1);
   }

   private boolean a(e var1) {
      return jv.equal(this.UP, var1.UP);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof e && this.a((e)var1);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.UP});
   }

   public DataSet jH() {
      return this.UP;
   }

   public String toString() {
      return jv.h(this).a("dataSet", this.UP).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }

   public static class a {
      private DataSet UP;

      public e.a b(DataSet var1) {
         this.UP = var1;
         return this;
      }

      public e jU() {
         boolean var2 = true;
         boolean var1;
         if(this.UP != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must set the data set");
         if(!this.UP.getDataPoints().isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "Cannot use an empty data set");
         if(this.UP.getDataSource().jx() != null) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.a(var1, "Must set the app package name for the data source");
         return new e(this, null);
      }
   }
}
