package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.au;

public class at implements SafeParcelable {
   public static final Creator CREATOR = new au();
   public final int ayd;
   public final int statusCode;
   public final int versionCode;

   at(int var1, int var2, int var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.ayd = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      au.a(this, var1, var2);
   }
}
