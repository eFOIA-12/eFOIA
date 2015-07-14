package com.google.android.gms.tagmanager;

class j {
   public static byte[] co(String var0) {
      int var2 = var0.length();
      if(var2 % 2 != 0) {
         throw new IllegalArgumentException("purported base16 string has odd number of characters");
      } else {
         byte[] var5 = new byte[var2 / 2];

         for(int var1 = 0; var1 < var2; var1 += 2) {
            int var3 = Character.digit(var0.charAt(var1), 16);
            int var4 = Character.digit(var0.charAt(var1 + 1), 16);
            if(var3 == -1 || var4 == -1) {
               throw new IllegalArgumentException("purported base16 string has illegal char");
            }

            var5[var1 / 2] = (byte)((var3 << 4) + var4);
         }

         return var5;
      }
   }

   public static String d(byte[] var0) {
      StringBuilder var4 = new StringBuilder();
      int var2 = var0.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         byte var3 = var0[var1];
         if((var3 & 240) == 0) {
            var4.append("0");
         }

         var4.append(Integer.toHexString(var3 & 255));
      }

      return var4.toString().toUpperCase();
   }
}
