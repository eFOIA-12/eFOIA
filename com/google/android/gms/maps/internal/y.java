package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.z;

public class y implements SafeParcelable {
   public static final z CREATOR = new z();
   private final Point alK;
   private final int versionCode;

   public y(int var1, Point var2) {
      this.versionCode = var1;
      this.alK = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof y)) {
         return false;
      } else {
         y var2 = (y)var1;
         return this.alK.equals(var2.alK);
      }
   }

   int getVersionCode() {
      return this.versionCode;
   }

   public int hashCode() {
      return this.alK.hashCode();
   }

   public Point oa() {
      return this.alK;
   }

   public String toString() {
      return this.alK.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      z.a(this, var1, var2);
   }
}
