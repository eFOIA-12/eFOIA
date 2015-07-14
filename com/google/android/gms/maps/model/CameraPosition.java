package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.a;
import com.google.android.gms.maps.model.b;

public final class CameraPosition implements SafeParcelable {
   public static final a CREATOR = new a();
   private final int CK;
   public final float bearing;
   public final LatLng target;
   public final float tilt;
   public final float zoom;

   CameraPosition(int var1, LatLng var2, float var3, float var4, float var5) {
      jx.b((Object)var2, "null camera target");
      boolean var6;
      if(0.0F <= var4 && var4 <= 90.0F) {
         var6 = true;
      } else {
         var6 = false;
      }

      jx.b(var6, "Tilt needs to be between 0 and 90 inclusive");
      this.CK = var1;
      this.target = var2;
      this.zoom = var3;
      this.tilt = var4 + 0.0F;
      var3 = var5;
      if((double)var5 <= 0.0D) {
         var3 = var5 % 360.0F + 360.0F;
      }

      this.bearing = var3 % 360.0F;
   }

   public CameraPosition(LatLng var1, float var2, float var3, float var4) {
      this(1, var1, var2, var3, var4);
   }

   public static CameraPosition.Builder builder() {
      return new CameraPosition.Builder();
   }

   public static CameraPosition.Builder builder(CameraPosition var0) {
      return new CameraPosition.Builder(var0);
   }

   public static CameraPosition createFromAttributes(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var5 = var0.getResources().obtainAttributes(var1, R.styleable.MapAttrs);
         float var2;
         if(var5.hasValue(R.styleable.MapAttrs_cameraTargetLat)) {
            var2 = var5.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0F);
         } else {
            var2 = 0.0F;
         }

         float var3;
         if(var5.hasValue(R.styleable.MapAttrs_cameraTargetLng)) {
            var3 = var5.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0F);
         } else {
            var3 = 0.0F;
         }

         LatLng var6 = new LatLng((double)var2, (double)var3);
         CameraPosition.Builder var4 = builder();
         var4.target(var6);
         if(var5.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            var4.zoom(var5.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0F));
         }

         if(var5.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            var4.bearing(var5.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0F));
         }

         if(var5.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            var4.tilt(var5.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0F));
         }

         return var4.build();
      }
   }

   public static final CameraPosition fromLatLngZoom(LatLng var0, float var1) {
      return new CameraPosition(var0, var1, 0.0F, 0.0F);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof CameraPosition)) {
            return false;
         }

         CameraPosition var2 = (CameraPosition)var1;
         if(!this.target.equals(var2.target) || Float.floatToIntBits(this.zoom) != Float.floatToIntBits(var2.zoom) || Float.floatToIntBits(this.tilt) != Float.floatToIntBits(var2.tilt) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
   }

   public String toString() {
      return jv.h(this).a("target", this.target).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         b.a(this, var1, var2);
      } else {
         a.a(this, var1, var2);
      }
   }

   public static final class Builder {
      private LatLng alN;
      private float alO;
      private float alP;
      private float alQ;

      public Builder() {
      }

      public Builder(CameraPosition var1) {
         this.alN = var1.target;
         this.alO = var1.zoom;
         this.alP = var1.tilt;
         this.alQ = var1.bearing;
      }

      public CameraPosition.Builder bearing(float var1) {
         this.alQ = var1;
         return this;
      }

      public CameraPosition build() {
         return new CameraPosition(this.alN, this.alO, this.alP, this.alQ);
      }

      public CameraPosition.Builder target(LatLng var1) {
         this.alN = var1;
         return this;
      }

      public CameraPosition.Builder tilt(float var1) {
         this.alP = var1;
         return this;
      }

      public CameraPosition.Builder zoom(float var1) {
         this.alO = var1;
         return this;
      }
   }
}
