package org.apache.http;

import org.apache.http.NameValuePair;

public interface HeaderElement {
   String getName();

   NameValuePair getParameter(int var1);

   NameValuePair getParameterByName(String var1);

   int getParameterCount();

   NameValuePair[] getParameters();

   String getValue();
}
