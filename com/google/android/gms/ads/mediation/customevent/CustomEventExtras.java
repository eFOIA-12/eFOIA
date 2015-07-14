package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
   private final HashMap xy = new HashMap();

   public Object getExtra(String var1) {
      return this.xy.get(var1);
   }

   public void setExtra(String var1, Object var2) {
      this.xy.put(var1, var2);
   }
}
