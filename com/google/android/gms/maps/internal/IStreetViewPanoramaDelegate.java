package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.internal.s;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface IStreetViewPanoramaDelegate extends IInterface {
   void animateTo(StreetViewPanoramaCamera var1, long var2) throws RemoteException;

   void enablePanning(boolean var1) throws RemoteException;

   void enableStreetNames(boolean var1) throws RemoteException;

   void enableUserNavigation(boolean var1) throws RemoteException;

   void enableZoom(boolean var1) throws RemoteException;

   StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

   StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

   boolean isPanningGesturesEnabled() throws RemoteException;

   boolean isStreetNamesEnabled() throws RemoteException;

   boolean isUserNavigationEnabled() throws RemoteException;

   boolean isZoomGesturesEnabled() throws RemoteException;

   com.google.android.gms.dynamic.d orientationToPoint(StreetViewPanoramaOrientation var1) throws RemoteException;

   StreetViewPanoramaOrientation pointToOrientation(com.google.android.gms.dynamic.d var1) throws RemoteException;

   void setOnStreetViewPanoramaCameraChangeListener(r var1) throws RemoteException;

   void setOnStreetViewPanoramaChangeListener(s var1) throws RemoteException;

   void setOnStreetViewPanoramaClickListener(t var1) throws RemoteException;

   void setPosition(LatLng var1) throws RemoteException;

   void setPositionWithID(String var1) throws RemoteException;

   void setPositionWithRadius(LatLng var1, int var2) throws RemoteException;

   public abstract static class a extends Binder implements IStreetViewPanoramaDelegate {
      public static IStreetViewPanoramaDelegate br(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return (IStreetViewPanoramaDelegate)(var1 != null && var1 instanceof IStreetViewPanoramaDelegate?(IStreetViewPanoramaDelegate)var1:new IStreetViewPanoramaDelegate.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var15 = null;
         LatLng var13 = null;
         com.google.android.gms.dynamic.d var14 = null;
         boolean var10 = false;
         boolean var11 = false;
         boolean var12 = false;
         byte var5 = 0;
         byte var6 = 0;
         byte var7 = 0;
         byte var8 = 0;
         boolean var9 = false;
         byte var16;
         StreetViewPanoramaOrientation var17;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.enableZoom(var9);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var9 = var10;
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.enablePanning(var9);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var9 = var11;
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.enableUserNavigation(var9);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var9 = var12;
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.enableStreetNames(var9);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var9 = this.isZoomGesturesEnabled();
            var3.writeNoException();
            var16 = var5;
            if(var9) {
               var16 = 1;
            }

            var3.writeInt(var16);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var9 = this.isPanningGesturesEnabled();
            var3.writeNoException();
            var16 = var6;
            if(var9) {
               var16 = 1;
            }

            var3.writeInt(var16);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var9 = this.isUserNavigationEnabled();
            var3.writeNoException();
            var16 = var7;
            if(var9) {
               var16 = 1;
            }

            var3.writeInt(var16);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var9 = this.isStreetNamesEnabled();
            var3.writeNoException();
            var16 = var8;
            if(var9) {
               var16 = 1;
            }

            var3.writeInt(var16);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaCamera var21;
            if(var2.readInt() != 0) {
               var21 = StreetViewPanoramaCamera.CREATOR.di(var2);
            } else {
               var21 = null;
            }

            this.animateTo(var21, var2.readLong());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaCamera var20 = this.getPanoramaCamera();
            var3.writeNoException();
            if(var20 != null) {
               var3.writeInt(1);
               var20.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setPositionWithID(var2.readString());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var13 = var14;
            if(var2.readInt() != 0) {
               var13 = LatLng.CREATOR.de(var2);
            }

            this.setPosition(var13);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var13 = (LatLng)var15;
            if(var2.readInt() != 0) {
               var13 = LatLng.CREATOR.de(var2);
            }

            this.setPositionWithRadius(var13, var2.readInt());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaLocation var19 = this.getStreetViewPanoramaLocation();
            var3.writeNoException();
            if(var19 != null) {
               var3.writeInt(1);
               var19.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setOnStreetViewPanoramaChangeListener(s.a.bm(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setOnStreetViewPanoramaCameraChangeListener(r.a.bl(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setOnStreetViewPanoramaClickListener(t.a.bn(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var17 = this.pointToOrientation(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            if(var17 != null) {
               var3.writeInt(1);
               var17.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            if(var2.readInt() != 0) {
               var17 = StreetViewPanoramaOrientation.CREATOR.dl(var2);
            } else {
               var17 = null;
            }

            var14 = this.orientationToPoint(var17);
            var3.writeNoException();
            IBinder var18 = var13;
            if(var14 != null) {
               var18 = var14.asBinder();
            }

            var3.writeStrongBinder(var18);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements IStreetViewPanoramaDelegate {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void animateTo(StreetViewPanoramaCamera param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void enablePanning(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void enableStreetNames(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void enableUserNavigation(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void enableZoom(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         StreetViewPanoramaCamera var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
               this.le.transact(10, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = StreetViewPanoramaCamera.CREATOR.di(var3);
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

      public StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         StreetViewPanoramaLocation var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
               this.le.transact(14, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = StreetViewPanoramaLocation.CREATOR.dk(var3);
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

      public boolean isPanningGesturesEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.le.transact(6, var3, var4, 0);
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

      public boolean isStreetNamesEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.le.transact(8, var3, var4, 0);
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

      public boolean isUserNavigationEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.le.transact(7, var3, var4, 0);
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

      public boolean isZoomGesturesEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.le.transact(5, var3, var4, 0);
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

      public com.google.android.gms.dynamic.d orientationToPoint(StreetViewPanoramaOrientation param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public StreetViewPanoramaOrientation pointToOrientation(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnStreetViewPanoramaCameraChangeListener(r param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnStreetViewPanoramaChangeListener(s param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnStreetViewPanoramaClickListener(t param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPosition(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPositionWithID(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var2.writeString(var1);
            this.le.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setPositionWithRadius(LatLng param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
