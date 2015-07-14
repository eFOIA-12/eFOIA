package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.nx;

public class nw implements SafeParcelable {
   public static final nx CREATOR = new nx();
   final int CK;
   private final String ahx;
   private final String ahy;
   private final String mTag;

   nw(int var1, String var2, String var3, String var4) {
      this.CK = var1;
      this.ahx = var2;
      this.mTag = var3;
      this.ahy = var4;
   }

   public int describeContents() {
      nx var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof nw) {
         nw var2 = (nw)var1;
         if(jv.equal(this.ahx, var2.ahx) && jv.equal(this.mTag, var2.mTag) && jv.equal(this.ahy, var2.ahy)) {
            return true;
         }
      }

      return false;
   }

   public String getSource() {
      return this.ahy;
   }

   public String getTag() {
      return this.mTag;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.ahx, this.mTag, this.ahy});
   }

   public String nw() {
      return this.ahx;
   }

   public String toString() {
      return jv.h(this).a("mPlaceId", this.ahx).a("mTag", this.mTag).a("mSource", this.ahy).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      nx var3 = CREATOR;
      nx.a(this, var1, var2);
   }
}
