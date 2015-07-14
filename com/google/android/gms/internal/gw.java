package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;

@ey
public class gw extends WebChromeClient {
   private final gu mo;

   public gw(gu var1) {
      this.mo = var1;
   }

   private static void a(Builder var0, String var1, final JsResult var2) {
      var0.setMessage(var1).setPositiveButton(17039370, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2x) {
            var2.confirm();
         }
      }).setNegativeButton(17039360, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2x) {
            var2.cancel();
         }
      }).setOnCancelListener(new OnCancelListener() {
         public void onCancel(DialogInterface var1) {
            var2.cancel();
         }
      }).create().show();
   }

   private static void a(Context var0, Builder var1, String var2, String var3, final JsPromptResult var4) {
      LinearLayout var5 = new LinearLayout(var0);
      var5.setOrientation(1);
      TextView var6 = new TextView(var0);
      var6.setText(var2);
      final EditText var7 = new EditText(var0);
      var7.setText(var3);
      var5.addView(var6);
      var5.addView(var7);
      var1.setView(var5).setPositiveButton(17039370, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var4.confirm(var7.getText().toString());
         }
      }).setNegativeButton(17039360, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var4.cancel();
         }
      }).setOnCancelListener(new OnCancelListener() {
         public void onCancel(DialogInterface var1) {
            var4.cancel();
         }
      }).create().show();
   }

   private final Context c(WebView var1) {
      Context var4;
      if(!(var1 instanceof gu)) {
         var4 = var1.getContext();
      } else {
         gu var3 = (gu)var1;
         Context var2 = var3.dI();
         var4 = var2;
         if(var2 == null) {
            return var3.getContext();
         }
      }

      return var4;
   }

   protected final void a(View var1, int var2, CustomViewCallback var3) {
      dp var4 = this.mo.dC();
      if(var4 == null) {
         gr.W("Could not get ad overlay when showing custom view.");
         var3.onCustomViewHidden();
      } else {
         var4.a(var1, var3);
         var4.setRequestedOrientation(var2);
      }
   }

   protected boolean a(Context param1, String param2, String param3, String param4, JsResult param5, JsPromptResult param6, boolean param7) {
      // $FF: Couldn't be decompiled
   }

   public final void onCloseWindow(WebView var1) {
      if(!(var1 instanceof gu)) {
         gr.W("Tried to close a WebView that wasn\'t an AdWebView.");
      } else {
         dp var2 = ((gu)var1).dC();
         if(var2 == null) {
            gr.W("Tried to close an AdWebView not associated with an overlay.");
         } else {
            var2.close();
         }
      }
   }

   public final boolean onConsoleMessage(ConsoleMessage var1) {
      String var2 = "JS: " + var1.message() + " (" + var1.sourceId() + ":" + var1.lineNumber() + ")";
      if(var2.contains("Application Cache")) {
         return super.onConsoleMessage(var1);
      } else {
         switch(null.xq[var1.messageLevel().ordinal()]) {
         case 1:
            gr.T(var2);
            break;
         case 2:
            gr.W(var2);
            break;
         case 3:
         case 4:
            gr.U(var2);
            break;
         case 5:
            gr.S(var2);
            break;
         default:
            gr.U(var2);
         }

         return super.onConsoleMessage(var1);
      }
   }

   public final boolean onCreateWindow(WebView var1, boolean var2, boolean var3, Message var4) {
      WebViewTransport var5 = (WebViewTransport)var4.obj;
      var1 = new WebView(var1.getContext());
      var1.setWebViewClient(this.mo.dD());
      var5.setWebView(var1);
      var4.sendToTarget();
      return true;
   }

   public final void onExceededDatabaseQuota(String var1, String var2, long var3, long var5, long var7, QuotaUpdater var9) {
      long var10 = 5242880L - var7;
      if(var10 <= 0L) {
         var9.updateQuota(var3);
      } else {
         if(var3 == 0L) {
            if(var5 > var10 || var5 > 1048576L) {
               var5 = 0L;
            }
         } else if(var5 == 0L) {
            var5 = Math.min(Math.min(131072L, var10) + var3, 1048576L);
         } else {
            var7 = var3;
            if(var5 <= Math.min(1048576L - var3, var10)) {
               var7 = var3 + var5;
            }

            var5 = var7;
         }

         var9.updateQuota(var5);
      }
   }

   public final void onHideCustomView() {
      dp var1 = this.mo.dC();
      if(var1 == null) {
         gr.W("Could not get ad overlay when hiding custom view.");
      } else {
         var1.cf();
      }
   }

   public final boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      return this.a(this.c(var1), var2, var3, (String)null, var4, (JsPromptResult)null, false);
   }

   public final boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
      return this.a(this.c(var1), var2, var3, (String)null, var4, (JsPromptResult)null, false);
   }

   public final boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
      return this.a(this.c(var1), var2, var3, (String)null, var4, (JsPromptResult)null, false);
   }

   public final boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
      return this.a(this.c(var1), var2, var3, var4, (JsResult)null, var5, true);
   }

   public final void onReachedMaxAppCacheSize(long var1, long var3, QuotaUpdater var5) {
      var1 += 131072L;
      if(5242880L - var3 < var1) {
         var5.updateQuota(0L);
      } else {
         var5.updateQuota(var1);
      }
   }

   public final void onShowCustomView(View var1, CustomViewCallback var2) {
      this.a(var1, -1, var2);
   }
}
