package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.cache.CRDynamicContentDao;
import com.parallel6.captivereachconnectsdk.cache.CRSendContentDao;
import com.parallel6.captivereachconnectsdk.cache.CacheUrl;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PostFavoriteTask extends CaptiveReachRequest {
   private static final String REST_FAVORITE_REQUEST = "favorites";
   private CRModel crModel;
   private CRDynamicContentDao dao;
   private CRSendContentDao send;

   public PostFavoriteTask(Context var1, TaskListener var2, CRModel var3) {
      super(var1, "POST", (String)null, var2);
      this.crModel = var3;
      this.dao = new CRDynamicContentDao(var1);
      this.send = new CRSendContentDao(var1);
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "favorites" + "?id=" + this.crModel.getId();
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      this.dao.update("dynamic_" + this.crModel.getContent_type() + "_filter_content", (int)this.crModel.getId(), "favorited", Integer.valueOf(1));

      try {
         this.send.insert(new CacheUrl(0, this.getRequestUrl(), (String)null, "POST"));
      } catch (Exception var4) {
         Log.e(PostFavoriteTask.class.getSimpleName(), "Unable to save the request: " + var4);
      }

      JSONObject var1 = new JSONObject();

      try {
         var1.put("status", "OK");
      } catch (JSONException var3) {
         var3.printStackTrace();
      }

      return new NetworkHelper.Result(var1.toString(), this.getEtag());
   }

   protected String parseResponse(String var1) throws Exception {
      return (new JSONObject(var1)).getString("status");
   }
}
