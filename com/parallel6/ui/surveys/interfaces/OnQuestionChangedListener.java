package com.parallel6.ui.surveys.interfaces;

import com.parallel6.captivereachconnectsdk.models.surveys.Answer;
import java.util.List;

public interface OnQuestionChangedListener {
   void onQuestionChanged(long var1, Answer var3);

   void onQuestionChanged(long var1, List var3);
}
