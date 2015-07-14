package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class ContentLengthInputStream extends InputStream {
   private static final int BUFFER_SIZE = 2048;
   private boolean closed = false;
   private final long contentLength;
   private SessionInputBuffer in = null;
   private long pos = 0L;

   public ContentLengthInputStream(SessionInputBuffer var1, long var2) {
      this.in = (SessionInputBuffer)Args.notNull(var1, "Session input buffer");
      this.contentLength = Args.notNegative(var2, "Content length");
   }

   public int available() throws IOException {
      return this.in instanceof BufferInfo?Math.min(((BufferInfo)this.in).length(), (int)(this.contentLength - this.pos)):0;
   }

   public void close() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public int read() throws IOException {
      if(this.closed) {
         throw new IOException("Attempted read from closed stream.");
      } else {
         int var1;
         if(this.pos >= this.contentLength) {
            var1 = -1;
         } else {
            var1 = this.in.read();
            if(var1 != -1) {
               ++this.pos;
               return var1;
            }

            if(this.pos < this.contentLength) {
               throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
            }
         }

         return var1;
      }
   }

   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      if(this.closed) {
         throw new IOException("Attempted read from closed stream.");
      } else {
         if(this.pos >= this.contentLength) {
            var2 = -1;
         } else {
            int var4 = var3;
            if(this.pos + (long)var3 > this.contentLength) {
               var4 = (int)(this.contentLength - this.pos);
            }

            var3 = this.in.read(var1, var2, var4);
            if(var3 == -1 && this.pos < this.contentLength) {
               throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
            }

            var2 = var3;
            if(var3 > 0) {
               this.pos += (long)var3;
               return var3;
            }
         }

         return var2;
      }
   }

   public long skip(long var1) throws IOException {
      long var6;
      if(var1 <= 0L) {
         var6 = 0L;
      } else {
         byte[] var8 = new byte[2048];
         long var4 = Math.min(var1, this.contentLength - this.pos);
         var1 = 0L;

         while(true) {
            var6 = var1;
            if(var4 <= 0L) {
               break;
            }

            int var3 = this.read(var8, 0, (int)Math.min(2048L, var4));
            var6 = var1;
            if(var3 == -1) {
               break;
            }

            var1 += (long)var3;
            var4 -= (long)var3;
         }
      }

      return var6;
   }
}
