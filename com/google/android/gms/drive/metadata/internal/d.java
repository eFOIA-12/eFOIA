package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Date;

public class d extends com.google.android.gms.drive.metadata.d {
   public d(String var1, int var2) {
      super(var1, var2);
   }

   protected void a(Bundle var1, Date var2) {
      var1.putLong(this.getName(), var2.getTime());
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.f(var1, var2, var3);
   }

   protected Date f(DataHolder var1, int var2, int var3) {
      return new Date(var1.a(this.getName(), var2, var3));
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.k(var1);
   }

   protected Date k(Bundle var1) {
      return new Date(var1.getLong(this.getName()));
   }
}
