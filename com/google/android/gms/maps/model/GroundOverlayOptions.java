package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.e;
import com.google.android.gms.maps.model.f;

public final class GroundOverlayOptions implements SafeParcelable {
   public static final e CREATOR = new e();
   public static final float NO_DIMENSION = -1.0F;
   private final int CK;
   private float alQ;
   private float alX;
   private boolean alY = true;
   private BitmapDescriptor ama;
   private LatLng amb;
   private float amc;
   private float amd;
   private LatLngBounds ame;
   private float amf = 0.0F;
   private float amg = 0.5F;
   private float amh = 0.5F;

   public GroundOverlayOptions() {
      this.CK = 1;
   }

   GroundOverlayOptions(int var1, IBinder var2, LatLng var3, float var4, float var5, LatLngBounds var6, float var7, float var8, boolean var9, float var10, float var11, float var12) {
      this.CK = var1;
      this.ama = new BitmapDescriptor(com.google.android.gms.dynamic.d.ap(var2));
      this.amb = var3;
      this.amc = var4;
      this.amd = var5;
      this.ame = var6;
      this.alQ = var7;
      this.alX = var8;
      this.alY = var9;
      this.amf = var10;
      this.amg = var11;
      this.amh = var12;
   }

   private GroundOverlayOptions a(LatLng var1, float var2, float var3) {
      this.amb = var1;
      this.amc = var2;
      this.amd = var3;
      return this;
   }

   public GroundOverlayOptions anchor(float var1, float var2) {
      this.amg = var1;
      this.amh = var2;
      return this;
   }

   public GroundOverlayOptions bearing(float var1) {
      this.alQ = (var1 % 360.0F + 360.0F) % 360.0F;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public float getAnchorU() {
      return this.amg;
   }

   public float getAnchorV() {
      return this.amh;
   }

   public float getBearing() {
      return this.alQ;
   }

   public LatLngBounds getBounds() {
      return this.ame;
   }

   public float getHeight() {
      return this.amd;
   }

   public BitmapDescriptor getImage() {
      return this.ama;
   }

   public LatLng getLocation() {
      return this.amb;
   }

   public float getTransparency() {
      return this.amf;
   }

   int getVersionCode() {
      return this.CK;
   }

   public float getWidth() {
      return this.amc;
   }

   public float getZIndex() {
      return this.alX;
   }

   public GroundOverlayOptions image(BitmapDescriptor var1) {
      this.ama = var1;
      return this;
   }

   public boolean isVisible() {
      return this.alY;
   }

   IBinder od() {
      return this.ama.nA().asBinder();
   }

   public GroundOverlayOptions position(LatLng var1, float var2) {
      boolean var4 = true;
      boolean var3;
      if(this.ame == null) {
         var3 = true;
      } else {
         var3 = false;
      }

      jx.a(var3, "Position has already been set using positionFromBounds");
      if(var1 != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      jx.b(var3, "Location must be specified");
      if(var2 >= 0.0F) {
         var3 = var4;
      } else {
         var3 = false;
      }

      jx.b(var3, "Width must be non-negative");
      return this.a(var1, var2, -1.0F);
   }

   public GroundOverlayOptions position(LatLng var1, float var2, float var3) {
      boolean var5 = true;
      boolean var4;
      if(this.ame == null) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.a(var4, "Position has already been set using positionFromBounds");
      if(var1 != null) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.b(var4, "Location must be specified");
      if(var2 >= 0.0F) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.b(var4, "Width must be non-negative");
      if(var3 >= 0.0F) {
         var4 = var5;
      } else {
         var4 = false;
      }

      jx.b(var4, "Height must be non-negative");
      return this.a(var1, var2, var3);
   }

   public GroundOverlayOptions positionFromBounds(LatLngBounds var1) {
      boolean var2;
      if(this.amb == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.a(var2, "Position has already been set using position: " + this.amb);
      this.ame = var1;
      return this;
   }

   public GroundOverlayOptions transparency(float var1) {
      boolean var2;
      if(var1 >= 0.0F && var1 <= 1.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.b(var2, "Transparency must be in the range [0..1]");
      this.amf = var1;
      return this;
   }

   public GroundOverlayOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         f.a(this, var1, var2);
      } else {
         e.a(this, var1, var2);
      }
   }

   public GroundOverlayOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
