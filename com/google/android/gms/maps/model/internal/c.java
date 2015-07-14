package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.d;

public final class c implements SafeParcelable {
   public static final d CREATOR = new d();
   private final int CK;
   private Bundle amK;
   private int type;

   c(int var1, int var2, Bundle var3) {
      this.CK = var1;
      this.type = var2;
      this.amK = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getType() {
      return this.type;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public Bundle oi() {
      return this.amK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
