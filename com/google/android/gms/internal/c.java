package com.google.android.gms.internal;

import com.google.android.gms.internal.d;
import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qr;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qz;
import java.io.IOException;

public interface c {
   public static final class a extends qq {
      public int fn;
      public int fo;
      public int level;

      public a() {
         this.b();
      }

      public c.a a(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 8:
               var2 = var1.rC();
               switch(var2) {
               case 1:
               case 2:
               case 3:
                  this.level = var2;
               default:
                  continue;
               }
            case 16:
               this.fn = var1.rC();
               break;
            case 24:
               this.fo = var1.rC();
               break;
            default:
               if(this.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }

      public void a(qp var1) throws IOException {
         if(this.level != 1) {
            var1.t(1, this.level);
         }

         if(this.fn != 0) {
            var1.t(2, this.fn);
         }

         if(this.fo != 0) {
            var1.t(3, this.fo);
         }

         super.a(var1);
      }

      public c.a b() {
         this.level = 1;
         this.fn = 0;
         this.fo = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.a(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(this.level != 1) {
            var1 = var2 + qp.v(1, this.level);
         }

         var2 = var1;
         if(this.fn != 0) {
            var2 = var1 + qp.v(2, this.fn);
         }

         var1 = var2;
         if(this.fo != 0) {
            var1 = var2 + qp.v(3, this.fo);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.a) {
               c.a var4 = (c.a)var1;
               var2 = var3;
               if(this.level == var4.level) {
                  var2 = var3;
                  if(this.fn == var4.fn) {
                     var2 = var3;
                     if(this.fo == var4.fo) {
                        return this.a((qq)var4);
                     }
                  }
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         return (((this.level + 527) * 31 + this.fn) * 31 + this.fo) * 31 + this.rQ();
      }
   }

   public static final class b extends qq {
      private static volatile c.b[] fp;
      public int[] fq;
      public int fr;
      public boolean fs;
      public boolean ft;
      public int name;

      public b() {
         this.e();
      }

      public static c.b[] d() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         if(this.ft) {
            var1.b(1, this.ft);
         }

         var1.t(2, this.fr);
         if(this.fq != null && this.fq.length > 0) {
            for(int var2 = 0; var2 < this.fq.length; ++var2) {
               var1.t(3, this.fq[var2]);
            }
         }

         if(this.name != 0) {
            var1.t(4, this.name);
         }

         if(this.fs) {
            var1.b(6, this.fs);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.c(var1);
      }

      protected int c() {
         int var2 = 0;
         int var3 = super.c();
         int var1 = var3;
         if(this.ft) {
            var1 = var3 + qp.c(1, this.ft);
         }

         var3 = qp.v(2, this.fr) + var1;
         if(this.fq != null && this.fq.length > 0) {
            for(var1 = 0; var1 < this.fq.length; ++var1) {
               var2 += qp.gZ(this.fq[var1]);
            }

            var2 = var3 + var2 + this.fq.length * 1;
         } else {
            var2 = var3;
         }

         var1 = var2;
         if(this.name != 0) {
            var1 = var2 + qp.v(4, this.name);
         }

         var2 = var1;
         if(this.fs) {
            var2 = var1 + qp.c(6, this.fs);
         }

         return var2;
      }

      public c.b c(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            int[] var5;
            switch(var2) {
            case 8:
               this.ft = var1.rD();
               continue;
            case 16:
               this.fr = var1.rC();
               continue;
            case 24:
               var3 = qz.b(var1, 24);
               if(this.fq == null) {
                  var2 = 0;
               } else {
                  var2 = this.fq.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fq, 0, var5, 0, var2);
                  var3 = var2;
               }
               break;
            case 26:
               int var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.fq == null) {
                  var2 = 0;
               } else {
                  var2 = this.fq.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fq, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.fq = var5;
               var1.gT(var4);
               continue;
            case 32:
               this.name = var1.rC();
               continue;
            case 48:
               this.fs = var1.rD();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var5.length - 1) {
               var5[var3] = var1.rC();
               var1.rz();
               ++var3;
            }

            var5[var3] = var1.rC();
            this.fq = var5;
         }
      }

      public c.b e() {
         this.fq = qz.azj;
         this.fr = 0;
         this.name = 0;
         this.fs = false;
         this.ft = false;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.b) {
               c.b var4 = (c.b)var1;
               var2 = var3;
               if(qu.equals(this.fq, var4.fq)) {
                  var2 = var3;
                  if(this.fr == var4.fr) {
                     var2 = var3;
                     if(this.name == var4.name) {
                        var2 = var3;
                        if(this.fs == var4.fs) {
                           var2 = var3;
                           if(this.ft == var4.ft) {
                              return this.a(var4);
                           }
                        }
                     }
                  }
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         short var2 = 1231;
         int var3 = qu.hashCode(this.fq);
         int var4 = this.fr;
         int var5 = this.name;
         short var1;
         if(this.fs) {
            var1 = 1231;
         } else {
            var1 = 1237;
         }

         if(!this.ft) {
            var2 = 1237;
         }

         return ((var1 + (((var3 + 527) * 31 + var4) * 31 + var5) * 31) * 31 + var2) * 31 + this.rQ();
      }
   }

   public static final class c extends qq {
      private static volatile c.c[] fu;
      public String fv;
      public long fw;
      public long fx;
      public boolean fy;
      public long fz;

      public c() {
         this.g();
      }

      public static c.c[] f() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         if(!this.fv.equals("")) {
            var1.b(1, (String)this.fv);
         }

         if(this.fw != 0L) {
            var1.b(2, this.fw);
         }

         if(this.fx != 2147483647L) {
            var1.b(3, this.fx);
         }

         if(this.fy) {
            var1.b(4, this.fy);
         }

         if(this.fz != 0L) {
            var1.b(5, this.fz);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.d(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(!this.fv.equals("")) {
            var1 = var2 + qp.j(1, this.fv);
         }

         var2 = var1;
         if(this.fw != 0L) {
            var2 = var1 + qp.d(2, this.fw);
         }

         var1 = var2;
         if(this.fx != 2147483647L) {
            var1 = var2 + qp.d(3, this.fx);
         }

         var2 = var1;
         if(this.fy) {
            var2 = var1 + qp.c(4, this.fy);
         }

         var1 = var2;
         if(this.fz != 0L) {
            var1 = var2 + qp.d(5, this.fz);
         }

         return var1;
      }

      public c.c d(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 10:
               this.fv = var1.readString();
               break;
            case 16:
               this.fw = var1.rB();
               break;
            case 24:
               this.fx = var1.rB();
               break;
            case 32:
               this.fy = var1.rD();
               break;
            case 40:
               this.fz = var1.rB();
               break;
            default:
               if(this.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.c) {
               c.c var4 = (c.c)var1;
               if(this.fv == null) {
                  var2 = var3;
                  if(var4.fv != null) {
                     return var2;
                  }
               } else if(!this.fv.equals(var4.fv)) {
                  return false;
               }

               var2 = var3;
               if(this.fw == var4.fw) {
                  var2 = var3;
                  if(this.fx == var4.fx) {
                     var2 = var3;
                     if(this.fy == var4.fy) {
                        var2 = var3;
                        if(this.fz == var4.fz) {
                           return this.a(var4);
                        }
                     }
                  }
               }
            }
         }

         return var2;
      }

      public c.c g() {
         this.fv = "";
         this.fw = 0L;
         this.fx = 2147483647L;
         this.fy = false;
         this.fz = 0L;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public int hashCode() {
         int var1;
         if(this.fv == null) {
            var1 = 0;
         } else {
            var1 = this.fv.hashCode();
         }

         int var3 = (int)(this.fw ^ this.fw >>> 32);
         int var4 = (int)(this.fx ^ this.fx >>> 32);
         short var2;
         if(this.fy) {
            var2 = 1231;
         } else {
            var2 = 1237;
         }

         return ((var2 + (((var1 + 527) * 31 + var3) * 31 + var4) * 31) * 31 + (int)(this.fz ^ this.fz >>> 32)) * 31 + this.rQ();
      }
   }

   public static final class d extends qq {
      public d.a[] fA;
      public d.a[] fB;
      public c.c[] fC;

      public d() {
         this.h();
      }

      public void a(qp var1) throws IOException {
         byte var3 = 0;
         int var2;
         d.a var4;
         if(this.fA != null && this.fA.length > 0) {
            for(var2 = 0; var2 < this.fA.length; ++var2) {
               var4 = this.fA[var2];
               if(var4 != null) {
                  var1.a(1, (qw)var4);
               }
            }
         }

         if(this.fB != null && this.fB.length > 0) {
            for(var2 = 0; var2 < this.fB.length; ++var2) {
               var4 = this.fB[var2];
               if(var4 != null) {
                  var1.a(2, (qw)var4);
               }
            }
         }

         if(this.fC != null && this.fC.length > 0) {
            for(var2 = var3; var2 < this.fC.length; ++var2) {
               c.c var5 = this.fC[var2];
               if(var5 != null) {
                  var1.a(3, (qw)var5);
               }
            }
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.e(var1);
      }

      protected int c() {
         byte var4 = 0;
         int var1 = super.c();
         int var2 = var1;
         int var3;
         d.a var5;
         if(this.fA != null) {
            var2 = var1;
            if(this.fA.length > 0) {
               for(var2 = 0; var2 < this.fA.length; var1 = var3) {
                  var5 = this.fA[var2];
                  var3 = var1;
                  if(var5 != null) {
                     var3 = var1 + qp.c(1, var5);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         if(this.fB != null) {
            var1 = var2;
            if(this.fB.length > 0) {
               var1 = var2;

               for(var2 = 0; var2 < this.fB.length; var1 = var3) {
                  var5 = this.fB[var2];
                  var3 = var1;
                  if(var5 != null) {
                     var3 = var1 + qp.c(2, var5);
                  }

                  ++var2;
               }
            }
         }

         var3 = var1;
         if(this.fC != null) {
            var3 = var1;
            if(this.fC.length > 0) {
               var2 = var4;

               while(true) {
                  var3 = var1;
                  if(var2 >= this.fC.length) {
                     break;
                  }

                  c.c var6 = this.fC[var2];
                  var3 = var1;
                  if(var6 != null) {
                     var3 = var1 + qp.c(3, var6);
                  }

                  ++var2;
                  var1 = var3;
               }
            }
         }

         return var3;
      }

      public c.d e(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            d.a[] var5;
            switch(var2) {
            case 10:
               var3 = qz.b(var1, 10);
               if(this.fA == null) {
                  var2 = 0;
               } else {
                  var2 = this.fA.length;
               }

               var5 = new d.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fA, 0, var5, 0, var2);
                  var3 = var2;
               }
               break;
            case 18:
               var3 = qz.b(var1, 18);
               if(this.fB == null) {
                  var2 = 0;
               } else {
                  var2 = this.fB.length;
               }

               var5 = new d.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fB, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = new d.a();
                  var1.a(var5[var3]);
                  var1.rz();
                  ++var3;
               }

               var5[var3] = new d.a();
               var1.a(var5[var3]);
               this.fB = var5;
               continue;
            case 26:
               var3 = qz.b(var1, 26);
               if(this.fC == null) {
                  var2 = 0;
               } else {
                  var2 = this.fC.length;
               }

               c.c[] var4 = new c.c[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fC, 0, var4, 0, var2);
                  var3 = var2;
               }

               while(var3 < var4.length - 1) {
                  var4[var3] = new c.c();
                  var1.a(var4[var3]);
                  var1.rz();
                  ++var3;
               }

               var4[var3] = new c.c();
               var1.a(var4[var3]);
               this.fC = var4;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var5.length - 1) {
               var5[var3] = new d.a();
               var1.a(var5[var3]);
               var1.rz();
               ++var3;
            }

            var5[var3] = new d.a();
            var1.a(var5[var3]);
            this.fA = var5;
         }
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.d) {
               c.d var4 = (c.d)var1;
               var2 = var3;
               if(qu.equals((Object[])this.fA, (Object[])var4.fA)) {
                  var2 = var3;
                  if(qu.equals((Object[])this.fB, (Object[])var4.fB)) {
                     var2 = var3;
                     if(qu.equals((Object[])this.fC, (Object[])var4.fC)) {
                        return this.a(var4);
                     }
                  }
               }
            }
         }

         return var2;
      }

      public c.d h() {
         this.fA = d.a.r();
         this.fB = d.a.r();
         this.fC = c.c.f();
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public int hashCode() {
         return (((qu.hashCode((Object[])this.fA) + 527) * 31 + qu.hashCode((Object[])this.fB)) * 31 + qu.hashCode((Object[])this.fC)) * 31 + this.rQ();
      }
   }

   public static final class e extends qq {
      private static volatile c.e[] fD;
      public int key;
      public int value;

      public e() {
         this.j();
      }

      public static c.e[] i() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         var1.t(1, this.key);
         var1.t(2, this.value);
         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.f(var1);
      }

      protected int c() {
         return super.c() + qp.v(1, this.key) + qp.v(2, this.value);
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.e) {
               c.e var4 = (c.e)var1;
               var2 = var3;
               if(this.key == var4.key) {
                  var2 = var3;
                  if(this.value == var4.value) {
                     return this.a(var4);
                  }
               }
            }
         }

         return var2;
      }

