package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@ey
public class gx extends gv {
   public gx(gu var1, boolean var2) {
      super(var1, var2);
   }

   protected WebResourceResponse d(Context var1, String var2, String var3) throws IOException {
      HttpURLConnection var7 = (HttpURLConnection)(new URL(var3)).openConnection();

      WebResourceResponse var6;
      try {
         gi.a(var1, var2, true, var7, true);
         var7.addRequestProperty("Cache-Control", "max-stale=3600");
         var7.connect();
         var6 = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(gi.a((Readable)(new InputStreamReader(var7.getInputStream()))).getBytes("UTF-8")));
      } finally {
         var7.disconnect();
      }

      return var6;
   }

   public WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
      try {
         if(!"mraid.js".equalsIgnoreCase((new File(var2)).getName())) {
            return super.shouldInterceptRequest(var1, var2);
         } else if(!(var1 instanceof gu)) {
            gr.W("Tried to intercept request from a WebView that wasn\'t an AdWebView.");
            return super.shouldInterceptRequest(var1, var2);
         } else {
            gu var3 = (gu)var1;
            var3.dD().cg();
            if(var3.ac().oq) {
               gr.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
               return this.d(var3.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
            } else if(var3.dH()) {
               gr.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
               return this.d(var3.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
            } else {
               gr.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
               WebResourceResponse var5 = this.d(var3.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
               return var5;
            }
         }
      } catch (IOException var4) {
         gr.W("Could not fetch MRAID JS. " + var4.getMessage());
         return super.shouldInterceptRequest(var1, var2);
      }
   }
}
