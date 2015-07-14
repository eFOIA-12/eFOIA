package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

public interface lw extends IInterface {
   void a(DataReadResult var1) throws RemoteException;

   public abstract static class a extends Binder implements lw {
      public a() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.IDataReadCallback");
      }

      public static lw as(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
            return (lw)(var1 != null && var1 instanceof lw?(lw)var1:new lw.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
            DataReadResult var5;
            if(var2.readInt() != 0) {
               var5 = (DataReadResult)DataReadResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IDataReadCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements lw {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(DataReadResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
