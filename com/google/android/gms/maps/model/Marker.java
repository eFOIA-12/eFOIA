package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class Marker {
   private final com.google.android.gms.maps.model.internal.l amo;

   public Marker(com.google.android.gms.maps.model.internal.l var1) {
      this.amo = (com.google.android.gms.maps.model.internal.l)jx.i(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Marker)) {
         return false;
      } else {
         try {
            boolean var2 = this.amo.h(((Marker)var1).amo);
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }
   }

   public float getAlpha() {
      try {
         float var1 = this.amo.getAlpha();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var1 = this.amo.getId();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public LatLng getPosition() {
      try {
         LatLng var1 = this.amo.getPosition();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public float getRotation() {
      try {
         float var1 = this.amo.getRotation();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getSnippet() {
      try {
         String var1 = this.amo.getSnippet();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public String getTitle() {
      try {
         String var1 = this.amo.getTitle();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public int hashCode() {
      try {
         int var1 = this.amo.hashCodeRemote();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void hideInfoWindow() {
      try {
         this.amo.hideInfoWindow();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean isDraggable() {
      try {
         boolean var1 = this.amo.isDraggable();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isFlat() {
      try {
         boolean var1 = this.amo.isFlat();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isInfoWindowShown() {
      try {
         boolean var1 = this.amo.isInfoWindowShown();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var1 = this.amo.isVisible();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.amo.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setAlpha(float var1) {
      try {
         this.amo.setAlpha(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setAnchor(float var1, float var2) {
      try {
         this.amo.setAnchor(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setDraggable(boolean var1) {
      try {
         this.amo.setDraggable(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setFlat(boolean var1) {
      try {
         this.amo.setFlat(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setIcon(BitmapDescriptor var1) {
      try {
         this.amo.n(var1.nA());
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setInfoWindowAnchor(float var1, float var2) {
      try {
         this.amo.setInfoWindowAnchor(var1, var2);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setPosition(LatLng var1) {
      try {
         this.amo.setPosition(var1);
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setRotation(float var1) {
      try {
         this.amo.setRotation(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setSnippet(String var1) {
      try {
         this.amo.setSnippet(var1);
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setTitle(String var1) {
      try {
         this.amo.setTitle(var1);
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.amo.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void showInfoWindow() {
      try {
         this.amo.showInfoWindow();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }
}
