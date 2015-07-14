package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.n;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
   public static final Creator CREATOR = new n();
   private final int CK;
   String avN;
   CommonWalletObject avO;
   String fl;

   OfferWalletObject() {
      this.CK = 3;
   }

   OfferWalletObject(int var1, String var2, String var3, CommonWalletObject var4) {
      this.CK = var1;
      this.avN = var3;
      if(var1 < 3) {
         this.avO = CommonWalletObject.rh().dh(var2).ri();
      } else {
         this.avO = var4;
      }
   }

   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.avO.getId();
   }

   public String getRedemptionCode() {
      return this.avN;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      n.a(this, var1, var2);
   }
}
