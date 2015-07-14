package com.parallel6.captivereachconnectsdk.network.request;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri.Builder;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CaptiveReachMultiRequest extends AsyncTask {
   private static final String TAG = CaptiveReachMultiRequest.class.getSimpleName();
   protected Context context;
   private String httpMethod;
   private TaskListener listener;
   protected boolean multipart;
   private ProgressDialog progress;
   private String progressMessage;

   public CaptiveReachMultiRequest(Context var1, String var2, String var3, TaskListener var4) {
      this.context = var1;
      this.httpMethod = var2;
      this.progressMessage = var3;
      this.listener = var4;
   }

   public CaptiveReachMultiRequest(Context var1, String var2, String var3, TaskListener var4, boolean var5) {
      this.context = var1;
      this.httpMethod = var2;
      this.progressMessage = var3;
      this.listener = var4;
      this.multipart = var5;
   }

   private void reportCancelled() {
      if(this.listener != null) {
         this.listener.onTaskCancelled();
      }

   }

   protected Map doInBackground(Void... var1) {
      HashMap var10;
      if(this.context == null) {
         var10 = null;
      } else {
         String[] var5 = this.getRequestUrl();
         if(var5 == null) {
            return null;
         }

         HashMap var3 = new HashMap();
         int var2 = 0;

         while(true) {
            var10 = var3;
            if(var2 >= var5.length) {
               break;
            }

            var10 = var3;
            if(this.isCancelled()) {
               break;
            }

            this.httpMethod = this.getHttpMethod();
            String var6 = var5[var2];
            Builder var7 = new Builder();
            Map var4 = this.getParams();
            if("GET".equals(this.httpMethod)) {
               Object var11 = var4;
               if(var4 == null) {
                  var11 = new HashMap(1);
               }

               Iterator var13 = ((Map)var11).keySet().iterator();

               while(var13.hasNext()) {
                  String var8 = (String)var13.next();
                  var7.appendQueryParameter(var8, (String)((Map)var11).get(var8));
               }
            }

            String var12 = var6 + var7.toString();
            this.log(this.httpMethod + ":" + var12);
            Context var14 = this.context.getApplicationContext();
            if(var14 == null) {
               return null;
            }

            if("GET".equals(this.httpMethod)) {
               var3.put(this.getKeyUrl()[var2], NetworkHelper.get(var14, var12, this.getEtag()));
            } else {
               HttpEntity var15;
               try {
                  var15 = this.getHttpEntity();
               } catch (IOException var9) {
                  var3.clear();
                  var3.put(var12, new NetworkHelper.Result(var9));
                  return var3;
               }

               if("POST".equals(this.httpMethod)) {
                  var3.put(this.getKeyUrl()[var2], NetworkHelper.post(var14, var12, var15, this.multipart));
               } else if("PUT".equals(this.httpMethod)) {
                  var3.put(this.getKeyUrl()[var2], NetworkHelper.put(var14, var12, var15, this.multipart));
               } else {
                  if(!"DELETE".equals(this.httpMethod)) {
                     throw new RuntimeException("HTTP Method not supported! " + this.httpMethod);
                  }

                  var3.put(this.getKeyUrl()[var2], NetworkHelper.delete(var14, var12, var15));
               }
            }

            ++var2;
         }
      }

      return var10;
   }

   protected String getEtag() {
      return "";
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return null;
   }

   protected String getHttpMethod() {
      return this.httpMethod;
   }

   protected abstract String[] getKeyUrl();

   protected Map getParams() {
      return new HashMap();
   }

   protected abstract String[] getRequestUrl();

   protected String internalParseResponse(String var1) throws Exception {
      try {
         String var2 = (new JSONObject(var1)).getJSONObject("json").toString();
         return var2;
      } catch (JSONException var3) {
         return var1;
      }
   }

   protected void log(String var1) {
      Log.d(this.getClass().getName(), var1);
   }

   protected void logError(String var1, Throwable var2) {
      var2.printStackTrace();
      Log.e(this.getClass().getName() + ':' + var1, var2.toString());
   }

   protected void onCancelled(Map var1) {
      super.onCancelled(var1);
      this.reportCancelled();
   }

   protected void onPostExecute(Map var1) {
      if(var1 == null) {
         this.reportError(new Exception("Could not find any results"));
      } else {
         this.log("onPostExecute: entered, result = " + var1.size());
         if(this.progress != null) {
            this.progress.dismiss();
         }

         try {
            this.reportSuccess(this.parseResponse(var1));
         } catch (Exception var2) {
            this.reportError(var2);
            var2.printStackTrace();
         }
      }
   }

   protected void onPreExecute() {
      this.log("onPreExecute: entered");
      if(this.progressMessage != null) {
         this.progress = new ProgressDialog(this.context);
         this.progress.setMessage(this.progressMessage);
         this.progress.setIndeterminate(true);
         this.progress.setCancelable(false);
         this.progress.show();
      }

   }

   protected abstract Object parseResponse(Map var1) throws Exception;

   protected void reportError(Exception var1) {
      if(this.listener != null) {
         this.listener.onTaskFailure(var1);
      }

   }

   protected void reportSuccess(Object var1) {
      if(this.listener != null) {
         this.listener.onTaskSuccess(var1);
      }

   }
}
