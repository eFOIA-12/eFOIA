package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.of;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class oe implements SafeParcelable {
   public static final of CREATOR;
   public static final oe akb = A("test_type", 1);
   public static final oe akc = A("labeled_place", 6);
   public static final Set akd;
   final int CK;
   final int ake;
   final String vc;

   static {
      akd = Collections.unmodifiableSet(new HashSet(Arrays.asList(new oe[]{akb, akc})));
      CREATOR = new of();
   }

   oe(int var1, String var2, int var3) {
      jx.bb(var2);
      this.CK = var1;
      this.vc = var2;
      this.ake = var3;
   }

   private static oe A(String var0, int var1) {
      return new oe(0, var0, var1);
   }

   public int describeContents() {
      of var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof oe)) {
            return false;
         }

         oe var2 = (oe)var1;
         if(!this.vc.equals(var2.vc) || this.ake != var2.ake) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.vc.hashCode();
   }

   public String toString() {
      return this.vc;
   }

   public void writeToParcel(Parcel var1, int var2) {
      of var3 = CREATOR;
      of.a(this, var1, var2);
   }
}
