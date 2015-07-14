package org.apache.http.pool;

import org.apache.http.pool.PoolStats;

public interface ConnPoolControl {
   int getDefaultMaxPerRoute();

   int getMaxPerRoute(Object var1);

   int getMaxTotal();

   PoolStats getStats(Object var1);

   PoolStats getTotalStats();

   void setDefaultMaxPerRoute(int var1);

   void setMaxPerRoute(Object var1, int var2);

   void setMaxTotal(int var1);
}
