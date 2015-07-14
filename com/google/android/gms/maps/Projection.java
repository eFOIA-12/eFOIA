package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
   private final IProjectionDelegate alf;

   Projection(IProjectionDelegate var1) {
      this.alf = var1;
   }

   public LatLng fromScreenLocation(Point var1) {
      try {
         LatLng var3 = this.alf.fromScreenLocation(e.k(var1));
         return var3;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public VisibleRegion getVisibleRegion() {
      try {
         VisibleRegion var1 = this.alf.getVisibleRegion();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public Point toScreenLocation(LatLng var1) {
      try {
         Point var3 = (Point)e.f(this.alf.toScreenLocation(var1));
         return var3;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }
}
