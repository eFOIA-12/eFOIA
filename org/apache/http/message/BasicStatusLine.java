package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicStatusLine implements StatusLine, Cloneable, Serializable {
   private static final long serialVersionUID = -2443303766890459269L;
   private final ProtocolVersion protoVersion;
   private final String reasonPhrase;
   private final int statusCode;

   public BasicStatusLine(ProtocolVersion var1, int var2, String var3) {
      this.protoVersion = (ProtocolVersion)Args.notNull(var1, "Version");
      this.statusCode = Args.notNegative(var2, "Status code");
      this.reasonPhrase = var3;
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public ProtocolVersion getProtocolVersion() {
      return this.protoVersion;
   }

   public String getReasonPhrase() {
      return this.reasonPhrase;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String toString() {
      return BasicLineFormatter.INSTANCE.formatStatusLine((CharArrayBuffer)null, (StatusLine)this).toString();
   }
}
