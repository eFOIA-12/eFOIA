package com.parallel6.ui.configurability.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.configurability.models.CRConfLayoutModule;
import com.parallel6.ui.database.my_calendar.CalendarDao;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.fragments.calendar.CalendarEventListFragment;
import com.parallel6.ui.fragments.calendar.CalendarViewFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.models.CalendarEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class CRConfCalendarFragment extends BaseFragment {
   private static boolean isUpdated;
   private int SELECTED_TAB_COLOR;
   private int UNSELECTED_TAB_COLOR;
   private CRConfCalendarFragment.MyCalendarTab activeTab;
   private TextView calendarBtn;
   private CalendarDao calendarDao;
   private CalendarViewFragment calendarTab;
   private FrameLayout containerLayout;
   private Date currentSelectedDate;
   private String currentTitle;
   private ArrayList dates = new ArrayList();
   private List eventList;
   private CRConfLayoutModule layoutModel;
   private TextView listBtn;
   private CalendarEventListFragment listViewTab;
   private Date maxDate;
   private Date minDate;
   private OnClickListener onClickListener = new OnClickListener() {
      public void onClick(View var1) {
         if(var1 == CRConfCalendarFragment.this.calendarBtn) {
            CRConfCalendarFragment.this.activeTab = CRConfCalendarFragment.MyCalendarTab.Calendar;
         } else if(var1 == CRConfCalendarFragment.this.listBtn) {
            CRConfCalendarFragment.this.activeTab = CRConfCalendarFragment.MyCalendarTab.List;
         }

         CRConfCalendarFragment.this.showActiveTab();
      }
   };
   private final int yearOffset = 1;

   private void queryAllEvents() {
      this.eventList.clear();
      this.dates.clear();
      this.eventList = this.calendarDao.getAllEvents((String)null);
      if(this.eventList.size() > 0) {
         Iterator var1 = this.eventList.iterator();

         while(var1.hasNext()) {
            Date var2 = new Date(((CalendarEvent)var1.next()).getMillis());
            this.dates.add(var2);
         }
      }

   }

   private void queryEventsOfSelectedDate() {
      GregorianCalendar var1 = new GregorianCalendar();
      var1.setTime(this.currentSelectedDate);
      var1.add(5, 1);
      var1.add(13, -1);
      this.queryEventsOfSelectedDate(this.currentSelectedDate, var1.getTime());
   }

   private void queryEventsOfSelectedDate(Date var1, Date var2) {
      this.eventList.clear();
      this.dates.clear();
      List var3 = this.calendarDao.getAllEvents((String)null);
      if(var3.size() > 0) {
         Iterator var6 = var3.iterator();

         while(var6.hasNext()) {
            CalendarEvent var4 = (CalendarEvent)var6.next();
            Date var5 = new Date(var4.getMillis());
            if(!var5.before(var1) && !var5.after(var2)) {
               this.eventList.add(var4);
               this.dates.add(var5);
            }
         }
      }

   }

   private void setButtons(CRConfCalendarFragment.MyCalendarTab var1) {
      if(var1 == CRConfCalendarFragment.MyCalendarTab.Calendar) {
         this.calendarBtn.setBackgroundColor(this.UNSELECTED_TAB_COLOR);
         this.listBtn.setBackgroundColor(this.SELECTED_TAB_COLOR);
      } else if(var1 == CRConfCalendarFragment.MyCalendarTab.List) {
         this.calendarBtn.setBackgroundColor(this.SELECTED_TAB_COLOR);
         this.listBtn.setBackgroundColor(this.UNSELECTED_TAB_COLOR);
         return;
      }

   }

   private void setCurrentSelectedDate(Date var1) {
      this.currentSelectedDate = var1;
      this.currentSelectedDate.setHours(0);
      this.currentSelectedDate.setMinutes(0);
   }

   public static void setIsUpdated(boolean var0) {
      isUpdated = var0;
   }

   protected View getFragmentActionBarView(Context var1) {
      View var2 = View.inflate(var1, R.layout.actionbar_custom, (ViewGroup)null);
      TextView var3 = (TextView)var2.findViewById(R.id.actionbar_tv_title);
      String var4;
      if(StringUtils.isNotEmpty(this.getFragmentTitle())) {
         var4 = this.getFragmentTitle();
      } else {
         var4 = "";
      }

      var3.setText(var4);
      ImageView var5;
      if(this.activeTab == CRConfCalendarFragment.MyCalendarTab.Calendar) {
         var5 = (ImageView)var2.findViewById(R.id.actionbar_right_action);
         var5.setImageResource(R.drawable.ic_add);
         var5.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               long var2 = CRConfCalendarFragment.this.currentSelectedDate.getTime();
               if(var2 > 0L) {
                  CRConfCalendarFragment.this.controller.handleMessage(new CRMessage(-1412628463, new Object[]{Long.valueOf(CRConfCalendarFragment.this.minDate.getTime()), Long.valueOf(CRConfCalendarFragment.this.maxDate.getTime()), Long.valueOf(var2)}));
               } else {
                  CRConfCalendarFragment.this.controller.handleMessage(new CRMessage(-1412628463, new Object[]{Long.valueOf(CRConfCalendarFragment.this.minDate.getTime()), Long.valueOf(CRConfCalendarFragment.this.maxDate.getTime())}));
               }
            }
         });
      }

      var5 = (ImageView)var2.findViewById(R.id.actionbar_left_action);
      var5.setImageResource(R.drawable.ic_back);
      var5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            CRConfCalendarFragment.this.controller.handleMessage(-1412628478);
         }
      });
      return var2;
   }

   protected String getFragmentTitle() {
      return this.currentTitle;
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      long var2 = ((Long)var1.getData()[0]).longValue();
      this.setCurrentSelectedDate(new Date(var2));
      this.queryEventsOfSelectedDate();
      if(this.eventList.size() == 0) {
         this.controller.handleMessage(new CRMessage(-1412628463, new Object[]{Long.valueOf(this.minDate.getTime()), Long.valueOf(this.maxDate.getTime()), Long.valueOf(var2)}));
         return false;
      } else {
         this.selectedDateListTab(var2);
         return false;
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.layoutModel = (CRConfLayoutModule)this.getArguments().getParcelable("extras_layout_model");
      this.activeTab = CRConfCalendarFragment.MyCalendarTab.Calendar;
      this.calendarDao = new CalendarDao(this.getActivity());
      this.dates = new ArrayList();
      this.eventList = new ArrayList();
      Calendar var2 = Calendar.getInstance();
      var2.add(1, 1);
      this.maxDate = var2.getTime();
      var2.add(1, -2);
      this.minDate = var2.getTime();
      if(this.currentSelectedDate == null) {
         this.setCurrentSelectedDate(new Date());
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_my_calendar, (ViewGroup)null);
   }

   public void onRefresh() {
      super.onRefresh();
      if(isUpdated) {
         isUpdated = false;
         this.showActiveTab();
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.SELECTED_TAB_COLOR = this.getResources().getColor(R.color.calendar_selected_tab);
      this.UNSELECTED_TAB_COLOR = this.getResources().getColor(R.color.calendar_unselected_tab);
      this.containerLayout = (FrameLayout)var1.findViewById(R.id.fragment_my_calendar_content);
      this.calendarBtn = (TextView)var1.findViewById(R.id.fragment_my_calendar_btn_calendar);
      this.listBtn = (TextView)var1.findViewById(R.id.fragment_my_calendar_btn_list);
      this.calendarBtn.setOnClickListener(this.onClickListener);
      this.listBtn.setOnClickListener(this.onClickListener);
      this.showActiveTab();
   }

   public void selectedDateListTab(long var1) {
      if(this.containerLayout != null) {
         this.containerLayout.removeAllViews();
      }

      this.activeTab = CRConfCalendarFragment.MyCalendarTab.List;
      this.calendarBtn.setBackgroundColor(this.SELECTED_TAB_COLOR);
      this.listBtn.setBackgroundColor(this.UNSELECTED_TAB_COLOR);
      CalendarEventListFragment var3 = (CalendarEventListFragment)View.inflate(this.getActivity(), R.layout.fragment_calendar_list_view, (ViewGroup)null);
      var3.initTab(this.eventList, this.minDate, this.maxDate, this.controller, var1);
      this.containerLayout.addView(var3);
      this.currentTitle = "ListView";
      this.initTopActionBar();
   }

   public void showActiveTab() {
      if(this.containerLayout != null) {
         this.containerLayout.removeAllViews();
      }

      this.queryAllEvents();
      this.setButtons(this.activeTab);
      switch(null.$SwitchMap$com$parallel6$ui$configurability$fragments$CRConfCalendarFragment$MyCalendarTab[this.activeTab.ordinal()]) {
      case 1:
         this.currentTitle = this.getString(R.string.calendar_view);
         if(this.calendarTab == null) {
            this.calendarTab = (CalendarViewFragment)View.inflate(this.getActivity(), R.layout.fragment_calendar_view, (ViewGroup)null);
            this.calendarTab.initTab(this, this.dates, this.currentSelectedDate, this.minDate, this.maxDate, this.layoutModel);
         } else {
            this.calendarTab.refresh();
         }

         this.containerLayout.addView(this.calendarTab);
         break;
      case 2:
         this.currentTitle = this.getString(R.string.list_view);
         this.listViewTab = (CalendarEventListFragment)View.inflate(this.getActivity(), R.layout.fragment_calendar_list_view, (ViewGroup)null);
         this.listViewTab.initTab(this.eventList, this.minDate, this.maxDate, this.controller);
         this.containerLayout.addView(this.listViewTab);
      }

      this.initTopActionBar();
   }

   public static enum MyCalendarTab {
      Calendar,
      List;
   }
}
