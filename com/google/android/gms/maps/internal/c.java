package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;

public interface c extends IInterface {
   IMapViewDelegate a(com.google.android.gms.dynamic.d var1, GoogleMapOptions var2) throws RemoteException;

   IStreetViewPanoramaViewDelegate a(com.google.android.gms.dynamic.d var1, StreetViewPanoramaOptions var2) throws RemoteException;

   void a(com.google.android.gms.dynamic.d var1, int var2) throws RemoteException;

   void i(com.google.android.gms.dynamic.d var1) throws RemoteException;

   IMapFragmentDelegate j(com.google.android.gms.dynamic.d var1) throws RemoteException;

   IStreetViewPanoramaFragmentDelegate k(com.google.android.gms.dynamic.d var1) throws RemoteException;

   ICameraUpdateFactoryDelegate nW() throws RemoteException;

   com.google.android.gms.maps.model.internal.g nX() throws RemoteException;

   public abstract static class a extends Binder implements c {
      public static c aS(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (c)(var1 != null && var1 instanceof c?(c)var1:new c.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         IStreetViewPanoramaFragmentDelegate var5 = null;
         Object var8 = null;
         Object var9 = null;
         com.google.android.gms.dynamic.d var6 = null;
         Object var10 = null;
         Object var7 = null;
         IBinder var11;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            this.i(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            IMapFragmentDelegate var18 = this.j(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            var11 = (IBinder)var7;
            if(var18 != null) {
               var11 = var18.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            var6 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            GoogleMapOptions var19;
            if(var2.readInt() != 0) {
               var19 = GoogleMapOptions.CREATOR.cX(var2);
            } else {
               var19 = null;
            }

            IMapViewDelegate var17 = this.a(var6, var19);
            var3.writeNoException();
            var11 = var5;
            if(var17 != null) {
               var11 = var17.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            ICameraUpdateFactoryDelegate var16 = this.nW();
            var3.writeNoException();
            var11 = (IBinder)var8;
            if(var16 != null) {
               var11 = var16.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            com.google.android.gms.maps.model.internal.g var15 = this.nX();
            var3.writeNoException();
            var11 = (IBinder)var9;
            if(var15 != null) {
               var11 = var15.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            this.a(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            com.google.android.gms.dynamic.d var13 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            StreetViewPanoramaOptions var12;
            if(var2.readInt() != 0) {
               var12 = StreetViewPanoramaOptions.CREATOR.cY(var2);
            } else {
               var12 = null;
            }

            IStreetViewPanoramaViewDelegate var14 = this.a(var13, var12);
            var3.writeNoException();
            var11 = var6;
            if(var14 != null) {
               var11 = var14.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            var5 = this.k(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            var11 = (IBinder)var10;
            if(var5 != null) {
               var11 = var5.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ICreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements c {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IMapViewDelegate a(com.google.android.gms.dynamic.d param1, GoogleMapOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IStreetViewPanoramaViewDelegate a(com.google.android.gms.dynamic.d param1, StreetViewPanoramaOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.dynamic.d param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void i(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IMapFragmentDelegate j(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IStreetViewPanoramaFragmentDelegate k(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public ICameraUpdateFactoryDelegate nW() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ICameraUpdateFactoryDelegate var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.le.transact(4, var1, var2, 0);
            var2.readException();
            var3 = ICameraUpdateFactoryDelegate.a.aQ(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public com.google.android.gms.maps.model.internal.g nX() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.maps.model.internal.g var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.maps.model.internal.g.bv(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }
   }
}
