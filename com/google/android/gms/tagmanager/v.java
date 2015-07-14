package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.ak;
import com.google.android.gms.tagmanager.bh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class v implements DataLayer.c {
   private static final String ara = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' STRING NOT NULL, \'%s\' BLOB NOT NULL, \'%s\' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
   private final Executor arb;
   private v.a arc;
   private int ard;
   private final Context mContext;
   private ld wb;

   public v(Context var1) {
      this(var1, lf.if(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
   }

   v(Context var1, ld var2, String var3, int var4, Executor var5) {
      this.mContext = var1;
      this.wb = var2;
      this.ard = var4;
      this.arb = var5;
      this.arc = new v.a(this.mContext, var3);
   }

   private SQLiteDatabase al(String var1) {
      try {
         SQLiteDatabase var2 = this.arc.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         bh.W(var1);
         return null;
      }
   }

   private void b(List param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   private void c(List var1, long var2) {
      SQLiteDatabase var4 = this.al("Error opening database for writeEntryToDatabase.");
      if(var4 != null) {
         Iterator var7 = var1.iterator();

         while(var7.hasNext()) {
            v.b var5 = (v.b)var7.next();
            ContentValues var6 = new ContentValues();
            var6.put("expires", Long.valueOf(var2));
            var6.put("key", var5.KP);
            var6.put("value", var5.arj);
            var4.insert("datalayer", (String)null, var6);
         }
      }

   }

   private void cA(String var1) {
      SQLiteDatabase var3 = this.al("Error opening database for clearKeysWithPrefix.");
      if(var3 != null) {
         try {
            int var2 = var3.delete("datalayer", "key = ? OR key LIKE ?", new String[]{var1, var1 + ".%"});
            bh.V("Cleared " + var2 + " items");
            return;
         } catch (SQLiteException var6) {
            bh.W("Error deleting entries with key prefix: " + var1 + " (" + var6 + ").");
         } finally {
            this.pC();
         }

      }
   }

   private void fI(int var1) {
      var1 += this.pB() - this.ard;
      if(var1 > 0) {
         List var2 = this.fJ(var1);
         bh.U("DataLayer store full, deleting " + var2.size() + " entries to make room.");
         this.h((String[])var2.toArray(new String[0]));
      }

   }

   private List fJ(int param1) {
      // $FF: Couldn't be decompiled
   }

   private void h(String[] var1) {
      if(var1 != null && var1.length != 0) {
         SQLiteDatabase var2 = this.al("Error opening database for deleteEntries.");
         if(var2 != null) {
            String var3 = String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(var1.length, "?"))});

            try {
               var2.delete("datalayer", var3, var1);
               return;
            } catch (SQLiteException var4) {
               bh.W("Error deleting entries " + Arrays.toString(var1));
               return;
            }
         }
      }

   }

   private List i(List var1) {
      ArrayList var2 = new ArrayList();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         v.b var3 = (v.b)var4.next();
         var2.add(new DataLayer.a(var3.KP, this.j(var3.arj)));
      }

      return var2;
   }

   private Object j(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   private List j(List var1) {
      ArrayList var2 = new ArrayList();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         DataLayer.a var3 = (DataLayer.a)var4.next();
         var2.add(new v.b(var3.KP, this.m(var3.wF)));
      }

      return var2;
   }

   private byte[] m(Object param1) {
      // $FF: Couldn't be decompiled
   }

   private List pA() {
      SQLiteDatabase var2 = this.al("Error opening database for loadSerialized.");
      ArrayList var1 = new ArrayList();
      if(var2 == null) {
         return var1;
      } else {
         Cursor var6 = var2.query("datalayer", new String[]{"key", "value"}, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);

         while(true) {
            boolean var4 = false;

            try {
               var4 = true;
               if(!var6.moveToNext()) {
                  var4 = false;
                  break;
               }

               var1.add(new v.b(var6.getString(0), var6.getBlob(1)));
               var4 = false;
            } finally {
               if(var4) {
                  var6.close();
               }
            }
         }

         var6.close();
         return var1;
      }
   }

   private int pB() {
      // $FF: Couldn't be decompiled
   }

   private void pC() {
      try {
         this.arc.close();
      } catch (SQLiteException var2) {
         ;
      }
   }

   private List pz() {
      List var1;
      try {
         this.x(this.wb.currentTimeMillis());
         var1 = this.i(this.pA());
      } finally {
         this.pC();
      }

      return var1;
   }

   private void x(long var1) {
      SQLiteDatabase var4 = this.al("Error opening database for deleteOlderThan.");
      if(var4 != null) {
         try {
            int var3 = var4.delete("datalayer", "expires <= ?", new String[]{Long.toString(var1)});
            bh.V("Deleted " + var3 + " expired items");
         } catch (SQLiteException var5) {
            bh.W("Error deleting old entries.");
         }
      }
   }

   public void a(final DataLayer.a var1) {
      this.arb.execute(new Runnable() {
         public void run() {
            var1.h(v.this.pz());
         }
      });
   }

   public void a(final List var1, final long var2) {
      var1 = this.j(var1);
      this.arb.execute(new Runnable() {
         public void run() {
            v.this.b(var1, var2);
         }
      });
   }

   public void cz(final String var1) {
      this.arb.execute(new Runnable() {
         public void run() {
            v.this.cA(var1);
         }
      });
   }

   class a extends SQLiteOpenHelper {
      a(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      private void a(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      private boolean a(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         SQLiteDatabase var1 = null;

         SQLiteDatabase var2;
         label17: {
            try {
               var2 = super.getWritableDatabase();
            } catch (SQLiteException var3) {
               v.this.mContext.getDatabasePath("google_tagmanager.db").delete();
               break label17;
            }

            var1 = var2;
         }

         var2 = var1;
         if(var1 == null) {
            var2 = super.getWritableDatabase();
         }

         return var2;
      }

      public void onCreate(SQLiteDatabase var1) {
         ak.ag(var1.getPath());
      }

      public void onOpen(SQLiteDatabase var1) {
         if(VERSION.SDK_INT < 15) {
            Cursor var2 = var1.rawQuery("PRAGMA journal_mode=memory", (String[])null);

            try {
               var2.moveToFirst();
            } finally {
               var2.close();
            }
         }

         if(!this.a("datalayer", var1)) {
            var1.execSQL(v.ara);
         } else {
            this.a(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }

   private static class b {
      final String KP;
      final byte[] arj;

      b(String var1, byte[] var2) {
         this.KP = var1;
         this.arj = var2;
      }

      public String toString() {
         return "KeyAndSerialized: key = " + this.KP + " serialized hash = " + Arrays.hashCode(this.arj);
      }
   }
}
