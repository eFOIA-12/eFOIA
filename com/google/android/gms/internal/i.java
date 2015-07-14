package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.h;
import com.google.android.gms.internal.m;
import com.google.android.gms.internal.n;
import com.google.android.gms.internal.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class i extends h {
   private static Method kA;
   private static Method kB;
   private static Method kC;
   private static Method kD;
   private static Method kE;
   private static Method kF;
   private static Method kG;
   private static Method kH;
   private static Method kI;
   private static String kJ;
   private static String kK;
   private static String kL;
   private static o kM;
   static boolean kN = false;
   private static long startTime = 0L;

   protected i(Context var1, m var2, n var3) {
      super(var1, var2, var3);
   }

   static String a(Context param0, m param1) throws i.a {
      // $FF: Couldn't be decompiled
   }

   static ArrayList a(MotionEvent var0, DisplayMetrics var1) throws i.a {
      if(kE != null && var0 != null) {
         try {
            ArrayList var4 = (ArrayList)kE.invoke((Object)null, new Object[]{var0, var1});
            return var4;
         } catch (IllegalAccessException var2) {
            throw new i.a(var2);
         } catch (InvocationTargetException var3) {
            throw new i.a(var3);
         }
      } else {
         throw new i.a();
      }
   }

   protected static void a(String param0, Context param1, m param2) {
      // $FF: Couldn't be decompiled
   }

   static String b(Context param0, m param1) throws i.a {
      // $FF: Couldn't be decompiled
   }

   private static String b(byte[] var0, String var1) throws i.a {
      try {
         String var4 = new String(kM.c(var0, var1), "UTF-8");
         return var4;
      } catch (o.a var2) {
         throw new i.a(var2);
      } catch (UnsupportedEncodingException var3) {
         throw new i.a(var3);
      }
   }

   static String d(Context param0) throws i.a {
      // $FF: Couldn't be decompiled
   }

   static ArrayList e(Context param0) throws i.a {
      // $FF: Couldn't be decompiled
   }

   static int[] f(Context var0) throws i.a {
      if(kI == null) {
         throw new i.a();
      } else {
         try {
            int[] var3 = (int[])((int[])kI.invoke((Object)null, new Object[]{var0}));
            return var3;
         } catch (IllegalAccessException var1) {
            throw new i.a(var1);
         } catch (InvocationTargetException var2) {
            throw new i.a(var2);
         }
      }
   }

   private static void g(Context param0) throws i.a {
      // $FF: Couldn't be decompiled
   }

   static String v() throws i.a {
      if(kJ == null) {
         throw new i.a();
      } else {
         return kJ;
      }
   }

   static Long w() throws i.a {
      if(kA == null) {
         throw new i.a();
      } else {
         try {
            Long var0 = (Long)kA.invoke((Object)null, new Object[0]);
            return var0;
         } catch (IllegalAccessException var1) {
            throw new i.a(var1);
         } catch (InvocationTargetException var2) {
            throw new i.a(var2);
         }
      }
   }

   static String x() throws i.a {
      if(kC == null) {
         throw new i.a();
      } else {
         try {
            String var0 = (String)kC.invoke((Object)null, new Object[0]);
            return var0;
         } catch (IllegalAccessException var1) {
            throw new i.a(var1);
         } catch (InvocationTargetException var2) {
            throw new i.a(var2);
         }
      }
   }

   static Long y() throws i.a {
      if(kB == null) {
         throw new i.a();
      } else {
         try {
            Long var0 = (Long)kB.invoke((Object)null, new Object[0]);
            return var0;
         } catch (IllegalAccessException var1) {
            throw new i.a(var1);
         } catch (InvocationTargetException var2) {
            throw new i.a(var2);
         }
      }
   }

   protected void b(Context var1) {
      try {
         try {
            this.a(1, x());
         } catch (i.a var12) {
            ;
         }

         try {
            this.a(2, v());
         } catch (i.a var11) {
            ;
         }

         try {
            long var2 = w().longValue();
            this.a(25, var2);
            if(startTime != 0L) {
               this.a(17, var2 - startTime);
               this.a(23, startTime);
            }
         } catch (i.a var10) {
            ;
         }

         try {
            ArrayList var4 = e(var1);
            this.a(31, ((Long)var4.get(0)).longValue());
            this.a(32, ((Long)var4.get(1)).longValue());
         } catch (i.a var9) {
            ;
         }

         try {
            this.a(33, y().longValue());
         } catch (i.a var8) {
            ;
         }

         try {
            this.a(27, a(var1, this.ky));
         } catch (i.a var7) {
            ;
         }

         try {
            this.a(29, b(var1, this.ky));
         } catch (i.a var6) {
            ;
         }

         try {
            int[] var14 = f(var1);
            this.a(5, (long)var14[0]);
            this.a(6, (long)var14[1]);
         } catch (i.a var5) {
            ;
         }
      } catch (IOException var13) {
         ;
      }
   }

   protected void c(Context var1) {
      try {
         try {
            this.a(2, v());
         } catch (i.a var5) {
            ;
         }

         try {
            this.a(1, x());
         } catch (i.a var4) {
            ;
         }

         try {
            this.a(25, w().longValue());
         } catch (i.a var3) {
            ;
         }

         try {
            ArrayList var7 = a(this.kw, this.kx);
            this.a(14, ((Long)var7.get(0)).longValue());
            this.a(15, ((Long)var7.get(1)).longValue());
            if(var7.size() >= 3) {
               this.a(16, ((Long)var7.get(2)).longValue());
            }

         } catch (i.a var2) {
            ;
         }
      } catch (IOException var6) {
         ;
      }
   }

   static class a extends Exception {
      public a() {
      }

      public a(Throwable var1) {
         super(var1);
      }
   }
}
