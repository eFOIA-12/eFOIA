package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a;
import com.google.android.gms.maps.b;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
   public static final a CREATOR = new a();
   private final int CK;
   private Boolean akF;
   private Boolean akG;
   private int akH = -1;
   private CameraPosition akI;
   private Boolean akJ;
   private Boolean akK;
   private Boolean akL;
   private Boolean akM;
   private Boolean akN;
   private Boolean akO;
   private Boolean akP;
   private Boolean akQ;

   public GoogleMapOptions() {
      this.CK = 1;
   }

   GoogleMapOptions(int var1, byte var2, byte var3, int var4, CameraPosition var5, byte var6, byte var7, byte var8, byte var9, byte var10, byte var11, byte var12, byte var13) {
      this.CK = var1;
      this.akF = com.google.android.gms.maps.internal.a.a(var2);
      this.akG = com.google.android.gms.maps.internal.a.a(var3);
      this.akH = var4;
      this.akI = var5;
      this.akJ = com.google.android.gms.maps.internal.a.a(var6);
      this.akK = com.google.android.gms.maps.internal.a.a(var7);
      this.akL = com.google.android.gms.maps.internal.a.a(var8);
      this.akM = com.google.android.gms.maps.internal.a.a(var9);
      this.akN = com.google.android.gms.maps.internal.a.a(var10);
      this.akO = com.google.android.gms.maps.internal.a.a(var11);
      this.akP = com.google.android.gms.maps.internal.a.a(var12);
      this.akQ = com.google.android.gms.maps.internal.a.a(var13);
   }

   public static GoogleMapOptions createFromAttributes(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var2 = var0.getResources().obtainAttributes(var1, R.styleable.MapAttrs);
         GoogleMapOptions var3 = new GoogleMapOptions();
         if(var2.hasValue(R.styleable.MapAttrs_mapType)) {
            var3.mapType(var2.getInt(R.styleable.MapAttrs_mapType, -1));
         }

         if(var2.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            var3.zOrderOnTop(var2.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
         }

         if(var2.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            var3.useViewLifecycleInFragment(var2.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
         }

         if(var2.hasValue(R.styleable.MapAttrs_uiCompass)) {
            var3.compassEnabled(var2.getBoolean(R.styleable.MapAttrs_uiCompass, true));
         }

         if(var2.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            var3.rotateGesturesEnabled(var2.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
         }

         if(var2.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            var3.scrollGesturesEnabled(var2.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
         }

         if(var2.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            var3.tiltGesturesEnabled(var2.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
         }

         if(var2.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            var3.zoomGesturesEnabled(var2.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
         }

         if(var2.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            var3.zoomControlsEnabled(var2.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
         }

         if(var2.hasValue(R.styleable.MapAttrs_liteMode)) {
            var3.liteMode(var2.getBoolean(R.styleable.MapAttrs_liteMode, false));
         }

         if(var2.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            var3.mapToolbarEnabled(var2.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
         }

         var3.camera(CameraPosition.createFromAttributes(var0, var1));
         var2.recycle();
         return var3;
      }
   }

   public GoogleMapOptions camera(CameraPosition var1) {
      this.akI = var1;
      return this;
   }

   public GoogleMapOptions compassEnabled(boolean var1) {
      this.akK = Boolean.valueOf(var1);
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public CameraPosition getCamera() {
      return this.akI;
   }

   public Boolean getCompassEnabled() {
      return this.akK;
   }

   public Boolean getLiteMode() {
      return this.akP;
   }

   public Boolean getMapToolbarEnabled() {
      return this.akQ;
   }

   public int getMapType() {
      return this.akH;
   }

   public Boolean getRotateGesturesEnabled() {
      return this.akO;
   }

   public Boolean getScrollGesturesEnabled() {
      return this.akL;
   }

   public Boolean getTiltGesturesEnabled() {
      return this.akN;
   }

   public Boolean getUseViewLifecycleInFragment() {
      return this.akG;
   }

   int getVersionCode() {
      return this.CK;
   }

   public Boolean getZOrderOnTop() {
      return this.akF;
   }

   public Boolean getZoomControlsEnabled() {
      return this.akJ;
   }

   public Boolean getZoomGesturesEnabled() {
      return this.akM;
   }

   public GoogleMapOptions liteMode(boolean var1) {
      this.akP = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions mapToolbarEnabled(boolean var1) {
      this.akQ = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions mapType(int var1) {
      this.akH = var1;
      return this;
   }

   byte nD() {
      return com.google.android.gms.maps.internal.a.c(this.akF);
   }

   byte nE() {
      return com.google.android.gms.maps.internal.a.c(this.akG);
   }

   byte nF() {
      return com.google.android.gms.maps.internal.a.c(this.akJ);
   }

   byte nG() {
      return com.google.android.gms.maps.internal.a.c(this.akK);
   }

   byte nH() {
      return com.google.android.gms.maps.internal.a.c(this.akL);
   }

   byte nI() {
      return com.google.android.gms.maps.internal.a.c(this.akM);
   }

   byte nJ() {
      return com.google.android.gms.maps.internal.a.c(this.akN);
   }

   byte nK() {
      return com.google.android.gms.maps.internal.a.c(this.akO);
   }

   byte nL() {
      return com.google.android.gms.maps.internal.a.c(this.akP);
   }

   byte nM() {
      return com.google.android.gms.maps.internal.a.c(this.akQ);
   }

   public GoogleMapOptions rotateGesturesEnabled(boolean var1) {
      this.akO = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions scrollGesturesEnabled(boolean var1) {
      this.akL = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions tiltGesturesEnabled(boolean var1) {
      this.akN = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions useViewLifecycleInFragment(boolean var1) {
      this.akG = Boolean.valueOf(var1);
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         b.a(this, var1, var2);
      } else {
         a.a(this, var1, var2);
      }
   }

   public GoogleMapOptions zOrderOnTop(boolean var1) {
      this.akF = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomControlsEnabled(boolean var1) {
      this.akJ = Boolean.valueOf(var1);
      return this;
   }

   public GoogleMapOptions zoomGesturesEnabled(boolean var1) {
      this.akM = Boolean.valueOf(var1);
      return this;
   }
}
