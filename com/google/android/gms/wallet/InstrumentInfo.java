package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.h;

public final class InstrumentInfo implements SafeParcelable {
   public static final Creator CREATOR = new h();
   private final int CK;
   private String auX;
   private String auY;

   InstrumentInfo(int var1, String var2, String var3) {
      this.CK = var1;
      this.auX = var2;
      this.auY = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String getInstrumentDetails() {
      return this.auY;
   }

   public String getInstrumentType() {
      return this.auX;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }
}
