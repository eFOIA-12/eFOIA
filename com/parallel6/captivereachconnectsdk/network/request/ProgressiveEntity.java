package com.parallel6.captivereachconnectsdk.network.request;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class ProgressiveEntity implements HttpEntity {
   private HttpEntity entity;

   public ProgressiveEntity(HttpEntity var1) {
      this.entity = var1;
   }

   public void consumeContent() throws IOException {
      this.entity.consumeContent();
   }

   public InputStream getContent() throws IOException, IllegalStateException {
      return this.entity.getContent();
   }

   public Header getContentEncoding() {
      return this.entity.getContentEncoding();
   }

   public long getContentLength() {
      return this.entity.getContentLength();
   }

   public Header getContentType() {
      return this.entity.getContentType();
   }

   public boolean isChunked() {
      return this.entity.isChunked();
   }

   public boolean isRepeatable() {
      return this.entity.isRepeatable();
   }

   public boolean isStreaming() {
      return this.entity.isStreaming();
   }

   public void writeTo(OutputStream var1) throws IOException {
      this.entity.writeTo(new ProgressiveEntity.ProgressiveOutputStream(var1));
   }

   class ProgressiveOutputStream extends ProgressiveEntity.ProxyOutputStream {
      public ProgressiveOutputStream(OutputStream var2) {
         super();
      }

      public void write(byte[] var1, int var2, int var3) throws IOException {
         this.out.write(var1, var2, var3);
      }
   }

   class ProxyOutputStream extends FilterOutputStream {
      public ProxyOutputStream(OutputStream var2) {
         super(var2);
      }

      public void close() throws IOException {
         this.out.close();
      }

      public void flush() throws IOException {
         this.out.flush();
      }

      public void write(int var1) throws IOException {
         this.out.write(var1);
      }

      public void write(byte[] var1) throws IOException {
         this.out.write(var1);
      }

      public void write(byte[] var1, int var2, int var3) throws IOException {
         this.out.write(var1, var2, var3);
      }
   }
}
