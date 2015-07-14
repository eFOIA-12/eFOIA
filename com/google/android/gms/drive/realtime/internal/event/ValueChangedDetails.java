package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.g;

public class ValueChangedDetails implements SafeParcelable {
   public static final Creator CREATOR = new g();
   final int CK;
   final int Tj;

   ValueChangedDetails(int var1, int var2) {
      this.CK = var1;
      this.Tj = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      g.a(this, var1, var2);
   }
}
