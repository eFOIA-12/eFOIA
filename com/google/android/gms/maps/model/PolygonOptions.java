package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.m;
import com.google.android.gms.maps.model.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
   public static final m CREATOR = new m();
   private final int CK;
   private float alU = 10.0F;
   private int alV = -16777216;
   private int alW = 0;
   private float alX = 0.0F;
   private boolean alY = true;
   private final List amx;
   private final List amy;
   private boolean amz = false;

   public PolygonOptions() {
      this.CK = 1;
      this.amx = new ArrayList();
      this.amy = new ArrayList();
   }

   PolygonOptions(int var1, List var2, List var3, float var4, int var5, int var6, float var7, boolean var8, boolean var9) {
      this.CK = var1;
      this.amx = var2;
      this.amy = var3;
      this.alU = var4;
      this.alV = var5;
      this.alW = var6;
      this.alX = var7;
      this.alY = var8;
      this.amz = var9;
   }

   public PolygonOptions add(LatLng var1) {
      this.amx.add(var1);
      return this;
   }

   public PolygonOptions add(LatLng... var1) {
      this.amx.addAll(Arrays.asList(var1));
      return this;
   }

   public PolygonOptions addAll(Iterable var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         LatLng var2 = (LatLng)var3.next();
         this.amx.add(var2);
      }

      return this;
   }

   public PolygonOptions addHole(Iterable var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.add((LatLng)var3.next());
      }

      this.amy.add(var2);
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public PolygonOptions fillColor(int var1) {
      this.alW = var1;
      return this;
   }

   public PolygonOptions geodesic(boolean var1) {
      this.amz = var1;
      return this;
   }

   public int getFillColor() {
      return this.alW;
   }

   public List getHoles() {
      return this.amy;
   }

   public List getPoints() {
      return this.amx;
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

   public boolean isGeodesic() {
      return this.amz;
   }

   public boolean isVisible() {
      return this.alY;
   }

   List of() {
      return this.amy;
   }

   public PolygonOptions strokeColor(int var1) {
      this.alV = var1;
      return this;
   }

   public PolygonOptions strokeWidth(float var1) {
      this.alU = var1;
      return this;
   }

   public PolygonOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         n.a(this, var1, var2);
      } else {
         m.a(this, var1, var2);
      }
   }

   public PolygonOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
