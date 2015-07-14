package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public interface IPolylineDelegate extends IInterface {
   boolean equalsRemote(IPolylineDelegate var1) throws RemoteException;

   int getColor() throws RemoteException;

   String getId() throws RemoteException;

   List getPoints() throws RemoteException;

   float getWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isGeodesic() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setColor(int var1) throws RemoteException;

   void setGeodesic(boolean var1) throws RemoteException;

   void setPoints(List var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setWidth(float var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class a extends Binder implements IPolylineDelegate {
      public static IPolylineDelegate bC(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            return (IPolylineDelegate)(var1 != null && var1 instanceof IPolylineDelegate?(IPolylineDelegate)var1:new IPolylineDelegate.a(var0));
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
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            String var13 = this.getId();
            var3.writeNoException();
            var3.writeString(var13);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setPoints(var2.createTypedArrayList(LatLng.CREATOR));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            List var12 = this.getPoints();
            var3.writeNoException();
            var3.writeTypedList(var12);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setWidth(var2.readFloat());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var5 = this.getWidth();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var1 = this.getColor();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var5 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.setVisible(var9);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var9 = this.isVisible();
            var3.writeNoException();
            var11 = var6;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var9 = var10;
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.setGeodesic(var9);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var9 = this.isGeodesic();
            var3.writeNoException();
            var11 = var7;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var9 = this.equalsRemote(bC(var2.readStrongBinder()));
            var3.writeNoException();
            var11 = var8;
            if(var9) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements IPolylineDelegate {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public boolean equalsRemote(IPolylineDelegate param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getColor() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(8, var2, var3, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(4, var1, var2, 0);
            var2.readException();
            var3 = var2.createTypedArrayList(LatLng.CREATOR);
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public float getWidth() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(6, var2, var3, 0);
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(10, var2, var3, 0);
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(16, var2, var3, 0);
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
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(14, var3, var4, 0);
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
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(12, var3, var4, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeInt(var1);
            this.le.transact(7, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setGeodesic(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPoints(List var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeTypedList(var1);
            this.le.transact(3, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setWidth(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeFloat(var1);
            this.le.transact(5, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setZIndex(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeFloat(var1);
            this.le.transact(9, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
