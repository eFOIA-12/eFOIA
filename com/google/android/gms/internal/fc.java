package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ai;
import com.google.android.gms.internal.cy;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.u;

@ey
public final class fc {
   public static gf a(Context var0, u var1, fy.a var2, gu var3, cy var4, fc.a var5) {
      Object var6;
      if(var2.vK.ug) {
         var6 = new fm(var0, var1, new ai(), var2, var5);
      } else {
         var6 = new fd(var0, var2, var3, var4, var5);
      }

      ((gf)var6).start();
      return (gf)var6;
   }

   public interface a {
      void a(fy var1);
   }
}
