package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.tagmanager.ab;
import com.google.android.gms.tagmanager.ak;
import com.google.android.gms.tagmanager.ap;
import com.google.android.gms.tagmanager.at;
import com.google.android.gms.tagmanager.au;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.cy;
import com.google.android.gms.tagmanager.db;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

class cb implements at {
   private static final String BS = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL,\'%s\' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
   private final String BV;
   private long BX;
   private final int BY;
   private final cb.b asf;
   private volatile ab asg;
   private final au ash;
   private final Context mContext;
   private ld wb;

   cb(au var1, Context var2) {
      this(var1, var2, "gtm_urls.db", 2000);
   }

   cb(au var1, Context var2, String var3, int var4) {
      this.mContext = var2.getApplicationContext();
      this.BV = var3;
      this.ash = var1;
      this.wb = lf.if();
      this.asf = new cb.b(this.mContext, this.BV);
      this.asg = new db(new DefaultHttpClient(), this.mContext, new cb.a());
      this.BX = 0L;
      this.BY = var4;
   }

   // $FF: synthetic method
   static void a(cb var0, long var1, long var3) {
      var0.c(var1, var3);
   }

   private SQLiteDatabase al(String var1) {
      try {
         SQLiteDatabase var2 = this.asf.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         bh.W(var1);
         return null;
      }
   }

   private void c(long var1, long var3) {
      SQLiteDatabase var5 = this.al("Error opening database for getNumStoredHits.");
      if(var5 != null) {
         ContentValues var6 = new ContentValues();
         var6.put("hit_first_send_time", Long.valueOf(var3));

         try {
            var5.update("gtm_hits", var6, "hit_id=?", new String[]{String.valueOf(var1)});
         } catch (SQLiteException var7) {
            bh.W("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + var1);
            this.y(var1);
         }
      }
   }

   private void fh() {
      int var1 = this.fj() - this.BY + 1;
      if(var1 > 0) {
         List var2 = this.G(var1);
         bh.V("Store full, deleting " + var2.size() + " hits to make room.");
         this.b((String[])var2.toArray(new String[0]));
      }

   }

   private void g(long var1, String var3) {
      SQLiteDatabase var4 = this.al("Error opening database for putHit");
      if(var4 != null) {
         ContentValues var5 = new ContentValues();
         var5.put("hit_time", Long.valueOf(var1));
         var5.put("hit_url", var3);
         var5.put("hit_first_send_time", Integer.valueOf(0));

         try {
            var4.insert("gtm_hits", (String)null, var5);
            this.ash.B(false);
         } catch (SQLiteException var6) {
            bh.W("Error storing hit");
         }
      }
   }

   private void y(long var1) {
      this.b(new String[]{String.valueOf(var1)});
   }

   List G(int param1) {
      // $FF: Couldn't be decompiled
   }

   public List H(int param1) {
      // $FF: Couldn't be decompiled
   }

   void b(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   public void dispatch() {
      bh.V("GTM Dispatch running...");
      if(this.asg.ea()) {
         List var1 = this.H(40);
         if(var1.isEmpty()) {
            bh.V("...nothing to dispatch");
            this.ash.B(true);
            return;
         }

         this.asg.k(var1);
         if(this.pY() > 0) {
            cy.qN().dispatch();
            return;
         }
      }

   }

   public void f(long var1, String var3) {
      this.fi();
      this.fh();
      this.g(var1, var3);
   }

   int fi() {
      boolean var2 = true;
      long var3 = this.wb.currentTimeMillis();
      if(var3 > this.BX + 86400000L) {
         this.BX = var3;
         SQLiteDatabase var5 = this.al("Error opening database for deleteStaleHits.");
         if(var5 != null) {
            int var1 = var5.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.wb.currentTimeMillis() - 2592000000L)});
            au var6 = this.ash;
            if(this.fj() != 0) {
               var2 = false;
            }

            var6.B(var2);
            return var1;
         }
      }

      return 0;
   }

   int fj() {
      // $FF: Couldn't be decompiled
   }

   int pY() {
      // $FF: Couldn't be decompiled
   }

   class a implements db.a {
      public void a(ap var1) {
         cb.this.y(var1.fb());
      }

      public void b(ap var1) {
         cb.this.y(var1.fb());
         bh.V("Permanent failure dispatching hitId: " + var1.fb());
      }

      public void c(ap var1) {
         long var2 = var1.pK();
         if(var2 == 0L) {
            cb.a(cb.this, var1.fb(), cb.this.wb.currentTimeMillis());
         } else if(var2 + 14400000L < cb.this.wb.currentTimeMillis()) {
            cb.this.y(var1.fb());
            bh.V("Giving up on failed hitId: " + var1.fb());
            return;
         }

      }
   }

   class b extends SQLiteOpenHelper {
      private boolean BZ;
      private long Ca = 0L;

      b(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      private void a(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      private boolean a(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         if(this.BZ && this.Ca + 3600000L > cb.this.wb.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
         } else {
            SQLiteDatabase var1 = null;
            this.BZ = true;
            this.Ca = cb.this.wb.currentTimeMillis();

            SQLiteDatabase var2;
            label21: {
               try {
                  var2 = super.getWritableDatabase();
               } catch (SQLiteException var3) {
                  cb.this.mContext.getDatabasePath(cb.this.BV).delete();
                  break label21;
               }

               var1 = var2;
            }

            var2 = var1;
            if(var1 == null) {
               var2 = super.getWritableDatabase();
            }

            this.BZ = false;
            return var2;
         }
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

         if(!this.a("gtm_hits", var1)) {
            var1.execSQL(cb.BS);
         } else {
            this.a(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
