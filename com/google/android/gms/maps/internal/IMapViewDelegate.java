package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.m;

public interface IMapViewDelegate extends IInterface {
   IGoogleMapDelegate getMap() throws RemoteException;

   void getMapAsync(m var1) throws RemoteException;

   com.google.android.gms.dynamic.d getView() throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   public abstract static class a extends Binder implements IMapViewDelegate {
      public static IMapViewDelegate aY(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            return (IMapViewDelegate)(var1 != null && var1 instanceof IMapViewDelegate?(IMapViewDelegate)var1:new IMapViewDelegate.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var7 = null;
         Object var8 = null;
         IGoogleMapDelegate var6 = null;
         com.google.android.gms.dynamic.d var5 = null;
         IBinder var9;
         Bundle var10;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            var6 = this.getMap();
            var3.writeNoException();
            var9 = var5;
            if(var6 != null) {
               var9 = var6.asBinder();
            }

            var3.writeStrongBinder(var9);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            var10 = (Bundle)var7;
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.onCreate(var10);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onResume();
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onPause();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onLowMemory();
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            var10 = (Bundle)var8;
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.onSaveInstanceState(var10);
            var3.writeNoException();
            if(var10 != null) {
               var3.writeInt(1);
               var10.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            var5 = this.getView();
            var3.writeNoException();
            var9 = var6;
            if(var5 != null) {
               var9 = var5.asBinder();
            }

            var3.writeStrongBinder(var9);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.getMapAsync(m.a.bg(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements IMapViewDelegate {
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
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

      public com.google.android.gms.dynamic.d getView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.le.transact(8, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.le.transact(5, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.le.transact(6, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.le.transact(4, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.le.transact(3, var1, var2, 0);
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
