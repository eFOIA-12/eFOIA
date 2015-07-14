package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.ey;

@ey
public final class ba extends bf.a {
   private final AppEventListener os;

   public ba(AppEventListener var1) {
      this.os = var1;
   }

   public void onAppEvent(String var1, String var2) {
      this.os.onAppEvent(var1, var2);
   }
}
