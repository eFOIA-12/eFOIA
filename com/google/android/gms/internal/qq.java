package com.google.android.gms.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qr;
import com.google.android.gms.internal.qs;
import com.google.android.gms.internal.qt;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qy;
import com.google.android.gms.internal.qz;
import java.io.IOException;

public abstract class qq extends qw {
   protected qs ayW;

   public final Object a(qr var1) {
      if(this.ayW != null) {
         qt var2 = this.ayW.hh(qz.hl(var1.tag));
         if(var2 != null) {
            return var2.b(var1);
         }
      }

      return null;
   }

   public void a(qp var1) throws IOException {
      if(this.ayW != null) {
         for(int var2 = 0; var2 < this.ayW.size(); ++var2) {
            this.ayW.hi(var2).a(var1);
         }
      }

   }

   protected final boolean a(qo var1, int var2) throws IOException {
      int var3 = var1.getPosition();
      if(!var1.gQ(var2)) {
         return false;
      } else {
         int var4 = qz.hl(var2);
         qy var6 = new qy(var2, var1.s(var3, var1.getPosition() - var3));
         qt var7 = null;
         if(this.ayW == null) {
            this.ayW = new qs();
         } else {
            var7 = this.ayW.hh(var4);
         }

         qt var5 = var7;
         if(var7 == null) {
            var5 = new qt();
            this.ayW.a(var4, var5);
         }

         var5.a(var6);
         return true;
      }
   }

   protected final boolean a(qq var1) {
      return this.ayW != null && !this.ayW.isEmpty()?this.ayW.equals(var1.ayW):var1.ayW == null || var1.ayW.isEmpty();
   }

   protected int c() {
      int var2 = 0;
      int var3;
      if(this.ayW != null) {
         int var1 = 0;

         while(true) {
            var3 = var1;
            if(var2 >= this.ayW.size()) {
               break;
            }

            var1 += this.ayW.hi(var2).c();
            ++var2;
         }
      } else {
         var3 = 0;
      }

      return var3;
   }

   protected final int rQ() {
      return this.ayW != null && !this.ayW.isEmpty()?this.ayW.hashCode():0;
   }
}
