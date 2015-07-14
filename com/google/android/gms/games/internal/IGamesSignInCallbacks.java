package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface IGamesSignInCallbacks extends IInterface {
   void U(DataHolder var1) throws RemoteException;

   void V(DataHolder var1) throws RemoteException;

   void b(int var1, Intent var2) throws RemoteException;

   void dU(int var1) throws RemoteException;

   void dV(int var1) throws RemoteException;

   void dW(int var1) throws RemoteException;

   void g(DataHolder var1) throws RemoteException;

   public abstract static class Stub extends Binder implements IGamesSignInCallbacks {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInCallbacks");
      }

      public static IGamesSignInCallbacks aF(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            return (IGamesSignInCallbacks)(var1 != null && var1 instanceof IGamesSignInCallbacks?(IGamesSignInCallbacks)var1:new IGamesSignInCallbacks.Proxy(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         Object var7 = null;
         Object var8 = null;
         Intent var5 = null;
         DataHolder var9;
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
            }

            this.b(var1, var5);
            var3.writeNoException();
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            var9 = (DataHolder)var6;
            if(var2.readInt() != 0) {
               var9 = DataHolder.CREATOR.B(var2);
            }

            this.U(var9);
            var3.writeNoException();
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            var9 = (DataHolder)var7;
            if(var2.readInt() != 0) {
               var9 = DataHolder.CREATOR.B(var2);
            }

            this.V(var9);
            var3.writeNoException();
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            this.dU(var2.readInt());
            var3.writeNoException();
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            var9 = (DataHolder)var8;
            if(var2.readInt() != 0) {
               var9 = DataHolder.CREATOR.B(var2);
            }

            this.g(var9);
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            this.dV(var2.readInt());
            var3.writeNoException();
            return true;
         case 14001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            this.dW(var2.readInt());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IGamesSignInCallbacks {
      private IBinder le;

      Proxy(IBinder var1) {
         this.le = var1;
      }

      public void U(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void V(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(int param1, Intent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void dU(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            var2.writeInt(var1);
            this.le.transact(5004, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void dV(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            var2.writeInt(var1);
            this.le.transact(5006, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void dW(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            var2.writeInt(var1);
            this.le.transact(14001, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void g(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
