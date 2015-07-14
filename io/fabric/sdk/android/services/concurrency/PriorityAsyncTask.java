package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.DelegateProvider;
import io.fabric.sdk.android.services.concurrency.Dependency;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityFutureTask;
import io.fabric.sdk.android.services.concurrency.PriorityProvider;
import io.fabric.sdk.android.services.concurrency.PriorityTask;
import io.fabric.sdk.android.services.concurrency.Task;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class PriorityAsyncTask extends AsyncTask implements Dependency, PriorityProvider, Task, DelegateProvider {
   private final PriorityTask priorityTask = new PriorityTask();

   public void addDependency(Task var1) {
      if(this.getStatus() != AsyncTask.Status.PENDING) {
         throw new IllegalStateException("Must not add Dependency after task is running");
      } else {
         ((Dependency)((PriorityProvider)this.getDelegate())).addDependency(var1);
      }
   }

   public boolean areDependenciesMet() {
      return ((Dependency)((PriorityProvider)this.getDelegate())).areDependenciesMet();
   }

   public int compareTo(Object var1) {
      return Priority.compareTo(this, var1);
   }

   public final void executeOnExecutor(ExecutorService var1, Object... var2) {
      super.executeOnExecutor(new PriorityAsyncTask.ProxyExecutor(var1, this), var2);
   }

   public Dependency getDelegate() {
      return this.priorityTask;
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

   private static class ProxyExecutor implements Executor {
      private final Executor executor;
      private final PriorityAsyncTask task;

      public ProxyExecutor(Executor var1, PriorityAsyncTask var2) {
         this.executor = var1;
         this.task = var2;
      }

      public void execute(final Runnable var1) {
         this.executor.execute(new PriorityFutureTask(var1, (Object)null) {
            public Dependency getDelegate() {
               return ProxyExecutor.this.task;
            }
         });
      }
   }
}
