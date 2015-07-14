package org.apache.http.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpTransportMetrics;

@NotThreadSafe
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
   public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
   public static final String REQUEST_COUNT = "http.request-count";
   public static final String RESPONSE_COUNT = "http.response-count";
   public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
   private final HttpTransportMetrics inTransportMetric;
   private Map metricsCache;
   private final HttpTransportMetrics outTransportMetric;
   private long requestCount = 0L;
   private long responseCount = 0L;

   public HttpConnectionMetricsImpl(HttpTransportMetrics var1, HttpTransportMetrics var2) {
      this.inTransportMetric = var1;
      this.outTransportMetric = var2;
   }

   public Object getMetric(String var1) {
      Object var2 = null;
      if(this.metricsCache != null) {
         var2 = this.metricsCache.get(var1);
      }

      Object var3 = var2;
      if(var2 == null) {
         if("http.request-count".equals(var1)) {
            var3 = Long.valueOf(this.requestCount);
         } else {
            if("http.response-count".equals(var1)) {
               return Long.valueOf(this.responseCount);
            }

            if("http.received-bytes-count".equals(var1)) {
               if(this.inTransportMetric != null) {
                  return Long.valueOf(this.inTransportMetric.getBytesTransferred());
               }

               return null;
            }

            var3 = var2;
            if("http.sent-bytes-count".equals(var1)) {
               if(this.outTransportMetric != null) {
                  return Long.valueOf(this.outTransportMetric.getBytesTransferred());
               }

               return null;
            }
         }
      }

      return var3;
   }

   public long getReceivedBytesCount() {
      return this.inTransportMetric != null?this.inTransportMetric.getBytesTransferred():-1L;
   }

   public long getRequestCount() {
      return this.requestCount;
   }

   public long getResponseCount() {
      return this.responseCount;
   }

   public long getSentBytesCount() {
      return this.outTransportMetric != null?this.outTransportMetric.getBytesTransferred():-1L;
   }

   public void incrementRequestCount() {
      ++this.requestCount;
   }

   public void incrementResponseCount() {
      ++this.responseCount;
   }

   public void reset() {
      if(this.outTransportMetric != null) {
         this.outTransportMetric.reset();
      }

      if(this.inTransportMetric != null) {
         this.inTransportMetric.reset();
      }

      this.requestCount = 0L;
      this.responseCount = 0L;
      this.metricsCache = null;
   }

   public void setMetric(String var1, Object var2) {
      if(this.metricsCache == null) {
         this.metricsCache = new HashMap();
      }

      this.metricsCache.put(var1, var2);
   }
}
