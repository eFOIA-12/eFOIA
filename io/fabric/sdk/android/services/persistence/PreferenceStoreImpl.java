package io.fabric.sdk.android.services.persistence;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.persistence.PreferenceStore;

public class PreferenceStoreImpl implements PreferenceStore {
   private final Context context;
   private final String preferenceName;
   private final SharedPreferences sharedPreferences;

   public PreferenceStoreImpl(Context var1, String var2) {
      if(var1 == null) {
         throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
      } else {
         this.context = var1;
         this.preferenceName = var2;
         this.sharedPreferences = this.context.getSharedPreferences(this.preferenceName, 0);
      }
   }

   public PreferenceStoreImpl(Kit var1) {
      this(var1.getContext(), var1.getClass().getName());
   }

   public Editor edit() {
      return this.sharedPreferences.edit();
   }

   public SharedPreferences get() {
      return this.sharedPreferences;
   }

   @TargetApi(9)
   public boolean save(Editor var1) {
      if(VERSION.SDK_INT >= 9) {
         var1.apply();
         return true;
      } else {
         return var1.commit();
      }
   }
}
