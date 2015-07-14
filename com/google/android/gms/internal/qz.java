package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import java.io.IOException;

public final class qz {
   public static final int[] azj = new int[0];
   public static final long[] azk = new long[0];
   public static final float[] azl = new float[0];
   public static final double[] azm = new double[0];
   public static final boolean[] azn = new boolean[0];
   public static final String[] azo = new String[0];
   public static final byte[][] azp = new byte[0][];
   public static final byte[] azq = new byte[0];

   public static final int b(qo var0, int var1) throws IOException {
      int var2 = 1;
      int var3 = var0.getPosition();
      var0.gQ(var1);

      while(var0.rz() == var1) {
         var0.gQ(var1);
         ++var2;
      }

      var0.gU(var3);
      return var2;
   }

   static int hk(int var0) {
      return var0 & 7;
   }

   public static int hl(int var0) {
      return var0 >>> 3;
   }

   static int y(int var0, int var1) {
      return var0 << 3 | var1;
   }
}
