package com.parallel6.ui.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.FrameLayout.LayoutParams;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.ui.enums.ScreenOrientation;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import java.util.Timer;
import java.util.TimerTask;

public class CRWebViewFragment extends BaseFragment {
   public static final String TAG = "WebView";
   public static final String URL = "url";
   private CRWebViewFragment.FullscreenChromeClient chromeClient;
   protected String content;
   protected String currentUrl;
   private View mCustomView;
   private CustomViewCallback mCustomViewCallback;
   private ProgressBar progressBar;
   protected String title = "";
   private WebView webView;

   private ProgressBar getProgressBar() {
      if(this.progressBar == null) {
         this.progressBar = (ProgressBar)this.findView(this.getView(), R.id.fragment_webview_pb);
      }

      return this.progressBar;
   }

   private WebView getWebView() {
      if(this.webView == null) {
         this.webView = (WebView)this.findView(this.getView(), R.id.webview_content);
      }

      return this.webView;
   }

   protected String getFragmentTitle() {
      return this.title;
   }

   public ScreenOrientation getScreenOrientation() {
      return ScreenOrientation.BOTH;
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   protected boolean isFitToPage() {
      return true;
   }

   public boolean onBack() {
      if(this.mCustomView != null) {
         if(this.mCustomViewCallback != null) {
            this.mCustomViewCallback.onCustomViewHidden();
         }

         this.chromeClient.onHideCustomView();
         this.mCustomView = null;
      }

      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.currentUrl = this.getArguments().getString("key_url");
      this.title = this.getArguments().getString("extras_title");
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_webview, var2, false);
   }

   public void onDestroy() {
      super.onDestroy();
      long var1 = ViewConfiguration.getZoomControlsTimeout();
      (new Timer()).schedule(new TimerTask() {
         public void run() {
            try {
               CRWebViewFragment.this.getActivity().runOnUiThread(new Runnable() {
                  public void run() {
                     try {
                        if(CRWebViewFragment.this.getWebView() != null) {
                           CRWebViewFragment.this.getWebView().removeAllViews();
                        }

                        if(CRWebViewFragment.this.getWebView() != null) {
                           CRWebViewFragment.this.getWebView().destroy();
                        }

                     } catch (Exception var2) {
                        Log.e("WebView", "Error destroying the webview: " + var2);
                     }
                  }
               });
            } catch (Exception var2) {
               Log.e("WebView", "Error destroying the webview: " + var2);
            }
         }
      }, var1);
   }

   public void onPause() {
      super.onPause();
      this.getWebView().onPause();
   }

