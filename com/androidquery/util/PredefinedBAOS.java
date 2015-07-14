package com.androidquery.util;

import java.io.ByteArrayOutputStream;

public class PredefinedBAOS extends ByteArrayOutputStream {
   public PredefinedBAOS(int var1) {
      super(var1);
   }

   public byte[] toByteArray() {
      return this.count == this.buf.length?this.buf:super.toByteArray();
   }
}
