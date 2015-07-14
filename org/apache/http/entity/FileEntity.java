package org.apache.http.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

@NotThreadSafe
public class FileEntity extends AbstractHttpEntity implements Cloneable {
   protected final File file;

   public FileEntity(File var1) {
      this.file = (File)Args.notNull(var1, "File");
   }

   @Deprecated
   public FileEntity(File var1, String var2) {
      this.file = (File)Args.notNull(var1, "File");
      this.setContentType(var2);
   }

   public FileEntity(File var1, ContentType var2) {
      this.file = (File)Args.notNull(var1, "File");
      if(var2 != null) {
         this.setContentType(var2.toString());
      }

   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public InputStream getContent() throws IOException {
      return new FileInputStream(this.file);
   }

   public long getContentLength() {
      return this.file.length();
   }

   public boolean isRepeatable() {
      return true;
   }

   public boolean isStreaming() {
      return false;
   }

   public void writeTo(OutputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
