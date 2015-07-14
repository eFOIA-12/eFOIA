package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.no;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class nn implements SafeParcelable, Geofence {
   public static final no CREATOR = new no();
   private final int CK;
   private final String Zt;
   private final int agd;
   private final short agf;
   private final double agg;
   private final double agh;
   private final float agi;
   private final int agj;
   private final int agk;
   private final long ahl;

   public nn(int var1, String var2, int var3, short var4, double var5, double var7, float var9, long var10, int var12, int var13) {
      cb(var2);
      b(var9);
      a(var5, var7);
      var3 = eH(var3);
      this.CK = var1;
      this.agf = var4;
      this.Zt = var2;
      this.agg = var5;
      this.agh = var7;
      this.agi = var9;
      this.ahl = var10;
      this.agd = var3;
      this.agj = var12;
      this.agk = var13;
   }

   public nn(String var1, int var2, short var3, double var4, double var6, float var8, long var9, int var11, int var12) {
      this(1, var1, var2, var3, var4, var6, var8, var9, var11, var12);
   }

   private static void a(double var0, double var2) {
      if(var0 <= 90.0D && var0 >= -90.0D) {
         if(var2 > 180.0D || var2 < -180.0D) {
            throw new IllegalArgumentException("invalid longitude: " + var2);
         }
      } else {
         throw new IllegalArgumentException("invalid latitude: " + var0);
      }
   }

   private static void b(float var0) {
      if(var0 <= 0.0F) {
         throw new IllegalArgumentException("invalid radius: " + var0);
      }
   }

   private static void cb(String var0) {
      if(var0 == null || var0.length() > 100) {
         throw new IllegalArgumentException("requestId is null or too long: " + var0);
      }
   }

   private static int eH(int var0) {
      int var1 = var0 & 7;
      if(var1 == 0) {
         throw new IllegalArgumentException("No supported transition specified: " + var0);
      } else {
         return var1;
      }
   }

   private static String eI(int var0) {
      switch(var0) {
      case 1:
         return "CIRCLE";
      default:
         return null;
      }
   }

   public static nn h(byte[] var0) {
      Parcel var1 = Parcel.obtain();
      var1.unmarshall(var0, 0, var0.length);
      var1.setDataPosition(0);
      nn var2 = CREATOR.cN(var1);
      var1.recycle();
      return var2;
   }

   public int describeContents() {
      no var1 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(!(var1 instanceof nn)) {
            return false;
         }

         nn var2 = (nn)var1;
         if(this.agi != var2.agi) {
            return false;
         }

         if(this.agg != var2.agg) {
            return false;
         }

         if(this.agh != var2.agh) {
            return false;
         }

         if(this.agf != var2.agf) {
            return false;
         }
      }

      return true;
   }

   public long getExpirationTime() {
      return this.ahl;
   }

   public double getLatitude() {
      return this.agg;
   }

   public double getLongitude() {
      return this.agh;
   }

   public int getNotificationResponsiveness() {
      return this.agj;
   }

   public String getRequestId() {
      return this.Zt;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      long var2 = Double.doubleToLongBits(this.agg);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.agh);
      return ((((var1 + 31) * 31 + (int)(var2 ^ var2 >>> 32)) * 31 + Float.floatToIntBits(this.agi)) * 31 + this.agf) * 31 + this.agd;
   }

   public short nn() {
      return this.agf;
   }

   public float no() {
      return this.agi;
   }

   public int np() {
      return this.agd;
   }

   public int nq() {
      return this.agk;
   }

   public String toString() {
      return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{eI(this.agf), this.Zt, Integer.valueOf(this.agd), Double.valueOf(this.agg), Double.valueOf(this.agh), Float.valueOf(this.agi), Integer.valueOf(this.agj / 1000), Integer.valueOf(this.agk), Long.valueOf(this.ahl)});
   }

   public void writeToParcel(Parcel var1, int var2) {
      no var3 = CREATOR;
      no.a(this, var1, var2);
   }
}
