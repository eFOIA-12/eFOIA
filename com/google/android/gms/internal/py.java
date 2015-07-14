package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.pz;

public final class py implements SafeParcelable {
   public static final Creator CREATOR = new pz();
   private final int CK;
   String[] avY;
   byte[][] avZ;

   py() {
      this(1, new String[0], new byte[0][]);
   }

   py(int var1, String[] var2, byte[][] var3) {
      this.CK = var1;
      this.avY = var2;
      this.avZ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      pz.a(this, var1, var2);
   }
}
