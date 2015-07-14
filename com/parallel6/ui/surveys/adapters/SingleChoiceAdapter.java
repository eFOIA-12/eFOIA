package com.parallel6.ui.surveys.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.surveys.Answer;
import com.parallel6.captivereachconnectsdk.models.surveys.Choice;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.surveys.adapters.SurveyAdapter;
import com.parallel6.ui.surveys.interfaces.OnQuestionChangedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleChoiceAdapter extends SurveyAdapter {
   private OnClickListener choiceClickListener;
   private List choiceViewList;
   private Answer currentAnswer;
   private View currentSelected;
   private View previousSelected;

   public SingleChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5) {
      this(var1, var2, var3, var5, (OnQuestionChangedListener)null);
   }

   public SingleChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6) {
      super(var1, var2, var3, var5, var6, (CRTheme)null);
      this.currentSelected = null;
      this.previousSelected = null;
      this.currentAnswer = new Answer();
      this.choiceClickListener = new OnClickListener() {
         public void onClick(View var1) {
            SingleChoiceAdapter.this.checkChoice(var1);
         }
      };
      this.choiceViewList = new ArrayList();
   }

   public SingleChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6, CRTheme var7) {
      super(var1, var2, var3, var5, var6, var7);
      this.currentSelected = null;
      this.previousSelected = null;
      this.currentAnswer = new Answer();
      this.choiceClickListener = new OnClickListener() {
         public void onClick(View var1) {
            SingleChoiceAdapter.this.checkChoice(var1);
         }
      };
      this.choiceViewList = new ArrayList();
      this.currentAnswer.setQuestionId(this.mQuestionId);
      this.initForm();
   }

   private void checkChoice(View var1) {
      Choice var2 = (Choice)var1.getTag();
      this.currentAnswer.setValue(var2.getBody());
      this.currentAnswer.setChoiceId(var2.getId());
      if(this.currentSelected == null) {
         this.currentSelected = var1;
      } else {
         this.previousSelected = this.currentSelected;
         this.currentSelected = var1;
      }

      this.highLightSelection();
   }

   private void highLightSelection() {
      if(this.currentSelected != null) {
         ((RadioButton)this.currentSelected.findViewById(R.id.row_single_choice_rbtn)).setChecked(true);
      }

      if(this.previousSelected != null) {
         ((RadioButton)this.previousSelected.findViewById(R.id.row_single_choice_rbtn)).setChecked(false);
      }

   }

   public void executeQuestionChanged() {
      if(this.questionListener != null) {
         this.questionListener.onQuestionChanged(this.mQuestionId, this.currentAnswer);
      }

   }

   public LinearLayout getRow(Choice var1) {
      int var2 = (int)this.mContext.getResources().getDimension(R.dimen.margin_survey_choice);
      int var3 = (int)this.mContext.getResources().getDimension(R.dimen.height_survey_choice);
      LinearLayout var4 = (LinearLayout)View.inflate(this.mContext, R.layout.row_single_choice, (ViewGroup)null);
      LayoutParams var5 = new LayoutParams(-1, var3);
      var5.setMargins(var2, var2, var2, var2);
      var4.setLayoutParams(var5);
      var4.setTag(var1);
      var4.setOnClickListener(this.choiceClickListener);
      ((TextView)var4.findViewById(R.id.row_single_choice_tv_title)).setText(var1.getBody());
      return var4;
   }

   protected void initForm() {
      LinearLayout var1 = new LinearLayout(this.mContext);
      var1.setOrientation(1);
      Iterator var2 = this.mChoiceList.iterator();

      while(var2.hasNext()) {
         LinearLayout var3 = this.getRow((Choice)var2.next());
         this.choiceViewList.add(var3);
         var1.addView(var3);
      }

      this.mQuestionContent.addView(var1);
   }

   public void setAnswers(List var1) {
      if(var1.size() == 1) {
         Iterator var2 = this.choiceViewList.iterator();

         while(var2.hasNext()) {
            LinearLayout var3 = (LinearLayout)var2.next();
            if(((Choice)var3.getTag()).getId() == ((Answer)var1.get(0)).getChoiceId()) {
               this.checkChoice(var3);
               break;
            }
         }
      }

   }
}
