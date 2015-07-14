package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface n extends IInterface {
   boolean a(com.google.android.gms.maps.model.internal.l var1) throws RemoteException;

   public abstract static class a extends Binder implements n {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
      }

      public static n bh(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (n)(var1 != null && var1 instanceof n?(n)var1:new n.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            boolean var5 = this.a(com.google.android.gms.maps.model.internal.l.bA(var2.readStrongBinder()));
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements n {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public boolean a(com.google.android.gms.maps.model.internal.l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
