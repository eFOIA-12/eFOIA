package com.parallel6.captivereachconnectsdk.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.parallel6.captivereachconnectsdk.cache.CRSendDataDBHelper;
import com.parallel6.captivereachconnectsdk.cache.CacheUrl;
import java.util.ArrayList;
import java.util.List;

public class CRSendContentDao {
   public static final String KEY_CONTENT = "content";
   public static final String KEY_HTTP_METHOD = "http_method";
   public static final String KEY_ID = "id";
   public static final String KEY_SENT = "sent";
   public static final String KEY_URL = "url";
   public static final String SEND_CONTENT_TABLE = "send_content";
   private SQLiteDatabase db;
   private Context mContext;

   public CRSendContentDao(Context var1) {
      this.mContext = var1;
   }

   private void close() {
      this.db.close();
   }

   private void open() {
      this.db = (new CRSendDataDBHelper(this.mContext)).getWritableDatabase();
   }

   public void delete(CacheUrl var1) {
      this.open();
      this.db.delete("send_content", "id=?", new String[]{String.valueOf(var1.getId())});
      this.close();
   }

   public void deleteAll(boolean var1) {
      byte var2 = 1;
      this.open();
      SQLiteDatabase var3 = this.db;
      if(!var1) {
         var2 = 0;
      }

      var3.delete("send_content", "sent=?", new String[]{String.valueOf(var2)});
      this.close();
   }

   public CacheUrl get(int var1) {
      CacheUrl var2 = new CacheUrl();
      this.open();
      Cursor var3 = this.db.query("send_content", (String[])null, "id=?", new String[]{String.valueOf(var1)}, (String)null, (String)null, (String)null);
      if(var3.moveToFirst()) {
         var2.setId(var3.getInt(var3.getColumnIndex("id")));
         var2.setPath(var3.getString(var3.getColumnIndex("url")));
         var2.setJson(var3.getString(var3.getColumnIndex("content")));
         var2.setHttpMethod(var3.getString(var3.getColumnIndex("http_method")));
      }

      var3.close();
      this.close();
      return var2;
   }

   public List getAll(boolean var1) {
      byte var2 = 1;
      ArrayList var3 = new ArrayList();
      this.open();
      SQLiteDatabase var4 = this.db;
      if(!var1) {
         var2 = 0;
      }

      Cursor var6 = var4.query("send_content", (String[])null, "sent=?", new String[]{String.valueOf(var2)}, (String)null, (String)null, (String)null);
      if(var6.moveToFirst()) {
         do {
            CacheUrl var5 = new CacheUrl();
            var5.setId(var6.getInt(var6.getColumnIndex("id")));
            var5.setPath(var6.getString(var6.getColumnIndex("url")));
            var5.setJson(var6.getString(var6.getColumnIndex("content")));
            var5.setHttpMethod(var6.getString(var6.getColumnIndex("http_method")));
            var3.add(var5);
         } while(var6.moveToNext());
      }

      var6.close();
      this.close();
      return var3;
   }

   public void insert(CacheUrl var1) {
      this.open();
      ContentValues var2 = new ContentValues();
      var2.put("url", var1.getPath());
      var2.put("content", var1.getJson());
      var2.put("http_method", var1.getHttpMethod());
      var2.put("sent", Integer.valueOf(0));
      this.db.insert("send_content", (String)null, var2);
      this.close();
   }

   public void update(CacheUrl var1, boolean var2) {
      this.open();
      ContentValues var4 = new ContentValues();
      var4.put("url", var1.getPath());
      var4.put("content", var1.getJson());
      var4.put("http_method", var1.getHttpMethod());
      byte var3;
      if(var2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var4.put("sent", Integer.valueOf(var3));
      this.db.update("send_content", var4, "id=?", new String[]{String.valueOf(var1.getId())});
      this.close();
   }
}
