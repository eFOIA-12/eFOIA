package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.CRLocation;
import com.parallel6.captivereachconnectsdk.models.json.request.LocationRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class PutLocationTask extends CaptiveReachRequest {
   public PutLocationTask(Context var1) {
      super(var1, "POST", (String)null, (TaskListener)null);
   }

   protected HttpEntity getHttpEntity() throws IOException {
      LocationRequest var1 = new LocationRequest();
      CRLocation var2 = new CRLocation();
      var2.setLat(Double.parseDouble(SettingsUtils.getLat(this.context)));
      var2.setLon(Double.parseDouble(SettingsUtils.getLng(this.context)));
      var1.setLocation(var2);
      return new StringEntity((new Gson()).toJson((Object)var1, (Type)LocationRequest.class));
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "devices/update_location";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected String parseResponse(String var1) throws Exception {
      return var1;
   }
}
