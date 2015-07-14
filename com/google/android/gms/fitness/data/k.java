package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;

public interface k extends IInterface {
   void c(DataPoint var1) throws RemoteException;

   public abstract static class a extends Binder implements k {
      public a() {
         this.attachInterface(this, "com.google.android.gms.fitness.data.IDataSourceListener");
      }

      public static k aq(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            return (k)(var1 != null && var1 instanceof k?(k)var1:new k.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            DataPoint var5;
            if(var2.readInt() != 0) {
               var5 = (DataPoint)DataPoint.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.c(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements k {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void c(DataPoint param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
