package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.a;

public class ObjectChangedDetails implements SafeParcelable {
   public static final Creator CREATOR = new a();
   final int CK;
   final int SO;
   final int SP;

   ObjectChangedDetails(int var1, int var2, int var3) {
      this.CK = var1;
      this.SO = var2;
      this.SP = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }
}
