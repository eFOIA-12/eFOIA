package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.cache.CRSendContentDao;
import com.parallel6.captivereachconnectsdk.cache.CacheUrl;
import com.parallel6.captivereachconnectsdk.models.Tracker;
import com.parallel6.captivereachconnectsdk.models.json.request.TrackerRequest;
import com.parallel6.captivereachconnectsdk.network.PostFavoriteTask;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.JSonUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class PostInsightTask extends CaptiveReachRequest {
   private Tracker report;
   private CRSendContentDao send;

   public PostInsightTask(Context var1, Tracker var2) {
      super(var1, "POST", (String)null, (TaskListener)null);
      this.report = var2;
      this.send = new CRSendContentDao(var1);
   }

   private String getJson() {
      TrackerRequest var1 = new TrackerRequest();
      var1.setTracker(this.report);
      String var2 = JSonUtils.getJSonString(var1, TrackerRequest.class);
      Log.v(PostInsightTask.class.getSimpleName(), var2);
      return var2;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity(this.getJson(), "utf-8");
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "v2/insights/track";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      try {
         this.send.insert(new CacheUrl(0, this.getRequestUrl(), this.getJson(), "PUT"));
      } catch (Exception var2) {
         Log.e(PostFavoriteTask.class.getSimpleName(), "Unable to save the request: " + var2);
      }

      return null;
   }

   protected Void parseResponse(String var1) throws Exception {
      Log.i("Insights V2 Response", var1);
      return null;
   }
}
