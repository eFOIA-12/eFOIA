package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CircleImageView extends ImageView {
   private static final int FILL_SHADOW_COLOR = 1023410176;
   private static final int KEY_SHADOW_COLOR = 503316480;
   private static final int SHADOW_ELEVATION = 4;
   private static final float SHADOW_RADIUS = 3.5F;
   private static final float X_OFFSET = 0.0F;
   private static final float Y_OFFSET = 1.75F;
   private AnimationListener mListener;
   private int mShadowRadius;

   public CircleImageView(Context var1, int var2, float var3) {
      super(var1);
      float var4 = this.getContext().getResources().getDisplayMetrics().density;
      int var5 = (int)(var3 * var4 * 2.0F);
      int var6 = (int)(1.75F * var4);
      int var7 = (int)(0.0F * var4);
      this.mShadowRadius = (int)(3.5F * var4);
      ShapeDrawable var8;
      if(this.elevationSupported()) {
         var8 = new ShapeDrawable(new OvalShape());
         ViewCompat.setElevation(this, 4.0F * var4);
      } else {
         var8 = new ShapeDrawable(new CircleImageView.OvalShadow(this.mShadowRadius, var5));
         ViewCompat.setLayerType(this, 1, var8.getPaint());
         var8.getPaint().setShadowLayer((float)this.mShadowRadius, (float)var7, (float)var6, 503316480);
         var5 = this.mShadowRadius;
         this.setPadding(var5, var5, var5, var5);
      }

      var8.getPaint().setColor(var2);
      this.setBackgroundDrawable(var8);
   }

   private boolean elevationSupported() {
      return VERSION.SDK_INT >= 21;
   }

   public void onAnimationEnd() {
      super.onAnimationEnd();
      if(this.mListener != null) {
         this.mListener.onAnimationEnd(this.getAnimation());
      }

   }

   public void onAnimationStart() {
      super.onAnimationStart();
      if(this.mListener != null) {
         this.mListener.onAnimationStart(this.getAnimation());
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(!this.elevationSupported()) {
         this.setMeasuredDimension(this.getMeasuredWidth() + this.mShadowRadius * 2, this.getMeasuredHeight() + this.mShadowRadius * 2);
      }

   }

   public void setAnimationListener(AnimationListener var1) {
      this.mListener = var1;
   }

   public void setBackgroundColor(int var1) {
      if(this.getBackground() instanceof ShapeDrawable) {
         ((ShapeDrawable)this.getBackground()).getPaint().setColor(var1);
      }

   }

   public void setBackgroundColorRes(int var1) {
      this.setBackgroundColor(this.getContext().getResources().getColor(var1));
   }

   private class OvalShadow extends OvalShape {
      private int mCircleDiameter;
      private RadialGradient mRadialGradient;
      private Paint mShadowPaint = new Paint();

      public OvalShadow(int var2, int var3) {
         CircleImageView.this.mShadowRadius = var2;
         this.mCircleDiameter = var3;
         float var4 = (float)(this.mCircleDiameter / 2);
         float var5 = (float)(this.mCircleDiameter / 2);
         float var6 = (float)CircleImageView.this.mShadowRadius;
         TileMode var7 = TileMode.CLAMP;
         this.mRadialGradient = new RadialGradient(var4, var5, var6, new int[]{1023410176, 0}, (float[])null, var7);
         this.mShadowPaint.setShader(this.mRadialGradient);
      }

      public void draw(Canvas var1, Paint var2) {
         int var3 = CircleImageView.this.getWidth();
         int var4 = CircleImageView.this.getHeight();
         var1.drawCircle((float)(var3 / 2), (float)(var4 / 2), (float)(this.mCircleDiameter / 2 + CircleImageView.this.mShadowRadius), this.mShadowPaint);
         var1.drawCircle((float)(var3 / 2), (float)(var4 / 2), (float)(this.mCircleDiameter / 2), var2);
      }
   }
}
