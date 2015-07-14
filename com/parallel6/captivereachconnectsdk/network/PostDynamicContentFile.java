package com.parallel6.captivereachconnectsdk.network;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.helpers.FileUploadHelper;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.models.json.request.CRModelRequest;
import com.parallel6.captivereachconnectsdk.network.GetDynamicContent;
import com.parallel6.captivereachconnectsdk.network.request.CaptiveReachRequest;
import com.parallel6.captivereachconnectsdk.network.request.NetworkHelper;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.http.HttpEntity;

public class PostDynamicContentFile {
   private Context context;
   private final TaskListener localTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(CRModel var1) {
         if(var1.getId() != 0L && PostDynamicContentFile.this.mFileList != null && PostDynamicContentFile.this.mFileList.size() > 0) {
            (PostDynamicContentFile.this.new PutFileTask(PostDynamicContentFile.this.context, PostDynamicContentFile.this.mTaskListener, String.valueOf(var1.getId()))).execute(new Void[0]);
         } else if(PostDynamicContentFile.this.mFileList == null || PostDynamicContentFile.this.mFileList.size() <= 0) {
            PostDynamicContentFile.this.mTaskListener.onTaskSuccess("ok");
            return;
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private List mFileList;
   private String mPermanentLink;
   private TaskListener mTaskListener;
   GetDynamicContent socialSitesTask;

   public PostDynamicContentFile(Context var1, CRModel var2, String var3, List var4, TaskListener var5) {
      this.mFileList = var4;
      this.mTaskListener = var5;
      this.mPermanentLink = var3;
      this.context = var1;
      Type var7 = (new TypeToken() {
      }).getType();
      CRModelRequest var6 = new CRModelRequest();
      var6.setContent(var2);
      this.socialSitesTask = (new DynamicContentTaskBuilder()).withContext(var1).withPermanentLink(var3).withProgressMessage("Uploading content to the server.").withData(var6, CRModelRequest.class).withProgressMessage("Uploading content to the server.").withMethod("POST").withTaskListener(this.localTaskListener).withType(var7).build();
   }

   public void execute() {
      this.socialSitesTask.execute();
   }

   private class PutFileTask extends CaptiveReachRequest {
      private String mContentId;

      public PutFileTask(Context var2, TaskListener var3, String var4) {
         super(var2, "PUT", "Uploading your files to the server.", var3, true);
         this.mContentId = var4;
      }

      protected HttpEntity getHttpEntity() throws IOException {
         try {
            HttpEntity var1 = FileUploadHelper.postFiles(PostDynamicContentFile.this.mFileList);
            return var1;
         } catch (Exception var2) {
            var2.printStackTrace();
            return null;
         }
      }

      protected String getRequestUrl() throws Exception {
         return SettingsUtils.getBaseRestUrl(this.context) + "dynamic/" + PostDynamicContentFile.this.mPermanentLink + "/" + this.mContentId + ".json";
      }

      protected NetworkHelper.Result onNetworkDisabled() {
         return null;
      }

      protected String parseResponse(String var1) throws Exception {
         return ((BaseJSon)(new Gson()).fromJson(var1, BaseJSon.class)).getStatus();
      }
   }
}
