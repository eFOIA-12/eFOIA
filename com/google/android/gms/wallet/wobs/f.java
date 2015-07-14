package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.g;
import com.google.android.gms.wallet.wobs.i;
import com.google.android.gms.wallet.wobs.l;

public final class f implements SafeParcelable {
   public static final Creator CREATOR = new i();
   private final int CK;
   l avm;
   g awM;
   String label;
   String type;

   f() {
      this.CK = 1;
   }

   f(int var1, String var2, g var3, String var4, l var5) {
      this.CK = var1;
      this.label = var2;
      this.awM = var3;
      this.type = var4;
      this.avm = var5;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      i.a(this, var1, var2);
   }
}
