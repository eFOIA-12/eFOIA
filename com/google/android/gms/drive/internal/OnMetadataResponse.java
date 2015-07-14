package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.at;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
   public static final Creator CREATOR = new at();
   final int CK;
   final MetadataBundle Px;

   OnMetadataResponse(int var1, MetadataBundle var2) {
      this.CK = var1;
      this.Px = var2;
   }

   public int describeContents() {
      return 0;
   }

   public MetadataBundle iU() {
      return this.Px;
   }

   public void writeToParcel(Parcel var1, int var2) {
      at.a(this, var1, var2);
   }
}
