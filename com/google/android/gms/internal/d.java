package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qz;
import java.io.IOException;

public interface d {
   public static final class a extends qq {
      private static volatile d.a[] gu;
      public String gA;
      public long gB;
      public boolean gC;
      public d.a[] gD;
      public int[] gE;
      public boolean gF;
      public String gv;
      public d.a[] gw;
      public d.a[] gx;
      public d.a[] gy;
      public String gz;
      public int type;

      public a() {
         this.s();
      }

      public static d.a[] r() {
         // $FF: Couldn't be decompiled
      }

      public void a(qp var1) throws IOException {
         byte var3 = 0;
         var1.t(1, this.type);
         if(!this.gv.equals("")) {
            var1.b(2, (String)this.gv);
         }

         int var2;
         d.a var4;
         if(this.gw != null && this.gw.length > 0) {
            for(var2 = 0; var2 < this.gw.length; ++var2) {
               var4 = this.gw[var2];
               if(var4 != null) {
                  var1.a(3, (qw)var4);
               }
            }
         }

         if(this.gx != null && this.gx.length > 0) {
            for(var2 = 0; var2 < this.gx.length; ++var2) {
               var4 = this.gx[var2];
               if(var4 != null) {
                  var1.a(4, (qw)var4);
               }
            }
         }

         if(this.gy != null && this.gy.length > 0) {
            for(var2 = 0; var2 < this.gy.length; ++var2) {
               var4 = this.gy[var2];
               if(var4 != null) {
                  var1.a(5, (qw)var4);
               }
            }
         }

         if(!this.gz.equals("")) {
            var1.b(6, (String)this.gz);
         }

         if(!this.gA.equals("")) {
            var1.b(7, (String)this.gA);
         }

         if(this.gB != 0L) {
            var1.b(8, this.gB);
         }

         if(this.gF) {
            var1.b(9, this.gF);
         }

         if(this.gE != null && this.gE.length > 0) {
            for(var2 = 0; var2 < this.gE.length; ++var2) {
               var1.t(10, this.gE[var2]);
            }
         }

         if(this.gD != null && this.gD.length > 0) {
            for(var2 = var3; var2 < this.gD.length; ++var2) {
               var4 = this.gD[var2];
               if(var4 != null) {
                  var1.a(11, (qw)var4);
               }
            }
         }

         if(this.gC) {
            var1.b(12, this.gC);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.l(var1);
      }

      protected int c() {
         byte var4 = 0;
         int var2 = super.c() + qp.v(1, this.type);
         int var1 = var2;
         if(!this.gv.equals("")) {
            var1 = var2 + qp.j(2, this.gv);
         }

         var2 = var1;
         int var3;
         d.a var5;
         if(this.gw != null) {
            var2 = var1;
            if(this.gw.length > 0) {
               for(var2 = 0; var2 < this.gw.length; var1 = var3) {
                  var5 = this.gw[var2];
                  var3 = var1;
                  if(var5 != null) {
                     var3 = var1 + qp.c(3, var5);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         if(this.gx != null) {
            var1 = var2;
            if(this.gx.length > 0) {
               var1 = var2;

               for(var2 = 0; var2 < this.gx.length; var1 = var3) {
                  var5 = this.gx[var2];
                  var3 = var1;
                  if(var5 != null) {
                     var3 = var1 + qp.c(4, var5);
                  }

                  ++var2;
               }
            }
         }

         var2 = var1;
         if(this.gy != null) {
            var2 = var1;
            if(this.gy.length > 0) {
               for(var2 = 0; var2 < this.gy.length; var1 = var3) {
                  var5 = this.gy[var2];
                  var3 = var1;
                  if(var5 != null) {
                     var3 = var1 + qp.c(5, var5);
                  }

                  ++var2;
               }

               var2 = var1;
            }
         }

         var1 = var2;
         if(!this.gz.equals("")) {
            var1 = var2 + qp.j(6, this.gz);
         }

         var2 = var1;
         if(!this.gA.equals("")) {
            var2 = var1 + qp.j(7, this.gA);
         }

         var1 = var2;
         if(this.gB != 0L) {
            var1 = var2 + qp.d(8, this.gB);
         }

         var2 = var1;
         if(this.gF) {
            var2 = var1 + qp.c(9, this.gF);
         }

         var1 = var2;
         if(this.gE != null) {
            var1 = var2;
            if(this.gE.length > 0) {
               var1 = 0;

               for(var3 = 0; var1 < this.gE.length; ++var1) {
                  var3 += qp.gZ(this.gE[var1]);
               }

               var1 = var2 + var3 + this.gE.length * 1;
            }
         }

         var2 = var1;
         if(this.gD != null) {
            var2 = var1;
            if(this.gD.length > 0) {
               var3 = var4;

               while(true) {
                  var2 = var1;
                  if(var3 >= this.gD.length) {
                     break;
                  }

                  var5 = this.gD[var3];
                  var2 = var1;
                  if(var5 != null) {
                     var2 = var1 + qp.c(11, var5);
                  }

                  ++var3;
                  var1 = var2;
               }
            }
         }

         var1 = var2;
         if(this.gC) {
            var1 = var2 + qp.c(12, this.gC);
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
            if(var1 instanceof d.a) {
               d.a var4 = (d.a)var1;
               var2 = var3;
               if(this.type == var4.type) {
                  if(this.gv == null) {
                     var2 = var3;
                     if(var4.gv != null) {
                        return var2;
                     }
                  } else if(!this.gv.equals(var4.gv)) {
                     return false;
                  }

                  var2 = var3;
                  if(qu.equals((Object[])this.gw, (Object[])var4.gw)) {
                     var2 = var3;
                     if(qu.equals((Object[])this.gx, (Object[])var4.gx)) {
                        var2 = var3;
                        if(qu.equals((Object[])this.gy, (Object[])var4.gy)) {
                           if(this.gz == null) {
                              var2 = var3;
                              if(var4.gz != null) {
                                 return var2;
                              }
                           } else if(!this.gz.equals(var4.gz)) {
                              return false;
                           }

                           if(this.gA == null) {
                              var2 = var3;
                              if(var4.gA != null) {
                                 return var2;
                              }
                           } else if(!this.gA.equals(var4.gA)) {
                              return false;
                           }

                           var2 = var3;
                           if(this.gB == var4.gB) {
                              var2 = var3;
                              if(this.gC == var4.gC) {
                                 var2 = var3;
                                 if(qu.equals((Object[])this.gD, (Object[])var4.gD)) {
                                    var2 = var3;
                                    if(qu.equals(this.gE, var4.gE)) {
                                       var2 = var3;
                                       if(this.gF == var4.gF) {
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
         short var5 = 1231;
         int var3 = 0;
         int var6 = this.type;
         int var1;
         if(this.gv == null) {
            var1 = 0;
         } else {
            var1 = this.gv.hashCode();
         }

         int var7 = qu.hashCode((Object[])this.gw);
         int var8 = qu.hashCode((Object[])this.gx);
         int var9 = qu.hashCode((Object[])this.gy);
         int var2;
         if(this.gz == null) {
            var2 = 0;
         } else {
            var2 = this.gz.hashCode();
         }

         if(this.gA != null) {
            var3 = this.gA.hashCode();
         }

         int var10 = (int)(this.gB ^ this.gB >>> 32);
         short var4;
         if(this.gC) {
            var4 = 1231;
         } else {
            var4 = 1237;
         }

         int var11 = qu.hashCode((Object[])this.gD);
         int var12 = qu.hashCode(this.gE);
         if(!this.gF) {
            var5 = 1237;
         }

         return ((((var4 + (((var2 + ((((var1 + (var6 + 527) * 31) * 31 + var7) * 31 + var8) * 31 + var9) * 31) * 31 + var3) * 31 + var10) * 31) * 31 + var11) * 31 + var12) * 31 + var5) * 31 + this.rQ();
      }

      public d.a l(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            int var3;
            int var4;
            d.a[] var7;
            int[] var9;
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
                  this.type = var2;
               default:
                  continue;
               }
            case 18:
               this.gv = var1.readString();
               continue;
            case 26:
               var3 = qz.b(var1, 26);
               if(this.gw == null) {
                  var2 = 0;
               } else {
                  var2 = this.gw.length;
               }

               var7 = new d.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gw, 0, var7, 0, var2);
                  var3 = var2;
               }
               break;
            case 34:
               var3 = qz.b(var1, 34);
               if(this.gx == null) {
                  var2 = 0;
               } else {
                  var2 = this.gx.length;
               }

               var7 = new d.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gx, 0, var7, 0, var2);
                  var3 = var2;
               }

               while(var3 < var7.length - 1) {
                  var7[var3] = new d.a();
                  var1.a(var7[var3]);
                  var1.rz();
                  ++var3;
               }

               var7[var3] = new d.a();
               var1.a(var7[var3]);
               this.gx = var7;
               continue;
            case 42:
               var3 = qz.b(var1, 42);
               if(this.gy == null) {
                  var2 = 0;
               } else {
                  var2 = this.gy.length;
               }

               var7 = new d.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gy, 0, var7, 0, var2);
                  var3 = var2;
               }

               while(var3 < var7.length - 1) {
                  var7[var3] = new d.a();
                  var1.a(var7[var3]);
                  var1.rz();
                  ++var3;
               }

               var7[var3] = new d.a();
               var1.a(var7[var3]);
               this.gy = var7;
               continue;
            case 50:
               this.gz = var1.readString();
               continue;
            case 58:
               this.gA = var1.readString();
               continue;
            case 64:
               this.gB = var1.rB();
               continue;
            case 72:
               this.gF = var1.rD();
               continue;
            case 80:
               int var5 = qz.b(var1, 80);
               var9 = new int[var5];
               var3 = 0;
               var2 = 0;

               while(var3 < var5) {
                  if(var3 != 0) {
                     var1.rz();
                  }

                  int var6 = var1.rC();
                  switch(var6) {
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
                     var4 = var2 + 1;
                     var9[var2] = var6;
                     var2 = var4;
                  default:
                     ++var3;
                  }
               }

               if(var2 == 0) {
                  continue;
               }

               if(this.gE == null) {
                  var3 = 0;
               } else {
                  var3 = this.gE.length;
               }

               if(var3 == 0 && var2 == var9.length) {
                  this.gE = var9;
                  continue;
               }

               int[] var8 = new int[var3 + var2];
               if(var3 != 0) {
                  System.arraycopy(this.gE, 0, var8, 0, var3);
               }

               System.arraycopy(var9, 0, var8, var3, var2);
               this.gE = var8;
               continue;
            case 82:
               var4 = var1.gS(var1.rG());
               var2 = var1.getPosition();
               var3 = 0;

               while(var1.rL() > 0) {
                  switch(var1.rC()) {
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
                     ++var3;
                  }
               }

               if(var3 != 0) {
                  var1.gU(var2);
                  if(this.gE == null) {
                     var2 = 0;
                  } else {
                     var2 = this.gE.length;
                  }

                  var9 = new int[var3 + var2];
                  var3 = var2;
                  if(var2 != 0) {
                     System.arraycopy(this.gE, 0, var9, 0, var2);
                     var3 = var2;
                  }

                  while(var1.rL() > 0) {
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
                     case 16:
                     case 17:
                        var9[var3] = var2;
                        ++var3;
                     }
                  }

                  this.gE = var9;
               }

               var1.gT(var4);
               continue;
            case 90:
               var3 = qz.b(var1, 90);
               if(this.gD == null) {
                  var2 = 0;
               } else {
                  var2 = this.gD.length;
               }

               var7 = new d.a[var3 + var2];
               var3 = var2;
               if(var2 != 0) {
                  System.arraycopy(this.gD, 0, var7, 0, var2);
                  var3 = var2;
               }

               while(var3 < var7.length - 1) {
                  var7[var3] = new d.a();
                  var1.a(var7[var3]);
                  var1.rz();
                  ++var3;
               }

               var7[var3] = new d.a();
               var1.a(var7[var3]);
               this.gD = var7;
               continue;
            case 96:
               this.gC = var1.rD();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var3 < var7.length - 1) {
               var7[var3] = new d.a();
               var1.a(var7[var3]);
               var1.rz();
               ++var3;
            }

            var7[var3] = new d.a();
            var1.a(var7[var3]);
            this.gw = var7;
         }
      }

      public d.a s() {
         this.type = 1;
         this.gv = "";
         this.gw = r();
         this.gx = r();
         this.gy = r();
         this.gz = "";
         this.gA = "";
         this.gB = 0L;
         this.gC = false;
         this.gD = r();
         this.gE = qz.azj;
         this.gF = false;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }
}
