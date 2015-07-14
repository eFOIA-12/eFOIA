package com.parallel6.ui.widgets.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.widgets.calendar.Logr;
import com.parallel6.ui.widgets.calendar.MonthCellDescriptor;
import com.parallel6.ui.widgets.calendar.MonthDescriptor;
import com.parallel6.ui.widgets.calendar.MonthView;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CalendarPickerView extends ListView {
   private final CalendarPickerView.MonthAdapter adapter;
   private final List cells = new ArrayList();
   private CalendarPickerView.DateSelectableFilter dateConfiguredListener;
   private CalendarPickerView.OnDateSelectedListener dateListener;
   private int dayBackgroundResId;
   ColorStateList dayTextColorList;
   private int dayTextColorResId;
   private boolean displayOnly;
   private int dividerColor;
   private DateFormat fullDateFormat;
   private int headerTextColor;
   final List highlightedCals = new ArrayList();
   final List highlightedCells = new ArrayList();
   private CalendarPickerView.OnInvalidDateSelectedListener invalidDateListener = new CalendarPickerView.DefaultOnInvalidDateSelectedListener(null);
   final MonthView.Listener listener = new CalendarPickerView.CellClickedListener(null);
   private Locale locale;
   private Calendar maxCal;
   private Calendar minCal;
   private Calendar monthCounter;
   private DateFormat monthNameFormat;
   final List months = new ArrayList();
   final List selectedCals = new ArrayList();
   final List selectedCells = new ArrayList();
   CalendarPickerView.SelectionMode selectionMode;
   private int titleTextColor;
   Calendar today;
   private DateFormat weekdayNameFormat;

   public CalendarPickerView(Context var1, AttributeSet var2) {
      super(var1, var2);
      Resources var4 = var1.getResources();
      TypedArray var6 = var1.obtainStyledAttributes(var2, R.styleable.CalendarPickerView);
      int var3 = var6.getColor(R.styleable.CalendarPickerView_android_background, var4.getColor(R.color.calendar_bg));
      this.dividerColor = var6.getColor(R.styleable.CalendarPickerView_dividerColor, var4.getColor(R.color.calendar_divider));
      this.dayBackgroundResId = var6.getResourceId(R.styleable.CalendarPickerView_dayBackground, R.drawable.calendar_bg_selector);
      this.dayTextColorResId = var6.getResourceId(R.styleable.CalendarPickerView_dayTextColor, R.drawable.calendar_text_selector);
      this.titleTextColor = var6.getColor(R.styleable.CalendarPickerView_titleTextColor, R.color.calendar_text_active);
      this.headerTextColor = var6.getColor(R.styleable.CalendarPickerView_headerTextColor, R.color.calendar_text_active);
      var6.recycle();
      this.adapter = new CalendarPickerView.MonthAdapter(null);
      this.setDivider((Drawable)null);
      this.setDividerHeight(0);
      this.setBackgroundColor(var3);
      this.setCacheColorHint(var3);
      this.locale = Locale.getDefault();
      this.today = Calendar.getInstance(this.locale);
      this.minCal = Calendar.getInstance(this.locale);
      this.maxCal = Calendar.getInstance(this.locale);
      this.monthCounter = Calendar.getInstance(this.locale);
      this.monthNameFormat = new SimpleDateFormat(var1.getString(R.string.month_name_format), this.locale);
      this.weekdayNameFormat = new SimpleDateFormat(var1.getString(R.string.day_name_format), this.locale);
      this.fullDateFormat = DateFormat.getDateInstance(2, this.locale);
      if(this.isInEditMode()) {
         Calendar var5 = Calendar.getInstance(this.locale);
         var5.add(1, 1);
         this.init(new Date(), var5.getTime()).withSelectedDate(new Date());
      }

   }

   private Date applyMultiSelect(Date var1, Calendar var2) {
      Iterator var4 = this.selectedCells.iterator();

      Date var3;
      while(true) {
         var3 = var1;
         if(!var4.hasNext()) {
            break;
         }

         MonthCellDescriptor var6 = (MonthCellDescriptor)var4.next();
         if(var6.getDate().equals(var1)) {
            var6.setSelected(false);
            this.selectedCells.remove(var6);
            var3 = null;
            break;
         }
      }

      Iterator var5 = this.selectedCals.iterator();

      while(var5.hasNext()) {
         Calendar var7 = (Calendar)var5.next();
         if(sameDate(var7, var2)) {
            this.selectedCals.remove(var7);
            break;
         }
      }

      return var3;
   }

   private static boolean betweenDates(Calendar var0, Calendar var1, Calendar var2) {
      return betweenDates(var0.getTime(), var1, var2);
   }

   static boolean betweenDates(Date var0, Calendar var1, Calendar var2) {
      Date var3 = var1.getTime();
      return (var0.equals(var3) || var0.after(var3)) && var0.before(var2.getTime());
   }

   private void clearOldHighlights() {
      Iterator var1 = this.highlightedCells.iterator();

      while(var1.hasNext()) {
         ((MonthCellDescriptor)var1.next()).setHighlighted(false);
      }

      this.highlightedCells.clear();
      this.highlightedCals.clear();
   }

   private void clearOldSelections() {
      Iterator var1 = this.selectedCells.iterator();

      while(var1.hasNext()) {
         ((MonthCellDescriptor)var1.next()).setSelected(false);
      }

      this.selectedCells.clear();
      this.selectedCals.clear();
   }

   private static boolean containsDate(List var0, Calendar var1) {
      Iterator var2 = var0.iterator();

      do {
         if(!var2.hasNext()) {
            return false;
         }
      } while(!sameDate(var1, (Calendar)var2.next()));

      return true;
   }

   private static String dbg(Date var0, Date var1) {
      return "minDate: " + var0 + "\nmaxDate: " + var1;
   }

   private boolean doSelectDate(Date var1, MonthCellDescriptor var2) {
      Calendar var4 = Calendar.getInstance(this.locale);
      var4.setTime(var1);
      setMidnight(var4);
      Iterator var3 = this.selectedCells.iterator();

      while(var3.hasNext()) {
         ((MonthCellDescriptor)var3.next()).setRangeState(MonthCellDescriptor.RangeState.NONE);
      }

      Date var9;
      switch(null.$SwitchMap$com$parallel6$ui$widgets$calendar$CalendarPickerView$SelectionMode[this.selectionMode.ordinal()]) {
      case 1:
         if(this.selectedCals.size() > 1) {
            this.clearOldSelections();
            var9 = var1;
         } else {
            var9 = var1;
            if(this.selectedCals.size() == 1) {
               var9 = var1;
               if(var4.before(this.selectedCals.get(0))) {
                  this.clearOldSelections();
                  var9 = var1;
               }
            }
         }
         break;
      case 2:
         var9 = this.applyMultiSelect(var1, var4);
         break;
      case 3:
         this.clearOldSelections();
         var9 = var1;
         break;
      default:
         throw new IllegalStateException("Unknown selectionMode " + this.selectionMode);
      }

      if(var9 != null) {
         if(this.selectedCells.size() == 0 || !((MonthCellDescriptor)this.selectedCells.get(0)).equals(var2)) {
            this.selectedCells.add(var2);
            var2.setSelected(true);
         }

         this.selectedCals.add(var4);
         if(this.selectionMode == CalendarPickerView.SelectionMode.RANGE && this.selectedCells.size() > 1) {
            var1 = ((MonthCellDescriptor)this.selectedCells.get(0)).getDate();
            Date var8 = ((MonthCellDescriptor)this.selectedCells.get(1)).getDate();
            ((MonthCellDescriptor)this.selectedCells.get(0)).setRangeState(MonthCellDescriptor.RangeState.FIRST);
            ((MonthCellDescriptor)this.selectedCells.get(1)).setRangeState(MonthCellDescriptor.RangeState.LAST);
            Iterator var10 = this.cells.iterator();

            while(var10.hasNext()) {
               Iterator var5 = ((List)var10.next()).iterator();

               while(var5.hasNext()) {
                  Iterator var6 = ((List)var5.next()).iterator();

                  while(var6.hasNext()) {
                     MonthCellDescriptor var7 = (MonthCellDescriptor)var6.next();
                     if(var7.getDate().after(var1) && var7.getDate().before(var8) && var7.isSelectable()) {
                        var7.setSelected(true);
                        var7.setRangeState(MonthCellDescriptor.RangeState.MIDDLE);
                        this.selectedCells.add(var7);
                     }
                  }
               }
            }
         }
      }

      this.validateAndUpdate();
      return var9 != null;
   }

   private CalendarPickerView.MonthCellWithMonthIndex getMonthCellWithIndexByDate(Date var1) {
      int var2 = 0;
      Calendar var3 = Calendar.getInstance(this.locale);
      var3.setTime(var1);
      Calendar var8 = Calendar.getInstance(this.locale);

      for(Iterator var4 = this.cells.iterator(); var4.hasNext(); ++var2) {
         Iterator var5 = ((List)var4.next()).iterator();

         while(var5.hasNext()) {
            Iterator var6 = ((List)var5.next()).iterator();

            while(var6.hasNext()) {
               MonthCellDescriptor var7 = (MonthCellDescriptor)var6.next();
               var8.setTime(var7.getDate());
               if(sameDate(var8, var3) && var7.isSelectable()) {
                  return new CalendarPickerView.MonthCellWithMonthIndex(var7, var2);
               }
            }
         }
      }

      return null;
   }

   private boolean isDateSelectable(Date var1) {
      return this.dateConfiguredListener == null || this.dateConfiguredListener.isDateSelectable(var1);
   }

   private static Calendar maxDate(List var0) {
      if(var0 != null && var0.size() != 0) {
         Collections.sort(var0);
         return (Calendar)var0.get(var0.size() - 1);
      } else {
         return null;
      }
   }

   private static Calendar minDate(List var0) {
      if(var0 != null && var0.size() != 0) {
         Collections.sort(var0);
         return (Calendar)var0.get(0);
      } else {
         return null;
      }
   }

   private static boolean sameDate(Calendar var0, Calendar var1) {
      return var0.get(2) == var1.get(2) && var0.get(1) == var1.get(1) && var0.get(5) == var1.get(5);
   }

   private static boolean sameMonth(Calendar var0, MonthDescriptor var1) {
      return var0.get(2) == var1.getMonth() && var0.get(1) == var1.getYear();
   }

   private void scrollToSelectedDates() {
      Integer var3 = null;
      Integer var4 = null;
      Calendar var7 = Calendar.getInstance(this.locale);

      Integer var6;
      for(int var1 = 0; var1 < this.months.size(); var4 = var6) {
         MonthDescriptor var8 = (MonthDescriptor)this.months.get(var1);
         Integer var5 = var3;
         var6 = var4;
         if(var3 == null) {
            Iterator var9 = this.selectedCals.iterator();

            Integer var2;
            while(true) {
               var2 = var3;
               if(!var9.hasNext()) {
                  break;
               }

               if(sameMonth((Calendar)var9.next(), var8)) {
                  var2 = Integer.valueOf(var1);
                  break;
               }
            }

            var5 = var2;
            var6 = var4;
            if(var2 == null) {
               var5 = var2;
               var6 = var4;
               if(var4 == null) {
                  var5 = var2;
                  var6 = var4;
                  if(sameMonth(var7, var8)) {
                     var6 = Integer.valueOf(var1);
                     var5 = var2;
                  }
               }
            }
         }

         ++var1;
         var3 = var5;
      }

      if(var3 != null) {
         this.scrollToSelectedMonth(var3.intValue());
      } else if(var4 != null) {
         this.scrollToSelectedMonth(var4.intValue());
         return;
      }

   }

   private void scrollToSelectedMonth(int var1) {
      this.scrollToSelectedMonth(var1, false);
   }

   private void scrollToSelectedMonth(final int var1, final boolean var2) {
      this.post(new Runnable() {
         public void run() {
            Logr.d("Scrolling to position %d", new Object[]{Integer.valueOf(var1)});
            if(var2) {
               CalendarPickerView.this.smoothScrollToPosition(var1);
            } else {
               CalendarPickerView.this.setSelection(var1);
            }
         }
      });
   }

   static void setMidnight(Calendar var0) {
      var0.set(11, 0);
      var0.set(12, 0);
      var0.set(13, 0);
      var0.set(14, 0);
   }

   private void validateAndUpdate() {
      if(this.getAdapter() == null) {
         this.setAdapter(this.adapter);
      }

      this.adapter.notifyDataSetChanged();
   }

   private void validateDate(Date var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Selected date must be non-null.");
      } else if(var1.getTime() == 0L) {
         throw new IllegalArgumentException("Selected date must be non-zero.  " + var1);
      } else if(var1.before(this.minCal.getTime()) || var1.after(this.maxCal.getTime())) {
         throw new IllegalArgumentException(String.format("SelectedDate must be between minDate and maxDate.%nminDate: %s%nmaxDate: %s%nselectedDate: %s", new Object[]{this.minCal.getTime(), this.maxCal.getTime(), var1}));
      }
   }

   public void fixDialogDimens() {
      Logr.d("Fixing dimensions to h = %d / w = %d", new Object[]{Integer.valueOf(this.getMeasuredHeight()), Integer.valueOf(this.getMeasuredWidth())});
      this.getLayoutParams().height = this.getMeasuredHeight();
      this.getLayoutParams().width = this.getMeasuredWidth();
      this.post(new Runnable() {
         public void run() {
            Logr.d("Dimens are fixed: now scroll to the selected date");
            CalendarPickerView.this.scrollToSelectedDates();
         }
      });
   }

   List getMonthCells(MonthDescriptor var1, Calendar var2) {
      Calendar var11 = Calendar.getInstance(this.locale);
      var11.setTime(var2.getTime());
      ArrayList var12 = new ArrayList();
      var11.set(5, 1);
      int var3 = var11.get(7);
      int var4 = var11.getFirstDayOfWeek() - var3;
      var3 = var4;
      if(var4 > 0) {
         var3 = var4 - 7;
      }

      var11.add(5, var3);
      Calendar var13 = minDate(this.selectedCals);
      Calendar var14 = maxDate(this.selectedCals);

      while((var11.get(2) < var1.getMonth() + 1 || var11.get(1) < var1.getYear()) && var11.get(1) <= var1.getYear()) {
         Logr.d("Building week row starting at %s", new Object[]{var11.getTime()});
         ArrayList var15 = new ArrayList();
         var12.add(var15);

         for(var3 = 0; var3 < 7; ++var3) {
            Date var16 = var11.getTime();
            boolean var5;
            if(var11.get(2) == var1.getMonth()) {
               var5 = true;
            } else {
               var5 = false;
            }

            boolean var6;
            if(var5 && containsDate(this.selectedCals, var11)) {
               var6 = true;
            } else {
               var6 = false;
            }

            boolean var7;
            if(var5 && betweenDates(var11, this.minCal, this.maxCal) && this.isDateSelectable(var16)) {
               var7 = true;
            } else {
               var7 = false;
            }

            boolean var8 = sameDate(var11, this.today);
            boolean var9 = containsDate(this.highlightedCals, var11);
            var4 = var11.get(5);
            MonthCellDescriptor.RangeState var10 = MonthCellDescriptor.RangeState.NONE;
            MonthCellDescriptor.RangeState var17 = var10;
            if(this.selectedCals.size() > 1) {
               if(sameDate(var13, var11)) {
                  var17 = MonthCellDescriptor.RangeState.FIRST;
               } else if(sameDate(maxDate(this.selectedCals), var11)) {
                  var17 = MonthCellDescriptor.RangeState.LAST;
               } else {
                  var17 = var10;
                  if(betweenDates(var11, var13, var14)) {
                     var17 = MonthCellDescriptor.RangeState.MIDDLE;
                  }
               }
            }

            var15.add(new MonthCellDescriptor(var16, var5, var7, var6, var8, var9, var4, var17));
            var11.add(5, 1);
         }
      }

      return var12;
   }

   public Date getSelectedDate() {
      return this.selectedCals.size() > 0?((Calendar)this.selectedCals.get(0)).getTime():null;
   }

   public List getSelectedDates() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.selectedCells.iterator();

      while(var2.hasNext()) {
         var1.add(((MonthCellDescriptor)var2.next()).getDate());
      }

      Collections.sort(var1);
      return var1;
   }

   public void highlightDates(Collection param1) {
      // $FF: Couldn't be decompiled
   }

   public CalendarPickerView.FluentInitializer init(Date var1, Date var2) {
      return this.init(var1, var2, Locale.getDefault());
   }

   public CalendarPickerView.FluentInitializer init(Date var1, Date var2, Locale var3) {
      if(var1 != null && var2 != null) {
         if(var1.after(var2)) {
            throw new IllegalArgumentException("minDate must be before maxDate.  " + dbg(var1, var2));
         } else if(var1.getTime() != 0L && var2.getTime() != 0L) {
            if(var3 == null) {
               throw new IllegalArgumentException("Locale is null.");
            } else {
               this.locale = var3;
               this.today = Calendar.getInstance(var3);
               this.minCal = Calendar.getInstance(var3);
               this.maxCal = Calendar.getInstance(var3);
               this.monthCounter = Calendar.getInstance(var3);
               this.monthNameFormat = new SimpleDateFormat(this.getContext().getString(R.string.month_name_format), var3);
               Iterator var6 = this.months.iterator();

               while(var6.hasNext()) {
                  MonthDescriptor var7 = (MonthDescriptor)var6.next();
                  var7.setLabel(this.monthNameFormat.format(var7.getDate()));
               }

               this.weekdayNameFormat = new SimpleDateFormat(this.getContext().getString(R.string.day_name_format), var3);
               this.fullDateFormat = DateFormat.getDateInstance(2, var3);
               this.selectionMode = CalendarPickerView.SelectionMode.SINGLE;
               this.selectedCals.clear();
               this.selectedCells.clear();
               this.highlightedCals.clear();
               this.highlightedCells.clear();
               this.cells.clear();
               this.months.clear();
               this.minCal.setTime(var1);
               this.maxCal.setTime(var2);
               setMidnight(this.minCal);
               setMidnight(this.maxCal);
               this.displayOnly = false;
               this.maxCal.add(12, -1);
               this.monthCounter.setTime(this.minCal.getTime());
               int var4 = this.maxCal.get(2);
               int var5 = this.maxCal.get(1);

               while((this.monthCounter.get(2) <= var4 || this.monthCounter.get(1) < var5) && this.monthCounter.get(1) < var5 + 1) {
                  var1 = this.monthCounter.getTime();
                  MonthDescriptor var8 = new MonthDescriptor(this.monthCounter.get(2), this.monthCounter.get(1), var1, this.monthNameFormat.format(var1));
                  this.cells.add(this.getMonthCells(var8, this.monthCounter));
                  Logr.d("Adding month %s", new Object[]{var8});
                  this.months.add(var8);
                  this.monthCounter.add(2, 1);
               }

               this.validateAndUpdate();
               return new CalendarPickerView.FluentInitializer();
            }
         } else {
            throw new IllegalArgumentException("minDate and maxDate must be non-zero.  " + dbg(var1, var2));
         }
      } else {
         throw new IllegalArgumentException("minDate and maxDate must be non-null.  " + dbg(var1, var2));
      }
   }

   protected void onMeasure(int var1, int var2) {
      if(this.months.isEmpty()) {
         throw new IllegalStateException("Must have at least one month to display.  Did you forget to call init()?");
      } else {
         super.onMeasure(var1, var2);
      }
   }

   public boolean selectDate(Date var1) {
      return this.selectDate(var1, false);
   }

   public boolean selectDate(Date var1, boolean var2) {
      this.validateDate(var1);
      CalendarPickerView.MonthCellWithMonthIndex var5 = this.getMonthCellWithIndexByDate(var1);
      boolean var3;
      if(var5 != null && this.isDateSelectable(var1)) {
         boolean var4 = this.doSelectDate(var1, var5.cell);
         var3 = var4;
         if(var4) {
            this.scrollToSelectedMonth(var5.monthIndex, var2);
            return var4;
         }
      } else {
         var3 = false;
      }

      return var3;
   }

   public void setDateSelectableFilter(CalendarPickerView.DateSelectableFilter var1) {
      this.dateConfiguredListener = var1;
   }

   public void setDayTextColor(int var1) {
      ColorStateList var2 = this.getResources().getColorStateList(this.dayTextColorResId);
      int[][] var3 = new int[][]{{16842913}, {16842919}, {-R.attr.state_current_month}, {R.attr.state_today}, {-R.attr.state_selectable}, new int[0]};
      this.dayTextColorList = new ColorStateList(var3, new int[]{var2.getColorForState(var3[0], 0), var2.getColorForState(var3[1], 0), var2.getColorForState(var3[2], 0), var2.getColorForState(var3[3], 0), var2.getColorForState(var3[4], 0), var1});
      this.validateAndUpdate();
   }

   public void setOnDateSelectedListener(CalendarPickerView.OnDateSelectedListener var1) {
      this.dateListener = var1;
   }

   public void setOnInvalidDateSelectedListener(CalendarPickerView.OnInvalidDateSelectedListener var1) {
      this.invalidDateListener = var1;
   }

   public void unfixDialogDimens() {
      Logr.d("Reset the fixed dimensions to allow for re-measurement");
      this.getLayoutParams().height = -1;
      this.getLayoutParams().width = -1;
      this.requestLayout();
   }

   private class CellClickedListener implements MonthView.Listener {
      private CellClickedListener() {
      }

      // $FF: synthetic method
      CellClickedListener(Object var2) {
         this();
      }

      public void handleClick(MonthCellDescriptor var1) {
         Date var3 = var1.getDate();
         if(CalendarPickerView.betweenDates(var3, CalendarPickerView.this.minCal, CalendarPickerView.this.maxCal) && CalendarPickerView.this.isDateSelectable(var3)) {
            boolean var2 = CalendarPickerView.this.doSelectDate(var3, var1);
            if(CalendarPickerView.this.dateListener != null) {
               if(var2) {
                  CalendarPickerView.this.dateListener.onDateSelected(var3);
                  return;
               }

               CalendarPickerView.this.dateListener.onDateUnselected(var3);
               return;
            }
         } else if(CalendarPickerView.this.invalidDateListener != null) {
            CalendarPickerView.this.invalidDateListener.onInvalidDateSelected(var3);
         }

      }
   }

   public interface DateSelectableFilter {
      boolean isDateSelectable(Date var1);
   }

   private class DefaultOnInvalidDateSelectedListener implements CalendarPickerView.OnInvalidDateSelectedListener {
      private DefaultOnInvalidDateSelectedListener() {
      }

      // $FF: synthetic method
      DefaultOnInvalidDateSelectedListener(Object var2) {
         this();
      }

      public void onInvalidDateSelected(Date var1) {
         String var2 = CalendarPickerView.this.getResources().getString(R.string.invalid_date, new Object[]{CalendarPickerView.this.fullDateFormat.format(CalendarPickerView.this.minCal.getTime()), CalendarPickerView.this.fullDateFormat.format(CalendarPickerView.this.maxCal.getTime())});
         Toast.makeText(CalendarPickerView.this.getContext(), var2, 0).show();
      }
   }

   public class FluentInitializer {
      public CalendarPickerView.FluentInitializer displayOnly() {
         CalendarPickerView.this.displayOnly = true;
         return this;
      }

      public CalendarPickerView.FluentInitializer inMode(CalendarPickerView.SelectionMode var1) {
         CalendarPickerView.this.selectionMode = var1;
         CalendarPickerView.this.validateAndUpdate();
         return this;
      }

      public CalendarPickerView.FluentInitializer setShortWeekdays(String[] var1) {
         DateFormatSymbols var2 = new DateFormatSymbols(CalendarPickerView.this.locale);
         var2.setShortWeekdays(var1);
         CalendarPickerView.this.weekdayNameFormat = new SimpleDateFormat(CalendarPickerView.this.getContext().getString(R.string.day_name_format), var2);
         return this;
      }

      public CalendarPickerView.FluentInitializer withHighlightedDate(Date var1) {
         return this.withHighlightedDates(Arrays.asList(new Date[]{var1}));
      }

      public CalendarPickerView.FluentInitializer withHighlightedDates(Collection var1) {
         CalendarPickerView.this.highlightDates(var1);
         return this;
      }

      public CalendarPickerView.FluentInitializer withSelectedDate(Date var1) {
         return this.withSelectedDates(Arrays.asList(new Date[]{var1}));
      }

      public CalendarPickerView.FluentInitializer withSelectedDates(Collection var1) {
         if(CalendarPickerView.this.selectionMode == CalendarPickerView.SelectionMode.SINGLE && var1.size() > 1) {
            throw new IllegalArgumentException("SINGLE mode can\'t be used with multiple selectedDates");
         } else {
            if(var1 != null) {
               Iterator var3 = var1.iterator();

               while(var3.hasNext()) {
                  Date var2 = (Date)var3.next();
                  CalendarPickerView.this.selectDate(var2);
               }
            }

            CalendarPickerView.this.validateAndUpdate();
            return this;
         }
      }
   }

   private class MonthAdapter extends BaseAdapter {
      private final LayoutInflater inflater;

      private MonthAdapter() {
         this.inflater = LayoutInflater.from(CalendarPickerView.this.getContext());
      }

      // $FF: synthetic method
      MonthAdapter(Object var2) {
         this();
      }

      public int getCount() {
         return CalendarPickerView.this.months.size();
      }

      public Object getItem(int var1) {
         return CalendarPickerView.this.months.get(var1);
      }

      public long getItemId(int var1) {
         return (long)var1;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         MonthView var4 = (MonthView)var2;
         MonthView var5 = var4;
         if(var4 == null) {
            var5 = MonthView.create(var3, this.inflater, CalendarPickerView.this.weekdayNameFormat, CalendarPickerView.this.listener, CalendarPickerView.this.today, CalendarPickerView.this.dividerColor, CalendarPickerView.this.dayBackgroundResId, CalendarPickerView.this.dayTextColorResId, CalendarPickerView.this.titleTextColor, CalendarPickerView.this.headerTextColor);
         }

         var5.init((MonthDescriptor)CalendarPickerView.this.months.get(var1), (List)CalendarPickerView.this.cells.get(var1), CalendarPickerView.this.displayOnly, CalendarPickerView.this.dayTextColorList);
         return var5;
      }

      public boolean isEnabled(int var1) {
         return false;
      }
   }

   private static class MonthCellWithMonthIndex {
      public MonthCellDescriptor cell;
      public int monthIndex;

      public MonthCellWithMonthIndex(MonthCellDescriptor var1, int var2) {
         this.cell = var1;
         this.monthIndex = var2;
      }
   }

   public interface OnDateSelectedListener {
      void onDateSelected(Date var1);

      void onDateUnselected(Date var1);
   }

   public interface OnInvalidDateSelectedListener {
      void onInvalidDateSelected(Date var1);
   }

   public static enum SelectionMode {
      MULTIPLE,
      RANGE,
      SINGLE;
   }
}
