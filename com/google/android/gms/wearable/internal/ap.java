package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.aq;
import com.google.android.gms.wearable.internal.m;

public class ap implements SafeParcelable {
   public static final Creator CREATOR = new aq();
   public final m axM;
   public final int statusCode;
   public final int versionCode;

   ap(int var1, int var2, m var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axM = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      aq.a(this, var1, var2);
   }
}
