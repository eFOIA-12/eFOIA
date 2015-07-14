package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.Priority;

public interface PriorityProvider extends Comparable {
   Priority getPriority();
}
