package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.AbstractMultipartForm;
import org.apache.http.message.BasicHeader;

class MultipartFormEntity implements HttpEntity {
   private final long contentLength;
   private final org.apache.http.Header contentType;
   private final AbstractMultipartForm multipart;

   MultipartFormEntity(AbstractMultipartForm var1, String var2, long var3) {
      this.multipart = var1;
      this.contentType = new BasicHeader("Content-Type", var2);
      this.contentLength = var3;
   }

   public void consumeContent() throws IOException, UnsupportedOperationException {
      if(this.isStreaming()) {
         throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
      }
   }

   public InputStream getContent() throws IOException {
      throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
   }

   public org.apache.http.Header getContentEncoding() {
      return null;
   }

   public long getContentLength() {
      return this.contentLength;
   }

   public org.apache.http.Header getContentType() {
      return this.contentType;
   }

   AbstractMultipartForm getMultipart() {
      return this.multipart;
   }

   public boolean isChunked() {
      return !this.isRepeatable();
   }

   public boolean isRepeatable() {
      return this.contentLength != -1L;
   }

   public boolean isStreaming() {
      return !this.isRepeatable();
   }

   public void writeTo(OutputStream var1) throws IOException {
      this.multipart.writeTo(var1);
   }
}
