package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;

public interface k extends IInterface {
   void a(ParcelableIndexReference var1) throws RemoteException;

   void n(Status var1) throws RemoteException;

   public abstract static class a extends Binder implements k {
      public static k aj(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
            return (k)(var1 != null && var1 instanceof k?(k)var1:new k.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         ParcelableIndexReference var5 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
            if(var2.readInt() != 0) {
               var5 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(var2);
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
            Status var7 = (Status)var6;
            if(var2.readInt() != 0) {
               var7 = Status.CREATOR.createFromParcel(var2);
            }

            this.n(var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements k {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(ParcelableIndexReference param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void n(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
