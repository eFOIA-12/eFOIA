package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUiSettingsDelegate extends IInterface {
   boolean isCompassEnabled() throws RemoteException;

   boolean isIndoorLevelPickerEnabled() throws RemoteException;

   boolean isMapToolbarEnabled() throws RemoteException;

   boolean isMyLocationButtonEnabled() throws RemoteException;

   boolean isRotateGesturesEnabled() throws RemoteException;

   boolean isScrollGesturesEnabled() throws RemoteException;

   boolean isTiltGesturesEnabled() throws RemoteException;

   boolean isZoomControlsEnabled() throws RemoteException;

   boolean isZoomGesturesEnabled() throws RemoteException;

   void setAllGesturesEnabled(boolean var1) throws RemoteException;

   void setCompassEnabled(boolean var1) throws RemoteException;

   void setIndoorLevelPickerEnabled(boolean var1) throws RemoteException;

   void setMapToolbarEnabled(boolean var1) throws RemoteException;

   void setMyLocationButtonEnabled(boolean var1) throws RemoteException;

   void setRotateGesturesEnabled(boolean var1) throws RemoteException;

   void setScrollGesturesEnabled(boolean var1) throws RemoteException;

   void setTiltGesturesEnabled(boolean var1) throws RemoteException;

   void setZoomControlsEnabled(boolean var1) throws RemoteException;

   void setZoomGesturesEnabled(boolean var1) throws RemoteException;

   public abstract static class a extends Binder implements IUiSettingsDelegate {
      public static IUiSettingsDelegate bu(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            return (IUiSettingsDelegate)(var1 != null && var1 instanceof IUiSettingsDelegate?(IUiSettingsDelegate)var1:new IUiSettingsDelegate.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var15 = false;
         boolean var16 = false;
         boolean var17 = false;
         boolean var18 = false;
         boolean var19 = false;
         boolean var20 = false;
         boolean var21 = false;
         byte var5 = 0;
         byte var6 = 0;
         byte var7 = 0;
         byte var8 = 0;
         byte var9 = 0;
         byte var10 = 0;
         byte var11 = 0;
         boolean var22 = false;
         byte var12 = 0;
         boolean var23 = false;
         byte var13 = 0;
         boolean var14 = false;
         byte var24;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setZoomControlsEnabled(var14);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var15;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setCompassEnabled(var14);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var16;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setMyLocationButtonEnabled(var14);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var17;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setScrollGesturesEnabled(var14);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var18;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setZoomGesturesEnabled(var14);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var19;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setTiltGesturesEnabled(var14);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var20;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setRotateGesturesEnabled(var14);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var21;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setAllGesturesEnabled(var14);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isZoomControlsEnabled();
            var3.writeNoException();
            var24 = var5;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isCompassEnabled();
            var3.writeNoException();
            var24 = var6;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isMyLocationButtonEnabled();
            var3.writeNoException();
            var24 = var7;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isScrollGesturesEnabled();
            var3.writeNoException();
            var24 = var8;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isZoomGesturesEnabled();
            var3.writeNoException();
            var24 = var9;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isTiltGesturesEnabled();
            var3.writeNoException();
            var24 = var10;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isRotateGesturesEnabled();
            var3.writeNoException();
            var24 = var11;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var22;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setIndoorLevelPickerEnabled(var14);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isIndoorLevelPickerEnabled();
            var3.writeNoException();
            var24 = var12;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = var23;
            if(var2.readInt() != 0) {
               var14 = true;
            }

            this.setMapToolbarEnabled(var14);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            var14 = this.isMapToolbarEnabled();
            var3.writeNoException();
            var24 = var13;
            if(var14) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements IUiSettingsDelegate {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public boolean isCompassEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.le.transact(10, var3, var4, 0);
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

      public boolean isIndoorLevelPickerEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
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

      public boolean isMapToolbarEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
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

      public boolean isMyLocationButtonEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.le.transact(11, var3, var4, 0);
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

      public boolean isRotateGesturesEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.le.transact(15, var3, var4, 0);
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

      public boolean isScrollGesturesEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.le.transact(12, var3, var4, 0);
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

      public boolean isTiltGesturesEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.le.transact(14, var3, var4, 0);
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

      public boolean isZoomControlsEnabled() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.le.transact(9, var3, var4, 0);
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
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.le.transact(13, var3, var4, 0);
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

      public void setAllGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setCompassEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setIndoorLevelPickerEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setMapToolbarEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setMyLocationButtonEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setRotateGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setScrollGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setTiltGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZoomControlsEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZoomGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
