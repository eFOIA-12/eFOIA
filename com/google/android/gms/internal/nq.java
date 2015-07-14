package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.nr;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nq implements SafeParcelable {
   public static final nr CREATOR = new nr();
   final int CK;
   final boolean ahm;
   final List ahn;
   private final Set aho;

   nq(int var1, boolean var2, List var3) {
      this.CK = var1;
      this.ahm = var2;
      if(var3 == null) {
         var3 = Collections.emptyList();
      } else {
         var3 = Collections.unmodifiableList(var3);
      }

      this.ahn = var3;
      if(this.ahn.isEmpty()) {
         this.aho = Collections.emptySet();
      } else {
         this.aho = Collections.unmodifiableSet(new HashSet(this.ahn));
      }
   }

   public int describeContents() {
      nr var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof nq)) {
            return false;
         }

         nq var2 = (nq)var1;
         if(!this.aho.equals(var2.aho) || this.ahm != var2.ahm) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.aho, Boolean.valueOf(this.ahm)});
   }

   public boolean nr() {
      return this.ahm;
   }

   public void writeToParcel(Parcel var1, int var2) {
      nr var3 = CREATOR;
      nr.a(this, var1, var2);
   }
}
