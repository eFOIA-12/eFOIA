package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.aj;

public class LoadRealtimeRequest implements SafeParcelable {
   public static final Creator CREATOR = new aj();
   final int CK;
   final DriveId Oj;
   final boolean QF;

   LoadRealtimeRequest(int var1, DriveId var2, boolean var3) {
      this.CK = var1;
      this.Oj = var2;
      this.QF = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      aj.a(this, var1, var2);
   }
}
