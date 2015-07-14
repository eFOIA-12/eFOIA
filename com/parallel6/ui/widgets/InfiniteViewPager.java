package com.parallel6.ui.widgets;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.parallel6.ui.adapters.pager.InfinitePagerAdapter;

public class InfiniteViewPager extends ViewPager {
   private boolean swipeable = true;

   public InfiniteViewPager(Context var1) {
      super(var1);
   }

   public InfiniteViewPager(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private int getOffsetAmount() {
      return this.getAdapter() instanceof InfinitePagerAdapter?((InfinitePagerAdapter)this.getAdapter()).getRealCount() * 100:0;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      return this.swipeable?super.onInterceptTouchEvent(var1):false;
   }

   public void setAdapter(PagerAdapter var1) {
      super.setAdapter(var1);
      this.setCurrentItem(0);
   }

   public void setCurrentItem(int var1) {
      super.setCurrentItem(this.getOffsetAmount() + var1 % this.getAdapter().getCount());
   }

   public void setSwipeable(boolean var1) {
      this.swipeable = var1;
   }
}
