package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue;
import io.fabric.sdk.android.services.concurrency.PriorityFutureTask;
import io.fabric.sdk.android.services.concurrency.PriorityTask;
import io.fabric.sdk.android.services.concurrency.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
   private static final int CORE_POOL_SIZE;
   private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
   private static final long KEEP_ALIVE = 1L;
   private static final int MAXIMUM_POOL_SIZE;

   static {
      CORE_POOL_SIZE = CPU_COUNT + 1;
      MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
   }

   PriorityThreadPoolExecutor(int var1, int var2, long var3, TimeUnit var5, DependencyPriorityBlockingQueue var6, ThreadFactory var7) {
      super(var1, var2, var3, var5, var6, var7);
      this.prestartAllCoreThreads();
   }

   public static PriorityThreadPoolExecutor create() {
      return create(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE);
   }

   public static PriorityThreadPoolExecutor create(int var0) {
      return create(var0, var0);
   }

   public static PriorityThreadPoolExecutor create(int var0, int var1) {
      return new PriorityThreadPoolExecutor(var0, var1, 1L, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new PriorityThreadPoolExecutor.PriorityThreadFactory(10));
   }

   protected void afterExecute(Runnable var1, Throwable var2) {
      Task var3 = (Task)var1;
      var3.setFinished(true);
      var3.setError(var2);
      this.getQueue().recycleBlockedQueue();
      super.afterExecute(var1, var2);
   }

   public void execute(Runnable var1) {
      if(PriorityTask.isProperDelegate(var1)) {
         super.execute(var1);
      } else {
         super.execute(this.newTaskFor(var1, (Object)null));
      }
   }

   public DependencyPriorityBlockingQueue getQueue() {
      return (DependencyPriorityBlockingQueue)super.getQueue();
   }

   protected RunnableFuture newTaskFor(Runnable var1, Object var2) {
      return new PriorityFutureTask(var1, var2);
   }

   protected RunnableFuture newTaskFor(Callable var1) {
      return new PriorityFutureTask(var1);
   }

   protected static final class PriorityThreadFactory implements ThreadFactory {
      private final int threadPriority;

      public PriorityThreadFactory(int var1) {
         this.threadPriority = var1;
      }

      public Thread newThread(Runnable var1) {
         Thread var2 = new Thread(var1);
         var2.setPriority(this.threadPriority);
         var2.setName("Queue");
         return var2;
      }
   }
}
