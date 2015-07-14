package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEventTransform;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.UUID;

class SessionAnalyticsFilesManager extends EventsFilesManager {
   private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
   private AnalyticsSettingsData analyticsSettingsData;

   SessionAnalyticsFilesManager(Context var1, SessionEventTransform var2, CurrentTimeProvider var3, EventsStorage var4) throws IOException {
      super(var1, var2, var3, var4, 100);
   }

   protected String generateUniqueRollOverFileName() {
      UUID var1 = UUID.randomUUID();
      return "sa" + "_" + var1.toString() + "_" + this.currentTimeProvider.getCurrentTimeMillis() + ".tap";
   }

   protected int getMaxByteSizePerFile() {
      return this.analyticsSettingsData == null?super.getMaxByteSizePerFile():this.analyticsSettingsData.maxByteSizePerFile;
   }

   protected int getMaxFilesToKeep() {
      return this.analyticsSettingsData == null?super.getMaxFilesToKeep():this.analyticsSettingsData.maxPendingSendFileCount;
   }

   void setAnalyticsSettingsData(AnalyticsSettingsData var1) {
      this.analyticsSettingsData = var1;
   }
}
