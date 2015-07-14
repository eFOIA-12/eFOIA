package com.parallel6.ui.widgets.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.widgets.calendar.CalendarCellView;
import com.parallel6.ui.widgets.calendar.CalendarGridView;
import com.parallel6.ui.widgets.calendar.CalendarRowView;
import com.parallel6.ui.widgets.calendar.Logr;
import com.parallel6.ui.widgets.calendar.MonthCellDescriptor;
import com.parallel6.ui.widgets.calendar.MonthDescriptor;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class MonthView extends LinearLayout {
   CalendarGridView grid;
   private MonthView.Listener listener;
   TextView title;

   public MonthView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public static MonthView create(ViewGroup var0, LayoutInflater var1, DateFormat var2, MonthView.Listener var3, Calendar var4, int var5, int var6, int var7, int var8, int var9) {
      MonthView var10 = (MonthView)var1.inflate(R.layout.month, var0, false);
      var10.setDividerColor(var5);
      var10.setDayTextColor(var7);
      var10.setTitleTextColor(var8);
      var10.setHeaderTextColor(var9);
      if(var6 != 0) {
         var10.setDayBackground(var6);
      }

      var6 = var4.get(7);
      var7 = var4.getFirstDayOfWeek();
      CalendarRowView var11 = (CalendarRowView)var10.grid.getChildAt(0);

      for(var5 = 0; var5 < 7; ++var5) {
         var4.set(7, var7 + var5);
         ((TextView)var11.getChildAt(var5)).setText(var2.format(var4.getTime()));
      }

      var4.set(7, var6);
      var10.listener = var3;
      return var10;
   }

   public void init(MonthDescriptor var1, List var2, boolean var3, ColorStateList var4) {
      Logr.d("Initializing MonthView (%d) for %s", new Object[]{Integer.valueOf(System.identityHashCode(this)), var1});
      long var9 = System.currentTimeMillis();
      this.title.setText(var1.getLabel());
      int var7 = var2.size();
      this.grid.setNumRows(var7);

      for(int var5 = 0; var5 < 6; ++var5) {
         CalendarRowView var14 = (CalendarRowView)this.grid.getChildAt(var5 + 1);
         var14.setListener(this.listener);
         if(var5 < var7) {
            var14.setVisibility(0);
            List var11 = (List)var2.get(var5);

            for(int var6 = 0; var6 < var11.size(); ++var6) {
               MonthCellDescriptor var12 = (MonthCellDescriptor)var11.get(var6);
               CalendarCellView var13 = (CalendarCellView)var14.getChildAt(var6);
               var13.setText(Integer.toString(var12.getValue()));
               var13.setEnabled(var12.isCurrentMonth());
               boolean var8;
               if(!var3) {
                  var8 = true;
               } else {
                  var8 = false;
               }

               var13.setClickable(var8);
               var13.setSelectable(var12.isSelectable());
               var13.setSelected(var12.isSelected());
               var13.setCurrentMonth(var12.isCurrentMonth());
               var13.setToday(var12.isToday());
               var13.setRangeState(var12.getRangeState());
               var13.setHighlighted(var12.isHighlighted());
               var13.setTag(var12);
            }
         } else {
            var14.setVisibility(8);
         }
      }

      this.grid.setDayTextColorList(var4);
      Logr.d("MonthView.init took %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - var9)});
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.title = (TextView)this.findViewById(R.id.title);
      this.grid = (CalendarGridView)this.findViewById(R.id.calendar_grid);
   }

   public void setDayBackground(int var1) {
      this.grid.setDayBackground(var1);
   }

   public void setDayTextColor(int var1) {
      this.grid.setDayTextColor(var1);
   }

   public void setDividerColor(int var1) {
      this.grid.setDividerColor(var1);
   }

   public void setHeaderTextColor(int var1) {
      this.grid.setHeaderTextColor(var1);
   }

   public void setTitleTextColor(int var1) {
      this.title.setTextColor(var1);
   }

   public interface Listener {
      void handleClick(MonthCellDescriptor var1);
   }
}
