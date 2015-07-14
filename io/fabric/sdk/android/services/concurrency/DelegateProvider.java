package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.Dependency;

public interface DelegateProvider {
   Dependency getDelegate();
}
