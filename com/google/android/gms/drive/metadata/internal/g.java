package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

public class g extends com.google.android.gms.drive.metadata.a {
   public g(String var1, int var2) {
      super(var1, var2);
   }

   protected void a(Bundle var1, Long var2) {
      var1.putLong(this.getName(), var2.longValue());
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.h(var1, var2, var3);
   }

   protected Long h(DataHolder var1, int var2, int var3) {
      return Long.valueOf(var1.a(this.getName(), var2, var3));
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.m(var1);
   }

   protected Long m(Bundle var1) {
      return Long.valueOf(var1.getLong(this.getName()));
   }
}
