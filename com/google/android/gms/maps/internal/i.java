package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface i extends IInterface {
   void d(Location var1) throws RemoteException;

   void l(com.google.android.gms.dynamic.d var1) throws RemoteException;

   public abstract static class a extends Binder implements i {
      public static i bc(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (i)(var1 != null && var1 instanceof i?(i)var1:new i.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            this.l(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            Location var5;
            if(var2.readInt() != 0) {
               var5 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.d(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements i {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void d(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void l(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
