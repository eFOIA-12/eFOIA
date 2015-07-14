package com.parallel6.ui.surveys.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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

public class MultipleChoiceAdapter extends SurveyAdapter {
   private List answerList;
   private OnClickListener choiceClickListener;
   private List choiceViewList;

   public MultipleChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5) {
      this(var1, var2, var3, var5, (OnQuestionChangedListener)null);
   }

   public MultipleChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6) {
      this(var1, var2, var3, var5, var6, (CRTheme)null);
   }

   public MultipleChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6, CRTheme var7) {
      super(var1, var2, var3, var5, var6, var7);
      this.answerList = new ArrayList();
      this.choiceClickListener = new OnClickListener() {
         public void onClick(View var1) {
            MultipleChoiceAdapter.this.checkChoice(var1);
         }
      };
      this.choiceViewList = new ArrayList();
      this.initForm();
   }

   private void checkChoice(View var1) {
      this.highLightSelection(var1);
   }

   private void highLightSelection(View var1) {
      Choice var2 = (Choice)var1.getTag();
      CheckBox var3 = (CheckBox)var1.findViewById(R.id.row_multiple_choice_chk);
      if(!var3.isChecked()) {
         this.answerList.add(new Answer(var2.getBody(), var2.getId(), this.mQuestionId));
         var3.setChecked(true);
      } else {
         this.removeWithId(var2.getId());
         var3.setChecked(false);
      }
   }

   public void executeQuestionChanged() {
      if(this.questionListener != null) {
         this.questionListener.onQuestionChanged(this.mQuestionId, this.answerList);
      }

   }

   public LinearLayout getRow(Choice var1) {
      int var2 = (int)this.mContext.getResources().getDimension(R.dimen.margin_survey_choice);
      int var3 = (int)this.mContext.getResources().getDimension(R.dimen.height_survey_choice);
      LinearLayout var4 = (LinearLayout)View.inflate(this.mContext, R.layout.row_multiple_choice, (ViewGroup)null);
      LayoutParams var5 = new LayoutParams(-1, var3);
      var5.setMargins(var2, var2, var2, var2);
      var4.setLayoutParams(var5);
      var4.setTag(var1);
      var4.setOnClickListener(this.choiceClickListener);
      ((TextView)var4.findViewById(R.id.row_multiple_choice_tv_title)).setText(var1.getBody());
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

   public void removeWithId(long var1) {
      Iterator var3 = this.answerList.iterator();

      while(var3.hasNext()) {
         if(((Answer)var3.next()).getChoiceId() == var1) {
            var3.remove();
         }
      }

   }

   public void setAnswers(List var1) {
      if(var1.size() > 0) {
         Iterator var2 = this.choiceViewList.iterator();

         while(var2.hasNext()) {
            LinearLayout var3 = (LinearLayout)var2.next();
            Iterator var4 = var1.iterator();

            while(var4.hasNext()) {
               Answer var5 = (Answer)var4.next();
               if(((Choice)var3.getTag()).getId() == var5.getChoiceId()) {
                  this.checkChoice(var3);
               }
            }
         }
      }

   }
}
