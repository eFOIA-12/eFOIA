package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.y;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface IProjectionDelegate extends IInterface {
   LatLng fromScreenLocation(com.google.android.gms.dynamic.d var1) throws RemoteException;

   LatLng fromScreenLocation2(y var1) throws RemoteException;

   VisibleRegion getVisibleRegion() throws RemoteException;

   com.google.android.gms.dynamic.d toScreenLocation(LatLng var1) throws RemoteException;

   y toScreenLocation2(LatLng var1) throws RemoteException;

   public abstract static class a extends Binder implements IProjectionDelegate {
      public static IProjectionDelegate bp(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            return (IProjectionDelegate)(var1 != null && var1 instanceof IProjectionDelegate?(IProjectionDelegate)var1:new IProjectionDelegate.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         com.google.android.gms.dynamic.d var6 = null;
         Object var7 = null;
         LatLng var5 = null;
         LatLng var9;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            var9 = this.fromScreenLocation(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            if(var2.readInt() != 0) {
               var9 = LatLng.CREATOR.de(var2);
            } else {
               var9 = null;
            }

            var6 = this.toScreenLocation(var9);
            var3.writeNoException();
            IBinder var11 = var5;
            if(var6 != null) {
               var11 = var6.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            VisibleRegion var10 = this.getVisibleRegion();
            var3.writeNoException();
            if(var10 != null) {
               var3.writeInt(1);
               var10.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            y var12 = var6;
            if(var2.readInt() != 0) {
               var12 = y.CREATOR.cZ(var2);
            }

            var9 = this.fromScreenLocation2(var12);
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            var5 = (LatLng)var7;
            if(var2.readInt() != 0) {
               var5 = LatLng.CREATOR.de(var2);
            }

            y var8 = this.toScreenLocation2(var5);
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements IProjectionDelegate {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public LatLng fromScreenLocation(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public LatLng fromScreenLocation2(y param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public VisibleRegion getVisibleRegion() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         VisibleRegion var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
               this.le.transact(3, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = VisibleRegion.CREATOR.do(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public com.google.android.gms.dynamic.d toScreenLocation(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public y toScreenLocation2(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
