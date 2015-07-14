package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionAnalyticsManagerStrategy;
import io.fabric.sdk.android.services.events.DisabledEventsStrategy;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

class DisabledSessionAnalyticsManagerStrategy extends DisabledEventsStrategy implements SessionAnalyticsManagerStrategy {
   public void setAnalyticsSettingsData(AnalyticsSettingsData var1, String var2) {
   }
}
