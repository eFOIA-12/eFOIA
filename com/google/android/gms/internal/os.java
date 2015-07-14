package com.google.android.gms.internal;

import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.ov;
import com.google.android.gms.internal.ra;
import java.util.ArrayList;

public class os {
   private final ArrayList amZ;
   private int ana;

   public os() {
      this(100);
   }

   public os(int var1) {
      this.amZ = new ArrayList();
      this.ana = var1;
   }

   private void oq() {
      while(this.getSize() > this.getCapacity()) {
         this.amZ.remove(0);
      }

   }

   public void a(ov var1, or var2) {
      this.amZ.add(new os.a(var1, var2, null));
      this.oq();
   }

   public void clear() {
      this.amZ.clear();
   }

   public int getCapacity() {
      return this.ana;
   }

   public int getSize() {
      return this.amZ.size();
   }

   public boolean isEmpty() {
      return this.amZ.isEmpty();
   }

   public ArrayList op() {
      return this.amZ;
   }

   public static class a {
      public final ov anb;
      public final or anc;
      public final ra.c and;

      private a(ov var1, or var2) {
         this.anb = (ov)jx.i(var1);
         this.anc = (or)jx.i(var2);
         this.and = null;
      }

      // $FF: synthetic method
      a(ov var1, or var2, Object var3) {
         this(var1, var2);
      }
   }
}
