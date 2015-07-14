package org.apache.http.config;

import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class SocketConfig implements Cloneable {
   public static final SocketConfig DEFAULT = (new SocketConfig.Builder()).build();
   private final boolean soKeepAlive;
   private final int soLinger;
   private final boolean soReuseAddress;
   private final int soTimeout;
   private final boolean tcpNoDelay;

   SocketConfig(int var1, boolean var2, int var3, boolean var4, boolean var5) {
      this.soTimeout = var1;
      this.soReuseAddress = var2;
      this.soLinger = var3;
      this.soKeepAlive = var4;
      this.tcpNoDelay = var5;
   }

   public static SocketConfig.Builder copy(SocketConfig var0) {
      Args.notNull(var0, "Socket config");
      return (new SocketConfig.Builder()).setSoTimeout(var0.getSoTimeout()).setSoReuseAddress(var0.isSoReuseAddress()).setSoLinger(var0.getSoLinger()).setSoKeepAlive(var0.isSoKeepAlive()).setTcpNoDelay(var0.isTcpNoDelay());
   }

   public static SocketConfig.Builder custom() {
      return new SocketConfig.Builder();
   }

   protected SocketConfig clone() throws CloneNotSupportedException {
      return (SocketConfig)super.clone();
   }

   public int getSoLinger() {
      return this.soLinger;
   }

   public int getSoTimeout() {
      return this.soTimeout;
   }

   public boolean isSoKeepAlive() {
      return this.soKeepAlive;
   }

   public boolean isSoReuseAddress() {
      return this.soReuseAddress;
   }

   public boolean isTcpNoDelay() {
      return this.tcpNoDelay;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[soTimeout=").append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append("]");
      return var1.toString();
   }

   public static class Builder {
      private boolean soKeepAlive;
      private int soLinger = -1;
      private boolean soReuseAddress;
      private int soTimeout;
      private boolean tcpNoDelay = true;

      public SocketConfig build() {
         return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay);
      }

      public SocketConfig.Builder setSoKeepAlive(boolean var1) {
         this.soKeepAlive = var1;
         return this;
      }

      public SocketConfig.Builder setSoLinger(int var1) {
         this.soLinger = var1;
         return this;
      }

      public SocketConfig.Builder setSoReuseAddress(boolean var1) {
         this.soReuseAddress = var1;
         return this;
      }

      public SocketConfig.Builder setSoTimeout(int var1) {
         this.soTimeout = var1;
         return this;
      }

      public SocketConfig.Builder setTcpNoDelay(boolean var1) {
         this.tcpNoDelay = var1;
         return this;
      }
   }
}
