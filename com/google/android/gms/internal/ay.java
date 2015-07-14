package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.az;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gq;

@ey
public final class ay implements SafeParcelable {
   public static final az CREATOR = new az();
   public final int height;
   public final int heightPixels;
   public final String op;
   public final boolean oq;
   public final ay[] or;
   public final int versionCode;
   public final int width;
   public final int widthPixels;

   public ay() {
      this(2, "interstitial_mb", 0, 0, true, 0, 0, (ay[])null);
   }

   ay(int var1, String var2, int var3, int var4, boolean var5, int var6, int var7, ay[] var8) {
      this.versionCode = var1;
      this.op = var2;
      this.height = var3;
      this.heightPixels = var4;
      this.oq = var5;
      this.width = var6;
      this.widthPixels = var7;
      this.or = var8;
   }

   public ay(Context var1, AdSize var2) {
      this(var1, new AdSize[]{var2});
   }

   public ay(Context var1, AdSize[] var2) {
      byte var7 = 0;
      super();
      AdSize var8 = var2[0];
      this.versionCode = 2;
      this.oq = false;
      this.width = var8.getWidth();
      this.height = var8.getHeight();
      boolean var3;
      if(this.width == -1) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if(this.height == -2) {
         var4 = true;
      } else {
         var4 = false;
      }

      DisplayMetrics var9 = var1.getResources().getDisplayMetrics();
      int var5;
      if(var3) {
         this.widthPixels = a(var9);
         var5 = (int)((float)this.widthPixels / var9.density);
      } else {
         var5 = this.width;
         this.widthPixels = gq.a(var9, this.width);
      }

      int var6;
      if(var4) {
         var6 = c(var9);
      } else {
         var6 = this.height;
      }

      this.heightPixels = gq.a(var9, var6);
      if(!var3 && !var4) {
         this.op = var8.toString();
      } else {
         this.op = var5 + "x" + var6 + "_as";
      }

      if(var2.length > 1) {
         this.or = new ay[var2.length];

         for(int var10 = var7; var10 < var2.length; ++var10) {
            this.or[var10] = new ay(var1, var2[var10]);
         }
      } else {
         this.or = null;
      }

   }

   public ay(ay var1, ay[] var2) {
      this(2, var1.op, var1.height, var1.heightPixels, var1.oq, var1.width, var1.widthPixels, var2);
   }

   public static int a(DisplayMetrics var0) {
      return var0.widthPixels;
   }

   public static int b(DisplayMetrics var0) {
      return (int)((float)c(var0) * var0.density);
   }

   private static int c(DisplayMetrics var0) {
      int var1 = (int)((float)var0.heightPixels / var0.density);
      return var1 <= 400?32:(var1 <= 720?50:90);
   }

   public AdSize bh() {
      return com.google.android.gms.ads.a.a(this.width, this.height, this.op);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      az.a(this, var1, var2);
   }
}
