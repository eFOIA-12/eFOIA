package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import io.fabric.sdk.android.services.settings.AppIconSettingsData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.fabric.sdk.android.services.settings.SettingsJsonTransform;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsJsonTransform implements SettingsJsonTransform {
   private AnalyticsSettingsData buildAnalyticsSessionDataFrom(JSONObject var1) {
      return new AnalyticsSettingsData(var1.optString("url", "https://e.crashlytics.com/spi/v2/events"), var1.optInt("flush_interval_secs", 600), var1.optInt("max_byte_size_per_file", 8000), var1.optInt("max_file_count_per_send", 1), var1.optInt("max_pending_send_file_count", 100), var1.optBoolean("track_custom_events", true), var1.optInt("sampling_rate", 1));
   }

   private AppSettingsData buildAppDataFrom(JSONObject var1) throws JSONException {
      String var5 = var1.getString("identifier");
      String var6 = var1.getString("status");
      String var7 = var1.getString("url");
      String var8 = var1.getString("reports_url");
      boolean var2 = var1.optBoolean("update_required", false);
      Object var4 = null;
      AppIconSettingsData var3 = (AppIconSettingsData)var4;
      if(var1.has("icon")) {
         var3 = (AppIconSettingsData)var4;
         if(var1.getJSONObject("icon").has("hash")) {
            var3 = this.buildIconDataFrom(var1.getJSONObject("icon"));
         }
      }

      return new AppSettingsData(var5, var6, var7, var8, var2, var3);
   }

   private BetaSettingsData buildBetaSettingsDataFrom(JSONObject var1) throws JSONException {
      return new BetaSettingsData(var1.optString("update_endpoint", SettingsJsonConstants.BETA_UPDATE_ENDPOINT_DEFAULT), var1.optInt("update_suspend_duration", 3600));
   }

   private FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject var1) {
      return new FeaturesSettingsData(var1.optBoolean("prompt_enabled", false), var1.optBoolean("collect_logged_exceptions", true), var1.optBoolean("collect_reports", true), var1.optBoolean("collect_analytics", false));
   }

   private AppIconSettingsData buildIconDataFrom(JSONObject var1) throws JSONException {
      return new AppIconSettingsData(var1.getString("hash"), var1.getInt("width"), var1.getInt("height"));
   }

   private PromptSettingsData buildPromptDataFrom(JSONObject var1) throws JSONException {
      return new PromptSettingsData(var1.optString("title", "Send Crash Report?"), var1.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), var1.optString("send_button_title", "Send"), var1.optBoolean("show_cancel_button", true), var1.optString("cancel_button_title", "Don\'t Send"), var1.optBoolean("show_always_send_button", true), var1.optString("always_send_button_title", "Always Send"));
   }

   private SessionSettingsData buildSessionDataFrom(JSONObject var1) throws JSONException {
      return new SessionSettingsData(var1.optInt("log_buffer_size", '切'), var1.optInt("max_chained_exception_depth", 8), var1.optInt("max_custom_exception_events", 64), var1.optInt("max_custom_key_value_pairs", 64), var1.optInt("identifier_mask", 255), var1.optBoolean("send_session_without_crash", false));
   }

   private long getExpiresAtFrom(CurrentTimeProvider var1, long var2, JSONObject var4) throws JSONException {
      return var4.has("expires_at")?var4.getLong("expires_at"):var1.getCurrentTimeMillis() + 1000L * var2;
   }

   private JSONObject toAnalyticsJson(AnalyticsSettingsData var1) throws JSONException {
      return (new JSONObject()).put("url", var1.analyticsURL).put("flush_interval_secs", var1.flushIntervalSeconds).put("max_byte_size_per_file", var1.maxByteSizePerFile).put("max_file_count_per_send", var1.maxFileCountPerSend).put("max_pending_send_file_count", var1.maxPendingSendFileCount);
   }

   private JSONObject toAppJson(AppSettingsData var1) throws JSONException {
      JSONObject var2 = (new JSONObject()).put("identifier", var1.identifier).put("status", var1.status).put("url", var1.url).put("reports_url", var1.reportsUrl).put("update_required", var1.updateRequired);
      if(var1.icon != null) {
         var2.put("icon", this.toIconJson(var1.icon));
      }

      return var2;
   }

   private JSONObject toBetaJson(BetaSettingsData var1) throws JSONException {
      return (new JSONObject()).put("update_endpoint", var1.updateUrl).put("update_suspend_duration", var1.updateSuspendDurationSeconds);
   }

   private JSONObject toFeaturesJson(FeaturesSettingsData var1) throws JSONException {
      return (new JSONObject()).put("collect_logged_exceptions", var1.collectLoggedException).put("collect_reports", var1.collectReports).put("collect_analytics", var1.collectAnalytics);
   }

   private JSONObject toIconJson(AppIconSettingsData var1) throws JSONException {
      return (new JSONObject()).put("hash", var1.hash).put("width", var1.width).put("height", var1.height);
   }

   private JSONObject toPromptJson(PromptSettingsData var1) throws JSONException {
      return (new JSONObject()).put("title", var1.title).put("message", var1.message).put("send_button_title", var1.sendButtonTitle).put("show_cancel_button", var1.showCancelButton).put("cancel_button_title", var1.cancelButtonTitle).put("show_always_send_button", var1.showAlwaysSendButton).put("always_send_button_title", var1.alwaysSendButtonTitle);
   }

   private JSONObject toSessionJson(SessionSettingsData var1) throws JSONException {
      return (new JSONObject()).put("log_buffer_size", var1.logBufferSize).put("max_chained_exception_depth", var1.maxChainedExceptionDepth).put("max_custom_exception_events", var1.maxCustomExceptionEvents).put("max_custom_key_value_pairs", var1.maxCustomKeyValuePairs).put("identifier_mask", var1.identifierMask).put("send_session_without_crash", var1.sendSessionWithoutCrash);
   }

   public SettingsData buildFromJson(CurrentTimeProvider var1, JSONObject var2) throws JSONException {
      int var3 = var2.optInt("settings_version", 0);
      int var4 = var2.optInt("cache_duration", 3600);
      AppSettingsData var5 = this.buildAppDataFrom(var2.getJSONObject("app"));
      SessionSettingsData var6 = this.buildSessionDataFrom(var2.getJSONObject("session"));
      PromptSettingsData var7 = this.buildPromptDataFrom(var2.getJSONObject("prompt"));
      FeaturesSettingsData var8 = this.buildFeaturesSessionDataFrom(var2.getJSONObject("features"));
      AnalyticsSettingsData var9 = this.buildAnalyticsSessionDataFrom(var2.getJSONObject("analytics"));
      BetaSettingsData var10 = this.buildBetaSettingsDataFrom(var2.getJSONObject("beta"));
      return new SettingsData(this.getExpiresAtFrom(var1, (long)var4, var2), var5, var6, var7, var8, var9, var10, var3, var4);
   }

   public JSONObject sanitizeTraceInfo(JSONObject var1) throws JSONException {
      var1 = new JSONObject(var1.toString());
      var1.getJSONObject("features").remove("collect_analytics");
      var1.remove("analytics");
      return var1;
   }

   public JSONObject toJson(SettingsData var1) throws JSONException {
      return (new JSONObject()).put("expires_at", var1.expiresAtMillis).put("cache_duration", var1.cacheDuration).put("settings_version", var1.settingsVersion).put("features", this.toFeaturesJson(var1.featuresData)).put("analytics", this.toAnalyticsJson(var1.analyticsSettingsData)).put("beta", this.toBetaJson(var1.betaSettingsData)).put("app", this.toAppJson(var1.appData)).put("session", this.toSessionJson(var1.sessionData)).put("prompt", this.toPromptJson(var1.promptData));
   }
}
