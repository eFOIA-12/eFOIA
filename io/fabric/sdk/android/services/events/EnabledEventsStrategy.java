package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStrategy;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EnabledEventsStrategy implements EventsStrategy {
   static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
   protected final Context context;
   final ScheduledExecutorService executorService;
   protected final EventsFilesManager filesManager;
   volatile int rolloverIntervalSeconds = -1;
   final AtomicReference scheduledRolloverFutureRef;

   public EnabledEventsStrategy(Context var1, ScheduledExecutorService var2, EventsFilesManager var3) {
      this.context = var1;
      this.executorService = var2;
      this.filesManager = var3;
      this.scheduledRolloverFutureRef = new AtomicReference();
   }

   public void cancelTimeBasedFileRollOver() {
      if(this.scheduledRolloverFutureRef.get() != null) {
         CommonUtils.logControlled(this.context, "Cancelling time-based rollover because no events are currently being generated.");
         ((ScheduledFuture)this.scheduledRolloverFutureRef.get()).cancel(false);
         this.scheduledRolloverFutureRef.set((Object)null);
      }

   }

   protected void configureRollover(int var1) {
      this.rolloverIntervalSeconds = var1;
      this.scheduleTimeBasedFileRollOver(0L, (long)this.rolloverIntervalSeconds);
   }

   public void deleteAllEvents() {
      this.filesManager.deleteAllEventsFiles();
   }

   public void recordEvent(Object var1) {
      CommonUtils.logControlled(this.context, var1.toString());

      try {
         this.filesManager.writeEvent(var1);
      } catch (IOException var2) {
         CommonUtils.logControlledError(this.context, "Failed to write event.", var2);
      }

      this.scheduleTimeBasedRollOverIfNeeded();
   }

   public boolean rollFileOver() {
      try {
         boolean var1 = this.filesManager.rollFileOver();
         return var1;
      } catch (IOException var3) {
         CommonUtils.logControlledError(this.context, "Failed to roll file over.", var3);
         return false;
      }
   }

   void scheduleTimeBasedFileRollOver(long var1, long var3) {
      boolean var5;
      if(this.scheduledRolloverFutureRef.get() == null) {
         var5 = true;
      } else {
         var5 = false;
      }

      if(var5) {
         TimeBasedFileRollOverRunnable var6 = new TimeBasedFileRollOverRunnable(this.context, this);
         CommonUtils.logControlled(this.context, "Scheduling time based file roll over every " + var3 + " seconds");

         try {
            this.scheduledRolloverFutureRef.set(this.executorService.scheduleAtFixedRate(var6, var1, var3, TimeUnit.SECONDS));
         } catch (RejectedExecutionException var7) {
            CommonUtils.logControlledError(this.context, "Failed to schedule time based file roll over", var7);
            return;
         }
      }

   }

   public void scheduleTimeBasedRollOverIfNeeded() {
      boolean var1;
      if(this.rolloverIntervalSeconds != -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(var1) {
         this.scheduleTimeBasedFileRollOver((long)this.rolloverIntervalSeconds, (long)this.rolloverIntervalSeconds);
      }

   }

   void sendAndCleanUpIfSuccess() {
      // $FF: Couldn't be decompiled
   }

   public void sendEvents() {
      this.sendAndCleanUpIfSuccess();
   }
}
