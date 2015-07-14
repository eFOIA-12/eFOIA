package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.k;
import com.google.android.gms.internal.jv;

public class j implements SafeParcelable {
   public static final Creator CREATOR = new k();
   private final int CK;
   private final String mName;

   j(int var1, String var2) {
      this.CK = var1;
      this.mName = var2;
   }

   public j(String var1) {
      this.CK = 1;
      this.mName = var1;
   }

   private boolean a(j var1) {
      return jv.equal(this.mName, var1.mName);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof j && this.a((j)var1);
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.mName});
   }

   public String toString() {
      return jv.h(this).a("name", this.mName).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      k.a(this, var1, var2);
   }
}
