package org.apache.http.util;

public final class LangUtils {
   public static final int HASH_OFFSET = 37;
   public static final int HASH_SEED = 17;

   public static boolean equals(Object var0, Object var1) {
      return var0 == null?var1 == null:var0.equals(var1);
   }

   public static boolean equals(Object[] var0, Object[] var1) {
      if(var0 == null) {
         if(var1 != null) {
            return false;
         }
      } else {
         if(var1 == null || var0.length != var1.length) {
            return false;
         }

         for(int var2 = 0; var2 < var0.length; ++var2) {
            if(!equals(var0[var2], var1[var2])) {
               return false;
            }
         }
      }

      return true;
   }

   public static int hashCode(int var0, int var1) {
      return var0 * 37 + var1;
   }

   public static int hashCode(int var0, Object var1) {
      int var2;
      if(var1 != null) {
         var2 = var1.hashCode();
      } else {
         var2 = 0;
      }

      return hashCode(var0, var2);
   }

   public static int hashCode(int var0, boolean var1) {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      return hashCode(var0, var2);
   }
}
