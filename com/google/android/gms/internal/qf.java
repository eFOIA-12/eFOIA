package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.py;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

public interface qf extends IInterface {
   void a(int var1, FullWallet var2, Bundle var3) throws RemoteException;

   void a(int var1, MaskedWallet var2, Bundle var3) throws RemoteException;

   void a(int var1, boolean var2, Bundle var3) throws RemoteException;

   void a(Status var1, py var2, Bundle var3) throws RemoteException;

   void i(int var1, Bundle var2) throws RemoteException;

   public abstract static class a extends Binder implements qf {
      public a() {
         this.attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      }

      public static qf bU(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            return (qf)(var1 != null && var1 instanceof qf?(qf)var1:new qf.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Bundle var8;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            var1 = var2.readInt();
            MaskedWallet var10;
            if(var2.readInt() != 0) {
               var10 = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.a(var1, var10, var8);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            var1 = var2.readInt();
            FullWallet var9;
            if(var2.readInt() != 0) {
               var9 = (FullWallet)FullWallet.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.a(var1, var9, var8);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            var1 = var2.readInt();
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.a(var1, var5, var8);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            var1 = var2.readInt();
            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.i(var1, var8);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            Status var6;
            if(var2.readInt() != 0) {
               var6 = Status.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            py var7;
            if(var2.readInt() != 0) {
               var7 = (py)py.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.a(var6, var7, var8);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements qf {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(int param1, FullWallet param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(int param1, MaskedWallet param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(int param1, boolean param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(Status param1, py param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void i(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
