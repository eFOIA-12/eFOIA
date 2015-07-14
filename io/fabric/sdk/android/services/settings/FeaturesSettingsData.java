package io.fabric.sdk.android.services.settings;

public class FeaturesSettingsData {
   public final boolean collectAnalytics;
   public final boolean collectLoggedException;
   public final boolean collectReports;
   public final boolean promptEnabled;

   public FeaturesSettingsData(boolean var1, boolean var2, boolean var3, boolean var4) {
      this.promptEnabled = var1;
      this.collectLoggedException = var2;
      this.collectReports = var3;
      this.collectAnalytics = var4;
   }
}
