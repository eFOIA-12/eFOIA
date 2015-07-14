package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GetTokenTask extends CaptiveReachRequest {
   public GetTokenTask(Context var1, TaskListener var2) {
      super(var1, "GET", (String)null, var2);
   }

   protected Map getParams() {
      HashMap var1 = new HashMap();
      var1.put("udid", SettingsUtils.getDeviceId(this.context));
      return var1;
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseUrl(this.context) + "devices/token";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return new NetworkHelper.Result(new Exception("There is no connection. Failed to register device."));
   }

   protected String parseResponse(String var1) throws Exception {
      try {
         JSONObject var3 = new JSONObject(var1);
         return var3.getString("status").equals("ok")?var3.getString("token"):"fail";
      } catch (JSONException var2) {
         Log.e("SixAppeal", "failed to parse token", var2);
         return null;
      }
   }
}
