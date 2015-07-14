package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.n;

public class DeleteResourceRequest implements SafeParcelable {
   public static final Creator CREATOR = new n();
   final int CK;
   final DriveId Pp;

   DeleteResourceRequest(int var1, DriveId var2) {
      this.CK = var1;
      this.Pp = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      n.a(this, var1, var2);
   }
}
