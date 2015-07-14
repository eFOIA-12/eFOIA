package com.parallel6.ui.surveys.network;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.models.surveys.AnswerRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class PostAnswersTask extends CaptiveReachRequest {
   private AnswerRequest request;
   private long surveyId;

   public PostAnswersTask(Context var1, AnswerRequest var2, long var3, TaskListener var5) {
      super(var1, "POST", (String)null, var5);
      this.request = var2;
      this.surveyId = var3;
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return new StringEntity((new Gson()).toJson((Object)this.request, (Type)AnswerRequest.class));
   }

   protected String getRequestUrl() throws Exception {
      return SettingsUtils.getBaseRestUrl(this.context) + "surveys/" + this.surveyId + "/answer";
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      return null;
   }

   protected BaseJSon parseResponse(String var1) throws Exception {
      return (BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class);
   }
}
