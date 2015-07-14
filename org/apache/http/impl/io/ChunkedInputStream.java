package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.TruncatedChunkException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class ChunkedInputStream extends InputStream {
   private static final int BUFFER_SIZE = 2048;
   private static final int CHUNK_CRLF = 3;
   private static final int CHUNK_DATA = 2;
   private static final int CHUNK_LEN = 1;
   private final CharArrayBuffer buffer;
   private int chunkSize;
   private boolean closed = false;
   private boolean eof = false;
   private Header[] footers = new Header[0];
   private final SessionInputBuffer in;
   private int pos;
   private int state;

   public ChunkedInputStream(SessionInputBuffer var1) {
      this.in = (SessionInputBuffer)Args.notNull(var1, "Session input buffer");
      this.pos = 0;
      this.buffer = new CharArrayBuffer(16);
      this.state = 1;
   }

   private int getChunkSize() throws IOException {
      switch(this.state) {
      case 2:
      default:
         throw new IllegalStateException("Inconsistent codec state");
      case 3:
         this.buffer.clear();
         if(this.in.readLine(this.buffer) == -1) {
            break;
         }

         if(!this.buffer.isEmpty()) {
            throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
         }

         this.state = 1;
      case 1:
         this.buffer.clear();
         if(this.in.readLine(this.buffer) != -1) {
            int var2 = this.buffer.indexOf(59);
            int var1 = var2;
            if(var2 < 0) {
               var1 = this.buffer.length();
            }

            try {
               var1 = Integer.parseInt(this.buffer.substringTrimmed(0, var1), 16);
               return var1;
            } catch (NumberFormatException var4) {
               throw new MalformedChunkCodingException("Bad chunk header");
            }
         }
      }

      return 0;
   }

   private void nextChunk() throws IOException {
      this.chunkSize = this.getChunkSize();
      if(this.chunkSize < 0) {
         throw new MalformedChunkCodingException("Negative chunk size");
      } else {
         this.state = 2;
         this.pos = 0;
         if(this.chunkSize == 0) {
            this.eof = true;
            this.parseTrailerHeaders();
         }

      }
   }

   private void parseTrailerHeaders() throws IOException {
      try {
         this.footers = AbstractMessageParser.parseHeaders(this.in, -1, -1, (LineParser)null);
      } catch (HttpException var3) {
         MalformedChunkCodingException var2 = new MalformedChunkCodingException("Invalid footer: " + var3.getMessage());
         var2.initCause(var3);
         throw var2;
      }
   }

   public int available() throws IOException {
      return this.in instanceof BufferInfo?Math.min(((BufferInfo)this.in).length(), this.chunkSize - this.pos):0;
   }

   public void close() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public Header[] getFooters() {
      return (Header[])this.footers.clone();
   }

   public int read() throws IOException {
      if(this.closed) {
         throw new IOException("Attempted read from closed stream.");
      } else {
         int var1;
         if(this.eof) {
            var1 = -1;
         } else {
            if(this.state != 2) {
               this.nextChunk();
               if(this.eof) {
                  return -1;
               }
            }

            int var2 = this.in.read();
            var1 = var2;
            if(var2 != -1) {
               ++this.pos;
               var1 = var2;
               if(this.pos >= this.chunkSize) {
                  this.state = 3;
                  return var2;
               }
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
         if(this.eof) {
            var2 = -1;
         } else {
            if(this.state != 2) {
               this.nextChunk();
               if(this.eof) {
                  return -1;
               }
            }

            var3 = this.in.read(var1, var2, Math.min(var3, this.chunkSize - this.pos));
            if(var3 == -1) {
               this.eof = true;
               throw new TruncatedChunkException("Truncated chunk ( expected size: " + this.chunkSize + "; actual size: " + this.pos + ")");
            }

            this.pos += var3;
            var2 = var3;
            if(this.pos >= this.chunkSize) {
               this.state = 3;
               return var3;
            }
         }

         return var2;
      }
   }
}
