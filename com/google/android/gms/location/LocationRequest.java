package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.location.d;

public final class LocationRequest implements SafeParcelable {
   public static final d CREATOR = new d();
   public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
   public static final int PRIORITY_HIGH_ACCURACY = 100;
   public static final int PRIORITY_LOW_POWER = 104;
   public static final int PRIORITY_NO_POWER = 105;
   private final int CK;
   boolean Wg;
   long age;
   long agr;
   long ags;
   int agt;
   float agu;
   long agv;
   int mPriority;

   public LocationRequest() {
      this.CK = 1;
      this.mPriority = 102;
      this.agr = 3600000L;
      this.ags = 600000L;
      this.Wg = false;
      this.age = Long.MAX_VALUE;
      this.agt = Integer.MAX_VALUE;
      this.agu = 0.0F;
      this.agv = 0L;
   }

   LocationRequest(int var1, int var2, long var3, long var5, boolean var7, long var8, int var10, float var11, long var12) {
      this.CK = var1;
      this.mPriority = var2;
      this.agr = var3;
      this.ags = var5;
      this.Wg = var7;
      this.age = var8;
      this.agt = var10;
      this.agu = var11;
      this.agv = var12;
   }

   private static void a(float var0) {
      if(var0 < 0.0F) {
         throw new IllegalArgumentException("invalid displacement: " + var0);
      }
   }

   public static LocationRequest create() {
      return new LocationRequest();
   }

   private static void ey(int var0) {
      switch(var0) {
      case 100:
      case 102:
      case 104:
      case 105:
         return;
      case 101:
      case 103:
      default:
         throw new IllegalArgumentException("invalid quality: " + var0);
      }
   }

   public static String ez(int var0) {
      switch(var0) {
      case 100:
         return "PRIORITY_HIGH_ACCURACY";
      case 101:
      case 103:
      default:
         return "???";
      case 102:
         return "PRIORITY_BALANCED_POWER_ACCURACY";
      case 104:
         return "PRIORITY_LOW_POWER";
      case 105:
         return "PRIORITY_NO_POWER";
      }
   }

   private static void v(long var0) {
      if(var0 < 0L) {
         throw new IllegalArgumentException("invalid interval: " + var0);
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LocationRequest)) {
            return false;
         }

         LocationRequest var2 = (LocationRequest)var1;
         if(this.mPriority != var2.mPriority || this.agr != var2.agr || this.ags != var2.ags || this.Wg != var2.Wg || this.age != var2.age || this.agt != var2.agt || this.agu != var2.agu) {
            return false;
         }
      }

      return true;
   }

   public long getExpirationTime() {
      return this.age;
   }

   public long getFastestInterval() {
      return this.ags;
   }

   public long getInterval() {
      return this.agr;
   }

   public int getNumUpdates() {
      return this.agt;
   }

   public int getPriority() {
      return this.mPriority;
   }

   public float getSmallestDisplacement() {
      return this.agu;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.mPriority), Long.valueOf(this.agr), Long.valueOf(this.ags), Boolean.valueOf(this.Wg), Long.valueOf(this.age), Integer.valueOf(this.agt), Float.valueOf(this.agu)});
   }

   public LocationRequest setExpirationDuration(long var1) {
      long var3 = SystemClock.elapsedRealtime();
      if(var1 > Long.MAX_VALUE - var3) {
         this.age = Long.MAX_VALUE;
      } else {
         this.age = var3 + var1;
      }

      if(this.age < 0L) {
         this.age = 0L;
      }

      return this;
   }

   public LocationRequest setExpirationTime(long var1) {
      this.age = var1;
      if(this.age < 0L) {
         this.age = 0L;
      }

      return this;
   }

   public LocationRequest setFastestInterval(long var1) {
      v(var1);
      this.Wg = true;
      this.ags = var1;
      return this;
   }

   public LocationRequest setInterval(long var1) {
      v(var1);
      this.agr = var1;
      if(!this.Wg) {
         this.ags = (long)((double)this.agr / 6.0D);
      }

      return this;
   }

   public LocationRequest setNumUpdates(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("invalid numUpdates: " + var1);
      } else {
         this.agt = var1;
         return this;
      }
   }

   public LocationRequest setPriority(int var1) {
      ey(var1);
      this.mPriority = var1;
      return this;
   }

   public LocationRequest setSmallestDisplacement(float var1) {
      a(var1);
      this.agu = var1;
      return this;
   }

   public String toString() {
      StringBuilder var5 = new StringBuilder();
      var5.append("Request[").append(ez(this.mPriority));
      if(this.mPriority != 105) {
         var5.append(" requested=");
         var5.append(this.agr + "ms");
      }

      var5.append(" fastest=");
      var5.append(this.ags + "ms");
      if(this.age != Long.MAX_VALUE) {
         long var1 = this.age;
         long var3 = SystemClock.elapsedRealtime();
         var5.append(" expireIn=");
         var5.append(var1 - var3 + "ms");
      }

      if(this.agt != Integer.MAX_VALUE) {
         var5.append(" num=").append(this.agt);
      }

      var5.append(']');
      return var5.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
