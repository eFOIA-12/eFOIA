package com.google.android.gms.games.internal.events;

import com.google.android.gms.games.internal.events.EventIncrementCache;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
   private final AtomicReference acq = new AtomicReference();

   public void flush() {
      EventIncrementCache var1 = (EventIncrementCache)this.acq.get();
      if(var1 != null) {
         var1.flush();
      }

   }

   protected abstract EventIncrementCache lF();

   public void o(String var1, int var2) {
      EventIncrementCache var4 = (EventIncrementCache)this.acq.get();
      EventIncrementCache var3 = var4;
      if(var4 == null) {
         var4 = this.lF();
         var3 = var4;
         if(!this.acq.compareAndSet((Object)null, var4)) {
            var3 = (EventIncrementCache)this.acq.get();
         }
      }

      var3.y(var1, var2);
   }
}
