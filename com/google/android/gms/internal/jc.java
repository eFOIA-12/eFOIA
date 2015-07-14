package com.google.android.gms.internal;

import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.kj;

public final class jc extends kj {
   public jc() {
      super(10);
   }

   public static final class a {
      public final int Mt;
      public final int Mu;

      public a(int var1, int var2) {
         this.Mt = var1;
         this.Mu = var2;
      }

      public boolean equals(Object var1) {
         boolean var3 = true;
         boolean var2;
         if(!(var1 instanceof jc.a)) {
            var2 = false;
         } else {
            var2 = var3;
            if(this != var1) {
               jc.a var4 = (jc.a)var1;
               if(var4.Mt == this.Mt) {
                  var2 = var3;
                  if(var4.Mu == this.Mu) {
                     return var2;
                  }
               }

               return false;
            }
         }

         return var2;
      }

      public int hashCode() {
         return jv.hashCode(new Object[]{Integer.valueOf(this.Mt), Integer.valueOf(this.Mu)});
      }
   }
}
