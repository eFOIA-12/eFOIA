package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.http.MessageConstraintException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
   private final byte[] buffer;
   private int bufferlen;
   private int bufferpos;
   private CharBuffer cbuf;
   private final MessageConstraints constraints;
   private final CharsetDecoder decoder;
   private InputStream instream;
   private final ByteArrayBuffer linebuffer;
   private final HttpTransportMetricsImpl metrics;
   private final int minChunkLimit;

   public SessionInputBufferImpl(HttpTransportMetricsImpl var1, int var2) {
      this(var1, var2, var2, (MessageConstraints)null, (CharsetDecoder)null);
   }

   public SessionInputBufferImpl(HttpTransportMetricsImpl var1, int var2, int var3, MessageConstraints var4, CharsetDecoder var5) {
      Args.notNull(var1, "HTTP transport metrcis");
      Args.positive(var2, "Buffer size");
      this.metrics = var1;
      this.buffer = new byte[var2];
      this.bufferpos = 0;
      this.bufferlen = 0;
      if(var3 < 0) {
         var3 = 512;
      }

      this.minChunkLimit = var3;
      if(var4 == null) {
         var4 = MessageConstraints.DEFAULT;
      }

      this.constraints = var4;
      this.linebuffer = new ByteArrayBuffer(var2);
      this.decoder = var5;
   }

   private int appendDecoded(CharArrayBuffer var1, ByteBuffer var2) throws IOException {
      if(!var2.hasRemaining()) {
         return 0;
      } else {
         if(this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
         }

         this.decoder.reset();

         int var3;
         for(var3 = 0; var2.hasRemaining(); var3 += this.handleDecodingResult(this.decoder.decode(var2, this.cbuf, true), var1, var2)) {
            ;
         }

         int var4 = this.handleDecodingResult(this.decoder.flush(this.cbuf), var1, var2);
         this.cbuf.clear();
         return var3 + var4;
      }
   }

   private int handleDecodingResult(CoderResult var1, CharArrayBuffer var2, ByteBuffer var3) throws IOException {
      if(var1.isError()) {
         var1.throwException();
      }

      this.cbuf.flip();
      int var4 = this.cbuf.remaining();

      while(this.cbuf.hasRemaining()) {
         var2.append(this.cbuf.get());
      }

      this.cbuf.compact();
      return var4;
   }

   private int lineFromLineBuffer(CharArrayBuffer var1) throws IOException {
      int var4 = this.linebuffer.length();
      int var2 = var4;
      if(var4 > 0) {
         int var3 = var4;
         if(this.linebuffer.byteAt(var4 - 1) == 10) {
            var3 = var4 - 1;
         }

         var2 = var3;
         if(var3 > 0) {
            var2 = var3;
            if(this.linebuffer.byteAt(var3 - 1) == 13) {
               var2 = var3 - 1;
            }
         }
      }

      if(this.decoder == null) {
         var1.append((ByteArrayBuffer)this.linebuffer, 0, var2);
      } else {
         var2 = this.appendDecoded(var1, ByteBuffer.wrap(this.linebuffer.buffer(), 0, var2));
      }

      this.linebuffer.clear();
      return var2;
   }

   private int lineFromReadBuffer(CharArrayBuffer var1, int var2) throws IOException {
      int var4 = this.bufferpos;
      this.bufferpos = var2 + 1;
      int var3 = var2;
      if(var2 > var4) {
         var3 = var2;
         if(this.buffer[var2 - 1] == 13) {
            var3 = var2 - 1;
         }
      }

      var2 = var3 - var4;
      if(this.decoder == null) {
         var1.append(this.buffer, var4, var2);
         return var2;
      } else {
         return this.appendDecoded(var1, ByteBuffer.wrap(this.buffer, var4, var2));
      }
   }

   private int locateLF() {
      for(int var1 = this.bufferpos; var1 < this.bufferlen; ++var1) {
         if(this.buffer[var1] == 10) {
            return var1;
         }
      }

      return -1;
   }

   private int streamRead(byte[] var1, int var2, int var3) throws IOException {
      Asserts.notNull(this.instream, "Input stream");
      return this.instream.read(var1, var2, var3);
   }

   public int available() {
      return this.capacity() - this.length();
   }

   public void bind(InputStream var1) {
      this.instream = var1;
   }

   public int capacity() {
      return this.buffer.length;
   }

   public void clear() {
      this.bufferpos = 0;
      this.bufferlen = 0;
   }

   public int fillBuffer() throws IOException {
      int var1;
      if(this.bufferpos > 0) {
         var1 = this.bufferlen - this.bufferpos;
         if(var1 > 0) {
            System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, var1);
         }

         this.bufferpos = 0;
         this.bufferlen = var1;
      }

      var1 = this.bufferlen;
      int var2 = this.buffer.length;
      var2 = this.streamRead(this.buffer, var1, var2 - var1);
      if(var2 == -1) {
         return -1;
      } else {
         this.bufferlen = var1 + var2;
         this.metrics.incrementBytesTransferred((long)var2);
         return var2;
      }
   }

   public HttpTransportMetrics getMetrics() {
      return this.metrics;
   }

   public boolean hasBufferedData() {
      return this.bufferpos < this.bufferlen;
   }

   public boolean isBound() {
      return this.instream != null;
   }

   public boolean isDataAvailable(int var1) throws IOException {
      return this.hasBufferedData();
   }

   public int length() {
      return this.bufferlen - this.bufferpos;
   }

   public int read() throws IOException {
      while(true) {
         if(!this.hasBufferedData()) {
            if(this.fillBuffer() != -1) {
               continue;
            }

            return -1;
         }

         byte[] var2 = this.buffer;
         int var1 = this.bufferpos;
         this.bufferpos = var1 + 1;
         return var2[var1] & 255;
      }
   }

   public int read(byte[] var1) throws IOException {
      return var1 == null?0:this.read(var1, 0, var1.length);
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      if(var1 == null) {
         return 0;
      } else if(this.hasBufferedData()) {
         var3 = Math.min(var3, this.bufferlen - this.bufferpos);
         System.arraycopy(this.buffer, this.bufferpos, var1, var2, var3);
         this.bufferpos += var3;
         return var3;
      } else if(var3 > this.minChunkLimit) {
         var2 = this.streamRead(var1, var2, var3);
         if(var2 > 0) {
            this.metrics.incrementBytesTransferred((long)var2);
         }

         return var2;
      } else {
         do {
            if(this.hasBufferedData()) {
               var3 = Math.min(var3, this.bufferlen - this.bufferpos);
               System.arraycopy(this.buffer, this.bufferpos, var1, var2, var3);
               this.bufferpos += var3;
               return var3;
            }
         } while(this.fillBuffer() != -1);

         return -1;
      }
   }

   public int readLine(CharArrayBuffer var1) throws IOException {
      byte var6 = -1;
      Args.notNull(var1, "Char array buffer");
      int var4 = 0;
      boolean var3 = true;

      while(true) {
         int var8;
         if(var3) {
            int var5 = this.locateLF();
            boolean var2;
            if(var5 != -1) {
               if(this.linebuffer.isEmpty()) {
                  var8 = this.lineFromReadBuffer(var1, var5);
                  return var8;
               }

               var2 = false;
               int var9 = this.bufferpos;
               this.linebuffer.append(this.buffer, this.bufferpos, var5 + 1 - var9);
               this.bufferpos = var5 + 1;
               var5 = var4;
            } else {
               if(this.hasBufferedData()) {
                  var8 = this.bufferlen;
                  var4 = this.bufferpos;
                  this.linebuffer.append(this.buffer, this.bufferpos, var8 - var4);
                  this.bufferpos = this.bufferlen;
               }

               var4 = this.fillBuffer();
               var5 = var4;
               var2 = var3;
               if(var4 == -1) {
                  var2 = false;
                  var5 = var4;
               }
            }

            int var7 = this.constraints.getMaxLineLength();
            var4 = var5;
            var3 = var2;
            if(var7 > 0) {
               var4 = var5;
               var3 = var2;
               if(this.linebuffer.length() >= var7) {
                  throw new MessageConstraintException("Maximum line length limit exceeded");
               }
            }
         } else {
            if(var4 == -1) {
               var8 = var6;
               if(this.linebuffer.isEmpty()) {
                  return var8;
               }
            }

            return this.lineFromLineBuffer(var1);
         }
      }
   }

   public String readLine() throws IOException {
      CharArrayBuffer var1 = new CharArrayBuffer(64);
      return this.readLine(var1) != -1?var1.toString():null;
   }
}
