package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.q;

public class p implements SafeParcelable {
   public static final Creator CREATOR = new q();
   public final int axI;
   public final int statusCode;
   public final int versionCode;

   p(int var1, int var2, int var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axI = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      q.a(this, var1, var2);
   }
}
