package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number {
   private final String value;

   public LazilyParsedNumber(String var1) {
      this.value = var1;
   }

   private Object writeReplace() throws ObjectStreamException {
      return new BigDecimal(this.value);
   }

   public double doubleValue() {
      return Double.parseDouble(this.value);
   }

   public float floatValue() {
      return Float.parseFloat(this.value);
   }

   public int intValue() {
      try {
         int var1 = Integer.parseInt(this.value);
         return var1;
      } catch (NumberFormatException var6) {
         long var2;
         try {
            var2 = Long.parseLong(this.value);
         } catch (NumberFormatException var5) {
            return (new BigDecimal(this.value)).intValue();
         }

         return (int)var2;
      }
   }

   public long longValue() {
      try {
         long var1 = Long.parseLong(this.value);
         return var1;
      } catch (NumberFormatException var4) {
         return (new BigDecimal(this.value)).longValue();
      }
   }

   public String toString() {
      return this.value;
   }
}
