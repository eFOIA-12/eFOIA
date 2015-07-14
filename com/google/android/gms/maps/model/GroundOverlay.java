package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class GroundOverlay {
   private final com.google.android.gms.maps.model.internal.i alZ;

   public GroundOverlay(com.google.android.gms.maps.model.internal.i var1) {
      this.alZ = (com.google.android.gms.maps.model.internal.i)jx.i(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof GroundOverlay)) {
         return false;
      } else {
         try {
            boolean var2 = this.alZ.a(((GroundOverlay)var1).alZ);
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }
   }

   public float getBearing() {
      try {
         float var1 = this.alZ.getBearing();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public LatLngBounds getBounds() {
      try {
         LatLngBounds var1 = this.alZ.getBounds();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public float getHeight() {
      try {
         float var1 = this.alZ.getHeight();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var1 = this.alZ.getId();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public LatLng getPosition() {
      try {
         LatLng var1 = this.alZ.getPosition();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public float getTransparency() {
      try {
         float var1 = this.alZ.getTransparency();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getWidth() {
      try {
         float var1 = this.alZ.getWidth();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var1 = this.alZ.getZIndex();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var1 = this.alZ.hashCodeRemote();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var1 = this.alZ.isVisible();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.alZ.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setBearing(float var1) {
      try {
         this.alZ.setBearing(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setDimensions(float var1) {
      try {
         this.alZ.setDimensions(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setDimensions(float var1, float var2) {
      try {
         this.alZ.a(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setImage(BitmapDescriptor var1) {
      try {
         this.alZ.m(var1.nA());
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setPosition(LatLng var1) {
      try {
         this.alZ.setPosition(var1);
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setPositionFromBounds(LatLngBounds var1) {
      try {
         this.alZ.setPositionFromBounds(var1);
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setTransparency(float var1) {
      try {
         this.alZ.setTransparency(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.alZ.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.alZ.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
