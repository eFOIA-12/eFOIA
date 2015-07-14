package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ju extends IInterface {
   com.google.android.gms.dynamic.d a(com.google.android.gms.dynamic.d var1, int var2, int var3) throws RemoteException;

   public abstract static class a extends Binder implements ju {
      public static ju R(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (ju)(var1 != null && var1 instanceof ju?(ju)var1:new ju.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            com.google.android.gms.dynamic.d var5 = this.a(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()), var2.readInt(), var2.readInt());
            var3.writeNoException();
            IBinder var6;
            if(var5 != null) {
               var6 = var5.asBinder();
            } else {
               var6 = null;
            }

            var3.writeStrongBinder(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ju {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public com.google.android.gms.dynamic.d a(com.google.android.gms.dynamic.d param1, int param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
