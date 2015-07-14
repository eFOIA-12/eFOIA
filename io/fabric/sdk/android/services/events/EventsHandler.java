package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStorageListener;
import io.fabric.sdk.android.services.events.EventsStrategy;
import java.util.concurrent.ScheduledExecutorService;

public abstract class EventsHandler implements EventsStorageListener {
   protected final Context context;
   protected final ScheduledExecutorService executor;
   protected EventsStrategy strategy;

   public EventsHandler(Context var1, EventsStrategy var2, EventsFilesManager var3, ScheduledExecutorService var4) {
      this.context = var1.getApplicationContext();
      this.executor = var4;
      this.strategy = var2;
      var3.registerRollOverListener(this);
   }

   public void disable() {
      this.executeAsync(new Runnable() {
         public void run() {
            try {
               EventsStrategy var1 = EventsHandler.this.strategy;
               EventsHandler.this.strategy = EventsHandler.this.getDisabledEventsStrategy();
               var1.deleteAllEvents();
            } catch (Exception var2) {
               CommonUtils.logControlledError(EventsHandler.this.context, "Failed to disable events.", var2);
            }
         }
      });
   }

   protected void executeAsync(Runnable var1) {
      try {
         this.executor.submit(var1);
      } catch (Exception var2) {
         CommonUtils.logControlledError(this.context, "Failed to submit events task", var2);
      }
   }

   protected void executeSync(Runnable var1) {
      try {
         this.executor.submit(var1).get();
      } catch (Exception var2) {
         CommonUtils.logControlledError(this.context, "Failed to run events task", var2);
      }
   }

   protected abstract EventsStrategy getDisabledEventsStrategy();

   public void onRollOver(String var1) {
      this.executeAsync(new Runnable() {
         public void run() {
            try {
               EventsHandler.this.strategy.sendEvents();
            } catch (Exception var2) {
               CommonUtils.logControlledError(EventsHandler.this.context, "Failed to send events files.", var2);
            }
         }
      });
   }

   public void recordEventAsync(final Object var1, final boolean var2) {
      this.executeAsync(new Runnable() {
         public void run() {
            try {
               EventsHandler.this.strategy.recordEvent(var1);
               if(var2) {
                  EventsHandler.this.strategy.rollFileOver();
               }

            } catch (Exception var2x) {
               CommonUtils.logControlledError(EventsHandler.this.context, "Failed to record event.", var2x);
            }
         }
      });
   }

   public void recordEventSync(final Object var1) {
      this.executeSync(new Runnable() {
         public void run() {
            try {
               EventsHandler.this.strategy.recordEvent(var1);
            } catch (Exception var2) {
               CommonUtils.logControlledError(EventsHandler.this.context, "Crashlytics failed to record event", var2);
            }
         }
      });
   }
}
