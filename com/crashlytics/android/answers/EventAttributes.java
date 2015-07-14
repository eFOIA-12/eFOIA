package com.crashlytics.android.answers;

import java.util.HashMap;
import java.util.Map;

public final class EventAttributes {
   public static final int MAX_NUM_ATTRIBUTES = 20;
   public static final int MAX_STRING_LENGTH = 100;
   final Map attributes = new HashMap();

   static void validateStringLength(String var0) {
      if(var0.length() > 100) {
         throw new IllegalArgumentException(String.format("String cannot be longer than %d characters", new Object[]{Integer.valueOf(100)}));
      }
   }

   public EventAttributes put(String var1, Number var2) {
      if(var1 == null) {
         throw new NullPointerException("key must not be null");
      } else if(var2 == null) {
         throw new NullPointerException("value must not be null");
      } else {
         validateStringLength(var1);
         this.putAttribute(var1, var2);
         return this;
      }
   }

   public EventAttributes put(String var1, String var2) {
      if(var1 == null) {
         throw new NullPointerException("key must not be null");
      } else if(var2 == null) {
         throw new NullPointerException("value must not be null");
      } else {
         validateStringLength(var1);
         validateStringLength(var2);
         this.putAttribute(var1, var2);
         return this;
      }
   }

   void putAttribute(String var1, Object var2) {
      if(this.attributes.size() >= 20 && !this.attributes.containsKey(var1)) {
         throw new IllegalStateException(String.format("Event cannot have more than %d attributes", new Object[]{Integer.valueOf(20)}));
      } else {
         this.attributes.put(var1, var2);
      }
   }
}
