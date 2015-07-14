package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.eq;

public interface er extends IInterface {
   void a(eq var1) throws RemoteException;

   boolean isValidPurchase(String var1) throws RemoteException;

   public abstract static class a extends Binder implements er {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
      }

      public static er z(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            return (er)(var1 != null && var1 instanceof er?(er)var1:new er.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            boolean var5 = this.isValidPurchase(var2.readString());
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            this.a(eq.a.y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements er {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(eq param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public boolean isValidPurchase(String var1) throws RemoteException {
         boolean var3 = true;
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();
         boolean var7 = false;

         int var2;
         try {
            var7 = true;
            var4.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            var4.writeString(var1);
            this.le.transact(1, var4, var5, 0);
            var5.readException();
            var2 = var5.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var5.recycle();
               var4.recycle();
            }
         }

         if(var2 == 0) {
            var3 = false;
         }

         var5.recycle();
         var4.recycle();
         return var3;
      }
   }
}
