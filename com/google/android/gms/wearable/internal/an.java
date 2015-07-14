package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ao;

public class an implements SafeParcelable {
   public static final Creator CREATOR = new ao();
   public final long ayc;
   public final String label;
   public final String packageName;
   public final int versionCode;

   an(int var1, String var2, String var3, long var4) {
      this.versionCode = var1;
      this.packageName = var2;
      this.label = var3;
      this.ayc = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ao.a(this, var1, var2);
   }
}
