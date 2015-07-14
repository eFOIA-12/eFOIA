package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class ka {
   public static String a(String var0, String var1, Context var2, AttributeSet var3, boolean var4, boolean var5, String var6) {
      if(var3 == null) {
         var0 = null;
      } else {
         var0 = var3.getAttributeValue(var0, var1);
      }

      String var10 = var0;
      if(var0 != null) {
         var10 = var0;
         if(var0.startsWith("@string/")) {
            var10 = var0;
            if(var4) {
               String var7 = var0.substring("@string/".length());
               String var8 = var2.getPackageName();
               TypedValue var11 = new TypedValue();

               try {
                  var2.getResources().getValue(var8 + ":string/" + var7, var11, true);
               } catch (NotFoundException var9) {
                  Log.w(var6, "Could not find resource for " + var1 + ": " + var0);
               }

               if(var11.string != null) {
                  var10 = var11.string.toString();
               } else {
                  Log.w(var6, "Resource " + var1 + " was not a string: " + var11);
                  var10 = var0;
               }
            }
         }
      }

      if(var5 && var10 == null) {
         Log.w(var6, "Required XML attribute \"" + var1 + "\" missing");
      }

      return var10;
   }
}
