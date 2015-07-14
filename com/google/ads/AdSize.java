package com.google.ads;

import android.content.Context;

@Deprecated
public final class AdSize {
   public static final int AUTO_HEIGHT = -2;
   public static final AdSize BANNER = new AdSize(320, 50, "mb");
   public static final int FULL_WIDTH = -1;
   public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
   public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
   public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
   public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
   public static final int LANDSCAPE_AD_HEIGHT = 32;
   public static final int LARGE_AD_HEIGHT = 90;
   public static final int PORTRAIT_AD_HEIGHT = 50;
   public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
   private final com.google.android.gms.ads.AdSize c;

   public AdSize(int var1, int var2) {
      this(new com.google.android.gms.ads.AdSize(var1, var2));
   }

   private AdSize(int var1, int var2, String var3) {
      this(new com.google.android.gms.ads.AdSize(var1, var2));
   }

   public AdSize(com.google.android.gms.ads.AdSize var1) {
      this.c = var1;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof AdSize)) {
         return false;
      } else {
         AdSize var2 = (AdSize)var1;
         return this.c.equals(var2.c);
      }
   }

   public AdSize findBestSize(AdSize... var1) {
      AdSize var11 = null;
      AdSize var12 = null;
      if(var1 != null) {
         float var2 = 0.0F;
         int var6 = this.getWidth();
         int var7 = this.getHeight();
         int var8 = var1.length;
         int var5 = 0;

         while(true) {
            var12 = var11;
            if(var5 >= var8) {
               break;
            }

            float var3;
            label22: {
               var12 = var1[var5];
               int var9 = var12.getWidth();
               int var10 = var12.getHeight();
               if(this.isSizeAppropriate(var9, var10)) {
                  float var4 = (float)(var9 * var10) / (float)(var6 * var7);
                  var3 = var4;
                  if(var4 > 1.0F) {
                     var3 = 1.0F / var4;
                  }

                  if(var3 > var2) {
                     var11 = var12;
                     break label22;
                  }
               }

               var3 = var2;
            }

            ++var5;
            var2 = var3;
         }
      }

      return var12;
   }

   public int getHeight() {
      return this.c.getHeight();
   }

   public int getHeightInPixels(Context var1) {
      return this.c.getHeightInPixels(var1);
   }

   public int getWidth() {
      return this.c.getWidth();
   }

   public int getWidthInPixels(Context var1) {
      return this.c.getWidthInPixels(var1);
   }

   public int hashCode() {
      return this.c.hashCode();
   }

   public boolean isAutoHeight() {
      return this.c.isAutoHeight();
   }

   public boolean isCustomAdSize() {
      return false;
   }

   public boolean isFullWidth() {
      return this.c.isFullWidth();
   }

   public boolean isSizeAppropriate(int var1, int var2) {
      int var3 = this.getWidth();
      int var4 = this.getHeight();
      return (float)var1 <= (float)var3 * 1.25F && (float)var1 >= (float)var3 * 0.8F && (float)var2 <= (float)var4 * 1.25F && (float)var2 >= (float)var4 * 0.8F;
   }

   public String toString() {
      return this.c.toString();
   }
}
