package com.parallel6.ui.fragments.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.adapters.CRCalendarEventAdapter;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;
import com.parallel6.ui.models.CalendarEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CalendarEventListFragment extends RelativeLayout {
   private CRCalendarEventAdapter.CalendarEventItemListener calendarItemListener = new CRCalendarEventAdapter.CalendarEventItemListener() {
      public void onCalendarEventAdd() {
         if(CalendarEventListFragment.this.selectedMillis > 0L) {
            CalendarEventListFragment.this.controller.handleMessage(new CRMessage(-1412628463, new Object[]{Long.valueOf(CalendarEventListFragment.this.mindate.getTime()), Long.valueOf(CalendarEventListFragment.this.maxdate.getTime()), Long.valueOf(CalendarEventListFragment.this.selectedMillis)}));
         } else {
            CalendarEventListFragment.this.controller.handleMessage(new CRMessage(-1412628463, new Object[]{Long.valueOf(CalendarEventListFragment.this.mindate.getTime()), Long.valueOf(CalendarEventListFragment.this.maxdate.getTime())}));
         }
      }

      public void onCalendarEventEdit(CalendarEvent var1) {
         CalendarEventListFragment.this.controller.handleMessage(new CRMessage(-1412628463, new Object[]{Long.valueOf(CalendarEventListFragment.this.mindate.getTime()), Long.valueOf(CalendarEventListFragment.this.maxdate.getTime()), var1}));
      }
   };
   private ControllerState controller;
   private List eventList = new ArrayList();
   private ListView eventListView;
   private CRCalendarEventAdapter listAdapter;
   private Date maxdate;
   private Date mindate;
   private CalendarEventListFragment.EventComparator pComparator;
   private long selectedMillis;

   public CalendarEventListFragment(Context var1) {
      super(var1);
   }

   public CalendarEventListFragment(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public CalendarEventListFragment(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public void initTab(List var1, Date var2, Date var3, ControllerState var4) {
      this.eventList = var1;
      this.controller = var4;
      this.mindate = var2;
      this.maxdate = var3;
      this.initViews();
   }

   public void initTab(List var1, Date var2, Date var3, ControllerState var4, long var5) {
      this.selectedMillis = var5;
      this.pComparator = new CalendarEventListFragment.EventComparator();
      this.initTab(var1, var2, var3, var4);
   }

   public void initViews() {
      Collections.sort(this.eventList, this.pComparator);
      this.eventListView = (ListView)this.findViewById(R.id.fragment_calendar_list);
      if(this.listAdapter == null) {
         this.listAdapter = new CRCalendarEventAdapter(this.getContext(), this.eventList, this.calendarItemListener);
         this.eventListView.setAdapter(this.listAdapter);
      } else {
         this.listAdapter.notifyDataSetChanged();
      }
   }

   class EventComparator implements Comparator {
      public int compare(CalendarEvent var1, CalendarEvent var2) {
         return var1.getMillis() < var2.getMillis()?-1:1;
      }
   }
}
