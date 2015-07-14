package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

public interface m extends IInterface {
   void a(IGoogleMapDelegate var1) throws RemoteException;

   public abstract static class a extends Binder implements m {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
      }

      public static m bg(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            return (m)(var1 != null && var1 instanceof m?(m)var1:new m.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            this.a(IGoogleMapDelegate.a.aT(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements m {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(IGoogleMapDelegate param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
