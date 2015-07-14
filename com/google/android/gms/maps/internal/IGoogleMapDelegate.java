package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.internal.b;
import com.google.android.gms.maps.internal.d;
import com.google.android.gms.maps.internal.e;
import com.google.android.gms.maps.internal.f;
import com.google.android.gms.maps.internal.g;
import com.google.android.gms.maps.internal.h;
import com.google.android.gms.maps.internal.j;
import com.google.android.gms.maps.internal.k;
import com.google.android.gms.maps.internal.l;
import com.google.android.gms.maps.internal.m;
import com.google.android.gms.maps.internal.n;
import com.google.android.gms.maps.internal.o;
import com.google.android.gms.maps.internal.p;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

public interface IGoogleMapDelegate extends IInterface {
   com.google.android.gms.maps.model.internal.h addCircle(CircleOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.i addGroundOverlay(GroundOverlayOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.i addGroundOverlay2(GroundOverlayOptions var1, com.google.android.gms.maps.model.internal.e var2) throws RemoteException;

   com.google.android.gms.maps.model.internal.l addMarker(MarkerOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.l addMarker2(MarkerOptions var1, com.google.android.gms.maps.model.internal.p var2) throws RemoteException;

   com.google.android.gms.maps.model.internal.m addPolygon(PolygonOptions var1) throws RemoteException;

   IPolylineDelegate addPolyline(PolylineOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.n addTileOverlay(TileOverlayOptions var1) throws RemoteException;

   void animateCamera(com.google.android.gms.dynamic.d var1) throws RemoteException;

   void animateCamera2(com.google.android.gms.maps.model.internal.c var1) throws RemoteException;

   void animateCameraWithCallback(com.google.android.gms.dynamic.d var1, b var2) throws RemoteException;

   void animateCameraWithCallback2(com.google.android.gms.maps.model.internal.c var1, b var2) throws RemoteException;

   void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d var1, int var2, b var3) throws RemoteException;

   void animateCameraWithDurationAndCallback2(com.google.android.gms.maps.model.internal.c var1, int var2, b var3) throws RemoteException;

   void clear() throws RemoteException;

   CameraPosition getCameraPosition() throws RemoteException;

   com.google.android.gms.maps.model.internal.j getFocusedBuilding() throws RemoteException;

   void getMapAsync(m var1) throws RemoteException;

   int getMapType() throws RemoteException;

   float getMaxZoomLevel() throws RemoteException;

   float getMinZoomLevel() throws RemoteException;

   Location getMyLocation() throws RemoteException;

   IProjectionDelegate getProjection() throws RemoteException;

   IUiSettingsDelegate getUiSettings() throws RemoteException;

   boolean isBuildingsEnabled() throws RemoteException;

   boolean isIndoorEnabled() throws RemoteException;

   boolean isMyLocationEnabled() throws RemoteException;

   boolean isTrafficEnabled() throws RemoteException;

   void moveCamera(com.google.android.gms.dynamic.d var1) throws RemoteException;

   void moveCamera2(com.google.android.gms.maps.model.internal.c var1) throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   void setBuildingsEnabled(boolean var1) throws RemoteException;

   void setContentDescription(String var1) throws RemoteException;

   boolean setIndoorEnabled(boolean var1) throws RemoteException;

   void setInfoWindowAdapter(d var1) throws RemoteException;

   void setInfoWindowRenderer(e var1) throws RemoteException;

   void setLocationSource(ILocationSourceDelegate var1) throws RemoteException;

   void setMapType(int var1) throws RemoteException;

   void setMyLocationEnabled(boolean var1) throws RemoteException;

   void setOnCameraChangeListener(f var1) throws RemoteException;

   void setOnIndoorStateChangeListener(g var1) throws RemoteException;

   void setOnInfoWindowClickListener(h var1) throws RemoteException;

   void setOnMapClickListener(j var1) throws RemoteException;

   void setOnMapLoadedCallback(k var1) throws RemoteException;

   void setOnMapLongClickListener(l var1) throws RemoteException;

   void setOnMarkerClickListener(n var1) throws RemoteException;

   void setOnMarkerDragListener(o var1) throws RemoteException;

   void setOnMyLocationButtonClickListener(p var1) throws RemoteException;

   void setOnMyLocationChangeListener(q var1) throws RemoteException;

   void setPadding(int var1, int var2, int var3, int var4) throws RemoteException;

   void setTrafficEnabled(boolean var1) throws RemoteException;

   void snapshot(v var1, com.google.android.gms.dynamic.d var2) throws RemoteException;

   void stopAnimation() throws RemoteException;

   boolean useViewLifecycleWhenInFragment() throws RemoteException;

   public abstract static class a extends Binder implements IGoogleMapDelegate {
      public static IGoogleMapDelegate aT(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return (IGoogleMapDelegate)(var1 != null && var1 instanceof IGoogleMapDelegate?(IGoogleMapDelegate)var1:new IGoogleMapDelegate.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         byte var6 = 0;
         byte var7 = 0;
         byte var8 = 0;
         boolean var12 = false;
         byte var9 = 0;
         boolean var13 = false;
         byte var10 = 0;
         boolean var11 = false;
         Object var17 = null;
         Object var18 = null;
         Object var19 = null;
         Object var20 = null;
         Object var22 = null;
         Object var23 = null;
         Object var21 = null;
         Object var24 = null;
         Object var25 = null;
         Object var26 = null;
         Object var27 = null;
         Object var28 = null;
         IPolylineDelegate var15 = null;
         Object var16 = null;
         GroundOverlayOptions var14 = null;
         float var5;
         byte var29;
         IBinder var31;
         Bundle var33;
         com.google.android.gms.maps.model.internal.i var37;
         com.google.android.gms.maps.model.internal.l var40;
         com.google.android.gms.maps.model.internal.c var41;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CameraPosition var51 = this.getCameraPosition();
            var3.writeNoException();
            if(var51 != null) {
               var3.writeInt(1);
               var51.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var5 = this.getMaxZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var5 = this.getMinZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.moveCamera(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCamera(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithCallback(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()), b.a.aR(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()), var2.readInt(), b.a.aR(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.stopAnimation();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolylineOptions var47;
            if(var2.readInt() != 0) {
               var47 = PolylineOptions.CREATOR.dh(var2);
            } else {
               var47 = null;
            }

            var15 = this.addPolyline(var47);
            var3.writeNoException();
            var31 = var14;
            if(var15 != null) {
               var31 = var15.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolygonOptions var43;
            if(var2.readInt() != 0) {
               var43 = PolygonOptions.CREATOR.dg(var2);
            } else {
               var43 = null;
            }

            com.google.android.gms.maps.model.internal.m var50 = this.addPolygon(var43);
            var3.writeNoException();
            var31 = (IBinder)var17;
            if(var50 != null) {
               var31 = var50.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            MarkerOptions var42;
            if(var2.readInt() != 0) {
               var42 = MarkerOptions.CREATOR.df(var2);
            } else {
               var42 = null;
            }

            var40 = this.addMarker(var42);
            var3.writeNoException();
            var31 = (IBinder)var18;
            if(var40 != null) {
               var31 = var40.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            GroundOverlayOptions var38;
            if(var2.readInt() != 0) {
               var38 = GroundOverlayOptions.CREATOR.dc(var2);
            } else {
               var38 = null;
            }

            var37 = this.addGroundOverlay(var38);
            var3.writeNoException();
            var31 = (IBinder)var19;
            if(var37 != null) {
               var31 = var37.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            TileOverlayOptions var36;
            if(var2.readInt() != 0) {
               var36 = TileOverlayOptions.CREATOR.dn(var2);
            } else {
               var36 = null;
            }

            com.google.android.gms.maps.model.internal.n var49 = this.addTileOverlay(var36);
            var3.writeNoException();
            var31 = (IBinder)var20;
            if(var49 != null) {
               var31 = var49.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.clear();
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var1 = this.getMapType();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setMapType(var2.readInt());
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var11 = this.isTrafficEnabled();
            var3.writeNoException();
            if(var11) {
               var29 = 1;
            } else {
               var29 = 0;
            }

            var3.writeInt(var29);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if(var2.readInt() != 0) {
               var11 = true;
            }

            this.setTrafficEnabled(var11);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var11 = this.isIndoorEnabled();
            var3.writeNoException();
            var29 = var6;
            if(var11) {
               var29 = 1;
            }

            var3.writeInt(var29);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if(var2.readInt() != 0) {
               var11 = true;
            } else {
               var11 = false;
            }

            var11 = this.setIndoorEnabled(var11);
            var3.writeNoException();
            var29 = var7;
            if(var11) {
               var29 = 1;
            }

            var3.writeInt(var29);
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var11 = this.isMyLocationEnabled();
            var3.writeNoException();
            var29 = var8;
            if(var11) {
               var29 = 1;
            }

            var3.writeInt(var29);
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var11 = var12;
            if(var2.readInt() != 0) {
               var11 = true;
            }

            this.setMyLocationEnabled(var11);
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Location var35 = this.getMyLocation();
            var3.writeNoException();
            if(var35 != null) {
               var3.writeInt(1);
               var35.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setLocationSource(ILocationSourceDelegate.a.aW(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IUiSettingsDelegate var48 = this.getUiSettings();
            var3.writeNoException();
            var31 = (IBinder)var22;
            if(var48 != null) {
               var31 = var48.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IProjectionDelegate var46 = this.getProjection();
            var3.writeNoException();
            var31 = (IBinder)var23;
            if(var46 != null) {
               var31 = var46.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnCameraChangeListener(f.a.aZ(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapClickListener(j.a.bd(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLongClickListener(l.a.bf(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerClickListener(n.a.bh(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerDragListener(o.a.bi(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnInfoWindowClickListener(h.a.bb(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setInfoWindowAdapter(d.a.aU(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CircleOptions var34;
            if(var2.readInt() != 0) {
               var34 = CircleOptions.CREATOR.db(var2);
            } else {
               var34 = null;
            }

            com.google.android.gms.maps.model.internal.h var45 = this.addCircle(var34);
            var3.writeNoException();
            var31 = (IBinder)var21;
            if(var45 != null) {
               var31 = var45.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationChangeListener(q.a.bk(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationButtonClickListener(p.a.bj(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 38:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.snapshot(v.a.bq(var2.readStrongBinder()), com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 39:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setPadding(var2.readInt(), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var11 = this.isBuildingsEnabled();
            var3.writeNoException();
            var29 = var9;
            if(var11) {
               var29 = 1;
            }

            var3.writeInt(var29);
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var11 = var13;
            if(var2.readInt() != 0) {
               var11 = true;
            }

            this.setBuildingsEnabled(var11);
            var3.writeNoException();
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLoadedCallback(k.a.be(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            com.google.android.gms.maps.model.internal.j var44 = this.getFocusedBuilding();
            var3.writeNoException();
            var31 = (IBinder)var24;
            if(var44 != null) {
               var31 = var44.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnIndoorStateChangeListener(g.a.ba(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 53:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.getMapAsync(m.a.bg(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 54:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if(var2.readInt() != 0) {
               var33 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var33 = null;
            }

            this.onCreate(var33);
            var3.writeNoException();
            return true;
         case 55:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onResume();
            var3.writeNoException();
            return true;
         case 56:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onPause();
            var3.writeNoException();
            return true;
         case 57:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 58:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onLowMemory();
            var3.writeNoException();
            return true;
         case 59:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var11 = this.useViewLifecycleWhenInFragment();
            var3.writeNoException();
            var29 = var10;
            if(var11) {
               var29 = 1;
            }

            var3.writeInt(var29);
            return true;
         case 60:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if(var2.readInt() != 0) {
               var33 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var33 = null;
            }

            this.onSaveInstanceState(var33);
            var3.writeNoException();
            if(var33 != null) {
               var3.writeInt(1);
               var33.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 61:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setContentDescription(var2.readString());
            var3.writeNoException();
            return true;
         case 64:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var41 = (com.google.android.gms.maps.model.internal.c)var25;
            if(var2.readInt() != 0) {
               var41 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(var2);
            }

            this.moveCamera2(var41);
            var3.writeNoException();
            return true;
         case 65:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var41 = (com.google.android.gms.maps.model.internal.c)var26;
            if(var2.readInt() != 0) {
               var41 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(var2);
            }

            this.animateCamera2(var41);
            var3.writeNoException();
            return true;
         case 66:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var41 = (com.google.android.gms.maps.model.internal.c)var27;
            if(var2.readInt() != 0) {
               var41 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(var2);
            }

            this.animateCameraWithCallback2(var41, b.a.aR(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 67:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var41 = (com.google.android.gms.maps.model.internal.c)var28;
            if(var2.readInt() != 0) {
               var41 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(var2);
            }

            this.animateCameraWithDurationAndCallback2(var41, var2.readInt(), b.a.aR(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 68:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            MarkerOptions var39;
            if(var2.readInt() != 0) {
               var39 = MarkerOptions.CREATOR.df(var2);
            } else {
               var39 = null;
            }

            com.google.android.gms.maps.model.internal.p var32;
            if(var2.readInt() != 0) {
               var32 = com.google.android.gms.maps.model.internal.p.CREATOR.ds(var2);
            } else {
               var32 = null;
            }

            var40 = this.addMarker2(var39, var32);
            var3.writeNoException();
            var31 = var15;
            if(var40 != null) {
               var31 = var40.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 69:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setInfoWindowRenderer(e.a.aV(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 70:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if(var2.readInt() != 0) {
               var14 = GroundOverlayOptions.CREATOR.dc(var2);
            } else {
               var14 = null;
            }

            com.google.android.gms.maps.model.internal.e var30;
            if(var2.readInt() != 0) {
               var30 = com.google.android.gms.maps.model.internal.e.CREATOR.dr(var2);
            } else {
               var30 = null;
            }

            var37 = this.addGroundOverlay2(var14, var30);
            var3.writeNoException();
            var31 = (IBinder)var16;
            if(var37 != null) {
               var31 = var37.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements IGoogleMapDelegate {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public com.google.android.gms.maps.model.internal.h addCircle(CircleOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.i addGroundOverlay(GroundOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.i addGroundOverlay2(GroundOverlayOptions param1, com.google.android.gms.maps.model.internal.e param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.l addMarker(MarkerOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.l addMarker2(MarkerOptions param1, com.google.android.gms.maps.model.internal.p param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.m addPolygon(PolygonOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IPolylineDelegate addPolyline(PolylineOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.n addTileOverlay(TileOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCamera(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCamera2(com.google.android.gms.maps.model.internal.c param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithCallback(com.google.android.gms.dynamic.d param1, b param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithCallback2(com.google.android.gms.maps.model.internal.c param1, b param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d param1, int param2, b param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithDurationAndCallback2(com.google.android.gms.maps.model.internal.c param1, int param2, b param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void clear() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(14, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public CameraPosition getCameraPosition() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         CameraPosition var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
               this.le.transact(1, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = CameraPosition.CREATOR.da(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public com.google.android.gms.maps.model.internal.j getFocusedBuilding() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.maps.model.internal.j var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(44, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.maps.model.internal.j.by(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public void getMapAsync(m param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getMapType() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(15, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public float getMaxZoomLevel() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(2, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public float getMinZoomLevel() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(3, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public Location getMyLocation() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Location var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
               this.le.transact(23, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Location)Location.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public IProjectionDelegate getProjection() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IProjectionDelegate var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(26, var1, var2, 0);
            var2.readException();
            var3 = IProjectionDelegate.a.bp(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public IUiSettingsDelegate getUiSettings() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IUiSettingsDelegate var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(25, var1, var2, 0);
            var2.readException();
            var3 = IUiSettingsDelegate.a.bu(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public boolean isBuildingsEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(40, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isIndoorEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(19, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isMyLocationEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(21, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isTrafficEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(17, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public void moveCamera(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void moveCamera2(com.google.android.gms.maps.model.internal.c param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(57, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onLowMemory() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(58, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onPause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(56, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onResume() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(55, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onSaveInstanceState(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setBuildingsEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setContentDescription(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var2.writeString(var1);
            this.le.transact(61, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public boolean setIndoorEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowAdapter(d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowRenderer(e param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setLocationSource(ILocationSourceDelegate param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setMapType(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var2.writeInt(var1);
            this.le.transact(16, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setMyLocationEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnCameraChangeListener(f param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnIndoorStateChangeListener(g param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnInfoWindowClickListener(h param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapClickListener(j param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLoadedCallback(k param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLongClickListener(l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerClickListener(n param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerDragListener(o param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationButtonClickListener(p param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationChangeListener(q param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPadding(int var1, int var2, int var3, int var4) throws RemoteException {
         Parcel var5 = Parcel.obtain();
         Parcel var6 = Parcel.obtain();

         try {
            var5.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var5.writeInt(var1);
            var5.writeInt(var2);
            var5.writeInt(var3);
            var5.writeInt(var4);
            this.le.transact(39, var5, var6, 0);
            var6.readException();
         } finally {
            var6.recycle();
            var5.recycle();
         }

      }

      public void setTrafficEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void snapshot(v param1, com.google.android.gms.dynamic.d param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void stopAnimation() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(8, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean useViewLifecycleWhenInFragment() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.le.transact(59, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }
   }
}
