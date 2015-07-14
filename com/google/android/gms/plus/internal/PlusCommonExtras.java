package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.plus.internal.f;

public class PlusCommonExtras implements SafeParcelable {
   public static final f CREATOR = new f();
   public static String TAG = "PlusCommonExtras";
   private final int CK;
   private String anN;
   private String anO;

   public PlusCommonExtras() {
      this.CK = 1;
      this.anN = "";
      this.anO = "";
   }

   PlusCommonExtras(int var1, String var2, String var3) {
      this.CK = var1;
      this.anN = var2;
      this.anO = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof PlusCommonExtras) {
         PlusCommonExtras var2 = (PlusCommonExtras)var1;
         if(this.CK == var2.CK && jv.equal(this.anN, var2.anN) && jv.equal(this.anO, var2.anO)) {
            return true;
         }
      }

      return false;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.CK), this.anN, this.anO});
   }

   public String ox() {
      return this.anN;
   }

   public String oy() {
      return this.anO;
   }

   public void q(Bundle var1) {
      var1.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", com.google.android.gms.common.internal.safeparcel.c.a(this));
   }

   public String toString() {
      return jv.h(this).a("versionCode", Integer.valueOf(this.CK)).a("Gpsrc", this.anN).a("ClientCallingPackage", this.anO).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
