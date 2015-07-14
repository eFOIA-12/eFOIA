package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.internal.bd;

public class SetDrivePreferencesRequest implements SafeParcelable {
   public static final Creator CREATOR = new bd();
   final int CK;
   final DrivePreferences QN;

   SetDrivePreferencesRequest(int var1, DrivePreferences var2) {
      this.CK = var1;
      this.QN = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      bd.a(this, var1, var2);
   }
}
