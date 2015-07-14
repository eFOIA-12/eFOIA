package com.parallel6.ui.fragments.calendar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.configurability.models.CRConfLayoutModule;
import com.parallel6.ui.configurability.models.CRConfLayoutSlot;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.FragmentState;
import com.parallel6.ui.widgets.calendar.CalendarPickerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class CalendarViewFragment extends RelativeLayout {
   private static final String DAY_TEXT_COLOR = "textcolor";
   private CalendarPickerView calendar;
   private Date currentSelectedDate;
   private ArrayList dates;
   private Date maxdate;
   private Date mindate;
   private FragmentState parentFragment;

   public CalendarViewFragment(Context var1) {
      super(var1);
   }

   public CalendarViewFragment(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public CalendarViewFragment(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private void initViews(int var1) {
      this.calendar = (CalendarPickerView)this.findViewById(R.id.fragment_calendar_calendarview);
      this.calendar.setDayTextColor(var1);
      this.calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
         public void onDateSelected(Date var1) {
            CalendarViewFragment.this.currentSelectedDate = var1;
            CalendarViewFragment.this.currentSelectedDate.setHours(0);
            CalendarViewFragment.this.currentSelectedDate.setMinutes(0);
            Calendar var2 = Calendar.getInstance();
            var2.setTime(CalendarViewFragment.this.currentSelectedDate);
            CRMessage var3 = new CRMessage(-1412628464, new Object[]{Long.valueOf(var2.getTimeInMillis())});
            CalendarViewFragment.this.parentFragment.handleMessage(var3);
         }

         public void onDateUnselected(Date var1) {
         }
      });
      this.calendar.init(this.mindate, this.maxdate).inMode(CalendarPickerView.SelectionMode.SINGLE).withSelectedDate(this.currentSelectedDate).withHighlightedDates(this.dates);
   }

   public void initTab(FragmentState var1, ArrayList var2, Date var3, Date var4, Date var5, CRConfLayoutModule var6) {
      this.parentFragment = var1;
      this.dates = var2;
      this.mindate = var4;
      this.maxdate = var5;
      this.currentSelectedDate = var3;
      int var7 = this.getContext().getResources().getColor(R.color.bg_button_edit);
      int var8 = var7;
      if(var6 != null) {
         Iterator var9 = var6.getLayoutSlots().iterator();

         while(true) {
            var8 = var7;
            if(!var9.hasNext()) {
               break;
            }

            CRConfLayoutSlot var10 = (CRConfLayoutSlot)var9.next();
            if(var10.getAttributeKey().equals("textcolor")) {
               var7 = Color.parseColor(String.format("#%s", new Object[]{var10.getStyle().getFontColor()}));
            }
         }
      }

      this.initViews(var8);
   }

   public void refresh() {
      if(this.calendar != null) {
         this.calendar.highlightDates(this.dates);
         this.calendar.selectDate(this.currentSelectedDate);
      }

   }
}
