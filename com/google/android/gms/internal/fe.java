package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gr;

@ey
public final class fe {
   public static gf a(Context var0, fh var1, fe.a var2) {
      return var1.lO.wV?b(var0, var1, var2):c(var0, var1, var2);
   }

   private static gf b(Context var0, fh var1, fe.a var2) {
      gr.S("Fetching ad response from local ad request service.");
      ff.a var3 = new ff.a(var0, var1, var2);
      var3.start();
      return var3;
   }

   private static gf c(Context var0, fh var1, fe.a var2) {
      gr.S("Fetching ad response from remote ad request service.");
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) != 0) {
         gr.W("Failed to connect to remote ad request service.");
         return null;
      } else {
         return new ff.b(var0, var1, var2);
      }
   }

   public interface a {
      void a(fj var1);
   }
}
