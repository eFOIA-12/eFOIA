package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class ji implements SafeParcelable {
   private static ClassLoader MA = null;
   private static Integer MB = null;
   private static final Object Mz = new Object();
   private boolean MC = false;

   private static boolean a(Class var0) {
      try {
         boolean var1 = "SAFE_PARCELABLE_NULL_STRING".equals(var0.getField("NULL").get((Object)null));
         return var1;
      } catch (NoSuchFieldException var2) {
         return false;
      } catch (IllegalAccessException var3) {
         return false;
      }
   }

   protected static boolean aW(String var0) {
      ClassLoader var2 = hs();
      if(var2 == null) {
         return true;
      } else {
         try {
            boolean var1 = a(var2.loadClass(var0));
            return var1;
         } catch (Exception var3) {
            return false;
         }
      }
   }

   protected static ClassLoader hs() {
      // $FF: Couldn't be decompiled
   }

   protected static Integer ht() {
      // $FF: Couldn't be decompiled
   }

   protected boolean hu() {
      return this.MC;
   }
}
