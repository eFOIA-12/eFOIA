package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface o extends IInterface {
   void b(com.google.android.gms.maps.model.internal.l var1) throws RemoteException;

   void c(com.google.android.gms.maps.model.internal.l var1) throws RemoteException;

   void d(com.google.android.gms.maps.model.internal.l var1) throws RemoteException;

   public abstract static class a extends Binder implements o {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
      }

      public static o bi(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (o)(var1 != null && var1 instanceof o?(o)var1:new o.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.b(com.google.android.gms.maps.model.internal.l.bA(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.d(com.google.android.gms.maps.model.internal.l.bA(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.c(com.google.android.gms.maps.model.internal.l.bA(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
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

      public void b(com.google.android.gms.maps.model.internal.l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(com.google.android.gms.maps.model.internal.l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(com.google.android.gms.maps.model.internal.l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
