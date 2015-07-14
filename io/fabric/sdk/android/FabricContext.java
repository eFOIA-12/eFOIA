package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

class FabricContext extends ContextWrapper {
   private final String componentName;
   private final String componentPath;

   public FabricContext(Context var1, String var2, String var3) {
      super(var1);
      this.componentName = var2;
      this.componentPath = var3;
   }

   public File getCacheDir() {
      return new File(super.getCacheDir(), this.componentPath);
   }

   public File getDatabasePath(String var1) {
      File var2 = new File(super.getDatabasePath(var1).getParentFile(), this.componentPath);
      var2.mkdirs();
      return new File(var2, var1);
   }

   @TargetApi(8)
   public File getExternalCacheDir() {
      return new File(super.getExternalCacheDir(), this.componentPath);
   }

   @TargetApi(8)
   public File getExternalFilesDir(String var1) {
      return new File(super.getExternalFilesDir(var1), this.componentPath);
   }

   public File getFilesDir() {
      return new File(super.getFilesDir(), this.componentPath);
   }

   public SharedPreferences getSharedPreferences(String var1, int var2) {
      return super.getSharedPreferences(this.componentName + ":" + var1, var2);
   }

   public SQLiteDatabase openOrCreateDatabase(String var1, int var2, CursorFactory var3) {
      return SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath(var1), var3);
   }

   @TargetApi(11)
   public SQLiteDatabase openOrCreateDatabase(String var1, int var2, CursorFactory var3, DatabaseErrorHandler var4) {
      return SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath(var1).getPath(), var3, var4);
   }
}
