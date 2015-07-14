package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class BitmapDescriptorFactory {
   public static final float HUE_AZURE = 210.0F;
   public static final float HUE_BLUE = 240.0F;
   public static final float HUE_CYAN = 180.0F;
   public static final float HUE_GREEN = 120.0F;
   public static final float HUE_MAGENTA = 300.0F;
   public static final float HUE_ORANGE = 30.0F;
   public static final float HUE_RED = 0.0F;
   public static final float HUE_ROSE = 330.0F;
   public static final float HUE_VIOLET = 270.0F;
   public static final float HUE_YELLOW = 60.0F;
   private static com.google.android.gms.maps.model.internal.g alM;

   public static void a(com.google.android.gms.maps.model.internal.g var0) {
      if(alM == null) {
         alM = (com.google.android.gms.maps.model.internal.g)jx.i(var0);
      }
   }

   public static BitmapDescriptor defaultMarker() {
      try {
         BitmapDescriptor var0 = new BitmapDescriptor(oc().ok());
         return var0;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static BitmapDescriptor defaultMarker(float var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(oc().c(var0));
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static BitmapDescriptor fromAsset(String var0) {
      try {
         BitmapDescriptor var2 = new BitmapDescriptor(oc().cd(var0));
         return var2;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static BitmapDescriptor fromBitmap(Bitmap var0) {
      try {
         BitmapDescriptor var2 = new BitmapDescriptor(oc().b(var0));
         return var2;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static BitmapDescriptor fromFile(String var0) {
      try {
         BitmapDescriptor var2 = new BitmapDescriptor(oc().ce(var0));
         return var2;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static BitmapDescriptor fromPath(String var0) {
      try {
         BitmapDescriptor var2 = new BitmapDescriptor(oc().cf(var0));
         return var2;
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static BitmapDescriptor fromResource(int var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(oc().fo(var0));
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   private static com.google.android.gms.maps.model.internal.g oc() {
      return (com.google.android.gms.maps.model.internal.g)jx.b((Object)alM, "IBitmapDescriptorFactory is not initialized");
   }
}
