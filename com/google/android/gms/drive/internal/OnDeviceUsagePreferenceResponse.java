package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.am;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
   public static final Creator CREATOR = new am();
   final int CK;
   final FileUploadPreferencesImpl QK;

   OnDeviceUsagePreferenceResponse(int var1, FileUploadPreferencesImpl var2) {
      this.CK = var1;
      this.QK = var2;
   }

   public int describeContents() {
      return 0;
   }

   public FileUploadPreferencesImpl iN() {
      return this.QK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      am.a(this, var1, var2);
   }
}
