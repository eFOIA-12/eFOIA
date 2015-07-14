package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ICameraUpdateFactoryDelegate extends IInterface {
   com.google.android.gms.dynamic.d newCameraPosition(CameraPosition var1) throws RemoteException;

   com.google.android.gms.dynamic.d newLatLng(LatLng var1) throws RemoteException;

   com.google.android.gms.dynamic.d newLatLngBounds(LatLngBounds var1, int var2) throws RemoteException;

   com.google.android.gms.dynamic.d newLatLngBoundsWithSize(LatLngBounds var1, int var2, int var3, int var4) throws RemoteException;

   com.google.android.gms.dynamic.d newLatLngZoom(LatLng var1, float var2) throws RemoteException;

   com.google.android.gms.dynamic.d scrollBy(float var1, float var2) throws RemoteException;

   com.google.android.gms.dynamic.d zoomBy(float var1) throws RemoteException;

   com.google.android.gms.dynamic.d zoomByWithFocus(float var1, int var2, int var3) throws RemoteException;

   com.google.android.gms.dynamic.d zoomIn() throws RemoteException;

   com.google.android.gms.dynamic.d zoomOut() throws RemoteException;

   com.google.android.gms.dynamic.d zoomTo(float var1) throws RemoteException;

   public abstract static class a extends Binder implements ICameraUpdateFactoryDelegate {
      public static ICameraUpdateFactoryDelegate aQ(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            return (ICameraUpdateFactoryDelegate)(var1 != null && var1 instanceof ICameraUpdateFactoryDelegate?(ICameraUpdateFactoryDelegate)var1:new ICameraUpdateFactoryDelegate.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var11 = null;
         Object var12 = null;
         Object var13 = null;
         Object var14 = null;
         Object var15 = null;
         LatLngBounds var5 = null;
         com.google.android.gms.dynamic.d var6 = null;
         Object var7 = null;
         Object var8 = null;
         Object var9 = null;
         Object var10 = null;
         IBinder var16;
         com.google.android.gms.dynamic.d var18;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var18 = this.zoomIn();
            var3.writeNoException();
            var16 = (IBinder)var10;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var18 = this.zoomOut();
            var3.writeNoException();
            var16 = (IBinder)var11;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var18 = this.scrollBy(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            var16 = (IBinder)var12;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var18 = this.zoomTo(var2.readFloat());
            var3.writeNoException();
            var16 = (IBinder)var13;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var18 = this.zoomBy(var2.readFloat());
            var3.writeNoException();
            var16 = (IBinder)var14;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var18 = this.zoomByWithFocus(var2.readFloat(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            var16 = (IBinder)var15;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            CameraPosition var19;
            if(var2.readInt() != 0) {
               var19 = CameraPosition.CREATOR.da(var2);
            } else {
               var19 = null;
            }

            var6 = this.newCameraPosition(var19);
            var3.writeNoException();
            var16 = var5;
            if(var6 != null) {
               var16 = var6.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            LatLng var17;
            if(var2.readInt() != 0) {
               var17 = LatLng.CREATOR.de(var2);
            } else {
               var17 = null;
            }

            var18 = this.newLatLng(var17);
            var3.writeNoException();
            var16 = var6;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            LatLng var20;
            if(var2.readInt() != 0) {
               var20 = LatLng.CREATOR.de(var2);
            } else {
               var20 = null;
            }

            var18 = this.newLatLngZoom(var20, var2.readFloat());
            var3.writeNoException();
            var16 = (IBinder)var7;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if(var2.readInt() != 0) {
               var5 = LatLngBounds.CREATOR.dd(var2);
            } else {
               var5 = null;
            }

            var18 = this.newLatLngBounds(var5, var2.readInt());
            var3.writeNoException();
            var16 = (IBinder)var8;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if(var2.readInt() != 0) {
               var5 = LatLngBounds.CREATOR.dd(var2);
            } else {
               var5 = null;
            }

            var18 = this.newLatLngBoundsWithSize(var5, var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            var16 = (IBinder)var9;
            if(var18 != null) {
               var16 = var18.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ICameraUpdateFactoryDelegate {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public com.google.android.gms.dynamic.d newCameraPosition(CameraPosition param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d newLatLng(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d newLatLngBounds(LatLngBounds param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d newLatLngBoundsWithSize(LatLngBounds param1, int param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d newLatLngZoom(LatLng param1, float param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d scrollBy(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         com.google.android.gms.dynamic.d var5;
         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.le.transact(3, var3, var4, 0);
            var4.readException();
            var5 = com.google.android.gms.dynamic.d.ap(var4.readStrongBinder());
         } finally {
            var4.recycle();
            var3.recycle();
         }

         return var5;
      }

      public com.google.android.gms.dynamic.d zoomBy(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.d var4;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var2.writeFloat(var1);
            this.le.transact(5, var2, var3, 0);
            var3.readException();
            var4 = com.google.android.gms.dynamic.d.ap(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var4;
      }

      public com.google.android.gms.dynamic.d zoomByWithFocus(float var1, int var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         com.google.android.gms.dynamic.d var6;
         try {
            var4.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var4.writeFloat(var1);
            var4.writeInt(var2);
            var4.writeInt(var3);
            this.le.transact(6, var4, var5, 0);
            var5.readException();
            var6 = com.google.android.gms.dynamic.d.ap(var5.readStrongBinder());
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.d zoomIn() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public com.google.android.gms.dynamic.d zoomOut() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public com.google.android.gms.dynamic.d zoomTo(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.d var4;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var2.writeFloat(var1);
            this.le.transact(4, var2, var3, 0);
            var3.readException();
            var4 = com.google.android.gms.dynamic.d.ap(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var4;
      }
   }
}
