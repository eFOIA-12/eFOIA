package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.px;

public final class pw implements SafeParcelable {
   public static final Creator CREATOR = new px();
   private final int CK;
   int[] avX;

   pw() {
      this(1, (int[])null);
   }

   pw(int var1, int[] var2) {
      this.CK = var1;
      this.avX = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      px.a(this, var1, var2);
   }
}