   public void onResume() {
      super.onResume();
      this.getWebView().onResume();
      this.getProgressBar().setVisibility(0);
      if(this.currentUrl != null) {
         this.getWebView().loadUrl(this.currentUrl);
      } else if(this.content != null) {
         this.getWebView().loadData(this.content, "text/html", (String)null);
         return;
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString("url", this.currentUrl);
   }

   public void onStop() {
      super.onStop();
      if(this.mCustomView != null) {
         if(this.mCustomViewCallback != null) {
            this.mCustomViewCallback.onCustomViewHidden();
         }

         this.mCustomView = null;
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.chromeClient = new CRWebViewFragment.FullscreenChromeClient(this.getActivity());
      this.getWebView().getSettings().setJavaScriptEnabled(true);
      if(this.isFitToPage()) {
         this.getWebView().getSettings().setLoadWithOverviewMode(true);
         this.getWebView().getSettings().setUseWideViewPort(true);
      }

      this.getWebView().getSettings().setBuiltInZoomControls(true);
      this.getWebView().getSettings().setDisplayZoomControls(false);
      this.getWebView().getSettings().setCacheMode(1);
      if(SettingsUtils.isWebCacheEnabled(this.getActivity()).booleanValue()) {
         if(VERSION.SDK_INT < 18) {
            this.webView.getSettings().setAppCacheMaxSize(5242880L);
         }

         this.webView.getSettings().setAppCachePath(this.getActivity().getCacheDir().getAbsolutePath());
         this.webView.getSettings().setAllowFileAccess(true);
         this.webView.getSettings().setAppCacheEnabled(true);
      }

      this.getWebView().setWebChromeClient(this.chromeClient);
      this.getWebView().setWebViewClient(new CRWebViewFragment.WebClient(null));
      if(this.currentUrl.contains(".pdf")) {
         this.currentUrl = "https://docs.google.com/viewer?url=" + this.currentUrl;
      }

      CaptiveReachConnect.getInstance().trackInsightV2(this.getActivity(), "web", "view", this.currentUrl, this.currentUrl);
   }

   @TargetApi(17)
   public void onViewStateRestored(Bundle var1) {
      super.onViewStateRestored(var1);
      if(var1 != null) {
         this.currentUrl = var1.getString("url");
      }

   }

   protected void processCallBackUrl(String var1) {
      if(this.progressBar != null) {
         this.progressBar.setVisibility(0);
      }

      if(var1.contains("rtsp://")) {
         Intent var4 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         var4.setFlags(1073741824);
         this.startActivity(var4);
      } else if(var1.startsWith("mailto:")) {
         MailTo var3 = MailTo.parse(var1);
         Intent var2 = new Intent("android.intent.action.SEND");
         var2.setType("text/plain");
         var2.putExtra("android.intent.extra.EMAIL", new String[]{var3.getTo()});
         var2.putExtra("android.intent.extra.SUBJECT", var3.getSubject());
         var2.putExtra("android.intent.extra.CC", var3.getCc());
         var2.putExtra("android.intent.extra.TEXT", var3.getBody());
         this.startActivity(var2);
      } else {
         this.currentUrl = var1;
         this.webView.loadUrl(var1);
      }
   }

   public boolean webviewCanGoBack() {
      if(this.webView.canGoBack()) {
         this.webView.goBack();
         return true;
      } else {
         return false;
      }
   }

   public class FullscreenChromeClient extends WebChromeClient {
      private final LayoutParams COVER_SCREEN_PARAMS = new LayoutParams(-1, -1);
      protected Activity mActivity = null;
      private FrameLayout mContentView;
      private FrameLayout mFullscreenContainer;
      private int mOriginalOrientation;

      public FullscreenChromeClient(Activity var2) {
         this.mActivity = var2;
      }

      private void setFullscreen(boolean var1) {
         Window var2 = this.mActivity.getWindow();
         android.view.WindowManager.LayoutParams var3 = var2.getAttributes();
         if(var1) {
            var3.flags |= 1024;
         } else {
            var3.flags &= -1025;
            if(CRWebViewFragment.this.mCustomView != null) {
               CRWebViewFragment.this.mCustomView.setSystemUiVisibility(0);
            } else {
               this.mContentView.setSystemUiVisibility(0);
            }
         }

         var2.setAttributes(var3);
      }

      public void onHideCustomView() {
         if(CRWebViewFragment.this.mCustomView != null) {
            this.setFullscreen(false);
            ((FrameLayout)this.mActivity.getWindow().getDecorView()).removeView(this.mFullscreenContainer);
            this.mFullscreenContainer = null;
            CRWebViewFragment.this.mCustomView = null;
            CRWebViewFragment.this.mCustomViewCallback.onCustomViewHidden();
            this.mActivity.setRequestedOrientation(this.mOriginalOrientation);
         }
      }

      public void onShowCustomView(View var1, CustomViewCallback var2) {
         if(VERSION.SDK_INT >= 14) {
            if(CRWebViewFragment.this.mCustomView != null) {
               var2.onCustomViewHidden();
               return;
            }

            this.mOriginalOrientation = this.mActivity.getRequestedOrientation();
            FrameLayout var3 = (FrameLayout)this.mActivity.getWindow().getDecorView();
            this.mFullscreenContainer = new CRWebViewFragment.FullscreenHolder(this.mActivity);
            this.mFullscreenContainer.addView(var1, this.COVER_SCREEN_PARAMS);
            var3.addView(this.mFullscreenContainer, this.COVER_SCREEN_PARAMS);
            CRWebViewFragment.this.mCustomView = var1;
            this.setFullscreen(true);
            CRWebViewFragment.this.mCustomViewCallback = var2;
         }

         super.onShowCustomView(var1, var2);
      }
   }

   private class FullscreenHolder extends FrameLayout {
      public FullscreenHolder(Context var2) {
         super(var2);
         this.setBackgroundColor(var2.getResources().getColor(17170444));
      }

      public boolean onTouchEvent(@NonNull MotionEvent var1) {
         return true;
      }
   }

   private class WebClient extends WebViewClient {
      private WebClient() {
      }

      // $FF: synthetic method
      WebClient(Object var2) {
         this();
      }

      public void onPageFinished(WebView var1, String var2) {
         super.onPageFinished(var1, var2);
         CRWebViewFragment.this.getProgressBar().setVisibility(8);
      }

      public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
         Log.d("WebView", " url: " + var2);
         CRWebViewFragment.this.processCallBackUrl(var2);
         return true;
      }
   }
}
