package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;

public interface Dependency {
   void addDependency(Object var1);

   boolean areDependenciesMet();

   Collection getDependencies();
}
