package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

public class l extends com.google.android.gms.drive.metadata.a {
   public l(String var1, int var2) {
      super(var1, var2);
   }

   protected void a(Bundle var1, String var2) {
      var1.putString(this.getName(), var2);
   }

   // $FF: synthetic method
   protected Object c(DataHolder var1, int var2, int var3) {
      return this.i(var1, var2, var3);
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.p(var1);
   }

   protected String i(DataHolder var1, int var2, int var3) {
      return var1.c(this.getName(), var2, var3);
   }

   protected String p(Bundle var1) {
      return var1.getString(this.getName());
   }
}
