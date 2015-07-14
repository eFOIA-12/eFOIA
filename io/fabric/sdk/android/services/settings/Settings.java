package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.SettingsController;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Settings {
   public static final String SETTINGS_CACHE_FILENAME = "com.crashlytics.settings.json";
   private static final String SETTINGS_URL_FORMAT = "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings";
   private boolean initialized;
   private SettingsController settingsController;
   private final AtomicReference settingsData;
   private final CountDownLatch settingsDataLatch;

   private Settings() {
      this.settingsData = new AtomicReference();
      this.settingsDataLatch = new CountDownLatch(1);
      this.initialized = false;
   }

   // $FF: synthetic method
   Settings(Object var1) {
      this();
   }

   public static Settings getInstance() {
      return Settings.LazyHolder.INSTANCE;
   }

   private void setSettingsData(SettingsData var1) {
      this.settingsData.set(var1);
      this.settingsDataLatch.countDown();
   }

   public SettingsData awaitSettingsData() {
      try {
         this.settingsDataLatch.await();
         SettingsData var1 = (SettingsData)this.settingsData.get();
         return var1;
      } catch (InterruptedException var2) {
         Fabric.getLogger().e("Fabric", "Interrupted while waiting for settings data.");
         return null;
      }
   }

   public void clearSettings() {
      this.settingsData.set((Object)null);
   }

   public Settings initialize(Kit param1, IdManager param2, HttpRequestFactory param3, String param4, String param5, String param6) {
      // $FF: Couldn't be decompiled
   }

   public boolean loadSettingsData() {
      synchronized(this){}
      boolean var4 = false;

      SettingsData var2;
      try {
         var4 = true;
         var2 = this.settingsController.loadSettingsData();
         this.setSettingsData(var2);
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      boolean var1;
      if(var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean loadSettingsSkippingCache() {
      // $FF: Couldn't be decompiled
   }

   public void setSettingsController(SettingsController var1) {
      this.settingsController = var1;
   }

   public Object withSettings(Settings.SettingsAccess var1, Object var2) {
      SettingsData var3 = (SettingsData)this.settingsData.get();
      return var3 == null?var2:var1.usingSettings(var3);
   }

   static class LazyHolder {
      private static final Settings INSTANCE = new Settings(null);
   }

   public interface SettingsAccess {
      Object usingSettings(SettingsData var1);
   }
}
