package com.androidquery.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Picture;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebView.PictureListener;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;

public class WebImage extends WebViewClient {
   private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
   private static final String PREF_FILE = "WebViewSettings";
   private static String template;
   private int color;
   private boolean control;
   private Object progress;
   private String url;
   private WebView wv;
   private boolean zoom;

   public WebImage(WebView var1, String var2, Object var3, boolean var4, boolean var5, int var6) {
      this.wv = var1;
      this.url = var2;
      this.progress = var3;
      this.zoom = var4;
      this.control = var5;
      this.color = var6;
   }

   private void delaySetup() {
      this.wv.setPictureListener(new PictureListener() {
         public void onNewPicture(WebView var1, Picture var2) {
            WebImage.this.wv.setPictureListener((PictureListener)null);
            WebImage.this.setup();
         }
      });
      this.wv.loadData("<html></html>", "text/html", "utf-8");
      this.wv.setBackgroundColor(this.color);
   }

   private static void disableZoomControl(WebView var0) {
      if(VERSION.SDK_INT >= 11) {
         AQUtility.invokeHandler(var0.getSettings(), "setDisplayZoomControls", false, false, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(false)});
      }
   }

   private void done(WebView var1) {
      if(this.progress != null) {
         var1.setVisibility(0);
         Common.showProgress(this.progress, this.url, false);
      }

      var1.setWebViewClient((WebViewClient)null);
   }

   private static void fixWebviewTip(Context var0) {
      SharedPreferences var1 = var0.getSharedPreferences("WebViewSettings", 0);
      if(var1.getInt("double_tap_toast_count", 1) > 0) {
         var1.edit().putInt("double_tap_toast_count", 0).commit();
      }

   }

   private static String getSource(Context var0) {
      if(template == null) {
         try {
            template = new String(AQUtility.toBytes(var0.getClassLoader().getResourceAsStream("com/androidquery/util/web_image.html")));
         } catch (Exception var1) {
            AQUtility.debug((Throwable)var1);
         }
      }

      return template;
   }

   private void setup() {
      String var1 = getSource(this.wv.getContext()).replace("@src", this.url).replace("@color", Integer.toHexString(this.color));
      this.wv.setWebViewClient(this);
      this.wv.loadDataWithBaseURL((String)null, var1, "text/html", "utf-8", (String)null);
      this.wv.setBackgroundColor(this.color);
   }

   public void load() {
      if(!this.url.equals(this.wv.getTag(1090453505))) {
         this.wv.setTag(1090453505, this.url);
         if(VERSION.SDK_INT <= 10) {
            this.wv.setDrawingCacheEnabled(true);
         }

         fixWebviewTip(this.wv.getContext());
         WebSettings var1 = this.wv.getSettings();
         var1.setSupportZoom(this.zoom);
         var1.setBuiltInZoomControls(this.zoom);
         if(!this.control) {
            disableZoomControl(this.wv);
         }

         var1.setJavaScriptEnabled(true);
         this.wv.setBackgroundColor(this.color);
         if(this.progress != null) {
            Common.showProgress(this.progress, this.url, true);
         }

         if(this.wv.getWidth() > 0) {
            this.setup();
         } else {
            this.delaySetup();
         }
      }
   }

   public void onPageFinished(WebView var1, String var2) {
      this.done(var1);
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      this.done(var1);
   }

   public void onScaleChanged(WebView var1, float var2, float var3) {
   }
}
