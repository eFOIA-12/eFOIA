package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

public interface ly extends IInterface {
   void a(DataTypeResult var1) throws RemoteException;

   public abstract static class a extends Binder implements ly {
      public a() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.IDataTypeCallback");
      }

      public static ly au(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
            return (ly)(var1 != null && var1 instanceof ly?(ly)var1:new ly.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
            DataTypeResult var5;
            if(var2.readInt() != 0) {
               var5 = (DataTypeResult)DataTypeResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IDataTypeCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ly {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(DataTypeResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
