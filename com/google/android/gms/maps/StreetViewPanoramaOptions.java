package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
   public static final c CREATOR = new c();
   private final int CK;
   private Boolean akG;
   private Boolean akM = Boolean.valueOf(true);
   private StreetViewPanoramaCamera alr;
   private String als;
   private LatLng alt;
   private Integer alu;
   private Boolean alv = Boolean.valueOf(true);
   private Boolean alw = Boolean.valueOf(true);
   private Boolean alx = Boolean.valueOf(true);

   public StreetViewPanoramaOptions() {
      this.CK = 1;
   }

   StreetViewPanoramaOptions(int var1, StreetViewPanoramaCamera var2, String var3, LatLng var4, Integer var5, byte var6, byte var7, byte var8, byte var9, byte var10) {
      this.CK = var1;
      this.alr = var2;
      this.alt = var4;
      this.alu = var5;
      this.als = var3;
      this.alv = com.google.android.gms.maps.internal.a.a(var6);
      this.akM = com.google.android.gms.maps.internal.a.a(var7);
      this.alw = com.google.android.gms.maps.internal.a.a(var8);
      this.alx = com.google.android.gms.maps.internal.a.a(var9);
      this.akG = com.google.android.gms.maps.internal.a.a(var10);
   }

   public int describeContents() {
      return 0;
   }

   public Boolean getPanningGesturesEnabled() {
      return this.alw;
   }

   public String getPanoramaId() {
      return this.als;
   }

   public LatLng getPosition() {
      return this.alt;
   }

   public Integer getRadius() {
      return this.alu;
   }

   public Boolean getStreetNamesEnabled() {
      return this.alx;
   }

   public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
      return this.alr;
   }

   public Boolean getUseViewLifecycleInFragment() {
      return this.akG;
   }

   public Boolean getUserNavigationEnabled() {
      return this.alv;
   }

   int getVersionCode() {
      return this.CK;
   }

   public Boolean getZoomGesturesEnabled() {
      return this.akM;
   }

   byte nE() {
      return com.google.android.gms.maps.internal.a.c(this.akG);
   }

   byte nI() {
      return com.google.android.gms.maps.internal.a.c(this.akM);
   }

   byte nS() {
      return com.google.android.gms.maps.internal.a.c(this.alv);
   }

   byte nT() {
      return com.google.android.gms.maps.internal.a.c(this.alw);
   }

   byte nU() {
      return com.google.android.gms.maps.internal.a.c(this.alx);
   }

   public StreetViewPanoramaOptions panningGesturesEnabled(boolean var1) {
      this.alw = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera var1) {
      this.alr = var1;
      return this;
   }

   public StreetViewPanoramaOptions panoramaId(String var1) {
      this.als = var1;
      return this;
   }

   public StreetViewPanoramaOptions position(LatLng var1) {
      this.alt = var1;
      return this;
   }

   public StreetViewPanoramaOptions position(LatLng var1, Integer var2) {
      this.alt = var1;
      this.alu = var2;
      return this;
   }

   public StreetViewPanoramaOptions streetNamesEnabled(boolean var1) {
      this.alx = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean var1) {
      this.akG = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions userNavigationEnabled(boolean var1) {
      this.alv = Boolean.valueOf(var1);
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      c.a(this, var1, var2);
   }

   public StreetViewPanoramaOptions zoomGesturesEnabled(boolean var1) {
      this.akM = Boolean.valueOf(var1);
      return this;
   }
}
