package com.parallel6.ui.widgets.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.parallel6.ui.widgets.calendar.Logr;
import com.parallel6.ui.widgets.calendar.MonthCellDescriptor;
import com.parallel6.ui.widgets.calendar.MonthView;

public class CalendarRowView extends ViewGroup implements OnClickListener {
   private int cellSize;
   private boolean isHeaderRow;
   private MonthView.Listener listener;

   public CalendarRowView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public void addView(@NonNull View var1, int var2, LayoutParams var3) {
      var1.setOnClickListener(this);
      super.addView(var1, var2, var3);
   }

   public void onClick(View var1) {
      if(this.listener != null) {
         this.listener.handleClick((MonthCellDescriptor)var1.getTag());
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      long var6 = System.currentTimeMillis();
      var2 = 0;

      for(var4 = this.getChildCount(); var2 < var4; ++var2) {
         this.getChildAt(var2).layout(this.cellSize * var2, 0, (var2 + 1) * this.cellSize, var5 - var3);
      }

      Logr.d("Row.onLayout %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - var6)});
   }

   protected void onMeasure(int var1, int var2) {
      long var8 = System.currentTimeMillis();
      int var6 = MeasureSpec.getSize(var1);
      this.cellSize = var6 / 7;
      int var5 = MeasureSpec.makeMeasureSpec(this.cellSize, 1073741824);
      if(this.isHeaderRow) {
         var1 = MeasureSpec.makeMeasureSpec(this.cellSize, Integer.MIN_VALUE);
      } else {
         var1 = var5;
      }

      int var3 = 0;
      var2 = 0;

      int var4;
      for(int var7 = this.getChildCount(); var2 < var7; var3 = var4) {
         View var10 = this.getChildAt(var2);
         var10.measure(var5, var1);
         var4 = var3;
         if(var10.getMeasuredHeight() > var3) {
            var4 = var10.getMeasuredHeight();
         }

         ++var2;
      }

      this.setMeasuredDimension(this.getPaddingLeft() + var6 + this.getPaddingRight(), this.getPaddingTop() + var3 + this.getPaddingBottom());
      Logr.d("Row.onMeasure %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - var8)});
   }

   public void setCellBackground(int var1) {
      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         this.getChildAt(var2).setBackgroundResource(var1);
      }

   }

   public void setCellTextColor(int var1) {
      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         ((TextView)this.getChildAt(var2)).setTextColor(var1);
      }

   }

   public void setCellTextColor(ColorStateList var1) {
      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         ((TextView)this.getChildAt(var2)).setTextColor(var1);
      }

   }

   public void setIsHeaderRow(boolean var1) {
      this.isHeaderRow = var1;
   }

   public void setListener(MonthView.Listener var1) {
      this.listener = var1;
   }
}
