package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.nm;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class nl implements SafeParcelable {
   public static final nm CREATOR = new nm();
   static final List ahg = Collections.emptyList();
   private final int CK;
   LocationRequest We;
   boolean ahh;
   boolean ahi;
   boolean ahj;
   List ahk;
   final String mTag;

   nl(int var1, LocationRequest var2, boolean var3, boolean var4, boolean var5, List var6, String var7) {
      this.CK = var1;
      this.We = var2;
      this.ahh = var3;
      this.ahi = var4;
      this.ahj = var5;
      this.ahk = var6;
      this.mTag = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof nl) {
         nl var2 = (nl)var1;
         if(jv.equal(this.We, var2.We) && this.ahh == var2.ahh && this.ahi == var2.ahi && this.ahj == var2.ahj && jv.equal(this.ahk, var2.ahk)) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return this.We.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.We.toString());
      var1.append(" requestNlpDebugInfo=");
      var1.append(this.ahh);
      var1.append(" restorePendingIntentListeners=");
      var1.append(this.ahi);
      var1.append(" triggerUpdate=");
      var1.append(this.ahj);
      var1.append(" clients=");
      var1.append(this.ahk);
      if(this.mTag != null) {
         var1.append(" tag=");
         var1.append(this.mTag);
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      nm.a(this, var1, var2);
   }
}
