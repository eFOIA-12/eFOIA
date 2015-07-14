package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface qa extends IInterface {
   void a(com.google.android.gms.dynamic.d var1, WalletFragmentOptions var2, Bundle var3) throws RemoteException;

   int getState() throws RemoteException;

   void initialize(WalletFragmentInitParams var1) throws RemoteException;

   void onActivityResult(int var1, int var2, Intent var3) throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   com.google.android.gms.dynamic.d onCreateView(com.google.android.gms.dynamic.d var1, com.google.android.gms.dynamic.d var2, Bundle var3) throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   void onStart() throws RemoteException;

   void onStop() throws RemoteException;

   void setEnabled(boolean var1) throws RemoteException;

   void updateMaskedWallet(MaskedWallet var1) throws RemoteException;

   void updateMaskedWalletRequest(MaskedWalletRequest var1) throws RemoteException;

   public abstract static class a extends Binder implements qa {
      public static qa bP(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            return (qa)(var1 != null && var1 instanceof qa?(qa)var1:new qa.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         WalletFragmentOptions var6 = null;
         com.google.android.gms.dynamic.d var7;
         Bundle var13;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var6 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            if(var2.readInt() != 0) {
               var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            this.a(var7, var6, var13);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            if(var2.readInt() != 0) {
               var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            this.onCreate(var13);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            com.google.android.gms.dynamic.d var8 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            var7 = this.onCreateView(var7, var8, var13);
            var3.writeNoException();
            IBinder var14 = var6;
            if(var7 != null) {
               var14 = var7.asBinder();
            }

            var3.writeStrongBinder(var14);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.onStart();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.onResume();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.onPause();
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.onStop();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            if(var2.readInt() != 0) {
               var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            this.onSaveInstanceState(var13);
            var3.writeNoException();
            if(var13 != null) {
               var3.writeInt(1);
               var13.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            var1 = var2.readInt();
            var4 = var2.readInt();
            Intent var12;
            if(var2.readInt() != 0) {
               var12 = (Intent)Intent.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            this.onActivityResult(var1, var4, var12);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            WalletFragmentInitParams var11;
            if(var2.readInt() != 0) {
               var11 = (WalletFragmentInitParams)WalletFragmentInitParams.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.initialize(var11);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            MaskedWalletRequest var10;
            if(var2.readInt() != 0) {
               var10 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.updateMaskedWalletRequest(var10);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.setEnabled(var5);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            var1 = this.getState();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            MaskedWallet var9;
            if(var2.readInt() != 0) {
               var9 = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            this.updateMaskedWallet(var9);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements qa {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(com.google.android.gms.dynamic.d param1, WalletFragmentOptions param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public int getState() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.le.transact(13, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public void initialize(WalletFragmentInitParams param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onActivityResult(int param1, int param2, Intent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d onCreateView(com.google.android.gms.dynamic.d param1, com.google.android.gms.dynamic.d param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onPause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.le.transact(6, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onResume() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onSaveInstanceState(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onStart() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.le.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onStop() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            this.le.transact(7, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void updateMaskedWallet(MaskedWallet param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void updateMaskedWalletRequest(MaskedWalletRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
