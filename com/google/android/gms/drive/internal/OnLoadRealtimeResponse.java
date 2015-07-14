package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.au;

public class OnLoadRealtimeResponse implements SafeParcelable {
   public static final Creator CREATOR = new au();
   final int CK;
   final boolean wg;

   OnLoadRealtimeResponse(int var1, boolean var2) {
      this.CK = var1;
      this.wg = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      au.a(this, var1, var2);
   }
}
