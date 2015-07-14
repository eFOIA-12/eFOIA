package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public interface m extends IInterface {
   boolean a(m var1) throws RemoteException;

   int getFillColor() throws RemoteException;

   List getHoles() throws RemoteException;

   String getId() throws RemoteException;

   List getPoints() throws RemoteException;

   int getStrokeColor() throws RemoteException;

   float getStrokeWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isGeodesic() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setFillColor(int var1) throws RemoteException;

   void setGeodesic(boolean var1) throws RemoteException;

   void setHoles(List var1) throws RemoteException;

   void setPoints(List var1) throws RemoteException;

   void setStrokeColor(int var1) throws RemoteException;

   void setStrokeWidth(float var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class a extends Binder implements m {
      public static m bB(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            return (m)(var1 != null && var1 instanceof m?(m)var1:new m.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         byte var6 = 0;
         boolean var10 = false;
         byte var7 = 0;
         byte var8 = 0;
         boolean var9 = false;
         float var5;
         byte var11;
         List var12;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            String var13 = this.getId();
            var3.writeNoException();
            var3.writeString(var13);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.setPoints(var2.createTypedArrayList(LatLng.CREATOR));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var12 = this.getPoints();
            var3.writeNoException();
            var3.writeTypedList(var12);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.setHoles(var2.readArrayList(this.getClass().getClassLoader()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var12 = this.getHoles();
            var3.writeNoException();
            var3.writeList(var12);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.setStrokeWidth(var2.readFloat());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var5 = this.getStrokeWidth();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.setStrokeColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var1 = this.getStrokeColor();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.setFillColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var1 = this.getFillColor();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var5 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.setVisible(var9);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var9 = this.isVisible();
            var3.writeNoException();
            var11 = var6;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var9 = var10;
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.setGeodesic(var9);
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var9 = this.isGeodesic();
            var3.writeNoException();
            var11 = var7;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var9 = this.a(bB(var2.readStrongBinder()));
            var3.writeNoException();
            var11 = var8;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements m {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public boolean a(m param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public int getFillColor() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.le.transact(12, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public List getHoles() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.le.transact(6, var1, var2, 0);
            var2.readException();
            var3 = var2.readArrayList(this.getClass().getClassLoader());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public String getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public List getPoints() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.le.transact(4, var1, var2, 0);
            var2.readException();
            var3 = var2.createTypedArrayList(LatLng.CREATOR);
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public int getStrokeColor() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.le.transact(20, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public boolean isGeodesic() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.le.transact(18, var3, var4, 0);
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

      public boolean isVisible() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setFillColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var2.writeInt(var1);
            this.le.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setGeodesic(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setHoles(List var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var2.writeList(var1);
            this.le.transact(5, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setPoints(List var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            var2.writeTypedList(var1);
            this.le.transact(3, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setStrokeColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
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
