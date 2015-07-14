package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.pw;
import com.google.android.gms.internal.qe;
import com.google.android.gms.internal.qf;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public interface qc extends IInterface {
   void a(Bundle var1, qf var2) throws RemoteException;

   void a(pw var1, Bundle var2, qf var3) throws RemoteException;

   void a(FullWalletRequest var1, Bundle var2, qf var3) throws RemoteException;

   void a(MaskedWalletRequest var1, Bundle var2, qe var3) throws RemoteException;

   void a(MaskedWalletRequest var1, Bundle var2, qf var3) throws RemoteException;

   void a(NotifyTransactionStatusRequest var1, Bundle var2) throws RemoteException;

   void a(com.google.android.gms.wallet.d var1, Bundle var2, qf var3) throws RemoteException;

   void a(String var1, String var2, Bundle var3, qf var4) throws RemoteException;

   void r(Bundle var1) throws RemoteException;

   void s(Bundle var1) throws RemoteException;

   public abstract static class a extends Binder implements qc {
      public static qc bR(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (qc)(var1 != null && var1 instanceof qc?(qc)var1:new qc.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Bundle var5;
         Bundle var7;
         MaskedWalletRequest var9;
         Bundle var11;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            if(var2.readInt() != 0) {
               var9 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var9, var5, qf.a.bU(var2.readStrongBinder()));
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            FullWalletRequest var14;
            if(var2.readInt() != 0) {
               var14 = (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var14, var5, qf.a.bU(var2.readStrongBinder()));
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            String var13 = var2.readString();
            String var6 = var2.readString();
            if(var2.readInt() != 0) {
               var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.a(var13, var6, var11, qf.a.bU(var2.readStrongBinder()));
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            NotifyTransactionStatusRequest var12;
            if(var2.readInt() != 0) {
               var12 = (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.a(var12, var7);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            if(var2.readInt() != 0) {
               var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.a(var11, qf.a.bU(var2.readStrongBinder()));
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            com.google.android.gms.wallet.d var10;
            if(var2.readInt() != 0) {
               var10 = (com.google.android.gms.wallet.d)com.google.android.gms.wallet.d.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var10, var5, qf.a.bU(var2.readStrongBinder()));
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            if(var2.readInt() != 0) {
               var9 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var9, var5, qe.a.bT(var2.readStrongBinder()));
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            pw var8;
            if(var2.readInt() != 0) {
               var8 = (pw)pw.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var8, var5, qf.a.bU(var2.readStrongBinder()));
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.r(var7);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.s(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.internal.IOwService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements qc {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(Bundle param1, qf param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(pw param1, Bundle param2, qf param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(FullWalletRequest param1, Bundle param2, qf param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(MaskedWalletRequest param1, Bundle param2, qe param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(MaskedWalletRequest param1, Bundle param2, qf param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(NotifyTransactionStatusRequest param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.wallet.d param1, Bundle param2, qf param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, String param2, Bundle param3, qf param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void r(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void s(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
