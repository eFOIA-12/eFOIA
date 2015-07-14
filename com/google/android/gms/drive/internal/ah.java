package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ah extends IInterface {
   void M(boolean var1) throws RemoteException;

   public abstract static class a extends Binder implements ah {
      public static ah aa(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
            return (ah)(var1 != null && var1 instanceof ah?(ah)var1:new ah.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.M(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ah {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void M(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
