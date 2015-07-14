package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelResponse;
import com.parallel6.captivereachconnectsdk.models.json.request.SignUpModelRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class SignUpTask extends CaptiveReachRequest {
   private SignUpModelRequest signUpModelRequest;

   public SignUpTask(Context var1, String var2, TaskListener var3, SignUpModelRequest var4) {
      super(var1, "POST", var2, var3);
      this.signUpModelRequest = var4;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.signUpModelRequest, (Type)SignUpModelRequest.class), "utf-8");
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "mobile_users/sign_up";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected SignInModelResponse parseResponse(String var1) throws Exception {
      return (SignInModelResponse)(new Gson()).fromJson(var1, SignInModelResponse.class);
   }
}
