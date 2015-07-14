package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.k;

public final class j implements SafeParcelable {
   public static final Creator CREATOR = new k();
   private final int CK;
   String awT;
   String tU;

   j() {
      this.CK = 1;
   }

   j(int var1, String var2, String var3) {
      this.CK = var1;
      this.awT = var2;
      this.tU = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      k.a(this, var1, var2);
   }
}
