package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.i;
import com.google.android.gms.internal.m;
import com.google.android.gms.internal.n;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class j extends i {
   private static AdvertisingIdClient kO;
   private static CountDownLatch kP = new CountDownLatch(1);
   private static boolean kQ;

   protected j(Context var1, m var2, n var3) {
      super(var1, var2, var3);
   }

   public static j a(String param0, Context param1) {
      // $FF: Couldn't be decompiled
   }

   protected void b(Context param1) {
      // $FF: Couldn't be decompiled
   }

   j.a z() throws IOException {
      // $FF: Couldn't be decompiled
   }

   class a {
      private String kR;
      private boolean kS;

      public a(String var2, boolean var3) {
         this.kR = var2;
         this.kS = var3;
      }

      public String getId() {
         return this.kR;
      }

      public boolean isLimitAdTrackingEnabled() {
         return this.kS;
      }
   }
}
