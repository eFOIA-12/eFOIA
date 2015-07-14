package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.o;
import com.google.android.gms.maps.model.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
   public static final o CREATOR = new o();
   private final int CK;
   private float alX = 0.0F;
   private boolean alY = true;
   private float amc = 10.0F;
   private final List amx;
   private boolean amz = false;
   private int mColor = -16777216;

   public PolylineOptions() {
      this.CK = 1;
      this.amx = new ArrayList();
   }

   PolylineOptions(int var1, List var2, float var3, int var4, float var5, boolean var6, boolean var7) {
      this.CK = var1;
      this.amx = var2;
      this.amc = var3;
      this.mColor = var4;
      this.alX = var5;
      this.alY = var6;
      this.amz = var7;
   }

   public PolylineOptions add(LatLng var1) {
      this.amx.add(var1);
      return this;
   }

   public PolylineOptions add(LatLng... var1) {
      this.amx.addAll(Arrays.asList(var1));
      return this;
   }

   public PolylineOptions addAll(Iterable var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         LatLng var2 = (LatLng)var3.next();
         this.amx.add(var2);
      }

      return this;
   }

   public PolylineOptions color(int var1) {
      this.mColor = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public PolylineOptions geodesic(boolean var1) {
      this.amz = var1;
      return this;
   }

   public int getColor() {
      return this.mColor;
   }

   public List getPoints() {
      return this.amx;
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

   public boolean isGeodesic() {
      return this.amz;
   }

   public boolean isVisible() {
      return this.alY;
   }

   public PolylineOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public PolylineOptions width(float var1) {
      this.amc = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         p.a(this, var1, var2);
      } else {
         o.a(this, var1, var2);
      }
   }

   public PolylineOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
