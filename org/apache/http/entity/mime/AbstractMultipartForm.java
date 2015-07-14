package org.apache.http.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MinimalField;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;

abstract class AbstractMultipartForm {
   private static final ByteArrayBuffer CR_LF;
   private static final ByteArrayBuffer FIELD_SEP;
   private static final ByteArrayBuffer TWO_DASHES;
   private final String boundary;
   protected final Charset charset;
   private final String subType;

   static {
      FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
      CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
      TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
   }

   public AbstractMultipartForm(String var1, String var2) {
      this(var1, (Charset)null, var2);
   }

   public AbstractMultipartForm(String var1, Charset var2, String var3) {
      Args.notNull(var1, "Multipart subtype");
      Args.notNull(var3, "Multipart boundary");
      this.subType = var1;
      if(var2 == null) {
         var2 = MIME.DEFAULT_CHARSET;
      }

      this.charset = var2;
      this.boundary = var3;
   }

   private static ByteArrayBuffer encode(Charset var0, String var1) {
      ByteBuffer var2 = var0.encode(CharBuffer.wrap(var1));
      ByteArrayBuffer var3 = new ByteArrayBuffer(var2.remaining());
      var3.append(var2.array(), var2.position(), var2.remaining());
      return var3;
   }

   private static void writeBytes(String var0, OutputStream var1) throws IOException {
      writeBytes(encode(MIME.DEFAULT_CHARSET, var0), var1);
   }

   private static void writeBytes(String var0, Charset var1, OutputStream var2) throws IOException {
      writeBytes(encode(var1, var0), var2);
   }

   private static void writeBytes(ByteArrayBuffer var0, OutputStream var1) throws IOException {
      var1.write(var0.buffer(), 0, var0.length());
   }

   protected static void writeField(MinimalField var0, OutputStream var1) throws IOException {
      writeBytes(var0.getName(), var1);
      writeBytes(FIELD_SEP, var1);
      writeBytes(var0.getBody(), var1);
      writeBytes(CR_LF, var1);
   }

   protected static void writeField(MinimalField var0, Charset var1, OutputStream var2) throws IOException {
      writeBytes(var0.getName(), var1, var2);
      writeBytes(FIELD_SEP, var2);
      writeBytes(var0.getBody(), var1, var2);
      writeBytes(CR_LF, var2);
   }

   void doWriteTo(OutputStream var1, boolean var2) throws IOException {
      ByteArrayBuffer var3 = encode(this.charset, this.getBoundary());

      for(Iterator var4 = this.getBodyParts().iterator(); var4.hasNext(); writeBytes(CR_LF, var1)) {
         FormBodyPart var5 = (FormBodyPart)var4.next();
         writeBytes(TWO_DASHES, var1);
         writeBytes(var3, var1);
         writeBytes(CR_LF, var1);
         this.formatMultipartHeader(var5, var1);
         writeBytes(CR_LF, var1);
         if(var2) {
            var5.getBody().writeTo(var1);
         }
      }

      writeBytes(TWO_DASHES, var1);
      writeBytes(var3, var1);
      writeBytes(TWO_DASHES, var1);
      writeBytes(CR_LF, var1);
   }

   protected abstract void formatMultipartHeader(FormBodyPart var1, OutputStream var2) throws IOException;

   public abstract List getBodyParts();

   public String getBoundary() {
      return this.boundary;
   }

   public Charset getCharset() {
      return this.charset;
   }

   public String getSubType() {
      return this.subType;
   }

   public long getTotalLength() {
      long var6 = -1L;
      long var2 = 0L;
      Iterator var10 = this.getBodyParts().iterator();

      long var4;
      while(true) {
         if(!var10.hasNext()) {
            ByteArrayOutputStream var12 = new ByteArrayOutputStream();

            int var1;
            try {
               this.doWriteTo(var12, false);
               var1 = var12.toByteArray().length;
            } catch (IOException var11) {
               return -1L;
            }

            var4 = (long)var1 + var2;
            break;
         }

         long var8 = ((FormBodyPart)var10.next()).getBody().getContentLength();
         var4 = var6;
         if(var8 < 0L) {
            break;
         }

         var2 += var8;
      }

      return var4;
   }

   public void writeTo(OutputStream var1) throws IOException {
      this.doWriteTo(var1, true);
   }
}
