package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ac;
import com.google.android.gms.wearable.internal.al;

public class ab implements SafeParcelable {
   public static final Creator CREATOR = new ac();
   public final al axO;
   public final int statusCode;
   public final int versionCode;

   ab(int var1, int var2, al var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axO = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ac.a(this, var1, var2);
   }
}
