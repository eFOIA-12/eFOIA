package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ExceptionParser;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser {
   private final TreeSet Cd = new TreeSet();

   public StandardExceptionParser(Context var1, Collection var2) {
      this.setIncludedPackages(var1, var2);
   }

   protected StackTraceElement getBestStackTraceElement(Throwable var1) {
      StackTraceElement[] var7 = var1.getStackTrace();
      if(var7 != null && var7.length != 0) {
         int var3 = var7.length;
         int var2 = 0;

         label23:
         while(var2 < var3) {
            StackTraceElement var4 = var7[var2];
            String var5 = var4.getClassName();
            Iterator var6 = this.Cd.iterator();

            do {
               if(!var6.hasNext()) {
                  ++var2;
                  continue label23;
               }
            } while(!var5.startsWith((String)var6.next()));

            return var4;
         }

         return var7[0];
      } else {
         return null;
      }
   }

   protected Throwable getCause(Throwable var1) {
      while(var1.getCause() != null) {
         var1 = var1.getCause();
      }

      return var1;
   }

   public String getDescription(String var1, Throwable var2) {
      return this.getDescription(this.getCause(var2), this.getBestStackTraceElement(this.getCause(var2)), var1);
   }

   protected String getDescription(Throwable var1, StackTraceElement var2, String var3) {
      StringBuilder var5 = new StringBuilder();
      var5.append(var1.getClass().getSimpleName());
      if(var2 != null) {
         String[] var6 = var2.getClassName().split("\\.");
         String var4 = "unknown";
         String var7 = var4;
         if(var6 != null) {
            var7 = var4;
            if(var6.length > 0) {
               var7 = var6[var6.length - 1];
            }
         }

         var5.append(String.format(" (@%s:%s:%s)", new Object[]{var7, var2.getMethodName(), Integer.valueOf(var2.getLineNumber())}));
      }

      if(var3 != null) {
         var5.append(String.format(" {%s}", new Object[]{var3}));
      }

      return var5.toString();
   }

   public void setIncludedPackages(Context param1, Collection param2) {
      // $FF: Couldn't be decompiled
   }
}
