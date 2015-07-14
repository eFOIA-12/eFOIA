package com.google.android.gms.internal;

import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qz;
import java.io.IOException;

public final class qo {
   private int ayM;
   private int ayN;
   private int ayO;
   private int ayP;
   private int ayQ;
   private int ayR = Integer.MAX_VALUE;
   private int ayS;
   private int ayT = 64;
   private int ayU = 67108864;
   private final byte[] buffer;

   private qo(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.ayM = var2;
      this.ayN = var2 + var3;
      this.ayP = var2;
   }

   public static long A(long var0) {
      return var0 >>> 1 ^ -(1L & var0);
   }

   public static qo a(byte[] var0, int var1, int var2) {
      return new qo(var0, var1, var2);
   }

   public static int gR(int var0) {
      return var0 >>> 1 ^ -(var0 & 1);
   }

   public static qo p(byte[] var0) {
      return a(var0, 0, var0.length);
   }

   private void rK() {
      this.ayN += this.ayO;
      int var1 = this.ayN;
      if(var1 > this.ayR) {
         this.ayO = var1 - this.ayR;
         this.ayN -= this.ayO;
      } else {
         this.ayO = 0;
      }
   }

   public void a(qw var1) throws IOException {
      int var2 = this.rG();
      if(this.ayS >= this.ayT) {
         throw qv.rX();
      } else {
         var2 = this.gS(var2);
         ++this.ayS;
         var1.b(this);
         this.gP(0);
         --this.ayS;
         this.gT(var2);
      }
   }

   public void a(qw var1, int var2) throws IOException {
      if(this.ayS >= this.ayT) {
         throw qv.rX();
      } else {
         ++this.ayS;
         var1.b(this);
         this.gP(qz.y(var2, 4));
         --this.ayS;
      }
   }

   public void gP(int var1) throws qv {
      if(this.ayQ != var1) {
         throw qv.rV();
      }
   }

   public boolean gQ(int var1) throws IOException {
      switch(qz.hk(var1)) {
      case 0:
         this.rC();
         return true;
      case 1:
         this.rJ();
         return true;
      case 2:
         this.gW(this.rG());
         return true;
      case 3:
         this.rA();
         this.gP(qz.y(qz.hl(var1), 4));
         return true;
      case 4:
         return false;
      case 5:
         this.rI();
         return true;
      default:
         throw qv.rW();
      }
   }

   public int gS(int var1) throws qv {
      if(var1 < 0) {
         throw qv.rS();
      } else {
         var1 += this.ayP;
         int var2 = this.ayR;
         if(var1 > var2) {
            throw qv.rR();
         } else {
            this.ayR = var1;
            this.rK();
            return var2;
         }
      }
   }

   public void gT(int var1) {
      this.ayR = var1;
      this.rK();
   }

   public void gU(int var1) {
      if(var1 > this.ayP - this.ayM) {
         throw new IllegalArgumentException("Position " + var1 + " is beyond current " + (this.ayP - this.ayM));
      } else if(var1 < 0) {
         throw new IllegalArgumentException("Bad position " + var1);
      } else {
         this.ayP = this.ayM + var1;
      }
   }

