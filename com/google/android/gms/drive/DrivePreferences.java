package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.d;

public class DrivePreferences implements SafeParcelable {
   public static final Creator CREATOR = new d();
   final int CK;
   final boolean Ox;

   DrivePreferences(int var1, boolean var2) {
      this.CK = var1;
      this.Ox = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
