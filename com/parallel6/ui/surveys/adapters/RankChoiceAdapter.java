package com.parallel6.ui.surveys.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.surveys.Answer;
import com.parallel6.captivereachconnectsdk.models.surveys.Choice;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.surveys.adapters.SurveyAdapter;
import com.parallel6.ui.surveys.interfaces.OnQuestionChangedListener;
import com.parallel6.ui.surveys.views.RankChoiceView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RankChoiceAdapter extends SurveyAdapter {
   private List answerList;
   private OnClickListener choiceListener;
   private List choiceViewList;
   private int currentIndex;
   private RankChoiceView previousSelected;
   private int rankCounter;

   public RankChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5) {
      this(var1, var2, var3, var5, (OnQuestionChangedListener)null);
   }

   public RankChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6) {
      this(var1, var2, var3, var5, var6, (CRTheme)null);
   }

   public RankChoiceAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6, CRTheme var7) {
      super(var1, var2, var3, var5, var6, var7);
      this.rankCounter = 0;
      this.currentIndex = 0;
      this.answerList = new ArrayList();
      this.choiceViewList = new ArrayList();
      this.choiceListener = new OnClickListener() {
         public void onClick(View var1) {
            boolean var3 = true;
            boolean var2 = true;
            RankChoiceAdapter var4;
            RankChoiceView var5;
            if(RankChoiceAdapter.this.previousSelected == null) {
               RankChoiceAdapter.this.previousSelected = (RankChoiceView)var1;
               var4 = RankChoiceAdapter.this;
               var5 = (RankChoiceView)var1;
               if(((RankChoiceView)var1).isChecked()) {
                  var2 = false;
               }

               var4.switchOption(var5, var2);
            } else if(RankChoiceAdapter.this.previousSelected.getChoice().getId() != ((RankChoiceView)var1).getChoice().getId() && ((RankChoiceView)var1).isChecked()) {
               RankChoiceAdapter.this.previousSelected = null;
               RankChoiceAdapter.this.resetAll();
            } else {
               RankChoiceAdapter.this.previousSelected = (RankChoiceView)var1;
               var4 = RankChoiceAdapter.this;
               var5 = (RankChoiceView)var1;
               if(!((RankChoiceView)var1).isChecked()) {
                  var2 = var3;
               } else {
                  var2 = false;
               }

               var4.switchOption(var5, var2);
            }
         }
      };
      this.initForm();
   }

   private void addAnswer(Choice var1, int var2) {
      this.answerList.add(new Answer(var1.getBody(), var1.getId(), this.mQuestionId, var2));
   }

   private void removeAnswer(Choice var1, int var2) {
      this.removeById(var1.getId());
   }

   private void removeById(long var1) {
      Iterator var3 = this.answerList.iterator();

      while(var3.hasNext()) {
         if(((Answer)var3.next()).getChoiceId() == var1) {
            var3.remove();
         }
      }

   }

   private void resetAll() {
      this.rankCounter = 0;
      Iterator var1 = this.choiceViewList.iterator();

      while(var1.hasNext()) {
         RankChoiceView var2 = (RankChoiceView)var1.next();
         var2.setRank(-1);
         var2.setChecked(false);
         var2.toggle();
      }

   }

   private void switchOption(RankChoiceView var1, boolean var2) {
      int var3;
      if(var2) {
         var3 = this.rankCounter + 1;
         this.rankCounter = var3;
      } else {
         var3 = this.rankCounter - 1;
         this.rankCounter = var3;
      }

      var1.setRank(var3);
      var1.setChecked(var2);
      var1.toggle();
   }

   public void executeQuestionChanged() {
      Iterator var1 = this.choiceViewList.iterator();

      while(var1.hasNext()) {
         RankChoiceView var2 = (RankChoiceView)var1.next();
         if(var2.isChecked()) {
            Choice var3 = var2.getChoice();
            this.answerList.add(new Answer(var3.getBody(), var3.getId(), var3.getQuestionId(), var2.getRank()));
         }
      }

      if(this.questionListener != null) {
         this.questionListener.onQuestionChanged(this.mQuestionId, this.answerList);
      }

   }

   public RankChoiceView getRow(Choice var1) {
      RankChoiceView var2 = (RankChoiceView)View.inflate(this.mContext, R.layout.row_rank_choice, (ViewGroup)null);
      var2.setChoice(var1);
      var2.setOnClickListener(this.choiceListener);
      ((TextView)var2.findViewById(R.id.row_rank_choice_tv_title)).setText(var1.getBody());
      return var2;
   }

   protected void initForm() {
      LinearLayout var1 = new LinearLayout(this.mContext);
      var1.setOrientation(1);
      Iterator var2 = this.mChoiceList.iterator();

      while(var2.hasNext()) {
         RankChoiceView var3 = this.getRow((Choice)var2.next());
         this.choiceViewList.add(var3);
         var1.addView(var3);
      }

      this.mQuestionContent.addView(var1);
   }

   public void setAnswers(List var1) {
      if(var1.size() > 0) {
         Iterator var2 = this.choiceViewList.iterator();

         while(var2.hasNext()) {
            RankChoiceView var3 = (RankChoiceView)var2.next();
            Iterator var4 = var1.iterator();

            while(var4.hasNext()) {
               Answer var5 = (Answer)var4.next();
               if(var3.getChoice().getId() == var5.getChoiceId()) {
                  this.switchOption(var3, true);
               }
            }
         }
      }

   }
}
