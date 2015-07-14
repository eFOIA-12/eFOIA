package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.h;

public final class g implements SafeParcelable {
   public static final Creator CREATOR = new h();
   private final int CK;
   int awN;
   String awO;
   double awP;
   String awQ;
   long awR;
   int awS;

   g() {
      this.CK = 1;
      this.awS = -1;
      this.awN = -1;
      this.awP = -1.0D;
   }

   g(int var1, int var2, String var3, double var4, String var6, long var7, int var9) {
      this.CK = var1;
      this.awN = var2;
      this.awO = var3;
      this.awP = var4;
      this.awQ = var6;
      this.awR = var7;
      this.awS = var9;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      h.a(this, var1, var2);
   }
}
