package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qx;
import java.io.IOException;

public abstract class qw {
   protected volatile int azh = -1;

   public static final qw a(qw var0, byte[] var1) throws qv {
      return b(var0, var1, 0, var1.length);
   }

   public static final void a(qw var0, byte[] var1, int var2, int var3) {
      try {
         qp var5 = qp.b(var1, var2, var3);
         var0.a(var5);
         var5.rP();
      } catch (IOException var4) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var4);
      }
   }

   public static final qw b(qw var0, byte[] var1, int var2, int var3) throws qv {
      try {
         qo var6 = qo.a(var1, var2, var3);
         var0.b(var6);
         var6.gP(0);
         return var0;
      } catch (qv var4) {
         throw var4;
      } catch (IOException var5) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
      }
   }

   public static final byte[] f(qw var0) {
      byte[] var1 = new byte[var0.rZ()];
      a(var0, var1, 0, var1.length);
      return var1;
   }

   public void a(qp var1) throws IOException {
   }

   public abstract qw b(qo var1) throws IOException;

   protected int c() {
      return 0;
   }

   public int rY() {
      if(this.azh < 0) {
         this.rZ();
      }

      return this.azh;
   }

   public int rZ() {
      int var1 = this.c();
      this.azh = var1;
      return var1;
   }

   public String toString() {
      return qx.g(this);
   }
}
