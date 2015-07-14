package org.apache.http.entity.mime;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.AbstractMultipartForm;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpBrowserCompatibleMultipart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.HttpRFC6532Multipart;
import org.apache.http.entity.mime.HttpStrictMultipart;
import org.apache.http.entity.mime.MultipartFormEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.util.Args;

public class MultipartEntityBuilder {
   private static final String DEFAULT_SUBTYPE = "form-data";
   private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
   private List bodyParts;
   private String boundary;
   private Charset charset;
   private HttpMultipartMode mode;
   private String subType = "form-data";

   MultipartEntityBuilder() {
      this.mode = HttpMultipartMode.STRICT;
      this.boundary = null;
      this.charset = null;
      this.bodyParts = null;
   }

   public static MultipartEntityBuilder create() {
      return new MultipartEntityBuilder();
   }

   private String generateBoundary() {
      StringBuilder var3 = new StringBuilder();
      Random var4 = new Random();
      int var2 = var4.nextInt(11);

      for(int var1 = 0; var1 < var2 + 30; ++var1) {
         var3.append(MULTIPART_CHARS[var4.nextInt(MULTIPART_CHARS.length)]);
      }

      return var3.toString();
   }

   private String generateContentType(String var1, Charset var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("multipart/form-data; boundary=");
      var3.append(var1);
      if(var2 != null) {
         var3.append("; charset=");
         var3.append(var2.name());
      }

      return var3.toString();
   }

   public MultipartEntityBuilder addBinaryBody(String var1, File var2) {
      ContentType var4 = ContentType.DEFAULT_BINARY;
      String var3;
      if(var2 != null) {
         var3 = var2.getName();
      } else {
         var3 = null;
      }

      return this.addBinaryBody(var1, var2, var4, var3);
   }

   public MultipartEntityBuilder addBinaryBody(String var1, File var2, ContentType var3, String var4) {
      return this.addPart(var1, new FileBody(var2, var3, var4));
   }

   public MultipartEntityBuilder addBinaryBody(String var1, InputStream var2) {
      return this.addBinaryBody(var1, (InputStream)var2, ContentType.DEFAULT_BINARY, (String)null);
   }

   public MultipartEntityBuilder addBinaryBody(String var1, InputStream var2, ContentType var3, String var4) {
      return this.addPart(var1, new InputStreamBody(var2, var3, var4));
   }

   public MultipartEntityBuilder addBinaryBody(String var1, byte[] var2) {
      return this.addBinaryBody(var1, (byte[])var2, ContentType.DEFAULT_BINARY, (String)null);
   }

   public MultipartEntityBuilder addBinaryBody(String var1, byte[] var2, ContentType var3, String var4) {
      return this.addPart(var1, new ByteArrayBody(var2, var3, var4));
   }

   public MultipartEntityBuilder addPart(String var1, ContentBody var2) {
      Args.notNull(var1, "Name");
      Args.notNull(var2, "Content body");
      return this.addPart(new FormBodyPart(var1, var2));
   }

   MultipartEntityBuilder addPart(FormBodyPart var1) {
      if(var1 == null) {
         return this;
      } else {
         if(this.bodyParts == null) {
            this.bodyParts = new ArrayList();
         }

         this.bodyParts.add(var1);
         return this;
      }
   }

   public MultipartEntityBuilder addTextBody(String var1, String var2) {
      return this.addTextBody(var1, var2, ContentType.DEFAULT_TEXT);
   }

   public MultipartEntityBuilder addTextBody(String var1, String var2, ContentType var3) {
      return this.addPart(var1, new StringBody(var2, var3));
   }

   public HttpEntity build() {
      return this.buildEntity();
   }

   MultipartFormEntity buildEntity() {
      String var1;
      if(this.subType != null) {
         var1 = this.subType;
      } else {
         var1 = "form-data";
      }

      Charset var5 = this.charset;
      String var2;
      if(this.boundary != null) {
         var2 = this.boundary;
      } else {
         var2 = this.generateBoundary();
      }

      Object var3;
      if(this.bodyParts != null) {
         var3 = new ArrayList(this.bodyParts);
      } else {
         var3 = Collections.emptyList();
      }

      HttpMultipartMode var4;
      if(this.mode != null) {
         var4 = this.mode;
      } else {
         var4 = HttpMultipartMode.STRICT;
      }

      Object var6;
      switch(null.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[var4.ordinal()]) {
      case 1:
         var6 = new HttpBrowserCompatibleMultipart(var1, var5, var2, (List)var3);
         break;
      case 2:
         var6 = new HttpRFC6532Multipart(var1, var5, var2, (List)var3);
         break;
      default:
         var6 = new HttpStrictMultipart(var1, var5, var2, (List)var3);
      }

      return new MultipartFormEntity((AbstractMultipartForm)var6, this.generateContentType(var2, var5), ((AbstractMultipartForm)var6).getTotalLength());
   }

   public MultipartEntityBuilder setBoundary(String var1) {
      this.boundary = var1;
      return this;
   }

   public MultipartEntityBuilder setCharset(Charset var1) {
      this.charset = var1;
      return this;
   }

   public MultipartEntityBuilder setLaxMode() {
      this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
      return this;
   }

   public MultipartEntityBuilder setMode(HttpMultipartMode var1) {
      this.mode = var1;
      return this;
   }

   public MultipartEntityBuilder setStrictMode() {
      this.mode = HttpMultipartMode.STRICT;
      return this;
   }
}
