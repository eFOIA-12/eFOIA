package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.ey;
import java.io.File;

@ey
public final class gm {
   public static void a(Context var0, WebSettings var1) {
      File var2 = var0.getCacheDir();
      if(var2 != null) {
         var1.setAppCachePath(var2.getAbsolutePath());
         var1.setAppCacheMaxSize(0L);
         var1.setAppCacheEnabled(true);
      }

      var1.setDatabasePath(var0.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
      var1.setDatabaseEnabled(true);
      var1.setDomStorageEnabled(true);
      var1.setDisplayZoomControls(false);
      var1.setBuiltInZoomControls(true);
      var1.setSupportZoom(true);
   }

   public static void a(Window var0) {
      var0.setFlags(16777216, 16777216);
   }

   public static void a(WebView var0) {
      var0.onPause();
   }

   public static void b(WebView var0) {
      var0.onResume();
   }

   public static void i(View var0) {
      var0.setLayerType(1, (Paint)null);
   }

   public static void j(View var0) {
      var0.setLayerType(0, (Paint)null);
   }
}
