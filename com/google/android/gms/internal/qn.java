package com.google.android.gms.internal;

public class qn {
   private final byte[] ayJ = new byte[256];
   private int ayK;
   private int ayL;

   public qn(byte[] var1) {
      int var3;
      for(var3 = 0; var3 < 256; ++var3) {
         this.ayJ[var3] = (byte)var3;
      }

      int var4 = 0;

      for(var3 = 0; var3 < 256; ++var3) {
         var4 = var4 + this.ayJ[var3] + var1[var3 % var1.length] & 255;
         byte var2 = this.ayJ[var3];
         this.ayJ[var3] = this.ayJ[var4];
         this.ayJ[var4] = var2;
      }

      this.ayK = 0;
      this.ayL = 0;
   }

   public void o(byte[] var1) {
      int var5 = this.ayK;
      int var4 = this.ayL;

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var5 = var5 + 1 & 255;
         var4 = var4 + this.ayJ[var5] & 255;
         byte var2 = this.ayJ[var5];
         this.ayJ[var5] = this.ayJ[var4];
         this.ayJ[var4] = var2;
         var1[var3] ^= this.ayJ[this.ayJ[var5] + this.ayJ[var4] & 255];
      }

      this.ayK = var5;
      this.ayL = var4;
   }
}
