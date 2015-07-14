package com.google.gson;

import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;

public enum FieldNamingPolicy implements FieldNamingStrategy {
   IDENTITY {
      public String translateName(Field var1) {
         return var1.getName();
      }
   },
   LOWER_CASE_WITH_DASHES {
      public String translateName(Field var1) {
         return FieldNamingPolicy.separateCamelCase(var1.getName(), "-").toLowerCase();
      }
   },
   LOWER_CASE_WITH_UNDERSCORES {
      public String translateName(Field var1) {
         return FieldNamingPolicy.separateCamelCase(var1.getName(), "_").toLowerCase();
      }
   },
   UPPER_CAMEL_CASE {
      public String translateName(Field var1) {
         return FieldNamingPolicy.upperCaseFirstLetter(var1.getName());
      }
   },
   UPPER_CAMEL_CASE_WITH_SPACES {
      public String translateName(Field var1) {
         return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(var1.getName(), " "));
      }
   };

   private FieldNamingPolicy() {
   }

   // $FF: synthetic method
   FieldNamingPolicy(Object var3) {
      this();
   }

   private static String modifyString(char var0, String var1, int var2) {
      return var2 < var1.length()?var0 + var1.substring(var2):String.valueOf(var0);
   }

   private static String separateCamelCase(String var0, String var1) {
      StringBuilder var4 = new StringBuilder();

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         char var2 = var0.charAt(var3);
         if(Character.isUpperCase(var2) && var4.length() != 0) {
            var4.append(var1);
         }

         var4.append(var2);
      }

      return var4.toString();
   }

   private static String upperCaseFirstLetter(String var0) {
      StringBuilder var4 = new StringBuilder();
      int var2 = 0;

      char var1;
      for(var1 = var0.charAt(0); var2 < var0.length() - 1 && !Character.isLetter(var1); var1 = var0.charAt(var2)) {
         var4.append(var1);
         ++var2;
      }

      String var3;
      if(var2 == var0.length()) {
         var3 = var4.toString();
      } else {
         var3 = var0;
         if(!Character.isUpperCase(var1)) {
            return var4.append(modifyString(Character.toUpperCase(var1), var0, var2 + 1)).toString();
         }
      }

      return var3;
   }
}
