package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;

public class GetSMSTask extends CaptiveReachRequest {
   public GetSMSTask(Context var1, String var2, TaskListener var3) {
      super(var1, "GET", var2, var3);
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "mobile_users/send_message";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected String parseResponse(String var1) throws Exception {
      return ((BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class)).getMessage();
   }
}
