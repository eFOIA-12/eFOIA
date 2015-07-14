package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.as;

public class OnListParentsResponse extends com.google.android.gms.drive.i implements SafeParcelable {
   public static final Creator CREATOR = new as();
   final int CK;
   final DataHolder QR;

   OnListParentsResponse(int var1, DataHolder var2) {
      this.CK = var1;
      this.QR = var2;
   }

   protected void I(Parcel var1, int var2) {
      as.a(this, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public DataHolder iT() {
      return this.QR;
   }
}
