package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface d extends IInterface {
   com.google.android.gms.dynamic.d f(com.google.android.gms.maps.model.internal.l var1) throws RemoteException;

   com.google.android.gms.dynamic.d g(com.google.android.gms.maps.model.internal.l var1) throws RemoteException;

   public abstract static class a extends Binder implements d {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
      }

      public static d aU(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (d)(var1 != null && var1 instanceof d?(d)var1:new d.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         com.google.android.gms.dynamic.d var6 = null;
         com.google.android.gms.dynamic.d var5 = null;
         IBinder var7;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            var6 = this.f(com.google.android.gms.maps.model.internal.l.bA(var2.readStrongBinder()));
            var3.writeNoException();
            var7 = var5;
            if(var6 != null) {
               var7 = var6.asBinder();
            }

            var3.writeStrongBinder(var7);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            var5 = this.g(com.google.android.gms.maps.model.internal.l.bA(var2.readStrongBinder()));
            var3.writeNoException();
            var7 = var6;
            if(var5 != null) {
               var7 = var5.asBinder();
            }

            var3.writeStrongBinder(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements d {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public com.google.android.gms.dynamic.d f(com.google.android.gms.maps.model.internal.l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d g(com.google.android.gms.maps.model.internal.l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
