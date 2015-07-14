package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class JsonTreeReader extends JsonReader {
   private static final Object SENTINEL_CLOSED = new Object();
   private static final Reader UNREADABLE_READER = new Reader() {
      public void close() throws IOException {
         throw new AssertionError();
      }

      public int read(char[] var1, int var2, int var3) throws IOException {
         throw new AssertionError();
      }
   };
   private final List stack = new ArrayList();

   public JsonTreeReader(JsonElement var1) {
      super(UNREADABLE_READER);
      this.stack.add(var1);
   }

   private void expect(JsonToken var1) throws IOException {
      if(this.peek() != var1) {
         throw new IllegalStateException("Expected " + var1 + " but was " + this.peek());
      }
   }

   private Object peekStack() {
      return this.stack.get(this.stack.size() - 1);
   }

   private Object popStack() {
      return this.stack.remove(this.stack.size() - 1);
   }

   public void beginArray() throws IOException {
      this.expect(JsonToken.BEGIN_ARRAY);
      JsonArray var1 = (JsonArray)this.peekStack();
      this.stack.add(var1.iterator());
   }

   public void beginObject() throws IOException {
      this.expect(JsonToken.BEGIN_OBJECT);
      JsonObject var1 = (JsonObject)this.peekStack();
      this.stack.add(var1.entrySet().iterator());
   }

   public void close() throws IOException {
      this.stack.clear();
      this.stack.add(SENTINEL_CLOSED);
   }

   public void endArray() throws IOException {
      this.expect(JsonToken.END_ARRAY);
      this.popStack();
      this.popStack();
   }

   public void endObject() throws IOException {
      this.expect(JsonToken.END_OBJECT);
      this.popStack();
      this.popStack();
   }

   public boolean hasNext() throws IOException {
      JsonToken var1 = this.peek();
      return var1 != JsonToken.END_OBJECT && var1 != JsonToken.END_ARRAY;
   }

   public boolean nextBoolean() throws IOException {
      this.expect(JsonToken.BOOLEAN);
      return ((JsonPrimitive)this.popStack()).getAsBoolean();
   }

   public double nextDouble() throws IOException {
      JsonToken var3 = this.peek();
      if(var3 != JsonToken.NUMBER && var3 != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + var3);
      } else {
         double var1 = ((JsonPrimitive)this.peekStack()).getAsDouble();
         if(!this.isLenient() && (Double.isNaN(var1) || Double.isInfinite(var1))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + var1);
         } else {
            this.popStack();
            return var1;
         }
      }
   }

   public int nextInt() throws IOException {
      JsonToken var2 = this.peek();
      if(var2 != JsonToken.NUMBER && var2 != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + var2);
      } else {
         int var1 = ((JsonPrimitive)this.peekStack()).getAsInt();
         this.popStack();
         return var1;
      }
   }

   public long nextLong() throws IOException {
      JsonToken var3 = this.peek();
      if(var3 != JsonToken.NUMBER && var3 != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + var3);
      } else {
         long var1 = ((JsonPrimitive)this.peekStack()).getAsLong();
         this.popStack();
         return var1;
      }
   }

   public String nextName() throws IOException {
      this.expect(JsonToken.NAME);
      Entry var1 = (Entry)((Iterator)this.peekStack()).next();
      this.stack.add(var1.getValue());
      return (String)var1.getKey();
   }

   public void nextNull() throws IOException {
      this.expect(JsonToken.NULL);
      this.popStack();
   }

   public String nextString() throws IOException {
      JsonToken var1 = this.peek();
      if(var1 != JsonToken.STRING && var1 != JsonToken.NUMBER) {
         throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + var1);
      } else {
         return ((JsonPrimitive)this.popStack()).getAsString();
      }
   }

   public JsonToken peek() throws IOException {
      if(this.stack.isEmpty()) {
         return JsonToken.END_DOCUMENT;
      } else {
         Object var2 = this.peekStack();
         if(var2 instanceof Iterator) {
            boolean var1 = this.stack.get(this.stack.size() - 2) instanceof JsonObject;
            Iterator var4 = (Iterator)var2;
            if(var4.hasNext()) {
               if(var1) {
                  return JsonToken.NAME;
               } else {
                  this.stack.add(var4.next());
                  return this.peek();
               }
            } else {
               return var1?JsonToken.END_OBJECT:JsonToken.END_ARRAY;
            }
         } else if(var2 instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
         } else if(var2 instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
         } else if(var2 instanceof JsonPrimitive) {
            JsonPrimitive var3 = (JsonPrimitive)var2;
            if(var3.isString()) {
               return JsonToken.STRING;
            } else if(var3.isBoolean()) {
               return JsonToken.BOOLEAN;
            } else if(var3.isNumber()) {
               return JsonToken.NUMBER;
            } else {
               throw new AssertionError();
            }
         } else if(var2 instanceof JsonNull) {
            return JsonToken.NULL;
         } else if(var2 == SENTINEL_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
         } else {
            throw new AssertionError();
         }
      }
   }

   public void promoteNameToValue() throws IOException {
      this.expect(JsonToken.NAME);
      Entry var1 = (Entry)((Iterator)this.peekStack()).next();
      this.stack.add(var1.getValue());
      this.stack.add(new JsonPrimitive((String)var1.getKey()));
   }

   public void skipValue() throws IOException {
      if(this.peek() == JsonToken.NAME) {
         this.nextName();
      } else {
         this.popStack();
      }
   }

   public String toString() {
      return this.getClass().getSimpleName();
   }
}
