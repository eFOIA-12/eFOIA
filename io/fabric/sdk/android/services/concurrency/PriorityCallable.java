package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.PriorityTask;
import java.util.concurrent.Callable;

public abstract class PriorityCallable extends PriorityTask implements Callable {
}
