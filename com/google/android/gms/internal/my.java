package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.mx;

public interface my extends IInterface {
   void a(mx var1, UserAddressRequest var2, Bundle var3) throws RemoteException;

   public abstract static class a extends Binder implements my {
      public static my aK(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            return (my)(var1 != null && var1 instanceof my?(my)var1:new my.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            mx var6 = mx.a.aJ(var2.readStrongBinder());
            UserAddressRequest var5;
            if(var2.readInt() != 0) {
               var5 = (UserAddressRequest)UserAddressRequest.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.a(var6, var5, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements my {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(mx param1, UserAddressRequest param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
