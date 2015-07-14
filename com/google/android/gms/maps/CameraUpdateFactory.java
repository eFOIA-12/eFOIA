package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
   private static ICameraUpdateFactoryDelegate akl;

   public static void a(ICameraUpdateFactoryDelegate var0) {
      akl = (ICameraUpdateFactoryDelegate)jx.i(var0);
   }

   private static ICameraUpdateFactoryDelegate nB() {
      return (ICameraUpdateFactoryDelegate)jx.b((Object)akl, "CameraUpdateFactory is not initialized");
   }

   public static CameraUpdate newCameraPosition(CameraPosition var0) {
      try {
         CameraUpdate var2 = new CameraUpdate(nB().newCameraPosition(var0));
         return var2;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static CameraUpdate newLatLng(LatLng var0) {
      try {
         CameraUpdate var2 = new CameraUpdate(nB().newLatLng(var0));
         return var2;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static CameraUpdate newLatLngBounds(LatLngBounds var0, int var1) {
      try {
         CameraUpdate var3 = new CameraUpdate(nB().newLatLngBounds(var0, var1));
         return var3;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static CameraUpdate newLatLngBounds(LatLngBounds var0, int var1, int var2, int var3) {
      try {
         CameraUpdate var5 = new CameraUpdate(nB().newLatLngBoundsWithSize(var0, var1, var2, var3));
         return var5;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public static CameraUpdate newLatLngZoom(LatLng var0, float var1) {
      try {
         CameraUpdate var3 = new CameraUpdate(nB().newLatLngZoom(var0, var1));
         return var3;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static CameraUpdate scrollBy(float var0, float var1) {
      try {
         CameraUpdate var2 = new CameraUpdate(nB().scrollBy(var0, var1));
         return var2;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static CameraUpdate zoomBy(float var0) {
      try {
         CameraUpdate var1 = new CameraUpdate(nB().zoomBy(var0));
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static CameraUpdate zoomBy(float var0, Point var1) {
      try {
         CameraUpdate var3 = new CameraUpdate(nB().zoomByWithFocus(var0, var1.x, var1.y));
         return var3;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static CameraUpdate zoomIn() {
      try {
         CameraUpdate var0 = new CameraUpdate(nB().zoomIn());
         return var0;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static CameraUpdate zoomOut() {
      try {
         CameraUpdate var0 = new CameraUpdate(nB().zoomOut());
         return var0;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static CameraUpdate zoomTo(float var0) {
      try {
         CameraUpdate var1 = new CameraUpdate(nB().zoomTo(var0));
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }
}
