package com.google.android.gms.internal;

import com.google.android.gms.internal.qp;
import java.io.IOException;
import java.util.Arrays;

final class qy {
   final byte[] azi;
   final int tag;

   qy(int var1, byte[] var2) {
      this.tag = var1;
      this.azi = var2;
   }

   void a(qp var1) throws IOException {
      var1.hd(this.tag);
      var1.t(this.azi);
   }

   int c() {
      return 0 + qp.he(this.tag) + this.azi.length;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof qy)) {
            return false;
         }

         qy var2 = (qy)var1;
         if(this.tag != var2.tag || !Arrays.equals(this.azi, var2.azi)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return (this.tag + 527) * 31 + Arrays.hashCode(this.azi);
   }
}
