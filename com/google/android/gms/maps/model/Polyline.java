package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import java.util.List;

public final class Polyline {
   private final IPolylineDelegate amA;

   public Polyline(IPolylineDelegate var1) {
      this.amA = (IPolylineDelegate)jx.i(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Polyline)) {
         return false;
      } else {
         try {
            boolean var2 = this.amA.equalsRemote(((Polyline)var1).amA);
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }
   }

   public int getColor() {
      try {
         int var1 = this.amA.getColor();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var1 = this.amA.getId();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public List getPoints() {
      try {
         List var1 = this.amA.getPoints();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public float getWidth() {
      try {
         float var1 = this.amA.getWidth();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var1 = this.amA.getZIndex();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var1 = this.amA.hashCodeRemote();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isGeodesic() {
      try {
         boolean var1 = this.amA.isGeodesic();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var1 = this.amA.isVisible();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.amA.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setColor(int var1) {
      try {
         this.amA.setColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setGeodesic(boolean var1) {
      try {
         this.amA.setGeodesic(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setPoints(List var1) {
      try {
         this.amA.setPoints(var1);
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.amA.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setWidth(float var1) {
      try {
         this.amA.setWidth(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.amA.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
