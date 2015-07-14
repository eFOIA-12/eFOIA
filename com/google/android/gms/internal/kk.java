package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kl;

public class kk implements SafeParcelable {
   public static final kl CREATOR = new kl();
   final int CK;
   public final String ND;
   public final int NE;

   public kk(int var1, String var2, int var3) {
      this.CK = var1;
      this.ND = var2;
      this.NE = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      kl.a(this, var1, var2);
   }
}
