package com.parallel6.captivereachconnectsdk.utils;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.utils.Utils;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask {
   private static final int CORE_POOL_SIZE = 10;
   public static final Executor DUAL_THREAD_EXECUTOR;
   private static final int KEEP_ALIVE = 1;
   private static final String LOG_TAG = "AsyncTask";
   private static final int MAXIMUM_POOL_SIZE = 128;
   private static final int MESSAGE_POST_PROGRESS = 2;
   private static final int MESSAGE_POST_RESULT = 1;
   public static final Executor SERIAL_EXECUTOR;
   public static final Executor THREAD_POOL_EXECUTOR;
   private static volatile Executor sDefaultExecutor;
   private static final AsyncTask.InternalHandler sHandler;
   private static final BlockingQueue sPoolWorkQueue = new LinkedBlockingQueue(10);
   private static final ThreadFactory sThreadFactory = new ThreadFactory() {
      private final AtomicInteger mCount = new AtomicInteger(1);

      public Thread newThread(Runnable var1) {
         return new Thread(var1, "AsyncTask #" + this.mCount.getAndIncrement());
      }
   };
   private final AtomicBoolean mCancelled;
   private final FutureTask mFuture;
   private volatile AsyncTask.Status mStatus;
   private final AtomicBoolean mTaskInvoked;
   private final AsyncTask.WorkerRunnable mWorker;

   static {
      THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(10, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new DiscardOldestPolicy());
      Object var0;
      if(Utils.hasHoneycomb()) {
         var0 = new AsyncTask.SerialExecutor(null);
      } else {
         var0 = Executors.newSingleThreadExecutor(sThreadFactory);
      }

      SERIAL_EXECUTOR = (Executor)var0;
      DUAL_THREAD_EXECUTOR = Executors.newFixedThreadPool(2, sThreadFactory);
      sHandler = new AsyncTask.InternalHandler(null);
      sDefaultExecutor = SERIAL_EXECUTOR;
   }

   public AsyncTask() {
      this.mStatus = AsyncTask.Status.PENDING;
      this.mCancelled = new AtomicBoolean();
      this.mTaskInvoked = new AtomicBoolean();
      this.mWorker = new AsyncTask.WorkerRunnable(null) {
         public Object call() throws Exception {
            AsyncTask.this.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return AsyncTask.this.postResult(AsyncTask.this.doInBackground(this.mParams));
         }
      };
      this.mFuture = new FutureTask(this.mWorker) {
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
      sDefaultExecutor.execute(var0);
   }

   private void finish(Object var1) {
      if(this.isCancelled()) {
         this.onCancelled(var1);
      } else {
         this.onPostExecute(var1);
      }

      this.mStatus = AsyncTask.Status.FINISHED;
   }

   public static void init() {
      sHandler.getLooper();
   }

   private Object postResult(Object var1) {
      sHandler.obtainMessage(1, new AsyncTask.AsyncTaskResult(this, new Object[]{var1})).sendToTarget();
      return var1;
   }

   private void postResultIfNotInvoked(Object var1) {
      if(!this.mTaskInvoked.get()) {
         this.postResult(var1);
      }

   }

   public static void setDefaultExecutor(Executor var0) {
      sDefaultExecutor = var0;
   }

   public final boolean cancel(boolean var1) {
      this.mCancelled.set(true);
      return this.mFuture.cancel(var1);
   }

   protected abstract Object doInBackground(Object... var1);

   public final AsyncTask execute(Object... var1) {
      return this.executeOnExecutor(sDefaultExecutor, var1);
   }

   public final AsyncTask executeOnExecutor(Executor var1, Object... var2) {
      if(this.mStatus != AsyncTask.Status.PENDING) {
         switch(null.$SwitchMap$com$parallel6$captivereachconnectsdk$utils$AsyncTask$Status[this.mStatus.ordinal()]) {
         case 1:
            throw new IllegalStateException("Cannot execute task: the task is already running.");
         case 2:
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
         }
      }

      this.mStatus = AsyncTask.Status.RUNNING;
      this.onPreExecute();
      this.mWorker.mParams = var2;
      var1.execute(this.mFuture);
      return this;
   }

   public final Object get() throws InterruptedException, ExecutionException {
      return this.mFuture.get();
   }

   public final Object get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException {
      return this.mFuture.get(var1, var3);
   }

   public final AsyncTask.Status getStatus() {
      return this.mStatus;
   }

   public final boolean isCancelled() {
      return this.mCancelled.get();
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
         sHandler.obtainMessage(2, new AsyncTask.AsyncTaskResult(this, var1)).sendToTarget();
      }

   }

   private static class AsyncTaskResult {
      final Object[] mData;
      final AsyncTask mTask;

      AsyncTaskResult(AsyncTask var1, Object... var2) {
         this.mTask = var1;
         this.mData = var2;
      }
   }

   private static class InternalHandler extends Handler {
      private InternalHandler() {
      }

      // $FF: synthetic method
      InternalHandler(Object var1) {
         this();
      }

      public void handleMessage(Message var1) {
         AsyncTask.AsyncTaskResult var2 = (AsyncTask.AsyncTaskResult)var1.obj;
         switch(var1.what) {
         case 1:
            var2.mTask.finish(var2.mData[0]);
            return;
         case 2:
            var2.mTask.onProgressUpdate(var2.mData);
            return;
         default:
         }
      }
   }

   @TargetApi(11)
   private static class SerialExecutor implements Executor {
      Runnable mActive;
      final ArrayDeque mTasks;

      private SerialExecutor() {
         this.mTasks = new ArrayDeque();
      }

      // $FF: synthetic method
      SerialExecutor(Object var1) {
         this();
      }

      public void execute(final Runnable var1) {
         synchronized(this){}

         try {
            this.mTasks.offer(new Runnable() {
               public void run() {
                  try {
                     var1.run();
                  } finally {
                     SerialExecutor.this.scheduleNext();
                  }

               }
            });
            if(this.mActive == null) {
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
      Object[] mParams;

      private WorkerRunnable() {
      }

      // $FF: synthetic method
      WorkerRunnable(Object var1) {
         this();
      }
   }
}
