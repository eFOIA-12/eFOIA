package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Gson {
   static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
   private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}\'\n";
   private final ThreadLocal calls;
   private final ConstructorConstructor constructorConstructor;
   final JsonDeserializationContext deserializationContext;
   private final List factories;
   private final boolean generateNonExecutableJson;
   private final boolean htmlSafe;
   private final boolean prettyPrinting;
   final JsonSerializationContext serializationContext;
   private final boolean serializeNulls;
   private final Map typeTokenCache;

   public Gson() {
      this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
   }

   Gson(Excluder var1, FieldNamingStrategy var2, Map var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, LongSerializationPolicy var10, List var11) {
      this.calls = new ThreadLocal();
      this.typeTokenCache = Collections.synchronizedMap(new HashMap());
      this.deserializationContext = new JsonDeserializationContext() {
         public Object deserialize(JsonElement var1, Type var2) throws JsonParseException {
            return Gson.this.fromJson(var1, var2);
         }
      };
      this.serializationContext = new JsonSerializationContext() {
         public JsonElement serialize(Object var1) {
            return Gson.this.toJsonTree(var1);
         }

         public JsonElement serialize(Object var1, Type var2) {
            return Gson.this.toJsonTree(var1, var2);
         }
      };
      this.constructorConstructor = new ConstructorConstructor(var3);
      this.serializeNulls = var4;
      this.generateNonExecutableJson = var6;
      this.htmlSafe = var7;
      this.prettyPrinting = var8;
      ArrayList var12 = new ArrayList();
      var12.add(TypeAdapters.JSON_ELEMENT_FACTORY);
      var12.add(ObjectTypeAdapter.FACTORY);
      var12.add(var1);
      var12.addAll(var11);
      var12.add(TypeAdapters.STRING_FACTORY);
      var12.add(TypeAdapters.INTEGER_FACTORY);
      var12.add(TypeAdapters.BOOLEAN_FACTORY);
      var12.add(TypeAdapters.BYTE_FACTORY);
      var12.add(TypeAdapters.SHORT_FACTORY);
      var12.add(TypeAdapters.newFactory(Long.TYPE, Long.class, this.longAdapter(var10)));
      var12.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(var9)));
      var12.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(var9)));
      var12.add(TypeAdapters.NUMBER_FACTORY);
      var12.add(TypeAdapters.CHARACTER_FACTORY);
      var12.add(TypeAdapters.STRING_BUILDER_FACTORY);
      var12.add(TypeAdapters.STRING_BUFFER_FACTORY);
      var12.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
      var12.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
      var12.add(TypeAdapters.URL_FACTORY);
      var12.add(TypeAdapters.URI_FACTORY);
      var12.add(TypeAdapters.UUID_FACTORY);
      var12.add(TypeAdapters.LOCALE_FACTORY);
      var12.add(TypeAdapters.INET_ADDRESS_FACTORY);
      var12.add(TypeAdapters.BIT_SET_FACTORY);
      var12.add(DateTypeAdapter.FACTORY);
      var12.add(TypeAdapters.CALENDAR_FACTORY);
      var12.add(TimeTypeAdapter.FACTORY);
      var12.add(SqlDateTypeAdapter.FACTORY);
      var12.add(TypeAdapters.TIMESTAMP_FACTORY);
      var12.add(ArrayTypeAdapter.FACTORY);
      var12.add(TypeAdapters.CLASS_FACTORY);
      var12.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
      var12.add(new MapTypeAdapterFactory(this.constructorConstructor, var5));
      var12.add(new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor));
      var12.add(TypeAdapters.ENUM_FACTORY);
      var12.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, var2, var1));
      this.factories = Collections.unmodifiableList(var12);
   }

   private static void assertFullConsumption(Object var0, JsonReader var1) {
      if(var0 != null) {
         try {
            if(var1.peek() != JsonToken.END_DOCUMENT) {
               throw new JsonIOException("JSON document was not fully consumed.");
            }
         } catch (MalformedJsonException var2) {
            throw new JsonSyntaxException(var2);
         } catch (IOException var3) {
            throw new JsonIOException(var3);
         }
      }

   }

   private void checkValidFloatingPoint(double var1) {
      if(Double.isNaN(var1) || Double.isInfinite(var1)) {
         throw new IllegalArgumentException(var1 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
      }
   }

   private TypeAdapter doubleAdapter(boolean var1) {
      return var1?TypeAdapters.DOUBLE:new TypeAdapter() {
         public Double read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Double.valueOf(var1.nextDouble());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               double var3 = var2.doubleValue();
               Gson.this.checkValidFloatingPoint(var3);
               var1.value(var2);
            }
         }
      };
   }

   private TypeAdapter floatAdapter(boolean var1) {
      return var1?TypeAdapters.FLOAT:new TypeAdapter() {
         public Float read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Float.valueOf((float)var1.nextDouble());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               float var3 = var2.floatValue();
               Gson.this.checkValidFloatingPoint((double)var3);
               var1.value(var2);
            }
         }
      };
   }

   private TypeAdapter longAdapter(LongSerializationPolicy var1) {
      return var1 == LongSerializationPolicy.DEFAULT?TypeAdapters.LONG:new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Long.valueOf(var1.nextLong());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               var1.value(var2.toString());
            }
         }
      };
   }

   private JsonWriter newJsonWriter(Writer var1) throws IOException {
      if(this.generateNonExecutableJson) {
         var1.write(")]}\'\n");
      }

      JsonWriter var2 = new JsonWriter(var1);
      if(this.prettyPrinting) {
         var2.setIndent("  ");
      }

      var2.setSerializeNulls(this.serializeNulls);
      return var2;
   }

   public Object fromJson(JsonElement var1, Class var2) throws JsonSyntaxException {
      Object var3 = this.fromJson((JsonElement)var1, (Type)var2);
      return Primitives.wrap(var2).cast(var3);
   }

   public Object fromJson(JsonElement var1, Type var2) throws JsonSyntaxException {
      return var1 == null?null:this.fromJson((JsonReader)(new JsonTreeReader(var1)), (Type)var2);
   }

   public Object fromJson(JsonReader param1, Type param2) throws JsonIOException, JsonSyntaxException {
      // $FF: Couldn't be decompiled
   }

   public Object fromJson(Reader var1, Class var2) throws JsonSyntaxException, JsonIOException {
      JsonReader var4 = new JsonReader(var1);
      Object var3 = this.fromJson((JsonReader)var4, (Type)var2);
      assertFullConsumption(var3, var4);
      return Primitives.wrap(var2).cast(var3);
   }

   public Object fromJson(Reader var1, Type var2) throws JsonIOException, JsonSyntaxException {
      JsonReader var3 = new JsonReader(var1);
      Object var4 = this.fromJson(var3, var2);
      assertFullConsumption(var4, var3);
      return var4;
   }

   public Object fromJson(String var1, Class var2) throws JsonSyntaxException {
      Object var3 = this.fromJson((String)var1, (Type)var2);
      return Primitives.wrap(var2).cast(var3);
   }

   public Object fromJson(String var1, Type var2) throws JsonSyntaxException {
      return var1 == null?null:this.fromJson((Reader)(new StringReader(var1)), (Type)var2);
   }

   public TypeAdapter getAdapter(TypeToken param1) {
      // $FF: Couldn't be decompiled
   }

   public TypeAdapter getAdapter(Class var1) {
      return this.getAdapter(TypeToken.get(var1));
   }

   public TypeAdapter getDelegateAdapter(TypeAdapterFactory var1, TypeToken var2) {
      boolean var3 = false;
      if(!this.factories.contains(var1)) {
         var3 = true;
      }

      Iterator var4 = this.factories.iterator();

      while(var4.hasNext()) {
         TypeAdapterFactory var5 = (TypeAdapterFactory)var4.next();
         if(!var3) {
            if(var5 == var1) {
               var3 = true;
            }
         } else {
            TypeAdapter var6 = var5.create(this, var2);
            if(var6 != null) {
               return var6;
            }
         }
      }

      throw new IllegalArgumentException("GSON cannot serialize " + var2);
   }

   public String toJson(JsonElement var1) {
      StringWriter var2 = new StringWriter();
      this.toJson((JsonElement)var1, (Appendable)var2);
      return var2.toString();
   }

   public String toJson(Object var1) {
      return var1 == null?this.toJson((JsonElement)JsonNull.INSTANCE):this.toJson((Object)var1, (Type)var1.getClass());
   }

   public String toJson(Object var1, Type var2) {
      StringWriter var3 = new StringWriter();
      this.toJson(var1, var2, (Appendable)var3);
      return var3.toString();
   }

   public void toJson(JsonElement var1, JsonWriter var2) throws JsonIOException {
      boolean var3 = var2.isLenient();
      var2.setLenient(true);
      boolean var4 = var2.isHtmlSafe();
      var2.setHtmlSafe(this.htmlSafe);
      boolean var5 = var2.getSerializeNulls();
      var2.setSerializeNulls(this.serializeNulls);

      try {
         Streams.write(var1, var2);
      } catch (IOException var8) {
         throw new JsonIOException(var8);
      } finally {
         var2.setLenient(var3);
         var2.setHtmlSafe(var4);
         var2.setSerializeNulls(var5);
      }

   }

   public void toJson(JsonElement var1, Appendable var2) throws JsonIOException {
      try {
         this.toJson(var1, this.newJsonWriter(Streams.writerForAppendable(var2)));
      } catch (IOException var3) {
         throw new RuntimeException(var3);
      }
   }

   public void toJson(Object var1, Appendable var2) throws JsonIOException {
      if(var1 != null) {
         this.toJson(var1, var1.getClass(), (Appendable)var2);
      } else {
         this.toJson((JsonElement)JsonNull.INSTANCE, (Appendable)var2);
      }
   }

   public void toJson(Object var1, Type var2, JsonWriter var3) throws JsonIOException {
      TypeAdapter var11 = this.getAdapter(TypeToken.get(var2));
      boolean var4 = var3.isLenient();
      var3.setLenient(true);
      boolean var5 = var3.isHtmlSafe();
      var3.setHtmlSafe(this.htmlSafe);
      boolean var6 = var3.getSerializeNulls();
      var3.setSerializeNulls(this.serializeNulls);

      try {
         var11.write(var3, var1);
      } catch (IOException var9) {
         throw new JsonIOException(var9);
      } finally {
         var3.setLenient(var4);
         var3.setHtmlSafe(var5);
         var3.setSerializeNulls(var6);
      }

   }

   public void toJson(Object var1, Type var2, Appendable var3) throws JsonIOException {
      try {
         this.toJson(var1, var2, this.newJsonWriter(Streams.writerForAppendable(var3)));
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      }
   }

   public JsonElement toJsonTree(Object var1) {
      return (JsonElement)(var1 == null?JsonNull.INSTANCE:this.toJsonTree(var1, var1.getClass()));
   }

   public JsonElement toJsonTree(Object var1, Type var2) {
      JsonTreeWriter var3 = new JsonTreeWriter();
      this.toJson(var1, var2, (JsonWriter)var3);
      return var3.get();
   }

   public String toString() {
      return "{serializeNulls:" + this.serializeNulls + "factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
   }

   static class FutureTypeAdapter extends TypeAdapter {
      private TypeAdapter delegate;

      public Object read(JsonReader var1) throws IOException {
         if(this.delegate == null) {
            throw new IllegalStateException();
         } else {
            return this.delegate.read(var1);
         }
      }

      public void setDelegate(TypeAdapter var1) {
         if(this.delegate != null) {
            throw new AssertionError();
         } else {
            this.delegate = var1;
         }
      }

      public void write(JsonWriter var1, Object var2) throws IOException {
         if(this.delegate == null) {
            throw new IllegalStateException();
         } else {
            this.delegate.write(var1, var2);
         }
      }
   }
}
