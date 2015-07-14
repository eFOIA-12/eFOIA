package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class Scope implements SafeParcelable {
   public static final Creator CREATOR = new e();
   final int CK;
   private final String Kv;

   Scope(int var1, String var2) {
      jx.b((String)var2, "scopeUri must not be null or empty");
      this.CK = var1;
      this.Kv = var2;
   }

   public Scope(String var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Scope)?false:this.Kv.equals(((Scope)var1).Kv));
   }

   public String gO() {
      return this.Kv;
   }

   public int hashCode() {
      return this.Kv.hashCode();
   }

   public String toString() {
      return this.Kv;
   }

   public void writeToParcel(Parcel var1, int var2) {
      e.a(this, var1, var2);
   }
}
