package com.google.android.gms.internal;

import java.util.LinkedHashMap;

public class kj {
   private int NA;
   private int NB;
   private int NC;
   private final LinkedHashMap Nw;
   private int Nx;
   private int Ny;
   private int Nz;
   private int size;

   public kj(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         this.Nx = var1;
         this.Nw = new LinkedHashMap(0, 0.75F, true);
      }
   }

   private int c(Object var1, Object var2) {
      int var3 = this.sizeOf(var1, var2);
      if(var3 < 0) {
         throw new IllegalStateException("Negative size: " + var1 + "=" + var2);
      } else {
         return var3;
      }
   }

   protected Object create(Object var1) {
      return null;
   }

   protected void entryRemoved(boolean var1, Object var2, Object var3, Object var4) {
   }

   public final void evictAll() {
      this.trimToSize(-1);
   }

   public final Object get(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public final Object put(Object param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public final int size() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.size;
      } finally {
         ;
      }

      return var1;
   }

   protected int sizeOf(Object var1, Object var2) {
      return 1;
   }

   public final String toString() {
      // $FF: Couldn't be decompiled
   }

   public void trimToSize(int param1) {
      // $FF: Couldn't be decompiled
   }
}
