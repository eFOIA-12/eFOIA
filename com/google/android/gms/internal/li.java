package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class li {
   private static final Pattern Og = Pattern.compile("\\\\.");
   private static final Pattern Oh = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

   public static String bh(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         Matcher var3 = Oh.matcher(var0);
         StringBuffer var1 = null;

         while(var3.find()) {
            StringBuffer var2 = var1;
            if(var1 == null) {
               var2 = new StringBuffer();
            }

            switch(var3.group().charAt(0)) {
            case '\b':
               var3.appendReplacement(var2, "\\\\b");
               var1 = var2;
               break;
            case '\t':
               var3.appendReplacement(var2, "\\\\t");
               var1 = var2;
               break;
            case '\n':
               var3.appendReplacement(var2, "\\\\n");
               var1 = var2;
               break;
            case '\f':
               var3.appendReplacement(var2, "\\\\f");
               var1 = var2;
               break;
            case '\r':
               var3.appendReplacement(var2, "\\\\r");
               var1 = var2;
               break;
            case '\"':
               var3.appendReplacement(var2, "\\\\\\\"");
               var1 = var2;
               break;
            case '/':
               var3.appendReplacement(var2, "\\\\/");
               var1 = var2;
               break;
            case '\\':
               var3.appendReplacement(var2, "\\\\\\\\");
               var1 = var2;
               break;
            default:
               var1 = var2;
            }
         }

         if(var1 != null) {
            var3.appendTail(var1);
            return var1.toString();
         }
      }

      return var0;
   }

   public static boolean d(Object var0, Object var1) {
      boolean var3;
      if(var0 instanceof JSONObject && var1 instanceof JSONObject) {
         JSONObject var9 = (JSONObject)var0;
         JSONObject var11 = (JSONObject)var1;
         if(var9.length() == var11.length()) {
            Iterator var4 = var9.keys();

            while(true) {
               if(!var4.hasNext()) {
                  return true;
               }

               String var5 = (String)var4.next();
               if(!var11.has(var5)) {
                  break;
               }

               try {
                  var3 = d(var9.get(var5), var11.get(var5));
               } catch (JSONException var7) {
                  return false;
               }

               if(!var3) {
                  return false;
               }
            }
         }
      } else {
         if(!(var0 instanceof JSONArray) || !(var1 instanceof JSONArray)) {
            return var0.equals(var1);
         }

         JSONArray var8 = (JSONArray)var0;
         JSONArray var10 = (JSONArray)var1;
         if(var8.length() == var10.length()) {
            int var2 = 0;

            while(true) {
               if(var2 >= var8.length()) {
                  return true;
               }

               try {
                  var3 = d(var8.get(var2), var10.get(var2));
               } catch (JSONException var6) {
                  return false;
               }

               if(!var3) {
                  break;
               }

               ++var2;
            }
         }
      }

      return false;
   }
}
