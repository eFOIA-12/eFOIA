package org.apache.http;

import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

public interface Header {
   HeaderElement[] getElements() throws ParseException;

   String getName();

   String getValue();
}
