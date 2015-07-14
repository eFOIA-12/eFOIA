package com.parallel6.ui.widgets.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.widgets.calendar.CalendarRowView;
import com.parallel6.ui.widgets.calendar.Logr;

public class CalendarGridView extends ViewGroup {
   private static final float FLOAT_FUDGE = 0.5F;
   private final Paint dividerPaint = new Paint();
   private int oldNumRows;
   private int oldWidthMeasureSize;

   public CalendarGridView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.dividerPaint.setColor(this.getResources().getColor(R.color.calendar_divider));
   }

   public void addView(@NonNull View var1, int var2, LayoutParams var3) {
      if(this.getChildCount() == 0) {
         ((CalendarRowView)var1).setIsHeaderRow(true);
      }

      super.addView(var1, var2, var3);
   }

   protected void dispatchDraw(@NonNull Canvas var1) {
      super.dispatchDraw(var1);
      ViewGroup var7 = (ViewGroup)this.getChildAt(1);
      int var4 = var7.getTop();
      int var5 = this.getBottom();
      int var6 = var7.getChildAt(0).getLeft() + this.getLeft();
      var1.drawLine((float)var6 + 0.5F, (float)var4, (float)var6 + 0.5F, (float)var5, this.dividerPaint);

      for(int var3 = 0; var3 < 7; ++var3) {
         float var2 = (float)(var7.getChildAt(var3).getRight() + var6) - 0.5F;
         var1.drawLine(var2, (float)var4, var2, (float)var5, this.dividerPaint);
      }

   }

   protected boolean drawChild(@NonNull Canvas var1, @NonNull View var2, long var3) {
      boolean var6 = super.drawChild(var1, var2, var3);
      int var5 = var2.getBottom() - 1;
      var1.drawLine((float)var2.getLeft(), (float)var5, (float)(var2.getRight() - 2), (float)var5, this.dividerPaint);
      return var6;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      long var8 = System.currentTimeMillis();
      var5 = 0;
      var3 = 0;

      for(int var6 = this.getChildCount(); var3 < var6; ++var3) {
         View var10 = this.getChildAt(var3);
         int var7 = var10.getMeasuredHeight();
         var10.layout(var2, var5, var4, var5 + var7);
         var5 += var7;
      }

      Logr.d("Grid.onLayout %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - var8)});
   }

   protected void onMeasure(int var1, int var2) {
      Logr.d("Grid.onMeasure w=%s h=%s", new Object[]{MeasureSpec.toString(var1), MeasureSpec.toString(var2)});
      var1 = MeasureSpec.getSize(var1);
      if(this.oldWidthMeasureSize == var1) {
         Logr.d("SKIP Grid.onMeasure");
         this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight());
      } else {
         long var9 = System.currentTimeMillis();
         this.oldWidthMeasureSize = var1;
         int var4 = var1 / 7;
         int var5 = var4 * 7;
         var2 = 0;
         int var6 = MeasureSpec.makeMeasureSpec(var5, 1073741824);
         int var7 = MeasureSpec.makeMeasureSpec(var4, 1073741824);
         var1 = 0;

         int var3;
         for(int var8 = this.getChildCount(); var1 < var8; var2 = var3) {
            View var11 = this.getChildAt(var1);
            var3 = var2;
            if(var11.getVisibility() == 0) {
               if(var1 == 0) {
                  this.measureChild(var11, var6, MeasureSpec.makeMeasureSpec(var4, Integer.MIN_VALUE));
               } else {
                  this.measureChild(var11, var6, var7);
               }

               var3 = var2 + var11.getMeasuredHeight();
            }

            ++var1;
         }

         this.setMeasuredDimension(var5 + 2, var2);
         Logr.d("Grid.onMeasure %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - var9)});
      }
   }

   public void setDayBackground(int var1) {
      for(int var2 = 1; var2 < this.getChildCount(); ++var2) {
         ((CalendarRowView)this.getChildAt(var2)).setCellBackground(var1);
      }

   }

   public void setDayTextColor(int var1) {
      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         ColorStateList var3 = this.getResources().getColorStateList(var1);
         ((CalendarRowView)this.getChildAt(var2)).setCellTextColor(var3);
      }

   }

   public void setDayTextColorList(ColorStateList var1) {
      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         ((CalendarRowView)this.getChildAt(var2)).setCellTextColor(var1);
      }

   }

   public void setDividerColor(int var1) {
      this.dividerPaint.setColor(var1);
   }

   public void setHeaderTextColor(int var1) {
      ((CalendarRowView)this.getChildAt(0)).setCellTextColor(var1);
   }

   public void setNumRows(int var1) {
      if(this.oldNumRows != var1) {
         this.oldWidthMeasureSize = 0;
      }

      this.oldNumRows = var1;
   }
}
