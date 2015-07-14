package org.apache.http.entity.mime.content;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.util.Args;

public class InputStreamBody extends AbstractContentBody {
   private final String filename;
   private final InputStream in;

   public InputStreamBody(InputStream var1, String var2) {
      this(var1, ContentType.DEFAULT_BINARY, var2);
   }

   @Deprecated
   public InputStreamBody(InputStream var1, String var2, String var3) {
      this(var1, ContentType.create(var2), var3);
   }

   public InputStreamBody(InputStream var1, ContentType var2) {
      this(var1, (ContentType)var2, (String)null);
   }

   public InputStreamBody(InputStream var1, ContentType var2, String var3) {
      super(var2);
      Args.notNull(var1, "Input stream");
      this.in = var1;
      this.filename = var3;
   }

   public long getContentLength() {
      return -1L;
   }

   public String getFilename() {
      return this.filename;
   }

   public InputStream getInputStream() {
      return this.in;
   }

   public String getTransferEncoding() {
      return "binary";
   }

   public void writeTo(OutputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
