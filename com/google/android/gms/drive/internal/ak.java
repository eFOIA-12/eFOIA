package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import java.io.IOException;

public final class ak extends qq {
   public String QG;
   public long QH;
   public long QI;
   public int versionCode;

   public ak() {
      this.iK();
   }

   public static ak g(byte[] var0) throws qv {
      return (ak)qw.a(new ak(), var0);
   }

   public void a(qp var1) throws IOException {
      var1.t(1, this.versionCode);
      var1.b(2, (String)this.QG);
      var1.c(3, this.QH);
      var1.c(4, this.QI);
      super.a(var1);
   }

   // $FF: synthetic method
   public qw b(qo var1) throws IOException {
      return this.m(var1);
   }

   protected int c() {
      return super.c() + qp.v(1, this.versionCode) + qp.j(2, this.QG) + qp.e(3, this.QH) + qp.e(4, this.QI);
   }

   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if(var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if(var1 instanceof ak) {
            ak var4 = (ak)var1;
            var2 = var3;
            if(this.versionCode == var4.versionCode) {
               if(this.QG == null) {
                  var2 = var3;
                  if(var4.QG != null) {
                     return var2;
                  }
               } else if(!this.QG.equals(var4.QG)) {
                  return false;
               }

               var2 = var3;
               if(this.QH == var4.QH) {
                  var2 = var3;
                  if(this.QI == var4.QI) {
                     return this.a(var4);
                  }
               }
            }
         }
      }

      return var2;
   }

   public int hashCode() {
      int var2 = this.versionCode;
      int var1;
      if(this.QG == null) {
         var1 = 0;
      } else {
         var1 = this.QG.hashCode();
      }

      return (((var1 + (var2 + 527) * 31) * 31 + (int)(this.QH ^ this.QH >>> 32)) * 31 + (int)(this.QI ^ this.QI >>> 32)) * 31 + this.rQ();
   }

   public ak iK() {
      this.versionCode = 1;
      this.QG = "";
      this.QH = -1L;
      this.QI = -1L;
      this.ayW = null;
      this.azh = -1;
      return this;
   }

   public ak m(qo var1) throws IOException {
      while(true) {
         int var2 = var1.rz();
         switch(var2) {
         case 8:
            this.versionCode = var1.rC();
            break;
         case 18:
            this.QG = var1.readString();
            break;
         case 24:
            this.QH = var1.rF();
            break;
         case 32:
            this.QI = var1.rF();
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
