package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

public interface ContentProducer {
   void writeTo(OutputStream var1) throws IOException;
}
