package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.w;

@ey
public final class bo extends bq.a {
   private final w px;
   private final String py;
   private final String pz;

   public bo(w var1, String var2, String var3) {
      this.px = var1;
      this.py = var2;
      this.pz = var3;
   }

   public void a(com.google.android.gms.dynamic.d var1) {
      if(var1 != null) {
         this.px.b((View)com.google.android.gms.dynamic.e.f(var1));
      }
   }

   public void av() {
      this.px.av();
   }

   public void aw() {
      this.px.aw();
   }

   public String bA() {
      return this.pz;
   }

   public String bz() {
      return this.py;
   }
}
