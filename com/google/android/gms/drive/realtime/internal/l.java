package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface l extends IInterface {
   void ct(int var1) throws RemoteException;

   void n(Status var1) throws RemoteException;

   public abstract static class a extends Binder implements l {
      public static l ak(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
            return (l)(var1 != null && var1 instanceof l?(l)var1:new l.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
            this.ct(var2.readInt());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
            Status var5;
            if(var2.readInt() != 0) {
               var5 = Status.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.n(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.IIntCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements l {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void ct(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIntCallback");
            var2.writeInt(var1);
            this.le.transact(1, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void n(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
