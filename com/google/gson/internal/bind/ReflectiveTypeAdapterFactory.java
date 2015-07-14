package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
   private final ConstructorConstructor constructorConstructor;
   private final Excluder excluder;
   private final FieldNamingStrategy fieldNamingPolicy;

   public ReflectiveTypeAdapterFactory(ConstructorConstructor var1, FieldNamingStrategy var2, Excluder var3) {
      this.constructorConstructor = var1;
      this.fieldNamingPolicy = var2;
      this.excluder = var3;
   }

   private ReflectiveTypeAdapterFactory.BoundField createBoundField(final Gson var1, final Field var2, final String var3, final TypeToken var4, final boolean var5, final boolean var6) {
      return new ReflectiveTypeAdapterFactory.BoundField(var3, var5, var6) {
         final TypeAdapter typeAdapter;
         // $FF: synthetic field
         final boolean val$isPrimitive;

         {
            this.val$isPrimitive = var8;
            this.typeAdapter = ReflectiveTypeAdapterFactory.this.getFieldAdapter(var1, var2, var4);
         }

         void read(JsonReader var1x, Object var2x) throws IOException, IllegalAccessException {
            Object var3 = this.typeAdapter.read(var1x);
            if(var3 != null || !this.val$isPrimitive) {
               var2.set(var2x, var3);
            }

         }

         void write(JsonWriter var1x, Object var2x) throws IOException, IllegalAccessException {
            var2x = var2.get(var2x);
            (new TypeAdapterRuntimeTypeWrapper(var1, this.typeAdapter, var4.getType())).write(var1x, var2x);
         }

         public boolean writeField(Object var1x) throws IOException, IllegalAccessException {
            return this.serialized && var2.get(var1x) != var1x;
         }
      };
   }

   static boolean excludeField(Field var0, boolean var1, Excluder var2) {
      return !var2.excludeClass(var0.getType(), var1) && !var2.excludeField(var0, var1);
   }

   private Map getBoundFields(Gson var1, TypeToken var2, Class var3) {
      LinkedHashMap var8 = new LinkedHashMap();
      if(!var3.isInterface()) {
         for(Type var9 = var2.getType(); var3 != Object.class; var3 = var2.getRawType()) {
            Field[] var10 = var3.getDeclaredFields();
            int var5 = var10.length;

            for(int var4 = 0; var4 < var5; ++var4) {
               Field var11 = var10[var4];
               boolean var6 = this.excludeField(var11, true);
               boolean var7 = this.excludeField(var11, false);
               if(var6 || var7) {
                  var11.setAccessible(true);
                  Type var12 = $Gson$Types.resolve(var2.getType(), var3, var11.getGenericType());
                  ReflectiveTypeAdapterFactory.BoundField var13 = this.createBoundField(var1, var11, this.getFieldName(var11), TypeToken.get(var12), var6, var7);
                  var13 = (ReflectiveTypeAdapterFactory.BoundField)var8.put(var13.name, var13);
                  if(var13 != null) {
                     throw new IllegalArgumentException(var9 + " declares multiple JSON fields named " + var13.name);
                  }
               }
            }

            var2 = TypeToken.get($Gson$Types.resolve(var2.getType(), var3, var3.getGenericSuperclass()));
         }
      }

      return var8;
   }

   private TypeAdapter getFieldAdapter(Gson var1, Field var2, TypeToken var3) {
      JsonAdapter var4 = (JsonAdapter)var2.getAnnotation(JsonAdapter.class);
      if(var4 != null) {
         TypeAdapter var5 = JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(this.constructorConstructor, var1, var3, var4);
         if(var5 != null) {
            return var5;
         }
      }

      return var1.getAdapter(var3);
   }

   static String getFieldName(FieldNamingStrategy var0, Field var1) {
      SerializedName var2 = (SerializedName)var1.getAnnotation(SerializedName.class);
      return var2 == null?var0.translateName(var1):var2.value();
   }

   private String getFieldName(Field var1) {
      return getFieldName(this.fieldNamingPolicy, var1);
   }

   public TypeAdapter create(Gson var1, TypeToken var2) {
      Class var3 = var2.getRawType();
      return !Object.class.isAssignableFrom(var3)?null:new ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(var2), this.getBoundFields(var1, var2, var3), null);
   }

   public boolean excludeField(Field var1, boolean var2) {
      return excludeField(var1, var2, this.excluder);
   }

   public static final class Adapter extends TypeAdapter {
      private final Map boundFields;
      private final ObjectConstructor constructor;

      private Adapter(ObjectConstructor var1, Map var2) {
         this.constructor = var1;
         this.boundFields = var2;
      }

      // $FF: synthetic method
      Adapter(ObjectConstructor var1, Map var2, Object var3) {
         this(var1, var2);
      }

      public Object read(JsonReader param1) throws IOException {
         // $FF: Couldn't be decompiled
      }

      public void write(JsonWriter param1, Object param2) throws IOException {
         // $FF: Couldn't be decompiled
      }
   }

   abstract static class BoundField {
      final boolean deserialized;
      final String name;
      final boolean serialized;

      protected BoundField(String var1, boolean var2, boolean var3) {
         this.name = var1;
         this.serialized = var2;
         this.deserialized = var3;
      }

      abstract void read(JsonReader var1, Object var2) throws IOException, IllegalAccessException;

      abstract void write(JsonWriter var1, Object var2) throws IOException, IllegalAccessException;

      abstract boolean writeField(Object var1) throws IOException, IllegalAccessException;
   }
}
