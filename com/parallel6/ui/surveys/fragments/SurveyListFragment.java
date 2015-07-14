package com.parallel6.ui.surveys.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.fragments.base.BaseListFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.surveys.adapters.SurveyListAdapter;
import java.util.ArrayList;
import java.util.List;

public class SurveyListFragment extends BaseListFragment {
   private ProgressBar progressBar;
   private List surveyList = new ArrayList();
   private TaskListener surveyListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         SurveyListFragment.this.progressBar.setVisibility(4);
         if(var1.getContent().size() > 0) {
            SurveyListFragment.this.surveyList = var1.getContent();
            SurveyListFragment.this.initListView(SurveyListFragment.this.surveyList);
         }

      }

      public void onTaskTimeOut() {
      }
   };

   private void initListView(List var1) {
      this.setListAdapter(new SurveyListAdapter(this.getActivity(), var1));
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public boolean onBack() {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withPath("surveys").withMethod("GET").withTaskListener(this.surveyListener).withType((new TypeToken() {
      }).getType()).build().execute();
   }

   public View onCreateView(@NonNull LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.fragment_survey_list, (ViewGroup)null);
   }

   public void onListItemClick(ListView var1, View var2, int var3, long var4) {
      super.onListItemClick(var1, var2, var3, var4);
      this.controller.handleMessage(new CRMessage(-1412628467, new Object[]{this.surveyList.get(var3)}));
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.progressBar = (ProgressBar)var1.findViewById(R.id.fragment_survey_list_pb);
      this.progressBar.setVisibility(0);
   }
}
