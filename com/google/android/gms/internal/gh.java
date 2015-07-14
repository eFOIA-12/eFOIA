package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gr;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@ey
public final class gh {
   private static final ThreadFactory ww = new ThreadFactory() {
      private final AtomicInteger wA = new AtomicInteger(1);

      public Thread newThread(Runnable var1) {
         return new Thread(var1, "AdWorker #" + this.wA.getAndIncrement());
      }
   };
   private static final ExecutorService wx;

   static {
      wx = Executors.newFixedThreadPool(10, ww);
   }

   public static Future a(final Runnable var0) {
      return submit(new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.ds();
         }

         public Void ds() {
            var0.run();
            return null;
         }
      });
   }

   public static Future submit(final Callable var0) {
      try {
         Future var2 = wx.submit(new Callable() {
            public Object call() throws Exception {
               try {
                  Process.setThreadPriority(10);
                  Object var1 = var0.call();
                  return var1;
               } catch (Exception var2) {
                  ga.e(var2);
                  return null;
               }
            }
         });
         return var2;
      } catch (RejectedExecutionException var1) {
         gr.d("Thread execution is rejected.", var1);
         return new gk((Object)null);
      }
   }
}
