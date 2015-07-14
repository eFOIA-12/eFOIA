package io.fabric.sdk.android.services.cache;

import android.content.Context;
import io.fabric.sdk.android.services.cache.ValueLoader;

public interface ValueCache {
   Object get(Context var1, ValueLoader var2) throws Exception;

   void invalidate(Context var1);
}
