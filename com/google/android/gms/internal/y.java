package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.z;

@ey
public final class y implements SafeParcelable {
   public static final z CREATOR = new z();
   public final boolean mi;
   public final boolean ms;
   public final int versionCode;

   y(int var1, boolean var2, boolean var3) {
      this.versionCode = var1;
      this.mi = var2;
      this.ms = var3;
   }

   public y(boolean var1, boolean var2) {
      this.versionCode = 1;
      this.mi = var1;
      this.ms = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      z.a(this, var1, var2);
   }
}
