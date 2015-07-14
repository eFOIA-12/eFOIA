package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;

public class if implements SafeParcelable {
   public static final ig CREATOR = new ig();
   final Bundle Ep;
   final byte[] Eq;
   final int responseCode;
   final int versionCode;

   public if(int var1, int var2, Bundle var3, byte[] var4) {
      this.versionCode = var1;
      this.responseCode = var2;
      this.Ep = var3;
      this.Eq = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ig.a(this, var1, var2);
   }
}
