package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.nz;
import java.util.concurrent.TimeUnit;

public final class ny implements SafeParcelable {
   public static final nz CREATOR = new nz();
   public static final long ahz;
   final int CK;
   private final long agr;
   private final nu ahA;
   private final int mPriority;

   static {
      ahz = TimeUnit.HOURS.toMillis(1L);
   }

   public ny(int var1, nu var2, long var3, int var5) {
      this.CK = var1;
      this.ahA = var2;
      this.agr = var3;
      this.mPriority = var5;
   }

   public int describeContents() {
      nz var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof ny)) {
            return false;
         }

         ny var2 = (ny)var1;
         if(!jv.equal(this.ahA, var2.ahA) || this.agr != var2.agr || this.mPriority != var2.mPriority) {
            return false;
         }
      }

      return true;
   }

   public long getInterval() {
      return this.agr;
   }

   public int getPriority() {
      return this.mPriority;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.ahA, Long.valueOf(this.agr), Integer.valueOf(this.mPriority)});
   }

   public nu nt() {
      return this.ahA;
   }

   public String toString() {
      return jv.h(this).a("filter", this.ahA).a("interval", Long.valueOf(this.agr)).a("priority", Integer.valueOf(this.mPriority)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      nz var3 = CREATOR;
      nz.a(this, var1, var2);
   }
}
