package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.b;

public class EndCompoundOperationRequest implements SafeParcelable {
   public static final Creator CREATOR = new b();
   final int CK;

   public EndCompoundOperationRequest() {
      this(1);
   }

   EndCompoundOperationRequest(int var1) {
      this.CK = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
