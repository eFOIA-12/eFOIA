package org.apache.http.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.concurrent.FutureCallback;

public class BasicFuture implements Future, Cancellable {
   private final FutureCallback callback;
   private volatile boolean cancelled;
   private volatile boolean completed;
   private volatile Exception ex;
   private volatile Object result;

   public BasicFuture(FutureCallback var1) {
      this.callback = var1;
   }

   private Object getResult() throws ExecutionException {
      if(this.ex != null) {
         throw new ExecutionException(this.ex);
      } else {
         return this.result;
      }
   }

   public boolean cancel() {
      return this.cancel(true);
   }

   public boolean cancel(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean completed(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean failed(Exception param1) {
      // $FF: Couldn't be decompiled
   }

   public Object get() throws InterruptedException, ExecutionException {
      synchronized(this){}

      while(true) {
         boolean var3 = false;

         try {
            var3 = true;
            if(this.completed) {
               Object var1 = this.getResult();
               var3 = false;
               return var1;
            }

            this.wait();
            var3 = false;
         } finally {
            if(var3) {
               ;
            }
         }
      }
   }

   public Object get(long param1, TimeUnit param3) throws InterruptedException, ExecutionException, TimeoutException {
      // $FF: Couldn't be decompiled
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public boolean isDone() {
      return this.completed;
   }
}
