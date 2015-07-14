package com.parallel6.captivereachconnectsdk.network.request;

import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.log.LogDeviceInformation;
import com.parallel6.captivereachconnectsdk.log.LogEntry;
import com.parallel6.captivereachconnectsdk.log.LogRequest;
import com.parallel6.captivereachconnectsdk.log.LogRequestInformation;
import com.parallel6.captivereachconnectsdk.log.LogTask;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class NetworkHelper {
   private static final String CONTENT_TYPE = "application/json";
   private static final String TAG = NetworkHelper.class.getSimpleName();
   private static String lastEtag = null;

   private static String convertStreamToString(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   public static NetworkHelper.Result delete(Context var0, String var1, HttpEntity var2) {
      Log.d(TAG, "delete: url = " + var1);
      return execute(var0, new HttpDelete(var1), var2, false);
   }

   private static NetworkHelper.Result execute(Context param0, HttpRequestBase param1, HttpEntity param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   public static NetworkHelper.Result get(Context var0, String var1, String var2) {
      Log.d(TAG, "get: url = " + var1);
      HttpGet var3 = new HttpGet(var1);
      lastEtag = var2;
      return execute(var0, var3, (HttpEntity)null, false);
   }

   public static StringEntity getEntity(JSONObject var0) throws UnsupportedEncodingException {
      StringEntity var1 = new StringEntity(var0.toString(), "UTF-8");
      var1.setContentType("application/json; charset=UTF-8");
      return var1;
   }

   public static NetworkHelper.Result post(Context var0, String var1, HttpEntity var2, boolean var3) {
      return execute(var0, new HttpPost(var1), var2, var3);
   }

   public static NetworkHelper.Result post(Context var0, String var1, JSONObject var2) {
      Log.d(TAG, "post: url = " + var1 + ", postData = " + var2);

      try {
         NetworkHelper.Result var4 = post(var0, var1, getEntity(var2), false);
         return var4;
      } catch (UnsupportedEncodingException var3) {
         return new NetworkHelper.Result(var3);
      }
   }

   public static NetworkHelper.Result put(Context var0, String var1, HttpEntity var2, boolean var3) {
      return execute(var0, new HttpPut(var1), var2, var3);
   }

   public static void safelyCloseHttpClient(HttpClient var0) {
      if(var0 != null) {
         var0.getConnectionManager().shutdown();
      }

   }

   private static void sendErrorLogEntry(Context var0, HttpRequestBase var1, HttpEntity var2, int var3, String var4) throws IOException {
      LogRequest var5 = new LogRequest();
      var5.setDevice_information(new LogDeviceInformation(var0));
      var5.setEntry(new LogEntry());
      var5.getEntry().setTag("Request");
      var5.getEntry().setMessage("Error in request: " + var4);
      var5.setRequest_information(new LogRequestInformation());
      var5.getRequest_information().setMethod(var1.getMethod());
      var5.getRequest_information().setUrl(var1.getURI().toString());
      var5.getRequest_information().setStatus_code(String.valueOf(var3));
      if(var2 != null) {
         var5.getRequest_information().setParams(EntityUtils.toString(var2));
      }

      (new LogTask(var0, var5)).execute(new Void[0]);
   }

   public static class Result {
      private String eTag;
      private Exception error;
      private boolean isCache;
      private boolean isModified = true;
      private String responseJSON;
      private Object responseObject;
      private boolean success;
      private boolean timeout;

      public Result(Exception var1) {
         this.error = var1;
         this.success = false;
      }

      public Result(Exception var1, boolean var2) {
         this.error = var1;
         this.success = false;
         this.timeout = var2;
      }

      public Result(String var1, String var2) {
         this.responseJSON = var1;
         this.success = true;
         this.eTag = var2;
      }

      public String getETag() {
         return this.eTag;
      }

      public Exception getError() {
         return this.error;
      }

      public String getJSONResponse() {
         return this.responseJSON;
      }

      public Object getResponse() {
         return this.responseObject;
      }

      public boolean isCache() {
         return this.isCache;
      }

      public boolean isModified() {
         return this.isModified;
      }

      public boolean isSuccess() {
         return this.success;
      }

      public boolean isTimeout() {
         return this.timeout;
      }

      public void setError(Exception var1) {
         this.error = var1;
         this.success = false;
         this.isCache = false;
      }

      public void setIsCache(boolean var1) {
         this.isCache = var1;
      }

      public void setIsModified(boolean var1) {
         this.isModified = var1;
      }

      public void setResponseObject(Object var1) {
         this.responseObject = var1;
      }

      public String toString() {
         return "{ success: " + this.success + ", response: " + this.responseJSON + ", error: " + this.error + " }";
      }
   }
}
