package com.google.android.gms.analytics;

import android.app.Activity;
import com.google.android.gms.analytics.m;
import java.util.HashMap;
import java.util.Map;

class am implements m {
   int CA = -1;
   Map CB = new HashMap();
   String Cv;
   double Cw = -1.0D;
   int Cx = -1;
   int Cy = -1;
   int Cz = -1;

   public String am(String var1) {
      String var2 = (String)this.CB.get(var1);
      return var2 != null?var2:var1;
   }

   public boolean fA() {
      return this.Cz != -1;
   }

   public boolean fB() {
      return this.Cz == 1;
   }

   public boolean fC() {
      return this.CA == 1;
   }

   public boolean ft() {
      return this.Cv != null;
   }

   public String fu() {
      return this.Cv;
   }

   public boolean fv() {
      return this.Cw >= 0.0D;
   }

   public double fw() {
      return this.Cw;
   }

   public boolean fx() {
      return this.Cx >= 0;
   }

   public boolean fy() {
      return this.Cy != -1;
   }

   public boolean fz() {
      return this.Cy == 1;
   }

   public int getSessionTimeout() {
      return this.Cx;
   }

   public String k(Activity var1) {
      return this.am(var1.getClass().getCanonicalName());
   }
}
