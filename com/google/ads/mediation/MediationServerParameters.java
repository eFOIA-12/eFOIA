package com.google.ads.mediation;

import com.google.android.gms.internal.gr;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class MediationServerParameters {
   protected void a() {
   }

   public void load(Map var1) throws MediationServerParameters.MappingException {
      HashMap var4 = new HashMap();
      Field[] var5 = this.getClass().getFields();
      int var3 = var5.length;

      Field var6;
      for(int var2 = 0; var2 < var3; ++var2) {
         var6 = var5[var2];
         MediationServerParameters.Parameter var7 = (MediationServerParameters.Parameter)var6.getAnnotation(MediationServerParameters.Parameter.class);
         if(var7 != null) {
            var4.put(var7.name(), var6);
         }
      }

      if(var4.isEmpty()) {
         gr.W("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
      }

      Iterator var10 = var1.entrySet().iterator();

      while(var10.hasNext()) {
         Entry var13 = (Entry)var10.next();
         var6 = (Field)var4.remove(var13.getKey());
         if(var6 != null) {
            try {
               var6.set(this, var13.getValue());
            } catch (IllegalAccessException var8) {
               gr.W("Server option \"" + (String)var13.getKey() + "\" could not be set: Illegal Access");
            } catch (IllegalArgumentException var9) {
               gr.W("Server option \"" + (String)var13.getKey() + "\" could not be set: Bad Type");
            }
         } else {
            gr.S("Unexpected server option: " + (String)var13.getKey() + " = \"" + (String)var13.getValue() + "\"");
         }
      }

      StringBuilder var11 = new StringBuilder();
      Iterator var12 = var4.values().iterator();

      while(var12.hasNext()) {
         Field var14 = (Field)var12.next();
         if(((MediationServerParameters.Parameter)var14.getAnnotation(MediationServerParameters.Parameter.class)).required()) {
            gr.W("Required server option missing: " + ((MediationServerParameters.Parameter)var14.getAnnotation(MediationServerParameters.Parameter.class)).name());
            if(var11.length() > 0) {
               var11.append(", ");
            }

            var11.append(((MediationServerParameters.Parameter)var14.getAnnotation(MediationServerParameters.Parameter.class)).name());
         }
      }

      if(var11.length() > 0) {
         throw new MediationServerParameters.MappingException("Required server option(s) missing: " + var11.toString());
      } else {
         this.a();
      }
   }

   public static final class MappingException extends Exception {
      public MappingException(String var1) {
         super(var1);
      }
   }

   @Retention(RetentionPolicy.RUNTIME)
   @Target({ElementType.FIELD})
   protected @interface Parameter {
      String name();

      boolean required() default true;
   }
}
