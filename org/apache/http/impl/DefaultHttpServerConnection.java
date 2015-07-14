package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.SocketHttpServerConnection;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
@NotThreadSafe
public class DefaultHttpServerConnection extends SocketHttpServerConnection {
   public void bind(Socket var1, HttpParams var2) throws IOException {
      boolean var5 = true;
      Args.notNull(var1, "Socket");
      Args.notNull(var2, "HTTP parameters");
      this.assertNotOpen();
      var1.setTcpNoDelay(var2.getBooleanParameter("http.tcp.nodelay", true));
      var1.setSoTimeout(var2.getIntParameter("http.socket.timeout", 0));
      var1.setKeepAlive(var2.getBooleanParameter("http.socket.keepalive", false));
      int var3 = var2.getIntParameter("http.socket.linger", -1);
      boolean var4;
      if(var3 >= 0) {
         if(var3 > 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         var1.setSoLinger(var4, var3);
      }

      if(var3 >= 0) {
         if(var3 > 0) {
            var4 = var5;
         } else {
            var4 = false;
         }

         var1.setSoLinger(var4, var3);
      }

      super.bind(var1, var2);
   }
}
