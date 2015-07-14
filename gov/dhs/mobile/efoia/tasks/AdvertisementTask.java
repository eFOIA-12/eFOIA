package gov.dhs.mobile.efoia.tasks;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.response.AdvertisementResponse;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;

public class AdvertisementTask extends CaptiveReachRequest {
   public AdvertisementTask(Context var1, TaskListener var2) {
      super(var1, "GET", "Loading...", var2);
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "v2/advertisements";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return new NetworkHelper.Result(new Exception("No connection"));
   }

   protected AdvertisementResponse parseResponse(String var1) throws Exception {
      return (AdvertisementResponse)(new Gson()).fromJson(var1, AdvertisementResponse.class);
   }
}
