package com.crashlytics.android.beta;

import android.content.Context;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.beta.BuildProperties;
import com.crashlytics.android.beta.CheckForUpdatesRequest;
import com.crashlytics.android.beta.CheckForUpdatesResponseTransform;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.settings.BetaSettingsData;

class CheckForUpdatesController {
   static final long LAST_UPDATE_CHECK_DEFAULT = 0L;
   static final String LAST_UPDATE_CHECK_KEY = "last_update_check";
   private final Beta beta;
   private final BetaSettingsData betaSettings;
   private final BuildProperties buildProps;
   private final Context context;
   private final CurrentTimeProvider currentTimeProvider;
   private final HttpRequestFactory httpRequestFactory;
   private final IdManager idManager;
   private final PreferenceStore preferenceStore;

   public CheckForUpdatesController(Context var1, Beta var2, IdManager var3, BetaSettingsData var4, BuildProperties var5, PreferenceStore var6, CurrentTimeProvider var7, HttpRequestFactory var8) {
      this.context = var1;
      this.beta = var2;
      this.idManager = var3;
      this.betaSettings = var4;
      this.buildProps = var5;
      this.preferenceStore = var6;
      this.currentTimeProvider = var7;
      this.httpRequestFactory = var8;
   }

   public void checkForUpdates() {
      long var1 = this.currentTimeProvider.getCurrentTimeMillis();
      long var3 = (long)(this.betaSettings.updateSuspendDurationSeconds * 1000);
      Fabric.getLogger().d("Beta", "Check for updates delay: " + var3);
      long var5 = this.preferenceStore.get().getLong("last_update_check", 0L);
      Fabric.getLogger().d("Beta", "Check for updates last check time: " + var5);
      var3 += var5;
      Fabric.getLogger().d("Beta", "Check for updates current time: " + var1 + ", next check time: " + var3);
      if(var1 >= var3) {
         try {
            Fabric.getLogger().d("Beta", "Performing update check");
            String var7 = (new ApiKey()).getValue(this.context);
            String var8 = this.idManager.createIdHeaderValue(var7, this.buildProps.packageName);
            (new CheckForUpdatesRequest(this.beta, this.beta.getOverridenSpiEndpoint(), this.betaSettings.updateUrl, this.httpRequestFactory, new CheckForUpdatesResponseTransform())).invoke(var7, var8, this.buildProps);
         } finally {
            this.preferenceStore.edit().putLong("last_update_check", var1).commit();
         }

      } else {
         Fabric.getLogger().d("Beta", "Check for updates next check time was not passed");
      }
   }
}
