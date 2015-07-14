package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hg;

public class hf implements SafeParcelable {
   public static final hg CREATOR = new hg();
   final int CK;
   final String CS;
   final String CT;
   final String CU;

   hf(int var1, String var2, String var3, String var4) {
      this.CK = var1;
      this.CS = var2;
      this.CT = var3;
      this.CU = var4;
   }

   public hf(String var1, String var2, String var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      hg var1 = CREATOR;
      return 0;
   }

   public String toString() {
      return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.CS, this.CT, this.CU});
   }

   public void writeToParcel(Parcel var1, int var2) {
      hg var3 = CREATOR;
      hg.a(this, var1, var2);
   }
}
