package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DateDeserializer implements JsonDeserializer {
   private static final String[] DATE_FORMATS = new String[]{"yyyy-MM-dd\'T\'HH:mm:ssZ", "yyyy-MM-dd\'T\'HH:mm:ss", "yyyy-MM-dd"};

   public Date deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      String[] var7 = DATE_FORMATS;
      int var5 = var7.length;
      int var4 = 0;

      while(var4 < var5) {
         String var8 = var7[var4];

         try {
            Date var9 = (new SimpleDateFormat(var8, Locale.US)).parse(var1.getAsString());
            return var9;
         } catch (ParseException var6) {
            ++var4;
         }
      }

      throw new JsonParseException("Unparseable date: \"" + var1.getAsString() + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
   }
}
