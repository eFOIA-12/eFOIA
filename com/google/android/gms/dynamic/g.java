package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;

public abstract class g {
   private final String TI;
   private Object TJ;

   protected g(String var1) {
      this.TI = var1;
   }

   protected final Object L(Context var1) throws g.a {
      if(this.TJ == null) {
         jx.i(var1);
         var1 = GooglePlayServicesUtil.getRemoteContext(var1);
         if(var1 == null) {
            throw new g.a("Could not get remote context.");
         }

         ClassLoader var5 = var1.getClassLoader();

         try {
            this.TJ = this.d((IBinder)var5.loadClass(this.TI).newInstance());
         } catch (ClassNotFoundException var2) {
            throw new g.a("Could not load creator class.", var2);
         } catch (InstantiationException var3) {
            throw new g.a("Could not instantiate creator.", var3);
         } catch (IllegalAccessException var4) {
            throw new g.a("Could not access creator.", var4);
         }
      }

      return this.TJ;
   }

   protected abstract Object d(IBinder var1);

   public static class a extends Exception {
      public a(String var1) {
         super(var1);
      }

      public a(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
