package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.DetectedActivityCreator;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
   public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
   public static final int IN_VEHICLE = 0;
   public static final int ON_BICYCLE = 1;
   public static final int ON_FOOT = 2;
   public static final int RUNNING = 8;
   public static final int STILL = 3;
   public static final int TILTING = 5;
   public static final int UNKNOWN = 4;
   public static final int WALKING = 7;
   public static final Comparator aga = new Comparator() {
      public int a(DetectedActivity var1, DetectedActivity var2) {
         int var4 = Integer.valueOf(var2.getConfidence()).compareTo(Integer.valueOf(var1.getConfidence()));
         int var3 = var4;
         if(var4 == 0) {
            var3 = Integer.valueOf(var1.getType()).compareTo(Integer.valueOf(var2.getType()));
         }

         return var3;
      }

      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.a((DetectedActivity)var1, (DetectedActivity)var2);
      }
   };
   private final int CK;
   int agb;
   int agc;

   public DetectedActivity(int var1, int var2) {
      this.CK = 1;
      this.agb = var1;
      this.agc = var2;
   }

   public DetectedActivity(int var1, int var2, int var3) {
      this.CK = var1;
      this.agb = var2;
      this.agc = var3;
   }

   private int ev(int var1) {
      int var2 = var1;
      if(var1 > 9) {
         var2 = 4;
      }

      return var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getConfidence() {
      return this.agc;
   }

   public int getType() {
      return this.ev(this.agb);
   }

   public int getVersionCode() {
      return this.CK;
   }

   public String toString() {
      return "DetectedActivity [type=" + this.getType() + ", confidence=" + this.agc + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      DetectedActivityCreator.a(this, var1, var2);
   }
}
