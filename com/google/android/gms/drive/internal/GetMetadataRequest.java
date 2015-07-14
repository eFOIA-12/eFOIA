package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ad;

public class GetMetadataRequest implements SafeParcelable {
   public static final Creator CREATOR = new ad();
   final int CK;
   final DriveId Pp;

   GetMetadataRequest(int var1, DriveId var2) {
      this.CK = var1;
      this.Pp = var2;
   }

   public GetMetadataRequest(DriveId var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ad.a(this, var1, var2);
   }
}