      public c.e f(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 8:
               this.key = var1.rC();
               break;
            case 16:
               this.value = var1.rC();
               break;
            default:
               if(this.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }

      public int hashCode() {
         return ((this.key + 527) * 31 + this.value) * 31 + this.rQ();
      }

      public c.e j() {
         this.key = 0;
         this.value = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class f extends qq {
      public String[] fE;
      public String[] fF;
      public d.a[] fG;
      public c.e[] fH;
      public c.b[] fI;
      public c.b[] fJ;
      public c.b[] fK;
      public c.g[] fL;
      public String fM;
      public String fN;
      public String fO;
      public c.a fP;
      public float fQ;
      public boolean fR;
      public String[] fS;
      public int fT;
      public String version;

      public f() {
         this.k();
      }

      public static c.f a(byte[] var0) throws qv {
         return (c.f)qw.a(new c.f(), var0);
      }

      public void a(qp var1) throws IOException {
         byte var3 = 0;
         int var2;
         String var4;
         if(this.fF != null && this.fF.length > 0) {
            for(var2 = 0; var2 < this.fF.length; ++var2) {
               var4 = this.fF[var2];
               if(var4 != null) {
                  var1.b(1, (String)var4);
               }
            }
         }

         if(this.fG != null && this.fG.length > 0) {
            for(var2 = 0; var2 < this.fG.length; ++var2) {
               d.a var5 = this.fG[var2];
               if(var5 != null) {
                  var1.a(2, (qw)var5);
               }
            }
         }

         if(this.fH != null && this.fH.length > 0) {
            for(var2 = 0; var2 < this.fH.length; ++var2) {
               c.e var6 = this.fH[var2];
               if(var6 != null) {
                  var1.a(3, (qw)var6);
               }
            }
         }

         c.b var7;
         if(this.fI != null && this.fI.length > 0) {
            for(var2 = 0; var2 < this.fI.length; ++var2) {
               var7 = this.fI[var2];
               if(var7 != null) {
                  var1.a(4, (qw)var7);
               }
            }
         }

         if(this.fJ != null && this.fJ.length > 0) {
            for(var2 = 0; var2 < this.fJ.length; ++var2) {
               var7 = this.fJ[var2];
               if(var7 != null) {
                  var1.a(5, (qw)var7);
               }
            }
         }

         if(this.fK != null && this.fK.length > 0) {
            for(var2 = 0; var2 < this.fK.length; ++var2) {
               var7 = this.fK[var2];
               if(var7 != null) {
                  var1.a(6, (qw)var7);
               }
            }
         }

         if(this.fL != null && this.fL.length > 0) {
            for(var2 = 0; var2 < this.fL.length; ++var2) {
               c.g var8 = this.fL[var2];
               if(var8 != null) {
                  var1.a(7, (qw)var8);
               }
            }
         }

         if(!this.fM.equals("")) {
            var1.b(9, (String)this.fM);
         }

         if(!this.fN.equals("")) {
            var1.b(10, (String)this.fN);
         }

         if(!this.fO.equals("0")) {
            var1.b(12, (String)this.fO);
         }

         if(!this.version.equals("")) {
            var1.b(13, (String)this.version);
         }

         if(this.fP != null) {
            var1.a(14, (qw)this.fP);
         }

         if(Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0F)) {
            var1.b(15, this.fQ);
         }

         if(this.fS != null && this.fS.length > 0) {
            for(var2 = 0; var2 < this.fS.length; ++var2) {
               var4 = this.fS[var2];
               if(var4 != null) {
                  var1.b(16, (String)var4);
               }
            }
         }

         if(this.fT != 0) {
            var1.t(17, this.fT);
         }

         if(this.fR) {
            var1.b(18, this.fR);
         }

         if(this.fE != null && this.fE.length > 0) {
            for(var2 = var3; var2 < this.fE.length; ++var2) {
               var4 = this.fE[var2];
               if(var4 != null) {
                  var1.b(19, (String)var4);
               }
            }
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.g(var1);
      }

      protected int c() {
         byte var7 = 0;
         int var6 = super.c();
         int var1;
         int var2;
         int var3;
         int var4;
         int var5;
         String var8;
         if(this.fF != null && this.fF.length > 0) {
            var1 = 0;
            var2 = 0;

            for(var3 = 0; var1 < this.fF.length; var3 = var4) {
               var8 = this.fF[var1];
               var5 = var2;
               var4 = var3;
               if(var8 != null) {
                  var4 = var3 + 1;
                  var5 = var2 + qp.dk(var8);
               }

               ++var1;
               var2 = var5;
            }

            var2 = var6 + var2 + var3 * 1;
         } else {
            var2 = var6;
         }

         var1 = var2;
         if(this.fG != null) {
            var1 = var2;
            if(this.fG.length > 0) {
               var1 = var2;

               for(var2 = 0; var2 < this.fG.length; var1 = var3) {
                  d.a var9 = this.fG[var2];
                  var3 = var1;
                  if(var9 != null) {
                     var3 = var1 + qp.c(2, var9);
                  }

                  ++var2;
               }
            }
         }

         var2 = var1;
         if(this.fH != null) {
            var2 = var1;
            if(this.fH.length > 0) {
               for(var2 = 0; var2 < this.fH.length; var1 = var3) {
                  c.e var10 = this.fH[var2];
                  var3 = var1;
                  if(var10 != null) {
                     var3 = var1 + qp.c(3, var10);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         c.b var11;
         if(this.fI != null) {
            var1 = var2;
            if(this.fI.length > 0) {
               var1 = var2;

               for(var2 = 0; var2 < this.fI.length; var1 = var3) {
                  var11 = this.fI[var2];
                  var3 = var1;
                  if(var11 != null) {
                     var3 = var1 + qp.c(4, var11);
                  }

                  ++var2;
               }
            }
         }

         var2 = var1;
         if(this.fJ != null) {
            var2 = var1;
            if(this.fJ.length > 0) {
               for(var2 = 0; var2 < this.fJ.length; var1 = var3) {
                  var11 = this.fJ[var2];
                  var3 = var1;
                  if(var11 != null) {
                     var3 = var1 + qp.c(5, var11);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         if(this.fK != null) {
            var1 = var2;
            if(this.fK.length > 0) {
               var1 = var2;

               for(var2 = 0; var2 < this.fK.length; var1 = var3) {
                  var11 = this.fK[var2];
                  var3 = var1;
                  if(var11 != null) {
                     var3 = var1 + qp.c(6, var11);
                  }

                  ++var2;
               }
            }
         }

         var2 = var1;
         if(this.fL != null) {
            var2 = var1;
            if(this.fL.length > 0) {
               for(var2 = 0; var2 < this.fL.length; var1 = var3) {
                  c.g var12 = this.fL[var2];
                  var3 = var1;
                  if(var12 != null) {
                     var3 = var1 + qp.c(7, var12);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         if(!this.fM.equals("")) {
            var1 = var2 + qp.j(9, this.fM);
         }

         var2 = var1;
         if(!this.fN.equals("")) {
            var2 = var1 + qp.j(10, this.fN);
         }

         var1 = var2;
         if(!this.fO.equals("0")) {
            var1 = var2 + qp.j(12, this.fO);
         }

         var2 = var1;
         if(!this.version.equals("")) {
            var2 = var1 + qp.j(13, this.version);
         }

         var3 = var2;
         if(this.fP != null) {
            var3 = var2 + qp.c(14, this.fP);
         }

         var1 = var3;
         if(Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0F)) {
            var1 = var3 + qp.c(15, this.fQ);
         }

         var2 = var1;
         if(this.fS != null) {
            var2 = var1;
            if(this.fS.length > 0) {
               var2 = 0;
               var3 = 0;

               for(var4 = 0; var2 < this.fS.length; var4 = var5) {
                  var8 = this.fS[var2];
                  var6 = var3;
                  var5 = var4;
                  if(var8 != null) {
                     var5 = var4 + 1;
                     var6 = var3 + qp.dk(var8);
                  }

                  ++var2;
                  var3 = var6;
               }

               var2 = var1 + var3 + var4 * 2;
            }
         }

         var3 = var2;
         if(this.fT != 0) {
            var3 = var2 + qp.v(17, this.fT);
         }

         var1 = var3;
         if(this.fR) {
            var1 = var3 + qp.c(18, this.fR);
         }

         var2 = var1;
         if(this.fE != null) {
            var2 = var1;
            if(this.fE.length > 0) {
               var3 = 0;
               var4 = 0;

               for(var2 = var7; var2 < this.fE.length; var4 = var5) {
                  var8 = this.fE[var2];
                  var6 = var3;
                  var5 = var4;
                  if(var8 != null) {
                     var5 = var4 + 1;
                     var6 = var3 + qp.dk(var8);
                  }

                  ++var2;
                  var3 = var6;
               }

               var2 = var1 + var3 + var4 * 2;
            }
         }

         return var2;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.f) {
               c.f var4 = (c.f)var1;
               var2 = var3;
               if(qu.equals((Object[])this.fE, (Object[])var4.fE)) {
                  var2 = var3;
                  if(qu.equals((Object[])this.fF, (Object[])var4.fF)) {
                     var2 = var3;
                     if(qu.equals((Object[])this.fG, (Object[])var4.fG)) {
                        var2 = var3;
                        if(qu.equals((Object[])this.fH, (Object[])var4.fH)) {
                           var2 = var3;
                           if(qu.equals((Object[])this.fI, (Object[])var4.fI)) {
                              var2 = var3;
                              if(qu.equals((Object[])this.fJ, (Object[])var4.fJ)) {
                                 var2 = var3;
                                 if(qu.equals((Object[])this.fK, (Object[])var4.fK)) {
                                    var2 = var3;
                                    if(qu.equals((Object[])this.fL, (Object[])var4.fL)) {
                                       if(this.fM == null) {
                                          var2 = var3;
                                          if(var4.fM != null) {
                                             return var2;
                                          }
                                       } else if(!this.fM.equals(var4.fM)) {
                                          return false;
                                       }

                                       if(this.fN == null) {
                                          var2 = var3;
                                          if(var4.fN != null) {
                                             return var2;
                                          }
                                       } else if(!this.fN.equals(var4.fN)) {
                                          return false;
                                       }

                                       if(this.fO == null) {
                                          var2 = var3;
                                          if(var4.fO != null) {
                                             return var2;
                                          }
                                       } else if(!this.fO.equals(var4.fO)) {
                                          return false;
                                       }

                                       if(this.version == null) {
                                          var2 = var3;
                                          if(var4.version != null) {
                                             return var2;
                                          }
                                       } else if(!this.version.equals(var4.version)) {
                                          return false;
                                       }

                                       if(this.fP == null) {
                                          var2 = var3;
                                          if(var4.fP != null) {
                                             return var2;
                                          }
                                       } else if(!this.fP.equals(var4.fP)) {
                                          return false;
                                       }

                                       var2 = var3;
                                       if(Float.floatToIntBits(this.fQ) == Float.floatToIntBits(var4.fQ)) {
                                          var2 = var3;
                                          if(this.fR == var4.fR) {
                                             var2 = var3;
                                             if(qu.equals((Object[])this.fS, (Object[])var4.fS)) {
                                                var2 = var3;
                                                if(this.fT == var4.fT) {
                                                   return this.a((qq)var4);
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var2;
      }

      public c.f g(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            String[] var4;
            c.b[] var6;
            switch(var2) {
            case 10:
               var3 = qz.b(var1, 10);
               if(this.fF == null) {
                  var2 = 0;
               } else {
                  var2 = this.fF.length;
               }

               var4 = new String[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fF, 0, var4, 0, var2);
                  var3 = var2;
               }
               break;
            case 18:
               var3 = qz.b(var1, 18);
               if(this.fG == null) {
                  var2 = 0;
               } else {
                  var2 = this.fG.length;
               }

               d.a[] var8 = new d.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fG, 0, var8, 0, var2);
                  var3 = var2;
               }

               while(var3 < var8.length - 1) {
                  var8[var3] = new d.a();
                  var1.a(var8[var3]);
                  var1.rz();
                  ++var3;
               }

               var8[var3] = new d.a();
               var1.a(var8[var3]);
               this.fG = var8;
               continue;
            case 26:
               var3 = qz.b(var1, 26);
               if(this.fH == null) {
                  var2 = 0;
               } else {
                  var2 = this.fH.length;
               }

               c.e[] var7 = new c.e[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fH, 0, var7, 0, var2);
                  var3 = var2;
               }

               while(var3 < var7.length - 1) {
                  var7[var3] = new c.e();
                  var1.a(var7[var3]);
                  var1.rz();
                  ++var3;
               }

               var7[var3] = new c.e();
               var1.a(var7[var3]);
               this.fH = var7;
               continue;
            case 34:
               var3 = qz.b(var1, 34);
               if(this.fI == null) {
                  var2 = 0;
               } else {
                  var2 = this.fI.length;
               }

               var6 = new c.b[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fI, 0, var6, 0, var2);
                  var3 = var2;
               }

               while(var3 < var6.length - 1) {
                  var6[var3] = new c.b();
                  var1.a(var6[var3]);
                  var1.rz();
                  ++var3;
               }

               var6[var3] = new c.b();
               var1.a(var6[var3]);
               this.fI = var6;
               continue;
            case 42:
               var3 = qz.b(var1, 42);
               if(this.fJ == null) {
                  var2 = 0;
               } else {
                  var2 = this.fJ.length;
               }

               var6 = new c.b[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fJ, 0, var6, 0, var2);
                  var3 = var2;
               }

               while(var3 < var6.length - 1) {
                  var6[var3] = new c.b();
                  var1.a(var6[var3]);
                  var1.rz();
                  ++var3;
               }

               var6[var3] = new c.b();
               var1.a(var6[var3]);
               this.fJ = var6;
               continue;
            case 50:
               var3 = qz.b(var1, 50);
               if(this.fK == null) {
                  var2 = 0;
               } else {
                  var2 = this.fK.length;
               }

               var6 = new c.b[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fK, 0, var6, 0, var2);
                  var3 = var2;
               }

               while(var3 < var6.length - 1) {
                  var6[var3] = new c.b();
                  var1.a(var6[var3]);
                  var1.rz();
                  ++var3;
               }

               var6[var3] = new c.b();
               var1.a(var6[var3]);
               this.fK = var6;
               continue;
            case 58:
               var3 = qz.b(var1, 58);
               if(this.fL == null) {
                  var2 = 0;
               } else {
                  var2 = this.fL.length;
               }

               c.g[] var5 = new c.g[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fL, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = new c.g();
                  var1.a(var5[var3]);
                  var1.rz();
                  ++var3;
               }

               var5[var3] = new c.g();
               var1.a(var5[var3]);
               this.fL = var5;
               continue;
            case 74:
               this.fM = var1.readString();
               continue;
            case 82:
               this.fN = var1.readString();
               continue;
            case 98:
               this.fO = var1.readString();
               continue;
            case 106:
               this.version = var1.readString();
               continue;
            case 114:
               if(this.fP == null) {
                  this.fP = new c.a();
               }

               var1.a(this.fP);
               continue;
            case 125:
               this.fQ = var1.readFloat();
               continue;
            case 130:
               var3 = qz.b(var1, 130);
               if(this.fS == null) {
                  var2 = 0;
               } else {
                  var2 = this.fS.length;
               }

               var4 = new String[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fS, 0, var4, 0, var2);
                  var3 = var2;
               }

               while(var3 < var4.length - 1) {
                  var4[var3] = var1.readString();
                  var1.rz();
                  ++var3;
               }

               var4[var3] = var1.readString();
               this.fS = var4;
               continue;
            case 136:
               this.fT = var1.rC();
               continue;
            case 144:
               this.fR = var1.rD();
               continue;
            case 154:
               var3 = qz.b(var1, 154);
               if(this.fE == null) {
                  var2 = 0;
               } else {
                  var2 = this.fE.length;
               }

               var4 = new String[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fE, 0, var4, 0, var2);
                  var3 = var2;
               }

               while(var3 < var4.length - 1) {
                  var4[var3] = var1.readString();
                  var1.rz();
                  ++var3;
               }

               var4[var3] = var1.readString();
               this.fE = var4;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var4.length - 1) {
               var4[var3] = var1.readString();
               var1.rz();
               ++var3;
            }

            var4[var3] = var1.readString();
            this.fF = var4;
         }
      }

      public int hashCode() {
         int var5 = 0;
         int var7 = qu.hashCode((Object[])this.fE);
         int var8 = qu.hashCode((Object[])this.fF);
         int var9 = qu.hashCode((Object[])this.fG);
         int var10 = qu.hashCode((Object[])this.fH);
         int var11 = qu.hashCode((Object[])this.fI);
         int var12 = qu.hashCode((Object[])this.fJ);
         int var13 = qu.hashCode((Object[])this.fK);
         int var14 = qu.hashCode((Object[])this.fL);
         int var1;
         if(this.fM == null) {
            var1 = 0;
         } else {
            var1 = this.fM.hashCode();
         }

         int var2;
         if(this.fN == null) {
            var2 = 0;
         } else {
            var2 = this.fN.hashCode();
         }

         int var3;
         if(this.fO == null) {
            var3 = 0;
         } else {
            var3 = this.fO.hashCode();
         }

         int var4;
         if(this.version == null) {
            var4 = 0;
         } else {
            var4 = this.version.hashCode();
         }

         if(this.fP != null) {
            var5 = this.fP.hashCode();
         }

         int var15 = Float.floatToIntBits(this.fQ);
         short var6;
         if(this.fR) {
            var6 = 1231;
         } else {
            var6 = 1237;
         }

         return (((var6 + (((var4 + (var3 + (var2 + (var1 + ((((((((var7 + 527) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + var11) * 31 + var12) * 31 + var13) * 31 + var14) * 31) * 31) * 31) * 31) * 31 + var5) * 31 + var15) * 31) * 31 + qu.hashCode((Object[])this.fS)) * 31 + this.fT) * 31 + this.rQ();
      }

      public c.f k() {
         this.fE = qz.azo;
         this.fF = qz.azo;
         this.fG = d.a.r();
         this.fH = c.e.i();
         this.fI = c.b.d();
         this.fJ = c.b.d();
         this.fK = c.b.d();
         this.fL = c.g.l();
         this.fM = "";
         this.fN = "";
         this.fO = "0";
         this.version = "";
         this.fP = null;
         this.fQ = 0.0F;
         this.fR = false;
         this.fS = qz.azo;
         this.fT = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class g extends qq {
      private static volatile c.g[] fU;
      public int[] fV;
      public int[] fW;
      public int[] fX;
      public int[] fY;
      public int[] fZ;
      public int[] ga;
      public int[] gb;
      public int[] gc;
      public int[] gd;
      public int[] ge;

      public g() {
         this.m();
      }

      public static c.g[] l() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         byte var3 = 0;
         int var2;
         if(this.fV != null && this.fV.length > 0) {
            for(var2 = 0; var2 < this.fV.length; ++var2) {
               var1.t(1, this.fV[var2]);
            }
         }

         if(this.fW != null && this.fW.length > 0) {
            for(var2 = 0; var2 < this.fW.length; ++var2) {
               var1.t(2, this.fW[var2]);
            }
         }

         if(this.fX != null && this.fX.length > 0) {
            for(var2 = 0; var2 < this.fX.length; ++var2) {
               var1.t(3, this.fX[var2]);
            }
         }

         if(this.fY != null && this.fY.length > 0) {
            for(var2 = 0; var2 < this.fY.length; ++var2) {
               var1.t(4, this.fY[var2]);
            }
         }

         if(this.fZ != null && this.fZ.length > 0) {
            for(var2 = 0; var2 < this.fZ.length; ++var2) {
               var1.t(5, this.fZ[var2]);
            }
         }

         if(this.ga != null && this.ga.length > 0) {
            for(var2 = 0; var2 < this.ga.length; ++var2) {
               var1.t(6, this.ga[var2]);
            }
         }

         if(this.gb != null && this.gb.length > 0) {
            for(var2 = 0; var2 < this.gb.length; ++var2) {
               var1.t(7, this.gb[var2]);
            }
         }

         if(this.gc != null && this.gc.length > 0) {
            for(var2 = 0; var2 < this.gc.length; ++var2) {
               var1.t(8, this.gc[var2]);
            }
         }

         if(this.gd != null && this.gd.length > 0) {
            for(var2 = 0; var2 < this.gd.length; ++var2) {
               var1.t(9, this.gd[var2]);
            }
         }

         if(this.ge != null && this.ge.length > 0) {
            for(var2 = var3; var2 < this.ge.length; ++var2) {
               var1.t(10, this.ge[var2]);
            }
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.h(var1);
      }

      protected int c() {
         byte var4 = 0;
         int var3 = super.c();
         int var1;
         int var2;
         if(this.fV != null && this.fV.length > 0) {
            var1 = 0;

            for(var2 = 0; var1 < this.fV.length; ++var1) {
               var2 += qp.gZ(this.fV[var1]);
            }

            var2 = var3 + var2 + this.fV.length * 1;
         } else {
            var2 = var3;
         }

         var1 = var2;
         if(this.fW != null) {
            var1 = var2;
            if(this.fW.length > 0) {
               var1 = 0;

               for(var3 = 0; var1 < this.fW.length; ++var1) {
                  var3 += qp.gZ(this.fW[var1]);
               }

               var1 = var2 + var3 + this.fW.length * 1;
            }
         }

         var2 = var1;
         if(this.fX != null) {
            var2 = var1;
            if(this.fX.length > 0) {
               var2 = 0;

               for(var3 = 0; var2 < this.fX.length; ++var2) {
                  var3 += qp.gZ(this.fX[var2]);
               }

               var2 = var1 + var3 + this.fX.length * 1;
            }
         }

         var1 = var2;
         if(this.fY != null) {
            var1 = var2;
            if(this.fY.length > 0) {
               var1 = 0;

               for(var3 = 0; var1 < this.fY.length; ++var1) {
                  var3 += qp.gZ(this.fY[var1]);
               }

               var1 = var2 + var3 + this.fY.length * 1;
            }
         }

         var2 = var1;
         if(this.fZ != null) {
            var2 = var1;
            if(this.fZ.length > 0) {
               var2 = 0;

               for(var3 = 0; var2 < this.fZ.length; ++var2) {
                  var3 += qp.gZ(this.fZ[var2]);
               }

               var2 = var1 + var3 + this.fZ.length * 1;
            }
         }

         var1 = var2;
         if(this.ga != null) {
            var1 = var2;
            if(this.ga.length > 0) {
               var1 = 0;

               for(var3 = 0; var1 < this.ga.length; ++var1) {
                  var3 += qp.gZ(this.ga[var1]);
               }

               var1 = var2 + var3 + this.ga.length * 1;
            }
         }

         var2 = var1;
         if(this.gb != null) {
            var2 = var1;
            if(this.gb.length > 0) {
               var2 = 0;

               for(var3 = 0; var2 < this.gb.length; ++var2) {
                  var3 += qp.gZ(this.gb[var2]);
               }

               var2 = var1 + var3 + this.gb.length * 1;
            }
         }

         var1 = var2;
         if(this.gc != null) {
            var1 = var2;
            if(this.gc.length > 0) {
               var1 = 0;

               for(var3 = 0; var1 < this.gc.length; ++var1) {
                  var3 += qp.gZ(this.gc[var1]);
               }

               var1 = var2 + var3 + this.gc.length * 1;
            }
         }

         var2 = var1;
         if(this.gd != null) {
            var2 = var1;
            if(this.gd.length > 0) {
               var2 = 0;

               for(var3 = 0; var2 < this.gd.length; ++var2) {
                  var3 += qp.gZ(this.gd[var2]);
               }

               var2 = var1 + var3 + this.gd.length * 1;
            }
         }

         var1 = var2;
         if(this.ge != null) {
            var1 = var2;
            if(this.ge.length > 0) {
               var3 = 0;

               for(var1 = var4; var1 < this.ge.length; ++var1) {
                  var3 += qp.gZ(this.ge[var1]);
               }

               var1 = var2 + var3 + this.ge.length * 1;
            }
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.g) {
               c.g var4 = (c.g)var1;
               var2 = var3;
               if(qu.equals(this.fV, var4.fV)) {
                  var2 = var3;
                  if(qu.equals(this.fW, var4.fW)) {
                     var2 = var3;
                     if(qu.equals(this.fX, var4.fX)) {
                        var2 = var3;
                        if(qu.equals(this.fY, var4.fY)) {
                           var2 = var3;
                           if(qu.equals(this.fZ, var4.fZ)) {
                              var2 = var3;
                              if(qu.equals(this.ga, var4.ga)) {
                                 var2 = var3;
                                 if(qu.equals(this.gb, var4.gb)) {
                                    var2 = var3;
                                    if(qu.equals(this.gc, var4.gc)) {
                                       var2 = var3;
                                       if(qu.equals(this.gd, var4.gd)) {
                                          var2 = var3;
                                          if(qu.equals(this.ge, var4.ge)) {
                                             return this.a(var4);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var2;
      }

      public c.g h(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            int var4;
            int[] var5;
            switch(var2) {
            case 8:
               var3 = qz.b(var1, 8);
               if(this.fV == null) {
                  var2 = 0;
               } else {
                  var2 = this.fV.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fV, 0, var5, 0, var2);
                  var3 = var2;
               }
               break;
            case 10:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.fV == null) {
                  var2 = 0;
               } else {
                  var2 = this.fV.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fV, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.fV = var5;
               var1.gT(var4);
               continue;
            case 16:
               var3 = qz.b(var1, 16);
               if(this.fW == null) {
                  var2 = 0;
               } else {
                  var2 = this.fW.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fW, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.fW = var5;
               continue;
            case 18:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.fW == null) {
                  var2 = 0;
               } else {
                  var2 = this.fW.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fW, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.fW = var5;
               var1.gT(var4);
               continue;
            case 24:
               var3 = qz.b(var1, 24);
               if(this.fX == null) {
                  var2 = 0;
               } else {
                  var2 = this.fX.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fX, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.fX = var5;
               continue;
            case 26:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.fX == null) {
                  var2 = 0;
               } else {
                  var2 = this.fX.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fX, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.fX = var5;
               var1.gT(var4);
               continue;
            case 32:
               var3 = qz.b(var1, 32);
               if(this.fY == null) {
                  var2 = 0;
               } else {
                  var2 = this.fY.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fY, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.fY = var5;
               continue;
            case 34:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.fY == null) {
                  var2 = 0;
               } else {
                  var2 = this.fY.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fY, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.fY = var5;
               var1.gT(var4);
               continue;
            case 40:
               var3 = qz.b(var1, 40);
               if(this.fZ == null) {
                  var2 = 0;
               } else {
                  var2 = this.fZ.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fZ, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.fZ = var5;
               continue;
            case 42:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.fZ == null) {
                  var2 = 0;
               } else {
                  var2 = this.fZ.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.fZ, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.fZ = var5;
               var1.gT(var4);
               continue;
            case 48:
               var3 = qz.b(var1, 48);
               if(this.ga == null) {
                  var2 = 0;
               } else {
                  var2 = this.ga.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ga, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.ga = var5;
               continue;
            case 50:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.ga == null) {
                  var2 = 0;
               } else {
                  var2 = this.ga.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ga, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.ga = var5;
               var1.gT(var4);
               continue;
            case 56:
               var3 = qz.b(var1, 56);
               if(this.gb == null) {
                  var2 = 0;
               } else {
                  var2 = this.gb.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gb, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.gb = var5;
               continue;
            case 58:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.gb == null) {
                  var2 = 0;
               } else {
                  var2 = this.gb.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gb, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.gb = var5;
               var1.gT(var4);
               continue;
            case 64:
               var3 = qz.b(var1, 64);
               if(this.gc == null) {
                  var2 = 0;
               } else {
                  var2 = this.gc.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gc, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.gc = var5;
               continue;
            case 66:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.gc == null) {
                  var2 = 0;
               } else {
                  var2 = this.gc.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gc, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.gc = var5;
               var1.gT(var4);
               continue;
            case 72:
               var3 = qz.b(var1, 72);
               if(this.gd == null) {
                  var2 = 0;
               } else {
                  var2 = this.gd.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gd, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.gd = var5;
               continue;
            case 74:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.gd == null) {
                  var2 = 0;
               } else {
                  var2 = this.gd.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gd, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.gd = var5;
               var1.gT(var4);
               continue;
            case 80:
               var3 = qz.b(var1, 80);
               if(this.ge == null) {
                  var2 = 0;
               } else {
                  var2 = this.ge.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ge, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.ge = var5;
               continue;
            case 82:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.ge == null) {
                  var2 = 0;
               } else {
                  var2 = this.ge.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ge, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.ge = var5;
               var1.gT(var4);
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var5.length - 1) {
               var5[var3] = var1.rC();
               var1.rz();
               ++var3;
            }

            var5[var3] = var1.rC();
            this.fV = var5;
         }
      }

      public int hashCode() {
         return ((((((((((qu.hashCode(this.fV) + 527) * 31 + qu.hashCode(this.fW)) * 31 + qu.hashCode(this.fX)) * 31 + qu.hashCode(this.fY)) * 31 + qu.hashCode(this.fZ)) * 31 + qu.hashCode(this.ga)) * 31 + qu.hashCode(this.gb)) * 31 + qu.hashCode(this.gc)) * 31 + qu.hashCode(this.gd)) * 31 + qu.hashCode(this.ge)) * 31 + this.rQ();
      }

      public c.g m() {
         this.fV = qz.azj;
         this.fW = qz.azj;
         this.fX = qz.azj;
         this.fY = qz.azj;
         this.fZ = qz.azj;
         this.ga = qz.azj;
         this.gb = qz.azj;
         this.gc = qz.azj;
         this.gd = qz.azj;
         this.ge = qz.azj;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class h extends qq {
      public static final qr gf = qr.a(11, c.h.class, 810);
      private static final c.h[] gg = new c.h[0];
      public int[] gh;
      public int[] gi;
      public int[] gj;
      public int gk;
      public int[] gl;
      public int gm;
      public int gn;

      public h() {
         this.n();
      }

      public void a(qp var1) throws IOException {
         byte var3 = 0;
         int var2;
         if(this.gh != null && this.gh.length > 0) {
            for(var2 = 0; var2 < this.gh.length; ++var2) {
               var1.t(1, this.gh[var2]);
            }
         }

         if(this.gi != null && this.gi.length > 0) {
            for(var2 = 0; var2 < this.gi.length; ++var2) {
               var1.t(2, this.gi[var2]);
            }
         }

         if(this.gj != null && this.gj.length > 0) {
            for(var2 = 0; var2 < this.gj.length; ++var2) {
               var1.t(3, this.gj[var2]);
            }
         }

         if(this.gk != 0) {
            var1.t(4, this.gk);
         }

         if(this.gl != null && this.gl.length > 0) {
            for(var2 = var3; var2 < this.gl.length; ++var2) {
               var1.t(5, this.gl[var2]);
            }
         }

         if(this.gm != 0) {
            var1.t(6, this.gm);
         }

         if(this.gn != 0) {
            var1.t(7, this.gn);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.i(var1);
      }

      protected int c() {
         byte var4 = 0;
         int var3 = super.c();
         int var1;
         int var2;
         if(this.gh != null && this.gh.length > 0) {
            var1 = 0;

            for(var2 = 0; var1 < this.gh.length; ++var1) {
               var2 += qp.gZ(this.gh[var1]);
            }

            var2 = var3 + var2 + this.gh.length * 1;
         } else {
            var2 = var3;
         }

         var1 = var2;
         if(this.gi != null) {
            var1 = var2;
            if(this.gi.length > 0) {
               var1 = 0;

               for(var3 = 0; var1 < this.gi.length; ++var1) {
                  var3 += qp.gZ(this.gi[var1]);
               }

               var1 = var2 + var3 + this.gi.length * 1;
            }
         }

         var2 = var1;
         if(this.gj != null) {
            var2 = var1;
            if(this.gj.length > 0) {
               var2 = 0;

               for(var3 = 0; var2 < this.gj.length; ++var2) {
                  var3 += qp.gZ(this.gj[var2]);
               }

               var2 = var1 + var3 + this.gj.length * 1;
            }
         }

         var1 = var2;
         if(this.gk != 0) {
            var1 = var2 + qp.v(4, this.gk);
         }

         var2 = var1;
         if(this.gl != null) {
            var2 = var1;
            if(this.gl.length > 0) {
               var3 = 0;

               for(var2 = var4; var2 < this.gl.length; ++var2) {
                  var3 += qp.gZ(this.gl[var2]);
               }

               var2 = var1 + var3 + this.gl.length * 1;
            }
         }

         var1 = var2;
         if(this.gm != 0) {
            var1 = var2 + qp.v(6, this.gm);
         }

         var2 = var1;
         if(this.gn != 0) {
            var2 = var1 + qp.v(7, this.gn);
         }

         return var2;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.h) {
               c.h var4 = (c.h)var1;
               var2 = var3;
               if(qu.equals(this.gh, var4.gh)) {
                  var2 = var3;
                  if(qu.equals(this.gi, var4.gi)) {
                     var2 = var3;
                     if(qu.equals(this.gj, var4.gj)) {
                        var2 = var3;
                        if(this.gk == var4.gk) {
                           var2 = var3;
                           if(qu.equals(this.gl, var4.gl)) {
                              var2 = var3;
                              if(this.gm == var4.gm) {
                                 var2 = var3;
                                 if(this.gn == var4.gn) {
                                    return this.a(var4);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         return (((((((qu.hashCode(this.gh) + 527) * 31 + qu.hashCode(this.gi)) * 31 + qu.hashCode(this.gj)) * 31 + this.gk) * 31 + qu.hashCode(this.gl)) * 31 + this.gm) * 31 + this.gn) * 31 + this.rQ();
      }

      public c.h i(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            int var4;
            int[] var5;
            switch(var2) {
            case 8:
               var3 = qz.b(var1, 8);
               if(this.gh == null) {
                  var2 = 0;
               } else {
                  var2 = this.gh.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gh, 0, var5, 0, var2);
                  var3 = var2;
               }
               break;
            case 10:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.gh == null) {
                  var2 = 0;
               } else {
                  var2 = this.gh.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gh, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.gh = var5;
               var1.gT(var4);
               continue;
            case 16:
               var3 = qz.b(var1, 16);
               if(this.gi == null) {
                  var2 = 0;
               } else {
                  var2 = this.gi.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gi, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.gi = var5;
               continue;
            case 18:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.gi == null) {
                  var2 = 0;
               } else {
                  var2 = this.gi.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gi, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.gi = var5;
               var1.gT(var4);
               continue;
            case 24:
               var3 = qz.b(var1, 24);
               if(this.gj == null) {
                  var2 = 0;
               } else {
                  var2 = this.gj.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gj, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.gj = var5;
               continue;
            case 26:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.gj == null) {
                  var2 = 0;
               } else {
                  var2 = this.gj.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gj, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.gj = var5;
               var1.gT(var4);
               continue;
            case 32:
               this.gk = var1.rC();
               continue;
            case 40:
               var3 = qz.b(var1, 40);
               if(this.gl == null) {
                  var2 = 0;
               } else {
                  var2 = this.gl.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gl, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.gl = var5;
               continue;
            case 42:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.gl == null) {
                  var2 = 0;
               } else {
                  var2 = this.gl.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gl, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.gl = var5;
               var1.gT(var4);
               continue;
            case 48:
               this.gm = var1.rC();
               continue;
            case 56:
               this.gn = var1.rC();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var5.length - 1) {
               var5[var3] = var1.rC();
               var1.rz();
               ++var3;
            }

            var5[var3] = var1.rC();
            this.gh = var5;
         }
      }

      public c.h n() {
         this.gh = qz.azj;
         this.gi = qz.azj;
         this.gj = qz.azj;
         this.gk = 0;
         this.gl = qz.azj;
         this.gm = 0;
         this.gn = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class i extends qq {
      private static volatile c.i[] go;
      public d.a gp;
      public c.d gq;
      public String name;

      public i() {
         this.p();
      }

      public static c.i[] o() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         if(!this.name.equals("")) {
            var1.b(1, (String)this.name);
         }

         if(this.gp != null) {
            var1.a(2, (qw)this.gp);
         }

         if(this.gq != null) {
            var1.a(3, (qw)this.gq);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.j(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(!this.name.equals("")) {
            var1 = var2 + qp.j(1, this.name);
         }

         var2 = var1;
         if(this.gp != null) {
            var2 = var1 + qp.c(2, this.gp);
         }

         var1 = var2;
         if(this.gq != null) {
            var1 = var2 + qp.c(3, this.gq);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.i) {
               c.i var4 = (c.i)var1;
               if(this.name == null) {
                  var2 = var3;
                  if(var4.name != null) {
                     return var2;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.gp == null) {
                  var2 = var3;
                  if(var4.gp != null) {
                     return var2;
                  }
               } else if(!this.gp.equals(var4.gp)) {
                  return false;
               }

               if(this.gq == null) {
                  var2 = var3;
                  if(var4.gq != null) {
                     return var2;
                  }
               } else if(!this.gq.equals(var4.gq)) {
                  return false;
               }

               return this.a(var4);
            }
         }

         return var2;
      }

      public int hashCode() {
         int var3 = 0;
         int var1;
         if(this.name == null) {
            var1 = 0;
         } else {
            var1 = this.name.hashCode();
         }

         int var2;
         if(this.gp == null) {
            var2 = 0;
         } else {
            var2 = this.gp.hashCode();
         }

         if(this.gq != null) {
            var3 = this.gq.hashCode();
         }

         return ((var2 + (var1 + 527) * 31) * 31 + var3) * 31 + this.rQ();
      }

      public c.i j(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.gp == null) {
                  this.gp = new d.a();
               }

               var1.a(this.gp);
               break;
            case 26:
               if(this.gq == null) {
                  this.gq = new c.d();
               }

               var1.a(this.gq);
               break;
            default:
               if(this.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }

      public c.i p() {
         this.name = "";
         this.gp = null;
         this.gq = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class j extends qq {
      public c.i[] gr;
      public c.f gs;
      public String gt;

      public j() {
         this.q();
      }

      public static c.j b(byte[] var0) throws qv {
         return (c.j)qw.a(new c.j(), var0);
      }

      public void a(qp var1) throws IOException {
         if(this.gr != null && this.gr.length > 0) {
            for(int var2 = 0; var2 < this.gr.length; ++var2) {
               c.i var3 = this.gr[var2];
               if(var3 != null) {
                  var1.a(1, (qw)var3);
               }
            }
         }

         if(this.gs != null) {
            var1.a(2, (qw)this.gs);
         }

         if(!this.gt.equals("")) {
            var1.b(3, (String)this.gt);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.k(var1);
      }

      protected int c() {
         int var1 = super.c();
         int var2 = var1;
         if(this.gr != null) {
            var2 = var1;
            if(this.gr.length > 0) {
               int var3 = 0;

               while(true) {
                  var2 = var1;
                  if(var3 >= this.gr.length) {
                     break;
                  }

                  c.i var4 = this.gr[var3];
                  var2 = var1;
                  if(var4 != null) {
                     var2 = var1 + qp.c(1, var4);
                  }

                  ++var3;
                  var1 = var2;
               }
            }
         }

         var1 = var2;
         if(this.gs != null) {
            var1 = var2 + qp.c(2, this.gs);
         }

         var2 = var1;
         if(!this.gt.equals("")) {
            var2 = var1 + qp.j(3, this.gt);
         }

         return var2;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof c.j) {
               c.j var4 = (c.j)var1;
               var2 = var3;
               if(qu.equals((Object[])this.gr, (Object[])var4.gr)) {
                  if(this.gs == null) {
                     var2 = var3;
                     if(var4.gs != null) {
                        return var2;
                     }
                  } else if(!this.gs.equals(var4.gs)) {
                     return false;
                  }

                  if(this.gt == null) {
                     var2 = var3;
                     if(var4.gt != null) {
                        return var2;
                     }
                  } else if(!this.gt.equals(var4.gt)) {
                     return false;
                  }

                  return this.a(var4);
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         int var2 = 0;
         int var3 = qu.hashCode((Object[])this.gr);
         int var1;
         if(this.gs == null) {
            var1 = 0;
         } else {
            var1 = this.gs.hashCode();
         }

         if(this.gt != null) {
            var2 = this.gt.hashCode();
         }

         return ((var1 + (var3 + 527) * 31) * 31 + var2) * 31 + this.rQ();
      }

      public c.j k(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            c.i[] var4;
            switch(var2) {
            case 10:
               var3 = qz.b(var1, 10);
               if(this.gr == null) {
                  var2 = 0;
               } else {
                  var2 = this.gr.length;
               }

               var4 = new c.i[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gr, 0, var4, 0, var2);
                  var3 = var2;
               }
               break;
            case 18:
               if(this.gs == null) {
                  this.gs = new c.f();
               }

               var1.a(this.gs);
               continue;
            case 26:
               this.gt = var1.readString();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var4.length - 1) {
               var4[var3] = new c.i();
               var1.a(var4[var3]);
               var1.rz();
               ++var3;
            }

            var4[var3] = new c.i();
            var1.a(var4[var3]);
            this.gr = var4;
         }
      }

      public c.j q() {
         this.gr = c.i.o();
         this.gs = null;
         this.gt = "";
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }
}
