package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qz;
import java.io.IOException;
import java.util.Arrays;

public interface ra {
   public static final class a extends qq {
      public String[] azr;
      public String[] azs;
      public int[] azt;

      public a() {
         this.sa();
      }

      public void a(qp var1) throws IOException {
         byte var3 = 0;
         int var2;
         String var4;
         if(this.azr != null && this.azr.length > 0) {
            for(var2 = 0; var2 < this.azr.length; ++var2) {
               var4 = this.azr[var2];
               if(var4 != null) {
                  var1.b(1, (String)var4);
               }
            }
         }

         if(this.azs != null && this.azs.length > 0) {
            for(var2 = 0; var2 < this.azs.length; ++var2) {
               var4 = this.azs[var2];
               if(var4 != null) {
                  var1.b(2, (String)var4);
               }
            }
         }

         if(this.azt != null && this.azt.length > 0) {
            for(var2 = var3; var2 < this.azt.length; ++var2) {
               var1.t(3, this.azt[var2]);
            }
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.y(var1);
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
         if(this.azr != null && this.azr.length > 0) {
            var1 = 0;
            var2 = 0;

            for(var3 = 0; var1 < this.azr.length; var3 = var4) {
               var8 = this.azr[var1];
               var5 = var2;
               var4 = var3;
               if(var8 != null) {
                  var4 = var3 + 1;
                  var5 = var2 + qp.dk(var8);
               }

               ++var1;
               var2 = var5;
            }

            var1 = var6 + var2 + var3 * 1;
         } else {
            var1 = var6;
         }

         var2 = var1;
         if(this.azs != null) {
            var2 = var1;
            if(this.azs.length > 0) {
               var2 = 0;
               var3 = 0;

               for(var4 = 0; var2 < this.azs.length; var4 = var5) {
                  var8 = this.azs[var2];
                  var6 = var3;
                  var5 = var4;
                  if(var8 != null) {
                     var5 = var4 + 1;
                     var6 = var3 + qp.dk(var8);
                  }

                  ++var2;
                  var3 = var6;
               }

               var2 = var1 + var3 + var4 * 1;
            }
         }

         var1 = var2;
         if(this.azt != null) {
            var1 = var2;
            if(this.azt.length > 0) {
               var3 = 0;

               for(var1 = var7; var1 < this.azt.length; ++var1) {
                  var3 += qp.gZ(this.azt[var1]);
               }

               var1 = var2 + var3 + this.azt.length * 1;
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
            if(var1 instanceof ra.a) {
               ra.a var4 = (ra.a)var1;
               var2 = var3;
               if(qu.equals((Object[])this.azr, (Object[])var4.azr)) {
                  var2 = var3;
                  if(qu.equals((Object[])this.azs, (Object[])var4.azs)) {
                     var2 = var3;
                     if(qu.equals(this.azt, var4.azt)) {
                        return this.a(var4);
                     }
                  }
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         return (((qu.hashCode((Object[])this.azr) + 527) * 31 + qu.hashCode((Object[])this.azs)) * 31 + qu.hashCode(this.azt)) * 31 + this.rQ();
      }

      public ra.a sa() {
         this.azr = qz.azo;
         this.azs = qz.azo;
         this.azt = qz.azj;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public ra.a y(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            int[] var5;
            String[] var6;
            switch(var2) {
            case 10:
               var3 = qz.b(var1, 10);
               if(this.azr == null) {
                  var2 = 0;
               } else {
                  var2 = this.azr.length;
               }

               var6 = new String[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.azr, 0, var6, 0, var2);
                  var3 = var2;
               }
               break;
            case 18:
               var3 = qz.b(var1, 18);
               if(this.azs == null) {
                  var2 = 0;
               } else {
                  var2 = this.azs.length;
               }

               var6 = new String[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.azs, 0, var6, 0, var2);
                  var3 = var2;
               }

               while(var3 < var6.length - 1) {
                  var6[var3] = var1.readString();
                  var1.rz();
                  ++var3;
               }

               var6[var3] = var1.readString();
               this.azs = var6;
               continue;
            case 24:
               var3 = qz.b(var1, 24);
               if(this.azt == null) {
                  var2 = 0;
               } else {
                  var2 = this.azt.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.azt, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length - 1) {
                  var5[var3] = var1.rC();
                  var1.rz();
                  ++var3;
               }

               var5[var3] = var1.rC();
               this.azt = var5;
               continue;
            case 26:
               int var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();

               for(var3 = 0; var1.rL() > 0; ++var3) {
                  var1.rC();
               }

               var1.gU(var2);
               if(this.azt == null) {
                  var2 = 0;
               } else {
                  var2 = this.azt.length;
               }

               var5 = new int[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.azt, 0, var5, 0, var2);
                  var3 = var2;
               }

               while(var3 < var5.length) {
                  var5[var3] = var1.rC();
                  ++var3;
               }

               this.azt = var5;
               var1.gT(var4);
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var6.length - 1) {
               var6[var3] = var1.readString();
               var1.rz();
               ++var3;
            }

            var6[var3] = var1.readString();
            this.azr = var6;
         }
      }
   }

   public static final class b extends qq {
      public int azu;
      public String azv;
      public String version;

      public b() {
         this.sb();
      }

      public void a(qp var1) throws IOException {
         if(this.azu != 0) {
            var1.t(1, this.azu);
         }

         if(!this.azv.equals("")) {
            var1.b(2, (String)this.azv);
         }

         if(!this.version.equals("")) {
            var1.b(3, (String)this.version);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.z(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(this.azu != 0) {
            var1 = var2 + qp.v(1, this.azu);
         }

         var2 = var1;
         if(!this.azv.equals("")) {
            var2 = var1 + qp.j(2, this.azv);
         }

         var1 = var2;
         if(!this.version.equals("")) {
            var1 = var2 + qp.j(3, this.version);
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
            if(var1 instanceof ra.b) {
               ra.b var4 = (ra.b)var1;
               var2 = var3;
               if(this.azu == var4.azu) {
                  if(this.azv == null) {
                     var2 = var3;
                     if(var4.azv != null) {
                        return var2;
                     }
                  } else if(!this.azv.equals(var4.azv)) {
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

                  return this.a(var4);
               }
            }
         }

         return var2;
      }

      public int hashCode() {
         int var2 = 0;
         int var3 = this.azu;
         int var1;
         if(this.azv == null) {
            var1 = 0;
         } else {
            var1 = this.azv.hashCode();
         }

         if(this.version != null) {
            var2 = this.version.hashCode();
         }

         return ((var1 + (var3 + 527) * 31) * 31 + var2) * 31 + this.rQ();
      }

      public ra.b sb() {
         this.azu = 0;
         this.azv = "";
         this.version = "";
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public ra.b z(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 8:
               var2 = var1.rC();
               switch(var2) {
               case 0:
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
               case 16:
               case 17:
               case 18:
               case 19:
               case 20:
               case 21:
               case 22:
                  this.azu = var2;
               default:
                  continue;
               }
            case 18:
               this.azv = var1.readString();
               break;
            case 26:
               this.version = var1.readString();
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
      public ra.d[] azA;
      public ra.b azB;
      public byte[] azC;
      public byte[] azD;
      public byte[] azE;
      public ra.a azF;
      public String azG;
      public long azH;
      public long azw;
      public int azx;
      public int azy;
      public boolean azz;
      public String tag;

      public c() {
         this.sc();
      }

      public ra.c A(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            ra.d[] var4;
            switch(var2) {
            case 8:
               this.azw = var1.rB();
               continue;
            case 18:
               this.tag = var1.readString();
               continue;
            case 26:
               var3 = qz.b(var1, 26);
               if(this.azA == null) {
                  var2 = 0;
               } else {
                  var2 = this.azA.length;
               }

               var4 = new ra.d[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.azA, 0, var4, 0, var2);
                  var3 = var2;
               }
               break;
            case 50:
               this.azC = var1.readBytes();
               continue;
            case 58:
               if(this.azF == null) {
                  this.azF = new ra.a();
               }

               var1.a(this.azF);
               continue;
            case 66:
               this.azD = var1.readBytes();
               continue;
            case 74:
               if(this.azB == null) {
                  this.azB = new ra.b();
               }

               var1.a(this.azB);
               continue;
            case 80:
               this.azz = var1.rD();
               continue;
            case 88:
               this.azx = var1.rC();
               continue;
            case 96:
               this.azy = var1.rC();
               continue;
            case 106:
               this.azE = var1.readBytes();
               continue;
            case 114:
               this.azG = var1.readString();
               continue;
            case 120:
               this.azH = var1.rF();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var4.length - 1) {
               var4[var3] = new ra.d();
               var1.a(var4[var3]);
               var1.rz();
               ++var3;
            }

            var4[var3] = new ra.d();
            var1.a(var4[var3]);
            this.azA = var4;
         }
      }

      public void a(qp var1) throws IOException {
         if(this.azw != 0L) {
            var1.b(1, this.azw);
         }

         if(!this.tag.equals("")) {
            var1.b(2, (String)this.tag);
         }

         if(this.azA != null && this.azA.length > 0) {
            for(int var2 = 0; var2 < this.azA.length; ++var2) {
               ra.d var3 = this.azA[var2];
               if(var3 != null) {
                  var1.a(3, (qw)var3);
               }
            }
         }

         if(!Arrays.equals(this.azC, qz.azq)) {
            var1.a(6, (byte[])this.azC);
         }

         if(this.azF != null) {
            var1.a(7, (qw)this.azF);
         }

         if(!Arrays.equals(this.azD, qz.azq)) {
            var1.a(8, (byte[])this.azD);
         }

         if(this.azB != null) {
            var1.a(9, (qw)this.azB);
         }

         if(this.azz) {
            var1.b(10, this.azz);
         }

         if(this.azx != 0) {
            var1.t(11, this.azx);
         }

         if(this.azy != 0) {
            var1.t(12, this.azy);
         }

         if(!Arrays.equals(this.azE, qz.azq)) {
            var1.a(13, (byte[])this.azE);
         }

         if(!this.azG.equals("")) {
            var1.b(14, (String)this.azG);
         }

         if(this.azH != 0L) {
            var1.c(15, this.azH);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.A(var1);
      }

      protected int c() {
         int var1 = super.c();
         int var2 = var1;
         if(this.azw != 0L) {
            var2 = var1 + qp.d(1, this.azw);
         }

         var1 = var2;
         if(!this.tag.equals("")) {
            var1 = var2 + qp.j(2, this.tag);
         }

         var2 = var1;
         if(this.azA != null) {
            var2 = var1;
            if(this.azA.length > 0) {
               int var3;
               for(var2 = 0; var2 < this.azA.length; var1 = var3) {
                  ra.d var4 = this.azA[var2];
                  var3 = var1;
                  if(var4 != null) {
                     var3 = var1 + qp.c(3, var4);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         if(!Arrays.equals(this.azC, qz.azq)) {
            var1 = var2 + qp.b(6, (byte[])this.azC);
         }

         var2 = var1;
         if(this.azF != null) {
            var2 = var1 + qp.c(7, this.azF);
         }

         var1 = var2;
         if(!Arrays.equals(this.azD, qz.azq)) {
            var1 = var2 + qp.b(8, (byte[])this.azD);
         }

         var2 = var1;
         if(this.azB != null) {
            var2 = var1 + qp.c(9, this.azB);
         }

         var1 = var2;
         if(this.azz) {
            var1 = var2 + qp.c(10, this.azz);
         }

         var2 = var1;
         if(this.azx != 0) {
            var2 = var1 + qp.v(11, this.azx);
         }

         var1 = var2;
         if(this.azy != 0) {
            var1 = var2 + qp.v(12, this.azy);
         }

         var2 = var1;
         if(!Arrays.equals(this.azE, qz.azq)) {
            var2 = var1 + qp.b(13, (byte[])this.azE);
         }

         var1 = var2;
         if(!this.azG.equals("")) {
            var1 = var2 + qp.j(14, this.azG);
         }

         var2 = var1;
         if(this.azH != 0L) {
            var2 = var1 + qp.e(15, this.azH);
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
            if(var1 instanceof ra.c) {
               ra.c var4 = (ra.c)var1;
               var2 = var3;
               if(this.azw == var4.azw) {
                  if(this.tag == null) {
                     var2 = var3;
                     if(var4.tag != null) {
                        return var2;
                     }
                  } else if(!this.tag.equals(var4.tag)) {
                     return false;
                  }

                  var2 = var3;
                  if(this.azx == var4.azx) {
                     var2 = var3;
                     if(this.azy == var4.azy) {
                        var2 = var3;
                        if(this.azz == var4.azz) {
                           var2 = var3;
                           if(qu.equals((Object[])this.azA, (Object[])var4.azA)) {
                              if(this.azB == null) {
                                 var2 = var3;
                                 if(var4.azB != null) {
                                    return var2;
                                 }
                              } else if(!this.azB.equals(var4.azB)) {
                                 return false;
                              }

                              var2 = var3;
                              if(Arrays.equals(this.azC, var4.azC)) {
                                 var2 = var3;
                                 if(Arrays.equals(this.azD, var4.azD)) {
                                    var2 = var3;
                                    if(Arrays.equals(this.azE, var4.azE)) {
                                       if(this.azF == null) {
                                          var2 = var3;
                                          if(var4.azF != null) {
                                             return var2;
                                          }
                                       } else if(!this.azF.equals(var4.azF)) {
                                          return false;
                                       }

                                       if(this.azG == null) {
                                          var2 = var3;
                                          if(var4.azG != null) {
                                             return var2;
                                          }
                                       } else if(!this.azG.equals(var4.azG)) {
                                          return false;
                                       }

                                       var2 = var3;
                                       if(this.azH == var4.azH) {
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

         return var2;
      }

      public int hashCode() {
         int var5 = 0;
         int var6 = (int)(this.azw ^ this.azw >>> 32);
         int var1;
         if(this.tag == null) {
            var1 = 0;
         } else {
            var1 = this.tag.hashCode();
         }

         int var7 = this.azx;
         int var8 = this.azy;
         short var2;
         if(this.azz) {
            var2 = 1231;
         } else {
            var2 = 1237;
         }

         int var9 = qu.hashCode((Object[])this.azA);
         int var3;
         if(this.azB == null) {
            var3 = 0;
         } else {
            var3 = this.azB.hashCode();
         }

         int var10 = Arrays.hashCode(this.azC);
         int var11 = Arrays.hashCode(this.azD);
         int var12 = Arrays.hashCode(this.azE);
         int var4;
         if(this.azF == null) {
            var4 = 0;
         } else {
            var4 = this.azF.hashCode();
         }

         if(this.azG != null) {
            var5 = this.azG.hashCode();
         }

         return (((var4 + ((((var3 + ((var2 + (((var1 + (var6 + 527) * 31) * 31 + var7) * 31 + var8) * 31) * 31 + var9) * 31) * 31 + var10) * 31 + var11) * 31 + var12) * 31) * 31 + var5) * 31 + (int)(this.azH ^ this.azH >>> 32)) * 31 + this.rQ();
      }

      public ra.c sc() {
         this.azw = 0L;
         this.tag = "";
         this.azx = 0;
         this.azy = 0;
         this.azz = false;
         this.azA = ra.d.sd();
         this.azB = null;
         this.azC = qz.azq;
         this.azD = qz.azq;
         this.azE = qz.azq;
         this.azF = null;
         this.azG = "";
         this.azH = 0L;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class d extends qq {
      private static volatile ra.d[] azI;
      public String fv;
      public String value;

      public d() {
         this.se();
      }

      public static ra.d[] sd() {
         // $FF: Couldn't be decompiled
      }

      public ra.d B(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 10:
               this.fv = var1.readString();
               break;
            case 18:
               this.value = var1.readString();
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
         if(!this.fv.equals("")) {
            var1.b(1, (String)this.fv);
         }

         if(!this.value.equals("")) {
            var1.b(2, (String)this.value);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.B(var1);
      }

      protected int c() {
         int var2 = super.c();
         int var1 = var2;
         if(!this.fv.equals("")) {
            var1 = var2 + qp.j(1, this.fv);
         }

         var2 = var1;
         if(!this.value.equals("")) {
            var2 = var1 + qp.j(2, this.value);
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
            if(var1 instanceof ra.d) {
               ra.d var4 = (ra.d)var1;
               if(this.fv == null) {
                  var2 = var3;
                  if(var4.fv != null) {
                     return var2;
                  }
               } else if(!this.fv.equals(var4.fv)) {
                  return false;
               }

               if(this.value == null) {
                  var2 = var3;
                  if(var4.value != null) {
                     return var2;
                  }
               } else if(!this.value.equals(var4.value)) {
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
         if(this.fv == null) {
            var1 = 0;
         } else {
            var1 = this.fv.hashCode();
         }

         if(this.value != null) {
            var2 = this.value.hashCode();
         }

         return ((var1 + 527) * 31 + var2) * 31 + this.rQ();
      }

      public ra.d se() {
         this.fv = "";
         this.value = "";
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }
}
