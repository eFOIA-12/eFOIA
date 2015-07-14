package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.u;

public class t implements SafeParcelable {
   public static final Creator CREATOR = new u();
   public final com.google.android.gms.wearable.c[] axK;
   public final int statusCode;
   public final int versionCode;

   t(int var1, int var2, com.google.android.gms.wearable.c[] var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axK = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      u.a(this, var1, var2);
   }
}
