package com.parallel6.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.ui.adapters.base.CRBaseAdapter;
import com.parallel6.ui.models.CalendarEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CRCalendarEventAdapter extends CRBaseAdapter {
   private OnClickListener calendarEventClickListener = new OnClickListener() {
      public void onClick(View var1) {
         CRCalendarEventAdapter.CalendarViewHolder var2 = (CRCalendarEventAdapter.CalendarViewHolder)var1.getTag();
         if(CRCalendarEventAdapter.this.calendarEventItemListener != null) {
            CRCalendarEventAdapter.this.calendarEventItemListener.onCalendarEventEdit(var2.calendarEventModel);
         }

      }
   };
   private CRCalendarEventAdapter.CalendarEventItemListener calendarEventItemListener;
   private DateFormat dateFormat;
   private SimpleDateFormat timeFormat;
   private CRCalendarEventAdapter.CalendarViewHolder viewHolder = null;

   public CRCalendarEventAdapter(Context var1, List var2, CRCalendarEventAdapter.CalendarEventItemListener var3) {
      super.mContext = var1;
      super.mObjectList = var2;
      super.mObjectList.add(new CalendarEvent());
      this.calendarEventItemListener = var3;
      this.dateFormat = DateFormat.getDateInstance(2, Locale.getDefault());
      this.timeFormat = new SimpleDateFormat(var1.getString(R.string.hour_minute_format));
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      CalendarEvent var6 = (CalendarEvent)this.getItem(var1);
      if(var2 == null) {
         var2 = View.inflate(this.mContext, R.layout.row_calendar_event, (ViewGroup)null);
         var2.setOnClickListener(this.calendarEventClickListener);
         this.viewHolder = new CRCalendarEventAdapter.CalendarViewHolder(var2, var6);
         var2.setTag(this.viewHolder);
      } else {
         this.viewHolder = (CRCalendarEventAdapter.CalendarViewHolder)var2.getTag();
         this.viewHolder.setModel(var6);
      }

      if(this.viewHolder != null) {
         long var4 = var6.getMillis();
         this.viewHolder.calendarEventDate.setText(this.dateFormat.format(Long.valueOf(var4)));
         this.viewHolder.calendarEventLocation.setText(var6.getLocation());
         this.viewHolder.calendarEventTime.setText(this.timeFormat.format(Long.valueOf(var4)));
         this.viewHolder.calendarEventNotes.setText(var6.getNotes());
         this.viewHolder.calendarEventType.setText(var6.getType());
      }

      return var2;
   }

   public interface CalendarEventItemListener {
      void onCalendarEventAdd();

      void onCalendarEventEdit(CalendarEvent var1);
   }

   private static class CalendarViewHolder {
      private TextView calendarEventDate;
      private TextView calendarEventLocation;
      private CalendarEvent calendarEventModel;
      private TextView calendarEventNotes;
      private TextView calendarEventTime;
      private TextView calendarEventType;

      public CalendarViewHolder(View var1, CalendarEvent var2) {
         this.calendarEventDate = (TextView)var1.findViewById(R.id.row_calendar_event_tv_date);
         this.calendarEventLocation = (TextView)var1.findViewById(R.id.row_calendar_event_tv_location);
         this.calendarEventTime = (TextView)var1.findViewById(R.id.row_calendar_event_tv_time);
         this.calendarEventNotes = (TextView)var1.findViewById(R.id.row_calendar_event_tv_note);
         this.calendarEventType = (TextView)var1.findViewById(R.id.row_calendar_event_tv_type);
         this.setModel(var2);
      }

      public void setModel(CalendarEvent var1) {
         this.calendarEventModel = var1;
      }
   }
}
