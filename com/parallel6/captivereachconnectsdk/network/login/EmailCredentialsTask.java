package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.models.json.request.ForgotCredentialRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class EmailCredentialsTask extends CaptiveReachRequest {
   private String mCredentialEndPoint;
   private ForgotCredentialRequest mCredentialRequest;

   public EmailCredentialsTask(Context var1, ForgotCredentialRequest var2, String var3, TaskListener var4) {
      super(var1, "POST", (String)null, var4);
      this.mCredentialRequest = var2;
      this.mCredentialEndPoint = var3;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.mCredentialRequest, (Type)ForgotCredentialRequest.class));
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "mobile_users/" + this.mCredentialEndPoint;
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected BaseJSon parseResponse(String var1) throws Exception {
      return (BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class);
   }
}
