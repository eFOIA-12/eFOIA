package com.google.android.gms.internal;

import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Map;

@ey
public class cf implements cd {
   private final cg qa;

   public cf(cg var1) {
      this.qa = var1;
   }

   public void a(gu var1, Map var2) {
      boolean var3 = "1".equals(var2.get("transparentBackground"));
      this.qa.d(var3);
   }
}
