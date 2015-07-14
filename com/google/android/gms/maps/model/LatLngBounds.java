package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.g;
import com.google.android.gms.maps.model.h;

public final class LatLngBounds implements SafeParcelable {
   public static final g CREATOR = new g();
   private final int CK;
   public final LatLng northeast;
   public final LatLng southwest;

   LatLngBounds(int var1, LatLng var2, LatLng var3) {
      jx.b((Object)var2, "null southwest");
      jx.b((Object)var3, "null northeast");
      boolean var4;
      if(var3.latitude >= var2.latitude) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.b(var4, "southern latitude exceeds northern latitude (%s > %s)", new Object[]{Double.valueOf(var2.latitude), Double.valueOf(var3.latitude)});
      this.CK = var1;
      this.southwest = var2;
      this.northeast = var3;
   }

   public LatLngBounds(LatLng var1, LatLng var2) {
      this(1, var1, var2);
   }

   private static double b(double var0, double var2) {
      return (var0 - var2 + 360.0D) % 360.0D;
   }

   public static LatLngBounds.Builder builder() {
      return new LatLngBounds.Builder();
   }

   private static double c(double var0, double var2) {
      return (var2 - var0 + 360.0D) % 360.0D;
   }

   private boolean c(double var1) {
      return this.southwest.latitude <= var1 && var1 <= this.northeast.latitude;
   }

   // $FF: synthetic method
   static double d(double var0, double var2) {
      return b(var0, var2);
   }

   private boolean d(double var1) {
      boolean var3 = false;
      if(this.southwest.longitude <= this.northeast.longitude) {
         return this.southwest.longitude <= var1 && var1 <= this.northeast.longitude;
      } else {
         if(this.southwest.longitude <= var1 || var1 <= this.northeast.longitude) {
            var3 = true;
         }

         return var3;
      }
   }

   // $FF: synthetic method
   static double e(double var0, double var2) {
      return c(var0, var2);
   }

   public boolean contains(LatLng var1) {
      return this.c(var1.latitude) && this.d(var1.longitude);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LatLngBounds)) {
            return false;
         }

         LatLngBounds var2 = (LatLngBounds)var1;
         if(!this.southwest.equals(var2.southwest) || !this.northeast.equals(var2.northeast)) {
            return false;
         }
      }

      return true;
   }

   public LatLng getCenter() {
      double var3 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
      double var1 = this.northeast.longitude;
      double var5 = this.southwest.longitude;
      if(var5 <= var1) {
         var1 = (var1 + var5) / 2.0D;
      } else {
         var1 = (var1 + 360.0D + var5) / 2.0D;
      }

      return new LatLng(var3, var1);
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{this.southwest, this.northeast});
   }

   public LatLngBounds including(LatLng var1) {
      double var8 = Math.min(this.southwest.latitude, var1.latitude);
      double var10 = Math.max(this.northeast.latitude, var1.latitude);
      double var4 = this.northeast.longitude;
      double var6 = this.southwest.longitude;
      double var2 = var1.longitude;
      if(!this.d(var2)) {
         if(b(var6, var2) >= c(var4, var2)) {
            var4 = var2;
            var2 = var6;
         }
      } else {
         var2 = var6;
      }

      return new LatLngBounds(new LatLng(var8, var2), new LatLng(var10, var4));
   }

   public String toString() {
      return jv.h(this).a("southwest", this.southwest).a("northeast", this.northeast).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(aa.ob()) {
         h.a(this, var1, var2);
      } else {
         g.a(this, var1, var2);
      }
   }

   public static final class Builder {
      private double amk = Double.POSITIVE_INFINITY;
      private double aml = Double.NEGATIVE_INFINITY;
      private double amm = Double.NaN;
      private double amn = Double.NaN;

      private boolean d(double var1) {
         boolean var3 = false;
         if(this.amm <= this.amn) {
            return this.amm <= var1 && var1 <= this.amn;
         } else {
            if(this.amm <= var1 || var1 <= this.amn) {
               var3 = true;
            }

            return var3;
         }
      }

      public LatLngBounds build() {
         boolean var1;
         if(!Double.isNaN(this.amm)) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "no included points");
         return new LatLngBounds(new LatLng(this.amk, this.amm), new LatLng(this.aml, this.amn));
      }

      public LatLngBounds.Builder include(LatLng var1) {
         this.amk = Math.min(this.amk, var1.latitude);
         this.aml = Math.max(this.aml, var1.latitude);
         double var2 = var1.longitude;
         if(Double.isNaN(this.amm)) {
            this.amm = var2;
            this.amn = var2;
         } else if(!this.d(var2)) {
            if(LatLngBounds.d(this.amm, var2) < LatLngBounds.e(this.amn, var2)) {
               this.amm = var2;
               return this;
            }

            this.amn = var2;
            return this;
         }

         return this;
      }
   }
}
