package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Collection;

public abstract class j extends com.google.android.gms.drive.metadata.a {
   public j(String var1, Collection var2, Collection var3, int var4) {
      super(var1, var2, var3, var4);
   }

   protected void a(Bundle var1, Parcelable var2) {
      var1.putParcelable(this.getName(), var2);
   }

   // $FF: synthetic method
   protected Object i(Bundle var1) {
      return this.o(var1);
   }

   protected Parcelable o(Bundle var1) {
      return var1.getParcelable(this.getName());
   }
}
