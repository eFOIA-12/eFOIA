package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.model.r;

public class StreetViewPanoramaLink implements SafeParcelable {
   public static final r CREATOR = new r();
   private final int CK;
   public final float bearing;
   public final String panoId;

   StreetViewPanoramaLink(int var1, String var2, float var3) {
      this.CK = var1;
      this.panoId = var2;
      float var4 = var3;
      if((double)var3 <= 0.0D) {
         var4 = var3 % 360.0F + 360.0F;
      }

      this.bearing = var4 % 360.0F;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaLink)) {
            return false;
         }

         StreetViewPanoramaLink var2 = (StreetViewPanoramaLink)var1;
         if(!this.panoId.equals(var2.panoId) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.panoId, Float.valueOf(this.bearing)});
   }

   public String toString() {
      return jv.h(this).a("panoId", this.panoId).a("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      r.a(this, var1, var2);
   }
}
