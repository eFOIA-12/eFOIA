package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.f;

public class TextInsertedDetails implements SafeParcelable {
   public static final Creator CREATOR = new f();
   final int CK;
   final int Ti;
   final int mIndex;

   TextInsertedDetails(int var1, int var2, int var3) {
      this.CK = var1;
      this.mIndex = var2;
      this.Ti = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
