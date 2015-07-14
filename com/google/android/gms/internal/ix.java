package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.is;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ix {
   private static final is Hh = new is("MetadataUtils");
   private static final String[] Iq = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
   private static final String Ir;

   static {
      Ir = "yyyyMMdd\'T\'HHmmss" + Iq[0];
   }

   public static String a(Calendar var0) {
      String var3;
      if(var0 == null) {
         Hh.b("Calendar object cannot be null", new Object[0]);
         var3 = null;
      } else {
         String var2 = Ir;
         String var1 = var2;
         if(var0.get(11) == 0) {
            var1 = var2;
            if(var0.get(12) == 0) {
               var1 = var2;
               if(var0.get(13) == 0) {
                  var1 = "yyyyMMdd";
               }
            }
         }

         SimpleDateFormat var4 = new SimpleDateFormat(var1);
         var4.setTimeZone(var0.getTimeZone());
         var1 = var4.format(var0.getTime());
         var3 = var1;
         if(var1.endsWith("+0000")) {
            return var1.replace("+0000", Iq[0]);
         }
      }

      return var3;
   }

   public static void a(List param0, JSONObject param1) {
      // $FF: Couldn't be decompiled
   }

   public static void a(JSONObject var0, List var1) {
      if(var1 != null && !var1.isEmpty()) {
         JSONArray var2 = new JSONArray();
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            var2.put(((WebImage)var4.next()).toJson());
         }

         try {
            var0.put("images", var2);
         } catch (JSONException var3) {
            return;
         }
      }

   }

   public static Calendar aL(String var0) {
      if(TextUtils.isEmpty(var0)) {
         Hh.b("Input string is empty or null", new Object[0]);
         return null;
      } else {
         String var2 = aM(var0);
         if(TextUtils.isEmpty(var2)) {
            Hh.b("Invalid date format", new Object[0]);
            return null;
         } else {
            String var3 = aN(var0);
            var0 = "yyyyMMdd";
            String var1 = var2;
            if(!TextUtils.isEmpty(var3)) {
               var1 = var2 + "T" + var3;
               if(var3.length() == "HHmmss".length()) {
                  var0 = "yyyyMMdd\'T\'HHmmss";
               } else {
                  var0 = Ir;
               }
            }

            Calendar var6 = GregorianCalendar.getInstance();

            Date var5;
            try {
               var5 = (new SimpleDateFormat(var0)).parse(var1);
            } catch (ParseException var4) {
               Hh.b("Error parsing string: %s", new Object[]{var4.getMessage()});
               return null;
            }

            var6.setTime(var5);
            return var6;
         }
      }
   }

   private static String aM(String var0) {
      if(TextUtils.isEmpty(var0)) {
         Hh.b("Input string is empty or null", new Object[0]);
         return null;
      } else {
         try {
            var0 = var0.substring(0, "yyyyMMdd".length());
            return var0;
         } catch (IndexOutOfBoundsException var1) {
            Hh.c("Error extracting the date: %s", new Object[]{var1.getMessage()});
            return null;
         }
      }
   }

   private static String aN(String var0) {
      if(TextUtils.isEmpty(var0)) {
         Hh.b("string is empty or null", new Object[0]);
      } else {
         int var1 = var0.indexOf(84);
         if(var1 != "yyyyMMdd".length()) {
            Hh.b("T delimeter is not found", new Object[0]);
            return null;
         }

         try {
            var0 = var0.substring(var1 + 1);
         } catch (IndexOutOfBoundsException var2) {
            Hh.b("Error extracting the time substring: %s", new Object[]{var2.getMessage()});
            return null;
         }

         if(var0.length() == "HHmmss".length()) {
            return var0;
         }

         switch(var0.charAt("HHmmss".length())) {
         case '+':
         case '-':
            if(aO(var0)) {
               return var0.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
            }
            break;
         case 'Z':
            if(var0.length() == "HHmmss".length() + Iq[0].length()) {
               return var0.substring(0, var0.length() - 1) + "+0000";
            }
            break;
         default:
            return null;
         }
      }

      return null;
   }

   private static boolean aO(String var0) {
      int var1 = var0.length();
      int var2 = "HHmmss".length();
      return var1 == Iq[1].length() + var2 || var1 == Iq[2].length() + var2 || var1 == var2 + Iq[3].length();
   }
}
