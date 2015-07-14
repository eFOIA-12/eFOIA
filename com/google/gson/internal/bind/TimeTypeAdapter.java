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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public TypeAdapter create(Gson var1, TypeToken var2) {
         return var2.getRawType() == Time.class?new TimeTypeAdapter():null;
      }
   };
   private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

   public Time read(JsonReader var1) throws IOException {
      synchronized(this){}
      boolean var4 = false;

      Time var7;
      try {
         var4 = true;
         if(var1.peek() != JsonToken.NULL) {
            try {
               var7 = new Time(this.format.parse(var1.nextString()).getTime());
               var4 = false;
               return var7;
            } catch (ParseException var5) {
               throw new JsonSyntaxException(var5);
            }
         }

         var1.nextNull();
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      var7 = null;
      return var7;
   }

   public void write(JsonWriter param1, Time param2) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
