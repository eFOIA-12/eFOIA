package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.m;

public final class l implements SafeParcelable {
   public static final Creator CREATOR = new m();
   private final int CK;
   long awU;
   long awV;

   l() {
      this.CK = 1;
   }

   l(int var1, long var2, long var4) {
      this.CK = var1;
      this.awU = var2;
      this.awV = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      m.a(this, var1, var2);
   }
}
