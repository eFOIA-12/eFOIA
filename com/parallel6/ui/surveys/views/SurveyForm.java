package com.parallel6.ui.surveys.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.enums.QuestionType;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import com.parallel6.captivereachconnectsdk.models.surveys.Answer;
import com.parallel6.captivereachconnectsdk.models.surveys.AnswerRequest;
import com.parallel6.captivereachconnectsdk.models.surveys.Question;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.surveys.adapters.InputChoiceAdapter;
import com.parallel6.ui.surveys.adapters.MultipleChoiceAdapter;
import com.parallel6.ui.surveys.adapters.RankChoiceAdapter;
import com.parallel6.ui.surveys.adapters.SingleChoiceAdapter;
import com.parallel6.ui.surveys.adapters.SurveyAdapter;
import com.parallel6.ui.surveys.interfaces.OnQuestionChangedListener;
import com.parallel6.ui.surveys.network.PostAnswersTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class SurveyForm extends LinearLayout {
   private TaskListener answerSurveyListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
         Toast.makeText(SurveyForm.this.getContext(), "An error has occurred. Please try again!", 0).show();
      }

      public void onTaskSuccess(BaseJSon var1) {
         if(var1.getStatus().contains("ok") && SurveyForm.this.mFormListener != null) {
            SurveyForm.this.mFormListener.onSurveyFinished();
         }

      }

      public void onTaskTimeOut() {
         Toast.makeText(SurveyForm.this.getContext(), "An error has occurred. Please try again!", 0).show();
      }
   };
   private CRTheme appTheme;
   private HashMap mAnswersMap = new HashMap();
   private SurveyAdapter mCurrentQuestionAdapter;
   private int mCurrentQuestionIndex;
   private SurveyForm.SurveyFormListener mFormListener;
   private Button mNextQuestion;
   private Button mPreviousQuestion;
   private FrameLayout mQuestionContent;
   private TextView mQuestionCounter;
   private List mQuestionList;
   private TextView mQuestionPrompt;
   private TextView mQuestionTitle;
   private long mSurveyId;
   private OnQuestionChangedListener questionChangeListener = new OnQuestionChangedListener() {
      public void onQuestionChanged(long var1, Answer var3) {
         ArrayList var4 = new ArrayList();
         var4.add(var3);
         SurveyForm.this.insertAnswers(var1, var4);
      }

      public void onQuestionChanged(long var1, List var3) {
         SurveyForm.this.insertAnswers(var1, var3);
      }
   };

   public SurveyForm(Context var1) {
      super(var1);
   }

   public SurveyForm(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public SurveyForm(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   // $FF: synthetic method
   static int access$108(SurveyForm var0) {
      int var1 = var0.mCurrentQuestionIndex;
      var0.mCurrentQuestionIndex = var1 + 1;
      return var1;
   }

   // $FF: synthetic method
   static int access$110(SurveyForm var0) {
      int var1 = var0.mCurrentQuestionIndex;
      var0.mCurrentQuestionIndex = var1 - 1;
      return var1;
   }

   private void changeToQuestion(int var1, Question var2) {
      this.mQuestionTitle.setText(var2.getBody());
      if(this.mFormListener != null) {
         this.mFormListener.onSurveyQuestionChange();
      }

      if(var1 < this.mQuestionList.size() - 1) {
         this.mNextQuestion.setText("");
         this.mNextQuestion.setBackgroundResource(this.appTheme.getAppDrawables().getSurveyRightArrow());
      } else if(var1 == this.mQuestionList.size() - 1) {
         this.mNextQuestion.setText(this.getContext().getString(R.string.survey_btn_done));
         this.mNextQuestion.setTextSize(14.0F);
      }

      this.mQuestionContent.removeAllViews();
      QuestionType var3;
      if(StringUtils.isNotEmpty(var2.getQuestionTypeString())) {
         var3 = QuestionType.valueOf(var2.getQuestionTypeString().toUpperCase());
      } else {
         var3 = QuestionType.SINGLE_CHOICE;
      }

      this.updateQuestionCounter(var1);
      if(this.mCurrentQuestionAdapter != null) {
         this.mCurrentQuestionAdapter.executeQuestionChanged();
      }

      this.mQuestionPrompt.setText(var2.getInstructions());
      switch(null.$SwitchMap$com$parallel6$captivereachconnectsdk$enums$QuestionType[var3.ordinal()]) {
      case 1:
         this.mCurrentQuestionAdapter = new SingleChoiceAdapter(this.getContext(), this.mQuestionContent, var2.getId(), var2.getChoiceList(), this.questionChangeListener, this.appTheme);
         break;
      case 2:
         this.mCurrentQuestionAdapter = new MultipleChoiceAdapter(this.getContext(), this.mQuestionContent, var2.getId(), var2.getChoiceList(), this.questionChangeListener, this.appTheme);
         break;
      case 3:
         String var4 = var2.getQuestionStyle();
         this.mCurrentQuestionAdapter = new InputChoiceAdapter(this.getContext(), this.mQuestionContent, var2.getId(), var4, this.questionChangeListener, this.appTheme);
         break;
      case 4:
         this.mCurrentQuestionAdapter = new RankChoiceAdapter(this.getContext(), this.mQuestionContent, var2.getId(), var2.getChoiceList(), this.questionChangeListener, this.appTheme);
      }

      if(this.hasAnswers(var2.getId())) {
         this.mCurrentQuestionAdapter.setAnswers(this.getAnswers(var2.getId()));
      }

   }

   private List getAnswers() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.mAnswersMap.entrySet().iterator();

      while(var2.hasNext()) {
         var1.addAll((Collection)((Entry)var2.next()).getValue());
      }

      return var1;
   }

   private List getAnswers(long var1) {
      return (List)this.mAnswersMap.get(Long.valueOf(var1));
   }

   private boolean hasAnswers(long var1) {
      boolean var4 = false;

      boolean var3;
      for(Iterator var5 = this.mAnswersMap.entrySet().iterator(); var5.hasNext(); var4 |= var3) {
         if(((Long)((Entry)var5.next()).getKey()).longValue() == var1) {
            var3 = true;
         } else {
            var3 = false;
         }
      }

      return var4;
   }

   private void sendAnswers() {
      if(this.getAnswers().size() == 0) {
         Toast.makeText(this.getContext(), "There are no answers to save.!", 0).show();
      } else {
         AnswerRequest var1 = new AnswerRequest(this.getAnswers());
         (new PostAnswersTask(this.getContext(), var1, this.mSurveyId, this.answerSurveyListener)).execute(new Void[0]);
      }
   }

   private void updateQuestionCounter(int var1) {
      this.mPreviousQuestion.setVisibility(0);
      this.mNextQuestion.setVisibility(0);
      if(this.mCurrentQuestionIndex == 0) {
         this.mPreviousQuestion.setVisibility(4);
      }

      if(this.mQuestionCounter != null) {
         this.mQuestionCounter.setText(String.format("%d of %d", new Object[]{Integer.valueOf(var1 + 1), Integer.valueOf(this.mQuestionList.size())}));
      }

   }

   public void initForm(long var1, List var3, SurveyForm.SurveyFormListener var4) {
      this.initForm(var1, var3, var4, (CRTheme)null);
   }

   public void initForm(long var1, List var3, SurveyForm.SurveyFormListener var4, CRTheme var5) {
      this.appTheme = var5;
      this.mSurveyId = var1;
      this.mQuestionList = var3;
      this.mCurrentQuestionIndex = 0;
      this.mFormListener = var4;
      this.mQuestionTitle = (TextView)this.findViewById(R.id.survey_form_tv_question);
      this.mQuestionPrompt = (TextView)this.findViewById(R.id.survey_form_tv_question_prompt);
      this.mQuestionCounter = (TextView)this.findViewById(R.id.survey_form_tv_question_counter);
      this.mNextQuestion = (Button)this.findViewById(R.id.survey_form_iv_next_question);
      this.mPreviousQuestion = (Button)this.findViewById(R.id.survey_form_iv_previous_question);
      this.mPreviousQuestion.setBackgroundResource(this.appTheme.getAppDrawables().getSurveyLeftArrow());
      this.mQuestionContent = (FrameLayout)this.findViewById(R.id.survey_form_lyt_container);
      this.mNextQuestion.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(SurveyForm.this.mCurrentQuestionIndex < SurveyForm.this.mQuestionList.size() - 1) {
               SurveyForm.access$108(SurveyForm.this);
               SurveyForm.this.changeToQuestion(SurveyForm.this.mCurrentQuestionIndex, (Question)SurveyForm.this.mQuestionList.get(SurveyForm.this.mCurrentQuestionIndex));
            } else if(SurveyForm.this.mCurrentQuestionIndex == SurveyForm.this.mQuestionList.size() - 1) {
               if(SurveyForm.this.mCurrentQuestionAdapter != null) {
                  SurveyForm.this.mCurrentQuestionAdapter.executeQuestionChanged();
               }

               SurveyForm.this.sendAnswers();
               return;
            }

         }
      });
      this.mPreviousQuestion.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(SurveyForm.this.mCurrentQuestionIndex > 0) {
               SurveyForm.access$110(SurveyForm.this);
            }

            SurveyForm.this.changeToQuestion(SurveyForm.this.mCurrentQuestionIndex, (Question)SurveyForm.this.mQuestionList.get(SurveyForm.this.mCurrentQuestionIndex));
         }
      });
      this.changeToQuestion(0, (Question)this.mQuestionList.get(0));
   }

   public void insertAnswers(long var1, List var3) {
      this.mAnswersMap.put(Long.valueOf(var1), var3);
   }

   public interface SurveyFormListener {
      void onSurveyFinished();

      void onSurveyQuestionChange();
   }
}
