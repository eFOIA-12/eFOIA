package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface n extends IInterface {
   boolean a(n var1) throws RemoteException;

   void clearTileCache() throws RemoteException;

   boolean getFadeIn() throws RemoteException;

   String getId() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setFadeIn(boolean var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class a extends Binder implements n {
      public static n bD(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            return (n)(var1 != null && var1 instanceof n?(n)var1:new n.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         byte var6 = 0;
         byte var7 = 0;
         boolean var10 = false;
         byte var8 = 0;
         boolean var9 = false;
         byte var11;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.clearTileCache();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            String var12 = this.getId();
            var3.writeNoException();
            var3.writeString(var12);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            float var5 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.setVisible(var9);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            var9 = this.isVisible();
            var3.writeNoException();
            var11 = var6;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            var9 = this.a(bD(var2.readStrongBinder()));
            var3.writeNoException();
            var11 = var7;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            var9 = var10;
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.setFadeIn(var9);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            var9 = this.getFadeIn();
            var3.writeNoException();
            var11 = var8;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements n {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public boolean a(n param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void clearTileCache() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean getFadeIn() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.le.transact(11, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public String getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.le.transact(3, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public float getZIndex() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.le.transact(5, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public int hashCodeRemote() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.le.transact(9, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public boolean isVisible() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.le.transact(7, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setFadeIn(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZIndex(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            var2.writeFloat(var1);
            this.le.transact(4, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
