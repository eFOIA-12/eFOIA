package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface c extends IInterface {
   com.google.android.gms.dynamic.d a(com.google.android.gms.dynamic.d var1, int var2, int var3, String var4, int var5) throws RemoteException;

   com.google.android.gms.dynamic.d a(com.google.android.gms.dynamic.d var1, int var2, int var3, String var4, String var5) throws RemoteException;

   public abstract static class a extends Binder implements c {
      public static c bL(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (c)(var1 != null && var1 instanceof c?(c)var1:new c.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var5 = null;
         IBinder var7;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            com.google.android.gms.dynamic.d var8 = this.a(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readString(), var2.readInt());
            var3.writeNoException();
            if(var8 != null) {
               var7 = var8.asBinder();
            } else {
               var7 = null;
            }

            var3.writeStrongBinder(var7);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            com.google.android.gms.dynamic.d var6 = this.a(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readString(), var2.readString());
            var3.writeNoException();
            var7 = (IBinder)var5;
            if(var6 != null) {
               var7 = var6.asBinder();
            }

            var3.writeStrongBinder(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements c {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public com.google.android.gms.dynamic.d a(com.google.android.gms.dynamic.d param1, int param2, int param3, String param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d a(com.google.android.gms.dynamic.d param1, int param2, int param3, String param4, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
