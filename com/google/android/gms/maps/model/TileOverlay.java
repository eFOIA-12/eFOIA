package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class TileOverlay {
   private final com.google.android.gms.maps.model.internal.n amC;

   public TileOverlay(com.google.android.gms.maps.model.internal.n var1) {
      this.amC = (com.google.android.gms.maps.model.internal.n)jx.i(var1);
   }

   public void clearTileCache() {
      try {
         this.amC.clearTileCache();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof TileOverlay)) {
         return false;
      } else {
         try {
            boolean var2 = this.amC.a(((TileOverlay)var1).amC);
            return var2;
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }
      }
   }

   public boolean getFadeIn() {
      try {
         boolean var1 = this.amC.getFadeIn();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public String getId() {
      try {
         String var1 = this.amC.getId();
         return var1;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public float getZIndex() {
      try {
         float var1 = this.amC.getZIndex();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public int hashCode() {
      try {
         int var1 = this.amC.hashCodeRemote();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public boolean isVisible() {
      try {
         boolean var1 = this.amC.isVisible();
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void remove() {
      try {
         this.amC.remove();
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public void setFadeIn(boolean var1) {
      try {
         this.amC.setFadeIn(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setVisible(boolean var1) {
      try {
         this.amC.setVisible(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public void setZIndex(float var1) {
      try {
         this.amC.setZIndex(var1);
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
