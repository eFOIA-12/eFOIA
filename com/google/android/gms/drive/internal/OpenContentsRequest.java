package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ay;

public class OpenContentsRequest implements SafeParcelable {
   public static final Creator CREATOR = new ay();
   final int CK;
   final int Oi;
   final DriveId Pp;
   final int QT;

   OpenContentsRequest(int var1, DriveId var2, int var3, int var4) {
      this.CK = var1;
      this.Pp = var2;
      this.Oi = var3;
      this.QT = var4;
   }

   public OpenContentsRequest(DriveId var1, int var2, int var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ay.a(this, var1, var2);
   }
}
