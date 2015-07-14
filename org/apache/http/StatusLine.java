package org.apache.http;

import org.apache.http.ProtocolVersion;

public interface StatusLine {
   ProtocolVersion getProtocolVersion();

   String getReasonPhrase();

   int getStatusCode();
}
