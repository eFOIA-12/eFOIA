package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

public class f extends com.google.android.gms.drive.metadata.a {
   public f(String var1, int var2) {
      super(var1, var2);
   }

   protected void a(Bundle var1, Integer var2) {
      var1.putInt(this.getName(), var2.intValue());
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.g(var1, var2, var3);
   }

   protected Integer g(DataHolder var1, int var2, int var3) {
      return Integer.valueOf(var1.b(this.getName(), var2, var3));
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.l(var1);
   }

   protected Integer l(Bundle var1) {
      return Integer.valueOf(var1.getInt(this.getName()));
   }
}
