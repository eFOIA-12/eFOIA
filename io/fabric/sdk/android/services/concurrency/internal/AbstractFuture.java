package io.fabric.sdk.android.services.concurrency.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public abstract class AbstractFuture implements Future {
   private final AbstractFuture.Sync sync = new AbstractFuture.Sync();

   static final CancellationException cancellationExceptionWithCause(String var0, Throwable var1) {
      CancellationException var2 = new CancellationException(var0);
      var2.initCause(var1);
      return var2;
   }

   public boolean cancel(boolean var1) {
      if(!this.sync.cancel(var1)) {
         return false;
      } else {
         if(var1) {
            this.interruptTask();
         }

         return true;
      }
   }

   public Object get() throws InterruptedException, ExecutionException {
      return this.sync.get();
   }

   public Object get(long var1, TimeUnit var3) throws InterruptedException, TimeoutException, ExecutionException {
      return this.sync.get(var3.toNanos(var1));
   }

   protected void interruptTask() {
   }

   public boolean isCancelled() {
      return this.sync.isCancelled();
   }

   public boolean isDone() {
      return this.sync.isDone();
   }

   protected boolean set(Object var1) {
      return this.sync.set(var1);
   }

   protected boolean setException(Throwable var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         return this.sync.setException(var1);
      }
   }

   protected final boolean wasInterrupted() {
      return this.sync.wasInterrupted();
   }

   static final class Sync extends AbstractQueuedSynchronizer {
      static final int CANCELLED = 4;
      static final int COMPLETED = 2;
      static final int COMPLETING = 1;
      static final int INTERRUPTED = 8;
      static final int RUNNING = 0;
      private static final long serialVersionUID = 0L;
      private Throwable exception;
      private Object value;

      private boolean complete(Object var1, Throwable var2, int var3) {
         boolean var4 = this.compareAndSetState(0, 1);
         if(var4) {
            this.value = var1;
            if((var3 & 12) != 0) {
               var2 = new CancellationException("Future.cancel() was called.");
            }

            this.exception = (Throwable)var2;
            this.releaseShared(var3);
         } else if(this.getState() == 1) {
            this.acquireShared(-1);
            return var4;
         }

         return var4;
      }

      private Object getValue() throws CancellationException, ExecutionException {
         int var1 = this.getState();
         switch(var1) {
         case 2:
            if(this.exception != null) {
               throw new ExecutionException(this.exception);
            }

            return this.value;
         case 4:
         case 8:
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.exception);
         default:
            throw new IllegalStateException("Error, synchronizer in invalid state: " + var1);
         }
      }

      boolean cancel(boolean var1) {
         byte var2;
         if(var1) {
            var2 = 8;
         } else {
            var2 = 4;
         }

         return this.complete((Object)null, (Throwable)null, var2);
      }

      Object get() throws CancellationException, ExecutionException, InterruptedException {
         this.acquireSharedInterruptibly(-1);
         return this.getValue();
      }

      Object get(long var1) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
         if(!this.tryAcquireSharedNanos(-1, var1)) {
            throw new TimeoutException("Timeout waiting for task.");
         } else {
            return this.getValue();
         }
      }

      boolean isCancelled() {
         return (this.getState() & 12) != 0;
      }

      boolean isDone() {
         return (this.getState() & 14) != 0;
      }

      boolean set(Object var1) {
         return this.complete(var1, (Throwable)null, 2);
      }

      boolean setException(Throwable var1) {
         return this.complete((Object)null, var1, 2);
      }

      protected int tryAcquireShared(int var1) {
         return this.isDone()?1:-1;
      }

      protected boolean tryReleaseShared(int var1) {
         this.setState(var1);
         return true;
      }

      boolean wasInterrupted() {
         return this.getState() == 8;
      }
   }
}
