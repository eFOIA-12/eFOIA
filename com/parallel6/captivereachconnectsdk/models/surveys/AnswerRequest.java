package com.parallel6.captivereachconnectsdk.models.surveys;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AnswerRequest {
   @SerializedName("answers")
   private List answerList;

   public AnswerRequest(List var1) {
      this.answerList = var1;
   }

   public List getAnswerList() {
      return this.answerList;
   }

   public void setAnswerList(List var1) {
      this.answerList = var1;
   }
}
