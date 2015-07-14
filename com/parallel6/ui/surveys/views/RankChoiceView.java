package com.parallel6.ui.surveys.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.surveys.Choice;

public class RankChoiceView extends LinearLayout implements Checkable {
   private boolean isChecked;
   private Choice mChoice;
   private int mRank;

   public RankChoiceView(Context var1) {
      super(var1);
      this.init();
   }

   public RankChoiceView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init();
   }

   public RankChoiceView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   public Choice getChoice() {
      return this.mChoice;
   }

   public int getRank() {
      return this.mRank;
   }

   public void init() {
      int var1 = (int)this.getContext().getResources().getDimension(R.dimen.margin_survey_choice);
      LayoutParams var2 = new LayoutParams(-1, (int)this.getContext().getResources().getDimension(R.dimen.height_survey_choice));
      var2.setMargins(var1, var1, var1, var1);
      this.setLayoutParams(var2);
   }

   public boolean isChecked() {
      return this.isChecked;
   }

   public void setChecked(boolean var1) {
      this.isChecked = var1;
   }

   public void setChoice(Choice var1) {
      this.mChoice = var1;
   }

   public void setRank(int var1) {
      this.mRank = var1;
   }

   public void toggle() {
      EditText var2 = (EditText)this.findViewById(R.id.row_rank_choice_et);
      String var1;
      if(this.isChecked) {
         var1 = String.format("%d", new Object[]{Integer.valueOf(this.mRank)});
      } else {
         var1 = "";
      }

      var2.setText(var1);
      if(!this.isChecked) {
         this.setRank(-1);
      }

   }
}
