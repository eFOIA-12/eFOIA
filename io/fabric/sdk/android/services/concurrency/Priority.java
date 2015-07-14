package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.PriorityProvider;

public enum Priority {
   HIGH,
   IMMEDIATE,
   LOW,
   NORMAL;

   static int compareTo(PriorityProvider var0, Object var1) {
      Priority var2;
      if(var1 instanceof PriorityProvider) {
         var2 = ((PriorityProvider)var1).getPriority();
      } else {
         var2 = NORMAL;
      }

      return var2.ordinal() - var0.getPriority().ordinal();
   }
}
