package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public interface l extends IInterface {
   void onMapLongClick(LatLng var1) throws RemoteException;

   public abstract static class a extends Binder implements l {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLongClickListener");
      }

      public static l bf(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLongClickListener");
            return (l)(var1 != null && var1 instanceof l?(l)var1:new l.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMapLongClickListener");
            LatLng var5;
            if(var2.readInt() != 0) {
               var5 = LatLng.CREATOR.de(var2);
            } else {
               var5 = null;
            }

            this.onMapLongClick(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMapLongClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements l {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void onMapLongClick(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
