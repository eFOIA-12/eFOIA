package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.a;
import com.google.android.gms.maps.model.internal.f;

public final class e implements SafeParcelable {
   public static final f CREATOR = new f();
   private final int CK;
   private a amM;

   public e() {
      this.CK = 1;
   }

   e(int var1, a var2) {
      this.CK = var1;
      this.amM = var2;
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.CK;
   }

   public a oj() {
      return this.amM;
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
