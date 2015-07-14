package com.crashlytics.android.core;

import com.crashlytics.android.core.CodedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

final class ByteString {
   public static final ByteString EMPTY = new ByteString(new byte[0]);
   private final byte[] bytes;
   private volatile int hash;

   private ByteString(byte[] var1) {
      this.hash = 0;
      this.bytes = var1;
   }

   // $FF: synthetic method
   ByteString(byte[] var1, Object var2) {
      this(var1);
   }

   public static ByteString copyFrom(String var0, String var1) throws UnsupportedEncodingException {
      return new ByteString(var0.getBytes(var1));
   }

   public static ByteString copyFrom(ByteBuffer var0) {
      return copyFrom(var0, var0.remaining());
   }

   public static ByteString copyFrom(ByteBuffer var0, int var1) {
      byte[] var2 = new byte[var1];
      var0.get(var2);
      return new ByteString(var2);
   }

   public static ByteString copyFrom(List var0) {
      if(var0.size() == 0) {
         return EMPTY;
      } else if(var0.size() == 1) {
         return (ByteString)var0.get(0);
      } else {
         int var1 = 0;

         for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 += ((ByteString)var2.next()).size()) {
            ;
         }

         byte[] var5 = new byte[var1];
         var1 = 0;

         ByteString var3;
         for(Iterator var4 = var0.iterator(); var4.hasNext(); var1 += var3.size()) {
            var3 = (ByteString)var4.next();
            System.arraycopy(var3.bytes, 0, var5, var1, var3.size());
         }

         return new ByteString(var5);
      }
   }

   public static ByteString copyFrom(byte[] var0) {
      return copyFrom(var0, 0, var0.length);
   }

   public static ByteString copyFrom(byte[] var0, int var1, int var2) {
      byte[] var3 = new byte[var2];
      System.arraycopy(var0, var1, var3, 0, var2);
      return new ByteString(var3);
   }

   public static ByteString copyFromUtf8(String var0) {
      try {
         ByteString var2 = new ByteString(var0.getBytes("UTF-8"));
         return var2;
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException("UTF-8 not supported.", var1);
      }
   }

   static ByteString.CodedBuilder newCodedBuilder(int var0) {
      return new ByteString.CodedBuilder(var0, null);
   }

   public static ByteString.Output newOutput() {
      return newOutput(32);
   }

   public static ByteString.Output newOutput(int var0) {
      return new ByteString.Output(new ByteArrayOutputStream(var0), null);
   }

   public ByteBuffer asReadOnlyByteBuffer() {
      return ByteBuffer.wrap(this.bytes).asReadOnlyBuffer();
   }

   public byte byteAt(int var1) {
      return this.bytes[var1];
   }

   public void copyTo(ByteBuffer var1) {
      var1.put(this.bytes, 0, this.bytes.length);
   }

   public void copyTo(byte[] var1, int var2) {
      System.arraycopy(this.bytes, 0, var1, var2, this.bytes.length);
   }

   public void copyTo(byte[] var1, int var2, int var3, int var4) {
      System.arraycopy(this.bytes, var2, var1, var3, var4);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ByteString)) {
            return false;
         }

         ByteString var4 = (ByteString)var1;
         int var3 = this.bytes.length;
         if(var3 != var4.bytes.length) {
            return false;
         }

         byte[] var5 = this.bytes;
         byte[] var6 = var4.bytes;

         for(int var2 = 0; var2 < var3; ++var2) {
            if(var5[var2] != var6[var2]) {
               return false;
            }
         }
      }

      return true;
   }

   public int hashCode() {
      int var1 = this.hash;
      int var2 = var1;
      if(var1 == 0) {
         byte[] var4 = this.bytes;
         int var3 = this.bytes.length;
         var1 = var3;

         for(var2 = 0; var2 < var3; ++var2) {
            var1 = var1 * 31 + var4[var2];
         }

         var2 = var1;
         if(var1 == 0) {
            var2 = 1;
         }

         this.hash = var2;
      }

      return var2;
   }

   public boolean isEmpty() {
      return this.bytes.length == 0;
   }

   public InputStream newInput() {
      return new ByteArrayInputStream(this.bytes);
   }

   public int size() {
      return this.bytes.length;
   }

   public byte[] toByteArray() {
      int var1 = this.bytes.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(this.bytes, 0, var2, 0, var1);
      return var2;
   }

   public String toString(String var1) throws UnsupportedEncodingException {
      return new String(this.bytes, var1);
   }

   public String toStringUtf8() {
      try {
         String var1 = new String(this.bytes, "UTF-8");
         return var1;
      } catch (UnsupportedEncodingException var2) {
         throw new RuntimeException("UTF-8 not supported?", var2);
      }
   }

   static final class CodedBuilder {
      private final byte[] buffer;
      private final CodedOutputStream output;

      private CodedBuilder(int var1) {
         this.buffer = new byte[var1];
         this.output = CodedOutputStream.newInstance(this.buffer);
      }

      // $FF: synthetic method
      CodedBuilder(int var1, Object var2) {
         this(var1);
      }

      public ByteString build() {
         this.output.checkNoSpaceLeft();
         return new ByteString(this.buffer, null);
      }

      public CodedOutputStream getCodedOutput() {
         return this.output;
      }
   }

   static final class Output extends FilterOutputStream {
      private final ByteArrayOutputStream bout;

      private Output(ByteArrayOutputStream var1) {
         super(var1);
         this.bout = var1;
      }

      // $FF: synthetic method
      Output(ByteArrayOutputStream var1, Object var2) {
         this(var1);
      }

      public ByteString toByteString() {
         return new ByteString(this.bout.toByteArray(), null);
      }
   }
}
