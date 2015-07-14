package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.nv;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class nu implements SafeParcelable {
   public static final nv CREATOR = new nv();
   final int CK;
   final List ahn;
   private final Set aho;
   private final String ahr;
   private final boolean ahs;
   final List aht;
   final List ahu;
   private final Set ahv;
   private final Set ahw;

   nu(int var1, List var2, String var3, boolean var4, List var5, List var6) {
      this.CK = var1;
      if(var2 == null) {
         var2 = Collections.emptyList();
      } else {
         var2 = Collections.unmodifiableList(var2);
      }

      this.ahn = var2;
      String var7 = var3;
      if(var3 == null) {
         var7 = "";
      }

      this.ahr = var7;
      this.ahs = var4;
      if(var5 == null) {
         var2 = Collections.emptyList();
      } else {
         var2 = Collections.unmodifiableList(var5);
      }

      this.aht = var2;
      if(var6 == null) {
         var2 = Collections.emptyList();
      } else {
         var2 = Collections.unmodifiableList(var6);
      }

      this.ahu = var2;
      this.aho = g(this.ahn);
      this.ahv = g(this.aht);
      this.ahw = g(this.ahu);
   }

   private static Set g(List var0) {
      return var0.isEmpty()?Collections.emptySet():Collections.unmodifiableSet(new HashSet(var0));
   }

   public int describeContents() {
      nv var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof nu)) {
            return false;
         }

         nu var2 = (nu)var1;
         if(!this.aho.equals(var2.aho) || this.ahs != var2.ahs || !this.ahv.equals(var2.ahv) || !this.ahw.equals(var2.ahw)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.aho, Boolean.valueOf(this.ahs), this.ahv, this.ahw});
   }

   @Deprecated
   public String nu() {
      return this.ahr;
   }

   public boolean nv() {
      return this.ahs;
   }

   public String toString() {
      return jv.h(this).a("types", this.aho).a("placeIds", this.ahw).a("requireOpenNow", Boolean.valueOf(this.ahs)).a("requestedUserDataTypes", this.ahv).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      nv var3 = CREATOR;
      nv.a(this, var1, var2);
   }
}
