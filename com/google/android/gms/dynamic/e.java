package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.d;
import java.lang.reflect.Field;

public final class e extends d.a {
   private final Object TH;

   private e(Object var1) {
      this.TH = var1;
   }

   public static Object f(d var0) {
      if(var0 instanceof e) {
         return ((e)var0).TH;
      } else {
         IBinder var5 = var0.asBinder();
         Field[] var1 = var5.getClass().getDeclaredFields();
         if(var1.length == 1) {
            Field var7 = var1[0];
            if(!var7.isAccessible()) {
               var7.setAccessible(true);

               try {
                  Object var6 = var7.get(var5);
                  return var6;
               } catch (NullPointerException var2) {
                  throw new IllegalArgumentException("Binder object is null.", var2);
               } catch (IllegalArgumentException var3) {
                  throw new IllegalArgumentException("remoteBinder is the wrong class.", var3);
               } catch (IllegalAccessException var4) {
                  throw new IllegalArgumentException("Could not access the field in remoteBinder.", var4);
               }
            } else {
               throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
         } else {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
         }
      }
   }

   public static d k(Object var0) {
      return new e(var0);
   }
}
