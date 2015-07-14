package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.internal.a;

public interface i extends IInterface {
   void a(float var1, float var2) throws RemoteException;

   void a(a var1) throws RemoteException;

   boolean a(i var1) throws RemoteException;

   float getBearing() throws RemoteException;

   LatLngBounds getBounds() throws RemoteException;

   float getHeight() throws RemoteException;

   String getId() throws RemoteException;

   LatLng getPosition() throws RemoteException;

   float getTransparency() throws RemoteException;

   float getWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void m(com.google.android.gms.dynamic.d var1) throws RemoteException;

   void remove() throws RemoteException;

   void setBearing(float var1) throws RemoteException;

   void setDimensions(float var1) throws RemoteException;

   void setPosition(LatLng var1) throws RemoteException;

   void setPositionFromBounds(LatLngBounds var1) throws RemoteException;

   void setTransparency(float var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class a extends Binder implements i {
      public static i bx(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            return (i)(var1 != null && var1 instanceof i?(i)var1:new i.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var10 = null;
         Object var11 = null;
         LatLng var9 = null;
         byte var7 = 0;
         byte var6 = 0;
         float var5;
         boolean var8;
         byte var12;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            String var15 = this.getId();
            var3.writeNoException();
            var3.writeString(var15);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            if(var2.readInt() != 0) {
               var9 = LatLng.CREATOR.de(var2);
            }

            this.setPosition(var9);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            LatLng var14 = this.getPosition();
            var3.writeNoException();
            if(var14 != null) {
               var3.writeInt(1);
               var14.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setDimensions(var2.readFloat());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.a(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var5 = this.getWidth();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var5 = this.getHeight();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            LatLngBounds var17 = (LatLngBounds)var10;
            if(var2.readInt() != 0) {
               var17 = LatLngBounds.CREATOR.dd(var2);
            }

            this.setPositionFromBounds(var17);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            LatLngBounds var13 = this.getBounds();
            var3.writeNoException();
            if(var13 != null) {
               var3.writeInt(1);
               var13.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setBearing(var2.readFloat());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var5 = this.getBearing();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var5 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.setVisible(var8);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var8 = this.isVisible();
            var3.writeNoException();
            var12 = var6;
            if(var8) {
               var12 = 1;
            }

            var3.writeInt(var12);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setTransparency(var2.readFloat());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var5 = this.getTransparency();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var8 = this.a(bx(var2.readStrongBinder()));
            var3.writeNoException();
            var12 = var7;
            if(var8) {
               var12 = 1;
            }

            var3.writeInt(var12);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.m(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            a var16 = (a)var11;
            if(var2.readInt() != 0) {
               var16 = a.CREATOR.dp(var2);
            }

            this.a(var16);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements i {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.le.transact(6, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void a(a param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public boolean a(i param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public float getBearing() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(12, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public LatLngBounds getBounds() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         LatLngBounds var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
               this.le.transact(10, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = LatLngBounds.CREATOR.dd(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public float getHeight() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(8, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public String getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public LatLng getPosition() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         LatLng var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
               this.le.transact(4, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = LatLng.CREATOR.de(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public float getTransparency() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(18, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public float getWidth() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(7, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public float getZIndex() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(14, var2, var3, 0);
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(20, var2, var3, 0);
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
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(16, var3, var4, 0);
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

      public void m(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setBearing(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.le.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setDimensions(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.le.transact(5, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setPosition(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPositionFromBounds(LatLngBounds param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setTransparency(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.le.transact(17, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZIndex(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.le.transact(13, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
