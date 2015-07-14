package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.models.json.request.VerifyAccountRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class VerifyAccountTask extends CaptiveReachRequest {
   private VerifyAccountRequest request = new VerifyAccountRequest();

   public VerifyAccountTask(Context var1, String var2, TaskListener var3, String var4) {
      super(var1, "POST", var2, var3);
      this.request.setVerification_code(var4);
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.request, (Type)VerifyAccountRequest.class));
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "mobile_users/verify";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected String parseResponse(String var1) throws Exception {
      return ((BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class)).getStatus();
   }
}
