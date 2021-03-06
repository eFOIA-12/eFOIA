package android.support.v4.util;

public class Pair {
   public final Object first;
   public final Object second;

   public Pair(Object var1, Object var2) {
      this.first = var1;
      this.second = var2;
   }

   public static Pair create(Object var0, Object var1) {
      return new Pair(var0, var1);
   }

   private static boolean objectsEqual(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Pair) {
         Pair var2 = (Pair)var1;
         if(objectsEqual(var2.first, this.first) && objectsEqual(var2.second, this.second)) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      int var2 = 0;
      int var1;
      if(this.first == null) {
         var1 = 0;
      } else {
         var1 = this.first.hashCode();
      }

      if(this.second != null) {
         var2 = this.second.hashCode();
      }

      return var1 ^ var2;
   }
}
