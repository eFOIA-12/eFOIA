package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ep extends IInterface {
   IBinder c(com.google.android.gms.dynamic.d var1) throws RemoteException;

   public abstract static class a extends Binder implements ep {
      public static ep x(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return (ep)(var1 != null && var1 instanceof ep?(ep)var1:new ep.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            IBinder var5 = this.c(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ep {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public IBinder c(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
