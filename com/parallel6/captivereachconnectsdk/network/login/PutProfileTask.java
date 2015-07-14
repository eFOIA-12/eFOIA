package com.parallel6.captivereachconnectsdk.network.login;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.models.login.Profile;
import com.parallel6.captivereachconnectsdk.network.login.ProfileRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class PutProfileTask extends CaptiveReachRequest {
   private ProfileRequest profileRequest = new ProfileRequest();

   public PutProfileTask(Context var1, String var2, TaskListener var3, Profile var4) {
      super(var1, "PUT", var2, var3);
      this.profileRequest.setProfile(var4);
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.profileRequest, (Type)ProfileRequest.class), "utf-8");
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "profile";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected String parseResponse(String var1) throws Exception {
      return ((BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class)).getStatus();
   }
}
