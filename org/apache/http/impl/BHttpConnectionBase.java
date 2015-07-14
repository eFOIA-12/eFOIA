package org.apache.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.HttpConnectionMetricsImpl;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.impl.io.SessionInputBufferImpl;
import org.apache.http.impl.io.SessionOutputBufferImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.NetUtils;

@NotThreadSafe
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
   private final HttpConnectionMetricsImpl connMetrics;
   private final SessionInputBufferImpl inbuffer;
   private final ContentLengthStrategy incomingContentStrategy;
   private volatile boolean open;
   private final SessionOutputBufferImpl outbuffer;
   private final ContentLengthStrategy outgoingContentStrategy;
   private volatile Socket socket;

   protected BHttpConnectionBase(int var1, int var2, CharsetDecoder var3, CharsetEncoder var4, MessageConstraints var5, ContentLengthStrategy var6, ContentLengthStrategy var7) {
      Args.positive(var1, "Buffer size");
      HttpTransportMetricsImpl var8 = new HttpTransportMetricsImpl();
      HttpTransportMetricsImpl var9 = new HttpTransportMetricsImpl();
      if(var5 == null) {
         var5 = MessageConstraints.DEFAULT;
      }

      this.inbuffer = new SessionInputBufferImpl(var8, var1, -1, var5, var3);
      this.outbuffer = new SessionOutputBufferImpl(var9, var1, var2, var4);
      this.connMetrics = new HttpConnectionMetricsImpl(var8, var9);
      if(var6 == null) {
         var6 = LaxContentLengthStrategy.INSTANCE;
      }

      this.incomingContentStrategy = (ContentLengthStrategy)var6;
      if(var7 == null) {
         var7 = StrictContentLengthStrategy.INSTANCE;
      }

      this.outgoingContentStrategy = (ContentLengthStrategy)var7;
   }

   private int fillInputBuffer(int var1) throws IOException {
      int var2 = this.socket.getSoTimeout();

      try {
         this.socket.setSoTimeout(var1);
         var1 = this.inbuffer.fillBuffer();
      } finally {
         this.socket.setSoTimeout(var2);
      }

      return var1;
   }

   protected boolean awaitInput(int var1) throws IOException {
      if(this.inbuffer.hasBufferedData()) {
         return true;
      } else {
         this.fillInputBuffer(var1);
         return this.inbuffer.hasBufferedData();
      }
   }

   protected void bind(Socket var1) throws IOException {
      Args.notNull(var1, "Socket");
      this.socket = var1;
      this.open = true;
      this.inbuffer.bind((InputStream)null);
      this.outbuffer.bind((OutputStream)null);
   }

   public void close() throws IOException {
      if(this.open) {
         this.open = false;
         Socket var1 = this.socket;

         try {
            this.inbuffer.clear();
            this.outbuffer.flush();

            try {
               try {
                  var1.shutdownOutput();
               } catch (IOException var8) {
                  ;
               }

               try {
                  var1.shutdownInput();
               } catch (IOException var7) {
                  ;
               }
            } catch (UnsupportedOperationException var9) {
               ;
            }
         } finally {
            var1.close();
         }

      }
   }

   protected InputStream createInputStream(long var1, SessionInputBuffer var3) {
      return (InputStream)(var1 == -2L?new ChunkedInputStream(var3):(var1 == -1L?new IdentityInputStream(var3):new ContentLengthInputStream(var3, var1)));
   }

   protected OutputStream createOutputStream(long var1, SessionOutputBuffer var3) {
      return (OutputStream)(var1 == -2L?new ChunkedOutputStream(2048, var3):(var1 == -1L?new IdentityOutputStream(var3):new ContentLengthOutputStream(var3, var1)));
   }

   protected void doFlush() throws IOException {
      this.outbuffer.flush();
   }

   protected void ensureOpen() throws IOException {
      Asserts.check(this.open, "Connection is not open");
      if(!this.inbuffer.isBound()) {
         this.inbuffer.bind(this.getSocketInputStream(this.socket));
      }

      if(!this.outbuffer.isBound()) {
         this.outbuffer.bind(this.getSocketOutputStream(this.socket));
      }

   }

   public InetAddress getLocalAddress() {
      return this.socket != null?this.socket.getLocalAddress():null;
   }

   public int getLocalPort() {
      return this.socket != null?this.socket.getLocalPort():-1;
   }

   public HttpConnectionMetrics getMetrics() {
      return this.connMetrics;
   }

   public InetAddress getRemoteAddress() {
      return this.socket != null?this.socket.getInetAddress():null;
   }

   public int getRemotePort() {
      return this.socket != null?this.socket.getPort():-1;
   }

   protected SessionInputBuffer getSessionInputBuffer() {
      return this.inbuffer;
   }

   protected SessionOutputBuffer getSessionOutputBuffer() {
      return this.outbuffer;
   }

   protected Socket getSocket() {
      return this.socket;
   }

   protected InputStream getSocketInputStream(Socket var1) throws IOException {
      return var1.getInputStream();
   }

   protected OutputStream getSocketOutputStream(Socket var1) throws IOException {
      return var1.getOutputStream();
   }

   public int getSocketTimeout() {
      int var1 = -1;
      if(this.socket != null) {
         try {
            var1 = this.socket.getSoTimeout();
         } catch (SocketException var3) {
            return -1;
         }
      }

      return var1;
   }

   protected void incrementRequestCount() {
      this.connMetrics.incrementRequestCount();
   }

   protected void incrementResponseCount() {
      this.connMetrics.incrementResponseCount();
   }

   public boolean isOpen() {
      return this.open;
   }

   public boolean isStale() {
      if(this.isOpen()) {
         int var1;
         try {
            var1 = this.fillInputBuffer(1);
         } catch (SocketTimeoutException var3) {
            return false;
         } catch (IOException var4) {
            return true;
         }

         if(var1 >= 0) {
            return false;
         }
      }

      return true;
   }

   protected HttpEntity prepareInput(HttpMessage var1) throws HttpException {
      BasicHttpEntity var4 = new BasicHttpEntity();
      long var2 = this.incomingContentStrategy.determineLength(var1);
      InputStream var5 = this.createInputStream(var2, this.inbuffer);
      if(var2 == -2L) {
         var4.setChunked(true);
         var4.setContentLength(-1L);
         var4.setContent(var5);
      } else if(var2 == -1L) {
         var4.setChunked(false);
         var4.setContentLength(-1L);
         var4.setContent(var5);
      } else {
         var4.setChunked(false);
         var4.setContentLength(var2);
         var4.setContent(var5);
      }

      Header var7 = var1.getFirstHeader("Content-Type");
      if(var7 != null) {
         var4.setContentType(var7);
      }

      Header var6 = var1.getFirstHeader("Content-Encoding");
      if(var6 != null) {
         var4.setContentEncoding(var6);
      }

      return var4;
   }

   protected OutputStream prepareOutput(HttpMessage var1) throws HttpException {
      return this.createOutputStream(this.outgoingContentStrategy.determineLength(var1), this.outbuffer);
   }

   public void setSocketTimeout(int var1) {
      if(this.socket != null) {
         try {
            this.socket.setSoTimeout(var1);
         } catch (SocketException var3) {
            return;
         }
      }

   }

   public void shutdown() throws IOException {
      this.open = false;
      Socket var1 = this.socket;
      if(var1 != null) {
         var1.close();
      }

   }

   public String toString() {
      if(this.socket != null) {
         StringBuilder var1 = new StringBuilder();
         SocketAddress var2 = this.socket.getRemoteSocketAddress();
         SocketAddress var3 = this.socket.getLocalSocketAddress();
         if(var2 != null && var3 != null) {
            NetUtils.formatAddress(var1, var3);
            var1.append("<->");
            NetUtils.formatAddress(var1, var2);
         }

         return var1.toString();
      } else {
         return "[Not bound]";
      }
   }
}
