package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.cache.CRDynamicContentDao;
import com.parallel6.captivereachconnectsdk.models.DateDeserializer;
import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;
import com.parallel6.captivereachconnectsdk.models.json.request.CRFilterRequest;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import com.parallel6.captivereachconnectsdk.utils.FilterUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class GetDynamicContent extends CaptiveReachRequest {
   private Context context;
   private CRFilterRequest filterRequest;
   private HttpEntity httpEntity;
   private HashMap params;
   private String permanent_link;
   private Type type;

   public GetDynamicContent(DynamicContentTaskBuilder var1) {
      super(var1.getContext(), var1.getRequestMethod(), var1.getProgressMessage(), var1.getTaskListener(), var1.getCachePolicy());
      this.context = var1.getContext();
      this.permanent_link = var1.getPermanentLink();
      this.type = var1.getType();
      this.filterRequest = var1.getFilterRequest();
      this.params = var1.getParams();
      if(this.filterRequest != null) {
         String var3 = (new Gson()).toJson((Object)this.filterRequest, (Type)CRFilterRequest.class);
         Log.d(GetDynamicContent.class.getSimpleName(), "Body request: " + var3);

         try {
            this.httpEntity = new StringEntity(var3, "UTF-8");
         } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
         }
      } else {
         this.httpEntity = var1.getHttpEntity();
      }
   }

   public void execute() {
      this.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
   }

   public String getEtag() {
      String var2 = this.getPermanentLink();
      String var1 = var2;
      if(this.filterRequest != null) {
         var1 = var2;
         if(this.filterRequest.getFilters().size() > 0) {
            var1 = var2 + "/filter";
         }
      }

      var2 = var1;
      if(this.permanent_link.contains("/favorites")) {
         var2 = var1.replace("/favorites", "/filter");
         this.filterRequest = new CRFilterRequest();
         CRFilter var4 = new CRFilter();
         var4.setAttributeName("favorited");
         ArrayList var3 = new ArrayList();
         var3.add("1");
         var4.setFilterValues(var3);
         this.filterRequest.getFilters().add(var4);
      }

      CRDynamicContentDao var5 = new CRDynamicContentDao(this.context);
      if(this.filterRequest != null) {
         var5.setFilters(this.filterRequest.getFilters());
      }

      return var5.getEtag(var2);
   }

   protected HttpEntity getHttpEntity() throws IOException {
      return this.httpEntity;
   }

   protected String getPermanentLink() {
      return "dynamic/" + this.permanent_link.replaceAll("[?=]", "_");
   }

   protected String getRequestUrl() throws Exception {
      String var2 = SettingsUtils.getBaseRestUrl(this.context) + this.permanent_link;
      String var1 = var2;
      if(this.filterRequest != null) {
         var1 = var2 + "/filter";
      }

      var2 = var1;
      if(this.params != null) {
         var2 = var1;
         if(this.params.size() > 0) {
            var2 = var1 + FilterUtils.getRequestParamsString(this.params);
         }
      }

      return var2;
   }

   protected NetworkHelper.Result onNetworkDisabled() {
      // $FF: Couldn't be decompiled
   }

   protected Object parseResponse(String var1) throws Exception {
      return (new GsonBuilder()).registerTypeAdapter(Date.class, new DateDeserializer()).create().fromJson(var1, this.type);
   }
}
