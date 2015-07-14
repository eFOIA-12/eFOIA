package com.parallel6.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.parallel6.captivereachconnectsdk.R;

public class RoundedImageView extends ImageView {
   private int backgroundColor;
   private Paint paint;
   private Paint paintBorder;
   private BitmapShader shader;
   private int strokeSize;
   private int viewHeight;
   private int viewWidth;

   public RoundedImageView(Context var1) {
      super(var1);
      this.setup();
   }

   public RoundedImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.RoundedImageView);
      this.strokeSize = (int)var3.getDimension(R.styleable.RoundedImageView_strokeSize, 0.0F);
      this.backgroundColor = var3.getColor(R.styleable.RoundedImageView_backgroundColor, -1);
      this.setup();
   }

   public RoundedImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.RoundedImageView);
      this.strokeSize = (int)var4.getDimension(R.styleable.RoundedImageView_strokeSize, 0.0F);
      this.backgroundColor = var4.getColor(R.styleable.RoundedImageView_backgroundColor, -1);
      this.setup();
   }

   private Bitmap createCroppedBitmap(Bitmap var1) {
      if(var1.getWidth() == var1.getHeight()) {
         return var1;
      } else {
         if(var1.getWidth() >= var1.getHeight()) {
            var1 = Bitmap.createBitmap(var1, var1.getWidth() / 2 - var1.getHeight() / 2, 0, var1.getHeight(), var1.getHeight());
         } else {
            var1 = Bitmap.createBitmap(var1, 0, var1.getHeight() / 2 - var1.getWidth() / 2, var1.getWidth(), var1.getWidth());
         }

         return var1;
      }
   }

   private int measureHeight(int var1, int var2) {
      var2 = MeasureSpec.getMode(var1);
      var1 = MeasureSpec.getSize(var1);
      if(var2 != 1073741824) {
         var1 = this.viewHeight;
      }

      return var1 + 2;
   }

   private int measureWidth(int var1) {
      int var2 = MeasureSpec.getMode(var1);
      var1 = MeasureSpec.getSize(var1);
      return var2 == 1073741824?var1:this.viewWidth;
   }

   private void setup() {
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.paintBorder = new Paint();
      this.paintBorder.setColor(this.backgroundColor);
      this.paintBorder.setAntiAlias(true);
      if(VERSION.SDK_INT >= 11) {
         this.setLayerType(1, this.paintBorder);
      }

      this.paintBorder.setShadowLayer(6.0F, 0.0F, 2.0F, -16777216);
   }

   public int getBackgroundColor() {
      return this.backgroundColor;
   }

   public int getStrokeSize() {
      return this.strokeSize;
   }

   protected void onDraw(Canvas var1) {
      Drawable var3 = this.getDrawable();
      if(this.getWidth() != 0 && this.getHeight() != 0) {
         if(var3 != null) {
            this.shader = new BitmapShader(Bitmap.createScaledBitmap(this.createCroppedBitmap(((BitmapDrawable)var3).getBitmap()), this.getWidth(), this.getWidth(), false), TileMode.CLAMP, TileMode.CLAMP);
         } else {
            Bitmap var4 = Bitmap.createBitmap(this.getWidth(), this.getWidth(), Config.ARGB_8888);
            (new Canvas(var4)).drawColor(this.backgroundColor);
            this.shader = new BitmapShader(var4, TileMode.CLAMP, TileMode.CLAMP);
         }

         this.paint.setShader(this.shader);
         int var2 = this.viewWidth / 2;
         var1.drawCircle((float)(this.strokeSize + var2), (float)(this.strokeSize + var2), (float)(this.strokeSize + var2) - 4.0F, this.paintBorder);
         var1.drawCircle((float)(this.strokeSize + var2), (float)(this.strokeSize + var2), (float)var2 - 4.0F, this.paint);
      }
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = this.measureWidth(var1);
      var1 = this.measureHeight(var2, var1);
      this.viewWidth = var3 - this.strokeSize * 2;
      this.viewHeight = var1 - this.strokeSize * 2;
      this.setMeasuredDimension(var3, var1);
   }

   public void setBackgroundColor(int var1) {
      this.backgroundColor = var1;
      this.invalidate();
   }

   public void setStrokeSize(int var1) {
      this.strokeSize = var1;
      this.invalidate();
   }
}
