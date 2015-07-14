package com.google.android.gms.internal;

public class lk {
   public static int a(byte[] var0, int var1, int var2, int var3) {
      int var5 = var1 + (var2 & -4);
      int var4 = var3;
      var3 = var1;

      for(var1 = var4; var3 < var5; var3 += 4) {
         var4 = (var0[var3] & 255 | (var0[var3 + 1] & 255) << 8 | (var0[var3 + 2] & 255) << 16 | var0[var3 + 3] << 24) * -862048943;
         var1 ^= (var4 >>> 17 | var4 << 15) * 461845907;
         var1 = -430675100 + (var1 >>> 19 | var1 << 13) * 5;
      }

      var4 = 0;
      var3 = 0;
      switch(var2 & 3) {
      case 3:
         var3 = (var0[var5 + 2] & 255) << 16;
      case 2:
         var4 = var3 | (var0[var5 + 1] & 255) << 8;
      case 1:
         var3 = (var4 | var0[var5] & 255) * -862048943;
         var1 ^= (var3 >>> 17 | var3 << 15) * 461845907;
      default:
         var1 ^= var2;
         var1 = (var1 ^ var1 >>> 16) * -2048144789;
         var1 = (var1 ^ var1 >>> 13) * -1028477387;
         return var1 ^ var1 >>> 16;
      }
   }
}
