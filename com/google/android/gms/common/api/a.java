package com.google.android.gms.common.api;

import com.google.android.gms.common.api.d;
import com.google.android.gms.common.data.DataHolder;

public abstract class a implements d.b {
   private final DataHolder JG;

   protected a(DataHolder var1) {
      this.JG = var1;
   }

   protected abstract void a(Object var1, DataHolder var2);

   public final void c(Object var1) {
      this.a(var1, this.JG);
   }

   public void gG() {
      if(this.JG != null) {
         this.JG.close();
      }

   }
}
