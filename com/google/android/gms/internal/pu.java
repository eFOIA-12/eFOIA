package com.google.android.gms.internal;

import com.google.android.gms.internal.c;
import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import java.io.IOException;

public interface pu {
   public static final class a extends qq {
      public long auB;
      public c.j auC;
      public c.f gs;

      public a() {
         this.rc();
      }

      public static pu.a l(byte[] var0) throws qv {
         return (pu.a)qw.a(new pu.a(), var0);
      }

      public void a(qp var1) throws IOException {
         var1.b(1, this.auB);
         if(this.gs != null) {
            var1.a(2, (qw)this.gs);
         }

         if(this.auC != null) {
            var1.a(3, (qw)this.auC);
         }

         super.a(var1);
      }

      // $FF: synthetic method
      public qw b(qo var1) throws IOException {
         return this.s(var1);
      }

      protected int c() {
         int var2 = super.c() + qp.d(1, this.auB);
         int var1 = var2;
         if(this.gs != null) {
            var1 = var2 + qp.c(2, this.gs);
         }

         var2 = var1;
         if(this.auC != null) {
            var2 = var1 + qp.c(3, this.auC);
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
            if(var1 instanceof pu.a) {
               pu.a var4 = (pu.a)var1;
               var2 = var3;
               if(this.auB == var4.auB) {
                  if(this.gs == null) {
                     var2 = var3;
                     if(var4.gs != null) {
                        return var2;
                     }
                  } else if(!this.gs.equals(var4.gs)) {
                     return false;
                  }

                  if(this.auC == null) {
                     var2 = var3;
                     if(var4.auC != null) {
                        return var2;
                     }
                  } else if(!this.auC.equals(var4.auC)) {
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
         int var3 = (int)(this.auB ^ this.auB >>> 32);
         int var1;
         if(this.gs == null) {
            var1 = 0;
         } else {
            var1 = this.gs.hashCode();
         }

         if(this.auC != null) {
            var2 = this.auC.hashCode();
         }

         return ((var1 + (var3 + 527) * 31) * 31 + var2) * 31 + this.rQ();
      }

      public pu.a rc() {
         this.auB = 0L;
         this.gs = null;
         this.auC = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public pu.a s(qo var1) throws IOException {
         while(true) {
            int var2 = var1.rz();
            switch(var2) {
            case 8:
               this.auB = var1.rB();
               break;
            case 18:
               if(this.gs == null) {
                  this.gs = new c.f();
               }

               var1.a(this.gs);
               break;
            case 26:
               if(this.auC == null) {
                  this.auC = new c.j();
               }

               var1.a(this.auC);
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
