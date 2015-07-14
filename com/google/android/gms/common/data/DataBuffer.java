package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.c;
import com.google.android.gms.common.data.h;
import java.util.Iterator;

public abstract class DataBuffer implements Releasable, Iterable {
   protected final DataHolder JG;

   protected DataBuffer(DataHolder var1) {
      this.JG = var1;
      if(this.JG != null) {
         this.JG.e(this);
      }

   }

   @Deprecated
   public final void close() {
      this.release();
   }

   public int describeContents() {
      return 0;
   }

   public Bundle gV() {
      return this.JG.gV();
   }

   public abstract Object get(int var1);

   public int getCount() {
      return this.JG == null?0:this.JG.getCount();
   }

   @Deprecated
   public boolean isClosed() {
      return this.JG == null?true:this.JG.isClosed();
   }

   public Iterator iterator() {
      return new c(this);
   }

   public void release() {
      if(this.JG != null) {
         this.JG.close();
      }

   }

   public Iterator singleRefIterator() {
      return new h(this);
   }
}
