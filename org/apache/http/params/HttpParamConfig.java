package org.apache.http.params;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.SocketConfig;
import org.apache.http.params.HttpParams;

@Deprecated
public final class HttpParamConfig {
   public static ConnectionConfig getConnectionConfig(HttpParams var0) {
      MessageConstraints var2 = getMessageConstraints(var0);
      String var1 = (String)var0.getParameter("http.protocol.element-charset");
      ConnectionConfig.Builder var3 = ConnectionConfig.custom();
      Charset var4;
      if(var1 != null) {
         var4 = Charset.forName(var1);
      } else {
         var4 = null;
      }

      return var3.setCharset(var4).setMalformedInputAction((CodingErrorAction)var0.getParameter("http.malformed.input.action")).setMalformedInputAction((CodingErrorAction)var0.getParameter("http.unmappable.input.action")).setMessageConstraints(var2).build();
   }

   public static MessageConstraints getMessageConstraints(HttpParams var0) {
      return MessageConstraints.custom().setMaxHeaderCount(var0.getIntParameter("http.connection.max-header-count", -1)).setMaxLineLength(var0.getIntParameter("http.connection.max-line-length", -1)).build();
   }

   public static SocketConfig getSocketConfig(HttpParams var0) {
      return SocketConfig.custom().setSoTimeout(var0.getIntParameter("http.socket.timeout", 0)).setSoReuseAddress(var0.getBooleanParameter("http.socket.reuseaddr", false)).setSoKeepAlive(var0.getBooleanParameter("http.socket.keepalive", false)).setSoLinger(var0.getIntParameter("http.socket.linger", -1)).setTcpNoDelay(var0.getBooleanParameter("http.tcp.nodelay", true)).build();
   }
}
