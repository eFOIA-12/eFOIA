package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public interface h extends IInterface {
   boolean a(h var1) throws RemoteException;

   LatLng getCenter() throws RemoteException;

   int getFillColor() throws RemoteException;

   String getId() throws RemoteException;

   double getRadius() throws RemoteException;

   int getStrokeColor() throws RemoteException;

   float getStrokeWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setCenter(LatLng var1) throws RemoteException;

   void setFillColor(int var1) throws RemoteException;

   void setRadius(double var1) throws RemoteException;

   void setStrokeColor(int var1) throws RemoteException;

   void setStrokeWidth(float var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class a extends Binder implements h {
      public static h bw(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            return (h)(var1 != null && var1 instanceof h?(h)var1:new h.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         byte var8 = 0;
         byte var9 = 0;
         boolean var10 = false;
         float var7;
         byte var11;
         LatLng var12;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            String var13 = this.getId();
            var3.writeNoException();
            var3.writeString(var13);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            if(var2.readInt() != 0) {
               var12 = LatLng.CREATOR.de(var2);
            } else {
               var12 = null;
            }

            this.setCenter(var12);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var12 = this.getCenter();
            var3.writeNoException();
            if(var12 != null) {
               var3.writeInt(1);
               var12.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setRadius(var2.readDouble());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            double var5 = this.getRadius();
            var3.writeNoException();
            var3.writeDouble(var5);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setStrokeWidth(var2.readFloat());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var7 = this.getStrokeWidth();
            var3.writeNoException();
            var3.writeFloat(var7);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setStrokeColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var1 = this.getStrokeColor();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setFillColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var1 = this.getFillColor();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var7 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var7);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            if(var2.readInt() != 0) {
               var10 = true;
            }

            this.setVisible(var10);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var10 = this.isVisible();
            var3.writeNoException();
            var11 = var8;
            if(var10) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var10 = this.a(bw(var2.readStrongBinder()));
            var3.writeNoException();
            var11 = var9;
            if(var10) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.ICircleDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements h {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public boolean a(h param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public LatLng getCenter() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         LatLng var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
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

      public int getFillColor() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.le.transact(12, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public double getRadius() throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         double var1;
         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.le.transact(6, var3, var4, 0);
            var4.readException();
            var1 = var4.readDouble();
         } finally {
            var4.recycle();
            var3.recycle();
         }

         return var1;
      }

      public int getStrokeColor() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.le.transact(10, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public float getStrokeWidth() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.le.transact(8, var2, var3, 0);
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.le.transact(18, var2, var3, 0);
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
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
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

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setCenter(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setFillColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var2.writeInt(var1);
            this.le.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setRadius(double var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var3.writeDouble(var1);
            this.le.transact(5, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void setStrokeColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var2.writeInt(var1);
            this.le.transact(9, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setStrokeWidth(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var2.writeFloat(var1);
            this.le.transact(7, var2, var3, 0);
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
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
