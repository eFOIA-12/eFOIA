package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface jq extends IInterface {
   Account hk() throws RemoteException;

   public abstract static class a extends Binder implements jq {
      public a() {
         this.attachInterface(this, "com.google.android.gms.common.internal.IAccountAccessor");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.common.internal.IAccountAccessor");
            Account var5 = this.hk();
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.IAccountAccessor");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
