package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.a;

public class AddEventListenerRequest implements SafeParcelable {
   public static final Creator CREATOR = new a();
   final int CK;
   final DriveId Oj;
   final int Pm;

   AddEventListenerRequest(int var1, DriveId var2, int var3) {
      this.CK = var1;
      this.Oj = var2;
      this.Pm = var3;
   }

   public AddEventListenerRequest(DriveId var1, int var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
