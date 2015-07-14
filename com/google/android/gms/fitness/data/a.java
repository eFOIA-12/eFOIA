package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.b;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public final class a implements SafeParcelable {
   public static final Creator CREATOR = new b();
   public static final a TT = new a("com.google.android.gms", String.valueOf(6587000), (String)null);
   private final int CK;
   private final String CS;
   private final String TU;
   private final String TV;

   a(int var1, String var2, String var3, String var4) {
      this.CK = var1;
      this.CS = (String)jx.i(var2);
      this.TU = "";
      this.TV = var4;
   }

   public a(String var1, String var2, String var3) {
      this(1, var1, "", var3);
   }

   private boolean a(a var1) {
      return this.CS.equals(var1.CS) && jv.equal(this.TU, var1.TU) && jv.equal(this.TV, var1.TV);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof a && this.a((a)var1);
   }

   public String getPackageName() {
      return this.CS;
   }

   public String getVersion() {
      return this.TU;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.CS, this.TU, this.TV});
   }

   public String jk() {
      return this.TV;
   }

   a jl() {
      return new a(mg.bw(this.CS), mg.bw(this.TU), mg.bw(this.TV));
   }

   public String toString() {
      return String.format("Application{%s:%s:%s}", new Object[]{this.CS, this.TU, this.TV});
   }

   public void writeToParcel(Parcel var1, int var2) {
      b.a(this, var1, var2);
   }
}
