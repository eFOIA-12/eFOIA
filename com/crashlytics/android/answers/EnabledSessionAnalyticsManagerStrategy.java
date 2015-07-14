package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.AnswersRetryFilesSender;
import com.crashlytics.android.answers.EventFilter;
import com.crashlytics.android.answers.KeepAllEventFilter;
import com.crashlytics.android.answers.SamplingEventFilter;
import com.crashlytics.android.answers.SessionAnalyticsFilesManager;
import com.crashlytics.android.answers.SessionAnalyticsFilesSender;
import com.crashlytics.android.answers.SessionAnalyticsManagerStrategy;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.EnabledEventsStrategy;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class EnabledSessionAnalyticsManagerStrategy extends EnabledEventsStrategy implements SessionAnalyticsManagerStrategy {
   EventFilter eventFilter = new KeepAllEventFilter();
   FilesSender filesSender;
   private final HttpRequestFactory httpRequestFactory;

   public EnabledSessionAnalyticsManagerStrategy(Context var1, ScheduledExecutorService var2, SessionAnalyticsFilesManager var3, HttpRequestFactory var4) {
      super(var1, var2, var3);
      this.httpRequestFactory = var4;
   }

   public FilesSender getFilesSender() {
      return this.filesSender;
   }

   public void recordEvent(SessionEvent var1) {
      if(this.eventFilter.skipEvent(var1)) {
         CommonUtils.logControlled(Answers.getInstance().getContext(), "skipping filtered event " + var1);
      } else {
         super.recordEvent(var1);
      }
   }

   public void setAnalyticsSettingsData(AnalyticsSettingsData var1, String var2) {
      this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(Answers.getInstance(), var2, var1.analyticsURL, this.httpRequestFactory, (new ApiKey()).getValue(this.context)));
      ((SessionAnalyticsFilesManager)this.filesManager).setAnalyticsSettingsData(var1);
      this.configureRollover(var1.flushIntervalSeconds);
      if(var1.samplingRate > 1) {
         this.eventFilter = new SamplingEventFilter(var1.samplingRate);
      }

   }
}
