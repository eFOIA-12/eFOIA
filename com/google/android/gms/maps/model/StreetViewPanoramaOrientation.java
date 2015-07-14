package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.t;

public class StreetViewPanoramaOrientation implements SafeParcelable {
   public static final t CREATOR = new t();
   private final int CK;
   public final float bearing;
   public final float tilt;

   public StreetViewPanoramaOrientation(float var1, float var2) {
      this(1, var1, var2);
   }

   StreetViewPanoramaOrientation(int var1, float var2, float var3) {
      boolean var4;
      if(-90.0F <= var2 && var2 <= 90.0F) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.b(var4, "Tilt needs to be between -90 and 90 inclusive");
      this.CK = var1;
      this.tilt = 0.0F + var2;
      var2 = var3;
      if((double)var3 <= 0.0D) {
         var2 = var3 % 360.0F + 360.0F;
      }

      this.bearing = var2 % 360.0F;
   }

   public static StreetViewPanoramaOrientation.Builder builder() {
      return new StreetViewPanoramaOrientation.Builder();
   }

   public static StreetViewPanoramaOrientation.Builder builder(StreetViewPanoramaOrientation var0) {
      return new StreetViewPanoramaOrientation.Builder(var0);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaOrientation)) {
            return false;
         }

         StreetViewPanoramaOrientation var2 = (StreetViewPanoramaOrientation)var1;
         if(Float.floatToIntBits(this.tilt) != Float.floatToIntBits(var2.tilt) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
   }

   public String toString() {
      return jv.h(this).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      t.a(this, var1, var2);
   }

   public static final class Builder {
      public float bearing;
      public float tilt;

      public Builder() {
      }

      public Builder(StreetViewPanoramaOrientation var1) {
         this.bearing = var1.bearing;
         this.tilt = var1.tilt;
      }

      public StreetViewPanoramaOrientation.Builder bearing(float var1) {
         this.bearing = var1;
         return this;
      }

      public StreetViewPanoramaOrientation build() {
         return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
      }

      public StreetViewPanoramaOrientation.Builder tilt(float var1) {
         this.tilt = var1;
         return this;
      }
   }
}
