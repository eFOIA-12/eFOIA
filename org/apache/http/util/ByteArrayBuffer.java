package org.apache.http.util;

import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public final class ByteArrayBuffer implements Serializable {
   private static final long serialVersionUID = 4359112959524048036L;
   private byte[] buffer;
   private int len;

   public ByteArrayBuffer(int var1) {
      Args.notNegative(var1, "Buffer capacity");
      this.buffer = new byte[var1];
   }

   private void expand(int var1) {
      byte[] var2 = new byte[Math.max(this.buffer.length << 1, var1)];
      System.arraycopy(this.buffer, 0, var2, 0, this.len);
      this.buffer = var2;
   }

   public void append(int var1) {
      int var2 = this.len + 1;
      if(var2 > this.buffer.length) {
         this.expand(var2);
      }

      this.buffer[this.len] = (byte)var1;
      this.len = var2;
   }

   public void append(CharArrayBuffer var1, int var2, int var3) {
      if(var1 != null) {
         this.append(var1.buffer(), var2, var3);
      }
   }

   public void append(byte[] var1, int var2, int var3) {
      if(var1 != null) {
         if(var2 < 0 || var2 > var1.length || var3 < 0 || var2 + var3 < 0 || var2 + var3 > var1.length) {
            throw new IndexOutOfBoundsException("off: " + var2 + " len: " + var3 + " b.length: " + var1.length);
         }

         if(var3 != 0) {
            int var4 = this.len + var3;
            if(var4 > this.buffer.length) {
               this.expand(var4);
            }

            System.arraycopy(var1, var2, this.buffer, this.len, var3);
            this.len = var4;
            return;
         }
      }

   }

   public void append(char[] var1, int var2, int var3) {
      if(var1 != null) {
         if(var2 < 0 || var2 > var1.length || var3 < 0 || var2 + var3 < 0 || var2 + var3 > var1.length) {
            throw new IndexOutOfBoundsException("off: " + var2 + " len: " + var3 + " b.length: " + var1.length);
         }

         if(var3 != 0) {
            int var4 = this.len;
            int var5 = var4 + var3;
            if(var5 > this.buffer.length) {
               this.expand(var5);
            }

            for(var3 = var4; var3 < var5; ++var3) {
               this.buffer[var3] = (byte)var1[var2];
               ++var2;
            }

            this.len = var5;
            return;
         }
      }

   }

   public byte[] buffer() {
      return this.buffer;
   }

   public int byteAt(int var1) {
      return this.buffer[var1];
   }

   public int capacity() {
      return this.buffer.length;
   }

   public void clear() {
      this.len = 0;
   }

   public void ensureCapacity(int var1) {
      if(var1 > 0 && var1 > this.buffer.length - this.len) {
         this.expand(this.len + var1);
      }
   }

   public int indexOf(byte var1) {
      return this.indexOf(var1, 0, this.len);
   }

   public int indexOf(byte var1, int var2, int var3) {
      int var4 = var2;
      var2 = var2;
      if(var4 < 0) {
         var2 = 0;
      }

      var4 = var3;
      var3 = var3;
      if(var4 > this.len) {
         var3 = this.len;
      }

      if(var2 > var3) {
         var4 = -1;
      } else {
         while(true) {
            if(var2 >= var3) {
               return -1;
            }

            var4 = var2;
            if(this.buffer[var2] == var1) {
               break;
            }

            ++var2;
         }
      }

      return var4;
   }

   public boolean isEmpty() {
      return this.len == 0;
   }

   public boolean isFull() {
      return this.len == this.buffer.length;
   }

   public int length() {
      return this.len;
   }

   public void setLength(int var1) {
      if(var1 >= 0 && var1 <= this.buffer.length) {
         this.len = var1;
      } else {
         throw new IndexOutOfBoundsException("len: " + var1 + " < 0 or > buffer len: " + this.buffer.length);
      }
   }

   public byte[] toByteArray() {
      byte[] var1 = new byte[this.len];
      if(this.len > 0) {
         System.arraycopy(this.buffer, 0, var1, 0, this.len);
      }

      return var1;
   }
}
