package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class ho {
   private static final String[] Df;
   private static final Map Dg;

   static {
      int var0 = 0;
      Df = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};

      for(Dg = new HashMap(Df.length); var0 < Df.length; ++var0) {
         Dg.put(Df[var0], Integer.valueOf(var0));
      }

   }

   public static String P(int var0) {
      return var0 >= 0 && var0 < Df.length?Df[var0]:null;
   }

   public static int as(String var0) {
      Integer var1 = (Integer)Dg.get(var0);
      if(var1 == null) {
         throw new IllegalArgumentException("[" + var0 + "] is not a valid global search section name");
      } else {
         return var1.intValue();
      }
   }

   public static int fF() {
      return Df.length;
   }
}
