package io.fabric.sdk.android.services.settings;

public class BetaSettingsData {
   public final int updateSuspendDurationSeconds;
   public final String updateUrl;

   public BetaSettingsData(String var1, int var2) {
      this.updateUrl = var1;
      this.updateSuspendDurationSeconds = var2;
   }
}
