package com.parallel6.ui.widgets;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class CustomScroller extends Scroller {
   private int mDuration = 2000;

   public CustomScroller(Context var1) {
      super(var1);
   }

   public CustomScroller(Context var1, Interpolator var2) {
      super(var1, var2);
   }

   public CustomScroller(Context var1, Interpolator var2, boolean var3) {
      super(var1, var2, var3);
   }

   public int getMDuration() {
      return this.mDuration;
   }

   public void setmDuration(int var1) {
      this.mDuration = var1;
   }

   public void startScroll(int var1, int var2, int var3, int var4) {
      super.startScroll(var1, var2, var3, var4, this.mDuration);
   }

   public void startScroll(int var1, int var2, int var3, int var4, int var5) {
      super.startScroll(var1, var2, var3, var4, this.mDuration);
   }
}
