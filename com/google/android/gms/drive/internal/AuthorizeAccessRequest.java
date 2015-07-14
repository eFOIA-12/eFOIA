package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.b;

public class AuthorizeAccessRequest implements SafeParcelable {
   public static final Creator CREATOR = new b();
   final int CK;
   final DriveId Oj;
   final long Pn;

   AuthorizeAccessRequest(int var1, long var2, DriveId var4) {
      this.CK = var1;
      this.Pn = var2;
      this.Oj = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
