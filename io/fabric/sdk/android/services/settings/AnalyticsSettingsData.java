package io.fabric.sdk.android.services.settings;

public class AnalyticsSettingsData {
   public static final int DEFAULT_SAMPLING_RATE = 1;
   public final String analyticsURL;
   public final int flushIntervalSeconds;
   public final int maxByteSizePerFile;
   public final int maxFileCountPerSend;
   public final int maxPendingSendFileCount;
   public final int samplingRate;
   public final boolean trackCustomEvents;

   @Deprecated
   public AnalyticsSettingsData(String var1, int var2, int var3, int var4, int var5, boolean var6) {
      this(var1, var2, var3, var4, var5, var6, 1);
   }

   public AnalyticsSettingsData(String var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
      this.analyticsURL = var1;
      this.flushIntervalSeconds = var2;
      this.maxByteSizePerFile = var3;
      this.maxFileCountPerSend = var4;
      this.maxPendingSendFileCount = var5;
      this.trackCustomEvents = var6;
      this.samplingRate = var7;
   }
}
