package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface kh extends IInterface {
   void aI(int var1) throws RemoteException;

   public abstract static class a extends Binder implements kh {
      public a() {
         this.attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
      }

      public static kh U(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return (kh)(var1 != null && var1 instanceof kh?(kh)var1:new kh.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            this.aI(var2.readInt());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements kh {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void aI(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
            var2.writeInt(var1);
            this.le.transact(1, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
