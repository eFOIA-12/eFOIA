package com.parallel6.ui.surveys.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.models.json.response.DynamicContentResponse;
import com.parallel6.captivereachconnectsdk.models.surveys.Survey;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.fragments.base.BaseFragment;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.surveys.views.SurveyForm;
import com.parallel6.ui.utils.CRThemeUtils;
import java.util.List;

public class SurveyFragment extends BaseFragment {
   private CRTheme appTheme;
   private SurveyForm.SurveyFormListener formListener = new SurveyForm.SurveyFormListener() {
      public void onSurveyFinished() {
         SurveyFragment.this.showCompletedForm();
      }

      public void onSurveyQuestionChange() {
         SurveyFragment.this.controller.hideKeyboard();
      }
   };
   private boolean instructionsShown;
   private ProgressBar progressBar;
   private List questionList;
   private boolean questionsFetched;
   private TaskListener questionsListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentResponse var1) {
         SurveyFragment.this.progressBar.setVisibility(4);
         SurveyFragment.this.questionsFetched = true;
         SurveyFragment.this.questionList = var1.getContent();
         if(!SurveyFragment.this.instructionsShown) {
            SurveyFragment.this.showInstructionsForm();
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private Survey surveyDetail;
   private ViewGroup viewContainer;

   private void getQuestionsForSurvey(Survey var1) {
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withPath("questions?survey_id=" + var1.getId()).withMethod("GET").withTaskListener(this.questionsListener).withType((new TypeToken() {
      }).getType()).build().execute();
   }

   private void showCompletedForm() {
      if(this.viewContainer != null) {
         this.viewContainer.removeAllViews();
         LinearLayout var1 = (LinearLayout)View.inflate(this.getActivity(), R.layout.survey_completed, (ViewGroup)null);
         ((TextView)var1.findViewById(R.id.survey_completed_tv_instructions)).setText(this.surveyDetail.getCompletion());
         ((Button)var1.findViewById(R.id.survey_completed_btn_complete)).setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               SurveyFragment.this.viewContainer.removeAllViews();
               SurveyFragment.this.controller.handleMessage(-1412628478);
            }
         });
         this.viewContainer.addView(var1);
      }

   }

   private void showSurveyForm() {
      if(this.questionsFetched && this.viewContainer != null) {
         this.viewContainer.removeAllViews();
         CaptiveReachConnect.getInstance().trackInsightV2(this.getActivity(), "surveys", "started", String.valueOf(this.surveyDetail), this.surveyDetail.getTitle());
         SurveyForm var1 = (SurveyForm)View.inflate(this.getActivity(), R.layout.survey_form, (ViewGroup)null);
         var1.initForm(this.surveyDetail.getId(), this.questionList, this.formListener, this.appTheme);
         this.viewContainer.addView(var1);
      }
   }

   public boolean handleMessage(int var1) {
      return false;
   }

   public boolean handleMessage(CRMessage var1) {
      return false;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.appTheme = ((CRMainActivity)this.getActivity()).getCRTheme();
      if(this.getArguments() != null && this.getArguments().getParcelable("survey_param") != null) {
         this.surveyDetail = (Survey)this.getArguments().getParcelable("survey_param");
         this.getQuestionsForSurvey(this.surveyDetail);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.viewContainer = (ViewGroup)var1.inflate(R.layout.survey_form_container, (ViewGroup)null);
      this.progressBar = (ProgressBar)this.viewContainer.findViewById(R.id.survey_form_container_pb_survey);
      this.progressBar.setVisibility(0);
      return this.viewContainer;
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.showInstructionsForm();
   }

   public void showInstructionsForm() {
      if(this.questionsFetched) {
         if(this.viewContainer != null) {
            this.viewContainer.removeAllViews();
            LinearLayout var1 = (LinearLayout)View.inflate(this.getActivity(), R.layout.survey_introduction, (ViewGroup)null);
            TextView var2 = (TextView)var1.findViewById(R.id.survey_introduction_tv_instructions);
            CRThemeUtils.setThemeAttributes(this.getActivity(), var2, this.appTheme, true);
            var2.setText(this.surveyDetail.getIntroduction());
            ((Button)var1.findViewById(R.id.survey_introduction_btn_start)).setOnClickListener(new OnClickListener() {
               public void onClick(View var1) {
                  SurveyFragment.this.showSurveyForm();
               }
            });
            this.viewContainer.addView(var1);
         }

         this.instructionsShown = true;
      }
   }
}
