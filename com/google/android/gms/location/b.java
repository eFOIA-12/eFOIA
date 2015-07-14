package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface b extends IInterface {
   void onLocationChanged(Location var1) throws RemoteException;

   public abstract static class a extends Binder implements b {
      public a() {
         this.attachInterface(this, "com.google.android.gms.location.ILocationListener");
      }

      public static b aL(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            return (b)(var1 != null && var1 instanceof b?(b)var1:new b.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.ILocationListener");
            Location var5;
            if(var2.readInt() != 0) {
               var5 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onLocationChanged(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.ILocationListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements b {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void onLocationChanged(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
