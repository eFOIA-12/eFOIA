package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.c;
import com.google.android.gms.common.data.d;
import java.util.NoSuchElementException;

public class h extends c {
   private Object Lt;

   public h(DataBuffer var1) {
      super(var1);
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException("Cannot advance the iterator beyond " + this.KX);
      } else {
         ++this.KX;
         if(this.KX == 0) {
            this.Lt = this.KW.get(0);
            if(!(this.Lt instanceof d)) {
               throw new IllegalStateException("DataBuffer reference of type " + this.Lt.getClass() + " is not movable");
            }
         } else {
            ((d)this.Lt).as(this.KX);
         }

         return this.Lt;
      }
   }
}
