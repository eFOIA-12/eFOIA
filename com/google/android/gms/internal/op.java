package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.ou;
import com.google.android.gms.internal.ov;
import com.google.android.gms.internal.ox;

public class op {
   private final ox amU;
   private ov amV;

   public op(Context var1, int var2, String var3, String var4, op.a var5, boolean var6) {
      int var7 = 0;
      super();
      String var9 = var1.getPackageName();

      label13: {
         int var8;
         try {
            var8 = var1.getPackageManager().getPackageInfo(var9, 0).versionCode;
         } catch (NameNotFoundException var11) {
            Log.wtf("PlayLogger", "This can\'t happen.");
            break label13;
         }

         var7 = var8;
      }

      this.amV = new ov(var9, var7, var2, var3, var4, var6);
      this.amU = new ox(var1, new ou(var5));
   }

   public void a(long var1, String var3, byte[] var4, String... var5) {
      this.amU.b(this.amV, new or(var1, var3, var4, var5));
   }

   public void b(String var1, byte[] var2, String... var3) {
      this.a(System.currentTimeMillis(), var1, var2, var3);
   }

   public void start() {
      this.amU.start();
   }

   public void stop() {
      this.amU.stop();
   }

   public interface a {
      void d(PendingIntent var1);

      void on();

      void oo();
   }
}
