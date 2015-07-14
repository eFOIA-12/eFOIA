package com.parallel6.ui.surveys.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.surveys.Answer;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.surveys.adapters.SurveyAdapter;
import com.parallel6.ui.surveys.interfaces.OnQuestionChangedListener;
import java.util.List;

public class InputChoiceAdapter extends SurveyAdapter {
   private static final int MAX_INPUT_LINES = 7;
   private EditText mInputField;
   private String mInputType;

   public InputChoiceAdapter(Context var1, FrameLayout var2, long var3, String var5) {
      this(var1, var2, var3, var5, (OnQuestionChangedListener)null);
   }

   public InputChoiceAdapter(Context var1, FrameLayout var2, long var3, String var5, OnQuestionChangedListener var6) {
      this(var1, var2, var3, var5, var6, (CRTheme)null);
   }

   public InputChoiceAdapter(Context var1, FrameLayout var2, long var3, String var5, OnQuestionChangedListener var6, CRTheme var7) {
      super(var1, var2, var3, (List)null, var6, var7);
      this.mInputType = var5;
      this.initForm();
   }

   public void executeQuestionChanged() {
      if(this.mInputField != null) {
         String var1 = this.mInputField.getText().toString();
         if(this.questionListener != null) {
            this.questionListener.onQuestionChanged(this.mQuestionId, new Answer(var1, this.mQuestionId));
         }
      }

   }

   public void initForm() {
      LinearLayout var1 = (LinearLayout)View.inflate(this.mContext, R.layout.survey_input_choice, (ViewGroup)null);
      this.mInputField = (EditText)var1.findViewById(R.id.survey_input_choice_et_input);
      switch(null.$SwitchMap$com$parallel6$ui$surveys$adapters$InputChoiceAdapter$InputStyle[InputChoiceAdapter.InputStyle.valueOf(this.mInputType.toUpperCase()).ordinal()]) {
      case 1:
         this.mInputField.setLines(7);
         this.mInputField.setSelection(0);
         break;
      case 2:
         this.mInputField.setInputType(1);
         break;
      case 3:
         this.mInputField.setInputType(2);
      }

      this.mQuestionContent.addView(var1);
   }

   public void setAnswers(List var1) {
      if(var1.size() > 0 && this.mInputField != null) {
         this.mInputField.setText(((Answer)var1.get(0)).getValue());
      }

   }

   private static enum InputStyle {
      NUMBER,
      TEXT,
      TEXT_AREA;
   }
}
