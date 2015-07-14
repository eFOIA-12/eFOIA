package com.androidquery.service;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import java.util.Locale;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

public class MarketService {
   private static final String BULLET = "•";
   public static final int MAJOR = 2;
   public static final int MINOR = 1;
   public static final int REVISION = 0;
   private static final String SKIP_VERSION = "aqs.skip";
   private static ApplicationInfo ai;
   private static PackageInfo pi;
   private Activity act;
   private AQuery aq;
   private boolean completed;
   private long expire = 720000L;
   private boolean fetch;
   private boolean force;
   private MarketService.Handler handler;
   private int level = 0;
   private String locale;
   private int progress;
   private String rateUrl;
   private String updateUrl;
   private String version;

   public MarketService(Activity var1) {
      this.act = var1;
      this.aq = new AQuery(var1);
      this.handler = new MarketService.Handler(null);
      this.locale = Locale.getDefault().toString();
      this.rateUrl = this.getMarketUrl();
      this.updateUrl = this.rateUrl;
   }

   private Drawable getAppIcon() {
      return this.getApplicationInfo().loadIcon(this.act.getPackageManager());
   }

   private String getAppId() {
      return this.getApplicationInfo().packageName;
   }

   private ApplicationInfo getApplicationInfo() {
      if(ai == null) {
         ai = this.act.getApplicationInfo();
      }

      return ai;
   }

   private String getHost() {
      return "https://androidquery.appspot.com";
   }

   private String getMarketUrl() {
      String var1 = this.getAppId();
      return "market://details?id=" + var1;
   }

   private PackageInfo getPackageInfo() {
      if(pi == null) {
         try {
            pi = this.act.getPackageManager().getPackageInfo(this.getAppId(), 0);
         } catch (NameNotFoundException var2) {
            var2.printStackTrace();
         }
      }

      return pi;
   }

   private String getQueryUrl() {
      String var1 = this.getAppId();
      String var2 = this.getHost() + "/api/market?app=" + var1 + "&locale=" + this.locale + "&version=" + this.getVersion() + "&code=" + this.getVersionCode() + "&aq=" + "0.26.9";
      var1 = var2;
      if(this.force) {
         var1 = var2 + "&force=true";
      }

      return var1;
   }

   private static String getSkipVersion(Context var0) {
      return PreferenceManager.getDefaultSharedPreferences(var0).getString("aqs.skip", (String)null);
   }

   private String getVersion() {
      return this.getPackageInfo().versionName;
   }

   private int getVersionCode() {
      return this.getPackageInfo().versionCode;
   }

   private boolean isActive() {
      return !this.act.isFinishing();
   }

