package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qz;
import java.io.IOException;

public interface mv {
   public static final class a extends qq {
      public mv.a[] afu;

      public a() {
         this.mW();
      }

      public void a(qp var1) throws IOException {
         if(this.afu != null && this.afu.length > 0) {
            for(int var2 = 0; var2 < this.afu.length; ++var2) {
               mv.a var3 = this.afu[var2];
               if(var3 != null) {
                  var1.a(1, (qw)var3);
               }
            }
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.n(var1);
      }

      protected int c() {
         int var1 = super.c();
         int var3 = var1;
         if(this.afu != null) {
            var3 = var1;
            if(this.afu.length > 0) {
               int var2 = 0;

               while(true) {
                  var3 = var1;
                  if(var2 >= this.afu.length) {
                     break;
                  }

                  mv.a var4 = this.afu[var2];
                  var3 = var1;
                  if(var4 != null) {
                     var3 = var1 + qp.c(1, var4);
                  }

                  ++var2;
                  var1 = var3;
               }
            }
         }

         return var3;
      }

      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2;
         if(var1 == this) {
            var2 = true;
         } else {
            var2 = var3;
            if(var1 instanceof mv.a) {
               mv.a var4 = (mv.a)var1;
               var2 = var3;
               if(qu.equals((Object[])this.afu, (Object[])var4.afu)) {
                  return this.a(var4);
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         return (qu.hashCode((Object[])this.afu) + 527) * 31 + this.rQ();
      }

      public mv.a mW() {
         this.afu = mv.a.mX();
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public mv.a n(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            mv.a[] var4;
            switch(var2) {
            case 10:
               var3 = qz.b(var1, 10);
               if(this.afu == null) {
                  var2 = 0;
               } else {
                  var2 = this.afu.length;
               }

               var4 = new mv.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.afu, 0, var4, 0, var2);
                  var3 = var2;
               }
               break;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var4.length - 1) {
               var4[var3] = new mv.a();
               var1.a(var4[var3]);
               var1.rz();
               ++var3;
            }

            var4[var3] = new mv.a();
            var1.a(var4[var3]);
            this.afu = var4;
         }
      }
   }

   public static final class a extends qq {
      private static volatile mv.a[] afv;
      public String afw;
      public String afx;
      public int viewId;

      public a() {
         this.mY();
      }

      public static mv.a[] mX() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         if(!this.afw.equals("")) {
            var1.b(1, (String)this.afw);
         }

         if(!this.afx.equals("")) {
            var1.b(2, (String)this.afx);
         }

