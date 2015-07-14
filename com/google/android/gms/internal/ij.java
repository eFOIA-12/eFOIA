package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;

public class ij implements SafeParcelable {
   public static final Creator CREATOR = new ik();
   private final int CK;
   private String Hd;

   public ij() {
      this(1, (String)null);
   }

   ij(int var1, String var2) {
      this.CK = var1;
      this.Hd = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ij)) {
         return false;
      } else {
         ij var2 = (ij)var1;
         return in.a(this.Hd, var2.Hd);
      }
   }

   public String fT() {
      return this.Hd;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.Hd});
   }

   public void writeToParcel(Parcel var1, int var2) {
      ik.a(this, var1, var2);
   }
}
