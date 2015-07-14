package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.location.ActivityRecognitionResultCreator;
import com.google.android.gms.location.DetectedActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
   public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
   public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
   private final int CK;
   List afX;
   long afY;
   long afZ;

   public ActivityRecognitionResult(int var1, List var2, long var3, long var5) {
      this.CK = 1;
      this.afX = var2;
      this.afY = var3;
      this.afZ = var5;
   }

   public ActivityRecognitionResult(DetectedActivity var1, long var2, long var4) {
      this(Collections.singletonList(var1), var2, var4);
   }

   public ActivityRecognitionResult(List var1, long var2, long var4) {
      boolean var7 = false;
      super();
      boolean var6;
      if(var1 != null && var1.size() > 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      jx.b(var6, "Must have at least 1 detected activity");
      var6 = var7;
      if(var2 > 0L) {
         var6 = var7;
         if(var4 > 0L) {
            var6 = true;
         }
      }

      jx.b(var6, "Must set times");
      this.CK = 1;
      this.afX = var1;
      this.afY = var2;
      this.afZ = var4;
   }

   public static ActivityRecognitionResult extractResult(Intent var0) {
      if(!hasResult(var0)) {
         return null;
      } else {
         Object var2 = var0.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
         if(var2 instanceof byte[]) {
            Parcel var1 = Parcel.obtain();
            var1.unmarshall((byte[])((byte[])var2), 0, ((byte[])((byte[])var2)).length);
            var1.setDataPosition(0);
            return CREATOR.createFromParcel(var1);
         } else {
            return var2 instanceof ActivityRecognitionResult?(ActivityRecognitionResult)var2:null;
         }
      }
   }

   public static boolean hasResult(Intent var0) {
      return var0 == null?false:var0.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
   }

   public int describeContents() {
      return 0;
   }

   public int getActivityConfidence(int var1) {
      Iterator var2 = this.afX.iterator();

      DetectedActivity var3;
      do {
         if(!var2.hasNext()) {
            return 0;
         }

         var3 = (DetectedActivity)var2.next();
      } while(var3.getType() != var1);

      return var3.getConfidence();
   }

   public long getElapsedRealtimeMillis() {
      return this.afZ;
   }

   public DetectedActivity getMostProbableActivity() {
      return (DetectedActivity)this.afX.get(0);
   }

   public List getProbableActivities() {
      return this.afX;
   }

   public long getTime() {
      return this.afY;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public String toString() {
      return "ActivityRecognitionResult [probableActivities=" + this.afX + ", timeMillis=" + this.afY + ", elapsedRealtimeMillis=" + this.afZ + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      ActivityRecognitionResultCreator.a(this, var1, var2);
   }
}
