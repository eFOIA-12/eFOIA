package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.google.android.gms.internal.ll;

public final class iz extends Drawable implements Callback {
   private boolean LO;
   private int LV;
   private long LW;
   private int LX;
   private int LY;
   private int LZ;
   private int Ma;
   private boolean Mb;
   private iz.b Mc;
   private Drawable Md;
   private Drawable Me;
   private boolean Mf;
   private boolean Mg;
   private boolean Mh;
   private int Mi;
   private int mFrom;

   public iz(Drawable var1, Drawable var2) {
      this((iz.b)null);
      Object var3 = var1;
      if(var1 == null) {
         var3 = iz.a.Mj;
      }

      this.Md = (Drawable)var3;
      ((Drawable)var3).setCallback(this);
      iz.b var4 = this.Mc;
      var4.Mm |= ((Drawable)var3).getChangingConfigurations();
      Object var5 = var2;
      if(var2 == null) {
         var5 = iz.a.Mj;
      }

      this.Me = (Drawable)var5;
      ((Drawable)var5).setCallback(this);
      iz.b var6 = this.Mc;
      var6.Mm |= ((Drawable)var5).getChangingConfigurations();
   }

   iz(iz.b var1) {
      this.LV = 0;
      this.LY = 255;
      this.Ma = 0;
      this.LO = true;
      this.Mc = new iz.b(var1);
   }

   public boolean canConstantState() {
      if(!this.Mf) {
         boolean var1;
         if(this.Md.getConstantState() != null && this.Me.getConstantState() != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.Mg = var1;
         this.Mf = true;
      }

      return this.Mg;
   }

   public void draw(Canvas var1) {
      boolean var5 = true;
      boolean var4 = true;
      boolean var6 = false;
      switch(this.LV) {
      case 1:
         this.LW = SystemClock.uptimeMillis();
         this.LV = 2;
         var4 = var6;
         break;
      case 2:
         if(this.LW >= 0L) {
            float var2 = (float)(SystemClock.uptimeMillis() - this.LW) / (float)this.LZ;
            if(var2 >= 1.0F) {
               var4 = var5;
            } else {
               var4 = false;
            }

            if(var4) {
               this.LV = 0;
            }

            var2 = Math.min(var2, 1.0F);
            float var3 = (float)this.mFrom;
            this.Ma = (int)(var2 * (float)(this.LX - this.mFrom) + var3);
         }
      }

      int var10 = this.Ma;
      boolean var7 = this.LO;
      Drawable var8 = this.Md;
      Drawable var9 = this.Me;
      if(!var4) {
         if(var7) {
            var8.setAlpha(this.LY - var10);
         }

         var8.draw(var1);
         if(var7) {
            var8.setAlpha(this.LY);
         }

         if(var10 > 0) {
            var9.setAlpha(var10);
            var9.draw(var1);
            var9.setAlpha(this.LY);
         }

         this.invalidateSelf();
      } else {
         if(!var7 || var10 == 0) {
            var8.draw(var1);
         }

         if(var10 == this.LY) {
            var9.setAlpha(this.LY);
            var9.draw(var1);
         }

      }
   }

   public int getChangingConfigurations() {
      return super.getChangingConfigurations() | this.Mc.Ml | this.Mc.Mm;
   }

   public ConstantState getConstantState() {
      if(this.canConstantState()) {
         this.Mc.Ml = this.getChangingConfigurations();
         return this.Mc;
      } else {
         return null;
      }
   }

   public int getIntrinsicHeight() {
      return Math.max(this.Md.getIntrinsicHeight(), this.Me.getIntrinsicHeight());
   }

   public int getIntrinsicWidth() {
      return Math.max(this.Md.getIntrinsicWidth(), this.Me.getIntrinsicWidth());
   }

   public int getOpacity() {
      if(!this.Mh) {
         this.Mi = Drawable.resolveOpacity(this.Md.getOpacity(), this.Me.getOpacity());
         this.Mh = true;
      }

      return this.Mi;
   }

   public Drawable hh() {
      return this.Me;
   }

   public void invalidateDrawable(Drawable var1) {
      if(ll.ig()) {
         Callback var2 = this.getCallback();
         if(var2 != null) {
            var2.invalidateDrawable(this);
         }
      }

   }

   public Drawable mutate() {
      if(!this.Mb && super.mutate() == this) {
         if(!this.canConstantState()) {
            throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
         }

         this.Md.mutate();
         this.Me.mutate();
         this.Mb = true;
      }

      return this;
   }

   protected void onBoundsChange(Rect var1) {
      this.Md.setBounds(var1);
      this.Me.setBounds(var1);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      if(ll.ig()) {
         Callback var5 = this.getCallback();
         if(var5 != null) {
            var5.scheduleDrawable(this, var2, var3);
         }
      }

   }

   public void setAlpha(int var1) {
      if(this.Ma == this.LY) {
         this.Ma = var1;
      }

      this.LY = var1;
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.Md.setColorFilter(var1);
      this.Me.setColorFilter(var1);
   }

   public void startTransition(int var1) {
      this.mFrom = 0;
      this.LX = this.LY;
      this.Ma = 0;
      this.LZ = var1;
      this.LV = 1;
      this.invalidateSelf();
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      if(ll.ig()) {
         Callback var3 = this.getCallback();
         if(var3 != null) {
            var3.unscheduleDrawable(this, var2);
         }
      }

   }

   private static final class a extends Drawable {
      private static final iz.a Mj = new iz.a();
      private static final iz.a Mk = new iz.a(null);

      public void draw(Canvas var1) {
      }

      public ConstantState getConstantState() {
         return Mk;
      }

      public int getOpacity() {
         return -2;
      }

      public void setAlpha(int var1) {
      }

      public void setColorFilter(ColorFilter var1) {
      }
   }

   private static final class a extends ConstantState {
      private a() {
      }

      // $FF: synthetic method
      a(Object var1) {
         this();
      }

      public int getChangingConfigurations() {
         return 0;
      }

      public Drawable newDrawable() {
         return iz.a.Mj;
      }
   }

   static final class b extends ConstantState {
      int Ml;
      int Mm;

      b(iz.b var1) {
         if(var1 != null) {
            this.Ml = var1.Ml;
            this.Mm = var1.Mm;
         }

      }

      public int getChangingConfigurations() {
         return this.Ml;
      }

      public Drawable newDrawable() {
         return new iz(this);
      }
   }
}
