package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.internal.a;

public interface l extends IInterface {
   void b(a var1) throws RemoteException;

   float getAlpha() throws RemoteException;

   String getId() throws RemoteException;

   LatLng getPosition() throws RemoteException;

   float getRotation() throws RemoteException;

   String getSnippet() throws RemoteException;

   String getTitle() throws RemoteException;

   boolean h(l var1) throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   void hideInfoWindow() throws RemoteException;

   boolean isDraggable() throws RemoteException;

   boolean isFlat() throws RemoteException;

   boolean isInfoWindowShown() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void n(com.google.android.gms.dynamic.d var1) throws RemoteException;

   void remove() throws RemoteException;

   void setAlpha(float var1) throws RemoteException;

   void setAnchor(float var1, float var2) throws RemoteException;

   void setDraggable(boolean var1) throws RemoteException;

   void setFlat(boolean var1) throws RemoteException;

   void setInfoWindowAnchor(float var1, float var2) throws RemoteException;

   void setPosition(LatLng var1) throws RemoteException;

   void setRotation(float var1) throws RemoteException;

   void setSnippet(String var1) throws RemoteException;

   void setTitle(String var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void showInfoWindow() throws RemoteException;

   public abstract static class a extends Binder implements l {
      public static l bA(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            return (l)(var1 != null && var1 instanceof l?(l)var1:new l.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var14 = null;
         LatLng var13 = null;
         byte var7 = 0;
         boolean var11 = false;
         byte var8 = 0;
         byte var9 = 0;
         boolean var12 = false;
         byte var10 = 0;
         byte var6 = 0;
         float var5;
         byte var15;
         String var16;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var16 = this.getId();
            var3.writeNoException();
            var3.writeString(var16);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            if(var2.readInt() != 0) {
               var13 = LatLng.CREATOR.de(var2);
            }

            this.setPosition(var13);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            LatLng var17 = this.getPosition();
            var3.writeNoException();
            if(var17 != null) {
               var3.writeInt(1);
               var17.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setTitle(var2.readString());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var16 = this.getTitle();
            var3.writeNoException();
            var3.writeString(var16);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setSnippet(var2.readString());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var16 = this.getSnippet();
            var3.writeNoException();
            var3.writeString(var16);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            if(var2.readInt() != 0) {
               var11 = true;
            } else {
               var11 = false;
            }

            this.setDraggable(var11);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var11 = this.isDraggable();
            var3.writeNoException();
            var15 = var6;
            if(var11) {
               var15 = 1;
            }

            var3.writeInt(var15);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.showInfoWindow();
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.hideInfoWindow();
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var11 = this.isInfoWindowShown();
            var3.writeNoException();
            var15 = var7;
            if(var11) {
               var15 = 1;
            }

            var3.writeInt(var15);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            if(var2.readInt() != 0) {
               var11 = true;
            }

            this.setVisible(var11);
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var11 = this.isVisible();
            var3.writeNoException();
            var15 = var8;
            if(var11) {
               var15 = 1;
            }

            var3.writeInt(var15);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var11 = this.h(bA(var2.readStrongBinder()));
            var3.writeNoException();
            var15 = var9;
            if(var11) {
               var15 = 1;
            }

            var3.writeInt(var15);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var1 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.n(com.google.android.gms.dynamic.d.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setAnchor(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var11 = var12;
            if(var2.readInt() != 0) {
               var11 = true;
            }

            this.setFlat(var11);
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var11 = this.isFlat();
            var3.writeNoException();
            var15 = var10;
            if(var11) {
               var15 = 1;
            }

            var3.writeInt(var15);
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setRotation(var2.readFloat());
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var5 = this.getRotation();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setInfoWindowAnchor(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setAlpha(var2.readFloat());
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var5 = this.getAlpha();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            a var18 = (a)var14;
            if(var2.readInt() != 0) {
               var18 = a.CREATOR.dp(var2);
            }

            this.b(var18);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements l {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(a param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public float getAlpha() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(26, var2, var3, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
               var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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

      public float getRotation() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         float var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(23, var2, var3, 0);
            var3.readException();
            var1 = var3.readFloat();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public String getSnippet() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(8, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public String getTitle() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(6, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public boolean h(l param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int hashCodeRemote() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(17, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public void hideInfoWindow() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(12, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean isDraggable() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(10, var3, var4, 0);
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

      public boolean isFlat() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(21, var3, var4, 0);
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

      public boolean isInfoWindowShown() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(13, var3, var4, 0);
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
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(15, var3, var4, 0);
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

      public void n(com.google.android.gms.dynamic.d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setAlpha(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeFloat(var1);
            this.le.transact(25, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setAnchor(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.le.transact(19, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void setDraggable(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setFlat(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowAnchor(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.le.transact(24, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void setPosition(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setRotation(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeFloat(var1);
            this.le.transact(22, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setSnippet(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeString(var1);
            this.le.transact(7, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setTitle(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeString(var1);
            this.le.transact(5, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void showInfoWindow() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.le.transact(11, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
