package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.z;
import com.google.android.gms.internal.jv;

public class y implements SafeParcelable {
   public static final Creator CREATOR = new z();
   private final int CK;
   private final String UN;
   private final String mName;

   y(int var1, String var2, String var3) {
      this.CK = var1;
      this.mName = var2;
      this.UN = var3;
   }

   private y(y.a var1) {
      this.CK = 1;
      this.mName = var1.mName;
      this.UN = var1.UN;
   }

   // $FF: synthetic method
   y(y.a var1, Object var2) {
      this(var1);
   }

   private boolean a(y var1) {
      return jv.equal(this.mName, var1.mName) && jv.equal(this.UN, var1.UN);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof y && this.a((y)var1);
   }

   public String getIdentifier() {
      return this.UN;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.mName, this.UN});
   }

   public String toString() {
      return jv.h(this).a("name", this.mName).a("identifier", this.UN).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      z.a(this, var1, var2);
   }

   public static class a {
      private String UN;
      private String mName;

      public y.a bx(String var1) {
         this.mName = var1;
         return this;
      }

      public y.a by(String var1) {
         this.UN = var1;
         return this;
      }

      public y kl() {
         return new y(this, null);
      }
   }
}
