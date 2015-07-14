package com.crashlytics.android.answers;

import com.crashlytics.android.answers.EventFilter;
import com.crashlytics.android.answers.SessionEvent;

public class KeepAllEventFilter implements EventFilter {
   public boolean skipEvent(SessionEvent var1) {
      return false;
   }
}
