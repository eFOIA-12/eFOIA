package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.apache.http.entity.mime.AbstractMultipartForm;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MinimalField;

class HttpRFC6532Multipart extends AbstractMultipartForm {
   private final List parts;

   public HttpRFC6532Multipart(String var1, Charset var2, String var3, List var4) {
      super(var1, var2, var3);
      this.parts = var4;
   }

   protected void formatMultipartHeader(FormBodyPart var1, OutputStream var2) throws IOException {
      Iterator var3 = var1.getHeader().iterator();

      while(var3.hasNext()) {
         writeField((MinimalField)var3.next(), MIME.UTF8_CHARSET, var2);
      }

   }

   public List getBodyParts() {
      return this.parts;
   }
}
