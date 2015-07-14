package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.pi;

public interface b extends IInterface {
   void a(int var1, Bundle var2, Bundle var3) throws RemoteException;

   void a(int var1, Bundle var2, ParcelFileDescriptor var3) throws RemoteException;

   void a(int var1, Bundle var2, ky var3) throws RemoteException;

   void a(int var1, pi var2) throws RemoteException;

   void a(DataHolder var1, String var2) throws RemoteException;

   void a(DataHolder var1, String var2, String var3) throws RemoteException;

   void aA(Status var1) throws RemoteException;

   void ch(String var1) throws RemoteException;

   void ci(String var1) throws RemoteException;

   void h(int var1, Bundle var2) throws RemoteException;

   public abstract static class a extends Binder implements b {
      public a() {
         this.attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
      }

      public static b bK(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            return (b)(var1 != null && var1 instanceof b?(b)var1:new b.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         ky var6 = null;
         Object var7 = null;
         Object var8 = null;
         Object var9 = null;
         DataHolder var5 = null;
         Bundle var10;
         Bundle var14;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var14 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.a(var1, var14, var10);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var14 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            ParcelFileDescriptor var11;
            if(var2.readInt() != 0) {
               var11 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.a(var1, var14, var11);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            this.ch(var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.a(var5, var2.readString());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var14 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            if(var2.readInt() != 0) {
               var6 = ky.CREATOR.Q(var2);
            }

            this.a(var1, var14, var6);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            var5 = (DataHolder)var7;
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.a(var5, var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.h(var1, var10);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            this.ci(var2.readString());
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            var1 = var2.readInt();
            pi var13 = (pi)var8;
            if(var2.readInt() != 0) {
               var13 = pi.CREATOR.dz(var2);
            }

            this.a(var1, var13);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            Status var12 = (Status)var9;
            if(var2.readInt() != 0) {
               var12 = Status.CREATOR.createFromParcel(var2);
            }

            this.aA(var12);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements b {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(int param1, Bundle param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(int param1, Bundle param2, ParcelFileDescriptor param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(int param1, Bundle param2, ky param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(int param1, pi param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void aA(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void ch(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            var2.writeString(var1);
            this.le.transact(3, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void ci(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            var2.writeString(var1);
            this.le.transact(8, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void h(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
