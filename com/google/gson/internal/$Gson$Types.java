package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class $Gson$Types {
   static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

   public static GenericArrayType arrayOf(Type var0) {
      return new $Gson$Types.GenericArrayTypeImpl(var0);
   }

   public static Type canonicalize(Type var0) {
      if(var0 instanceof Class) {
         Object var3 = (Class)var0;
         if(((Class)var3).isArray()) {
            var3 = new $Gson$Types.GenericArrayTypeImpl(canonicalize(((Class)var3).getComponentType()));
         }

         return (Type)var3;
      } else if(var0 instanceof ParameterizedType) {
         ParameterizedType var2 = (ParameterizedType)var0;
         return new $Gson$Types.ParameterizedTypeImpl(var2.getOwnerType(), var2.getRawType(), var2.getActualTypeArguments());
      } else if(var0 instanceof GenericArrayType) {
         return new $Gson$Types.GenericArrayTypeImpl(((GenericArrayType)var0).getGenericComponentType());
      } else if(var0 instanceof WildcardType) {
         WildcardType var1 = (WildcardType)var0;
         return new $Gson$Types.WildcardTypeImpl(var1.getUpperBounds(), var1.getLowerBounds());
      } else {
         return var0;
      }
   }

   private static void checkNotPrimitive(Type var0) {
      boolean var1;
      if(var0 instanceof Class && ((Class)var0).isPrimitive()) {
         var1 = false;
      } else {
         var1 = true;
      }

      $Gson$Preconditions.checkArgument(var1);
   }

   private static Class declaringClassOf(TypeVariable var0) {
      GenericDeclaration var1 = var0.getGenericDeclaration();
      return var1 instanceof Class?(Class)var1:null;
   }

   static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static boolean equals(Type var0, Type var1) {
      boolean var5 = true;
      boolean var6 = true;
      boolean var3 = true;
      boolean var4 = false;
      boolean var2;
      if(var0 == var1) {
         var2 = true;
      } else {
         if(var0 instanceof Class) {
            return var0.equals(var1);
         }

         if(var0 instanceof ParameterizedType) {
            var2 = var4;
            if(var1 instanceof ParameterizedType) {
               ParameterizedType var7 = (ParameterizedType)var0;
               ParameterizedType var10 = (ParameterizedType)var1;
               if(equal(var7.getOwnerType(), var10.getOwnerType()) && var7.getRawType().equals(var10.getRawType()) && Arrays.equals(var7.getActualTypeArguments(), var10.getActualTypeArguments())) {
                  var2 = var3;
               } else {
                  var2 = false;
               }

               return var2;
            }
         } else if(var0 instanceof GenericArrayType) {
            var2 = var4;
            if(var1 instanceof GenericArrayType) {
               GenericArrayType var8 = (GenericArrayType)var0;
               GenericArrayType var12 = (GenericArrayType)var1;
               return equals(var8.getGenericComponentType(), var12.getGenericComponentType());
            }
         } else if(var0 instanceof WildcardType) {
            var2 = var4;
            if(var1 instanceof WildcardType) {
               WildcardType var9 = (WildcardType)var0;
               WildcardType var13 = (WildcardType)var1;
               if(Arrays.equals(var9.getUpperBounds(), var13.getUpperBounds()) && Arrays.equals(var9.getLowerBounds(), var13.getLowerBounds())) {
                  var2 = var5;
               } else {
                  var2 = false;
               }

               return var2;
            }
         } else {
            var2 = var4;
            if(var0 instanceof TypeVariable) {
               var2 = var4;
               if(var1 instanceof TypeVariable) {
                  TypeVariable var11 = (TypeVariable)var0;
                  TypeVariable var14 = (TypeVariable)var1;
                  if(var11.getGenericDeclaration() == var14.getGenericDeclaration() && var11.getName().equals(var14.getName())) {
                     var2 = var6;
                  } else {
                     var2 = false;
                  }

                  return var2;
               }
            }
         }
      }

      return var2;
   }

   public static Type getArrayComponentType(Type var0) {
      return (Type)(var0 instanceof GenericArrayType?((GenericArrayType)var0).getGenericComponentType():((Class)var0).getComponentType());
   }

   public static Type getCollectionElementType(Type var0, Class var1) {
      Type var2 = getSupertype(var0, var1, Collection.class);
      var0 = var2;
      if(var2 instanceof WildcardType) {
         var0 = ((WildcardType)var2).getUpperBounds()[0];
      }

      return (Type)(var0 instanceof ParameterizedType?((ParameterizedType)var0).getActualTypeArguments()[0]:Object.class);
   }

   static Type getGenericSupertype(Type var0, Class var1, Class var2) {
      if(var2 == var1) {
         return var0;
      } else {
         if(var2.isInterface()) {
            Class[] var5 = var1.getInterfaces();
            int var3 = 0;

            for(int var4 = var5.length; var3 < var4; ++var3) {
               if(var5[var3] == var2) {
                  return var1.getGenericInterfaces()[var3];
               }

               if(var2.isAssignableFrom(var5[var3])) {
                  return getGenericSupertype(var1.getGenericInterfaces()[var3], var5[var3], var2);
               }
            }
         }

         if(!var1.isInterface()) {
            while(var1 != Object.class) {
               Class var6 = var1.getSuperclass();
               if(var6 == var2) {
                  return var1.getGenericSuperclass();
               }

               if(var2.isAssignableFrom(var6)) {
                  return getGenericSupertype(var1.getGenericSuperclass(), var6, var2);
               }

               var1 = var6;
            }
         }

         return var2;
      }
   }

   public static Type[] getMapKeyAndValueTypes(Type var0, Class var1) {
      if(var0 == Properties.class) {
         return new Type[]{String.class, String.class};
      } else {
         var0 = getSupertype(var0, var1, Map.class);
         return var0 instanceof ParameterizedType?((ParameterizedType)var0).getActualTypeArguments():new Type[]{Object.class, Object.class};
      }
   }

   public static Class getRawType(Type var0) {
      if(var0 instanceof Class) {
         return (Class)var0;
      } else if(var0 instanceof ParameterizedType) {
         var0 = ((ParameterizedType)var0).getRawType();
         $Gson$Preconditions.checkArgument(var0 instanceof Class);
         return (Class)var0;
      } else if(var0 instanceof GenericArrayType) {
         return Array.newInstance(getRawType(((GenericArrayType)var0).getGenericComponentType()), 0).getClass();
      } else if(var0 instanceof TypeVariable) {
         return Object.class;
      } else if(var0 instanceof WildcardType) {
         return getRawType(((WildcardType)var0).getUpperBounds()[0]);
      } else {
         String var1;
         if(var0 == null) {
            var1 = "null";
         } else {
            var1 = var0.getClass().getName();
         }

         throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + var0 + "> is of type " + var1);
      }
   }

   static Type getSupertype(Type var0, Class var1, Class var2) {
      $Gson$Preconditions.checkArgument(var2.isAssignableFrom(var1));
      return resolve(var0, var1, getGenericSupertype(var0, var1, var2));
   }

   private static int hashCodeOrZero(Object var0) {
      return var0 != null?var0.hashCode():0;
   }

   private static int indexOf(Object[] var0, Object var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         if(var1.equals(var0[var2])) {
            return var2;
         }
      }

      throw new NoSuchElementException();
   }

   public static ParameterizedType newParameterizedTypeWithOwner(Type var0, Type var1, Type... var2) {
      return new $Gson$Types.ParameterizedTypeImpl(var0, var1, var2);
   }

   public static Type resolve(Type var0, Class var1, Type var2) {
      while(true) {
         Type var7;
         Object var12;
         if(var2 instanceof TypeVariable) {
            TypeVariable var8 = (TypeVariable)var2;
            var7 = resolveTypeVariable(var0, var1, var8);
            var2 = var7;
            if(var7 != var8) {
               continue;
            }

            var12 = var7;
         } else {
            if(var2 instanceof Class && ((Class)var2).isArray()) {
               Class var14 = (Class)var2;
               Class var18 = var14.getComponentType();
               var0 = resolve(var0, var1, var18);
               Object var11;
               if(var18 == var0) {
                  var11 = var14;
               } else {
                  var11 = arrayOf(var0);
               }

               return (Type)var11;
            }

            if(var2 instanceof GenericArrayType) {
               var12 = (GenericArrayType)var2;
               var7 = ((GenericArrayType)var12).getGenericComponentType();
               var0 = resolve(var0, var1, var7);
               if(var7 != var0) {
                  return arrayOf(var0);
               }
            } else if(var2 instanceof ParameterizedType) {
               ParameterizedType var16 = (ParameterizedType)var2;
               var2 = var16.getOwnerType();
               Type var9 = resolve(var0, var1, var2);
               boolean var3;
               if(var9 != var2) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               Type[] var15 = var16.getActualTypeArguments();
               int var5 = 0;

               boolean var4;
               for(int var6 = var15.length; var5 < var6; var3 = var4) {
                  Type var10 = resolve(var0, var1, var15[var5]);
                  Type[] var13 = var15;
                  var4 = var3;
                  if(var10 != var15[var5]) {
                     var13 = var15;
                     var4 = var3;
                     if(!var3) {
                        var13 = (Type[])var15.clone();
                        var4 = true;
                     }

                     var13[var5] = var10;
                  }

                  ++var5;
                  var15 = var13;
               }

               var12 = var16;
               if(var3) {
                  return newParameterizedTypeWithOwner(var9, var16.getRawType(), var15);
               }
            } else {
               if(!(var2 instanceof WildcardType)) {
                  return var2;
               }

               WildcardType var17 = (WildcardType)var2;
               Type[] var19 = var17.getLowerBounds();
               Type[] var20 = var17.getUpperBounds();
               if(var19.length == 1) {
                  var0 = resolve(var0, var1, var19[0]);
                  var12 = var17;
                  if(var0 != var19[0]) {
                     return supertypeOf(var0);
                  }
               } else {
                  var12 = var17;
                  if(var20.length == 1) {
                     var0 = resolve(var0, var1, var20[0]);
                     var12 = var17;
                     if(var0 != var20[0]) {
                        return subtypeOf(var0);
                     }
                  }
               }
            }
         }

         return (Type)var12;
      }
   }

   static Type resolveTypeVariable(Type var0, Class var1, TypeVariable var2) {
      Class var4 = declaringClassOf(var2);
      if(var4 != null) {
         var0 = getGenericSupertype(var0, var1, var4);
         if(var0 instanceof ParameterizedType) {
            int var3 = indexOf(var4.getTypeParameters(), var2);
            return ((ParameterizedType)var0).getActualTypeArguments()[var3];
         }
      }

      return var2;
   }

   public static WildcardType subtypeOf(Type var0) {
      Type[] var1 = EMPTY_TYPE_ARRAY;
      return new $Gson$Types.WildcardTypeImpl(new Type[]{var0}, var1);
   }

   public static WildcardType supertypeOf(Type var0) {
      return new $Gson$Types.WildcardTypeImpl(new Type[]{Object.class}, new Type[]{var0});
   }

   public static String typeToString(Type var0) {
      return var0 instanceof Class?((Class)var0).getName():var0.toString();
   }

   private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
      private static final long serialVersionUID = 0L;
      private final Type componentType;

      public GenericArrayTypeImpl(Type var1) {
         this.componentType = $Gson$Types.canonicalize(var1);
      }

      public boolean equals(Object var1) {
         return var1 instanceof GenericArrayType && $Gson$Types.equals(this, (GenericArrayType)var1);
      }

      public Type getGenericComponentType() {
         return this.componentType;
      }

      public int hashCode() {
         return this.componentType.hashCode();
      }

      public String toString() {
         return $Gson$Types.typeToString(this.componentType) + "[]";
      }
   }

   private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
      private static final long serialVersionUID = 0L;
      private final Type ownerType;
      private final Type rawType;
      private final Type[] typeArguments;

      public ParameterizedTypeImpl(Type var1, Type var2, Type... var3) {
         boolean var5 = false;
         super();
         if(var2 instanceof Class) {
            Class var6 = (Class)var2;
            boolean var4;
            if(!Modifier.isStatic(var6.getModifiers()) && var6.getEnclosingClass() != null) {
               var4 = false;
            } else {
               var4 = true;
            }

            if(var1 != null || var4) {
               var5 = true;
            }

            $Gson$Preconditions.checkArgument(var5);
         }

         if(var1 == null) {
            var1 = null;
         } else {
            var1 = $Gson$Types.canonicalize(var1);
         }

         this.ownerType = var1;
         this.rawType = $Gson$Types.canonicalize(var2);
         this.typeArguments = (Type[])var3.clone();

         for(int var7 = 0; var7 < this.typeArguments.length; ++var7) {
            $Gson$Preconditions.checkNotNull(this.typeArguments[var7]);
            $Gson$Types.checkNotPrimitive(this.typeArguments[var7]);
            this.typeArguments[var7] = $Gson$Types.canonicalize(this.typeArguments[var7]);
         }

      }

      public boolean equals(Object var1) {
         return var1 instanceof ParameterizedType && $Gson$Types.equals(this, (ParameterizedType)var1);
      }

      public Type[] getActualTypeArguments() {
         return (Type[])this.typeArguments.clone();
      }

      public Type getOwnerType() {
         return this.ownerType;
      }

      public Type getRawType() {
         return this.rawType;
      }

      public int hashCode() {
         return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ $Gson$Types.hashCodeOrZero(this.ownerType);
      }

      public String toString() {
         StringBuilder var2 = new StringBuilder((this.typeArguments.length + 1) * 30);
         var2.append($Gson$Types.typeToString(this.rawType));
         if(this.typeArguments.length == 0) {
            return var2.toString();
         } else {
            var2.append("<").append($Gson$Types.typeToString(this.typeArguments[0]));

            for(int var1 = 1; var1 < this.typeArguments.length; ++var1) {
               var2.append(", ").append($Gson$Types.typeToString(this.typeArguments[var1]));
            }

            return var2.append(">").toString();
         }
      }
   }

   private static final class WildcardTypeImpl implements WildcardType, Serializable {
      private static final long serialVersionUID = 0L;
      private final Type lowerBound;
      private final Type upperBound;

      public WildcardTypeImpl(Type[] var1, Type[] var2) {
         boolean var4 = true;
         super();
         boolean var3;
         if(var2.length <= 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         $Gson$Preconditions.checkArgument(var3);
         if(var1.length == 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         $Gson$Preconditions.checkArgument(var3);
         if(var2.length == 1) {
            $Gson$Preconditions.checkNotNull(var2[0]);
            $Gson$Types.checkNotPrimitive(var2[0]);
            if(var1[0] == Object.class) {
               var3 = var4;
            } else {
               var3 = false;
            }

            $Gson$Preconditions.checkArgument(var3);
            this.lowerBound = $Gson$Types.canonicalize(var2[0]);
            this.upperBound = Object.class;
         } else {
            $Gson$Preconditions.checkNotNull(var1[0]);
            $Gson$Types.checkNotPrimitive(var1[0]);
            this.lowerBound = null;
            this.upperBound = $Gson$Types.canonicalize(var1[0]);
         }
      }

      public boolean equals(Object var1) {
         return var1 instanceof WildcardType && $Gson$Types.equals(this, (WildcardType)var1);
      }

      public Type[] getLowerBounds() {
         return this.lowerBound != null?new Type[]{this.lowerBound}:$Gson$Types.EMPTY_TYPE_ARRAY;
      }

      public Type[] getUpperBounds() {
         return new Type[]{this.upperBound};
      }

      public int hashCode() {
         int var1;
         if(this.lowerBound != null) {
            var1 = this.lowerBound.hashCode() + 31;
         } else {
            var1 = 1;
         }

         return var1 ^ this.upperBound.hashCode() + 31;
      }

      public String toString() {
         return this.lowerBound != null?"? super " + $Gson$Types.typeToString(this.lowerBound):(this.upperBound == Object.class?"?":"? extends " + $Gson$Types.typeToString(this.upperBound));
      }
   }
}
