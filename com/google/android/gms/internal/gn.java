package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gh;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@ey
public class gn {
   public static final gn.a wN = new gn.a() {
      // $FF: synthetic method
      public Object b(InputStream var1) {
         return this.c(var1);
      }

      public Void c(InputStream var1) {
         return null;
      }

      // $FF: synthetic method
      public Object cQ() {
         return this.dz();
      }

      public Void dz() {
         return null;
      }
   };

   public Future a(final String var1, final gn.a var2) {
      return gh.submit(new Callable() {
         public Object call() {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public interface a {
      Object b(InputStream var1);

      Object cQ();
   }
}
