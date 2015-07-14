package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.q;

public final class p implements SafeParcelable {
   public static final Creator CREATOR = new q();
   private final int CK;
   String awT;
   l awX;
   n awY;
   n awZ;
   String tU;

   p() {
      this.CK = 1;
   }

   p(int var1, String var2, String var3, l var4, n var5, n var6) {
      this.CK = var1;
      this.awT = var2;
      this.tU = var3;
      this.awX = var4;
      this.awY = var5;
      this.awZ = var6;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      q.a(this, var1, var2);
   }
}
