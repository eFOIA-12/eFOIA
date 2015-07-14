package io.fabric.sdk.android.services.cache;

import android.content.Context;
import io.fabric.sdk.android.services.cache.ValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

public abstract class AbstractValueCache implements ValueCache {
   private final ValueCache childCache;

   public AbstractValueCache() {
      this((ValueCache)null);
   }

   public AbstractValueCache(ValueCache var1) {
      this.childCache = var1;
   }

   private void cache(Context var1, Object var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.cacheValue(var1, var2);
      }
   }

   protected abstract void cacheValue(Context var1, Object var2);

   protected abstract void doInvalidate(Context var1);

   public final Object get(Context param1, ValueLoader param2) throws Exception {
      // $FF: Couldn't be decompiled
   }

   protected abstract Object getCached(Context var1);

   public final void invalidate(Context var1) {
      synchronized(this){}

      try {
         this.doInvalidate(var1);
      } finally {
         ;
      }

   }
}
