package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.ey;
import java.util.Date;
import java.util.HashSet;

@ey
public final class dg {
   public static int a(AdRequest.ErrorCode var0) {
      switch(null.rc[var0.ordinal()]) {
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
         return 3;
      default:
         return 0;
      }
   }

   public static AdSize b(ay var0) {
      int var1 = 0;

      for(AdSize[] var2 = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER}; var1 < var2.length; ++var1) {
         if(var2[var1].getWidth() == var0.width && var2[var1].getHeight() == var0.height) {
            return var2[var1];
         }
      }

      return new AdSize(com.google.android.gms.ads.a.a(var0.width, var0.height, var0.op));
   }

   public static MediationAdRequest d(av var0) {
      HashSet var1;
      if(var0.of != null) {
         var1 = new HashSet(var0.of);
      } else {
         var1 = null;
      }

      return new MediationAdRequest(new Date(var0.od), l(var0.oe), var1, var0.og, var0.ol);
   }

   public static AdRequest.Gender l(int var0) {
      switch(var0) {
      case 1:
         return AdRequest.Gender.MALE;
      case 2:
         return AdRequest.Gender.FEMALE;
      default:
         return AdRequest.Gender.UNKNOWN;
      }
   }
}
