package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

@NotThreadSafe
public class InputStreamEntity extends AbstractHttpEntity {
   private final InputStream content;
   private final long length;

   public InputStreamEntity(InputStream var1) {
      this(var1, -1L);
   }

   public InputStreamEntity(InputStream var1, long var2) {
      this(var1, var2, (ContentType)null);
   }

   public InputStreamEntity(InputStream var1, long var2, ContentType var4) {
      this.content = (InputStream)Args.notNull(var1, "Source input stream");
      this.length = var2;
      if(var4 != null) {
         this.setContentType(var4.toString());
      }

   }

   public InputStreamEntity(InputStream var1, ContentType var2) {
      this(var1, -1L, var2);
   }

   public InputStream getContent() throws IOException {
      return this.content;
   }

   public long getContentLength() {
      return this.length;
   }

   public boolean isRepeatable() {
      return false;
   }

   public boolean isStreaming() {
      return true;
   }

   public void writeTo(OutputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
