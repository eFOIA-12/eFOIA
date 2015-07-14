package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.w;
import com.google.android.gms.maps.model.x;

public final class TileOverlayOptions implements SafeParcelable {
   public static final w CREATOR = new w();
   private final int CK;
   private float alX;
   private boolean alY = true;
   private com.google.android.gms.maps.model.internal.o amD;
   private TileProvider amE;
   private boolean amF = true;

   public TileOverlayOptions() {
      this.CK = 1;
   }

   TileOverlayOptions(int var1, IBinder var2, boolean var3, float var4, boolean var5) {
      this.CK = var1;
      this.amD = com.google.android.gms.maps.model.internal.o.bE(var2);
      TileProvider var6;
      if(this.amD == null) {
         var6 = null;
      } else {
         var6 = new TileProvider() {
            private final com.google.android.gms.maps.model.internal.o amG;

            {
               this.amG = TileOverlayOptions.this.amD;
            }

            public Tile getTile(int var1, int var2, int var3) {
               try {
                  Tile var4 = this.amG.getTile(var1, var2, var3);
                  return var4;
               } catch (RemoteException var5) {
                  return null;
               }
            }
         };
      }

      this.amE = var6;
      this.alY = var3;
      this.alX = var4;
      this.amF = var5;
   }

   public int describeContents() {
      return 0;
   }

   public TileOverlayOptions fadeIn(boolean var1) {
      this.amF = var1;
      return this;
   }

   public boolean getFadeIn() {
      return this.amF;
   }

   public TileProvider getTileProvider() {
      return this.amE;
   }

   int getVersionCode() {
      return this.CK;
   }

   public float getZIndex() {
      return this.alX;
   }

   public boolean isVisible() {
      return this.alY;
   }

   IBinder og() {
      return this.amD.asBinder();
   }

   public TileOverlayOptions tileProvider(final TileProvider var1) {
      this.amE = var1;
      com.google.android.gms.maps.model.internal.o var2;
      if(this.amE == null) {
         var2 = null;
      } else {
         var2 = new com.google.android.gms.maps.model.internal.o() {
            public Tile getTile(int var1x, int var2, int var3) {
               return var1.getTile(var1x, var2, var3);
            }
         };
      }

      this.amD = var2;
      return this;
   }

   public TileOverlayOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         x.a(this, var1, var2);
      } else {
         w.a(this, var1, var2);
      }
   }

   public TileOverlayOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
