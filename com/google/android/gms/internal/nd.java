package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.ne;

public class nd implements SafeParcelable {
   public static final ne CREATOR = new ne();
   private final int CK;
   public final String packageName;
   public final int uid;

   nd(int var1, int var2, String var3) {
      this.CK = var1;
      this.uid = var2;
      this.packageName = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof nd) {
         nd var2 = (nd)var1;
         if(var2.uid == this.uid && jv.equal(var2.packageName, this.packageName)) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return this.uid;
   }

   public String toString() {
      return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
   }

   public void writeToParcel(Parcel var1, int var2) {
      ne.a(this, var1, var2);
   }
}
