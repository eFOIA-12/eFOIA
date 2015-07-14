package com.parallel6.ui.fragments.base;

import android.os.Bundle;
import android.view.View;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.captivereachconnectsdk.models.json.response.SingleDynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.GetDynamicContent;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.fragments.base.BaseFragment;
import java.lang.reflect.Type;

public abstract class BaseDetailFragment extends BaseFragment {
   protected TaskListener detailTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(SingleDynamicContentResponse var1) {
         if(var1.getContent() != null) {
            BaseDetailFragment.this.mDetailModel = (CRModel)var1.getContent();
            if(BaseDetailFragment.this.getView() != null) {
               BaseDetailFragment.this.onDetailModelInitialized(BaseDetailFragment.this.getView(), BaseDetailFragment.this.mDetailModel);
            }
         }

      }

      public void onTaskTimeOut() {
      }
   };
   protected Integer mDetailId;
   protected CRModel mDetailModel;

   protected GetDynamicContent getModelDetailTask() {
      return (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withPermanentLink("" + this.mDetailId + "/show").withMethod("GET").withTaskListener(this.detailTaskListener).withType(this.getModelType()).build();
   }

   protected abstract Type getModelType();

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments().getParcelable("dynamic_detail") != null) {
         this.mDetailModel = (CRModel)this.getArguments().getParcelable("dynamic_detail");
      }

      if(this.getArguments().getInt("dynamic_detail_id") != 0) {
         this.mDetailId = Integer.valueOf(this.getArguments().getInt("dynamic_detail_id"));
      }

      if(this.mDetailModel == null && this.mDetailId != null) {
         this.getModelDetailTask().execute();
      }

   }

   protected abstract void onDetailModelInitialized(View var1, CRModel var2);

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if(this.mDetailModel != null) {
         this.onDetailModelInitialized(var1, this.mDetailModel);
      }

   }
}
