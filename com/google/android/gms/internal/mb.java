package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

public interface mb extends IInterface {
   void a(SessionReadResult var1) throws RemoteException;

   public abstract static class a extends Binder implements mb {
      public a() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.ISessionReadCallback");
      }

      public static mb ax(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            return (mb)(var1 != null && var1 instanceof mb?(mb)var1:new mb.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            SessionReadResult var5;
            if(var2.readInt() != 0) {
               var5 = (SessionReadResult)SessionReadResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.ISessionReadCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements mb {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(SessionReadResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
