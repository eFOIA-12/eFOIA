package io.fabric.sdk.android.services.common;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueFile implements Closeable {
   static final int HEADER_LENGTH = 16;
   private static final int INITIAL_LENGTH = 4096;
   private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
   private final byte[] buffer = new byte[16];
   private int elementCount;
   int fileLength;
   private QueueFile.Element first;
   private QueueFile.Element last;
   private final RandomAccessFile raf;

   public QueueFile(File var1) throws IOException {
      if(!var1.exists()) {
         initialize(var1);
      }

      this.raf = open(var1);
      this.readHeader();
   }

   QueueFile(RandomAccessFile var1) throws IOException {
      this.raf = var1;
      this.readHeader();
   }

   private void expandIfNecessary(int var1) throws IOException {
      int var5 = var1 + 4;
      var1 = this.remainingBytes();
      if(var1 < var5) {
         int var2 = this.fileLength;

         int var3;
         int var4;
         do {
            var4 = var1 + var2;
            var3 = var2 << 1;
            var2 = var3;
            var1 = var4;
         } while(var4 < var5);

         this.setLength(var3);
         var1 = this.wrapPosition(this.last.position + 4 + this.last.length);
         if(var1 < this.first.position) {
            FileChannel var6 = this.raf.getChannel();
            var6.position((long)this.fileLength);
            var1 -= 4;
            if(var6.transferTo(16L, (long)var1, var6) != (long)var1) {
               throw new AssertionError("Copied insufficient number of bytes!");
            }
         }

         if(this.last.position < this.first.position) {
            var1 = this.fileLength + this.last.position - 16;
            this.writeHeader(var3, this.elementCount, this.first.position, var1);
            this.last = new QueueFile.Element(var1, this.last.length);
         } else {
            this.writeHeader(var3, this.elementCount, this.first.position, this.last.position);
         }

         this.fileLength = var3;
      }
   }

   private static void initialize(File var0) throws IOException {
      File var2 = new File(var0.getPath() + ".tmp");
      RandomAccessFile var1 = open(var2);

      try {
         var1.setLength(4096L);
         var1.seek(0L);
         byte[] var3 = new byte[16];
         writeInts(var3, new int[]{4096, 0, 0, 0});
         var1.write(var3);
      } finally {
         var1.close();
      }

      if(!var2.renameTo(var0)) {
         throw new IOException("Rename failed!");
      }
   }

   private static Object nonNull(Object var0, String var1) {
      if(var0 == null) {
         throw new NullPointerException(var1);
      } else {
         return var0;
      }
   }

   private static RandomAccessFile open(File var0) throws FileNotFoundException {
      return new RandomAccessFile(var0, "rwd");
   }

   private QueueFile.Element readElement(int var1) throws IOException {
      if(var1 == 0) {
         return QueueFile.Element.NULL;
      } else {
         this.raf.seek((long)var1);
         return new QueueFile.Element(var1, this.raf.readInt());
      }
   }

   private void readHeader() throws IOException {
      this.raf.seek(0L);
      this.raf.readFully(this.buffer);
      this.fileLength = readInt(this.buffer, 0);
      if((long)this.fileLength > this.raf.length()) {
         throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
      } else {
         this.elementCount = readInt(this.buffer, 4);
         int var1 = readInt(this.buffer, 8);
         int var2 = readInt(this.buffer, 12);
         this.first = this.readElement(var1);
         this.last = this.readElement(var2);
      }
   }

   private static int readInt(byte[] var0, int var1) {
      return ((var0[var1] & 255) << 24) + ((var0[var1 + 1] & 255) << 16) + ((var0[var1 + 2] & 255) << 8) + (var0[var1 + 3] & 255);
   }

   private int remainingBytes() {
      return this.fileLength - this.usedBytes();
   }

   private void ringRead(int var1, byte[] var2, int var3, int var4) throws IOException {
      var1 = this.wrapPosition(var1);
      if(var1 + var4 <= this.fileLength) {
         this.raf.seek((long)var1);
         this.raf.readFully(var2, var3, var4);
      } else {
         int var5 = this.fileLength - var1;
         this.raf.seek((long)var1);
         this.raf.readFully(var2, var3, var5);
         this.raf.seek(16L);
         this.raf.readFully(var2, var3 + var5, var4 - var5);
      }
   }

   private void ringWrite(int var1, byte[] var2, int var3, int var4) throws IOException {
      var1 = this.wrapPosition(var1);
      if(var1 + var4 <= this.fileLength) {
         this.raf.seek((long)var1);
         this.raf.write(var2, var3, var4);
      } else {
         int var5 = this.fileLength - var1;
         this.raf.seek((long)var1);
         this.raf.write(var2, var3, var5);
         this.raf.seek(16L);
         this.raf.write(var2, var3 + var5, var4 - var5);
      }
   }

   private void setLength(int var1) throws IOException {
      this.raf.setLength((long)var1);
      this.raf.getChannel().force(true);
   }

   private int wrapPosition(int var1) {
      return var1 < this.fileLength?var1:var1 + 16 - this.fileLength;
   }

   private void writeHeader(int var1, int var2, int var3, int var4) throws IOException {
      writeInts(this.buffer, new int[]{var1, var2, var3, var4});
      this.raf.seek(0L);
      this.raf.write(this.buffer);
   }

   private static void writeInt(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)(var2 >> 24);
      var0[var1 + 1] = (byte)(var2 >> 16);
      var0[var1 + 2] = (byte)(var2 >> 8);
      var0[var1 + 3] = (byte)var2;
   }

   private static void writeInts(byte[] var0, int... var1) {
      int var3 = 0;
      int var4 = var1.length;

      for(int var2 = 0; var2 < var4; ++var2) {
         writeInt(var0, var3, var1[var2]);
         var3 += 4;
      }

   }

   public void add(byte[] var1) throws IOException {
      this.add(var1, 0, var1.length);
   }

   public void add(byte[] param1, int param2, int param3) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void clear() throws IOException {
      synchronized(this){}

      try {
         this.writeHeader(4096, 0, 0, 0);
         this.elementCount = 0;
         this.first = QueueFile.Element.NULL;
         this.last = QueueFile.Element.NULL;
         if(this.fileLength > 4096) {
            this.setLength(4096);
         }

         this.fileLength = 4096;
      } finally {
         ;
      }

   }

   public void close() throws IOException {
      synchronized(this){}

      try {
         this.raf.close();
      } finally {
         ;
      }

   }

   public void forEach(QueueFile.ElementReader param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public boolean hasSpaceFor(int var1, int var2) {
      return this.usedBytes() + 4 + var1 <= var2;
   }

   public boolean isEmpty() {
      synchronized(this){}
      boolean var5 = false;

      int var1;
      try {
         var5 = true;
         var1 = this.elementCount;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void peek(QueueFile.ElementReader var1) throws IOException {
      synchronized(this){}

      try {
         if(this.elementCount > 0) {
            var1.read(new QueueFile.ElementInputStream(this.first, null), this.first.length);
         }
      } finally {
         ;
      }

   }

   public byte[] peek() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void remove() throws IOException {
      synchronized(this){}

      try {
         if(this.isEmpty()) {
            throw new NoSuchElementException();
         }

         if(this.elementCount == 1) {
            this.clear();
         } else {
            int var1 = this.wrapPosition(this.first.position + 4 + this.first.length);
            this.ringRead(var1, this.buffer, 0, 4);
            int var2 = readInt(this.buffer, 0);
            this.writeHeader(this.fileLength, this.elementCount - 1, var1, this.last.position);
            --this.elementCount;
            this.first = new QueueFile.Element(var1, var2);
         }
      } finally {
         ;
      }

   }

   public int size() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.elementCount;
      } finally {
         ;
      }

      return var1;
   }

   public String toString() {
      final StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append('[');
      var1.append("fileLength=").append(this.fileLength);
      var1.append(", size=").append(this.elementCount);
      var1.append(", first=").append(this.first);
      var1.append(", last=").append(this.last);
      var1.append(", element lengths=[");

      try {
         this.forEach(new QueueFile.ElementReader() {
            boolean first = true;

            public void read(InputStream var1x, int var2) throws IOException {
               if(this.first) {
                  this.first = false;
               } else {
                  var1.append(", ");
               }

               var1.append(var2);
            }
         });
      } catch (IOException var3) {
         LOGGER.log(Level.WARNING, "read error", var3);
      }

      var1.append("]]");
      return var1.toString();
   }

   public int usedBytes() {
      return this.elementCount == 0?16:(this.last.position >= this.first.position?this.last.position - this.first.position + 4 + this.last.length + 16:this.last.position + 4 + this.last.length + this.fileLength - this.first.position);
   }

   static class Element {
      static final int HEADER_LENGTH = 4;
      static final QueueFile.Element NULL = new QueueFile.Element(0, 0);
      final int length;
      final int position;

      Element(int var1, int var2) {
         this.position = var1;
         this.length = var2;
      }

      public String toString() {
         return this.getClass().getSimpleName() + "[" + "position = " + this.position + ", length = " + this.length + "]";
      }
   }

   private final class ElementInputStream extends InputStream {
      private int position;
      private int remaining;

      private ElementInputStream(QueueFile.Element var2) {
         this.position = QueueFile.this.wrapPosition(var2.position + 4);
         this.remaining = var2.length;
      }

      // $FF: synthetic method
      ElementInputStream(QueueFile.Element var2, Object var3) {
         this();
      }

      public int read() throws IOException {
         if(this.remaining == 0) {
            return -1;
         } else {
            QueueFile.this.raf.seek((long)this.position);
            int var1 = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            --this.remaining;
            return var1;
         }
      }

      public int read(byte[] var1, int var2, int var3) throws IOException {
         QueueFile.nonNull(var1, "buffer");
         if((var2 | var3) >= 0 && var3 <= var1.length - var2) {
            if(this.remaining > 0) {
               int var4 = var3;
               if(var3 > this.remaining) {
                  var4 = this.remaining;
               }

               QueueFile.this.ringRead(this.position, var1, var2, var4);
               this.position = QueueFile.this.wrapPosition(this.position + var4);
               this.remaining -= var4;
               return var4;
            } else {
               return -1;
            }
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   public interface ElementReader {
      void read(InputStream var1, int var2) throws IOException;
   }
}
