package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.DelegateProvider;
import io.fabric.sdk.android.services.concurrency.Dependency;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityProvider;
import io.fabric.sdk.android.services.concurrency.PriorityTask;
import io.fabric.sdk.android.services.concurrency.Task;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PriorityFutureTask extends FutureTask implements Dependency, PriorityProvider, Task, DelegateProvider {
   final Object delegate;

   public PriorityFutureTask(Runnable var1, Object var2) {
      super(var1, var2);
      this.delegate = this.checkAndInitDelegate(var1);
   }

   public PriorityFutureTask(Callable var1) {
      super(var1);
      this.delegate = this.checkAndInitDelegate(var1);
   }

   public void addDependency(Task var1) {
      ((Dependency)((PriorityProvider)this.getDelegate())).addDependency(var1);
   }

   public boolean areDependenciesMet() {
      return ((Dependency)((PriorityProvider)this.getDelegate())).areDependenciesMet();
   }

   protected Dependency checkAndInitDelegate(Object var1) {
      return (Dependency)(PriorityTask.isProperDelegate(var1)?(Dependency)var1:new PriorityTask());
   }

   public int compareTo(Object var1) {
      return ((PriorityProvider)this.getDelegate()).compareTo(var1);
   }

   public Dependency getDelegate() {
      return (Dependency)this.delegate;
   }

   public Collection getDependencies() {
      return ((Dependency)((PriorityProvider)this.getDelegate())).getDependencies();
   }

   public Throwable getError() {
      return ((Task)((PriorityProvider)this.getDelegate())).getError();
   }

   public Priority getPriority() {
      return ((PriorityProvider)this.getDelegate()).getPriority();
   }

   public boolean isFinished() {
      return ((Task)((PriorityProvider)this.getDelegate())).isFinished();
   }

   public void setError(Throwable var1) {
      ((Task)((PriorityProvider)this.getDelegate())).setError(var1);
   }

   public void setFinished(boolean var1) {
      ((Task)((PriorityProvider)this.getDelegate())).setFinished(var1);
   }
}
