package com.parallel6.ui.database.my_calendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CalendarDatabaseHelper extends SQLiteOpenHelper {
   private static final String CREATE_EVENT_TABLE = "CREATE TABLE calendar_events_table(event_index INTEGER PRIMARY KEY, _id INTEGER, event_tone_type INTEGER, event_type TEXT, event_username TEXT, description TEXT, event_reminder INTEGER, event_date TEXT, event_time TEXT, dtstart INTEGER, eventLocation text );";
   public static final String DB_NAME = "calendar_events.db";
   public static final int DB_VERSION = 1;

   public CalendarDatabaseHelper(Context var1) {
      super(var1, "calendar_events.db", (CursorFactory)null, 1);
   }

   public void createTable(SQLiteDatabase var1) {
      var1.execSQL("CREATE TABLE calendar_events_table(event_index INTEGER PRIMARY KEY, _id INTEGER, event_tone_type INTEGER, event_type TEXT, event_username TEXT, description TEXT, event_reminder INTEGER, event_date TEXT, event_time TEXT, dtstart INTEGER, eventLocation text );");
   }

   public void deleteTable(SQLiteDatabase var1, String var2) {
      var1.execSQL("DROP TABLE IF EXISTS " + var2);
   }

   public void onCreate(SQLiteDatabase var1) {
      this.createTable(var1);
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      this.deleteTable(var1, "calendar_events_table");
      this.onCreate(var1);
   }
}
