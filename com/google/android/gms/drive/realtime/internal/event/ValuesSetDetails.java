package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.j;

public class ValuesSetDetails implements SafeParcelable {
   public static final Creator CREATOR = new j();
   final int CK;
   final int SO;
   final int SP;
   final int mIndex;

   ValuesSetDetails(int var1, int var2, int var3, int var4) {
      this.CK = var1;
      this.mIndex = var2;
      this.SO = var3;
      this.SP = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      j.a(this, var1, var2);
   }
}
