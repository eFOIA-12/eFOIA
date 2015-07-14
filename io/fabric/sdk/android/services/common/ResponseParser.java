package io.fabric.sdk.android.services.common;

public class ResponseParser {
   public static final int ResponseActionDiscard = 0;
   public static final int ResponseActionRetry = 1;

   public static int parse(int var0) {
      if(var0 < 200 || var0 > 299) {
         if(var0 >= 300 && var0 <= 399) {
            return 1;
         }

         if(var0 < 400 || var0 > 499) {
            if(var0 >= 500) {
               return 1;
            }

            return 1;
         }
      }

      return 0;
   }
}
