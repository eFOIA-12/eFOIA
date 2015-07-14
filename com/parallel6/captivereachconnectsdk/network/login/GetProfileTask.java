package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.request.GetProfileModelRequest;
import com.parallel6.captivereachconnectsdk.models.login.Profile;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;

public class GetProfileTask extends CaptiveReachRequest {
   public GetProfileTask(Context var1, TaskListener var2) {
      super(var1, "GET", (String)null, var2);
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "profile?include_values=false";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected Profile parseResponse(String var1) throws Exception {
      return ((GetProfileModelRequest)(new Gson()).fromJson(var1, GetProfileModelRequest.class)).getProfile();
   }
}
