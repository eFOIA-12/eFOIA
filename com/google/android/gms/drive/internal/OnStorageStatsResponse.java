package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;
import com.google.android.gms.drive.internal.aw;

public class OnStorageStatsResponse implements SafeParcelable {
   public static final Creator CREATOR = new aw();
   final int CK;
   StorageStats QS;

   OnStorageStatsResponse(int var1, StorageStats var2) {
      this.CK = var1;
      this.QS = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      aw.a(this, var1, var2);
   }
}
