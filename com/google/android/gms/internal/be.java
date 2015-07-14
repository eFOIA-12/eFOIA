package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.cy;

public interface be extends IInterface {
   IBinder a(com.google.android.gms.dynamic.d var1, ay var2, String var3, cy var4, int var5) throws RemoteException;

   public abstract static class a extends Binder implements be {
      public static be g(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (be)(var1 != null && var1 instanceof be?(be)var1:new be.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            com.google.android.gms.dynamic.d var6 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            ay var5;
            if(var2.readInt() != 0) {
               var5 = ay.CREATOR.c(var2);
            } else {
               var5 = null;
            }

            IBinder var7 = this.a(var6, var5, var2.readString(), cy.a.n(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements be {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder a(com.google.android.gms.dynamic.d param1, ay param2, String param3, cy param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
