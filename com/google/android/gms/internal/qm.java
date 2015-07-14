package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qz;
import java.io.IOException;
import java.util.Arrays;

public final class qm extends qq {
   public qm.a[] ayq;

   public qm() {
      this.rt();
   }

   public static qm n(byte[] var0) throws qv {
      return (qm)qw.a(new qm(), var0);
   }

   public void a(qp var1) throws IOException {
      if(this.ayq != null && this.ayq.length > 0) {
         for(int var2 = 0; var2 < this.ayq.length; ++var2) {
            qm.a var3 = this.ayq[var2];
            if(var3 != null) {
               var1.a(1, (qw)var3);
            }
         }
      }

      super.a(var1);
   }

   // $FF: synthetic method
   public qw b(qo var1) throws IOException {
      return this.t(var1);
   }

   protected int c() {
      int var1 = super.c();
      int var3 = var1;
      if(this.ayq != null) {
         var3 = var1;
         if(this.ayq.length > 0) {
            int var2 = 0;

            while(true) {
               var3 = var1;
               if(var2 >= this.ayq.length) {
                  break;
               }

               qm.a var4 = this.ayq[var2];
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
         if(var1 instanceof qm) {
            qm var4 = (qm)var1;
            var2 = var3;
            if(qu.equals((Object[])this.ayq, (Object[])var4.ayq)) {
               return this.a(var4);
            }
         }
      }

      return var2;
   }

   public int hashCode() {
      return (qu.hashCode((Object[])this.ayq) + 527) * 31 + this.rQ();
   }

   public qm rt() {
      this.ayq = qm.a.ru();
      this.ayW = null;
      this.azh = -1;
      return this;
   }

   public qm t(qo var1) throws IOException {
      while(true) {
         int var2 = var1.rz();
         int var3;
         qm.a[] var4;
         switch(var2) {
         case 10:
            var3 = qz.b(var1, 10);
            if(this.ayq == null) {
               var2 = 0;
            } else {
               var2 = this.ayq.length;
            }

            var4 = new qm.a[var3 + var2];
            var3 = var2;
            if(var2 != 0) {
               System.arraycopy(this.ayq, 0, var4, 0, var2);
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
            var4[var3] = new qm.a();
            var1.a(var4[var3]);
            var1.rz();
            ++var3;
         }

         var4[var3] = new qm.a();
         var1.a(var4[var3]);
         this.ayq = var4;
      }
   }

   public static final class a extends qq {
      private static volatile qm.a[] ayr;
      public qm.a ays;
      public String name;

      public a() {
         this.rv();
      }

      public static qm.a[] ru() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         var1.b(1, (String)this.name);
         if(this.ays != null) {
            var1.a(2, (qw)this.ays);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.u(var1);
      }

      protected int c() {
         int var2 = super.c() + qp.j(1, this.name);
         int var1 = var2;
         if(this.ays != null) {
            var1 = var2 + qp.c(2, this.ays);
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
            if(var1 instanceof qm.a) {
               qm.a var4 = (qm.a)var1;
               if(this.name == null) {
                  var2 = var3;
                  if(var4.name != null) {
                     return var2;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.ays == null) {
                  var2 = var3;
                  if(var4.ays != null) {
                     return var2;
                  }
               } else if(!this.ays.equals(var4.ays)) {
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

         if(this.ays != null) {
            var2 = this.ays.hashCode();
         }

         return ((var1 + 527) * 31 + var2) * 31 + this.rQ();
      }

      public qm.a rv() {
         this.name = "";
         this.ays = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public qm.a u(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.ays == null) {
                  this.ays = new qm.a();
               }

               var1.a(this.ays);
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

   public static final class a extends qq {
      private static volatile qm.a[] ayt;
      public qm.a ayu;
      public int type;

      public a() {
         this.rx();
      }

      public static qm.a[] rw() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         var1.t(1, this.type);
         if(this.ayu != null) {
            var1.a(2, (qw)this.ayu);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.v(var1);
      }

      protected int c() {
         int var2 = super.c() + qp.v(1, this.type);
         int var1 = var2;
         if(this.ayu != null) {
            var1 = var2 + qp.c(2, this.ayu);
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
            if(var1 instanceof qm.a) {
               qm.a var4 = (qm.a)var1;
               var2 = var3;
               if(this.type == var4.type) {
                  if(this.ayu == null) {
                     var2 = var3;
                     if(var4.ayu != null) {
                        return var2;
                     }
                  } else if(!this.ayu.equals(var4.ayu)) {
                     return false;
                  }

                  return this.a(var4);
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         int var2 = this.type;
         int var1;
         if(this.ayu == null) {
            var1 = 0;
         } else {
            var1 = this.ayu.hashCode();
         }

         return (var1 + (var2 + 527) * 31) * 31 + this.rQ();
      }

      public qm.a rx() {
         this.type = 1;
         this.ayu = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public qm.a v(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 8:
               var2 = var1.rC();
               switch(var2) {
               case 1:
               case 2:
               case 3:
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
               case 9:
               case 10:
               case 11:
               case 12:
               case 13:
               case 14:
               case 15:
                  this.type = var2;
               default:
                  continue;
               }
            case 18:
               if(this.ayu == null) {
                  this.ayu = new qm.a();
               }

               var1.a(this.ayu);
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

   public static final class a extends qq {
      public int ayA;
      public int ayB;
      public boolean ayC;
      public qm.a[] ayD;
      public qm.a[] ayE;
      public String[] ayF;
      public long[] ayG;
      public float[] ayH;
      public long ayI;
      public byte[] ayv;
      public String ayw;
      public double ayx;
      public float ayy;
      public long ayz;

      public a() {
         this.ry();
      }

      public void a(qp var1) throws IOException {
         byte var3 = 0;
         if(!Arrays.equals(this.ayv, qz.azq)) {
            var1.a(1, (byte[])this.ayv);
         }

         if(!this.ayw.equals("")) {
            var1.b(2, (String)this.ayw);
         }

         if(Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0D)) {
            var1.a(3, this.ayx);
         }

         if(Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0F)) {
            var1.b(4, this.ayy);
         }

         if(this.ayz != 0L) {
            var1.b(5, this.ayz);
         }

         if(this.ayA != 0) {
            var1.t(6, this.ayA);
         }

         if(this.ayB != 0) {
            var1.u(7, this.ayB);
         }

         if(this.ayC) {
            var1.b(8, this.ayC);
         }

         int var2;
         if(this.ayD != null && this.ayD.length > 0) {
            for(var2 = 0; var2 < this.ayD.length; ++var2) {
               qm.a var4 = this.ayD[var2];
               if(var4 != null) {
                  var1.a(9, (qw)var4);
               }
            }
         }

         if(this.ayE != null && this.ayE.length > 0) {
            for(var2 = 0; var2 < this.ayE.length; ++var2) {
               qm.a var5 = this.ayE[var2];
               if(var5 != null) {
                  var1.a(10, (qw)var5);
               }
            }
         }

         if(this.ayF != null && this.ayF.length > 0) {
            for(var2 = 0; var2 < this.ayF.length; ++var2) {
               String var6 = this.ayF[var2];
               if(var6 != null) {
                  var1.b(11, (String)var6);
               }
            }
         }

         if(this.ayG != null && this.ayG.length > 0) {
            for(var2 = 0; var2 < this.ayG.length; ++var2) {
               var1.b(12, this.ayG[var2]);
            }
         }

         if(this.ayI != 0L) {
            var1.b(13, this.ayI);
         }

         if(this.ayH != null && this.ayH.length > 0) {
            for(var2 = var3; var2 < this.ayH.length; ++var2) {
               var1.b(14, this.ayH[var2]);
            }
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.w(var1);
      }

      protected int c() {
         byte var7 = 0;
         int var2 = super.c();
         int var1 = var2;
         if(!Arrays.equals(this.ayv, qz.azq)) {
            var1 = var2 + qp.b(1, (byte[])this.ayv);
         }

         var2 = var1;
         if(!this.ayw.equals("")) {
            var2 = var1 + qp.j(2, this.ayw);
         }

         var1 = var2;
         if(Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0D)) {
            var1 = var2 + qp.b(3, this.ayx);
         }

         var2 = var1;
         if(Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0F)) {
            var2 = var1 + qp.c(4, this.ayy);
         }

         var1 = var2;
         if(this.ayz != 0L) {
            var1 = var2 + qp.d(5, this.ayz);
         }

         var2 = var1;
         if(this.ayA != 0) {
            var2 = var1 + qp.v(6, this.ayA);
         }

         int var3 = var2;
         if(this.ayB != 0) {
            var3 = var2 + qp.w(7, this.ayB);
         }

         var1 = var3;
         if(this.ayC) {
            var1 = var3 + qp.c(8, this.ayC);
         }

         var2 = var1;
         if(this.ayD != null) {
            var2 = var1;
            if(this.ayD.length > 0) {
               for(var2 = 0; var2 < this.ayD.length; var1 = var3) {
                  qm.a var8 = this.ayD[var2];
                  var3 = var1;
                  if(var8 != null) {
                     var3 = var1 + qp.c(9, var8);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         if(this.ayE != null) {
            var1 = var2;
            if(this.ayE.length > 0) {
               var1 = var2;

               for(var2 = 0; var2 < this.ayE.length; var1 = var3) {
                  qm.a var9 = this.ayE[var2];
                  var3 = var1;
                  if(var9 != null) {
                     var3 = var1 + qp.c(10, var9);
                  }

                  ++var2;
               }
            }
         }

         var2 = var1;
         if(this.ayF != null) {
            var2 = var1;
            if(this.ayF.length > 0) {
               var2 = 0;
               var3 = 0;

               int var4;
               int var5;
               for(var4 = 0; var2 < this.ayF.length; var4 = var5) {
                  String var10 = this.ayF[var2];
                  int var6 = var3;
                  var5 = var4;
                  if(var10 != null) {
                     var5 = var4 + 1;
                     var6 = var3 + qp.dk(var10);
                  }

                  ++var2;
                  var3 = var6;
               }

               var2 = var1 + var3 + var4 * 1;
            }
         }

         var1 = var2;
         if(this.ayG != null) {
            var1 = var2;
            if(this.ayG.length > 0) {
               var3 = 0;

               for(var1 = var7; var1 < this.ayG.length; ++var1) {
                  var3 += qp.D(this.ayG[var1]);
               }

               var1 = var2 + var3 + this.ayG.length * 1;
            }
         }

         var2 = var1;
         if(this.ayI != 0L) {
            var2 = var1 + qp.d(13, this.ayI);
         }

         var1 = var2;
         if(this.ayH != null) {
            var1 = var2;
            if(this.ayH.length > 0) {
               var1 = var2 + this.ayH.length * 4 + this.ayH.length * 1;
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
            if(var1 instanceof qm.a) {
               qm.a var4 = (qm.a)var1;
               var2 = var3;
               if(Arrays.equals(this.ayv, var4.ayv)) {
                  if(this.ayw == null) {
                     var2 = var3;
                     if(var4.ayw != null) {
                        return var2;
                     }
                  } else if(!this.ayw.equals(var4.ayw)) {
                     return false;
                  }

                  var2 = var3;
                  if(Double.doubleToLongBits(this.ayx) == Double.doubleToLongBits(var4.ayx)) {
                     var2 = var3;
                     if(Float.floatToIntBits(this.ayy) == Float.floatToIntBits(var4.ayy)) {
                        var2 = var3;
                        if(this.ayz == var4.ayz) {
                           var2 = var3;
                           if(this.ayA == var4.ayA) {
                              var2 = var3;
                              if(this.ayB == var4.ayB) {
                                 var2 = var3;
                                 if(this.ayC == var4.ayC) {
                                    var2 = var3;
                                    if(qu.equals((Object[])this.ayD, (Object[])var4.ayD)) {
                                       var2 = var3;
                                       if(qu.equals((Object[])this.ayE, (Object[])var4.ayE)) {
                                          var2 = var3;
                                          if(qu.equals((Object[])this.ayF, (Object[])var4.ayF)) {
                                             var2 = var3;
                                             if(qu.equals(this.ayG, var4.ayG)) {
                                                var2 = var3;
                                                if(qu.equals(this.ayH, var4.ayH)) {
                                                   var2 = var3;
                                                   if(this.ayI == var4.ayI) {
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
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         int var3 = Arrays.hashCode(this.ayv);
         int var1;
         if(this.ayw == null) {
            var1 = 0;
         } else {
            var1 = this.ayw.hashCode();
         }

         long var9 = Double.doubleToLongBits(this.ayx);
         int var4 = (int)(var9 ^ var9 >>> 32);
         int var5 = Float.floatToIntBits(this.ayy);
         int var6 = (int)(this.ayz ^ this.ayz >>> 32);
         int var7 = this.ayA;
         int var8 = this.ayB;
         short var2;
         if(this.ayC) {
            var2 = 1231;
         } else {
            var2 = 1237;
         }

         return (((((((var2 + ((((((var1 + (var3 + 527) * 31) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31) * 31 + qu.hashCode((Object[])this.ayD)) * 31 + qu.hashCode((Object[])this.ayE)) * 31 + qu.hashCode((Object[])this.ayF)) * 31 + qu.hashCode(this.ayG)) * 31 + qu.hashCode(this.ayH)) * 31 + (int)(this.ayI ^ this.ayI >>> 32)) * 31 + this.rQ();
      }

      public qm.a ry() {
         this.ayv = qz.azq;
         this.ayw = "";
         this.ayx = 0.0D;
         this.ayy = 0.0F;
         this.ayz = 0L;
         this.ayA = 0;
         this.ayB = 0;
         this.ayC = false;
         this.ayD = qm.a.ru();
         this.ayE = qm.a.rw();
         this.ayF = qz.azo;
         this.ayG = qz.azk;
         this.ayH = qz.azl;
         this.ayI = 0L;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public qm.a w(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            int var4;
            float[] var5;
            long[] var6;
            qm.a[] var9;
            switch(var2) {
            case 10:
               this.ayv = var1.readBytes();
               continue;
            case 18:
               this.ayw = var1.readString();
               continue;
            case 25:
               this.ayx = var1.readDouble();
               continue;
            case 37:
               this.ayy = var1.readFloat();
               continue;
            case 40:
               this.ayz = var1.rB();
               continue;
            case 48:
               this.ayA = var1.rC();
               continue;
            case 56:
               this.ayB = var1.rE();
               continue;
            case 64:
               this.ayC = var1.rD();
               continue;
            case 74:
               var3 = qz.b(var1, 74);
               if(this.ayD == null) {
                  var2 = 0;
               } else {
                  var2 = this.ayD.length;
               }

               var9 = new qm.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ayD, 0, var9, 0, var2);
                  var3 = var2;
               }
               break;
            case 82:
               var3 = qz.b(var1, 82);
               if(this.ayE == null) {
                  var2 = 0;
               } else {
                  var2 = this.ayE.length;
               }

               qm.a[] var8 = new qm.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ayE, 0, var8, 0, var2);
                  var3 = var2;
               }

               while(var3 < var8.length - 1) {
                  var8[var3] = new qm.a();
                  var1.a(var8[var3]);
                  var1.rz();
                  ++var3;
               }

               var8[var3] = new qm.a();
               var1.a(var8[var3]);
               this.ayE = var8;
               continue;
            case 90:
               var3 = qz.b(var1, 90);
               if(this.ayF == null) {
                  var2 = 0;
               } else {
                  var2 = this.ayF.length;
               }

               String[] var7 = new String[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ayF, 0, var7, 0, var2);
                  var3 = var2;
               }

               while(var3 < var7.length - 1) {
                  var7[var3] = var1.readString();
                  var1.rz();
                  ++var3;
               }

               var7[var3] = var1.readString();
               this.ayF = var7;
               continue;
            case 96:
               var3 = qz.b(var1, 96);
               if(this.ayG == null) {
                  var2 = 0;
               } else {
                  var2 = this.ayG.length;
               }

               var6 = new long[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ayG, 0, var6, 0, var2);
                  var3 = var2;
               }

               while(var3 < var6.length - 1) {
                  var6[var3] = var1.rB();
                  var1.rz();
                  ++var3;
               }

               var6[var3] = var1.rB();
               this.ayG = var6;
               continue;
            case 98:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rB();
               }

               var1.gU(var2);
               if(this.ayG == null) {
                  var2 = 0;
               } else {
                  var2 = this.ayG.length;
               }

               var6 = new long[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ayG, 0, var6, 0, var2);
                  var3 = var2;
               }

               while(var3 < var6.length) {
                  var6[var3] = var1.rB();
                  ++var3;
               }

               this.ayG = var6;
               var1.gT(var4);
               continue;
            case 104:
               this.ayI = var1.rB();
               continue;
            case 114:
               var2 = var1.rG();
               var4 = var1.gS(var2);
               var3 = var2 / 4;
               if(this.ayH == null) {
                  var2 = 0;
               } else {
                  var2 = this.ayH.length;
               }

               var5 = new float[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ayH, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.readFloat();
                  ++var3;
               }

               this.ayH = var5;
               var1.gT(var4);
               continue;
            case 117:
               var3 = qz.b(var1, 117);
               if(this.ayH == null) {
                  var2 = 0;
               } else {
                  var2 = this.ayH.length;
               }

               var5 = new float[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.ayH, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.readFloat();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.readFloat();
               this.ayH = var5;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var9.length - 1) {
               var9[var3] = new qm.a();
               var1.a(var9[var3]);
               var1.rz();
               ++var3;
            }

            var9[var3] = new qm.a();
            var1.a(var9[var3]);
            this.ayD = var9;
         }
      }
   }
}
