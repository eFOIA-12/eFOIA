package com.google.android.gms.internal;

import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class jv {
   public static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static jv.a h(Object var0) {
      return new jv.a(var0, null);
   }

   public static int hashCode(Object... var0) {
      return Arrays.hashCode(var0);
   }

   public static final class a {
      private final List Nr;
      private final Object Ns;

      private a(Object var1) {
         this.Ns = jx.i(var1);
         this.Nr = new ArrayList();
      }

      // $FF: synthetic method
      a(Object var1, Object var2) {
         this(var1);
      }

      public jv.a a(String var1, Object var2) {
         this.Nr.add((String)jx.i(var1) + "=" + var2);
         return this;
      }

      public String toString() {
         StringBuilder var3 = (new StringBuilder(100)).append(this.Ns.getClass().getSimpleName()).append('{');
         int var2 = this.Nr.size();

         for(int var1 = 0; var1 < var2; ++var1) {
            var3.append((String)this.Nr.get(var1));
            if(var1 < var2 - 1) {
               var3.append(", ");
            }
         }

         return var3.append('}').toString();
      }
   }
}
