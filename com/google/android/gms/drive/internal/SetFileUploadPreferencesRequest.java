package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.be;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
   public static final Creator CREATOR = new be();
   final int CK;
   final FileUploadPreferencesImpl QK;

   SetFileUploadPreferencesRequest(int var1, FileUploadPreferencesImpl var2) {
      this.CK = var1;
      this.QK = var2;
   }

   public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      be.a(this, var1, var2);
   }
}
