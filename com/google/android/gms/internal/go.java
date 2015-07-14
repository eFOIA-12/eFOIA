package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gm;

@ey
public final class go {
   public static void a(Context var0, WebSettings var1) {
      gm.a(var0, var1);
      var1.setMediaPlaybackRequiresUserGesture(false);
   }

   public static String getDefaultUserAgent(Context var0) {
      return WebSettings.getDefaultUserAgent(var0);
   }
}
