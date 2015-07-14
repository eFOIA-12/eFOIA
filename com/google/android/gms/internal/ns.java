package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.nt;
import com.google.android.gms.internal.nu;

public final class ns implements SafeParcelable {
   public static final nt CREATOR = new nt();
   private final int CK;
   private final int agd;
   private final int ahp;
   private final nu ahq;

   ns(int var1, int var2, int var3, nu var4) {
      this.CK = var1;
      this.agd = var2;
      this.ahp = var3;
      this.ahq = var4;
   }

   public int describeContents() {
      nt var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof ns)) {
            return false;
         }

         ns var2 = (ns)var1;
         if(this.agd != var2.agd || this.ahp != var2.ahp || !this.ahq.equals(var2.ahq)) {
            return false;
         }
      }

      return true;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.agd), Integer.valueOf(this.ahp)});
   }

   public int np() {
      return this.agd;
   }

   public int ns() {
      return this.ahp;
   }

   public nu nt() {
      return this.ahq;
   }

   public String toString() {
      return jv.h(this).a("transitionTypes", Integer.valueOf(this.agd)).a("loiteringTimeMillis", Integer.valueOf(this.ahp)).a("placeFilter", this.ahq).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      nt var3 = CREATOR;
      nt.a(this, var1, var2);
   }
}
