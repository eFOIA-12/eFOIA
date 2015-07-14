package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.jv;
import java.net.URI;
import java.net.URISyntaxException;

@ey
public class gz extends WebViewClient {
   private final gu mo;
   private final String xr;
   private boolean xs;
   private final fb xt;

   public gz(fb var1, gu var2, String var3) {
      this.xr = this.Z(var3);
      this.xs = false;
      this.mo = var2;
      this.xt = var1;
   }

   private String Z(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         try {
            if(var1.endsWith("/")) {
               String var2 = var1.substring(0, var1.length() - 1);
               return var2;
            }
         } catch (IndexOutOfBoundsException var3) {
            gr.T(var3.getMessage());
            return var1;
         }
      }

      return var1;
   }

   protected boolean Y(String var1) {
      var1 = this.Z(var1);
      if(!TextUtils.isEmpty(var1)) {
         try {
            URI var3 = new URI(var1);
            if("passback".equals(var3.getScheme())) {
               gr.S("Passback received");
               this.xt.cG();
               return true;
            }

            if(!TextUtils.isEmpty(this.xr)) {
               URI var4 = new URI(this.xr);
               var1 = var4.getHost();
               String var2 = var3.getHost();
               String var7 = var4.getPath();
               String var6 = var3.getPath();
               if(jv.equal(var1, var2) && jv.equal(var7, var6)) {
                  gr.S("Passback received");
                  this.xt.cG();
                  return true;
               }
            }
         } catch (URISyntaxException var5) {
            gr.T(var5.getMessage());
            return false;
         }
      }

      return false;
   }

   public void onLoadResource(WebView var1, String var2) {
      gr.S("JavascriptAdWebViewClient::onLoadResource: " + var2);
      if(!this.Y(var2)) {
         this.mo.dD().onLoadResource(this.mo, var2);
      }

   }

   public void onPageFinished(WebView var1, String var2) {
      gr.S("JavascriptAdWebViewClient::onPageFinished: " + var2);
      if(!this.xs) {
         this.xt.cF();
         this.xs = true;
      }

   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      gr.S("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + var2);
      if(this.Y(var2)) {
         gr.S("shouldOverrideUrlLoading: received passback url");
         return true;
      } else {
         return this.mo.dD().shouldOverrideUrlLoading(this.mo, var2);
      }
   }
}
