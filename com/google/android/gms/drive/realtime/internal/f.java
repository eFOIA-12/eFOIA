package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface f extends IInterface {
   void b(DataHolder var1) throws RemoteException;

   void n(Status var1) throws RemoteException;

   public abstract static class a extends Binder implements f {
      public static f ae(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
            return (f)(var1 != null && var1 instanceof f?(f)var1:new f.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         DataHolder var5 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
            if(var2.readInt() != 0) {
               var5 = DataHolder.CREATOR.B(var2);
            }

            this.b(var5);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
            Status var7 = (Status)var6;
            if(var2.readInt() != 0) {
               var7 = Status.CREATOR.createFromParcel(var2);
            }

            this.n(var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements f {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void n(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
