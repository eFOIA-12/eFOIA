package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.AdvertisingInfo;
import io.fabric.sdk.android.services.common.AdvertisingInfoReflectionStrategy;
import io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy;
import io.fabric.sdk.android.services.common.AdvertisingInfoStrategy;
import io.fabric.sdk.android.services.common.BackgroundPriorityRunnable;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AdvertisingInfoProvider {
   private static final String ADVERTISING_INFO_PREFERENCES = "TwitterAdvertisingInfoPreferences";
   private static final String PREFKEY_ADVERTISING_ID = "advertising_id";
   private static final String PREFKEY_LIMIT_AD_TRACKING = "limit_ad_tracking_enabled";
   private final Context context;
   private final PreferenceStore preferenceStore;

   public AdvertisingInfoProvider(Context var1) {
      this.context = var1.getApplicationContext();
      this.preferenceStore = new PreferenceStoreImpl(var1, "TwitterAdvertisingInfoPreferences");
   }

   private AdvertisingInfo getAdvertisingInfoFromStrategies() {
      AdvertisingInfo var1 = this.getReflectionStrategy().getAdvertisingInfo();
      if(!this.isInfoValid(var1)) {
         var1 = this.getServiceStrategy().getAdvertisingInfo();
         if(!this.isInfoValid(var1)) {
            Fabric.getLogger().d("Fabric", "AdvertisingInfo not present");
            return var1;
         } else {
            Fabric.getLogger().d("Fabric", "Using AdvertisingInfo from Service Provider");
            return var1;
         }
      } else {
         Fabric.getLogger().d("Fabric", "Using AdvertisingInfo from Reflection Provider");
         return var1;
      }
   }

   private boolean isInfoValid(AdvertisingInfo var1) {
      return var1 != null && !TextUtils.isEmpty(var1.advertisingId);
   }

   private void refreshInfoIfNeededAsync(final AdvertisingInfo var1) {
      (new Thread(new BackgroundPriorityRunnable() {
         public void onRun() {
            AdvertisingInfo var1x = AdvertisingInfoProvider.this.getAdvertisingInfoFromStrategies();
            if(!var1.equals(var1x)) {
               Fabric.getLogger().d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
               AdvertisingInfoProvider.this.storeInfoToPreferences(var1x);
            }

         }
      })).start();
   }

   @SuppressLint({"CommitPrefEdits"})
   private void storeInfoToPreferences(AdvertisingInfo var1) {
      if(this.isInfoValid(var1)) {
         this.preferenceStore.save(this.preferenceStore.edit().putString("advertising_id", var1.advertisingId).putBoolean("limit_ad_tracking_enabled", var1.limitAdTrackingEnabled));
      } else {
         this.preferenceStore.save(this.preferenceStore.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
      }
   }

   public AdvertisingInfo getAdvertisingInfo() {
      AdvertisingInfo var1 = this.getInfoFromPreferences();
      if(this.isInfoValid(var1)) {
         Fabric.getLogger().d("Fabric", "Using AdvertisingInfo from Preference Store");
         this.refreshInfoIfNeededAsync(var1);
         return var1;
      } else {
         var1 = this.getAdvertisingInfoFromStrategies();
         this.storeInfoToPreferences(var1);
         return var1;
      }
   }

   protected AdvertisingInfo getInfoFromPreferences() {
      return new AdvertisingInfo(this.preferenceStore.get().getString("advertising_id", ""), this.preferenceStore.get().getBoolean("limit_ad_tracking_enabled", false));
   }

   public AdvertisingInfoStrategy getReflectionStrategy() {
      return new AdvertisingInfoReflectionStrategy(this.context);
   }

   public AdvertisingInfoStrategy getServiceStrategy() {
      return new AdvertisingInfoServiceStrategy(this.context);
   }
}
