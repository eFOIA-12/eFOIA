package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.wallet.wobs.e;
import java.util.ArrayList;

public final class d implements SafeParcelable {
   public static final Creator CREATOR = new e();
   private final int CK;
   String awJ;
   String awK;
   ArrayList awL;

   d() {
      this.CK = 1;
      this.awL = la.ie();
   }

   d(int var1, String var2, String var3, ArrayList var4) {
      this.CK = var1;
      this.awJ = var2;
      this.awK = var3;
      this.awL = var4;
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
