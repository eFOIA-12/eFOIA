package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface cm extends IInterface {
   Bundle bN() throws RemoteException;

   public abstract static class a extends Binder implements cm {
      public static cm m(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
            return (cm)(var1 != null && var1 instanceof cm?(cm)var1:new cm.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
            Bundle var5 = this.bN();
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements cm {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public Bundle bN() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Bundle var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
               this.le.transact(1, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Bundle)Bundle.CREATOR.createFromParcel(var3);
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
   }
}
