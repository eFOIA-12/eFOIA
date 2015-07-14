package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.o;

public final class ProxyCard implements SafeParcelable {
   public static final Creator CREATOR = new o();
   private final int CK;
   String avP;
   String avQ;
   int avR;
   int avS;

   ProxyCard(int var1, String var2, String var3, int var4, int var5) {
      this.CK = var1;
      this.avP = var2;
      this.avQ = var3;
      this.avR = var4;
      this.avS = var5;
   }

   public int describeContents() {
      return 0;
   }

   public String getCvn() {
      return this.avQ;
   }

   public int getExpirationMonth() {
      return this.avR;
   }

   public int getExpirationYear() {
      return this.avS;
   }

   public String getPan() {
      return this.avP;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      o.a(this, var1, var2);
   }
}
