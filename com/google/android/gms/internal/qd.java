package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qb;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface qd extends IInterface {
   qa a(com.google.android.gms.dynamic.d var1, com.google.android.gms.dynamic.c var2, WalletFragmentOptions var3, qb var4) throws RemoteException;

   public abstract static class a extends Binder implements qd {
      public static qd bS(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (qd)(var1 != null && var1 instanceof qd?(qd)var1:new qd.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            com.google.android.gms.dynamic.d var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            com.google.android.gms.dynamic.c var8 = com.google.android.gms.dynamic.c.ao(var2.readStrongBinder());
            WalletFragmentOptions var5;
            if(var2.readInt() != 0) {
               var5 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            qa var10 = this.a(var7, var8, var5, qb.a.bQ(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var9 = (IBinder)var6;
            if(var10 != null) {
               var9 = var10.asBinder();
            }

            var3.writeStrongBinder(var9);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements qd {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public qa a(com.google.android.gms.dynamic.d param1, com.google.android.gms.dynamic.c param2, WalletFragmentOptions param3, qb param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
