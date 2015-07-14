package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public final class ja {
   public static Bitmap a(Bitmap var0) {
      int var3 = 0;
      if(var0 == null) {
         return null;
      } else {
         int var4 = var0.getWidth();
         int var1 = var0.getHeight();
         int var2;
         if(var4 >= var1) {
            var3 = var4 / 2 - var1 / 2;
            var2 = 0;
         } else {
            var2 = var1 / 2 - var4 / 2;
            var1 = var4;
         }

         Bitmap var5 = Bitmap.createBitmap(var1, var1, Config.ARGB_8888);
         Canvas var6 = new Canvas(var5);
         Paint var7 = new Paint(1);
         var7.setColor(-16777216);
         var6.drawCircle((float)(var1 / 2), (float)(var1 / 2), (float)(var1 / 2), var7);
         var7.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
         var6.drawBitmap(var0, (float)var3, (float)var2, var7);
         return var5;
      }
   }

   private static Bitmap a(Drawable var0) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof BitmapDrawable) {
         return ((BitmapDrawable)var0).getBitmap();
      } else {
         Bitmap var1 = Bitmap.createBitmap(var0.getIntrinsicWidth(), var0.getIntrinsicHeight(), Config.ARGB_8888);
         Canvas var2 = new Canvas(var1);
         var0.setBounds(0, 0, var2.getWidth(), var2.getHeight());
         var0.draw(var2);
         return var1;
      }
   }

   public static Drawable a(Resources var0, Drawable var1) {
      return new BitmapDrawable(var0, a(a(var1)));
   }
}
