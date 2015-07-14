package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.models.ARTarget;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.JSonUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class PostTargetTask extends CaptiveReachRequest {
   private ARTarget target;

   public PostTargetTask(Context var1, TaskListener var2, ARTarget var3) {
      super(var1, "POST", (String)null, var2);
      this.target = var3;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      String var1 = JSonUtils.getJSonString(this.target, ARTarget.class);
      Log.i("Post JSON Offer", var1);
      return new StringEntity(var1);
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "vuforia_targets";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected String parseResponse(String var1) throws Exception {
      Log.i("RESPONSE", var1);

      try {
         var1 = (new JSONObject(var1)).getString("status");
         return var1;
      } catch (JSONException var2) {
         var2.printStackTrace();
         return "fail";
      }
   }
}
