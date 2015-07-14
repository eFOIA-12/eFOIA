package io.fabric.sdk.android.services.persistence;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;

public class FileStoreImpl implements FileStore {
   private final String contentPath;
   private final Context context;
   private final String legacySupport;

   public FileStoreImpl(Kit var1) {
      if(var1.getContext() == null) {
         throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
      } else {
         this.context = var1.getContext();
         this.contentPath = var1.getPath();
         this.legacySupport = "Android/" + this.context.getPackageName();
      }
   }

   public File getCacheDir() {
      return this.prepare(this.context.getCacheDir());
   }

   public File getExternalCacheDir() {
      File var1 = null;
      if(this.isExternalStorageAvailable()) {
         if(VERSION.SDK_INT >= 8) {
            var1 = this.context.getExternalCacheDir();
         } else {
            var1 = new File(Environment.getExternalStorageDirectory(), this.legacySupport + "/cache/" + this.contentPath);
         }
      }

      return this.prepare(var1);
   }

   @TargetApi(8)
   public File getExternalFilesDir() {
      File var1 = null;
      if(this.isExternalStorageAvailable()) {
         if(VERSION.SDK_INT >= 8) {
            var1 = this.context.getExternalFilesDir((String)null);
         } else {
            var1 = new File(Environment.getExternalStorageDirectory(), this.legacySupport + "/files/" + this.contentPath);
         }
      }

      return this.prepare(var1);
   }

   public File getFilesDir() {
      return this.prepare(this.context.getFilesDir());
   }

   boolean isExternalStorageAvailable() {
      if(!"mounted".equals(Environment.getExternalStorageState())) {
         Fabric.getLogger().w("Fabric", "External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
         return false;
      } else {
         return true;
      }
   }

   File prepare(File var1) {
      if(var1 != null) {
         if(var1.exists() || var1.mkdirs()) {
            return var1;
         }

         Fabric.getLogger().w("Fabric", "Couldn\'t create file");
      } else {
         Fabric.getLogger().d("Fabric", "Null File");
      }

      return null;
   }
}
