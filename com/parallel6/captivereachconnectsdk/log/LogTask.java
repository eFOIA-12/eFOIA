package com.parallel6.captivereachconnectsdk.log;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.log.LogRequest;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class LogTask extends CaptiveReachRequest {
   private LogRequest logRequest;

   public LogTask(Context var1, LogRequest var2) {
      super(var1, "POST", (String)null, (TaskListener)null);
      this.logRequest = var2;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.logRequest, (Type)LogRequest.class), "UTF-8");
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "log";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected BaseJSon parseResponse(String var1) throws Exception {
      Log.d(LogTask.class.getSimpleName(), var1);
      return (BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class);
   }
}
