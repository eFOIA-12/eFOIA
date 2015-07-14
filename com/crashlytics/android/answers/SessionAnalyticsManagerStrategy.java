package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.events.EventsStrategy;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

interface SessionAnalyticsManagerStrategy extends EventsStrategy {
   void setAnalyticsSettingsData(AnalyticsSettingsData var1, String var2);
}