   public byte[] gV(int var1) throws IOException {
      if(var1 < 0) {
         throw qv.rS();
      } else if(this.ayP + var1 > this.ayR) {
         this.gW(this.ayR - this.ayP);
         throw qv.rR();
      } else if(var1 <= this.ayN - this.ayP) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.ayP, var2, 0, var1);
         this.ayP += var1;
         return var2;
      } else {
         throw qv.rR();
      }
   }

   public void gW(int var1) throws IOException {
      if(var1 < 0) {
         throw qv.rS();
      } else if(this.ayP + var1 > this.ayR) {
         this.gW(this.ayR - this.ayP);
         throw qv.rR();
      } else if(var1 <= this.ayN - this.ayP) {
         this.ayP += var1;
      } else {
         throw qv.rR();
      }
   }

   public int getPosition() {
      return this.ayP - this.ayM;
   }

   public void rA() throws IOException {
      int var1;
      do {
         var1 = this.rz();
      } while(var1 != 0 && this.gQ(var1));

   }

   public long rB() throws IOException {
      return this.rH();
   }

   public int rC() throws IOException {
      return this.rG();
   }

   public boolean rD() throws IOException {
      return this.rG() != 0;
   }

   public int rE() throws IOException {
      return gR(this.rG());
   }

   public long rF() throws IOException {
      return A(this.rH());
   }

   public int rG() throws IOException {
      int var1 = this.rN();
      if(var1 < 0) {
         var1 &= 127;
         byte var2 = this.rN();
         if(var2 >= 0) {
            return var1 | var2 << 7;
         }

         var1 |= (var2 & 127) << 7;
         var2 = this.rN();
         if(var2 >= 0) {
            return var1 | var2 << 14;
         }

         var1 |= (var2 & 127) << 14;
         byte var3 = this.rN();
         if(var3 >= 0) {
            return var1 | var3 << 21;
         }

         var2 = this.rN();
         int var5 = var1 | (var3 & 127) << 21 | var2 << 28;
         var1 = var5;
         if(var2 < 0) {
            int var4 = 0;

            while(true) {
               if(var4 >= 5) {
                  throw qv.rT();
               }

               var1 = var5;
               if(this.rN() >= 0) {
                  break;
               }

               ++var4;
            }
         }
      }

      return var1;
   }

   public long rH() throws IOException {
      int var1 = 0;

      for(long var3 = 0L; var1 < 64; var1 += 7) {
         byte var2 = this.rN();
         var3 |= (long)(var2 & 127) << var1;
         if((var2 & 128) == 0) {
            return var3;
         }
      }

      throw qv.rT();
   }

   public int rI() throws IOException {
      return this.rN() & 255 | (this.rN() & 255) << 8 | (this.rN() & 255) << 16 | (this.rN() & 255) << 24;
   }

   public long rJ() throws IOException {
      byte var1 = this.rN();
      byte var2 = this.rN();
      byte var3 = this.rN();
      byte var4 = this.rN();
      byte var5 = this.rN();
      byte var6 = this.rN();
      byte var7 = this.rN();
      byte var8 = this.rN();
      long var9 = (long)var1;
      return ((long)var2 & 255L) << 8 | var9 & 255L | ((long)var3 & 255L) << 16 | ((long)var4 & 255L) << 24 | ((long)var5 & 255L) << 32 | ((long)var6 & 255L) << 40 | ((long)var7 & 255L) << 48 | ((long)var8 & 255L) << 56;
   }

   public int rL() {
      if(this.ayR == Integer.MAX_VALUE) {
         return -1;
      } else {
         int var1 = this.ayP;
         return this.ayR - var1;
      }
   }

   public boolean rM() {
      return this.ayP == this.ayN;
   }

   public byte rN() throws IOException {
      if(this.ayP == this.ayN) {
         throw qv.rR();
      } else {
         byte[] var2 = this.buffer;
         int var1 = this.ayP;
         this.ayP = var1 + 1;
         return var2[var1];
      }
   }

   public byte[] readBytes() throws IOException {
      int var1 = this.rG();
      if(var1 <= this.ayN - this.ayP && var1 > 0) {
         byte[] var2 = new byte[var1];
         System.arraycopy(this.buffer, this.ayP, var2, 0, var1);
         this.ayP += var1;
         return var2;
      } else {
         return this.gV(var1);
      }
   }

   public double readDouble() throws IOException {
      return Double.longBitsToDouble(this.rJ());
   }

   public float readFloat() throws IOException {
      return Float.intBitsToFloat(this.rI());
   }

   public String readString() throws IOException {
      int var1 = this.rG();
      if(var1 <= this.ayN - this.ayP && var1 > 0) {
         String var2 = new String(this.buffer, this.ayP, var1, "UTF-8");
         this.ayP += var1;
         return var2;
      } else {
         return new String(this.gV(var1), "UTF-8");
      }
   }

   public int rz() throws IOException {
      if(this.rM()) {
         this.ayQ = 0;
         return 0;
      } else {
         this.ayQ = this.rG();
         if(this.ayQ == 0) {
            throw qv.rU();
         } else {
            return this.ayQ;
         }
      }
   }

   public byte[] s(int var1, int var2) {
      if(var2 == 0) {
         return qz.azq;
      } else {
         byte[] var4 = new byte[var2];
         int var3 = this.ayM;
         System.arraycopy(this.buffer, var3 + var1, var4, 0, var2);
         return var4;
      }
   }
}
