package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ba;

public class OpenFileIntentSenderRequest implements SafeParcelable {
   public static final Creator CREATOR = new ba();
   final int CK;
   final String OH;
   final String[] OI;
   final DriveId OJ;

   OpenFileIntentSenderRequest(int var1, String var2, String[] var3, DriveId var4) {
      this.CK = var1;
      this.OH = var2;
      this.OI = var3;
      this.OJ = var4;
   }

   public OpenFileIntentSenderRequest(String var1, String[] var2, DriveId var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ba.a(this, var1, var2);
   }
}
