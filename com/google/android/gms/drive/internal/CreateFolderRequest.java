package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class CreateFolderRequest implements SafeParcelable {
   public static final Creator CREATOR = new l();
   final int CK;
   final MetadataBundle Px;
   final DriveId Pz;

   CreateFolderRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.CK = var1;
      this.Pz = (DriveId)jx.i(var2);
      this.Px = (MetadataBundle)jx.i(var3);
   }

   public CreateFolderRequest(DriveId var1, MetadataBundle var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      l.a(this, var1, var2);
   }
}
