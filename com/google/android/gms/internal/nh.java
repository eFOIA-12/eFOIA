package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface nh extends IInterface {
   void a(int var1, PendingIntent var2) throws RemoteException;

   void a(int var1, String[] var2) throws RemoteException;

   void b(int var1, String[] var2) throws RemoteException;

   public abstract static class a extends Binder implements nh {
      public a() {
         this.attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
      }

      public static nh aN(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return (nh)(var1 != null && var1 instanceof nh?(nh)var1:new nh.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.a(var2.readInt(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.b(var2.readInt(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var1 = var2.readInt();
            PendingIntent var5;
            if(var2.readInt() != 0) {
               var5 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var1, var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements nh {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(int param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.le.transact(1, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.le.transact(2, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }
   }
}
