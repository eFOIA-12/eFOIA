package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface k extends IInterface {
   boolean a(k var1) throws RemoteException;

   void activate() throws RemoteException;

   String getName() throws RemoteException;

   String getShortName() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   public abstract static class a extends Binder implements k {
      public static k bz(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            return (k)(var1 != null && var1 instanceof k?(k)var1:new k.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         String var7;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            var7 = this.getName();
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            var7 = this.getShortName();
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.activate();
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            boolean var5 = this.a(bz(var2.readStrongBinder()));
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements k {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public boolean a(k param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void activate() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.le.transact(3, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public String getName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public String getShortName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.le.transact(5, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }
   }
}
