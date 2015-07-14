package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ac;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
   public static final Creator CREATOR = new ac();
   final int CK;
   final String QC;
   final boolean QD;

   GetDriveIdFromUniqueIdentifierRequest(int var1, String var2, boolean var3) {
      this.CK = var1;
      this.QC = var2;
      this.QD = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ac.a(this, var1, var2);
   }
}
