package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.UnsafeAllocator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ConstructorConstructor {
   private final Map instanceCreators;

   public ConstructorConstructor(Map var1) {
      this.instanceCreators = var1;
   }

   private ObjectConstructor newDefaultConstructor(Class var1) {
      try {
         final Constructor var3 = var1.getDeclaredConstructor(new Class[0]);
         if(!var3.isAccessible()) {
            var3.setAccessible(true);
         }

         ObjectConstructor var4 = new ObjectConstructor() {
            public Object construct() {
               try {
                  Object var1 = var3.newInstance((Object[])null);
                  return var1;
               } catch (InstantiationException var2) {
                  throw new RuntimeException("Failed to invoke " + var3 + " with no args", var2);
               } catch (InvocationTargetException var3x) {
                  throw new RuntimeException("Failed to invoke " + var3 + " with no args", var3x.getTargetException());
               } catch (IllegalAccessException var4) {
                  throw new AssertionError(var4);
               }
            }
         };
         return var4;
      } catch (NoSuchMethodException var2) {
         return null;
      }
   }

   private ObjectConstructor newDefaultImplementationConstructor(final Type var1, Class var2) {
      return Collection.class.isAssignableFrom(var2)?(SortedSet.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public Object construct() {
            return new TreeSet();
         }
      }:(EnumSet.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public Object construct() {
            if(var1 instanceof ParameterizedType) {
               Type var1x = ((ParameterizedType)var1).getActualTypeArguments()[0];
               if(var1x instanceof Class) {
                  return EnumSet.noneOf((Class)var1x);
               } else {
                  throw new JsonIOException("Invalid EnumSet type: " + var1.toString());
               }
            } else {
               throw new JsonIOException("Invalid EnumSet type: " + var1.toString());
            }
         }
      }:(Set.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public Object construct() {
            return new LinkedHashSet();
         }
      }:(Queue.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public Object construct() {
            return new LinkedList();
         }
      }:new ObjectConstructor() {
         public Object construct() {
            return new ArrayList();
         }
      })))):(Map.class.isAssignableFrom(var2)?(SortedMap.class.isAssignableFrom(var2)?new ObjectConstructor() {
         public Object construct() {
            return new TreeMap();
         }
      }:(var1 instanceof ParameterizedType && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)var1).getActualTypeArguments()[0]).getRawType())?new ObjectConstructor() {
         public Object construct() {
            return new LinkedHashMap();
         }
      }:new ObjectConstructor() {
         public Object construct() {
            return new LinkedTreeMap();
         }
      })):null);
   }

   private ObjectConstructor newUnsafeAllocator(final Type var1, final Class var2) {
      return new ObjectConstructor() {
         private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

         public Object construct() {
            try {
               Object var1x = this.unsafeAllocator.newInstance(var2);
               return var1x;
            } catch (Exception var2x) {
               throw new RuntimeException("Unable to invoke no-args constructor for " + var1 + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", var2x);
            }
         }
      };
   }

   public ObjectConstructor get(TypeToken var1) {
      final Type var3 = var1.getType();
      Class var4 = var1.getRawType();
      final InstanceCreator var5 = (InstanceCreator)this.instanceCreators.get(var3);
      ObjectConstructor var6;
      if(var5 != null) {
         var6 = new ObjectConstructor() {
            public Object construct() {
               return var5.createInstance(var3);
            }
         };
      } else {
         var5 = (InstanceCreator)this.instanceCreators.get(var4);
         if(var5 != null) {
            return new ObjectConstructor() {
               public Object construct() {
                  return var5.createInstance(var3);
               }
            };
         }

         ObjectConstructor var2 = this.newDefaultConstructor(var4);
         var6 = var2;
         if(var2 == null) {
            var6 = this.newDefaultImplementationConstructor(var3, var4);
            if(var6 != null) {
               return var6;
            }

            return this.newUnsafeAllocator(var3, var4);
         }
      }

      return var6;
   }

   public String toString() {
      return this.instanceCreators.toString();
   }
}
