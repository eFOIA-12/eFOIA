package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import java.util.List;

@ey
public class eh {
   private static final Object mH = new Object();
   private static final String sZ = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
   private static eh tb;
   private final eh.a ta;

   private eh(Context var1) {
      this.ta = new eh.a(var1, "google_inapp_purchase.db");
   }

   public static eh j(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public ef a(Cursor var1) {
      return var1 == null?null:new ef(var1.getLong(0), var1.getString(1), var1.getString(2));
   }

   public void a(ef param1) {
      // $FF: Couldn't be decompiled
   }

   public void b(ef param1) {
      // $FF: Couldn't be decompiled
   }

   public void cA() {
      // $FF: Couldn't be decompiled
   }

   public List d(long param1) {
      // $FF: Couldn't be decompiled
   }

   public int getRecordCount() {
      // $FF: Couldn't be decompiled
   }

   public SQLiteDatabase getWritableDatabase() {
      try {
         SQLiteDatabase var1 = this.ta.getWritableDatabase();
         return var1;
      } catch (SQLiteException var2) {
         gr.W("Error opening writable conversion tracking database");
         return null;
      }
   }

   public class a extends SQLiteOpenHelper {
      public a(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 4);
      }

      public void onCreate(SQLiteDatabase var1) {
         var1.execSQL(eh.sZ);
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
         gr.U("Database updated from version " + var2 + " to version " + var3);
         var1.execSQL("DROP TABLE IF EXISTS InAppPurchase");
         this.onCreate(var1);
      }
   }
}
