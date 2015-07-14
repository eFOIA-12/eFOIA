package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
   private final ConstructorConstructor constructorConstructor;

   public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor var1) {
      this.constructorConstructor = var1;
   }

   static TypeAdapter getTypeAdapter(ConstructorConstructor var0, Gson var1, TypeToken var2, JsonAdapter var3) {
      Class var4 = var3.value();
      if(TypeAdapter.class.isAssignableFrom(var4)) {
         return (TypeAdapter)var0.get(TypeToken.get(var4)).construct();
      } else if(TypeAdapterFactory.class.isAssignableFrom(var4)) {
         return ((TypeAdapterFactory)var0.get(TypeToken.get(var4)).construct()).create(var1, var2);
      } else {
         throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
      }
   }

   public TypeAdapter create(Gson var1, TypeToken var2) {
      JsonAdapter var3 = (JsonAdapter)var2.getRawType().getAnnotation(JsonAdapter.class);
      return var3 == null?null:getTypeAdapter(this.constructorConstructor, var1, var2, var3);
   }
}
