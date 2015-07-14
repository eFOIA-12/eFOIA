package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.models.json.request.ResetCredentialRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class ResetPasswordTask extends CaptiveReachRequest {
   private ResetCredentialRequest mCredentialRequest;

   public ResetPasswordTask(Context var1, ResetCredentialRequest var2, TaskListener var3) {
      super(var1, "PUT", (String)null, var3);
      this.mCredentialRequest = var2;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.mCredentialRequest, (Type)ResetCredentialRequest.class));
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "mobile_users/" + "reset_password";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected BaseJSon parseResponse(String var1) throws Exception {
      return (BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class);
   }
}
