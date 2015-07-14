package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTypeAdapter extends TypeAdapter {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public TypeAdapter create(Gson var1, TypeToken var2) {
         return var2.getRawType() == Date.class?new DateTypeAdapter():null;
      }
   };
   private final DateFormat enUsFormat;
   private final DateFormat iso8601Format;
   private final DateFormat localFormat;

   public DateTypeAdapter() {
      this.enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
      this.localFormat = DateFormat.getDateTimeInstance(2, 2);
      this.iso8601Format = buildIso8601Format();
   }

   private static DateFormat buildIso8601Format() {
      SimpleDateFormat var0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.US);
      var0.setTimeZone(TimeZone.getTimeZone("UTC"));
      return var0;
   }

   private Date deserializeToDate(String var1) {
      synchronized(this){}
      boolean var7 = false;

      Date var2;
      Date var12;
      label84: {
         label85: {
            try {
               try {
                  var7 = true;
                  var2 = this.localFormat.parse(var1);
                  var7 = false;
                  break label84;
               } catch (ParseException var9) {
                  ;
               }

               try {
                  var2 = this.enUsFormat.parse(var1);
                  var7 = false;
                  break label85;
               } catch (ParseException var10) {
                  try {
                     var2 = this.iso8601Format.parse(var1);
                     var7 = false;
                  } catch (ParseException var8) {
                     throw new JsonSyntaxException(var1, var8);
                  }
               }
            } finally {
               if(var7) {
                  ;
               }
            }

            var12 = var2;
            return var12;
         }

         var12 = var2;
         return var12;
      }

      var12 = var2;
      return var12;
   }

   public Date read(JsonReader var1) throws IOException {
      if(var1.peek() == JsonToken.NULL) {
         var1.nextNull();
         return null;
      } else {
         return this.deserializeToDate(var1.nextString());
      }
   }

   public void write(JsonWriter param1, Date param2) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
