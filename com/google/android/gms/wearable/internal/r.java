package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.s;

@Deprecated
public class r implements SafeParcelable {
   public static final Creator CREATOR = new s();
   public final com.google.android.gms.wearable.c axJ;
   public final int statusCode;
   public final int versionCode;

   r(int var1, int var2, com.google.android.gms.wearable.c var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axJ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      s.a(this, var1, var2);
   }
}
