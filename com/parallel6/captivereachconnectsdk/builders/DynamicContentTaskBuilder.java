package com.parallel6.captivereachconnectsdk.builders;

import android.content.Context;
import com.google.gson.Gson;
import com.parallel6.captivereachconnectsdk.enums.CRCachePolicy;
import com.parallel6.captivereachconnectsdk.models.filters.CRSort;
import com.parallel6.captivereachconnectsdk.models.json.request.CRFilterRequest;
import com.parallel6.captivereachconnectsdk.network.GetDynamicContent;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class DynamicContentTaskBuilder {
   private CRCachePolicy cachePolicy;
   private Context context;
   private CRFilterRequest filterRequest;
   private HttpEntity httpEntity;
   private HashMap params;
   private String permanentLink;
   private String progressMessage;
   private String requestMethod;
   private TaskListener taskListener;
   private Type type;

   public GetDynamicContent build() {
      return new GetDynamicContent(this);
   }

   public CRCachePolicy getCachePolicy() {
      return this.cachePolicy;
   }

   public Context getContext() {
      return this.context;
   }

   public CRFilterRequest getFilterRequest() {
      return this.filterRequest;
   }

   public HttpEntity getHttpEntity() {
      return this.httpEntity;
   }

   public HashMap getParams() {
      return this.params;
   }

   public String getPermanentLink() {
      return this.permanentLink;
   }

   public String getProgressMessage() {
      return this.progressMessage;
   }

   public String getRequestMethod() {
      return this.requestMethod;
   }

   public TaskListener getTaskListener() {
      return this.taskListener;
   }

   public Type getType() {
      return this.type;
   }

   public void setCachePolicy(CRCachePolicy var1) {
      this.cachePolicy = var1;
   }

   public void setContext(Context var1) {
      this.context = var1;
   }

   public void setFilters(CRFilterRequest var1) {
      this.filterRequest = var1;
   }

   public void setHttpEntity(HttpEntity var1) {
      this.httpEntity = var1;
   }

   public void setParams(HashMap var1) {
      this.params = var1;
   }

   public void setPermanentLink(String var1) {
      this.permanentLink = var1;
   }

   public void setProgressMessage(String var1) {
      this.progressMessage = var1;
   }

   public void setRequestMethod(String var1) {
      this.requestMethod = var1;
   }

   public void setTaskListener(TaskListener var1) {
      this.taskListener = var1;
   }

   public void setType(Type var1) {
      this.type = var1;
   }

   public DynamicContentTaskBuilder withCachePolicy(CRCachePolicy var1) {
      this.cachePolicy = var1;
      return this;
   }

   public DynamicContentTaskBuilder withContext(Context var1) {
      this.context = var1;
      return this;
   }

   public DynamicContentTaskBuilder withData(Object var1, Type var2) {
      try {
         this.httpEntity = new StringEntity((new Gson()).toJson(var1, var2), "UTF-8");
         return this;
      } catch (UnsupportedEncodingException var3) {
         var3.printStackTrace();
         return this;
      }
   }

   public DynamicContentTaskBuilder withData(String var1) {
      try {
         this.httpEntity = new StringEntity(var1, "UTF-8");
         return this;
      } catch (UnsupportedEncodingException var2) {
         var2.printStackTrace();
         return this;
      }
   }

   public DynamicContentTaskBuilder withFilter(Object var1) {
      if(this.filterRequest == null) {
         this.filterRequest = new CRFilterRequest();
      }

      this.filterRequest.getFilters().add(var1);
      return this;
   }

   public DynamicContentTaskBuilder withFilters(List var1) {
      if(this.filterRequest == null) {
         this.filterRequest = new CRFilterRequest();
      }

      this.filterRequest.setFilters(var1);
      return this;
   }

   public DynamicContentTaskBuilder withMethod(String var1) {
      this.requestMethod = var1;
      return this;
   }

   public DynamicContentTaskBuilder withParam(String var1, String var2) {
      if(this.params == null) {
         this.params = new HashMap();
      }

      this.params.put(var1, var2);
      return this;
   }

   public DynamicContentTaskBuilder withParams(HashMap var1) {
      this.params = var1;
      return this;
   }

   public DynamicContentTaskBuilder withPath(String var1) {
      this.permanentLink = var1;
      return this;
   }

   public DynamicContentTaskBuilder withPermanentLink(String var1) {
      this.permanentLink = "dynamic/" + var1;
      return this;
   }

   public DynamicContentTaskBuilder withProgressMessage(String var1) {
      this.progressMessage = var1;
      return this;
   }

   public DynamicContentTaskBuilder withSort(CRSort var1) {
      if(this.filterRequest == null) {
         this.filterRequest = new CRFilterRequest();
      }

      this.filterRequest.getOrder_by().add(var1);
      return this;
   }

   public DynamicContentTaskBuilder withSort(List var1) {
      if(this.filterRequest == null) {
         this.filterRequest = new CRFilterRequest();
      }

      this.filterRequest.setOrder_by(var1);
      return this;
   }

   public DynamicContentTaskBuilder withTaskListener(TaskListener var1) {
      this.taskListener = var1;
      return this;
   }

   public DynamicContentTaskBuilder withType(Type var1) {
      this.type = var1;
      return this;
   }
}
