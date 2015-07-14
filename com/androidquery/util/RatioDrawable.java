package com.androidquery.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public class RatioDrawable extends BitmapDrawable {
   private boolean adjusted;
   private float anchor;
   private Matrix m;
   private float ratio;
   private WeakReference ref;
   private int w;

   public RatioDrawable(Resources var1, Bitmap var2, ImageView var3, float var4, float var5) {
      super(var1, var2);
      this.ref = new WeakReference(var3);
      this.ratio = var4;
      this.anchor = var5;
      var3.setScaleType(ScaleType.MATRIX);
      var3.setImageMatrix(new Matrix());
      this.adjust(var3, var2, false);
   }

   private void adjust(ImageView var1, Bitmap var2, boolean var3) {
      int var4 = this.getWidth(var1);
      if(var4 > 0) {
         var4 = this.targetHeight(var2.getWidth(), var2.getHeight(), var4) + var1.getPaddingTop() + var1.getPaddingBottom();
         LayoutParams var5 = var1.getLayoutParams();
         if(var5 != null) {
            if(var4 != var5.height) {
               var5.height = var4;
               var1.setLayoutParams(var5);
            }

            if(var3) {
               this.adjusted = true;
               return;
            }
         }
      }

   }

   private void draw(Canvas var1, ImageView var2, Bitmap var3) {
      Matrix var6 = this.getMatrix(var2, var3);
      if(var6 != null) {
         int var4 = var2.getPaddingTop() + var2.getPaddingBottom();
         int var5 = var2.getPaddingLeft() + var2.getPaddingRight();
         if(var4 > 0 || var5 > 0) {
            var1.clipRect(0, 0, var2.getWidth() - var5, var2.getHeight() - var4);
         }

         var1.drawBitmap(var3, var6, this.getPaint());
      }

      if(!this.adjusted) {
         this.adjust(var2, var3, true);
      }

   }

   private Matrix getMatrix(ImageView var1, Bitmap var2) {
      int var6 = var2.getWidth();
      if(this.m != null && var6 == this.w) {
         return this.m;
      } else {
         int var7 = var2.getHeight();
         int var8 = this.getWidth(var1);
         int var9 = this.targetHeight(var6, var7, var8);
         if(var6 > 0 && var7 > 0 && var8 > 0 && var9 > 0) {
            if(this.m == null || var6 != this.w) {
               float var3 = 0.0F;
               float var4 = 0.0F;
               this.m = new Matrix();
               float var5;
               if(var6 * var9 >= var8 * var7) {
                  var5 = (float)var9 / (float)var7;
                  var3 = ((float)var8 - (float)var6 * var5) * 0.5F;
               } else {
                  var5 = (float)var8 / (float)var6;
                  var4 = this.getYOffset(var6, var7);
                  var4 = ((float)var9 - (float)var7 * var5) * var4;
               }

               this.m.setScale(var5, var5);
               this.m.postTranslate(var3, var4);
               this.w = var6;
            }

            return this.m;
         } else {
            return null;
         }
      }
   }

   private int getWidth(ImageView var1) {
      int var3 = 0;
      LayoutParams var4 = var1.getLayoutParams();
      if(var4 != null) {
         var3 = var4.width;
      }

      int var2 = var3;
      if(var3 <= 0) {
         var2 = var1.getWidth();
      }

      var3 = var2;
      if(var2 > 0) {
         var3 = var2 - var1.getPaddingLeft() - var1.getPaddingRight();
      }

      return var3;
   }

   private float getYOffset(int var1, int var2) {
      return this.anchor != Float.MAX_VALUE?(1.0F - this.anchor) / 2.0F:0.25F + (1.5F - Math.max(1.0F, Math.min(1.5F, (float)var2 / (float)var1))) / 2.0F;
   }

   private int targetHeight(int var1, int var2, int var3) {
      float var4 = this.ratio;
      if(this.ratio == Float.MAX_VALUE) {
         var4 = (float)var2 / (float)var1;
      }

      return (int)((float)var3 * var4);
   }

   public void draw(Canvas var1) {
      ImageView var2 = null;
      if(this.ref != null) {
         var2 = (ImageView)this.ref.get();
      }

      if(this.ratio != 0.0F && var2 != null) {
         this.draw(var1, var2, this.getBitmap());
      } else {
         super.draw(var1);
      }
   }
}
