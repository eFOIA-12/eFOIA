package com.google.android.gms.internal;

import com.google.android.gms.internal.n;
import com.google.android.gms.internal.qp;
import java.io.IOException;

class p implements n {
   private qp lb;
   private byte[] lc;
   private final int ld;

   public p(int var1) {
      this.ld = var1;
      this.reset();
   }

   public byte[] D() throws IOException {
      int var1 = this.lb.rO();
      if(var1 < 0) {
         throw new IOException();
      } else if(var1 == 0) {
         return this.lc;
      } else {
         byte[] var2 = new byte[this.lc.length - var1];
         System.arraycopy(this.lc, 0, var2, 0, var2.length);
         return var2;
      }
   }

   public void b(int var1, long var2) throws IOException {
      this.lb.b(var1, var2);
   }

   public void b(int var1, String var2) throws IOException {
      this.lb.b(var1, var2);
   }

   public void reset() {
      this.lc = new byte[this.ld];
      this.lb = qp.q(this.lc);
   }
}
