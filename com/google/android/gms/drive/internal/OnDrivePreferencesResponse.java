package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.internal.ap;

public class OnDrivePreferencesResponse implements SafeParcelable {
   public static final Creator CREATOR = new ap();
   final int CK;
   DrivePreferences QN;

   OnDrivePreferencesResponse(int var1, DrivePreferences var2) {
      this.CK = var1;
      this.QN = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ap.a(this, var1, var2);
   }
}
