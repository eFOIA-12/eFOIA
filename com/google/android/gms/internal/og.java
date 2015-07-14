package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface og extends IInterface {
   void X(DataHolder var1) throws RemoteException;

   void Y(DataHolder var1) throws RemoteException;

   void Z(DataHolder var1) throws RemoteException;

   public abstract static class a extends Binder implements og {
      public static og aP(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return (og)(var1 != null && var1 instanceof og?(og)var1:new og.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         Object var7 = null;
         Object var5 = null;
         DataHolder var8;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            var8 = (DataHolder)var5;
            if(var2.readInt() != 0) {
               var8 = DataHolder.CREATOR.B(var2);
            }

            this.X(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            var8 = (DataHolder)var6;
            if(var2.readInt() != 0) {
               var8 = DataHolder.CREATOR.B(var2);
            }

            this.Y(var8);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            var8 = (DataHolder)var7;
            if(var2.readInt() != 0) {
               var8 = DataHolder.CREATOR.B(var2);
            }

            this.Z(var8);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements og {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void X(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void Y(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void Z(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
