package com.parallel6.captivereachconnectsdk.models.surveys;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.surveys.SurveyItem;

public class Choice extends SurveyItem {
   @SerializedName("body")
   private String body;
   @SerializedName("question_id")
   private long questionId;

   public Choice(long var1, String var3) {
      super(var1, var3);
   }

   public String getBody() {
      return this.body;
   }

   public long getQuestionId() {
      return this.questionId;
   }

   public void setBody(String var1) {
      this.body = var1;
   }

   public void setQuestionId(long var1) {
      this.questionId = var1;
   }
}
