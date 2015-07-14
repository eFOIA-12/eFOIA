package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class Circle {
   private final com.google.android.gms.maps.model.internal.h alR;

   public Circle(com.google.android.gms.maps.model.internal.h var1) {
      this.alR = (com.google.android.gms.maps.model.internal.h)jx.i(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Circle)) {
         return false;
      } else {
         try {
            boolean var2 = this.alR.a(((Circle)var1).alR);
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }
   }

   public LatLng getCenter() {
      try {
         LatLng var1 = this.alR.getCenter();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public int getFillColor() {
      try {
         int var1 = this.alR.getFillColor();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var1 = this.alR.getId();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public double getRadius() {
      try {
         double var1 = this.alR.getRadius();
         return var1;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public int getStrokeColor() {
      try {
         int var1 = this.alR.getStrokeColor();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getStrokeWidth() {
      try {
         float var1 = this.alR.getStrokeWidth();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public float getZIndex() {
      try {
         float var1 = this.alR.getZIndex();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var1 = this.alR.hashCodeRemote();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var1 = this.alR.isVisible();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.alR.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setCenter(LatLng var1) {
      try {
         this.alR.setCenter(var1);
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setFillColor(int var1) {
      try {
         this.alR.setFillColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setRadius(double var1) {
      try {
         this.alR.setRadius(var1);
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public void setStrokeColor(int var1) {
      try {
         this.alR.setStrokeColor(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setStrokeWidth(float var1) {
      try {
         this.alR.setStrokeWidth(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.alR.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.alR.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
