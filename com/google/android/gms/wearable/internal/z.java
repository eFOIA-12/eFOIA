package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.aa;

public class z implements SafeParcelable {
   public static final Creator CREATOR = new aa();
   public final ParcelFileDescriptor axN;
   public final int statusCode;
   public final int versionCode;

   z(int var1, int var2, ParcelFileDescriptor var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.axN = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      aa.a(this, var1, var2 | 1);
   }
}
