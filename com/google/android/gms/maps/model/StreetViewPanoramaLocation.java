package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.s;

public class StreetViewPanoramaLocation implements SafeParcelable {
   public static final s CREATOR = new s();
   private final int CK;
   public final StreetViewPanoramaLink[] links;
   public final String panoId;
   public final LatLng position;

   StreetViewPanoramaLocation(int var1, StreetViewPanoramaLink[] var2, LatLng var3, String var4) {
      this.CK = var1;
      this.links = var2;
      this.position = var3;
      this.panoId = var4;
   }

   public StreetViewPanoramaLocation(StreetViewPanoramaLink[] var1, LatLng var2, String var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaLocation)) {
            return false;
         }

         StreetViewPanoramaLocation var2 = (StreetViewPanoramaLocation)var1;
         if(!this.panoId.equals(var2.panoId) || !this.position.equals(var2.position)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.position, this.panoId});
   }

   public String toString() {
      return jv.h(this).a("panoId", this.panoId).a("position", this.position.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      s.a(this, var1, var2);
   }
}
