package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface g extends IInterface {
   com.google.android.gms.dynamic.d b(Bitmap var1) throws RemoteException;

   com.google.android.gms.dynamic.d c(float var1) throws RemoteException;

   com.google.android.gms.dynamic.d cd(String var1) throws RemoteException;

   com.google.android.gms.dynamic.d ce(String var1) throws RemoteException;

   com.google.android.gms.dynamic.d cf(String var1) throws RemoteException;

   com.google.android.gms.dynamic.d fo(int var1) throws RemoteException;

   com.google.android.gms.dynamic.d ok() throws RemoteException;

   public abstract static class a extends Binder implements g {
      public static g bv(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (g)(var1 != null && var1 instanceof g?(g)var1:new g.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var7 = null;
         Object var8 = null;
         Object var9 = null;
         com.google.android.gms.dynamic.d var5 = null;
         Object var10 = null;
         com.google.android.gms.dynamic.d var6 = null;
         IBinder var11;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            com.google.android.gms.dynamic.d var13 = this.fo(var2.readInt());
            var3.writeNoException();
            if(var13 != null) {
               var11 = var13.asBinder();
            } else {
               var11 = null;
            }

            var3.writeStrongBinder(var11);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var5 = this.cd(var2.readString());
            var3.writeNoException();
            var11 = var6;
            if(var5 != null) {
               var11 = var5.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var5 = this.ce(var2.readString());
            var3.writeNoException();
            var11 = (IBinder)var7;
            if(var5 != null) {
               var11 = var5.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var5 = this.ok();
            var3.writeNoException();
            var11 = (IBinder)var8;
            if(var5 != null) {
               var11 = var5.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var5 = this.c(var2.readFloat());
            var3.writeNoException();
            var11 = (IBinder)var9;
            if(var5 != null) {
               var11 = var5.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            Bitmap var12;
            if(var2.readInt() != 0) {
               var12 = (Bitmap)Bitmap.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            var6 = this.b(var12);
            var3.writeNoException();
            var11 = var5;
            if(var6 != null) {
               var11 = var6.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var5 = this.cf(var2.readString());
            var3.writeNoException();
            var11 = (IBinder)var10;
            if(var5 != null) {
               var11 = var5.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements g {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public com.google.android.gms.dynamic.d b(Bitmap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d c(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.d var4;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
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

      public com.google.android.gms.dynamic.d cd(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.d var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.le.transact(2, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.d.ap(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.d ce(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.d var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.le.transact(3, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.d.ap(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.d cf(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.d var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.le.transact(7, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.d.ap(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.d fo(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.d var4;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeInt(var1);
            this.le.transact(1, var2, var3, 0);
            var3.readException();
            var4 = com.google.android.gms.dynamic.d.ap(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var4;
      }

      public com.google.android.gms.dynamic.d ok() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            this.le.transact(4, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }
   }
}
