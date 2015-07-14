package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.o;

public class DisconnectRequest implements SafeParcelable {
   public static final Creator CREATOR = new o();
   final int CK;

   public DisconnectRequest() {
      this(1);
   }

   DisconnectRequest(int var1) {
      this.CK = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      o.a(this, var1, var2);
   }
}
