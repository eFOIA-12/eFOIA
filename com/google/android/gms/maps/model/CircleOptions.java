package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.c;
import com.google.android.gms.maps.model.d;

public final class CircleOptions implements SafeParcelable {
   public static final c CREATOR = new c();
   private final int CK;
   private LatLng alS = null;
   private double alT = 0.0D;
   private float alU = 10.0F;
   private int alV = -16777216;
   private int alW = 0;
   private float alX = 0.0F;
   private boolean alY = true;

   public CircleOptions() {
      this.CK = 1;
   }

   CircleOptions(int var1, LatLng var2, double var3, float var5, int var6, int var7, float var8, boolean var9) {
      this.CK = var1;
      this.alS = var2;
      this.alT = var3;
      this.alU = var5;
      this.alV = var6;
      this.alW = var7;
      this.alX = var8;
      this.alY = var9;
   }

   public CircleOptions center(LatLng var1) {
      this.alS = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public CircleOptions fillColor(int var1) {
      this.alW = var1;
      return this;
   }

   public LatLng getCenter() {
      return this.alS;
   }

   public int getFillColor() {
      return this.alW;
   }

   public double getRadius() {
      return this.alT;
   }

   public int getStrokeColor() {
      return this.alV;
   }

   public float getStrokeWidth() {
      return this.alU;
   }

   int getVersionCode() {
      return this.CK;
   }

   public float getZIndex() {
      return this.alX;
   }

   public boolean isVisible() {
      return this.alY;
   }

   public CircleOptions radius(double var1) {
      this.alT = var1;
      return this;
   }

   public CircleOptions strokeColor(int var1) {
      this.alV = var1;
      return this;
   }

   public CircleOptions strokeWidth(float var1) {
      this.alU = var1;
      return this;
   }

   public CircleOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         d.a(this, var1, var2);
      } else {
         c.a(this, var1, var2);
      }
   }

   public CircleOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
