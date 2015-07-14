package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.i;
import com.google.android.gms.maps.model.j;

public final class LatLng implements SafeParcelable {
   public static final i CREATOR = new i();
   private final int CK;
   public final double latitude;
   public final double longitude;

   public LatLng(double var1, double var3) {
      this(1, var1, var3);
   }

   LatLng(int var1, double var2, double var4) {
      this.CK = var1;
      if(-180.0D <= var4 && var4 < 180.0D) {
         this.longitude = var4;
      } else {
         this.longitude = ((var4 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D;
      }

      this.latitude = Math.max(-90.0D, Math.min(90.0D, var2));
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LatLng)) {
            return false;
         }

         LatLng var2 = (LatLng)var1;
         if(Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(var2.latitude) || Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(var2.longitude)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      long var2 = Double.doubleToLongBits(this.latitude);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.longitude);
      return (var1 + 31) * 31 + (int)(var2 ^ var2 >>> 32);
   }

   public String toString() {
      return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         j.a(this, var1, var2);
      } else {
         i.a(this, var1, var2);
      }
   }
}
