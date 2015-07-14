package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ax;

public class OnSyncMoreResponse implements SafeParcelable {
   public static final Creator CREATOR = new ax();
   final int CK;
   final boolean PJ;

   OnSyncMoreResponse(int var1, boolean var2) {
      this.CK = var1;
      this.PJ = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ax.a(this, var1, var2);
   }
}
