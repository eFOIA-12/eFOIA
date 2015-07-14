package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface j extends IInterface {
   boolean b(j var1) throws RemoteException;

   int getActiveLevelIndex() throws RemoteException;

   int getDefaultLevelIndex() throws RemoteException;

   List getLevels() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isUnderground() throws RemoteException;

   public abstract static class a extends Binder implements j {
      public static j by(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            return (j)(var1 != null && var1 instanceof j?(j)var1:new j.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         byte var6 = 0;
         byte var5 = 0;
         boolean var7;
         byte var8;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            var1 = this.getActiveLevelIndex();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            var1 = this.getDefaultLevelIndex();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            List var9 = this.getLevels();
            var3.writeNoException();
            var3.writeBinderList(var9);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            var7 = this.isUnderground();
            var3.writeNoException();
            var8 = var5;
            if(var7) {
               var8 = 1;
            }

            var3.writeInt(var8);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            var7 = this.b(by(var2.readStrongBinder()));
            var3.writeNoException();
            var8 = var6;
            if(var7) {
               var8 = 1;
            }

            var3.writeInt(var8);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements j {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public boolean b(j param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getActiveLevelIndex() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.le.transact(1, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public int getDefaultLevelIndex() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.le.transact(2, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public List getLevels() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.le.transact(3, var1, var2, 0);
            var2.readException();
            var3 = var2.createBinderArrayList();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public int hashCodeRemote() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.le.transact(6, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public boolean isUnderground() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.le.transact(4, var3, var4, 0);
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
