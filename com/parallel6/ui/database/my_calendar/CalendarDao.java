package com.parallel6.ui.database.my_calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.parallel6.ui.database.my_calendar.CalendarDatabaseHelper;
import com.parallel6.ui.enums.CalendarEventTone;
import com.parallel6.ui.models.CalendarEvent;
import java.util.ArrayList;
import java.util.List;

public class CalendarDao {
   public static final String DEFAULT_LOGGED_NAME = "XX";
   public static final String KEY_DATE = "event_date";
   public static final String KEY_INDEX = "event_index";
   public static final String KEY_REMINDER = "event_reminder";
   public static final String KEY_TIME = "event_time";
   public static final String KEY_TYPE = "event_type";
   public static final String KEY_USERNAME = "event_username";
   public static final String TABLE_EVENT = "calendar_events_table";
   public static final String TONE_TYPE = "event_tone_type";
   private static CalendarDatabaseHelper checkInDatabaseHelper;
   private Context context;
   private SQLiteDatabase db;

   public CalendarDao(Context var1) {
      this.context = var1;
   }

   private void close() {
      this.db.close();
   }

   private CalendarDatabaseHelper getCheckInDatabaseHelperInstance() {
      if(checkInDatabaseHelper == null) {
         checkInDatabaseHelper = new CalendarDatabaseHelper(this.context);
      }

      return checkInDatabaseHelper;
   }

   private CalendarEvent getEventDataFromCursor(Cursor var1) {
      CalendarEvent var2 = new CalendarEvent();
      var2.setId(var1.getLong(var1.getColumnIndex("_id")));
      var2.setInxex(var1.getLong(var1.getColumnIndex("event_index")));
      var2.setNotes(var1.getString(var1.getColumnIndex("description")));
      var2.setType(var1.getString(var1.getColumnIndex("event_type")));
      var2.setMillis(var1.getLong(var1.getColumnIndex("dtstart")));
      var2.setAppointmentDate(var1.getString(var1.getColumnIndex("event_date")));
      var2.setTime(var1.getString(var1.getColumnIndex("event_time")));
      var2.setEventTone(CalendarEventTone.values()[var1.getInt(var1.getColumnIndex("event_tone_type"))]);
      var2.setLocation(var1.getString(var1.getColumnIndex("eventLocation")));
      var2.setReminderIndex(var1.getInt(var1.getColumnIndex("event_reminder")));
      return var2;
   }

   private ContentValues getValuesFromModel(CalendarEvent var1, String var2) {
      String var3 = var2;
      if(var2 == null) {
         var3 = "XX";
      }

      ContentValues var4 = new ContentValues();
      var4.put("_id", Long.valueOf(var1.getId()));
      if(var1.getIndex() != -1L) {
         var4.put("event_index", Long.valueOf(var1.getIndex()));
      }

      var4.put("description", var1.getNotes());
      if(var1.getEventTone() != null) {
         var4.put("event_tone_type", Integer.valueOf(var1.getEventTone().ordinal()));
      }

      var4.put("dtstart", Long.valueOf(var1.getMillis()));
      var4.put("event_username", var3);
      var4.put("eventLocation", var1.getLocation());
      var4.put("event_date", var1.getAppointmentDate());
      var4.put("event_type", var1.getType());
      var4.put("event_time", var1.getTime());
      var4.put("event_reminder", Integer.valueOf(var1.getReminderIndex()));
      return var4;
   }

   private boolean isTableExist(String var1) {
      boolean var3 = false;
      Cursor var4 = this.db.rawQuery("SELECT count(*) FROM sqlite_master WHERE type=\'table\' AND name=\'" + var1 + "\'", (String[])null);
      boolean var2 = var3;
      if(var4.moveToNext()) {
         var2 = var3;
         if(var4.getInt(0) > 0) {
            var2 = true;
         }
      }

      var4.close();
      return var2;
   }

   private void open() {
      if(this.db != null && this.db.isOpen()) {
         this.db.close();
      }

      this.db = this.getCheckInDatabaseHelperInstance().getWritableDatabase();
   }

   public void createTable() {
      this.open();
      this.getCheckInDatabaseHelperInstance().createTable(this.db);
      this.close();
   }

   public void deleteByID(String var1, String var2) {
      String var3 = var2;
      if(var2 == null) {
         var3 = "XX";
      }

      this.open();
      this.db.delete("calendar_events_table", "_id=? AND event_username=?", new String[]{var1, var3});
      this.close();
   }

   public void deleteByID(String[] var1) {
      this.open();
      this.db.delete("calendar_events_table", "_id=?", var1);
      this.close();
   }

   public void deleteByIndex(String var1, String var2) {
      String var3 = var2;
      if(var2 == null) {
         var3 = "XX";
      }

      this.open();
      this.db.delete("calendar_events_table", "event_index=? AND event_username=?", new String[]{var1, var3});
      this.close();
   }

   public void dropDatabase() {
      if(this.context != null) {
         this.context.deleteDatabase("calendar_events.db");
      }

   }

   public List getAllEvents(String var1) {
      String var2 = var1;
      if(var1 == null) {
         var2 = "XX";
      }

      ArrayList var3 = new ArrayList();
      this.open();
      if(this.isTableExist("calendar_events_table")) {
         Cursor var4 = this.db.query("calendar_events_table", (String[])null, "event_username=?", new String[]{var2}, (String)null, (String)null, (String)null);
         if(var4.moveToFirst()) {
            do {
               var3.add(this.getEventDataFromCursor(var4));
            } while(var4.moveToNext());
         }

         var4.close();
      }

      this.close();
      return var3;
   }

   public CalendarEvent getById(long param1, String param3) {
      // $FF: Couldn't be decompiled
   }

   public CalendarEvent getByIndex(long param1, String param3) {
      // $FF: Couldn't be decompiled
   }

   public long insertToEvent(CalendarEvent var1, String var2) {
      String var5 = var2;
      if(var2 == null) {
         var5 = "XX";
      }

      if(var1.getId() != -1L && this.getById(var1.getId(), var5) != null) {
         this.update(var1, var5);
         return var1.getIndex();
      } else {
         ContentValues var10 = this.getValuesFromModel(var1, var5);

         try {
            this.open();
            long var3 = this.db.insert("calendar_events_table", (String)null, var10);
            return var3;
         } catch (Exception var8) {
            ;
         } finally {
            this.db.close();
         }

         return -1L;
      }
   }

   public boolean update(CalendarEvent var1, String var2) {
      String var3 = var2;
      if(var2 == null) {
         var3 = "XX";
      }

      ContentValues var8 = this.getValuesFromModel(var1, var3);

      try {
         this.open();
         this.db.update("calendar_events_table", var8, "_id=? AND event_username=?", new String[]{String.valueOf(var1.getId()), var3});
         return true;
      } catch (Exception var6) {
         ;
      } finally {
         this.db.close();
      }

      return false;
   }

   public boolean updateID(CalendarEvent var1, String var2) {
      String var3 = var2;
      if(var2 == null) {
         var3 = "XX";
      }

      ContentValues var8 = this.getValuesFromModel(var1, var3);

      try {
         this.open();
         this.db.update("calendar_events_table", var8, "event_index=? AND event_username=?", new String[]{String.valueOf(var1.getIndex()), var3});
         return true;
      } catch (Exception var6) {
         ;
      } finally {
         this.db.close();
      }

      return false;
   }
}
