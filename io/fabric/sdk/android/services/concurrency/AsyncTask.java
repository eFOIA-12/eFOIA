package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask {
   private static final int CORE_POOL_SIZE;
   private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
   private static final int KEEP_ALIVE = 1;
   private static final String LOG_TAG = "AsyncTask";
   private static final int MAXIMUM_POOL_SIZE;
   private static final int MESSAGE_POST_PROGRESS = 2;
   private static final int MESSAGE_POST_RESULT = 1;
   public static final Executor SERIAL_EXECUTOR;
   public static final Executor THREAD_POOL_EXECUTOR;
   private static volatile Executor defaultExecutor;
   private static final AsyncTask.InternalHandler handler;
   private static final BlockingQueue poolWorkQueue;
   private static final ThreadFactory threadFactory;
   private final AtomicBoolean cancelled;
   private final FutureTask future;
   private volatile AsyncTask.Status status;
   private final AtomicBoolean taskInvoked;
   private final AsyncTask.WorkerRunnable worker;

   static {
      CORE_POOL_SIZE = CPU_COUNT + 1;
      MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
      threadFactory = new ThreadFactory() {
         private final AtomicInteger count = new AtomicInteger(1);

         public Thread newThread(Runnable var1) {
            return new Thread(var1, "AsyncTask #" + this.count.getAndIncrement());
         }
      };
      poolWorkQueue = new LinkedBlockingQueue(128);
      THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1L, TimeUnit.SECONDS, poolWorkQueue, threadFactory);
      SERIAL_EXECUTOR = new AsyncTask.SerialExecutor(null);
      handler = new AsyncTask.InternalHandler();
      defaultExecutor = SERIAL_EXECUTOR;
   }

   public AsyncTask() {
      this.status = AsyncTask.Status.PENDING;
      this.cancelled = new AtomicBoolean();
      this.taskInvoked = new AtomicBoolean();
      this.worker = new AsyncTask.WorkerRunnable(null) {
         public Object call() throws Exception {
            AsyncTask.this.taskInvoked.set(true);
            Process.setThreadPriority(10);
            return AsyncTask.this.postResult(AsyncTask.this.doInBackground(this.params));
         }
      };
      this.future = new FutureTask(this.worker) {
         protected void done() {
            try {
               AsyncTask.this.postResultIfNotInvoked(this.get());
            } catch (InterruptedException var2) {
               Log.w("AsyncTask", var2);
            } catch (ExecutionException var3) {
               throw new RuntimeException("An error occured while executing doInBackground()", var3.getCause());
            } catch (CancellationException var4) {
               AsyncTask.this.postResultIfNotInvoked((Object)null);
            }
         }
      };
   }

   public static void execute(Runnable var0) {
      defaultExecutor.execute(var0);
   }

   private void finish(Object var1) {
      if(this.isCancelled()) {
         this.onCancelled(var1);
      } else {
         this.onPostExecute(var1);
      }

      this.status = AsyncTask.Status.FINISHED;
   }

   public static void init() {
      handler.getLooper();
   }

   private Object postResult(Object var1) {
      handler.obtainMessage(1, new AsyncTask.AsyncTaskResult(this, new Object[]{var1})).sendToTarget();
      return var1;
   }

   private void postResultIfNotInvoked(Object var1) {
      if(!this.taskInvoked.get()) {
         this.postResult(var1);
      }

   }

   public static void setDefaultExecutor(Executor var0) {
      defaultExecutor = var0;
   }

   public final boolean cancel(boolean var1) {
      this.cancelled.set(true);
      return this.future.cancel(var1);
   }

   protected abstract Object doInBackground(Object... var1);

   public final AsyncTask execute(Object... var1) {
      return this.executeOnExecutor(defaultExecutor, var1);
   }

   public final AsyncTask executeOnExecutor(Executor var1, Object... var2) {
      if(this.status != AsyncTask.Status.PENDING) {
         switch(null.$SwitchMap$io$fabric$sdk$android$services$concurrency$AsyncTask$Status[this.status.ordinal()]) {
         case 1:
            throw new IllegalStateException("Cannot execute task: the task is already running.");
         case 2:
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
         }
      }

      this.status = AsyncTask.Status.RUNNING;
      this.onPreExecute();
      this.worker.params = var2;
      var1.execute(this.future);
      return this;
   }

   public final Object get() throws InterruptedException, ExecutionException {
      return this.future.get();
   }

   public final Object get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException {
      return this.future.get(var1, var3);
   }

   public final AsyncTask.Status getStatus() {
      return this.status;
   }

   public final boolean isCancelled() {
      return this.cancelled.get();
   }

   protected void onCancelled() {
   }

   protected void onCancelled(Object var1) {
      this.onCancelled();
   }

   protected void onPostExecute(Object var1) {
   }

   protected void onPreExecute() {
   }

   protected void onProgressUpdate(Object... var1) {
   }

   protected final void publishProgress(Object... var1) {
      if(!this.isCancelled()) {
         handler.obtainMessage(2, new AsyncTask.AsyncTaskResult(this, var1)).sendToTarget();
      }

   }

   private static class AsyncTaskResult {
      final Object[] data;
      final AsyncTask task;

      AsyncTaskResult(AsyncTask var1, Object... var2) {
         this.task = var1;
         this.data = var2;
      }
   }

   private static class InternalHandler extends Handler {
      public InternalHandler() {
         super(Looper.getMainLooper());
      }

      public void handleMessage(Message var1) {
         AsyncTask.AsyncTaskResult var2 = (AsyncTask.AsyncTaskResult)var1.obj;
         switch(var1.what) {
         case 1:
            var2.task.finish(var2.data[0]);
            return;
         case 2:
            var2.task.onProgressUpdate(var2.data);
            return;
         default:
         }
      }
   }

   private static class SerialExecutor implements Executor {
      Runnable active;
      final LinkedList tasks;

      private SerialExecutor() {
         this.tasks = new LinkedList();
      }

      // $FF: synthetic method
      SerialExecutor(Object var1) {
         this();
      }

      public void execute(final Runnable var1) {
         synchronized(this){}

         try {
            this.tasks.offer(new Runnable() {
               public void run() {
                  try {
                     var1.run();
                  } finally {
                     SerialExecutor.this.scheduleNext();
                  }

               }
            });
            if(this.active == null) {
               this.scheduleNext();
            }
         } finally {
            ;
         }

      }

      protected void scheduleNext() {
         // $FF: Couldn't be decompiled
      }
   }

   public static enum Status {
      FINISHED,
      PENDING,
      RUNNING;
   }

   private abstract static class WorkerRunnable implements Callable {
      Object[] params;

      private WorkerRunnable() {
      }

      // $FF: synthetic method
      WorkerRunnable(Object var1) {
         this();
      }
   }
}
