package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.jx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c implements Iterator {
   protected final DataBuffer KW;
   protected int KX;

   public c(DataBuffer var1) {
      this.KW = (DataBuffer)jx.i(var1);
      this.KX = -1;
   }

   public boolean hasNext() {
      return this.KX < this.KW.getCount() - 1;
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException("Cannot advance the iterator beyond " + this.KX);
      } else {
         DataBuffer var2 = this.KW;
         int var1 = this.KX + 1;
         this.KX = var1;
         return var2.get(var1);
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
   }
}
