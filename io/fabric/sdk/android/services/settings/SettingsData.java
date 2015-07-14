package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;

public class SettingsData {
   public final AnalyticsSettingsData analyticsSettingsData;
   public final AppSettingsData appData;
   public final BetaSettingsData betaSettingsData;
   public final int cacheDuration;
   public final long expiresAtMillis;
   public final FeaturesSettingsData featuresData;
   public final PromptSettingsData promptData;
   public final SessionSettingsData sessionData;
   public final int settingsVersion;

   public SettingsData(long var1, AppSettingsData var3, SessionSettingsData var4, PromptSettingsData var5, FeaturesSettingsData var6, AnalyticsSettingsData var7, BetaSettingsData var8, int var9, int var10) {
      this.expiresAtMillis = var1;
      this.appData = var3;
      this.sessionData = var4;
      this.promptData = var5;
      this.featuresData = var6;
      this.settingsVersion = var9;
      this.cacheDuration = var10;
      this.analyticsSettingsData = var7;
      this.betaSettingsData = var8;
   }

   public boolean isExpired(long var1) {
      return this.expiresAtMillis < var1;
   }
}
