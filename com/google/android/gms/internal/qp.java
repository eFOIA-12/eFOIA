package com.google.android.gms.internal;

import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qz;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class qp {
   private final int ayV;
   private final byte[] buffer;
   private int position;

   private qp(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.position = var2;
      this.ayV = var2 + var3;
   }

   public static int D(long var0) {
      return G(var0);
   }

   public static int E(long var0) {
      return G(I(var0));
   }

   public static int G(long var0) {
      return (-128L & var0) == 0L?1:((-16384L & var0) == 0L?2:((-2097152L & var0) == 0L?3:((-268435456L & var0) == 0L?4:((-34359738368L & var0) == 0L?5:((-4398046511104L & var0) == 0L?6:((-562949953421312L & var0) == 0L?7:((-72057594037927936L & var0) == 0L?8:((Long.MIN_VALUE & var0) == 0L?9:10))))))));
   }

   public static long I(long var0) {
      return var0 << 1 ^ var0 >> 63;
   }

   public static int X(boolean var0) {
      return 1;
   }

   public static int b(int var0, double var1) {
      return hc(var0) + f(var1);
   }

   public static int b(int var0, qw var1) {
      return hc(var0) * 2 + d(var1);
   }

   public static int b(int var0, byte[] var1) {
      return hc(var0) + s(var1);
   }

   public static qp b(byte[] var0, int var1, int var2) {
      return new qp(var0, var1, var2);
   }

   public static int c(int var0, float var1) {
      return hc(var0) + e(var1);
   }

   public static int c(int var0, qw var1) {
      return hc(var0) + e(var1);
   }

   public static int c(int var0, boolean var1) {
      return hc(var0) + X(var1);
   }

   public static int d(int var0, long var1) {
      return hc(var0) + D(var1);
   }

   public static int d(qw var0) {
      return var0.rZ();
   }

   public static int dk(String var0) {
      int var1;
      int var2;
      try {
         byte[] var4 = var0.getBytes("UTF-8");
         var1 = he(var4.length);
         var2 = var4.length;
      } catch (UnsupportedEncodingException var3) {
         throw new RuntimeException("UTF-8 not supported.");
      }

      return var2 + var1;
   }

   public static int e(float var0) {
      return 4;
   }

   public static int e(int var0, long var1) {
      return hc(var0) + E(var1);
   }

   public static int e(qw var0) {
      int var1 = var0.rZ();
      return var1 + he(var1);
   }

   public static int f(double var0) {
      return 8;
   }

   public static int gZ(int var0) {
      return var0 >= 0?he(var0):10;
   }

   public static int ha(int var0) {
      return he(hg(var0));
   }

   public static int hc(int var0) {
      return he(qz.y(var0, 0));
   }

   public static int he(int var0) {
      return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
   }

   public static int hg(int var0) {
      return var0 << 1 ^ var0 >> 31;
   }

   public static int j(int var0, String var1) {
      return hc(var0) + dk(var1);
   }

   public static qp q(byte[] var0) {
      return b(var0, 0, var0.length);
   }

   public static int s(byte[] var0) {
      return he(var0.length) + var0.length;
   }

   public static int v(int var0, int var1) {
      return hc(var0) + gZ(var1);
   }

   public static int w(int var0, int var1) {
      return hc(var0) + ha(var1);
   }

   public void B(long var1) throws IOException {
      this.F(var1);
   }

   public void C(long var1) throws IOException {
      this.F(I(var1));
   }

   public void F(long var1) throws IOException {
      while((-128L & var1) != 0L) {
         this.hb((int)var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.hb((int)var1);
   }

   public void H(long var1) throws IOException {
      this.hb((int)var1 & 255);
      this.hb((int)(var1 >> 8) & 255);
      this.hb((int)(var1 >> 16) & 255);
      this.hb((int)(var1 >> 24) & 255);
      this.hb((int)(var1 >> 32) & 255);
      this.hb((int)(var1 >> 40) & 255);
      this.hb((int)(var1 >> 48) & 255);
      this.hb((int)(var1 >> 56) & 255);
   }

   public void W(boolean var1) throws IOException {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.hb(var2);
   }

   public void a(int var1, double var2) throws IOException {
      this.x(var1, 1);
      this.e(var2);
   }

   public void a(int var1, qw var2) throws IOException {
      this.x(var1, 2);
      this.c(var2);
   }

   public void a(int var1, byte[] var2) throws IOException {
      this.x(var1, 2);
      this.r(var2);
   }

   public void b(byte var1) throws IOException {
      if(this.position == this.ayV) {
         throw new qp.a(this.position, this.ayV);
      } else {
         byte[] var3 = this.buffer;
         int var2 = this.position;
         this.position = var2 + 1;
         var3[var2] = var1;
      }
   }

   public void b(int var1, float var2) throws IOException {
      this.x(var1, 5);
      this.d(var2);
   }

   public void b(int var1, long var2) throws IOException {
      this.x(var1, 0);
      this.B(var2);
   }

   public void b(int var1, String var2) throws IOException {
      this.x(var1, 2);
      this.dj(var2);
   }

   public void b(int var1, boolean var2) throws IOException {
      this.x(var1, 0);
      this.W(var2);
   }

   public void b(qw var1) throws IOException {
      var1.a(this);
   }

   public void c(int var1, long var2) throws IOException {
      this.x(var1, 0);
      this.C(var2);
   }

   public void c(qw var1) throws IOException {
      this.hd(var1.rY());
      var1.a(this);
   }

   public void c(byte[] var1, int var2, int var3) throws IOException {
      if(this.ayV - this.position >= var3) {
         System.arraycopy(var1, var2, this.buffer, this.position, var3);
         this.position += var3;
      } else {
         throw new qp.a(this.position, this.ayV);
      }
   }

   public void d(float var1) throws IOException {
      this.hf(Float.floatToIntBits(var1));
   }

   public void dj(String var1) throws IOException {
      byte[] var2 = var1.getBytes("UTF-8");
      this.hd(var2.length);
      this.t(var2);
   }

   public void e(double var1) throws IOException {
      this.H(Double.doubleToLongBits(var1));
   }

   public void gX(int var1) throws IOException {
      if(var1 >= 0) {
         this.hd(var1);
      } else {
         this.F((long)var1);
      }
   }

   public void gY(int var1) throws IOException {
      this.hd(hg(var1));
   }

   public void hb(int var1) throws IOException {
      this.b((byte)var1);
   }

   public void hd(int var1) throws IOException {
      while((var1 & -128) != 0) {
         this.hb(var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.hb(var1);
   }

   public void hf(int var1) throws IOException {
      this.hb(var1 & 255);
      this.hb(var1 >> 8 & 255);
      this.hb(var1 >> 16 & 255);
      this.hb(var1 >> 24 & 255);
   }

   public void r(byte[] var1) throws IOException {
      this.hd(var1.length);
      this.t(var1);
   }

   public int rO() {
      return this.ayV - this.position;
   }

   public void rP() {
      if(this.rO() != 0) {
         throw new IllegalStateException("Did not write as much data as expected.");
      }
   }

   public void t(int var1, int var2) throws IOException {
      this.x(var1, 0);
      this.gX(var2);
   }

   public void t(byte[] var1) throws IOException {
      this.c(var1, 0, var1.length);
   }

   public void u(int var1, int var2) throws IOException {
      this.x(var1, 0);
      this.gY(var2);
   }

   public void x(int var1, int var2) throws IOException {
      this.hd(qz.y(var1, var2));
   }

   public static class a extends IOException {
      a(int var1, int var2) {
         super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + var1 + " limit " + var2 + ").");
      }
   }
}
