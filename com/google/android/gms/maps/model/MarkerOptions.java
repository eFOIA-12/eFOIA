package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.k;
import com.google.android.gms.maps.model.l;

public final class MarkerOptions implements SafeParcelable {
   public static final k CREATOR = new k();
   private final int CK;
   private String OH;
   private boolean alY = true;
   private LatLng alt;
   private float amg = 0.5F;
   private float amh = 1.0F;
   private String amp;
   private BitmapDescriptor amq;
   private boolean amr;
   private boolean ams = false;
   private float amt = 0.0F;
   private float amu = 0.5F;
   private float amv = 0.0F;
   private float mAlpha = 1.0F;

   public MarkerOptions() {
      this.CK = 1;
   }

   MarkerOptions(int var1, LatLng var2, String var3, String var4, IBinder var5, float var6, float var7, boolean var8, boolean var9, boolean var10, float var11, float var12, float var13, float var14) {
      this.CK = var1;
      this.alt = var2;
      this.OH = var3;
      this.amp = var4;
      BitmapDescriptor var15;
      if(var5 == null) {
         var15 = null;
      } else {
         var15 = new BitmapDescriptor(com.google.android.gms.dynamic.d.ap(var5));
      }

      this.amq = var15;
      this.amg = var6;
      this.amh = var7;
      this.amr = var8;
      this.alY = var9;
      this.ams = var10;
      this.amt = var11;
      this.amu = var12;
      this.amv = var13;
      this.mAlpha = var14;
   }

   public MarkerOptions alpha(float var1) {
      this.mAlpha = var1;
      return this;
   }

   public MarkerOptions anchor(float var1, float var2) {
      this.amg = var1;
      this.amh = var2;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public MarkerOptions draggable(boolean var1) {
      this.amr = var1;
      return this;
   }

   public MarkerOptions flat(boolean var1) {
      this.ams = var1;
      return this;
   }

   public float getAlpha() {
      return this.mAlpha;
   }

   public float getAnchorU() {
      return this.amg;
   }

   public float getAnchorV() {
      return this.amh;
   }

   public BitmapDescriptor getIcon() {
      return this.amq;
   }

   public float getInfoWindowAnchorU() {
      return this.amu;
   }

   public float getInfoWindowAnchorV() {
      return this.amv;
   }

   public LatLng getPosition() {
      return this.alt;
   }

   public float getRotation() {
      return this.amt;
   }

   public String getSnippet() {
      return this.amp;
   }

   public String getTitle() {
      return this.OH;
   }

   int getVersionCode() {
      return this.CK;
   }

   public MarkerOptions icon(BitmapDescriptor var1) {
      this.amq = var1;
      return this;
   }

   public MarkerOptions infoWindowAnchor(float var1, float var2) {
      this.amu = var1;
      this.amv = var2;
      return this;
   }

   public boolean isDraggable() {
      return this.amr;
   }

   public boolean isFlat() {
      return this.ams;
   }

   public boolean isVisible() {
      return this.alY;
   }

   IBinder oe() {
      return this.amq == null?null:this.amq.nA().asBinder();
   }

   public MarkerOptions position(LatLng var1) {
      this.alt = var1;
      return this;
   }

   public MarkerOptions rotation(float var1) {
      this.amt = var1;
      return this;
   }

   public MarkerOptions snippet(String var1) {
      this.amp = var1;
      return this;
   }

   public MarkerOptions title(String var1) {
      this.OH = var1;
      return this;
   }

   public MarkerOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         l.a(this, var1, var2);
      } else {
         k.a(this, var1, var2);
      }
   }
}
