package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.c;

public final class b implements SafeParcelable {
   public static final Creator CREATOR = new c();
   private final int CK;
   String label;
   String value;

   b() {
      this.CK = 1;
   }

   b(int var1, String var2, String var3) {
      this.CK = var1;
      this.label = var2;
      this.value = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }
}
