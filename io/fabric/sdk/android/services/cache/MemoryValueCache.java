package io.fabric.sdk.android.services.cache;

import android.content.Context;
import io.fabric.sdk.android.services.cache.AbstractValueCache;
import io.fabric.sdk.android.services.cache.ValueCache;

public class MemoryValueCache extends AbstractValueCache {
   private Object value;

   public MemoryValueCache() {
      this((ValueCache)null);
   }

   public MemoryValueCache(ValueCache var1) {
      super(var1);
   }

   protected void cacheValue(Context var1, Object var2) {
      this.value = var2;
   }

   protected void doInvalidate(Context var1) {
      this.value = null;
   }

   protected Object getCached(Context var1) {
      return this.value;
   }
}
