package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface v extends IInterface {
   void h(com.google.android.gms.dynamic.d var1) throws RemoteException;

   void onSnapshotReady(Bitmap var1) throws RemoteException;

   public abstract static class a extends Binder implements v {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      }

      public static v bq(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return (v)(var1 != null && var1 instanceof v?(v)var1:new v.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            Bitmap var5;
            if(var2.readInt() != 0) {
               var5 = (Bitmap)Bitmap.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onSnapshotReady(var5);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            this.h(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements v {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void h(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onSnapshotReady(Bitmap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
