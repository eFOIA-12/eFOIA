package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.ab;
import com.google.android.gms.analytics.ac;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.af;
import com.google.android.gms.analytics.d;
import com.google.android.gms.analytics.e;
import com.google.android.gms.analytics.h;
import com.google.android.gms.analytics.o;
import com.google.android.gms.analytics.r;
import com.google.android.gms.analytics.t;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.impl.client.DefaultHttpClient;

class ag implements d {
   private static final String BS = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
   private final ag.a BT;
   private volatile r BU;
   private final String BV;
   private af BW;
   private long BX;
   private final int BY;
   private final Context mContext;
   private ld wb;
   private o ys;
   private volatile boolean yt;
   private final e zc;

   ag(e var1, Context var2, o var3) {
      this(var1, var2, "google_analytics_v4.db", 2000, var3);
   }

   ag(e var1, Context var2, String var3, int var4, o var5) {
      this.yt = true;
      this.mContext = var2.getApplicationContext();
      this.ys = var5;
      this.BV = var3;
      this.zc = var1;
      this.wb = lf.if();
      this.BT = new ag.a(this.mContext, this.BV);
      this.BU = new h(new DefaultHttpClient(), this.mContext, this.ys);
      this.BX = 0L;
      this.BY = var4;
   }

   static String A(Map var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         var1.add(ac.encode((String)var2.getKey()) + "=" + ac.encode((String)var2.getValue()));
      }

      return TextUtils.join("&", var1);
   }

   private void a(Map var1, long var2, String var4) {
      SQLiteDatabase var5 = this.al("Error opening database for putHit");
      if(var5 != null) {
         ContentValues var6 = new ContentValues();
         var6.put("hit_string", A(var1));
         var6.put("hit_time", Long.valueOf(var2));
         if(var1.containsKey("AppUID")) {
            try {
               var2 = Long.parseLong((String)var1.get("AppUID"));
            } catch (NumberFormatException var8) {
               var2 = 0L;
            }
         } else {
            var2 = 0L;
         }

         var6.put("hit_app_id", Long.valueOf(var2));
         String var9 = var4;
         if(var4 == null) {
            var9 = "http://www.google-analytics.com/collect";
         }

         if(var9.length() == 0) {
            ae.W("Empty path: not sending hit");
         } else {
            var6.put("hit_url", var9);

            try {
               var5.insert("hits2", (String)null, var6);
               this.zc.B(false);
            } catch (SQLiteException var7) {
               ae.W("Error storing hit");
            }
         }
      }
   }

   private void a(Map var1, Collection var2) {
      String var3 = "&_v".substring(1);
      if(var2 != null) {
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            ha var4 = (ha)var5.next();
            if("appendVersion".equals(var4.getId())) {
               var1.put(var3, var4.getValue());
               break;
            }
         }
      }

   }

   private SQLiteDatabase al(String var1) {
      try {
         SQLiteDatabase var2 = this.BT.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         ae.W(var1);
         return null;
      }
   }

   private void fh() {
      int var1 = this.fj() - this.BY + 1;
      if(var1 > 0) {
         List var2 = this.G(var1);
         ae.V("Store full, deleting " + var2.size() + " hits to make room.");
         this.b((String[])var2.toArray(new String[0]));
      }

   }

   List G(int param1) {
      // $FF: Couldn't be decompiled
   }

   public List H(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void a(Map var1, long var2, String var4, Collection var5) {
      this.fi();
      this.fh();
      this.a(var1, var5);
      this.a(var1, var2, var4);
   }

   @Deprecated
   void b(Collection var1) {
      if(var1 != null && !var1.isEmpty()) {
         String[] var3 = new String[var1.size()];
         Iterator var4 = var1.iterator();

         for(int var2 = 0; var4.hasNext(); ++var2) {
            var3[var2] = String.valueOf(((ab)var4.next()).fb());
         }

         this.b(var3);
      } else {
         ae.W("Empty/Null collection passed to deleteHits.");
      }
   }

   void b(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   public r dV() {
      return this.BU;
   }

   public void dispatch() {
      boolean var2 = true;
      ae.V("Dispatch running...");
      if(this.BU.ea()) {
         List var3 = this.H(20);
         if(var3.isEmpty()) {
            ae.V("...nothing to dispatch");
            this.zc.B(true);
         } else {
            if(this.BW == null) {
               this.BW = new af("_t=dispatch&_v=ma4.0.4", false);
            }

            if(this.fj() > var3.size()) {
               var2 = false;
            }

            int var1 = this.BU.a(var3, this.BW, var2);
            ae.V("sent " + var1 + " of " + var3.size() + " hits");
            this.b((Collection)var3.subList(0, Math.min(var1, var3.size())));
            if(var1 == var3.size() && this.fj() > 0) {
               GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            } else {
               this.BW = null;
            }
         }
      }
   }

   int fi() {
      boolean var2 = true;
      long var3 = this.wb.currentTimeMillis();
      if(var3 > this.BX + 86400000L) {
         this.BX = var3;
         SQLiteDatabase var5 = this.al("Error opening database for deleteStaleHits.");
         if(var5 != null) {
            int var1 = var5.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.wb.currentTimeMillis() - 2592000000L)});
            e var6 = this.zc;
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

   public void l(long var1) {
      boolean var3 = true;
      SQLiteDatabase var4 = this.al("Error opening database for clearHits");
      if(var4 != null) {
         if(var1 == 0L) {
            var4.delete("hits2", (String)null, (String[])null);
         } else {
            var4.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(var1).toString()});
         }

         e var5 = this.zc;
         if(this.fj() != 0) {
            var3 = false;
         }

         var5.B(var3);
      }

   }

   public void setDryRun(boolean var1) {
      this.yt = var1;
      if(this.BU != null) {
         this.BU.setDryRun(var1);
      }

   }

   class a extends SQLiteOpenHelper {
      private boolean BZ;
      private long Ca = 0L;

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
         if(this.BZ && this.Ca + 3600000L > ag.this.wb.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
         } else {
            SQLiteDatabase var1 = null;
            this.BZ = true;
            this.Ca = ag.this.wb.currentTimeMillis();

            SQLiteDatabase var2;
            label21: {
               try {
                  var2 = super.getWritableDatabase();
               } catch (SQLiteException var3) {
                  ag.this.mContext.getDatabasePath(ag.this.BV).delete();
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
         t.ag(var1.getPath());
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

         if(!this.a("hits2", var1)) {
            var1.execSQL(ag.BS);
         } else {
            this.a(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
