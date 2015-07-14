package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.e;

public final class d implements SafeParcelable {
   public static final Creator CREATOR = new e();
   private final int CK;
   LoyaltyWalletObject auJ;
   OfferWalletObject auK;

   d() {
      this.CK = 2;
   }

   d(int var1, LoyaltyWalletObject var2, OfferWalletObject var3) {
      this.CK = var1;
      this.auJ = var2;
      this.auK = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      e.a(this, var1, var2);
   }
}
