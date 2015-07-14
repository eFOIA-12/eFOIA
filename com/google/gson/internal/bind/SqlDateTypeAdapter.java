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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public TypeAdapter create(Gson var1, TypeToken var2) {
         return var2.getRawType() == Date.class?new SqlDateTypeAdapter():null;
      }
   };
   private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

   public Date read(JsonReader var1) throws IOException {
      synchronized(this){}
      boolean var4 = false;

      Date var7;
      try {
         var4 = true;
         if(var1.peek() != JsonToken.NULL) {
            try {
               var7 = new Date(this.format.parse(var1.nextString()).getTime());
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

   public void write(JsonWriter param1, Date param2) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
