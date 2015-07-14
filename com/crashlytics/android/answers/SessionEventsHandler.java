package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.DisabledSessionAnalyticsManagerStrategy;
import com.crashlytics.android.answers.SessionAnalyticsFilesManager;
import com.crashlytics.android.answers.SessionAnalyticsManagerStrategy;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.EventsHandler;
import io.fabric.sdk.android.services.events.EventsStrategy;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class SessionEventsHandler extends EventsHandler {
   SessionEventsHandler(Context var1, EventsStrategy var2, SessionAnalyticsFilesManager var3, ScheduledExecutorService var4) {
      super(var1, var2, var3, var4);
   }

   protected EventsStrategy getDisabledEventsStrategy() {
      return new DisabledSessionAnalyticsManagerStrategy();
   }

   protected void setAnalyticsSettingsData(final AnalyticsSettingsData var1, final String var2) {
      super.executeAsync(new Runnable() {
         public void run() {
            try {
               ((SessionAnalyticsManagerStrategy)SessionEventsHandler.this.strategy).setAnalyticsSettingsData(var1, var2);
            } catch (Exception var2x) {
               CommonUtils.logControlledError(Answers.getInstance().getContext(), "Crashlytics failed to set analytics settings data.", var2x);
            }
         }
      });
   }
}
