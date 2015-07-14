package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class hj implements SafeParcelable {
   public static final hk CREATOR = new hk();
   final int CK;
   final Bundle Db;
   public final int id;

   hj(int var1, int var2, Bundle var3) {
      this.CK = var1;
      this.id = var2;
      this.Db = var3;
   }

   public int describeContents() {
      hk var1 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      hk var3 = CREATOR;
      hk.a(this, var1, var2);
   }
}
