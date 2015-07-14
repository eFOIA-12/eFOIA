package org.apache.http.entity.mime.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.util.Args;

public class FileBody extends AbstractContentBody {
   private final File file;
   private final String filename;

   public FileBody(File var1) {
      ContentType var3 = ContentType.DEFAULT_BINARY;
      String var2;
      if(var1 != null) {
         var2 = var1.getName();
      } else {
         var2 = null;
      }

      this(var1, var3, var2);
   }

   @Deprecated
   public FileBody(File var1, String var2) {
      this(var1, (ContentType)ContentType.create(var2), (String)null);
   }

   @Deprecated
   public FileBody(File var1, String var2, String var3) {
      this(var1, (String)null, var2, var3);
   }

   @Deprecated
   public FileBody(File var1, String var2, String var3, String var4) {
      this(var1, ContentType.create(var3, var4), var2);
   }

   public FileBody(File var1, ContentType var2) {
      this(var1, (ContentType)var2, (String)null);
   }

   public FileBody(File var1, ContentType var2, String var3) {
      super(var2);
      Args.notNull(var1, "File");
      this.file = var1;
      this.filename = var3;
   }

   public long getContentLength() {
      return this.file.length();
   }

   public File getFile() {
      return this.file;
   }

   public String getFilename() {
      return this.filename;
   }

   public InputStream getInputStream() throws IOException {
      return new FileInputStream(this.file);
   }

   public String getTransferEncoding() {
      return "binary";
   }

   public void writeTo(OutputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
