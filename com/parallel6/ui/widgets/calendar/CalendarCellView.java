package com.parallel6.ui.widgets.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.widgets.calendar.MonthCellDescriptor;

public class CalendarCellView extends TextView {
   private static final int[] STATE_CURRENT_MONTH;
   private static final int[] STATE_HIGHLIGHTED;
   private static final int[] STATE_RANGE_FIRST;
   private static final int[] STATE_RANGE_LAST;
   private static final int[] STATE_RANGE_MIDDLE;
   private static final int[] STATE_SELECTABLE;
   private static final int[] STATE_TODAY;
   private boolean isCurrentMonth = false;
   private boolean isHighlighted = false;
   private boolean isSelectable = false;
   private boolean isToday = false;
   private MonthCellDescriptor.RangeState rangeState;

   static {
      STATE_SELECTABLE = new int[]{R.attr.state_selectable};
      STATE_CURRENT_MONTH = new int[]{R.attr.state_current_month};
      STATE_TODAY = new int[]{R.attr.state_today};
      STATE_HIGHLIGHTED = new int[]{R.attr.state_highlighted};
      STATE_RANGE_FIRST = new int[]{R.attr.state_range_first};
      STATE_RANGE_MIDDLE = new int[]{R.attr.state_range_middle};
      STATE_RANGE_LAST = new int[]{R.attr.state_range_last};
   }

   public CalendarCellView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.rangeState = MonthCellDescriptor.RangeState.NONE;
   }

   protected int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 5);
      if(this.isSelectable) {
         mergeDrawableStates(var2, STATE_SELECTABLE);
      }

      if(this.isCurrentMonth) {
         mergeDrawableStates(var2, STATE_CURRENT_MONTH);
      }

      if(this.isToday) {
         mergeDrawableStates(var2, STATE_TODAY);
      }

      if(this.isHighlighted) {
         mergeDrawableStates(var2, STATE_HIGHLIGHTED);
      }

      if(this.rangeState == MonthCellDescriptor.RangeState.FIRST) {
         mergeDrawableStates(var2, STATE_RANGE_FIRST);
      } else {
         if(this.rangeState == MonthCellDescriptor.RangeState.MIDDLE) {
            mergeDrawableStates(var2, STATE_RANGE_MIDDLE);
            return var2;
         }

         if(this.rangeState == MonthCellDescriptor.RangeState.LAST) {
            mergeDrawableStates(var2, STATE_RANGE_LAST);
            return var2;
         }
      }

      return var2;
   }

   public void setCurrentMonth(boolean var1) {
      this.isCurrentMonth = var1;
      this.refreshDrawableState();
   }

   public void setHighlighted(boolean var1) {
      this.isHighlighted = var1;
      this.refreshDrawableState();
   }

   public void setRangeState(MonthCellDescriptor.RangeState var1) {
      this.rangeState = var1;
      this.refreshDrawableState();
   }

   public void setSelectable(boolean var1) {
      this.isSelectable = var1;
      this.refreshDrawableState();
   }

   public void setToday(boolean var1) {
      this.isToday = var1;
      this.refreshDrawableState();
   }
}
