package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gs;
import org.json.JSONObject;

@ey
public final class ad {
   private final String mD;
   private final JSONObject mE;
   private final String mF;
   private final String mG;

   public ad(String var1, gs var2, String var3, JSONObject var4) {
      this.mG = var2.wS;
      this.mE = var4;
      this.mF = var1;
      this.mD = var3;
   }

   public String aE() {
      return this.mD;
   }

   public String aF() {
      return this.mG;
   }

   public JSONObject aG() {
      return this.mE;
   }

   public String aH() {
      return this.mF;
   }
}
