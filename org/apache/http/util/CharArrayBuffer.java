package org.apache.http.util;

import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;

@NotThreadSafe
public final class CharArrayBuffer implements Serializable {
   private static final long serialVersionUID = -6208952725094867135L;
   private char[] buffer;
   private int len;

   public CharArrayBuffer(int var1) {
      Args.notNegative(var1, "Buffer capacity");
      this.buffer = new char[var1];
   }

   private void expand(int var1) {
      char[] var2 = new char[Math.max(this.buffer.length << 1, var1)];
      System.arraycopy(this.buffer, 0, var2, 0, this.len);
      this.buffer = var2;
   }

   public void append(char var1) {
      int var2 = this.len + 1;
      if(var2 > this.buffer.length) {
         this.expand(var2);
      }

      this.buffer[this.len] = var1;
      this.len = var2;
   }

   public void append(Object var1) {
      this.append(String.valueOf(var1));
   }

   public void append(String var1) {
      if(var1 == null) {
         var1 = "null";
      }

      int var2 = var1.length();
      int var3 = this.len + var2;
      if(var3 > this.buffer.length) {
         this.expand(var3);
      }

      var1.getChars(0, var2, this.buffer, this.len);
      this.len = var3;
   }

   public void append(ByteArrayBuffer var1, int var2, int var3) {
      if(var1 != null) {
         this.append(var1.buffer(), var2, var3);
      }
   }

   public void append(CharArrayBuffer var1) {
      if(var1 != null) {
         this.append((char[])var1.buffer, 0, var1.len);
      }
   }

   public void append(CharArrayBuffer var1, int var2, int var3) {
      if(var1 != null) {
         this.append(var1.buffer, var2, var3);
      }
   }

   public void append(byte[] var1, int var2, int var3) {
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
               this.buffer[var3] = (char)(var1[var2] & 255);
               ++var2;
            }

            this.len = var5;
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

   public char[] buffer() {
      return this.buffer;
   }

   public int capacity() {
      return this.buffer.length;
   }

   public char charAt(int var1) {
      return this.buffer[var1];
   }

   public void clear() {
      this.len = 0;
   }

   public void ensureCapacity(int var1) {
      if(var1 > 0 && var1 > this.buffer.length - this.len) {
         this.expand(this.len + var1);
      }
   }

   public int indexOf(int var1) {
      return this.indexOf(var1, 0, this.len);
   }

   public int indexOf(int var1, int var2, int var3) {
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

   public String substring(int var1, int var2) {
      return new String(this.buffer, var1, var2 - var1);
   }

   public String substringTrimmed(int var1, int var2) {
      int var3 = var1;
      if(var1 < 0) {
         throw new IndexOutOfBoundsException("Negative beginIndex: " + var1);
      } else if(var2 > this.len) {
         throw new IndexOutOfBoundsException("endIndex: " + var2 + " > length: " + this.len);
      } else {
         var1 = var1;
         if(var3 > var2) {
            throw new IndexOutOfBoundsException("beginIndex: " + var3 + " > endIndex: " + var2);
         } else {
            while(true) {
               var3 = var2;
               if(var1 >= var2) {
                  break;
               }

               var3 = var2;
               if(!HTTP.isWhitespace(this.buffer[var1])) {
                  break;
               }

               ++var1;
            }

            while(var3 > var1 && HTTP.isWhitespace(this.buffer[var3 - 1])) {
               --var3;
            }

            return new String(this.buffer, var1, var3 - var1);
         }
      }
   }

   public char[] toCharArray() {
      char[] var1 = new char[this.len];
      if(this.len > 0) {
         System.arraycopy(this.buffer, 0, var1, 0, this.len);
      }

      return var1;
   }

   public String toString() {
      return new String(this.buffer, 0, this.len);
   }
}
