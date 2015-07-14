package com.google.android.gms.internal;

import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import java.util.Map;

@ey
public final class ca implements cd {
   private final cb pP;

   public ca(cb var1) {
      this.pP = var1;
   }

   public void a(gu var1, Map var2) {
      String var3 = (String)var2.get("name");
      if(var3 == null) {
         gr.W("App event with no name parameter.");
      } else {
         this.pP.onAppEvent(var3, (String)var2.get("info"));
      }
   }
}
