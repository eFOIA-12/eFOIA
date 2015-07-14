package com.parallel6.captivereachconnectsdk.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CRSendDataDBHelper extends SQLiteOpenHelper {
   private static final String DATABASE_NAME = "captivereach_senddata.db";
   private static final int DATABASE_VERSION = 1;
   private static final String SEND_CONTENT_TABLE = "CREATE TABLE send_content (id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT, content TEXT, http_method TEXT, sent INTEGER);";

   public CRSendDataDBHelper(Context var1) {
      super(var1, "captivereach_senddata.db", (CursorFactory)null, 1);
   }

   public void onCreate(SQLiteDatabase var1) {
      var1.execSQL("CREATE TABLE send_content (id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT, content TEXT, http_method TEXT, sent INTEGER);");
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      this.onCreate(var1);
   }
}
