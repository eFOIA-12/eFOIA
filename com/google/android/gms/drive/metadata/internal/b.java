package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

public class b extends com.google.android.gms.drive.metadata.a {
   public b(String var1, int var2) {
      super(var1, var2);
   }

   protected void a(Bundle var1, Boolean var2) {
      var1.putBoolean(this.getName(), var2.booleanValue());
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.e(var1, var2, var3);
   }

   protected Boolean e(DataHolder var1, int var2, int var3) {
      return Boolean.valueOf(var1.d(this.getName(), var2, var3));
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.j(var1);
   }

   protected Boolean j(Bundle var1) {
      return Boolean.valueOf(var1.getBoolean(this.getName()));
   }
}
