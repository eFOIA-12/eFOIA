package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gq;

public final class AdSize {
   public static final int AUTO_HEIGHT = -2;
   public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
   public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
   public static final int FULL_WIDTH = -1;
   public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
   public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
   public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
   public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
   public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
   private final int li;
   private final int lj;
   private final String lk;

   public AdSize(int var1, int var2) {
      StringBuilder var4 = new StringBuilder();
      String var3;
      if(var1 == -1) {
         var3 = "FULL";
      } else {
         var3 = String.valueOf(var1);
      }

      var4 = var4.append(var3).append("x");
      if(var2 == -2) {
         var3 = "AUTO";
      } else {
         var3 = String.valueOf(var2);
      }

      this(var1, var2, var4.append(var3).append("_as").toString());
   }

   AdSize(int var1, int var2, String var3) {
      if(var1 < 0 && var1 != -1) {
         throw new IllegalArgumentException("Invalid width for AdSize: " + var1);
      } else if(var2 < 0 && var2 != -2) {
         throw new IllegalArgumentException("Invalid height for AdSize: " + var2);
      } else {
         this.li = var1;
         this.lj = var2;
         this.lk = var3;
      }
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof AdSize)) {
            return false;
         }

         AdSize var2 = (AdSize)var1;
         if(this.li != var2.li || this.lj != var2.lj || !this.lk.equals(var2.lk)) {
            return false;
         }
      }

      return true;
   }

   public int getHeight() {
      return this.lj;
   }

   public int getHeightInPixels(Context var1) {
      return this.lj == -2?ay.b(var1.getResources().getDisplayMetrics()):gq.a(var1, this.lj);
   }

   public int getWidth() {
      return this.li;
   }

   public int getWidthInPixels(Context var1) {
      return this.li == -1?ay.a(var1.getResources().getDisplayMetrics()):gq.a(var1, this.li);
   }

   public int hashCode() {
      return this.lk.hashCode();
   }

   public boolean isAutoHeight() {
      return this.lj == -2;
   }

   public boolean isFullWidth() {
      return this.li == -1;
   }

   public String toString() {
      return this.lk;
   }
}
