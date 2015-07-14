package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.y;
import com.google.android.gms.maps.model.z;

public final class VisibleRegion implements SafeParcelable {
   public static final y CREATOR = new y();
   private final int CK;
   public final LatLng farLeft;
   public final LatLng farRight;
   public final LatLngBounds latLngBounds;
   public final LatLng nearLeft;
   public final LatLng nearRight;

   VisibleRegion(int var1, LatLng var2, LatLng var3, LatLng var4, LatLng var5, LatLngBounds var6) {
      this.CK = var1;
      this.nearLeft = var2;
      this.nearRight = var3;
      this.farLeft = var4;
      this.farRight = var5;
      this.latLngBounds = var6;
   }

   public VisibleRegion(LatLng var1, LatLng var2, LatLng var3, LatLng var4, LatLngBounds var5) {
      this(1, var1, var2, var3, var4, var5);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof VisibleRegion)) {
            return false;
         }

         VisibleRegion var2 = (VisibleRegion)var1;
         if(!this.nearLeft.equals(var2.nearLeft) || !this.nearRight.equals(var2.nearRight) || !this.farLeft.equals(var2.farLeft) || !this.farRight.equals(var2.farRight) || !this.latLngBounds.equals(var2.latLngBounds)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
   }

   public String toString() {
      return jv.h(this).a("nearLeft", this.nearLeft).a("nearRight", this.nearRight).a("farLeft", this.farLeft).a("farRight", this.farRight).a("latLngBounds", this.latLngBounds).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         z.a(this, var1, var2);
      } else {
         y.a(this, var1, var2);
      }
   }
}
