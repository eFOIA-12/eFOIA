package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.m;
import com.google.android.gms.wearable.internal.y;

public class x implements SafeParcelable {
   public static final Creator CREATOR = new y();
   public final m axM;
   public final int statusCode;
   public final int versionCode;

   x(int var1, int var2, m var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axM = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      y.a(this, var1, var2);
   }
}
