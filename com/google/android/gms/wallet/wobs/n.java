package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.o;

public final class n implements SafeParcelable {
   public static final Creator CREATOR = new o();
   private final int CK;
   String awW;
   String description;

   n() {
      this.CK = 1;
   }

   n(int var1, String var2, String var3) {
      this.CK = var1;
      this.awW = var2;
      this.description = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      o.a(this, var1, var2);
   }
}
