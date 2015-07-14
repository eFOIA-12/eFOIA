package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.a;
import com.google.android.gms.maps.model.internal.q;

public final class p implements SafeParcelable {
   public static final q CREATOR = new q();
   private final int CK;
   private a amN;

   public p() {
      this.CK = 1;
   }

   p(int var1, a var2) {
      this.CK = var1;
      this.amN = var2;
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public a ol() {
      return this.amN;
   }

   public void writeToParcel(Parcel var1, int var2) {
      q.a(this, var1, var2);
   }
}
