package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;

public interface EventFilter {
   boolean skipEvent(SessionEvent var1);
}
