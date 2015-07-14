package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface bq extends IInterface {
   void a(com.google.android.gms.dynamic.d var1) throws RemoteException;

   void av() throws RemoteException;

   void aw() throws RemoteException;

   String bA() throws RemoteException;

   String bz() throws RemoteException;

   public abstract static class a extends Binder implements bq {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
      }

      public static bq i(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            return (bq)(var1 != null && var1 instanceof bq?(bq)var1:new bq.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         String var5;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            var5 = this.bz();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            var5 = this.bA();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.a(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.av();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.aw();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements bq {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void av() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.le.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void aw() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public String bA() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public String bz() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }
   }
}
