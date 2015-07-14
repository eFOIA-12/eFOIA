package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.m;

public interface IMapFragmentDelegate extends IInterface {
   IGoogleMapDelegate getMap() throws RemoteException;

   void getMapAsync(m var1) throws RemoteException;

   boolean isReady() throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   com.google.android.gms.dynamic.d onCreateView(com.google.android.gms.dynamic.d var1, com.google.android.gms.dynamic.d var2, Bundle var3) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onDestroyView() throws RemoteException;

   void onInflate(com.google.android.gms.dynamic.d var1, GoogleMapOptions var2, Bundle var3) throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   public abstract static class a extends Binder implements IMapFragmentDelegate {
      public static IMapFragmentDelegate aX(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return (IMapFragmentDelegate)(var1 != null && var1 instanceof IMapFragmentDelegate?(IMapFragmentDelegate)var1:new IMapFragmentDelegate.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         GoogleMapOptions var6 = null;
         com.google.android.gms.dynamic.d var7;
         Bundle var10;
         IBinder var11;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            IGoogleMapDelegate var12 = this.getMap();
            var3.writeNoException();
            if(var12 != null) {
               var11 = var12.asBinder();
            } else {
               var11 = null;
            }

            var3.writeStrongBinder(var11);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var6 = GoogleMapOptions.CREATOR.cX(var2);
            } else {
               var6 = null;
            }

            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.onInflate(var7, var6, var10);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.onCreate(var10);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            com.google.android.gms.dynamic.d var8 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            var7 = this.onCreateView(var7, var8, var10);
            var3.writeNoException();
            var11 = var6;
            if(var7 != null) {
               var11 = var7.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onResume();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onPause();
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onDestroyView();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onLowMemory();
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.onSaveInstanceState(var10);
            var3.writeNoException();
            if(var10 != null) {
               var3.writeInt(1);
               var10.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            boolean var5 = this.isReady();
            var3.writeNoException();
            byte var9;
            if(var5) {
               var9 = 1;
            } else {
               var9 = 0;
            }

            var3.writeInt(var9);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.getMapAsync(m.a.bg(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements IMapFragmentDelegate {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public IGoogleMapDelegate getMap() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IGoogleMapDelegate var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
            var3 = IGoogleMapDelegate.a.aT(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public void getMapAsync(m param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public boolean isReady() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
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

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d onCreateView(com.google.android.gms.dynamic.d param1, com.google.android.gms.dynamic.d param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.le.transact(8, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onDestroyView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.le.transact(7, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onInflate(com.google.android.gms.dynamic.d param1, GoogleMapOptions param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onLowMemory() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.le.transact(9, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.le.transact(6, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onSaveInstanceState(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
