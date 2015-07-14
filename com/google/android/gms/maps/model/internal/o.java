package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public interface o extends IInterface {
   Tile getTile(int var1, int var2, int var3) throws RemoteException;

   public abstract static class a extends Binder implements o {
      public a() {
         this.attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
      }

      public static o bE(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            return (o)(var1 != null && var1 instanceof o?(o)var1:new o.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            Tile var5 = this.getTile(var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements o {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public Tile getTile(int var1, int var2, int var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();
         Parcel var6 = Parcel.obtain();
         boolean var8 = false;

         Tile var4;
         label36: {
            try {
               var8 = true;
               var5.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
               var5.writeInt(var1);
               var5.writeInt(var2);
               var5.writeInt(var3);
               this.le.transact(1, var5, var6, 0);
               var6.readException();
               if(var6.readInt() != 0) {
                  var4 = Tile.CREATOR.dm(var6);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var6.recycle();
                  var5.recycle();
               }
            }

            var4 = null;
         }

         var6.recycle();
         var5.recycle();
         return var4;
      }
   }
}
