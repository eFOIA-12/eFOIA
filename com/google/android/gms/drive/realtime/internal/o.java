package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface o extends IInterface {
   void n(Status var1) throws RemoteException;

   void onSuccess() throws RemoteException;

   public abstract static class a extends Binder implements o {
      public static o an(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            return (o)(var1 != null && var1 instanceof o?(o)var1:new o.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            this.onSuccess();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
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
            var3.writeString("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements o {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void n(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onSuccess() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
