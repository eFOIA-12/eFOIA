package org.apache.http.util;

import java.lang.reflect.Method;

@Deprecated
public final class ExceptionUtils {
   private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();

   private static Method getInitCauseMethod() {
      try {
         Method var0 = Throwable.class.getMethod("initCause", new Class[]{Throwable.class});
         return var0;
      } catch (NoSuchMethodException var1) {
         return null;
      }
   }

   public static void initCause(Throwable var0, Throwable var1) {
      if(INIT_CAUSE_METHOD != null) {
         try {
            INIT_CAUSE_METHOD.invoke(var0, new Object[]{var1});
         } catch (Exception var2) {
            return;
         }
      }

   }
}
