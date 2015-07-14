package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
   public static final Excluder DEFAULT = new Excluder();
   private static final double IGNORE_VERSIONS = -1.0D;
   private List deserializationStrategies = Collections.emptyList();
   private int modifiers = 136;
   private boolean requireExpose;
   private List serializationStrategies = Collections.emptyList();
   private boolean serializeInnerClasses = true;
   private double version = -1.0D;

   private boolean isAnonymousOrLocal(Class var1) {
      return !Enum.class.isAssignableFrom(var1) && (var1.isAnonymousClass() || var1.isLocalClass());
   }

   private boolean isInnerClass(Class var1) {
      return var1.isMemberClass() && !this.isStatic(var1);
   }

   private boolean isStatic(Class var1) {
      return (var1.getModifiers() & 8) != 0;
   }

   private boolean isValidSince(Since var1) {
      return var1 == null || var1.value() <= this.version;
   }

   private boolean isValidUntil(Until var1) {
      return var1 == null || var1.value() > this.version;
   }

   private boolean isValidVersion(Since var1, Until var2) {
      return this.isValidSince(var1) && this.isValidUntil(var2);
   }

   protected Excluder clone() {
      try {
         Excluder var1 = (Excluder)super.clone();
         return var1;
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError();
      }
   }

   public TypeAdapter create(final Gson var1, final TypeToken var2) {
      Class var5 = var2.getRawType();
      final boolean var3 = this.excludeClass(var5, true);
      final boolean var4 = this.excludeClass(var5, false);
      return !var3 && !var4?null:new TypeAdapter() {
         private TypeAdapter delegate;

         private TypeAdapter delegate() {
            TypeAdapter var1x = this.delegate;
            if(var1x != null) {
               return var1x;
            } else {
               var1x = var1.getDelegateAdapter(Excluder.this, var2);
               this.delegate = var1x;
               return var1x;
            }
         }

         public Object read(JsonReader var1x) throws IOException {
            if(var4) {
               var1x.skipValue();
               return null;
            } else {
               return this.delegate().read(var1x);
            }
         }

         public void write(JsonWriter var1x, Object var2x) throws IOException {
            if(var3) {
               var1x.nullValue();
            } else {
               this.delegate().write(var1x, var2x);
            }
         }
      };
   }

   public Excluder disableInnerClassSerialization() {
      Excluder var1 = this.clone();
      var1.serializeInnerClasses = false;
      return var1;
   }

   public boolean excludeClass(Class var1, boolean var2) {
      if(this.version != -1.0D && !this.isValidVersion((Since)var1.getAnnotation(Since.class), (Until)var1.getAnnotation(Until.class))) {
         return true;
      } else if(!this.serializeInnerClasses && this.isInnerClass(var1)) {
         return true;
      } else if(this.isAnonymousOrLocal(var1)) {
         return true;
      } else {
         List var3;
         if(var2) {
            var3 = this.serializationStrategies;
         } else {
            var3 = this.deserializationStrategies;
         }

         Iterator var4 = var3.iterator();

         do {
            if(!var4.hasNext()) {
               return false;
            }
         } while(!((ExclusionStrategy)var4.next()).shouldSkipClass(var1));

         return true;
      }
   }

   public boolean excludeField(Field var1, boolean var2) {
      if((this.modifiers & var1.getModifiers()) != 0) {
         return true;
      } else if(this.version != -1.0D && !this.isValidVersion((Since)var1.getAnnotation(Since.class), (Until)var1.getAnnotation(Until.class))) {
         return true;
      } else if(var1.isSynthetic()) {
         return true;
      } else {
         if(this.requireExpose) {
            label55: {
               Expose var3 = (Expose)var1.getAnnotation(Expose.class);
               if(var3 != null) {
                  if(var2) {
                     if(var3.serialize()) {
                        break label55;
                     }
                  } else if(var3.deserialize()) {
                     break label55;
                  }
               }

               return true;
            }
         }

         if(!this.serializeInnerClasses && this.isInnerClass(var1.getType())) {
            return true;
         } else if(this.isAnonymousOrLocal(var1.getType())) {
            return true;
         } else {
            List var5;
            if(var2) {
               var5 = this.serializationStrategies;
            } else {
               var5 = this.deserializationStrategies;
            }

            if(!var5.isEmpty()) {
               FieldAttributes var4 = new FieldAttributes(var1);
               Iterator var6 = var5.iterator();

               while(var6.hasNext()) {
                  if(((ExclusionStrategy)var6.next()).shouldSkipField(var4)) {
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }

   public Excluder excludeFieldsWithoutExposeAnnotation() {
      Excluder var1 = this.clone();
      var1.requireExpose = true;
      return var1;
   }

   public Excluder withExclusionStrategy(ExclusionStrategy var1, boolean var2, boolean var3) {
      Excluder var4 = this.clone();
      if(var2) {
         var4.serializationStrategies = new ArrayList(this.serializationStrategies);
         var4.serializationStrategies.add(var1);
      }

      if(var3) {
         var4.deserializationStrategies = new ArrayList(this.deserializationStrategies);
         var4.deserializationStrategies.add(var1);
      }

      return var4;
   }

   public Excluder withModifiers(int... var1) {
      Excluder var5 = this.clone();
      var5.modifiers = 0;
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         int var4 = var1[var2];
         var5.modifiers |= var4;
      }

      return var5;
   }

   public Excluder withVersion(double var1) {
      Excluder var3 = this.clone();
      var3.version = var1;
      return var3;
   }
}
