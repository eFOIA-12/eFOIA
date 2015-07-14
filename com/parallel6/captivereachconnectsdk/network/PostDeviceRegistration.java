package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.models.DeviceRegistrationPost;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.JSonUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class PostDeviceRegistration extends CaptiveReachRequest {
   private Context context;

   public PostDeviceRegistration(Context var1, TaskListener var2) {
      super(var1, "POST", (String)null, var2);
      this.context = var1;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      String var1 = JSonUtils.getJSonString(new DeviceRegistrationPost(SettingsUtils.getDeviceId(this.context), SettingsUtils.getPushId(this.context), "android", SettingsUtils.getLat(this.context), SettingsUtils.getLng(this.context)), DeviceRegistrationPost.class);
      Log.v("Post JSON Registration", var1);
      return new StringEntity(var1);
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseUrl(this.context) + "devices/registration";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return new NetworkHelper.Result(new Exception("There is no connection. Failed to register device."));
   }

   protected String parseResponse(String var1) throws Exception {
      Log.d(PostDeviceRegistration.class.getSimpleName(), var1);
      return var1;
   }
}
