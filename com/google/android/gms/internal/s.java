package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface s extends IInterface {
   void b(String var1, boolean var2) throws RemoteException;

   String c(String var1) throws RemoteException;

   boolean c(boolean var1) throws RemoteException;

   String getId() throws RemoteException;

   public abstract static class a extends Binder implements s {
      public static s b(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (s)(var1 != null && var1 instanceof s?(s)var1:new s.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var6 = false;
         byte var5 = 0;
         String var9;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            var9 = this.getId();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if(var2.readInt() != 0) {
               var6 = true;
            } else {
               var6 = false;
            }

            var6 = this.c(var6);
            var3.writeNoException();
            byte var8 = var5;
            if(var6) {
               var8 = 1;
            }

            var3.writeInt(var8);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            var9 = this.c(var2.readString());
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String var7 = var2.readString();
            if(var2.readInt() != 0) {
               var6 = true;
            }

            this.b(var7, var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements s {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public String c(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            var2.writeString(var1);
            this.le.transact(3, var2, var3, 0);
            var3.readException();
            var1 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public boolean c(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public String getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
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
