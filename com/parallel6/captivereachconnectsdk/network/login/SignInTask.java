package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelRequest;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelResponse;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class SignInTask extends CaptiveReachRequest {
   private SignInModelRequest signInModelRequest;

   public SignInTask(Context var1, String var2, TaskListener var3, SignInModelRequest var4) {
      super(var1, "POST", var2, var3);
      this.signInModelRequest = var4;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.signInModelRequest, (Type)SignInModelRequest.class));
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "mobile_users/sign_in";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected SignInModelResponse parseResponse(String var1) throws Exception {
      return (SignInModelResponse)(new Gson()).fromJson(var1, SignInModelResponse.class);
   }
}
