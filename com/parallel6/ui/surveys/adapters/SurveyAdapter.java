package com.parallel6.ui.surveys.adapters;

import android.content.Context;
import android.view.ViewGroup;
import com.parallel6.ui.models.CRTheme;
import com.parallel6.ui.surveys.interfaces.OnQuestionChangedListener;
import java.util.List;

public abstract class SurveyAdapter {
   protected CRTheme mAppTheme;
   protected List mChoiceList;
   protected Context mContext;
   protected ViewGroup mQuestionContent;
   protected long mQuestionId;
   protected OnQuestionChangedListener questionListener;

   public SurveyAdapter(Context var1, ViewGroup var2, long var3, List var5) {
      this(var1, var2, var3, var5, (OnQuestionChangedListener)null);
   }

   public SurveyAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6) {
      this(var1, var2, var3, var5, var6, (CRTheme)null);
   }

   public SurveyAdapter(Context var1, ViewGroup var2, long var3, List var5, OnQuestionChangedListener var6, CRTheme var7) {
      this.mQuestionContent = var2;
      this.questionListener = var6;
      this.mChoiceList = var5;
      this.mContext = var1;
      this.mQuestionId = var3;
      this.mAppTheme = var7;
   }

   public abstract void executeQuestionChanged();

   public abstract void setAnswers(List var1);

   protected static enum ChoiceToggle {
      Off,
      On;
   }
}
