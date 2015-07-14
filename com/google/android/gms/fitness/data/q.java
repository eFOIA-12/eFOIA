package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.r;
import com.google.android.gms.internal.jv;

public class q implements SafeParcelable {
   public static final Creator CREATOR = new r();
   final int CK;
   private final Session TQ;
   private final DataSet UP;

   q(int var1, Session var2, DataSet var3) {
      this.CK = var1;
      this.TQ = var2;
      this.UP = var3;
   }

   private boolean a(q var1) {
      return jv.equal(this.TQ, var1.TQ) && jv.equal(this.UP, var1.UP);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof q && this.a((q)var1);
   }

   public Session getSession() {
      return this.TQ;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.TQ, this.UP});
   }

   public DataSet jH() {
      return this.UP;
   }

   public String toString() {
      return jv.h(this).a("session", this.TQ).a("dataSet", this.UP).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      r.a(this, var1, var2);
   }
}
