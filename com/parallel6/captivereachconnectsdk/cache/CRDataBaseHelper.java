package com.parallel6.captivereachconnectsdk.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CRDataBaseHelper extends SQLiteOpenHelper {
   private static final String DATABASE_NAME = "captivereach_dynamic.db";
   private static final int DATABASE_VERSION = 2;

   public CRDataBaseHelper(Context var1) {
      super(var1, "captivereach_dynamic.db", (CursorFactory)null, 2);
   }

   public void onCreate(SQLiteDatabase var1) {
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      this.onCreate(var1);
   }
}
