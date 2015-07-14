package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;

public interface fl extends IInterface {
   fj b(fh var1) throws RemoteException;

   public abstract static class a extends Binder implements fl {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
      }

      public static fl C(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (fl)(var1 != null && var1 instanceof fl?(fl)var1:new fl.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            fh var5;
            if(var2.readInt() != 0) {
               var5 = fh.CREATOR.h(var2);
            } else {
               var5 = null;
            }

            fj var6 = this.b(var5);
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements fl {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public fj b(fh param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
