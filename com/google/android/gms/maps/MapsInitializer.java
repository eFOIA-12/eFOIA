package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.internal.x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
   public static void a(com.google.android.gms.maps.internal.c var0) {
      try {
         CameraUpdateFactory.a(var0.nW());
         BitmapDescriptorFactory.a(var0.nX());
      } catch (RemoteException var1) {
         throw new RuntimeRemoteException(var1);
      }
   }

   public static int initialize(Context var0) {
      jx.i(var0);

      com.google.android.gms.maps.internal.c var2;
      try {
         var2 = x.S(var0);
      } catch (GooglePlayServicesNotAvailableException var1) {
         return var1.errorCode;
      }

      a(var2);
      return 0;
   }
}
