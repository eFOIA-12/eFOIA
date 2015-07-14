package com.parallel6.captivereachconnectsdk.network.request;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.cache.CRDynamicContentDao;
import com.parallel6.captivereachconnectsdk.enums.CRCachePolicy;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import com.parallel6.captivereachconnectsdk.utils.ConnectionUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CaptiveReachRequest extends AsyncTask {
   private static final String TAG = CaptiveReachRequest.class.getSimpleName();
   protected boolean activeNetwork;
   private CRCachePolicy cachePolicy;
   protected Context context;
   private String httpMethod;
   private TaskListener listener;
   protected boolean multipart;
   private ProgressDialog progress;
   private String progressMessage;

   public CaptiveReachRequest(Context var1, String var2, String var3, TaskListener var4) {
      this(var1, var2, var3, var4, false, CRCachePolicy.NONE);
   }

   public CaptiveReachRequest(Context var1, String var2, String var3, TaskListener var4, CRCachePolicy var5) {
      this(var1, var2, var3, var4, false, var5);
   }

   public CaptiveReachRequest(Context var1, String var2, String var3, TaskListener var4, boolean var5) {
      this(var1, var2, var3, var4, var5, CRCachePolicy.NONE);
   }

   public CaptiveReachRequest(Context var1, String var2, String var3, TaskListener var4, boolean var5, CRCachePolicy var6) {
      this.context = var1;
      this.httpMethod = var2;
      this.progressMessage = var3;
      this.listener = var4;
      this.multipart = var5;
      this.cachePolicy = var6;
   }

   private boolean enableCache() {
      return this.activeNetwork && this.cachePolicy != null && this.cachePolicy != CRCachePolicy.NONE && this.cachePolicy != CRCachePolicy.CACHE_FIRST_NOREFRESH;
   }

   private Object internalParseResponse(NetworkHelper.Result var1, boolean var2) throws Exception {
      String var3 = var1.getJSONResponse();

      label17: {
         String var4;
         try {
            var4 = (new JSONObject(var3)).getJSONObject("json").toString();
         } catch (JSONException var5) {
            break label17;
         }

         var3 = var4;
      }

      if(var2) {
         this.saveResponse(var3, var1.getETag());
      }

      return this.parseResponse(var3);
   }

   private void reportCancelled() {
      if(this.listener != null) {
         this.listener.onTaskCancelled();
      }

   }

   private void reportError(Exception var1) {
      if(this.listener != null) {
         this.listener.onTaskFailure(var1);
      }

   }

   private void reportSuccess(Object var1) {
      if(this.listener != null) {
         this.listener.onTaskSuccess(var1);
      }

   }

   private void reportTimeOut() {
      if(this.listener != null) {
         this.listener.onTaskTimeOut();
      }

   }

   private void saveResponse(String var1, String var2) {
      try {
         String var3 = this.getPermanentLink();
         CRDynamicContentDao var4 = new CRDynamicContentDao(this.context);
         var4.insertData(var3, var1, var2);
         Log.v(TAG, "<" + var3 + ">" + "saveResponse: " + var4.getEtag(var3));
      } catch (Exception var5) {
         Log.e(TAG, "Error trying to update the database: " + var5);
      }
   }

   protected NetworkHelper.Result doInBackground(Void... param1) {
      // $FF: Couldn't be decompiled
   }

   protected String getEtag() {
      return "";
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return null;
   }

   protected Map getParams() {
      return new HashMap();
   }

   protected String getPermanentLink() {
      return null;
   }

   protected abstract String getRequestUrl() throws Exception;

   protected void log(String var1) {
      Log.d(this.getClass().getName(), var1);
   }

   protected void logError(String var1, Throwable var2) {
      if(var2 != null) {
         var2.printStackTrace();
         Log.e(this.getClass().getName() + ':' + var1, var2.toString());
      }

   }

   protected void onCancelled(NetworkHelper.Result var1) {
      super.onCancelled(var1);
      this.reportCancelled();
   }

   protected abstract NetworkHelper.Result onNetworkDisabled();

   protected void onPostExecute(NetworkHelper.Result var1) {
      if(this.progress != null) {
         this.progress.dismiss();
      }

      if(var1 == null) {
         this.reportError(new Exception("Could not find any results"));
      } else if(var1.isSuccess()) {
         this.reportSuccess(var1.getResponse());
      } else if(var1.isTimeout()) {
         this.reportTimeOut();
      } else {
         Exception var2 = var1.getError();
         this.logError("onPostExecute: failed to execute http request", var2);
         this.reportError(var2);
      }
   }

   protected void onPreExecute() {
      boolean var1 = false;
      this.log("onPreExecute: entered");
      if(this.progressMessage != null) {
         this.progress = new ProgressDialog(this.context);
         this.progress.setMessage(this.progressMessage);
         this.progress.setIndeterminate(true);
         this.progress.setCancelable(false);
         this.progress.show();
      }

      this.activeNetwork = ConnectionUtils.isNetworkActive(this.context);
      if(SettingsUtils.isCacheEnabled(this.context).booleanValue()) {
         CRDynamicContentDao var3 = new CRDynamicContentDao(this.context);
         boolean var2 = this.activeNetwork;
         if(!var3.isTableExists(this.getPermanentLink()) || SettingsUtils.isCacheRunning(this.context).booleanValue()) {
            var1 = true;
         }

         this.activeNetwork = var1 & var2;
      }

   }

   protected abstract Object parseResponse(String var1) throws Exception;
}
