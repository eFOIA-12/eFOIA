package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.DetectedActivity;

public class DetectedActivityCreator implements Creator {
   public static final int CONTENT_DESCRIPTION = 0;

   static void a(DetectedActivity var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.agb);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.agc);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public DetectedActivity createFromParcel(Parcel var1) {
      int var4 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new DetectedActivity(var2, var3, var4);
      }
   }

   public DetectedActivity[] newArray(int var1) {
      return new DetectedActivity[var1];
   }
}
