package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(ActivityRecognitionResult var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.afX, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.afY);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.afZ);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public ActivityRecognitionResult createFromParcel(Parcel var1) {
      long var5 = 0L;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      ArrayList var9 = null;
      long var7 = 0L;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DetectedActivity.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ActivityRecognitionResult(var2, var9, var7, var5);
      }
   }

   public ActivityRecognitionResult[] newArray(int var1) {
      return new ActivityRecognitionResult[var1];
   }
}
