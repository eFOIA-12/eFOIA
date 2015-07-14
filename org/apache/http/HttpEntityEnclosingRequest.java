package org.apache.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;

public interface HttpEntityEnclosingRequest extends HttpRequest {
   boolean expectContinue();

   HttpEntity getEntity();

   void setEntity(HttpEntity var1);
}
