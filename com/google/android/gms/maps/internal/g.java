package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface g extends IInterface {
   void a(com.google.android.gms.maps.model.internal.j var1) throws RemoteException;

   void onIndoorBuildingFocused() throws RemoteException;

   public abstract static class a extends Binder implements g {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
      }

      public static g ba(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (g)(var1 != null && var1 instanceof g?(g)var1:new g.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.onIndoorBuildingFocused();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.a(com.google.android.gms.maps.model.internal.j.by(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
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

      public void a(com.google.android.gms.maps.model.internal.j param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void onIndoorBuildingFocused() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