         if(this.viewId != 0) {
            var1.t(3, this.viewId);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.o(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(!this.afw.equals("")) {
            var1 = var2 + qp.j(1, this.afw);
         }

         var2 = var1;
         if(!this.afx.equals("")) {
            var2 = var1 + qp.j(2, this.afx);
         }

         var1 = var2;
         if(this.viewId != 0) {
            var1 = var2 + qp.v(3, this.viewId);
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
            if(var1 instanceof mv.a) {
               mv.a var4 = (mv.a)var1;
               if(this.afw == null) {
                  var2 = var3;
                  if(var4.afw != null) {
                     return var2;
                  }
               } else if(!this.afw.equals(var4.afw)) {
                  return false;
               }

               if(this.afx == null) {
                  var2 = var3;
                  if(var4.afx != null) {
                     return var2;
                  }
               } else if(!this.afx.equals(var4.afx)) {
                  return false;
               }

               var2 = var3;
               if(this.viewId == var4.viewId) {
                  return this.a(var4);
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         int var2 = 0;
         int var1;
         if(this.afw == null) {
            var1 = 0;
         } else {
            var1 = this.afw.hashCode();
         }

         if(this.afx != null) {
            var2 = this.afx.hashCode();
         }

         return (((var1 + 527) * 31 + var2) * 31 + this.viewId) * 31 + this.rQ();
      }

      public mv.a mY() {
         this.afw = "";
         this.afx = "";
         this.viewId = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public mv.a o(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 10:
               this.afw = var1.readString();
               break;
            case 18:
               this.afx = var1.readString();
               break;
            case 24:
               this.viewId = var1.rC();
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
   }

   public static final class b extends qq {
      private static volatile mv.b[] afy;
      public mv.d afz;
      public String name;

      public b() {
         this.na();
      }

      public static mv.b[] mZ() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         if(!this.name.equals("")) {
            var1.b(1, (String)this.name);
         }

         if(this.afz != null) {
            var1.a(2, (qw)this.afz);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.p(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(!this.name.equals("")) {
            var1 = var2 + qp.j(1, this.name);
         }

         var2 = var1;
         if(this.afz != null) {
            var2 = var1 + qp.c(2, this.afz);
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
            if(var1 instanceof mv.b) {
               mv.b var4 = (mv.b)var1;
               if(this.name == null) {
                  var2 = var3;
                  if(var4.name != null) {
                     return var2;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.afz == null) {
                  var2 = var3;
                  if(var4.afz != null) {
                     return var2;
                  }
               } else if(!this.afz.equals(var4.afz)) {
                  return false;
               }

               return this.a(var4);
            }
         }

         return var2;
      }

      public int hashCode() {
         int var2 = 0;
         int var1;
         if(this.name == null) {
            var1 = 0;
         } else {
            var1 = this.name.hashCode();
         }

         if(this.afz != null) {
            var2 = this.afz.hashCode();
         }

         return ((var1 + 527) * 31 + var2) * 31 + this.rQ();
      }

      public mv.b na() {
         this.name = "";
         this.afz = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public mv.b p(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.afz == null) {
                  this.afz = new mv.d();
               }

               var1.a(this.afz);
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
   }

   public static final class c extends qq {
      public mv.b[] afA;
      public String type;

      public c() {
         this.nb();
      }

      public void a(qp var1) throws IOException {
         if(!this.type.equals("")) {
            var1.b(1, (String)this.type);
         }

         if(this.afA != null && this.afA.length > 0) {
            for(int var2 = 0; var2 < this.afA.length; ++var2) {
               mv.b var3 = this.afA[var2];
               if(var3 != null) {
                  var1.a(2, (qw)var3);
               }
            }
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.q(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(!this.type.equals("")) {
            var1 = var2 + qp.j(1, this.type);
         }

         var2 = var1;
         if(this.afA != null) {
            var2 = var1;
            if(this.afA.length > 0) {
               int var3;
               for(var2 = 0; var2 < this.afA.length; var1 = var3) {
                  mv.b var4 = this.afA[var2];
                  var3 = var1;
                  if(var4 != null) {
                     var3 = var1 + qp.c(2, var4);
                  }

                  ++var2;
               }

               var2 = var1;
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
            if(var1 instanceof mv.c) {
               mv.c var4 = (mv.c)var1;
               if(this.type == null) {
                  var2 = var3;
                  if(var4.type != null) {
                     return var2;
                  }
               } else if(!this.type.equals(var4.type)) {
                  return false;
               }

               var2 = var3;
               if(qu.equals((Object[])this.afA, (Object[])var4.afA)) {
                  return this.a(var4);
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         int var1;
         if(this.type == null) {
            var1 = 0;
         } else {
            var1 = this.type.hashCode();
         }

         return ((var1 + 527) * 31 + qu.hashCode((Object[])this.afA)) * 31 + this.rQ();
      }

      public mv.c nb() {
         this.type = "";
         this.afA = mv.b.mZ();
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public mv.c q(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            mv.b[] var4;
            switch(var2) {
            case 10:
               this.type = var1.readString();
               continue;
            case 18:
               var3 = qz.b(var1, 18);
               if(this.afA == null) {
                  var2 = 0;
               } else {
                  var2 = this.afA.length;
               }

               var4 = new mv.b[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.afA, 0, var4, 0, var2);
                  var3 = var2;
               }
               break;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var4.length - 1) {
               var4[var3] = new mv.b();
               var1.a(var4[var3]);
               var1.rz();
               ++var3;
            }

            var4[var3] = new mv.b();
            var1.a(var4[var3]);
            this.afA = var4;
         }
      }
   }

   public static final class d extends qq {
      public String NJ;
      public boolean afB;
      public long afC;
      public double afD;
      public mv.c afE;

      public d() {
         this.nc();
      }

      public void a(qp var1) throws IOException {
         if(this.afB) {
            var1.b(1, this.afB);
         }

         if(!this.NJ.equals("")) {
            var1.b(2, (String)this.NJ);
         }

         if(this.afC != 0L) {
            var1.b(3, this.afC);
         }

         if(Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0D)) {
            var1.a(4, this.afD);
         }

         if(this.afE != null) {
            var1.a(5, (qw)this.afE);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.r(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(this.afB) {
            var1 = var2 + qp.c(1, this.afB);
         }

         var2 = var1;
         if(!this.NJ.equals("")) {
            var2 = var1 + qp.j(2, this.NJ);
         }

         var1 = var2;
         if(this.afC != 0L) {
            var1 = var2 + qp.d(3, this.afC);
         }

         var2 = var1;
         if(Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0D)) {
            var2 = var1 + qp.b(4, this.afD);
         }

         var1 = var2;
         if(this.afE != null) {
            var1 = var2 + qp.c(5, this.afE);
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
            if(var1 instanceof mv.d) {
               mv.d var4 = (mv.d)var1;
               var2 = var3;
               if(this.afB == var4.afB) {
                  if(this.NJ == null) {
                     var2 = var3;
                     if(var4.NJ != null) {
                        return var2;
                     }
                  } else if(!this.NJ.equals(var4.NJ)) {
                     return false;
                  }

                  var2 = var3;
                  if(this.afC == var4.afC) {
                     var2 = var3;
                     if(Double.doubleToLongBits(this.afD) == Double.doubleToLongBits(var4.afD)) {
                        if(this.afE == null) {
                           var2 = var3;
                           if(var4.afE != null) {
                              return var2;
                           }
                        } else if(!this.afE.equals(var4.afE)) {
                           return false;
                        }

                        return this.a(var4);
                     }
                  }
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         int var3 = 0;
         short var1;
         if(this.afB) {
            var1 = 1231;
         } else {
            var1 = 1237;
         }

         int var2;
         if(this.NJ == null) {
            var2 = 0;
         } else {
            var2 = this.NJ.hashCode();
         }

         int var4 = (int)(this.afC ^ this.afC >>> 32);
         long var6 = Double.doubleToLongBits(this.afD);
         int var5 = (int)(var6 ^ var6 >>> 32);
         if(this.afE != null) {
            var3 = this.afE.hashCode();
         }

         return ((((var2 + (var1 + 527) * 31) * 31 + var4) * 31 + var5) * 31 + var3) * 31 + this.rQ();
      }

      public mv.d nc() {
         this.afB = false;
         this.NJ = "";
         this.afC = 0L;
         this.afD = 0.0D;
         this.afE = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public mv.d r(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 8:
               this.afB = var1.rD();
               break;
            case 18:
               this.NJ = var1.readString();
               break;
            case 24:
               this.afC = var1.rB();
               break;
            case 33:
               this.afD = var1.readDouble();
               break;
            case 42:
               if(this.afE == null) {
                  this.afE = new mv.c();
               }

               var1.a(this.afE);
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
   }
}
