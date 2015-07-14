package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
   public JsonElement parse(JsonReader param1) throws JsonIOException, JsonSyntaxException {
      // $FF: Couldn't be decompiled
   }

   public JsonElement parse(Reader var1) throws JsonIOException, JsonSyntaxException {
      try {
         JsonReader var6 = new JsonReader(var1);
         JsonElement var2 = this.parse(var6);
         if(!var2.isJsonNull() && var6.peek() != JsonToken.END_DOCUMENT) {
            throw new JsonSyntaxException("Did not consume the entire document.");
         } else {
            return var2;
         }
      } catch (MalformedJsonException var3) {
         throw new JsonSyntaxException(var3);
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      } catch (NumberFormatException var5) {
         throw new JsonSyntaxException(var5);
      }
   }

   public JsonElement parse(String var1) throws JsonSyntaxException {
      return this.parse((Reader)(new StringReader(var1)));
   }
}
