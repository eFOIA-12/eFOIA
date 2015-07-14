package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.EOFException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator {
   private final Object lock;
   private final JsonReader parser;

   public JsonStreamParser(Reader var1) {
      this.parser = new JsonReader(var1);
      this.parser.setLenient(true);
      this.lock = new Object();
   }

   public JsonStreamParser(String var1) {
      this((Reader)(new StringReader(var1)));
   }

   public boolean hasNext() {
      // $FF: Couldn't be decompiled
   }

   public JsonElement next() throws JsonParseException {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         try {
            JsonElement var6 = Streams.parse(this.parser);
            return var6;
         } catch (StackOverflowError var3) {
            throw new JsonParseException("Failed parsing JSON source to Json", var3);
         } catch (OutOfMemoryError var4) {
            throw new JsonParseException("Failed parsing JSON source to Json", var4);
         } catch (JsonParseException var5) {
            Object var1 = var5;
            if(var5.getCause() instanceof EOFException) {
               var1 = new NoSuchElementException();
            }

            throw var1;
         }
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
