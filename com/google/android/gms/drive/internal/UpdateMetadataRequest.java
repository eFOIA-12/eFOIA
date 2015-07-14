package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.bi;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
   public static final Creator CREATOR = new bi();
   final int CK;
   final DriveId Pp;
   final MetadataBundle Pq;

   UpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.CK = var1;
      this.Pp = var2;
      this.Pq = var3;
   }

   public UpdateMetadataRequest(DriveId var1, MetadataBundle var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      bi.a(this, var1, var2);
   }
}
