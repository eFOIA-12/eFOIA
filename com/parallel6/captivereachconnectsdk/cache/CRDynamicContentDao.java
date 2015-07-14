package com.parallel6.captivereachconnectsdk.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.cache.CRDataBaseHelper;
import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CRDynamicContentDao {
   private static final String KEY_CREATION_DATE = "creation_date";
   private static final String KEY_ETAG = "etag";
   private static final String KEY_ID = "id";
   private static final String KEY_JSON = "json_object";
   private static final String TABLE_ARRAY = "@array/";
   private static final String TABLE_ATTRIBUTES = "{dynamic_attributes}";
   private static final String TABLE_DOUBLE = "@double/";
   private static final String TABLE_DYNAMIC_CREATE = "CREATE TABLE {permanent_link} (id INTEGER PRIMARY KEY AUTOINCREMENT,creation_date TEXT, etag TEXT, json_object TEXT {dynamic_attributes});";
   private static final String TABLE_INT = "@int/";
   private static final String TABLE_NAME = "{permanent_link}";
   private static final String TABLE_OBJECT = "@object/";
   private static final String TABLE_STRING = "@string/";
   private static final String TAG = CRDynamicContentDao.class.getSimpleName();
   private SimpleDateFormat creationDateFormat;
   private CRDataBaseHelper dbHelper;
   private List filters;
   private Context mContext;

   public CRDynamicContentDao(Context var1) {
      this.mContext = var1;
      this.dbHelper = new CRDataBaseHelper(var1);
      this.creationDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   }

   public CRDynamicContentDao(CRDataBaseHelper var1) {
      this.dbHelper = var1;
      this.creationDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   }

   private String getCorrectValue(String var1) {
      return var1.substring(var1.indexOf("/") + 1);
   }

   private String getFilter(String var1, String var2) {
      String var4 = var2;
      if(this.filters != null) {
         var4 = var2;
         if(var1.endsWith("content")) {
            Iterator var5 = this.filters.iterator();
            String var3 = var2;

            while(true) {
               var4 = var3;
               if(!var5.hasNext()) {
                  break;
               }

               CRFilter var6 = (CRFilter)var5.next();
               if(var6 != null && var6.getFilterValues() != null) {
                  var2 = "";
                  Iterator var7 = var6.getFilterValues().iterator();

                  while(var7.hasNext()) {
                     String var8 = (String)var7.next();
                     if(var8 != null) {
                        var4 = var2;
                        if(var2.length() > 0) {
                           var4 = var2 + " OR ";
                        }

                        if(var6.getAttributeName().equals("tag")) {
                           var2 = var4;
                           if(this.isColumntExists(var1, "tags")) {
                              var2 = var4 + "tags LIKE \'%" + var8 + "%\'";
                           }
                        } else {
                           var2 = var4 + var6.getAttributeName() + " LIKE \'%" + var8 + "%\'";
                        }
                     }
                  }

                  if(var2.length() > 0) {
                     var4 = "(" + var2 + ")";
                     StringBuilder var9 = (new StringBuilder()).append(var3);
                     if(var3.length() > 0) {
                        var2 = " AND ";
                     } else {
                        var2 = "";
                     }

                     var3 = var9.append(var2).append(var4).toString();
                  }
               }
            }
         }
      }

      return var4;
   }

   private String getWhere(String var1, String[] var2) {
      String var4;
      if(var2.length > 0) {
         var4 = "(";
      } else {
         var4 = "";
      }

      for(int var3 = 0; var3 < var2.length; ++var3) {
         String var5 = var4;
         if(var3 > 0) {
            var5 = var4 + " OR ";
         }

         var4 = var5 + "id=" + var2[var3];
      }

      String var6 = var4;
      if(var4.length() > 0) {
         var6 = var4 + ")";
      }

      return this.getFilter(var1, var6);
   }

   private SQLiteDatabase open() {
      return this.dbHelper.getWritableDatabase();
   }

   public void clearDatabase() {
      SQLiteDatabase var1 = this.open();
      ArrayList var2 = new ArrayList();
      Cursor var3 = var1.rawQuery("SELECT * FROM sqlite_master WHERE type=\'table\';", (String[])null);
      var3.moveToFirst();

      for(; !var3.isAfterLast(); var3.moveToNext()) {
         String var4 = var3.getString(1);
         if(!var4.equals("android_metadata") && !var4.equals("sqlite_sequence")) {
            var2.add(var4);
         }
      }

      var3.close();
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         var1.execSQL("DROP TABLE IF EXISTS " + var6);
      }

      var1.close();
   }

   public void createTable(String var1, JSONObject var2) throws JSONException {
      SQLiteDatabase var5 = this.open();
      var5.execSQL("DROP TABLE IF EXISTS \'" + var1 + "\'");
      String var6 = "CREATE TABLE {permanent_link} (id INTEGER PRIMARY KEY AUTOINCREMENT,creation_date TEXT, etag TEXT, json_object TEXT {dynamic_attributes});".replace("{permanent_link}", var1);
      String var3 = "";
      Iterator var7 = var2.keys();

      while(var7.hasNext()) {
         String var8 = (String)var7.next();
         String var4 = var3;
         if(!var8.equals("id")) {
            var4 = var3 + ", " + var8 + " TEXT";
         }

         Object var9 = var2.get(var8);
         if(var9 instanceof JSONObject) {
            this.createTable(var1 + "_" + var8, (JSONObject)var9);
            var3 = var4;
         } else {
            var3 = var4;
            if(var9 instanceof JSONArray) {
               JSONArray var10 = (JSONArray)var9;
               var3 = var4;
               if(var10.length() > 0) {
                  this.createTable(var1 + "_" + var8, var10.getJSONObject(0));
                  var3 = var4;
               }
            }
         }
      }

      var5.execSQL(var6.replace("{dynamic_attributes}", var3));
   }

   public String get(String var1) {
      var1 = this.get(var1.replaceAll("\\/", "_"), "1", (String)null);
      this.open().close();
      return var1;
   }

   public String get(String var1, String var2) {
      return this.get(var1, var2, (String)null);
   }

   public String get(String var1, String var2, String var3) {
      var3 = "";
      Cursor var5 = this.open().query(var1, (String[])null, "id=?", new String[]{var2}, (String)null, (String)null, (String)null);
      var1 = var3;
      if(var5.moveToFirst()) {
         label81: {
            try {
               var1 = var5.getString(var5.getColumnIndex("creation_date"));
               Date var9 = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).parse(var1);
               Date var10 = new Date();
               if(TimeUnit.MILLISECONDS.toDays(var10.getTime() - var9.getTime()) > (long)Integer.parseInt(SettingsUtils.getSafeSetting(this.mContext, "setting_expiration_days", "1"))) {
                  break label81;
               }
            } catch (ParseException var8) {
               ;
            }

            var2 = var5.getString(var5.getColumnIndex("json_object"));
            var1 = var2;
            if(!StringUtils.isNotEmpty(var2)) {
               var2 = "{";

               for(int var4 = 0; var4 < var5.getColumnCount(); var2 = var3) {
                  label51: {
                     String var6 = var5.getColumnName(var4);
                     var1 = "";
                     if(var6.equals("id")) {
                        var1 = "" + var5.getInt(var5.getColumnIndex(var6));
                     } else {
                        String var7 = var5.getString(var5.getColumnIndex(var6));
                        var3 = var2;
                        if(var7 == null) {
                           break label51;
                        }

                        var3 = var2;
                        if(var7.isEmpty()) {
                           break label51;
                        }

                        if(var7.startsWith("@array/")) {
                           String[] var12 = this.getCorrectValue(var7).split("/");
                           if(var12.length > 1) {
                              var1 = this.getWhere(var12[0], var12[1].split(","));
                              var1 = "" + this.getArray(var12[0], var1);
                           }
                        } else if(var7.startsWith("@object/")) {
                           String[] var11 = this.getCorrectValue(var7).split("/");
                           var1 = "" + this.get(var11[0], var11[1]);
                        } else if(var7.startsWith("@int/")) {
                           var1 = "" + Integer.parseInt(this.getCorrectValue(var7));
                        } else if(var7.startsWith("@double/")) {
                           var1 = "" + Double.parseDouble(this.getCorrectValue(var7));
                        } else {
                           var1 = "" + "\"" + this.getCorrectValue(var7) + "\"";
                        }
                     }

                     var3 = var2;
                     if(!var1.isEmpty()) {
                        var1 = var2 + "\"" + var6 + "\":" + var1;
                        var3 = var1 + ",";
                     }
                  }

                  ++var4;
               }

               var1 = var2;
               if(var2.endsWith(",")) {
                  var1 = var2.substring(0, var2.lastIndexOf(","));
               }

               var1 = var1 + "}";
               return var1;
            }

            return var1;
         }

         var1 = "";
         return var1;
      } else {
         return var1;
      }
   }

   public String getArray(String var1, String var2) {
      String var4 = "[";
      Cursor var5 = this.open().query(var1, (String[])null, var2, (String[])null, (String)null, (String)null, (String)null);
      var1 = var4;
      if(var5.moveToFirst()) {
         do {
            var2 = var4 + "{";

            for(int var3 = 0; var3 < var5.getColumnCount(); var2 = var4) {
               label49: {
                  String var6 = var5.getColumnName(var3);
                  var1 = "";
                  if(var6.equals("id")) {
                     var1 = "" + var5.getInt(var5.getColumnIndex(var6));
                  } else {
                     String var7 = var5.getString(var5.getColumnIndex(var6));
                     var4 = var2;
                     if(var7 == null) {
                        break label49;
                     }

                     var4 = var2;
                     if(var7.isEmpty()) {
                        break label49;
                     }

                     if(var7.startsWith("@array/")) {
                        String[] var9 = this.getCorrectValue(var7).split("/");
                        if(var9.length > 1) {
                           var1 = this.getWhere(var9[0], var9[1].split(","));
                           var1 = "" + this.getArray(var9[0], var1);
                        }
                     } else if(var7.startsWith("@object/")) {
                        String[] var8 = this.getCorrectValue(var7).split("/");
                        var1 = "" + this.get(var8[0], var8[1]);
                     } else if(var7.startsWith("@int/")) {
                        var1 = "" + Integer.parseInt(this.getCorrectValue(var7));
                     } else if(var7.startsWith("@double/")) {
                        var1 = "" + Double.parseDouble(this.getCorrectValue(var7));
                     } else {
                        var1 = "" + "\"" + this.getCorrectValue(var7) + "\"";
                     }
                  }

                  var4 = var2;
                  if(!var1.isEmpty()) {
                     var1 = var2 + "\"" + var6 + "\":" + var1;
                     var4 = var1 + ",";
                  }
               }

               ++var3;
            }

            var1 = var2;
            if(var2.endsWith(",")) {
               var1 = var2.substring(0, var2.lastIndexOf(","));
            }

            var2 = var1 + "}";
            var1 = var2;
            if(!var5.isLast()) {
               var1 = var2 + ",";
            }

            var4 = var1;
         } while(var5.moveToNext());
      }

      return var1 + "]";
   }

   public String getEtag(String var1) {
      String var2 = "";
      if(var1 == null) {
         return "";
      } else {
         var1 = var1.replaceAll("\\/", "_");
         if(!this.isTableExists(var1)) {
            Log.v(TAG, "Table <" + var1 + ">" + "not Exist");
            return "";
         } else {
            SQLiteDatabase var3 = this.open();
            Cursor var4 = var3.query(var1, (String[])null, "id=?", new String[]{"1"}, (String)null, (String)null, (String)null);
            var1 = var2;
            if(var4.moveToFirst()) {
               try {
                  var1 = var4.getString(var4.getColumnIndex("creation_date"));
                  Date var6 = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).parse(var1);
                  Date var7 = new Date();
                  if(TimeUnit.MILLISECONDS.toDays(var7.getTime() - var6.getTime()) > (long)Integer.parseInt(SettingsUtils.getSafeSetting(this.mContext, "setting_expiration_days", "1"))) {
                     return "";
                  }
               } catch (ParseException var5) {
                  ;
               }

               var1 = var4.getString(var4.getColumnIndex("etag"));
            }

            var3.close();
            return var1;
         }
      }
   }

   public void insert(String var1, JSONObject var2) throws JSONException {
      if(!this.isTableExists(var1)) {
         this.createTable(var1, var2);
      }

      ContentValues var6 = new ContentValues();
      Iterator var7 = var2.keys();

      while(var7.hasNext()) {
         String var8 = (String)var7.next();
         if(this.isColumntExists(var1, var8)) {
            if(var8.equals("id")) {
               var6.put(var8, Integer.valueOf(var2.getInt(var8)));
            } else {
               Object var4 = var2.get(var8);
               int var3;
               if(var4 instanceof JSONObject) {
                  if(var2.has("id")) {
                     var3 = var2.getInt("id");
                  } else {
                     var3 = 1;
                  }

                  var6.put(var8, "@object/" + var1 + "_" + var8 + "/" + var3);
                  JSONObject var12 = (JSONObject)var4;
                  if(!var12.has("id")) {
                     var12.put("id", var3);
                  }

                  this.insert(var1 + "_" + var8, var12);
               } else if(!(var4 instanceof JSONArray)) {
                  if(var4 instanceof Integer) {
                     var6.put(var8, "@int/" + var4);
                  } else if(var4 instanceof Double) {
                     var6.put(var8, "@double/" + var4);
                  } else {
                     var6.put(var8, "@string/" + var4.toString());
                  }
               } else {
                  JSONArray var9 = (JSONArray)var4;
                  String var11 = "";

                  String var5;
                  for(var3 = 0; var3 < var9.length(); var11 = var5) {
                     JSONObject var10 = var9.getJSONObject(var3);
                     if(var10.has("content_id") && !var10.has("id")) {
                        var10.put("id", var10.getInt("content_id"));
                     }

                     var5 = var11;
                     if(var10.has("id")) {
                        var5 = var11;
                        if(var3 > 0) {
                           var5 = var11 + ",";
                        }

                        var5 = var5 + var10.get("id").toString();
                     }

                     this.insert(var1 + "_" + var8, var10);
                     ++var3;
                  }

                  var5 = var11;
                  if(var11.length() > 0) {
                     var5 = "/" + var11;
                  }

                  var6.put(var8, "@array/" + var1 + "_" + var8 + var5);
               }
            }
         }
      }

      this.open().replace(var1, (String)null, var6);
   }

   public void insertData(String param1, String param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public boolean isColumntExists(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean isTableExists(String var1) {
      boolean var3 = true;
      SQLiteDatabase var4 = this.open();
      if(var1 != null && var4 != null && var4.isOpen()) {
         Cursor var5 = var4.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", var1});
         if(var5.moveToFirst()) {
            int var2 = var5.getInt(0);
            var5.close();
            var4.close();
            if(var2 <= 0) {
               var3 = false;
            }

            return var3;
         }
      }

      return false;
   }

   public void setFilters(List var1) {
      this.filters = var1;
   }

   public void update(String var1, int var2, String var3, Object var4) {
      String var5 = var1.replaceAll("\\/", "_");
      if(this.isTableExists(var5)) {
         ContentValues var6 = new ContentValues();
         if(var4 instanceof Integer) {
            var1 = "@int/" + var4;
         } else if(var4 instanceof Double) {
            var1 = "@double/" + var4;
         } else {
            if(!(var4 instanceof String)) {
               return;
            }

            var1 = "@string/" + var4;
         }

         var6.put(var3, var1);
         SQLiteDatabase var7 = this.open();
         var7.update(var5, var6, "id=?", new String[]{String.valueOf(var2)});
         var7.close();
      }

   }
}
