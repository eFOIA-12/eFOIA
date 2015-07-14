package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.v;
import com.google.android.gms.internal.jv;

public class u implements SafeParcelable {
   public static final Creator CREATOR = new v();
   private final int CK;
   private final PendingIntent mPendingIntent;

   u(int var1, PendingIntent var2) {
      this.CK = var1;
      this.mPendingIntent = var2;
   }

   public u(PendingIntent var1) {
      this.CK = 3;
      this.mPendingIntent = var1;
   }

   private boolean a(u var1) {
      return jv.equal(this.mPendingIntent, var1.mPendingIntent);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof u && this.a((u)var1);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.mPendingIntent});
   }

   public PendingIntent kb() {
      return this.mPendingIntent;
   }

   public String toString() {
      return jv.h(this).a("pendingIntent", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      v.a(this, var1, var2);
   }
}
