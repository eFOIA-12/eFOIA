package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ai;

public class ListParentsRequest implements SafeParcelable {
   public static final Creator CREATOR = new ai();
   final int CK;
   final DriveId QE;

   ListParentsRequest(int var1, DriveId var2) {
      this.CK = var1;
      this.QE = var2;
   }

   public ListParentsRequest(DriveId var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ai.a(this, var1, var2);
   }
}
