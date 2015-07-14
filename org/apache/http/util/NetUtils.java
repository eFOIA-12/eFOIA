package org.apache.http.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.apache.http.util.Args;

public final class NetUtils {
   public static void formatAddress(StringBuilder var0, SocketAddress var1) {
      Args.notNull(var0, "Buffer");
      Args.notNull(var1, "Socket address");
      if(var1 instanceof InetSocketAddress) {
         InetSocketAddress var3 = (InetSocketAddress)var1;
         InetAddress var2 = var3.getAddress();
         Object var4 = var2;
         if(var2 != null) {
            var4 = var2.getHostAddress();
         }

         var0.append(var4).append(':').append(var3.getPort());
      } else {
         var0.append(var1);
      }
   }
}
