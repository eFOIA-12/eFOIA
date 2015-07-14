package org.apache.http.message;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
   private int code;
   private HttpEntity entity;
   private Locale locale;
   private final ReasonPhraseCatalog reasonCatalog;
   private String reasonPhrase;
   private StatusLine statusline;
   private ProtocolVersion ver;

   public BasicHttpResponse(ProtocolVersion var1, int var2, String var3) {
      Args.notNegative(var2, "Status code");
      this.statusline = null;
      this.ver = var1;
      this.code = var2;
      this.reasonPhrase = var3;
      this.reasonCatalog = null;
      this.locale = null;
   }

   public BasicHttpResponse(StatusLine var1) {
      this.statusline = (StatusLine)Args.notNull(var1, "Status line");
      this.ver = var1.getProtocolVersion();
      this.code = var1.getStatusCode();
      this.reasonPhrase = var1.getReasonPhrase();
      this.reasonCatalog = null;
      this.locale = null;
   }

   public BasicHttpResponse(StatusLine var1, ReasonPhraseCatalog var2, Locale var3) {
      this.statusline = (StatusLine)Args.notNull(var1, "Status line");
      this.ver = var1.getProtocolVersion();
      this.code = var1.getStatusCode();
      this.reasonPhrase = var1.getReasonPhrase();
      this.reasonCatalog = var2;
      this.locale = var3;
   }

   public HttpEntity getEntity() {
      return this.entity;
   }

   public Locale getLocale() {
      return this.locale;
   }

   public ProtocolVersion getProtocolVersion() {
      return this.ver;
   }

   protected String getReason(int var1) {
      if(this.reasonCatalog != null) {
         ReasonPhraseCatalog var3 = this.reasonCatalog;
         Locale var2;
         if(this.locale != null) {
            var2 = this.locale;
         } else {
            var2 = Locale.getDefault();
         }

         return var3.getReason(var1, var2);
      } else {
         return null;
      }
   }

   public StatusLine getStatusLine() {
      if(this.statusline == null) {
         Object var2;
         if(this.ver != null) {
            var2 = this.ver;
         } else {
            var2 = HttpVersion.HTTP_1_1;
         }

         int var1 = this.code;
         String var3;
         if(this.reasonPhrase != null) {
            var3 = this.reasonPhrase;
         } else {
            var3 = this.getReason(this.code);
         }

         this.statusline = new BasicStatusLine((ProtocolVersion)var2, var1, var3);
      }

      return this.statusline;
   }

   public void setEntity(HttpEntity var1) {
      this.entity = var1;
   }

   public void setLocale(Locale var1) {
      this.locale = (Locale)Args.notNull(var1, "Locale");
      this.statusline = null;
   }

   public void setReasonPhrase(String var1) {
      this.statusline = null;
      this.reasonPhrase = var1;
   }

   public void setStatusCode(int var1) {
      Args.notNegative(var1, "Status code");
      this.statusline = null;
      this.code = var1;
      this.reasonPhrase = null;
   }

   public void setStatusLine(ProtocolVersion var1, int var2) {
      Args.notNegative(var2, "Status code");
      this.statusline = null;
      this.ver = var1;
      this.code = var2;
      this.reasonPhrase = null;
   }

   public void setStatusLine(ProtocolVersion var1, int var2, String var3) {
      Args.notNegative(var2, "Status code");
      this.statusline = null;
      this.ver = var1;
      this.code = var2;
      this.reasonPhrase = var3;
   }

   public void setStatusLine(StatusLine var1) {
      this.statusline = (StatusLine)Args.notNull(var1, "Status line");
      this.ver = var1.getProtocolVersion();
      this.code = var1.getStatusCode();
      this.reasonPhrase = var1.getReasonPhrase();
   }

   public String toString() {
      return this.getStatusLine() + " " + this.headergroup;
   }
}
