package gov.dhs.mobile.efoia.tasks;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.response.MobileMenuResponse;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;

public class GetSubMenusTask extends CaptiveReachRequest {
   private int id;

   public GetSubMenusTask(Context var1, TaskListener var2, int var3) {
      super(var1, "GET", "Loading...", var2);
      this.id = var3;
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "v2/mobile_menus/" + this.id + "/subcategories";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return new NetworkHelper.Result(new Exception("No connection"));
   }

   protected MobileMenuResponse parseResponse(String var1) throws Exception {
      return (MobileMenuResponse)(new Gson()).fromJson(var1, MobileMenuResponse.class);
   }
}
