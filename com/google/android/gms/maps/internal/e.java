package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface e extends IInterface {
   Bitmap a(com.google.android.gms.maps.model.internal.l var1, int var2, int var3) throws RemoteException;

   public abstract static class a extends Binder implements e {
      public static e aV(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            return (e)(var1 != null && var1 instanceof e?(e)var1:new e.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            Bitmap var5 = this.a(com.google.android.gms.maps.model.internal.l.bA(var2.readStrongBinder()), var2.readInt(), var2.readInt());
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements e {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public Bitmap a(com.google.android.gms.maps.model.internal.l param1, int param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
