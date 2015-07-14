package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.bb;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
   public static final Creator CREATOR = new bb();
   final int CK;
   final Query QV;

   QueryRequest(int var1, Query var2) {
      this.CK = var1;
      this.QV = var2;
   }

   public QueryRequest(Query var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      bb.a(this, var1, var2);
   }
}
