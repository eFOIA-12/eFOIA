package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelRequest;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelResponse;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.DeviceUtils;
import com.parallel6.captivereachconnectsdk.utils.JSonUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class GuestSignInTask extends CaptiveReachRequest {
   private Context context;

   public GuestSignInTask(Context var1, TaskListener var2) {
      super(var1, "POST", (String)null, var2);
      this.context = var1;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      SignInModelRequest var1 = new SignInModelRequest();
      var1.setDevice(DeviceUtils.getDevice(this.context));
      String var2 = JSonUtils.getJSonString(var1, SignInModelRequest.class);
      Log.v("Post JSON Registration", var2);
      return new StringEntity(var2);
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "mobile_users/sign_in_guest";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected SignInModelResponse parseResponse(String var1) throws Exception {
      return (SignInModelResponse)(new Gson()).fromJson(var1, SignInModelResponse.class);
   }
}