   private static boolean openUrl(Activity var0, String var1) {
      if(var1 == null) {
         return false;
      } else {
         try {
            var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)));
            return true;
         } catch (Exception var2) {
            return false;
         }
      }
   }

   private boolean outdated(String var1, int var2) {
      if(!var1.equals(getSkipVersion(this.act))) {
         String var4 = this.getVersion();
         int var3 = this.getVersionCode();
         if(!var4.equals(var1) && var3 <= var2) {
            return this.requireUpdate(var4, var1, this.level);
         }
      }

      return false;
   }

   private static String patchBody(String var0) {
      return "<small>" + var0 + "</small>";
   }

   private boolean requireUpdate(String param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   private static void setSkipVersion(Context var0, String var1) {
      PreferenceManager.getDefaultSharedPreferences(var0).edit().putString("aqs.skip", var1).commit();
   }

   protected void callback(String var1, JSONObject var2, AjaxStatus var3) {
      if(var2 != null) {
         var1 = var2.optString("version", "0");
         int var4 = var2.optInt("code", 0);
         AQUtility.debug("version", this.getVersion() + "->" + var1 + ":" + this.getVersionCode() + "->" + var4);
         AQUtility.debug("outdated", Boolean.valueOf(this.outdated(var1, var4)));
         if(this.force || this.outdated(var1, var4)) {
            this.showUpdateDialog(var2);
            return;
         }
      }

   }

   public void checkVersion() {
      String var3 = this.getQueryUrl();
      AjaxCallback var2 = new AjaxCallback();
      AjaxCallback var4 = (AjaxCallback)((AjaxCallback)((AjaxCallback)var2.url(var3)).type(JSONObject.class)).handler(this.handler, "marketCb");
      boolean var1;
      if(!this.force) {
         var1 = true;
      } else {
         var1 = false;
      }

      ((AjaxCallback)var4.fileCache(var1)).expire(this.expire);
      ((AQuery)this.aq.progress(this.progress)).ajax(var2);
   }

   public MarketService expire(long var1) {
      this.expire = var1;
      return this;
   }

   public MarketService force(boolean var1) {
      this.force = var1;
      return this;
   }

   public MarketService level(int var1) {
      this.level = var1;
      return this;
   }

   public MarketService locale(String var1) {
      this.locale = var1;
      return this;
   }

   public MarketService progress(int var1) {
      this.progress = var1;
      return this;
   }

   public MarketService rateUrl(String var1) {
      this.rateUrl = var1;
      return this;
   }

   protected void showUpdateDialog(JSONObject var1) {
      if(var1 != null && this.version == null && this.isActive()) {
         JSONObject var6 = var1.optJSONObject("dialog");
         String var3 = var6.optString("update", "Update");
         String var4 = var6.optString("skip", "Skip");
         String var5 = var6.optString("rate", "Rate");
         String var2 = var6.optString("wbody", "");
         String var7 = var6.optString("title", "Update Available");
         AQUtility.debug("wbody", var2);
         this.version = var1.optString("version", (String)null);
         Drawable var8 = this.getAppIcon();
         AlertDialog var9 = (new Builder(this.act)).setIcon(var8).setTitle(var7).setPositiveButton(var5, this.handler).setNeutralButton(var4, this.handler).setNegativeButton(var3, this.handler).create();
         var9.setMessage(Html.fromHtml(patchBody(var2), (ImageGetter)null, this.handler));
         this.aq.show(var9);
      }
   }

   public MarketService updateUrl(String var1) {
      this.updateUrl = var1;
      return this;
   }

   private class Handler implements OnClickListener, TagHandler {
      private Handler() {
      }

      // $FF: synthetic method
      Handler(Object var2) {
         this();
      }

      private void cb(String var1, JSONObject var2, AjaxStatus var3) {
         if(!MarketService.this.completed) {
            MarketService.this.completed = true;
            MarketService.this.progress = 0;
            MarketService.this.callback(var1, var2, var3);
         }

      }

      public void detailCb(String var1, String var2, AjaxStatus var3) {
         if(var2 != null && var2.length() > 1000) {
            var1 = MarketService.this.getQueryUrl();
            AjaxCallback var4 = new AjaxCallback();
            ((AjaxCallback)((AjaxCallback)var4.url(var1)).type(JSONObject.class)).handler(this, "marketCb");
            var4.param("html", var2);
            ((AQuery)MarketService.this.aq.progress(MarketService.this.progress)).ajax(var4);
         }

      }

      public void handleTag(boolean var1, String var2, Editable var3, XMLReader var4) {
         if("li".equals(var2)) {
            if(!var1) {
               var3.append("\n");
               return;
            }

            var3.append("  ");
            var3.append("•");
            var3.append("  ");
         }

      }

      public void marketCb(String var1, JSONObject var2, AjaxStatus var3) {
         if(!MarketService.this.act.isFinishing()) {
            if(var2 == null) {
               this.cb(var1, var2, var3);
               return;
            }

            String var4 = var2.optString("status");
            if(!"1".equals(var4)) {
               if("0".equals(var4)) {
                  var3.invalidate();
                  return;
               }

               this.cb(var1, var2, var3);
               return;
            }

            if(var2.has("dialog")) {
               this.cb(var1, var2, var3);
            }

            if(!MarketService.this.fetch && var2.optBoolean("fetch", false) && var3.getSource() == 1) {
               MarketService.this.fetch = true;
               var1 = var2.optString("marketUrl", (String)null);
               AjaxCallback var5 = new AjaxCallback();
               ((AjaxCallback)((AjaxCallback)var5.url(var1)).type(String.class)).handler(this, "detailCb");
               ((AQuery)MarketService.this.aq.progress(MarketService.this.progress)).ajax(var5);
               return;
            }
         }

      }

      public void onClick(DialogInterface var1, int var2) {
         switch(var2) {
         case -3:
            MarketService.setSkipVersion(MarketService.this.act, MarketService.this.version);
            return;
         case -2:
            MarketService.openUrl(MarketService.this.act, MarketService.this.updateUrl);
            return;
         case -1:
            MarketService.openUrl(MarketService.this.act, MarketService.this.rateUrl);
            return;
         default:
         }
      }
   }
}
