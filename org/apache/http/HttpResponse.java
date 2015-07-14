package org.apache.http;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public interface HttpResponse extends HttpMessage {
   HttpEntity getEntity();

   Locale getLocale();

   StatusLine getStatusLine();

   void setEntity(HttpEntity var1);

   void setLocale(Locale var1);

   void setReasonPhrase(String var1) throws IllegalStateException;

   void setStatusCode(int var1) throws IllegalStateException;

   void setStatusLine(ProtocolVersion var1, int var2);

   void setStatusLine(ProtocolVersion var1, int var2, String var3);

   void setStatusLine(StatusLine var1);
}
