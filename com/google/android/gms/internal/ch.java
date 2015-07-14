package com.google.android.gms.internal;

import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;

@ey
public class ch implements cd {
   static final Map qb = new HashMap();

   static {
      qb.put("resize", Integer.valueOf(1));
      qb.put("playVideo", Integer.valueOf(2));
      qb.put("storePicture", Integer.valueOf(3));
      qb.put("createCalendarEvent", Integer.valueOf(4));
   }

   public void a(gu var1, Map var2) {
      String var3 = (String)var2.get("a");
      switch(((Integer)qb.get(var3)).intValue()) {
      case 1:
         (new di(var1, var2)).execute();
         return;
      case 2:
      default:
         gr.U("Unknown MRAID command called.");
         return;
      case 3:
         (new dj(var1, var2)).execute();
         return;
      case 4:
         (new dh(var1, var2)).execute();
      }
   }
}
