package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.cache.CRSendContentDao;
import com.parallel6.captivereachconnectsdk.cache.CacheUrl;
import com.parallel6.captivereachconnectsdk.models.json.request.DeviceRequest;
import com.parallel6.captivereachconnectsdk.network.PostFavoriteTask;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.DeviceUtils;
import com.parallel6.captivereachconnectsdk.utils.JSonUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class PutDeviceTask extends CaptiveReachRequest {
   private CRSendContentDao send;

   public PutDeviceTask(Context var1) {
      super(var1, "PUT", (String)null, (TaskListener)null);
      this.send = new CRSendContentDao(var1);
   }

   private String getJson() {
      String var1 = JSonUtils.getJSonString(new DeviceRequest(SettingsUtils.getDeviceId(this.context), "android", SettingsUtils.getPushId(this.context), DeviceUtils.getAppVersion(this.context)), DeviceRequest.class);
      Log.v(PutDeviceTask.class.getSimpleName(), var1);
      return var1;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity(this.getJson());
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "devices";
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
      Log.i("Put Device Profile Response", var1);
      return null;
   }
}
