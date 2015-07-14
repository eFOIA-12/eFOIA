package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface oj extends IInterface {
   void a(int var1, Bundle var2, int var3, Intent var4) throws RemoteException;

   public abstract static class a extends Binder implements oj {
      public a() {
         this.attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
      }

      public static oj bF(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            return (oj)(var1 != null && var1 instanceof oj?(oj)var1:new oj.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            var1 = var2.readInt();
            Bundle var5;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            var4 = var2.readInt();
            Intent var6;
            if(var2.readInt() != 0) {
               var6 = (Intent)Intent.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.a(var1, var5, var4, var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements oj {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(int param1, Bundle param2, int param3, Intent param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
