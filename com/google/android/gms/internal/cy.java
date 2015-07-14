package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cz;

public interface cy extends IInterface {
   cz x(String var1) throws RemoteException;

   boolean y(String var1) throws RemoteException;

   public abstract static class a extends Binder implements cy {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      }

      public static cy n(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (cy)(var1 != null && var1 instanceof cy?(cy)var1:new cy.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            cz var7 = this.x(var2.readString());
            var3.writeNoException();
            IBinder var8;
            if(var7 != null) {
               var8 = var7.asBinder();
            } else {
               var8 = null;
            }

            var3.writeStrongBinder(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            boolean var5 = this.y(var2.readString());
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
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements cy {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public cz x(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         cz var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            var2.writeString(var1);
            this.le.transact(1, var2, var3, 0);
            var3.readException();
            var6 = cz.a.o(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public boolean y(String var1) throws RemoteException {
         boolean var3 = false;
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();
         boolean var7 = false;

         int var2;
         try {
            var7 = true;
            var4.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            var4.writeString(var1);
            this.le.transact(2, var4, var5, 0);
            var5.readException();
            var2 = var5.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var5.recycle();
               var4.recycle();
            }
         }

         if(var2 != 0) {
            var3 = true;
         }

         var5.recycle();
         var4.recycle();
         return var3;
      }
   }
}
