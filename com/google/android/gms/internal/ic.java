package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface ic extends IInterface {
   void T(int var1) throws RemoteException;

   void a(int var1, DataHolder var2) throws RemoteException;

   void a(DataHolder var1) throws RemoteException;

   void e(int var1, int var2) throws RemoteException;

   void fK() throws RemoteException;

   public abstract static class a extends Binder implements ic {
      public a() {
         this.attachInterface(this, "com.google.android.gms.appstate.internal.IAppStateCallbacks");
      }

      public static ic I(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            return (ic)(var1 != null && var1 instanceof ic?(ic)var1:new ic.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         DataHolder var5 = null;
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.a(var1, var5);
            var3.writeNoException();
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            var5 = (DataHolder)var6;
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            this.e(var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            this.fK();
            var3.writeNoException();
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            this.T(var2.readInt());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ic {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void T(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            var2.writeInt(var1);
            this.le.transact(5005, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void a(int param1, DataHolder param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void e(int var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            var3.writeInt(var1);
            var3.writeInt(var2);
            this.le.transact(5003, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void fK() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            this.le.transact(5004, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
