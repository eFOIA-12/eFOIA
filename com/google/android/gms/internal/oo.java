package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.op;

public class oo implements op.a {
   private final op amS;
   private boolean amT;

   public oo(Context var1, int var2) {
      this(var1, var2, (String)null);
   }

   public oo(Context var1, int var2, String var3) {
      this(var1, var2, var3, (String)null, true);
   }

   public oo(Context var1, int var2, String var3, String var4, boolean var5) {
      this.amS = new op(var1, var2, var3, var4, this, var5);
      this.amT = true;
   }

   private void om() {
      if(!this.amT) {
         throw new IllegalStateException("Cannot reuse one-time logger after sending.");
      }
   }

   public void a(String var1, byte[] var2, String... var3) {
      this.om();
      this.amS.b(var1, var2, var3);
   }

   public void d(PendingIntent var1) {
      Log.w("OneTimePlayLogger", "logger connection failed: " + var1);
   }

   public void on() {
      this.amS.stop();
   }

   public void oo() {
      Log.w("OneTimePlayLogger", "logger connection failed");
   }

   public void send() {
      this.om();
      this.amS.start();
      this.amT = false;
   }
}
